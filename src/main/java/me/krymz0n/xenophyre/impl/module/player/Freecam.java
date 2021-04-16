package me.krymz0n.xenophyre.impl.module.player;

import me.krymz0n.xenophyre.impl.module.Category;
import me.krymz0n.xenophyre.impl.module.Module;
import org.lwjgl.input.Keyboard;

public class Freecam extends Module {

    public Freecam() {
        super("Freecam", "Let's you see stuff", Category.PLAYER);
        this.setKey(Keyboard.KEY_NONE);
    }
}
