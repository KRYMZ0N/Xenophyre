package me.krymz0n.xenophyre.impl.module.player;

import me.krymz0n.xenophyre.impl.module.Category;
import me.krymz0n.xenophyre.impl.module.Module;
import org.lwjgl.input.Keyboard;

public class Scaffold extends Module {

    public Scaffold() {
        super("Scaffold", "places blocks under you while you walk!", Category.PLAYER);
        this.setKey(Keyboard.KEY_NONE);
    }
}
