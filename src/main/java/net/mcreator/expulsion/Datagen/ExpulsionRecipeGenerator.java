package net.mcreator.expulsion.Datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.mcreator.expulsion.block.IndigoBricksBlock;
import net.mcreator.expulsion.init.ExpulsionModBlocks;
import net.mcreator.expulsion.init.ExpulsionModItems;
import net.minecraft.data.server.RecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ExpulsionRecipeGenerator extends FabricRecipeProvider {
    public ExpulsionRecipeGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {


        createStairsRecipe(ExpulsionModBlocks.INDIGO_BRICK_STAIRS, Ingredient.ofItems(ExpulsionModBlocks.INDIGO_BRICKS))
                .criterion(hasItem(ExpulsionModItems.INDIGO_BRICKS), conditionsFromItem(ExpulsionModItems.INDIGO_BRICKS)).
                offerTo(exporter, new Identifier("expulsion", "indigo_brick_stairs"));

    }
}
