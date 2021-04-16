package me.krymz0n.xenophyre.impl.module.render;

import me.krymz0n.xenophyre.impl.module.Category;
import me.krymz0n.xenophyre.impl.module.Module;
import org.lwjgl.input.Keyboard;

public class ESP extends Module {

    public ESP() {
        super("ESP", "Highlights entities", Category.RENDER);
        this.setKey(Keyboard.KEY_NONE);
    }
}
