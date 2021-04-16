package me.krymz0n.xenophyre.impl.setting.settings;

import me.krymz0n.xenophyre.impl.Main;
import me.krymz0n.xenophyre.impl.module.Module;
import me.krymz0n.xenophyre.impl.setting.Setting;

public class BooleanSetting extends Setting {
	private final String name;
	private final Module parent;
	public boolean enabled;
	
	public BooleanSetting(String name, Module parent, boolean enabled) {
		this.name = name;
		this.parent = parent;
		this.enabled = enabled;
	}
	
	public boolean isEnabled() {
		return this.enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public void toggled() {
		this.enabled = !this.enabled;
	}

}
