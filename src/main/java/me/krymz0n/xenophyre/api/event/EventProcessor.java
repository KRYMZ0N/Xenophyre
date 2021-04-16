package me.krymz0n.xenophyre.api.event;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

import net.minecraftforge.client.event.*;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.lwjgl.input.Mouse;

import com.google.common.collect.Maps;

import me.krymz0n.xenophyre.api.event.events.EventPacket;
import me.krymz0n.xenophyre.api.event.events.EventPlayerJoin;
import me.krymz0n.xenophyre.api.event.events.EventPlayerLeave;
import me.krymz0n.xenophyre.impl.Main;
import me.krymz0n.xenophyre.impl.module.ModuleManager;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.server.SPacketPlayerListItem;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class EventProcessor {

	public static EventProcessor instance;
	Minecraft mc = Minecraft.getMinecraft();

	public EventProcessor() {
		instance = this;
	}

	@SubscribeEvent
	public void onTick(TickEvent.ClientTickEvent event) {
		if (mc.player != null) {
			ModuleManager.onUpdate();
		}
	}

	@SubscribeEvent
	public void onWorldRender(RenderWorldLastEvent event) {
		if (event.isCanceled()) {
			return;
		}
		ModuleManager.onWorldRender(event);
	}

	@SubscribeEvent
	public void onRender(RenderGameOverlayEvent.Post event) {
		Main.EVENT_BUS.post(event);
		if(event.getType() == RenderGameOverlayEvent.ElementType.HOTBAR) {
			ModuleManager.onRender();
		}
	}

	@SubscribeEvent
	public void onMouseInput(InputEvent.MouseInputEvent event) {
		if(Mouse.getEventButtonState()) {
			Main.EVENT_BUS.post(event);
		}
	}

	@SubscribeEvent
	public void onRenderScreen(RenderGameOverlayEvent.Text event) {
		Main.EVENT_BUS.post(event);
	}
	
	@SubscribeEvent
    public void onChat(ClientChatEvent event) {
        Main.EVENT_BUS.post(event);
    }

	@SubscribeEvent
	public void onChatReceived(ClientChatReceivedEvent event) {
		Main.EVENT_BUS.post(event);
	}

	@SubscribeEvent
	public void onAttackEntity(AttackEntityEvent event) {
		Main.EVENT_BUS.post(event);
	}

	@SubscribeEvent
	public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
		Main.EVENT_BUS.post(event);
	}

	@SubscribeEvent
	public void onDrawBlockHighlight(DrawBlockHighlightEvent event) {
		Main.EVENT_BUS.post(event);
	}

	@SubscribeEvent
	public void onRenderBlockOverlay(RenderBlockOverlayEvent event) {
		Main.EVENT_BUS.post(event);
	}

	@SubscribeEvent
	public void onLivingDamage(LivingDamageEvent event) {
		Main.EVENT_BUS.post(event);
	}
	@SubscribeEvent
	public void onLivingEntityUseItemFinish(LivingEntityUseItemEvent.Finish event) {
		Main.EVENT_BUS.post(event);
	}

	@SubscribeEvent
	public void onInputUpdate(InputUpdateEvent event) {
		Main.EVENT_BUS.post(event);
	}

	@SubscribeEvent
	public void onLivingDeath(LivingDeathEvent event) {
		Main.EVENT_BUS.post(event);
	}

	@SubscribeEvent
	public void onPlayerPush(PlayerSPPushOutOfBlocksEvent event) {
		Main.EVENT_BUS.post(event);
	}

	@SubscribeEvent
	public void onWorldUnload(WorldEvent.Unload event) {
		Main.EVENT_BUS.post(event);
	}

	@SubscribeEvent
	public void onWorldLoad(WorldEvent.Load event) {
		Main.EVENT_BUS.post(event);
	}

	@EventHandler
	private final Listener<EventPacket.Receive> receiveListener = new Listener<>(event -> {
		if (event.getPacket() instanceof SPacketPlayerListItem) {
			SPacketPlayerListItem packet = (SPacketPlayerListItem) event.getPacket();
			if (packet.getAction() == SPacketPlayerListItem.Action.ADD_PLAYER) {
				for (SPacketPlayerListItem.AddPlayerData playerData : packet.getEntries()) {
					if (playerData.getProfile().getId() != mc.session.getProfile().getId()) {
						new Thread(() -> {
							String name = resolveName(playerData.getProfile().getId().toString());
							if (name != null) {
								if (mc.player != null && mc.player.ticksExisted >= 1000) {
									Main.EVENT_BUS.post(new EventPlayerJoin(name));
								}
							}
						}).start();
					}
				}
			}
			if (packet.getAction() == SPacketPlayerListItem.Action.REMOVE_PLAYER) {
				for (SPacketPlayerListItem.AddPlayerData playerData : packet.getEntries()) {
					if (playerData.getProfile().getId() != mc.session.getProfile().getId()) {
						new Thread(() -> {
							final String name = resolveName(playerData.getProfile().getId().toString());
							if (name != null) {
								if (mc.player != null && mc.player.ticksExisted >= 1000) {
									Main.EVENT_BUS.post(new EventPlayerLeave(name));
								}
							}
						}).start();
					}
				}
			}
		}
	});

	private final Map<String, String> uuidNameCache = Maps.newConcurrentMap();

	public String resolveName(String uuid) {
		uuid = uuid.replace("-", "");
		if (uuidNameCache.containsKey(uuid)) {
			return uuidNameCache.get(uuid);
		}

		final String url = "https://api.mojang.com/user/profiles/" + uuid + "/names";
		try {
			final String nameJson = IOUtils.toString(new URL(url));
			if (nameJson != null && nameJson.length() > 0) {
				final JSONArray jsonArray = (JSONArray) JSONValue.parseWithException(nameJson);
				if (jsonArray != null) {
					final JSONObject latestName = (JSONObject) jsonArray.get(jsonArray.size() - 1);
					if (latestName != null) {
						return latestName.get("name").toString();
					}
				}
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public void init() {
		Main.EVENT_BUS.subscribe(this);
		MinecraftForge.EVENT_BUS.register(this);
	}
}