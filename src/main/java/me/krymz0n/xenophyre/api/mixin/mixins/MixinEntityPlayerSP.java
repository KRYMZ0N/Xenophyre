package me.krymz0n.xenophyre.api.mixin.mixins;

import me.krymz0n.xenophyre.impl.Main;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.krymz0n.xenophyre.api.event.events.EventPlayerUpdate;

@Mixin(EntityPlayerSP.class)
public abstract class MixinEntityPlayerSP extends AbstractClientPlayer {

	public MixinEntityPlayerSP() {
		super(null, null);
	}
	   
	   @Inject(method = "onUpdate", at = @At("HEAD"), cancellable = true)
	    public void onUpdate(CallbackInfo info) {
	        EventPlayerUpdate event = new EventPlayerUpdate();
	        Main.EVENT_BUS.post(event);
	        if (event.isCancelled())
	            info.cancel();
	    }
}
