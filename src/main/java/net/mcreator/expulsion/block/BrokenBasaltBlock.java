
package net.mcreator.expulsion.block;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.loot.context.LootContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.StateManager;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.BlockMirror;
import net.minecraft.block.FacingBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.BlockView;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.render.RenderLayer;

import net.mcreator.expulsion.procedures.BrokenBasaltBlockAddedProcedure;
import net.mcreator.expulsion.init.ExpulsionModBlocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import java.util.List;
import java.util.Collections;

public class BrokenBasaltBlock extends Block {
	public static AbstractBlock.Settings PROPERTIES = FabricBlockSettings.of().requiresTool().sounds(BlockSoundGroup.STONE).strength(2.5f, 100f).requiresTool();
	public static final DirectionProperty FACING = FacingBlock.FACING;

	public BrokenBasaltBlock() {
		super(PROPERTIES);
		this.setDefaultState(this.getStateManager().getDefaultState().with(FACING, Direction.NORTH));
	}

	@Override
	public int getOpacity(BlockState state, BlockView worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public BlockState getPlacementState(ItemPlacementContext context) {
		return this.getDefaultState().with(FACING, context.getSide());
	}

	public BlockState rotate(BlockState state, BlockRotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}

	public BlockState mirror(BlockState state, BlockMirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.get(FACING)));
	}


	@Override
	public void onBlockAdded(BlockState blockstate, World world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onBlockAdded(blockstate, world, pos, oldState, moving);
		BrokenBasaltBlockAddedProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("x", pos.getX()).put("y", pos.getY()).put("z", pos.getZ()).put("world", world).build());
	}

	@Environment(EnvType.CLIENT)
	public static void clientInit() {
		BlockRenderLayerMap.INSTANCE.putBlock(ExpulsionModBlocks.BROKEN_BASALT, RenderLayer.getSolid());
	}
}
