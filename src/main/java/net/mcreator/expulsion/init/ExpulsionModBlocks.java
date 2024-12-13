
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.expulsion.init;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.mcreator.expulsion.block.*;
import net.minecraft.block.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


import net.mcreator.expulsion.ExpulsionMod;

public class ExpulsionModBlocks {
	public static Block INDIGO_BRICK_SLAB;
	public static Block INDIGO_PLANKS_SLAB;
	public static Block INDIGO_PLANKS_STAIRS;
	public static Block INDIGO_BRICK_WALL;
	public static Block INDIGO_BRICK_STAIRS;
	public static Block INDIGO_BRICKS;
	public static Block BROKEN_BASALT;
	public static Block INDIGO_LANTERN;

	public static Block INDIGO_PILLAR;
	public static Block INDIGO_PLANKS;
	public static Block CHISELED_INDIGO_BRICKS;
	public static Block CHISELED_INDIGO_PILLAR;
	public static Block ACTIVATED_CHISELED_INDIGO_PILLAR;
	public static Block INDIGO_CHAIN;


	public static void load() {
		INDIGO_BRICKS = Registry.register(Registry.BLOCK, new Identifier(ExpulsionMod.MODID, "indigo_bricks"), new IndigoBricksBlock());
		INDIGO_BRICK_WALL = Registry.register(Registry.BLOCK,
				new Identifier(ExpulsionMod.MODID, "indigo_brick_wall"),
				new WallBlock(FabricBlockSettings.copyOf(INDIGO_BRICKS)));
		INDIGO_BRICK_SLAB = Registry.register(Registry.BLOCK,
				new Identifier(ExpulsionMod.MODID, "indigo_brick_slab"),
				new SlabBlock(FabricBlockSettings.copyOf(INDIGO_BRICKS)));
		INDIGO_BRICK_STAIRS = Registry.register(Registry.BLOCK,
				new Identifier(ExpulsionMod.MODID, "indigo_brick_stairs"),
				new StairsBlock(INDIGO_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(INDIGO_BRICKS)));
		BROKEN_BASALT = Registry.register(Registry.BLOCK, new Identifier(ExpulsionMod.MODID, "broken_basalt"), new BrokenBasaltBlock());
		INDIGO_LANTERN = Registry.register(Registry.BLOCK, new Identifier(ExpulsionMod.MODID, "indigo_lantern"), new IndigoLanternBlock());
		INDIGO_PILLAR = Registry.register(Registry.BLOCK, new Identifier(ExpulsionMod.MODID, "indigo_pillar"), new IndigoPillarBlock());
		INDIGO_PLANKS = Registry.register(Registry.BLOCK, new Identifier(ExpulsionMod.MODID, "indigo_planks"), new IndigoPlanksBlock());
		CHISELED_INDIGO_BRICKS = Registry.register(Registry.BLOCK, new Identifier(ExpulsionMod.MODID, "chiseled_indigo_bricks"), new ChiseledIndigoBricksBlock());
		CHISELED_INDIGO_PILLAR = Registry.register(Registry.BLOCK, new Identifier(ExpulsionMod.MODID, "chiseled_indigo_pillar"), new ChiseledIndigoPillarBlock());
		ACTIVATED_CHISELED_INDIGO_PILLAR = Registry.register(Registry.BLOCK, new Identifier(ExpulsionMod.MODID, "activated_chiseled_indigo_pillar"), new ActivatedChiseledIndigoPillarBlock());
		INDIGO_CHAIN = Registry.register(Registry.BLOCK, new Identifier(ExpulsionMod.MODID, "indigo_chain"), new IndigoChainBlock());
		INDIGO_PLANKS_SLAB = Registry.register(Registry.BLOCK,
				new Identifier(ExpulsionMod.MODID, "indigo_planks_slab"),
				new SlabBlock(FabricBlockSettings.copyOf(INDIGO_PLANKS)));
		INDIGO_PLANKS_STAIRS = Registry.register(Registry.BLOCK,
				new Identifier(ExpulsionMod.MODID, "indigo_planks_stairs"),
				new StairsBlock(INDIGO_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(INDIGO_PLANKS)));
	}
	public static void clientLoad() {
		IndigoBricksBlock.clientInit();
		BrokenBasaltBlock.clientInit();
		IndigoLanternBlock.clientInit();
		IndigoPillarBlock.clientInit();
		IndigoPlanksBlock.clientInit();
		ChiseledIndigoBricksBlock.clientInit();
		ChiseledIndigoPillarBlock.clientInit();
		ActivatedChiseledIndigoPillarBlock.clientInit();
		IndigoBricksStairs.clientInit();
		IndigoChainBlock.clientInit();
		IndigoBrickWall.clientInit();
		IndigoPlanksStairs.clientInit();
		IndigoPlanksSlabBlock.clientInit();

	}
	public static Block register (Block block, String name, boolean shouldRegister) {
		if (shouldRegister) {
			Registry.register(Registry.BLOCK, new Identifier(ExpulsionMod.MODID, name), block);
		}
		return block;
	}
}
