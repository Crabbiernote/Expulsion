package net.mcreator.expulsion.mixins;

import net.mcreator.expulsion.ExpulsionMod;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.advancement.PlayerAdvancementTracker;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PlayerAdvancementTracker.class)
public class PlayerAdvancementTrackerMixin {
    @Shadow private ServerPlayerEntity owner;

    @ModifyExpressionValue(method = "grantCriterion", at = @At(value = "INVOKE", target = "Lnet/minecraft/advancement/AdvancementDisplay;shouldAnnounceToChat()Z"))
    private boolean eplayers$maybeActuallyDontAnnounce(boolean original) {
        return original && !ExpulsionMod.bannedUuids.contains(this.owner.getUuid());
    }
}
