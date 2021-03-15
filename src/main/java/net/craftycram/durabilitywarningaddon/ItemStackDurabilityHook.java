package net.craftycram.durabilitywarningaddon;

import net.minecraft.item.ItemStack;

public class ItemStackDurabilityHook {

    public static void notify(ItemStack itemStack) {
        System.out.println("Update damage on " + itemStack.toString() + " " + itemStack.getItemDamage());
    }
}
