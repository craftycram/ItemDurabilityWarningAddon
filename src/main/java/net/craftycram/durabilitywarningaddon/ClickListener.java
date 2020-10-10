package net.craftycram.durabilitywarningaddon;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;


public class ClickListener {

    private boolean delta;

    @SubscribeEvent
    public void onMouseInputEvent(final PlayerInteractEvent event) {
        final EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        player.addChatMessage(new ChatComponentText("event"));
        /*
        final ItemStack item = player.getCurrentEquippedItem();
        if (item == null) { return; }
        if (!item.isItemStackDamageable()) { return; };
        player.addChatMessage(new ChatComponentText((item.getMaxDamage() - item.getItemDamage()) + " - " + delta + " " + Main.warningDurability));
        player.addChatMessage(new ChatComponentText(event.getPhase() + ""));
        if (Minecraft.getMinecraft().mouseHelper.deltaX == 0 && Minecraft.getMinecraft().mouseHelper.deltaY == 0 || delta) {
            delta = true;
            if (item.getMaxDamage() - item.getItemDamage() < Main.warningDurability) {
                player.playSound("note.pling", 100, 0);
            }
        }
        */
        // delta = Minecraft.getMinecraft().mouseHelper.deltaX == 0 && Minecraft.getMinecraft().mouseHelper.deltaY == 0;
    }

}
