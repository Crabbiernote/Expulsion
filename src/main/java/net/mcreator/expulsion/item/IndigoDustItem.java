
package net.mcreator.expulsion.item;

import net.mcreator.expulsion.ClientInit;
import net.mcreator.expulsion.init.ExpulsionModSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;

import net.mcreator.expulsion.init.ExpulsionModTabs;

import net.minecraft.world.World;

import java.sql.SQLOutput;

import static net.mcreator.expulsion.ClientInit.INDIGO_SHIFT;
import static net.mcreator.expulsion.ClientInit.shaderActive2;

public class IndigoDustItem extends Item {
	public IndigoDustItem() {
		super(new Item.Settings().group(ExpulsionModTabs.TAB_EXPULSION).maxCount(64).rarity(Rarity.COMMON)
				.food(new FoodComponent.Builder().hunger(0).saturationModifier(0.1f).alwaysEdible().snack().build()));
	}

	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		if (!world.isClient) {
			PlayerEntity player = (PlayerEntity) user;
			user.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 120, 0));
			world.playSound(

					null,
					user.getBlockPos(),
					ExpulsionModSounds.INDIGO_SNORT,
					SoundCategory.PLAYERS,
					1.0F,
					1.0F
			);
			player.getHungerManager().getFoodLevel();
			if (player.getHungerManager().getFoodLevel() > 0) {
				player.getHungerManager().add(-1, -0.1f);
			}
			ClientInit.indigoshader();
		}
		return super.finishUsing(stack, world, user);
	}
	@Override
	public SoundEvent getEatSound() {
		return ExpulsionModSounds.INDIGO_SNORT;
	}

}


