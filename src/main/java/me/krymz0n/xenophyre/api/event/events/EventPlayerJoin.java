package me.krymz0n.xenophyre.api.event.events;

import me.krymz0n.xenophyre.api.event.Event;

public class EventPlayerJoin extends Event {

	private final String name;

	public EventPlayerJoin(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}