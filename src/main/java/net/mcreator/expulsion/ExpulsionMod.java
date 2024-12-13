/*
 *	MCreator note:
 *
 *	If you lock base mod element files, you can edit this file and the proxy files
 *	and they won't get overwritten. If you change your mod package or modid, you
 *	need to apply these changes to this file MANUALLY.
 *
 *
 *	If you do not lock base mod element files in Workspace settings, this file
 *	will be REGENERATED on each build.
 *
 */
package net.mcreator.expulsion;

import net.mcreator.expulsion.command.GoingGhost;
import net.mcreator.expulsion.init.*;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import static net.mcreator.expulsion.procedures.HallowedEffigyDoesStuff.DoThefunny;

import net.fabricmc.api.ModInitializer;

import java.util.*;

public class ExpulsionMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MODID = "expulsion";
	public static Boolean isGhost = true;
	public static Boolean isCloaked = true;
	public static final ArrayList<UUID> bannedUuids = new ArrayList<>();
	public static final ArrayList<UUID> cloaked = new ArrayList<>();




	@Override
	public void onInitialize() {
		LOGGER.info("Initializing ExpulsionMod");
		ExpulsionModTabs.load();
		ExpulsionModBlocks.load();
		ExpulsionModItems.load();
		ExpulsionModProcedures.load();
		ExpulsionModSounds.load();
		bannedUuids.add(UUID.fromString("7a4a8f5e-acd5-41d7-9e3d-998bfd623c3d"));
		cloaked.add(UUID.fromString("259ce807-a306-4c16-96ca-ed60a62cea46"));

		// Check if the player has the effigy and is about to die
		DoThefunny();
		GoingGhost.GoingGhost();
		//ITS YELLING AT ME FOR SOMETHING THAT DOESNT EXIST WHYYYYYYYY




	}
}

