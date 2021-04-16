package me.krymz0n.xenophyre.impl.setting.settings;

import me.krymz0n.xenophyre.impl.setting.Setting;

public class KeybindSetting extends Setting {
	private final String name;
	public int code;
	
	public KeybindSetting(int code) {
		super();
		this.name = "Key Bind";
		this.code = code;
	}
	
	public int getkeyCode() {
		return this.code;
	}
	
	public void setKeyCode(int code) {
		this.code = code;
	}

}
