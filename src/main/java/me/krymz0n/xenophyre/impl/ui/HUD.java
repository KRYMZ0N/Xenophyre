package me.krymz0n.xenophyre.impl.ui;

import java.awt.Color;
import java.util.Collections;
import java.util.Comparator;

import me.krymz0n.xenophyre.impl.Main;
import me.krymz0n.xenophyre.impl.module.Module;
import me.krymz0n.xenophyre.impl.module.ModuleManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HUD extends Gui {
	
	private Minecraft mc = Minecraft.getMinecraft();
	
	public static class ModuleComparator implements Comparator<Module> {
		
		@Override
		public int compare(Module arg0, Module arg1) {
			if(Minecraft.getMinecraft().fontRenderer.getStringWidth(arg0.getName()) > Minecraft.getMinecraft().fontRenderer.getStringWidth(arg1.getName())) {
				return -1;
			}
				if(Minecraft.getMinecraft().fontRenderer.getStringWidth(arg0.getName()) > Minecraft.getMinecraft().fontRenderer.getStringWidth(arg1.getName())) {
					return 1;
				}
				return 0;
		  }			
	}
	
	private final ResourceLocation watermark = new ResourceLocation(Main.modid, "textures/watermark.png");

	@SubscribeEvent
	public void renderOverlay(RenderGameOverlayEvent event) {
		
		Collections.sort(ModuleManager.modules, new ModuleComparator());
		ScaledResolution sr = new ScaledResolution(mc);
		FontRenderer fr = mc.fontRenderer;
		
		//client logo
		if(event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			mc.renderEngine.bindTexture(watermark);
			drawScaledCustomSizeModalRect(0, 20, 0, 0, 60, 60, 60, 60, 60, 60);
		}
		
		//client name
		if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
			fr.drawStringWithShadow("Xenophyre" + " " + Main.version, 2, 1, 0x25A5F3);
		}
		if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
			fr.drawStringWithShadow("Coords: (X) " + mc.player.getPosition().getX() + " (Y) " + mc.player.getPosition().getY() + " (Z) " + mc.player.getPosition().getZ(), 2, 10, 0x25A5F3);
		}
		
		//arraylist
		if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
			int y = 2;
			final int[] counter = {1};
			for(Module mod : Main.moduleManager.getModuleList()) {
				if(!mod.getName().equalsIgnoreCase("") && mod.isToggled()) {
					fr.drawStringWithShadow(mod.getName(), sr.getScaledWidth() -fr.getStringWidth(mod.getName()) - 2, y, rainbow(counter[0] * 300));
					y += fr.FONT_HEIGHT;
					counter[0]++;
				}
			}
		}
	}
	public static int rainbow(int delay) {
		double rainbowState = Math.ceil((System.currentTimeMillis() + delay) / 10.0);
		rainbowState %=360;
		return Color.getHSBColor((float) (rainbowState / 360.0f), 1f, 1f).getRGB();
	}
}

