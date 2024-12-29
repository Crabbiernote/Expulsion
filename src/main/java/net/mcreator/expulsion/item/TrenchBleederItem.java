
package net.mcreator.expulsion.item;

import net.minecraft.recipe.Ingredient;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;

public class TrenchBleederItem extends SwordItem {
	public TrenchBleederItem() {
		super(new ToolMaterial() {

			@Override
			public int getDurability() {
				return 0;
			}

			@Override
			public float getMiningSpeedMultiplier() {
				return 15f;
			}

			@Override
			public float getAttackDamage() {
				return 5.5f;
			}

			@Override
			public int getMiningLevel() {
				return 4;
			}

			@Override
			public int getEnchantability() {
				return 10;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.EMPTY;
			}
		}, 3, -2.8f, new Item.Settings().fireproof());
	}
}
