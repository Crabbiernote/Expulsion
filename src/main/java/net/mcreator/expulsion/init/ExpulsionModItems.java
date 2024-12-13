
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.expulsion.init;
import net.mcreator.expulsion.item.*;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;


import net.mcreator.expulsion.ExpulsionMod;

public class ExpulsionModItems {
	public static Item INDIGO_BRICK_SLAB;
	public static Item INDIGO_BRICK_WALL;
	public static Item INDIGO_BRICK_STAIRS;
	public static Item INDIGO_BRICKS;
	public static Item ROCK_HAMMER;
	public static Item INDIGO_DUST;
	public static Item BROKEN_BASALT;
	public static Item INDIGO_LANTERN;
	public static Item INDIGO_PILLAR;
	public static Item TRENCH_BLEEDER;
	public static Item HOLLOW_EFFIGY;
	public static Item HALLOWED_ECHO_EFFIGY;
	public static Item INDIGO_PLANKS;
	public static Item INDIGO_PLANKS_SLAB;
	public static Item INDIGO_PLANKS_STAIRS;
	public static Item CHISELED_INDIGO_BRICKS;
	public static Item CHISELED_INDIGO_PILLAR;
	public static Item ACTIVATED_CHISELED_INDIGO_PILLAR;
	public static Item INDIGO_CHAIN;

	public static void load() {
		INDIGO_BRICK_STAIRS = Registry.register(Registry.ITEM, new Identifier(ExpulsionMod.MODID, "indigo_brick_stairs"), new BlockItem(ExpulsionModBlocks.INDIGO_BRICK_STAIRS, new Item.Settings().group(ExpulsionModTabs.TAB_EXPULSION)));
		INDIGO_BRICK_WALL = Registry.register(Registry.ITEM, new Identifier(ExpulsionMod.MODID, "indigo_brick_wall"), new BlockItem(ExpulsionModBlocks.INDIGO_BRICK_WALL, new Item.Settings().group(ExpulsionModTabs.TAB_EXPULSION)));
		INDIGO_BRICK_SLAB = Registry.register(Registry.ITEM, new Identifier(ExpulsionMod.MODID, "indigo_brick_slab"), new BlockItem(ExpulsionModBlocks.INDIGO_BRICK_SLAB, new Item.Settings().group(ExpulsionModTabs.TAB_EXPULSION)));
		INDIGO_BRICKS = Registry.register(Registry.ITEM, new Identifier(ExpulsionMod.MODID, "indigo_bricks"), new BlockItem(ExpulsionModBlocks.INDIGO_BRICKS, new Item.Settings().group(ExpulsionModTabs.TAB_EXPULSION)));
		ROCK_HAMMER = Registry.register(Registry.ITEM, new Identifier(ExpulsionMod.MODID, "rock_hammer"), new RockHammerItem());
		INDIGO_DUST = Registry.register(Registry.ITEM, new Identifier(ExpulsionMod.MODID, "indigo_dust"), new IndigoDustItem());
		BROKEN_BASALT = Registry.register(Registry.ITEM, new Identifier(ExpulsionMod.MODID, "broken_basalt"), new BlockItem(ExpulsionModBlocks.BROKEN_BASALT, new Item.Settings().group(null)));
		INDIGO_LANTERN = Registry.register(Registry.ITEM, new Identifier(ExpulsionMod.MODID, "indigo_lantern"), new BlockItem(ExpulsionModBlocks.INDIGO_LANTERN, new Item.Settings().group(ExpulsionModTabs.TAB_EXPULSION)));
		INDIGO_PILLAR = Registry.register(Registry.ITEM, new Identifier(ExpulsionMod.MODID, "indigo_pillar"), new BlockItem(ExpulsionModBlocks.INDIGO_PILLAR, new Item.Settings().group(ExpulsionModTabs.TAB_EXPULSION)));
		TRENCH_BLEEDER = Registry.register(Registry.ITEM, new Identifier(ExpulsionMod.MODID, "trench_bleeder"), new TrenchBleederItem());
		HOLLOW_EFFIGY = Registry.register(Registry.ITEM, new Identifier(ExpulsionMod.MODID, "hollow_effigy"), new HollowEffigyItem());
		INDIGO_PLANKS = Registry.register(Registry.ITEM, new Identifier(ExpulsionMod.MODID, "indigo_planks"), new BlockItem(ExpulsionModBlocks.INDIGO_PLANKS, new Item.Settings().group(ExpulsionModTabs.TAB_EXPULSION)));
		CHISELED_INDIGO_BRICKS = Registry.register(Registry.ITEM, new Identifier(ExpulsionMod.MODID, "chiseled_indigo_bricks"),
				new BlockItem(ExpulsionModBlocks.CHISELED_INDIGO_BRICKS, new Item.Settings().group(ExpulsionModTabs.TAB_EXPULSION)));
		CHISELED_INDIGO_PILLAR = Registry.register(Registry.ITEM, new Identifier(ExpulsionMod.MODID, "chiseled_indigo_pillar"),
				new BlockItem(ExpulsionModBlocks.CHISELED_INDIGO_PILLAR, new Item.Settings().group(ExpulsionModTabs.TAB_EXPULSION)));
		ACTIVATED_CHISELED_INDIGO_PILLAR = Registry.register(Registry.ITEM, new Identifier(ExpulsionMod.MODID, "activated_chiseled_indigo_pillar"),
				new BlockItem(ExpulsionModBlocks.ACTIVATED_CHISELED_INDIGO_PILLAR, new Item.Settings().group(null)));
		INDIGO_CHAIN = Registry.register(Registry.ITEM, new Identifier(ExpulsionMod.MODID, "indigo_chain"), new BlockItem(ExpulsionModBlocks.INDIGO_CHAIN, new Item.Settings().group(ExpulsionModTabs.TAB_EXPULSION)));
		INDIGO_PLANKS_SLAB = Registry.register(Registry.ITEM, new Identifier(ExpulsionMod.MODID, "indigo_planks_slab"), new BlockItem(ExpulsionModBlocks.INDIGO_PLANKS_SLAB, new Item.Settings().group(ExpulsionModTabs.TAB_EXPULSION)));
		INDIGO_PLANKS_STAIRS = Registry.register(Registry.ITEM, new Identifier(ExpulsionMod.MODID, "indigo_planks_stairs"), new BlockItem(ExpulsionModBlocks.INDIGO_PLANKS_STAIRS, new Item.Settings().group(ExpulsionModTabs.TAB_EXPULSION)));
		HALLOWED_ECHO_EFFIGY = Registry.register(Registry.ITEM, new Identifier(ExpulsionMod.MODID, "hallowed_echo_effigy"), new HallowedEchoEffigyItem());
	}
}
