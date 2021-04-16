package me.krymz0n.xenophyre.impl.module.render;

import me.krymz0n.xenophyre.impl.module.Category;
import me.krymz0n.xenophyre.impl.module.Module;
import org.lwjgl.input.Keyboard;

public class Xray extends Module {

    public Xray() {
        super("Xray", "Shows ores", Category.RENDER);
        this.setKey(Keyboard.KEY_NONE);
    }
}
