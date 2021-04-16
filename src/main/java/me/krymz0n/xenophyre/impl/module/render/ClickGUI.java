package me.krymz0n.xenophyre.impl.module.render;

import me.krymz0n.xenophyre.impl.Main;
import me.krymz0n.xenophyre.impl.module.Category;
import me.krymz0n.xenophyre.impl.module.Module;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class ClickGUI extends Module {

    private Minecraft mc = Minecraft.getMinecraft();

    public ClickGUI() {
        super("ClickGUI", "Allows you to enable and disable modules", Category.RENDER);
        this.setKey(Keyboard.KEY_Y);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        mc.displayGuiScreen(Main.instance.clickGui);
        this.setToggled(false);
    }
}
