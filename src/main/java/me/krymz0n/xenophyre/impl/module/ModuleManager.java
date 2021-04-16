package me.krymz0n.xenophyre.impl.module;

import me.krymz0n.xenophyre.api.utils.RenderUtil;
import me.krymz0n.xenophyre.impl.module.combat.*;
import me.krymz0n.xenophyre.impl.module.misc.ChatSuffix;
import me.krymz0n.xenophyre.impl.module.misc.DiscordRPC;
import me.krymz0n.xenophyre.impl.module.misc.EZAutoDuper;
import me.krymz0n.xenophyre.impl.module.misc.VileSexDupe;
import me.krymz0n.xenophyre.impl.module.movement.*;
import me.krymz0n.xenophyre.impl.module.player.*;
import me.krymz0n.xenophyre.impl.module.render.*;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderWorldLastEvent;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

    public static ArrayList<Module> modules;

    public ModuleManager() {
        modules = new ArrayList();
        //COMBAT
        modules.add(new AutoEZ());
        modules.add(new BedAura());
        modules.add(new Criticals());
        modules.add(new AutoLog());
        modules.add(new AutoArmor());
        modules.add(new AutoCrystal());
        modules.add(new KillAura());
        //MOVEMENT
        modules.add(new Speed());
        modules.add(new AutoJump());
        modules.add(new Jesus());
        modules.add(new Velocity());
        modules.add(new Sneak());
        //RENDER
        modules.add(new ClickGUI());
        modules.add(new Tracers());
        modules.add(new Xray());
        modules.add(new ESP());
        modules.add(new Brightness());
        //MISC
        modules.add(new VileSexDupe());
        modules.add(new DiscordRPC());
        modules.add(new ChatSuffix());
        modules.add(new EZAutoDuper());
        //PLAYER
        modules.add(new AutoEat());
        modules.add(new AutoFish());
        modules.add(new FastBreak());
        modules.add(new FastUse());
        modules.add( new Scaffold());
        modules.add(new Freecam());
        modules.add(new NoFall());
    }
    public static void onUpdate() {
        modules.stream().filter(Module::isToggled).forEach(Module::onUpdate);
    }

    public static void onRender() {
        modules.stream().filter(Module::isToggled).forEach(Module::onRender);
    }

    public static void onWorldRender(RenderWorldLastEvent event) {
        Minecraft.getMinecraft().mcProfiler.startSection("postman");
        Minecraft.getMinecraft().mcProfiler.startSection("setup");
        RenderUtil.prepare();
        Minecraft.getMinecraft().mcProfiler.endSection();

        modules.stream().filter(module -> module.isToggled()).forEach(module -> {
            Minecraft.getMinecraft().mcProfiler.startSection(module.getName());
            //module.onWorldRender(e);
            Minecraft.getMinecraft().mcProfiler.endSection();
        });

        Minecraft.getMinecraft().mcProfiler.startSection("release");
        RenderUtil.release();
        Minecraft.getMinecraft().mcProfiler.endSection();
        Minecraft.getMinecraft().mcProfiler.endSection();
    }

    public Module getModule(String name) {
        Module mod;
        for (Module m : this.modules) {
            if (m.getName().equalsIgnoreCase(name)){
                return m;
            }
        }
        return null;
    }

    public ArrayList<Module> getModuleList() {

        return modules;
    }

    public static List<Module> getModulesInCategory(Category c) {
        ArrayList<Module> mods = new ArrayList<Module>();
        for (Module m : modules) {
            if (m.getCategory().name().equalsIgnoreCase(c.name())) {
                mods.add(m);
            }
        }
        return mods;
    }
}
