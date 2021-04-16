package me.krymz0n.xenophyre.impl.module.player;

import me.krymz0n.xenophyre.impl.module.Category;
import me.krymz0n.xenophyre.impl.module.Module;
import org.lwjgl.input.Keyboard;

public class FastUse extends Module {

    public FastUse() {
        super("FastUse", "Uses things faster", Category.PLAYER);
        this.setKey(Keyboard.KEY_NONE);
    }
}
