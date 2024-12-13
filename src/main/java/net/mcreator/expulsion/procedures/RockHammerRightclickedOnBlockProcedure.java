package net.mcreator.expulsion.procedures;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.random.Random;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Property;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.WorldAccess;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;

import net.mcreator.expulsion.init.ExpulsionModItems;
import net.mcreator.expulsion.init.ExpulsionModBlocks;
import net.mcreator.expulsion.ExpulsionMod;

import java.util.Map;

public class RockHammerRightclickedOnBlockProcedure {

	public static <Entity> void execute(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ExpulsionMod.LOGGER.warn("Failed to load dependency world for procedure RockHammerRightclickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ExpulsionMod.LOGGER.warn("Failed to load dependency x for procedure RockHammerRightclickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ExpulsionMod.LOGGER.warn("Failed to load dependency y for procedure RockHammerRightclickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ExpulsionMod.LOGGER.warn("Failed to load dependency z for procedure RockHammerRightclickedOnBlock!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ExpulsionMod.LOGGER.warn("Failed to load dependency entity for procedure RockHammerRightclickedOnBlock!");
			return;
		}
		WorldAccess world = (WorldAccess) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.BASALT) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = ExpulsionModBlocks.BROKEN_BASALT.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getEntries().entrySet()) {
					Property _property = _bs.getBlock().getStateManager().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
			if (entity instanceof PlayerEntity _player) {
				ItemStack _setstack = new ItemStack(ExpulsionModItems.INDIGO_DUST);
				int dustamount = 1 + world.getRandom().nextInt(2);
				for (int i = 0; i < dustamount; i++) {
					// Add your code here for each iteration
					_player.giveItemStack(_setstack);
				}
				world.playSound(
						null,
						_player.getBlockPos(),
						SoundEvents.BLOCK_BASALT_BREAK,
						SoundCategory.BLOCKS,
						1.0f,
						1.0f
				);
			}
		}
	}
}
