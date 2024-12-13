package net.mcreator.expulsion.init;

import net.mcreator.expulsion.ExpulsionMod;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ExpulsionModSounds {
    public static void load(){
    }
    public static final SoundEvent INDIGO_SNORT = registerSoundEvent("indigo_snort");
    public static void register() {}

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(ExpulsionMod.MODID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }
}
