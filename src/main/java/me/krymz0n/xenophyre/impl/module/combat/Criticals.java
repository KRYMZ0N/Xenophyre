package me.krymz0n.xenophyre.impl.module.combat;

import me.krymz0n.xenophyre.impl.Main;
import me.krymz0n.xenophyre.impl.module.Category;
import me.krymz0n.xenophyre.impl.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import org.lwjgl.input.Keyboard;

public class Criticals extends Module {

    public Criticals() {
        super("Criticals", "Hits crits all the time!", Category.COMBAT);
        this.setKey(Keyboard.KEY_NONE);
    }

    public void onEnable() {
        Main.EVENT_BUS.subscribe(this);
    }

    public void onDisable() {
        Main.EVENT_BUS.unsubscribe(this);
    }

    @EventHandler
    private Listener<AttackEntityEvent> attackEntityEventListener = new Listener<>(event -> {
        if (!mc.player.isInWater() && !mc.player.isInLava()) {
            if (mc.player.onGround) { /* lol Minecraft checks for criticals if you're not on a block so just say you're not */
                mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 0.1f, mc.player.posZ, false));
                mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY, mc.player.posZ, false));
                mc.player.onCriticalHit(event.getTarget());
            }
        }
    });
}
