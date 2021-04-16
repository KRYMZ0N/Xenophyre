package me.krymz0n.xenophyre.impl.module.player;

import me.krymz0n.xenophyre.impl.module.Category;
import me.krymz0n.xenophyre.impl.module.Module;
import org.lwjgl.input.Keyboard;

public class AutoFish extends Module {

    public AutoFish() {
        super("Auto Fish", "Auto fishes for you", Category.PLAYER);
        this.setKey(Keyboard.KEY_NONE);
    }
}
