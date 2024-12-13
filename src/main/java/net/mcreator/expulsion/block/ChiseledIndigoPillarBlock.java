
package net.mcreator.expulsion.block;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.hit.BlockHitResult;
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
import net.minecraft.world.World;
import net.minecraft.world.BlockView;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.render.RenderLayer;

import net.mcreator.expulsion.procedures.ChiseledIndigoPillarOnBlockRightClickedProcedure;
import net.mcreator.expulsion.init.ExpulsionModBlocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import java.util.List;
import java.util.Collections;

public class ChiseledIndigoPillarBlock extends Block {
	public static AbstractBlock.Settings PROPERTIES = FabricBlockSettings.of(Material.STONE).requiresTool().sounds(BlockSoundGroup.STONE).strength(2.5f, 100f).requiresTool();
	public static final EnumProperty<Direction.Axis> AXIS = Properties.AXIS;

	public ChiseledIndigoPillarBlock() {
		super(PROPERTIES);
		this.setDefaultState(this.getStateManager().getDefaultState().with(AXIS, Direction.Axis.Y));
	}

	@Override
	public int getOpacity(BlockState state, BlockView worldIn, BlockPos pos) {
		return 15;
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
			if ((Direction.Axis) state.get(AXIS) == Direction.Axis.X) {
				return state.with(AXIS, Direction.Axis.Z);
			} else if ((Direction.Axis) state.get(AXIS) == Direction.Axis.Z) {
				return state.with(AXIS, Direction.Axis.X);
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

	@Override
	public ActionResult onUse(BlockState blockstate, World world, BlockPos pos, PlayerEntity entity, Hand hand, BlockHitResult hit) {
		super.onUse(blockstate, world, pos, entity, hand, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getPos().x;
		double hitY = hit.getPos().y;
		double hitZ = hit.getPos().z;
		Direction direction = hit.getSide();
		ChiseledIndigoPillarOnBlockRightClickedProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("world", world).put("x", x).put("y", y).put("z", z).put("entity", entity).build());
		return ActionResult.SUCCESS;
	}

	@Environment(EnvType.CLIENT)
	public static void clientInit() {
		BlockRenderLayerMap.INSTANCE.putBlock(ExpulsionModBlocks.CHISELED_INDIGO_PILLAR, RenderLayer.getSolid());
	}
}
