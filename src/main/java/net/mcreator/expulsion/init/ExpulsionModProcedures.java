
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.expulsion.init;

import net.mcreator.expulsion.procedures.RockHammerRightclickedOnBlockProcedure;
import net.mcreator.expulsion.procedures.IndigoPillarOnBlockRightClickedProcedure;

import net.mcreator.expulsion.procedures.ChiseledIndigoPillarOnBlockRightClickedProcedure;
import net.mcreator.expulsion.procedures.BrokenBasaltBlockAddedProcedure;
import net.mcreator.expulsion.procedures.ActivatedChiseledIndigoPillarOnBlockRightClickedProcedure;

@SuppressWarnings("InstantiationOfUtilityClass")
public class ExpulsionModProcedures {
	public static void load() {
		new BrokenBasaltBlockAddedProcedure();
		new RockHammerRightclickedOnBlockProcedure();

		new ChiseledIndigoPillarOnBlockRightClickedProcedure();
		new ActivatedChiseledIndigoPillarOnBlockRightClickedProcedure();
		new IndigoPillarOnBlockRightClickedProcedure();
	}
}
