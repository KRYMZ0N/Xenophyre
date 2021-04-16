package me.krymz0n.xenophyre.impl.module.combat;

import me.krymz0n.xenophyre.impl.module.Category;
import me.krymz0n.xenophyre.impl.module.Module;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class AutoEZ extends Module {

    private Minecraft mc = Minecraft.getMinecraft();

    public AutoEZ() {
        super("Auto EZ", "Auto EZ's when people die", Category.COMBAT);
        this.setKey(Keyboard.KEY_NONE);
    }

    @Override
    public void onEnable() {

    }
}
