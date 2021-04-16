package me.krymz0n.xenophyre.impl.module.player;

import me.krymz0n.xenophyre.impl.module.Category;
import me.krymz0n.xenophyre.impl.module.Module;
import org.lwjgl.input.Keyboard;

public class NoFall extends Module {

    public NoFall() {
        super("NoFall", "No more damage!", Category.PLAYER);
        this.setKey(Keyboard.KEY_NONE);
    }
}
