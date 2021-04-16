package me.krymz0n.xenophyre.impl.module.misc;

import me.krymz0n.xenophyre.impl.module.Category;
import me.krymz0n.xenophyre.impl.module.Module;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class VileSexDupe  extends Module {

    private Minecraft mc = Minecraft.getMinecraft();

    public VileSexDupe() {
        super("Vile Sex Dupe!", "says stupid shit in the chat", Category.MISC);
        this.setKey(Keyboard.KEY_NONE);

    }
    @Override
    public void onEnable() {
        if (mc.player != null)
            mc.player.sendChatMessage("I just performed the Vile sex dupe and got Operator status on 16b16t.net!");
        toggle();
    }
}

