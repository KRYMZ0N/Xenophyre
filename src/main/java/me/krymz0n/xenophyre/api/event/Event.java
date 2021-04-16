package me.krymz0n.xenophyre.api.event;

import me.krymz0n.xenophyre.api.utils.Wrapper;
import me.zero.alpine.type.Cancellable;

public class Event extends Cancellable {
	
	private Era era = Era.PRE;
    private final float partialTicks;

    public Event() {
        partialTicks = Wrapper.getMinecraft().getRenderPartialTicks();
    }
    
    public Event(Era p_Era) {
        partialTicks = Wrapper.getMinecraft().getRenderPartialTicks();
        era = p_Era;
    }

    public Era getEra() {
        return era;
    }

    public float getPartialTicks() {
        return partialTicks;
    }
    
    public enum Era {
        PRE,
        PERI,
        POST
    }
}