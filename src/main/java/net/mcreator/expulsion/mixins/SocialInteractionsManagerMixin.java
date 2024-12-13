package net.mcreator.expulsion.mixins;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.mcreator.expulsion.ExpulsionMod;
import net.minecraft.client.network.SocialInteractionsManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Map;
import java.util.UUID;

@Mixin(SocialInteractionsManager.class)
public class SocialInteractionsManagerMixin {
    @Shadow @Final private Map<String, UUID> playerNameByUuid;

    @ModifyReturnValue(method = "getUuid", at = @At("RETURN"))
    private UUID inowannatalk(UUID original) {
        if (ExpulsionMod.bannedUuids.contains(original)) {
            return null;
        }
        return original;
    }
}