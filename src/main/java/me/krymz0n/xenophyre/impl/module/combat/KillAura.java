package me.krymz0n.xenophyre.impl.module.combat;

import me.krymz0n.xenophyre.impl.module.Category;
import me.krymz0n.xenophyre.impl.module.Module;
import me.krymz0n.xenophyre.impl.setting.settings.NumberSetting;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class KillAura extends Module {
    public NumberSetting rangeA = new NumberSetting("range", this, 4, 1, 6, 0.5);

    public KillAura() {
        super("Kill Aura", "Punches entities that are nearest", Category.COMBAT);
        this.setKey(Keyboard.KEY_NONE);
    }


    public void onUpdate() {
        if (mc.player == null || mc.player.isDead) return;
        List<Entity> targets = mc.world.loadedEntityList.stream()
                .filter(entity -> entity != mc.player)
                .filter(entity -> mc.player.getDistance(entity) <= 4)
                .filter(entity -> !entity.isDead)
                .filter(entity -> attackCheck(entity))
                .sorted(Comparator.comparing(s -> mc.player.getDistance(s)))
                .collect(Collectors.toList());

        targets.forEach(target -> {
            attack(target);
        });
    }

    public void attack(Entity e) {
        if (mc.player.getCooledAttackStrength(0) >= 1) {
            mc.playerController.attackEntity(mc.player, e);
            mc.player.swingArm(EnumHand.MAIN_HAND);
        }
    }

    private boolean attackCheck(Entity entity) {

        if (entity instanceof EntityPlayer) {
            if (((EntityPlayer) entity).getHealth() > 0) {
                return true;
            }
        }

        if (entity instanceof EntityAnimal) {
            if (entity instanceof EntityTameable) {
                return false;
            } else {
                return true;
            }
        }
        if (entity instanceof EntityMob) {
            return true;
        }
        return false;
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}

