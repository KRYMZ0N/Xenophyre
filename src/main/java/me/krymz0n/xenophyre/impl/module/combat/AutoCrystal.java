package me.krymz0n.xenophyre.impl.module.combat;

import me.krymz0n.xenophyre.impl.module.Category;
import me.krymz0n.xenophyre.impl.module.Module;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AutoCrystal extends Module {

    public AutoCrystal() {
        super("Auto Crystal", "Destroys end crystals", Category.COMBAT);
        this.setKey(Keyboard.KEY_NONE);
    }
}
