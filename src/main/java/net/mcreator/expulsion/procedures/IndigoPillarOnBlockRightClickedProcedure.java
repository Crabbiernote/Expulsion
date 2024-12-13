package net.mcreator.expulsion.procedures;

import net.minecraft.world.WorldAccess;
import net.minecraft.state.property.Property;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

import net.mcreator.expulsion.init.ExpulsionModItems;
import net.mcreator.expulsion.init.ExpulsionModBlocks;
import net.mcreator.expulsion.ExpulsionMod;

import java.util.Map;

public class IndigoPillarOnBlockRightClickedProcedure {

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ExpulsionMod.LOGGER.warn("Failed to load dependency world for procedure IndigoPillarOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ExpulsionMod.LOGGER.warn("Failed to load dependency x for procedure IndigoPillarOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ExpulsionMod.LOGGER.warn("Failed to load dependency y for procedure IndigoPillarOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ExpulsionMod.LOGGER.warn("Failed to load dependency z for procedure IndigoPillarOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ExpulsionMod.LOGGER.warn("Failed to load dependency entity for procedure IndigoPillarOnBlockRightClicked!");
			return;
		}
		WorldAccess world = (WorldAccess) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY).getItem() == ExpulsionModItems.ROCK_HAMMER) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = ExpulsionModBlocks.CHISELED_INDIGO_PILLAR.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getEntries().entrySet()) {
					Property _property = _bs.getBlock().getStateManager().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				BlockEntity _be = world.getBlockEntity(_bp);
				NbtCompound _bnbt = null;
				if (_be != null) {
//					_bnbt = _be.createNbtWithIdentifyingData();
					_be.markRemoved();
				}
				world.setBlockState(_bp, _bs, 3);
				if (_bnbt != null) {
					_be = world.getBlockEntity(_bp);
					if (_be != null) {
						try {
							_be.readNbt(_bnbt);
						} catch (Exception ignored) {
						}

					}
				}
			}
		}
	}
}
