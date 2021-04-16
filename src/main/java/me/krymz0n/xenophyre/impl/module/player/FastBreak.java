package me.krymz0n.xenophyre.impl.module.player;

import me.krymz0n.xenophyre.impl.module.Category;
import me.krymz0n.xenophyre.impl.module.Module;
import org.lwjgl.input.Keyboard;

public class FastBreak extends Module {

    public FastBreak() {
        super("Fast Break", "Break blocks faster!", Category.PLAYER);
        this.setKey(Keyboard.KEY_NONE);
    }
}
