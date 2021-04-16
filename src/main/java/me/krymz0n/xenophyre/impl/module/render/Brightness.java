package me.krymz0n.xenophyre.impl.module.render;

import me.krymz0n.xenophyre.impl.module.Category;
import me.krymz0n.xenophyre.impl.module.Module;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class Brightness extends Module {
    private Minecraft mc = Minecraft.getMinecraft();
    public boolean on;

    public Brightness() {
        super("Brightness", "Brightens up your game", Category.RENDER);
        this.setKey(Keyboard.KEY_NONE);
    }
    public void onEnable() {
        mc.gameSettings.gammaSetting = 1000;
    }
    public void onDisable() {
        mc.gameSettings.gammaSetting = 1;
    }
}
