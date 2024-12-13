package net.mcreator.expulsion.procedures;

import net.mcreator.expulsion.init.ExpulsionModBlocks;
import net.minecraft.state.property.Property;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.WorldAccess;
import net.minecraft.util.math.BlockPos;

import net.mcreator.expulsion.ExpulsionMod;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

import java.util.Map;

public class BrokenBasaltBlockAddedProcedure {

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ExpulsionMod.LOGGER.warn("Failed to load dependency world for procedure BrokenBasaltBlockAdded!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ExpulsionMod.LOGGER.warn("Failed to load dependency x for procedure BrokenBasaltBlockAdded!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ExpulsionMod.LOGGER.warn("Failed to load dependency y for procedure BrokenBasaltBlockAdded!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ExpulsionMod.LOGGER.warn("Failed to load dependency z for procedure BrokenBasaltBlockAdded!");
			return;
		}
		WorldAccess world = (WorldAccess) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		new Object() {
			private int ticks = 0;

			public void startDelay(WorldAccess world) {
				ServerTickEvents.END_SERVER_TICK.register((server) -> {
					this.ticks++;
					if (this.ticks == 1200) {
						{
							BlockPos _bp = new BlockPos(x, y, z);
							if (world.getBlockState(_bp).getBlock() == ExpulsionModBlocks.BROKEN_BASALT) {
							BlockState _bs = Blocks.BASALT.getDefaultState();
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
							}
						return;
					}
				});
			}
		}.startDelay(world);
	}
}
