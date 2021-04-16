package me.krymz0n.xenophyre.api.event.events;

import me.krymz0n.xenophyre.api.event.Event;
import net.minecraft.network.Packet;

public class EventPacket extends Event {

	private final Packet packet;

	public EventPacket(Packet packet) {
		super();
		this.packet = packet;
	}

	public Packet getPacket() {
		return this.packet;
	}

	public static class Receive extends EventPacket {

		public Receive(Packet packet) {
			super(packet);
		}
	}

	public static class Send extends EventPacket {
		public Send(Packet packet) {
			super(packet);
		}
	}

	public static class PostReceive extends EventPacket {
		public PostReceive(Packet packet) {
			super(packet);
		}
	}

	public static class PostSend extends EventPacket {
		public PostSend(Packet packet) {
			super(packet);
		}
	}
}