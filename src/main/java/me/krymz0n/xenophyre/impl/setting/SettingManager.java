package me.krymz0n.xenophyre.impl.setting;
import java.util.ArrayList;

//Your Imports
import me.krymz0n.xenophyre.impl.Main;
import me.krymz0n.xenophyre.impl.module.Module;

/**
 *  Made by HeroCode
 *  it's free to use
 *  but you have to credit him
 *
 *  @author HeroCode
 */
public class SettingManager {

    private ArrayList<Setting> settings;

    public SettingManager(){
        this.settings = new ArrayList<Setting>();
    }

    public void rSetting(Setting in){
        this.settings.add(in);
    }

    public ArrayList<Setting> getSettings(){
        return this.settings;
    }

    public ArrayList<Setting> getSettingsByMod(Module mod){
        ArrayList<Setting> out = new ArrayList<Setting>();
        for(Setting s : getSettings()){
            if(s.getParentMod().equals(mod)){
                out.add(s);
            }
        }
        if(out.isEmpty()){
            return null;
        }
        return out;
    }

    public Setting getSettingByName(String name){
        for(Setting set : getSettings()){
            if(set.getName().equalsIgnoreCase(name)){
                return set;
            }
        }
        System.err.println("[Xenophyre] Error Setting NOT found: '" + name +"'!");
        return null;
    }

}
