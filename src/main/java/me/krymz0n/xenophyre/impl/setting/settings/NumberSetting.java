package me.krymz0n.xenophyre.impl.setting.settings;

import me.krymz0n.xenophyre.impl.Main;
import me.krymz0n.xenophyre.impl.module.Module;
import me.krymz0n.xenophyre.impl.setting.Setting;

public class NumberSetting extends Setting {

	private final String name;
	private final Module parent;
	public double value;
	public double minimun;
	public double maximum;
	public double increment;
	
	public NumberSetting(String name, Module parent, double value, double minimun, double maximum, double increment) {
		this.name = name;
	    this.parent = parent;
	    this.value = value;
	    this.minimun = minimun;
	    this.maximum = maximum;
	    this.increment = increment;
	}
	
	public double getValue() {
	    return this.value;
	}
	
	public void setValue(double value) {
	    double precision = 1.0D / this.increment;
	    //this.value = value;
	    this.value = Math.round(Math.max(this.minimun, Math.min(this.maximum, value)) * precision) / precision;
	}
	
	public void increment(boolean positive) {
		setValue(getValue() + (positive?1:-1) * increment);
	}
	
	public double getMinimun() {
		return this.minimun;
	}
	
	public void setMinimun(double minimun) {
	    this.minimun = minimun;
	}
	
	public double getMaximum() {
		return this.maximum;
	}
	
	public void setMaximum(double maximum) {
	    this.maximum = maximum;
	}
	
	public double getIncrement() {
		return this.increment;
	}
	
	public void setIncrement(double increment) {
		this.increment = increment;
	}
	
}
