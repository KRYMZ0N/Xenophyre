package me.krymz0n.xenophyre.impl.module.misc;

import me.krymz0n.xenophyre.api.utils.discord.Discord;
import me.krymz0n.xenophyre.impl.module.Category;
import me.krymz0n.xenophyre.impl.module.Module;
import org.lwjgl.input.Keyboard;

public class DiscordRPC extends Module {

    public DiscordRPC() {
        super("DiscordRPC", "Adds Rich presence for Discord!", Category.MISC);
        this.setKey(Keyboard.KEY_NONE);
    }

    public void onEnable() {
        Discord.startRPC();
    }

    public void onDisable() {
        Discord.stopRPC();
    }
}
