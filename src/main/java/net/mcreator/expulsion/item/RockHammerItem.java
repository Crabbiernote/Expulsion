
package net.mcreator.expulsion.item;

import net.mcreator.expulsion.init.ExpulsionModBlocks;
import net.mcreator.expulsion.init.ExpulsionModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResult;
import net.minecraft.text.Text;

import java.util.List;

public class RockHammerItem extends Item {
	public RockHammerItem() {
		super(new Item.Settings().maxCount(1).fireproof().rarity(Rarity.COMMON));
	}

	@Override
	public int getMaxUseTime(ItemStack itemstack) {
		return 0;
	}

	@Override
	public void appendTooltip(ItemStack itemstack, World world, List<Text> list, TooltipContext flag) {
		super.appendTooltip(itemstack, world, list, flag);
		list.add(Text.literal("Used to crack open basalt."));
	}

	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		ActionResult retval = super.useOnBlock(context);
		World world = context.getWorld();
		BlockPos blockpos = context.getBlockPos();
		PlayerEntity player = context.getPlayer();
		if (world.getBlockState(context.getBlockPos()).isOf(Blocks.BASALT)) {
			int j = 1 + world.random.nextInt(2);
			Block.dropStack(world, blockpos, new ItemStack(ExpulsionModItems.INDIGO_DUST, j));
			world.setBlockState(blockpos, ExpulsionModBlocks.BROKEN_BASALT.getDefaultState());
			player.swingHand(Hand.MAIN_HAND);
			world.playSound(
					null,
					player.getBlockPos(),
					SoundEvents.BLOCK_BASALT_BREAK,
					SoundCategory.BLOCKS,
					1.0f,
					1.0f
			);
			return retval;
		}
		return ActionResult.PASS;
	}
}
