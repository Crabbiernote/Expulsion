package net.mcreator.expulsion.mixins;

import net.mcreator.expulsion.ExpulsionMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
@Mixin(LivingEntityRenderer.class)
public class LivingEntityRendererMixin {
    @ModifyVariable(method = "render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;isInvisibleTo(Lnet/minecraft/entity/player/PlayerEntity;)Z"))
    private boolean eplayers$translucency(boolean original) {
        if (ExpulsionMod.isGhost){
        if(ExpulsionMod.bannedUuids.contains(MinecraftClient.getInstance().player.getUuid()))
            return true;
        }
        return original;
    }
}