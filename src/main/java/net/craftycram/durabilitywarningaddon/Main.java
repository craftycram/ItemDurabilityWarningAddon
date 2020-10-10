package net.craftycram.durabilitywarningaddon;

import net.labymod.api.LabyModAddon;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.settings.elements.SliderElement;
import net.labymod.utils.Consumer;
import net.labymod.utils.Material;

import java.util.List;

public class Main extends LabyModAddon {

    static int warningDurability;

    @Override
    public void onEnable() {
        getApi().registerForgeListener( new ClickListener() );
    }

    @Override
    public void loadConfig() {
        this.warningDurability = getConfig().has("warningDurability") ? getConfig().get("warningDurability").getAsInt() : 50; // <- default value 'true'
    }

    @Override
    protected void fillSettings(List<SettingsElement> list) {

        SliderElement scalingSliderElement = new SliderElement("Warning Durability", this, new ControlElement.IconData("icons/durability.png"), "warningDurability",40);

        // Setting the slider's min & max values
        scalingSliderElement.setRange(10, 100);

        // Setting slider steps
        scalingSliderElement.setSteps(100 /  100);

        // Adding change listener
        scalingSliderElement.addCallback(new Consumer<Integer>() {
            @Override
            public void accept(Integer accepted) {
                System.out.println("New slider value: " + accepted);
            }
        });

        // Adding setting
        list.add(scalingSliderElement);
    }
}
