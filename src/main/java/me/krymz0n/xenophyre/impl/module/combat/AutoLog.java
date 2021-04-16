package me.krymz0n.xenophyre.impl.module.combat;

import me.krymz0n.xenophyre.impl.module.Category;
import me.krymz0n.xenophyre.impl.module.Module;
import org.lwjgl.input.Keyboard;

public class AutoLog extends Module {

    public AutoLog() {
        super("Auto Log", "Auto Logs when the player is at low health", Category.COMBAT);
        this.setKey(Keyboard.KEY_NONE);
    }
}
