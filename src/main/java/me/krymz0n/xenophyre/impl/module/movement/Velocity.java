package me.krymz0n.xenophyre.impl.module.movement;

import me.krymz0n.xenophyre.api.event.events.EventPacket;
import me.krymz0n.xenophyre.impl.Main;
import me.krymz0n.xenophyre.impl.module.Category;
import me.krymz0n.xenophyre.impl.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.network.play.server.SPacketExplosion;
import org.lwjgl.input.Keyboard;

public class Velocity extends Module {

    public Velocity() {
        super("Velocity", "No more knock back!", Category.MOVEMENT);
        this.setKey(Keyboard.KEY_Z);
    }

    public void onEnable() {
        Main.EVENT_BUS.subscribe(this);
    }

    public void onDisable() {
        Main.EVENT_BUS.unsubscribe(this);
    }

    @EventHandler
    private final Listener<EventPacket.Receive> receiveListener = new Listener<>(event -> {
        if (event.getPacket() instanceof SPacketEntityVelocity){
            if (((SPacketEntityVelocity) event.getPacket()).getEntityID() == mc.player.getEntityId()) {
                event.cancel();
            }
        }
        if (event.getPacket() instanceof SPacketExplosion){
            event.cancel();
        }
    });
}

