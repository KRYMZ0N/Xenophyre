package me.krymz0n.xenophyre.impl.module.misc;

import me.krymz0n.xenophyre.impl.module.Category;
import me.krymz0n.xenophyre.impl.module.Module;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

import java.util.Random;

public class EZAutoDuper extends Module {

    private Minecraft mc = Minecraft.getMinecraft();

    public EZAutoDuper() {
        super("EZ Auto Dupe!", "kekz", Category.MISC);
        this.setKey(Keyboard.KEY_NONE);

    }

    @Override
    public void onEnable() {
        if (mc.player != null)
            mc.player.sendChatMessage("I Just duped " + (new Random().nextInt(30) + 1) + " Shulkers with the power of Xenophyre!");
        toggle();
    }
}
