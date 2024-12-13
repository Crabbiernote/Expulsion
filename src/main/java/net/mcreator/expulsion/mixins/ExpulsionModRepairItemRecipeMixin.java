package net.mcreator.expulsion.mixins;

import net.minecraft.inventory.CraftingInventory;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.recipe.RepairItemRecipe;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

import com.google.common.collect.Lists;

@Mixin(RepairItemRecipe.class)
public abstract class ExpulsionModRepairItemRecipeMixin {
	@Inject(method = "craft(Lnet/minecraft/inventory/CraftingInventory;)Lnet/minecraft/item/ItemStack;", at = @At("HEAD"), cancellable = true)
	public void craft(CraftingInventory craftingInventory, CallbackInfoReturnable<ItemStack> cir) {
		ItemStack itemStack3;
		ItemStack itemStack;
		ArrayList<ItemStack> list = Lists.newArrayList();
		for (int i = 0; i < craftingInventory.size(); ++i) {
			ItemStack itemStack2;
			itemStack = craftingInventory.getStack(i);
			if (itemStack.isEmpty())
				continue;
			list.add(itemStack);
		}
	}
}
