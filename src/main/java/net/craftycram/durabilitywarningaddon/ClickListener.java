package net.craftycram.durabilitywarningaddon;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class ClickListener {

    @SubscribeEvent
    public void onMouseInputEvent(InputEvent.MouseInputEvent event) {
        /*EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        if (player.getEntityWorld().isRemote) {
            if (player.getCurrentEquippedItem() != null) {
            ItemStack item = player.getCurrentEquippedItem();
            System.out.println(item.getUnlocalizedName());
            if (item.getItemDamage() < Main.warningDurability) {
            //if (item.getItemDamage() < 60) {
            player.playSound("note.pling", 100, 0);
            }
            }
        }*/

    }

}
