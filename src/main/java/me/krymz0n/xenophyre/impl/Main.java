package me.krymz0n.xenophyre.impl;

import me.krymz0n.xenophyre.api.event.EventProcessor;
import me.krymz0n.xenophyre.impl.clickgui.ClickGui;
import me.krymz0n.xenophyre.impl.module.Module;
import me.krymz0n.xenophyre.impl.ui.HUD;
import me.zero.alpine.EventBus;
import me.zero.alpine.EventManager;

import java.awt.Font;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.krymz0n.xenophyre.api.proxy.CommonProxy;
import me.krymz0n.xenophyre.api.utils.font.CustomFontRenderer;
import me.krymz0n.xenophyre.impl.module.ModuleManager;
import me.krymz0n.xenophyre.impl.setting.SettingManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.lwjgl.input.Keyboard;

@Mod(modid = Main.modid, name = Main.name, version = Main.version)
public class Main {
	public static final String modid = "xpc";
	public static final String name = "Xenophyre";
	public static final String version = "0.1.1";
	public static final String acceptedVersions = "[1.12.2]";
	public static final String clientProxyClass = "me.krymz0n.xenophyre.api.proxy.ClientProxy";
	public static final String commonProxyClass = "me.krymz0n.xenophyre.api.proxy.CommonProxy";

	public static final Logger log = LogManager.getLogger("Xenophyre");
	public static final EventBus EVENT_BUS = new EventManager();
	
	public static ModuleManager moduleManager;
	public static SettingManager settingManager;
	public CustomFontRenderer customFontRenderer;
	public EventProcessor eventProcessor;
	public ClickGui clickGui;
	public static HUD hud;
	
	@Instance 
	public static Main instance;
	
	public Main() {

		instance = this;
	}
	
	public static Main getInstance() {

		return instance;
	}
	
	@SidedProxy(clientSide = clientProxyClass, serverSide = commonProxyClass)
	public static CommonProxy proxy;

	@EventHandler
	public void PreInit (FMLPreInitializationEvent event) {
		
	}
	
	@EventHandler
	public void Init (FMLInitializationEvent event) {
		eventProcessor = new EventProcessor();
		eventProcessor.init();
		log.info("Xenophyre Event System Initialized!");
		
		MinecraftForge.EVENT_BUS.register(this);
		log.info("Forge Event System Initialized!");
		
		customFontRenderer = new CustomFontRenderer(new Font("Verdana", Font.PLAIN, 18), true,true);
		log.info("Custom Font Initialized!");
		
		settingManager = new SettingManager();
		log.info("Setting Manager Initialized!");
		
		MinecraftForge.EVENT_BUS.register(new ModuleManager()); // this is necessary for key input to work.
		moduleManager = new ModuleManager();
		log.info("Module Manager Initialized!");

		MinecraftForge.EVENT_BUS.register(new HUD());
		hud = new HUD();
		log.info("HUD Initialized!");

		clickGui = new ClickGui();
		log.info("Click GUI Intialized!");
		
		log.info("Xenophyre Finished Initialization");
		
	}
	
	@EventHandler
	public void PostInit (FMLPostInitializationEvent event) {

	}
	@SubscribeEvent
	public void key(InputEvent.KeyInputEvent e) {
		if (Minecraft.getMinecraft().world == null || Minecraft.getMinecraft().player == null)
			return;
		try {
			if (Keyboard.isCreated()) {
				if (Keyboard.getEventKeyState()) {
					int keyCode = Keyboard.getEventKey();
					if (keyCode <= 0)
						return;
					for (Module m : moduleManager.modules) {
						if (m.getKey() == keyCode && keyCode > 0) {
							m.toggle();
						}
					}
				}
			}
		} catch (Exception q) {q.printStackTrace(); }
	}
}
