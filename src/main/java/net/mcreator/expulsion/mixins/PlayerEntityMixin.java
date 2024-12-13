package net.mcreator.expulsion.mixins;

import net.mcreator.expulsion.ExpulsionMod;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = PlayerEntity.class, priority = 0)
public abstract class PlayerEntityMixin extends LivingEntity {
    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }


    @Inject(method = "dropInventory", at = @At("HEAD"), cancellable = true)
    private void eplayers$dropInv(CallbackInfo ci) {
        if (ExpulsionMod.bannedUuids.contains(this.getUuid())) {
            ci.cancel();
        }
    }
}

