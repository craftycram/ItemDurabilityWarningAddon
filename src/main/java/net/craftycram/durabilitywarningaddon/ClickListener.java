package net.craftycram.durabilitywarningaddon;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;


public class ClickListener {

    @SubscribeEvent
    public void onMouseInputEvent(InputEvent.MouseInputEvent event) {
        System.out.println(Minecraft.class);
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        System.out.println(player);
        //if (player.getEntityWorld().isRemote) {
            if (player.getCurrentEquippedItem() != null) {
            ItemStack item = player.getCurrentEquippedItem();
            if (Minecraft.getMinecraft().mouseHelper.deltaX == 0 && Minecraft.getMinecraft().mouseHelper.deltaY == 0) {
                if (item.getMaxDamage() - item.getItemDamage() > Main.warningDurability) {
                    player.playSound("note.pling", 100, 0);
                }
            }

            }
        //}*/

    }

}
