package net.mcreator.expulsion.Datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.mcreator.expulsion.init.ExpulsionModBlocks;
import net.minecraft.data.server.BlockLootTableGenerator;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public class ExpulsionLootTableGenerator extends SimpleFabricLootTableProvider {
    public ExpulsionLootTableGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator, LootContextTypes.BLOCK);
    }


    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> identifierBuilderBiConsumer) {
        identifierBuilderBiConsumer.accept(new Identifier("expulsion", "block/indigo_brick_slab"),
                BlockLootTableGenerator.slabDrops(ExpulsionModBlocks.INDIGO_BRICK_SLAB));
        identifierBuilderBiConsumer.accept(new Identifier("expulsion", "block/indigo_brick_stairs"),
                BlockLootTableGenerator.drops(ExpulsionModBlocks.INDIGO_BRICK_STAIRS));
        identifierBuilderBiConsumer.accept(new Identifier("expulsion", "block/indigo_brick_wall"),
                BlockLootTableGenerator.drops(ExpulsionModBlocks.INDIGO_BRICK_WALL));
    }
}

