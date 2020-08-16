package net.craftycram.durabilitywarningaddon;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;


import static net.craftycram.durabilitywarningaddon.Main.warningDurability;

public class ClickListener {

    @SubscribeEvent
    public void onMouseInputEvent( InputEvent.MouseInputEvent event ) {
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;

        if (player.getCurrentEquippedItem() != null)
        {
            ItemStack item = player.getCurrentEquippedItem();
            System.out.println(item.getUnlocalizedName());
            if (item.getItemDamage() < warningDurability) {
                player.playSound("note.pling", 100, 0);
            }
        }
    }

}
