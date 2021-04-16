package me.krymz0n.xenophyre.impl.module.movement;

import me.krymz0n.xenophyre.impl.module.Category;
import me.krymz0n.xenophyre.impl.module.Module;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

public class AutoJump extends Module {

    public AutoJump() {
        super("Auto Jump", "Auto Jumps for you!", Category.MOVEMENT);
        this.setKey(Keyboard.KEY_NONE);
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent e) {
        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
    }
    @Override
    public void onDisable() {
        super.onDisable();
        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
    }
}
