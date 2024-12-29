package net.mcreator.expulsion.init;

import net.mcreator.expulsion.ExpulsionMod;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

public class ExpulsionModSounds {
    public static void load(){
    }
    public static final SoundEvent INDIGO_SNORT = registerSoundEvent("indigo_snort");
    public static void register() {}

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(ExpulsionMod.MODID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
}
