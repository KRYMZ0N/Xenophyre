package me.krymz0n.xenophyre.impl.module.combat;

import me.krymz0n.xenophyre.impl.module.Category;
import me.krymz0n.xenophyre.impl.module.Module;
import org.lwjgl.input.Keyboard;

public class BedAura extends Module {

    public BedAura() {
        super("Bed Aura", "Auto Places beds in the nether", Category.COMBAT);
        this.setKey(Keyboard.KEY_NONE);
    }
}
