
package net.mcreator.expulsion.block;

import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.Vec3d;
import net.minecraft.loot.context.LootContext;
import net.minecraft.block.Material;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.StateManager;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.BlockRotation;
import net.minecraft.block.Block;
import net.minecraft.world.BlockView;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.render.RenderLayer;

import net.mcreator.expulsion.init.ExpulsionModBlocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import java.util.List;
import java.util.Collections;

import static net.minecraft.util.math.Direction.Axis.*;

public class IndigoChainBlock extends Block {
	public static AbstractBlock.Settings PROPERTIES = FabricBlockSettings.of(Material.METAL).requiresTool().sounds(BlockSoundGroup.CHAIN).strength(2.5f, 100f).requiresTool().nonOpaque()
			.solidBlock((bs, br, bp) -> false);
	public static final EnumProperty<Direction.Axis> AXIS = Properties.AXIS;

	public IndigoChainBlock() {
		super(PROPERTIES);
		this.setDefaultState(this.getStateManager().getDefaultState().with(AXIS, Y));
	}

	@Override
	public boolean isTranslucent(BlockState state, BlockView reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getOpacity(BlockState state, BlockView worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		Vec3d offset = state.getModelOffset(world, pos);
		return (switch (state.get(AXIS)) {
			case X -> createCuboidShape(0, 6.5, 6.5, 16, 9.5, 9.5);
			case Y -> createCuboidShape(6.5, 0, 6.5, 9.5, 16, 9.5);
			case Z -> createCuboidShape(6.5, 6.5, 0, 9.5, 9.5, 16);
		}).offset(offset.x, offset.y, offset.z);
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(AXIS);
	}

	@Override
	public BlockState getPlacementState(ItemPlacementContext context) {
		return this.getDefaultState().with(AXIS, context.getSide().getAxis());
	}

	@Override
	public BlockState rotate(BlockState state, BlockRotation rot) {
		if (rot == BlockRotation.CLOCKWISE_90 || rot == BlockRotation.COUNTERCLOCKWISE_90) {
			if ((Direction.Axis) state.get(AXIS) == X) {
				return state.with(AXIS, Z);
			} else if ((Direction.Axis) state.get(AXIS) == Z) {
				return state.with(AXIS, X);
			}
		}
		return state;
	}

	@Override
	public List<ItemStack> getDroppedStacks(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDroppedStacks(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}

	@Environment(EnvType.CLIENT)
	public static void clientInit() {
		BlockRenderLayerMap.INSTANCE.putBlock(ExpulsionModBlocks.INDIGO_CHAIN, RenderLayer.getSolid());
	}
}
