
package net.mcreator.expulsion.item;

import net.minecraft.world.World;
import net.minecraft.util.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.Hand;

public class HollowEffigyItem extends Item {
	public HollowEffigyItem() {
		super(new Item.Settings().maxCount(1).fireproof().rarity(Rarity.RARE));
	}

	@Override
	public int getMaxUseTime(ItemStack itemstack) {
		return 0;
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity entity, Hand hand) {
		TypedActionResult<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getValue();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		return ar;
	}
}



