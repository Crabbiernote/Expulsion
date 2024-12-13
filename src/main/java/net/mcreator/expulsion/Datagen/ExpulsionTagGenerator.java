package net.mcreator.expulsion.Datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.mcreator.expulsion.init.ExpulsionModBlocks;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.registry.Registry;

public class ExpulsionTagGenerator extends FabricTagProvider.BlockTagProvider {


    public ExpulsionTagGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateTags() {
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ExpulsionModBlocks.INDIGO_BRICK_WALL);

    }
}
