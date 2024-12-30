
package net.mcreator.expulsion.block;

import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.block.Block;
import net.minecraft.world.BlockView;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.render.RenderLayer;

import net.mcreator.expulsion.init.ExpulsionModBlocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import java.util.List;
import java.util.Collections;

public class IndigoLanternBlock extends Block {
	public static AbstractBlock.Settings PROPERTIES = FabricBlockSettings.copyOf(Blocks.STONE).requiresTool().sounds(BlockSoundGroup.STONE).strength(2.5f, 100f).luminance(s -> 11).requiresTool()
			.postProcess((bs, br, bp) -> true).emissiveLighting((bs, br, bp) -> true);

	public IndigoLanternBlock() {
		super(PROPERTIES);
	}

	@Override
	public int getOpacity(BlockState state, BlockView worldIn, BlockPos pos) {
		return 16;
	}

	@Override
	public List<ItemStack> getDroppedStacks(BlockState state, LootContextParameterSet.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDroppedStacks(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}

	@Environment(EnvType.CLIENT)
	public static void clientInit() {
		BlockRenderLayerMap.INSTANCE.putBlock(ExpulsionModBlocks.INDIGO_LANTERN, RenderLayer.getSolid());
	}
}
