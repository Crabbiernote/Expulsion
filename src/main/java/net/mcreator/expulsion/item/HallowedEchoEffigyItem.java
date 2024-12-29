package net.mcreator.expulsion.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Rarity;

public class HallowedEchoEffigyItem extends Item {
    public HallowedEchoEffigyItem() {
        super(new Item.Settings().maxCount(1).fireproof().rarity(Rarity.RARE));
    }

    @Override
    public int getMaxUseTime(ItemStack itemstack) {
        return 0;
    }


}
