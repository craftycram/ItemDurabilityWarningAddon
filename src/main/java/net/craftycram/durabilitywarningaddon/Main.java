package net.craftycram.durabilitywarningaddon;

import net.labymod.api.LabyModAddon;
import net.labymod.settings.elements.BooleanElement;
import net.labymod.core.asm.LabyModTransformer;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.settings.elements.SliderElement;
import net.labymod.utils.Consumer;
import net.labymod.utils.Material;

import java.util.List;

public class Main extends LabyModAddon {

    static int warningDurability;
    static boolean debugMode;

    @Override
    public void onEnable() {
        getApi().registerForgeListener( new ClickListener() );
    }

    @Override
    public void loadConfig() {
        this.warningDurability = getConfig().has("warningDurability") ? getConfig().get("warningDurability").getAsInt() : 50; // <- default value 'true'
        this.debugMode = getConfig().has("debugMode") ? getConfig().get("debugMode").getAsBoolean() : false; // <- default value 'true'
        // System.out.println(this.warningDurability);
        // System.out.println(getConfig().has("warningDurability") ? getConfig().get("warningDurability").getAsInt() : 50);
    }

    @Override
    protected void fillSettings(List<SettingsElement> list) {

        SliderElement scalingSliderElement = new SliderElement("Warning Durability", this, new ControlElement.IconData("icons/durability.png"), "warningDurability",40);
        // Setting the slider's min & max values
        scalingSliderElement.setRange(1, 100);
        // Setting slider steps
        scalingSliderElement.setSteps(100 /  100);
        // Adding change listener
        scalingSliderElement.addCallback(new Consumer<Integer>() {
            @Override
            public void accept(Integer accepted) {
                System.out.println("New slider value: " + accepted);
            }
        });

        BooleanElement debugSwitch = new BooleanElement( "debugMode" /* Display name */, new ControlElement.IconData( Material.LEVER ), new Consumer<Boolean>() {
            @Override
            public void accept( Boolean accepted ) {
                debugMode = accepted;
            }
        } /* Change listener */, false /* current value */ );


        // Adding setting
        list.add(scalingSliderElement);
        list.add(debugSwitch);
    }
}
