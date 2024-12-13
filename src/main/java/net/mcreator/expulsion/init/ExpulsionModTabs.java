
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.expulsion.init;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;

public class ExpulsionModTabs {
	public static ItemGroup TAB_EXPULSION;

	public static void load() {
		TAB_EXPULSION = FabricItemGroupBuilder.create(new Identifier("expulsion", "expulsion")).icon(() -> new ItemStack(ExpulsionModBlocks.INDIGO_LANTERN)).build();
	}
}
