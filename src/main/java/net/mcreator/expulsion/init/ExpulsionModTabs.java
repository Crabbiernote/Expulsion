
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.expulsion.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.mcreator.expulsion.init.ExpulsionModItems;
import net.mcreator.expulsion.init.ExpulsionModBlocks;

import static net.mcreator.expulsion.init.ExpulsionModItems.*;

public class ExpulsionModTabs {
	public static ItemGroup TAB_EXPULSION = FabricItemGroup.builder()
			.icon(() -> new ItemStack(ExpulsionModBlocks.INDIGO_LANTERN))
			.displayName(Text.translatable("itemGroup.expulsion.expulsion_tab"))
			.entries((context, entries) -> {
				entries.add(INDIGO_BRICK_STAIRS);
				entries.add(INDIGO_BRICK_WALL);
				entries.add(INDIGO_BRICK_SLAB);
				entries.add(INDIGO_BRICKS);
				entries.add(ROCK_HAMMER);
				entries.add(INDIGO_DUST);
				entries.add(BROKEN_BASALT);
				entries.add(INDIGO_LANTERN);
				entries.add(INDIGO_PILLAR);
				entries.add(TRENCH_BLEEDER);
				entries.add(HOLLOW_EFFIGY);
				entries.add(INDIGO_PLANKS);
				entries.add(CHISELED_INDIGO_BRICKS);
				entries.add(CHISELED_INDIGO_PILLAR);
				entries.add(ACTIVATED_CHISELED_INDIGO_PILLAR);
				entries.add(INDIGO_CHAIN);
			})
			.build();

	public static void load() {
		// This method is no longer needed as TAB_EXPULSION is already initialized
		Registry.register(Registries.ITEM_GROUP, new Identifier("expulsion", "expulsion_tab"), ExpulsionModTabs.TAB_EXPULSION);
	}
}
