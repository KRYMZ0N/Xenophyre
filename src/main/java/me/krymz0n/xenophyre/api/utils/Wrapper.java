package me.krymz0n.xenophyre.api.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

//Created by 086 on 11/11/2017.

// taken from postman :D.

public class Wrapper{

	private static FontRenderer fontRenderer;

	public static Minecraft mc = Minecraft.getMinecraft();

	public static Minecraft getMinecraft(){
		return Minecraft.getMinecraft();
	}

	public static EntityPlayerSP getPlayer(){
		return getMinecraft().player;
	}

	public static World getWorld(){
		return getMinecraft().world;
	}

	public static int getKey(String keyname){
		return Keyboard.getKeyIndex(keyname.toUpperCase());
	}

	public static FontRenderer getFontRenderer(){
		return fontRenderer;
	}
}