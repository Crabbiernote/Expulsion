package net.mcreator.expulsion.Datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.mcreator.expulsion.init.ExpulsionModBlocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ExpulsionTagGenerator extends FabricTagProvider.BlockTagProvider {


    public ExpulsionTagGenerator(FabricDataOutput dataOutput) {
        super(dataOutput, (CompletableFuture<RegistryWrapper.WrapperLookup>) Registries.BLOCK);
    }


    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

    }
}
