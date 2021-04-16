package me.krymz0n.xenophyre.impl.module.movement;

import me.krymz0n.xenophyre.impl.module.Category;
import me.krymz0n.xenophyre.impl.module.Module;
import org.lwjgl.input.Keyboard;

public class Jesus extends Module {

    public Jesus() {
        super("Jesus", "Walks on water!", Category.MOVEMENT);
        this.setKey(Keyboard.KEY_NONE);
    }
}
