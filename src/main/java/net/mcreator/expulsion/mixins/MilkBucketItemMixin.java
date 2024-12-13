package net.mcreator.expulsion.mixins;


import net.mcreator.expulsion.ClientInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MilkBucketItem.class)
public class MilkBucketItemMixin {
@Inject(method = "finishUsing", at = @At("HEAD"), cancellable = true)
private void milkCancelsOutDrugs(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir) {
    // Ensure this runs only on the client thread
    if (world.isClient && ClientInit.shaderActive) {
        // Reset shader-specific variables
        ClientInit.snoofcount = 0;
        ClientInit.shaderActive = false;
        ClientInit.targetblue = 1.0f;
        ClientInit.targetred = 1.0f;
        ClientInit.targetgreen = 1.0f;
    }
}
}
