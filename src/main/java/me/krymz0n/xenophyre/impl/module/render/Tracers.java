package me.krymz0n.xenophyre.impl.module.render;

import me.krymz0n.xenophyre.impl.module.Category;
import me.krymz0n.xenophyre.impl.module.Module;
import org.lwjgl.input.Keyboard;

public class Tracers extends Module {

    public Tracers() {
        super("Tracers", "SHows a tracer to block!", Category.RENDER);
        this.setKey(Keyboard.KEY_NONE);
    }
}
