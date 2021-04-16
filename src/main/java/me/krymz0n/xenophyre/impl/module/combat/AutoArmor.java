package me.krymz0n.xenophyre.impl.module.combat;

import me.krymz0n.xenophyre.impl.module.Category;
import me.krymz0n.xenophyre.impl.module.Module;
import org.lwjgl.input.Keyboard;

public class AutoArmor extends Module {

    public AutoArmor() {
        super("Auto Armor", "Auto equips Armor!", Category.COMBAT);
        this.setKey(Keyboard.KEY_NONE);
    }
}
