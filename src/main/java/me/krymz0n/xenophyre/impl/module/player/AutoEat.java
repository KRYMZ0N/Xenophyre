package me.krymz0n.xenophyre.impl.module.player;

import me.krymz0n.xenophyre.impl.module.Category;
import me.krymz0n.xenophyre.impl.module.Module;
import org.lwjgl.input.Keyboard;

public class AutoEat extends Module {

    public AutoEat() {
        super("Auto Eat", "Eats for you when you get hungry", Category.PLAYER);
        this.setKey(Keyboard.KEY_NONE);
    }
}
