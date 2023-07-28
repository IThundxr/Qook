package dev.ithundxr.qook.datagen;

import dev.ithundxr.qook.Qook;
import dev.ithundxr.qook.world.QookConfiguredFeatures;
import dev.ithundxr.qook.world.QookPlacedFeatures;
import io.github.fabricators_of_create.porting_lib.data.ExistingFileHelper;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator.Pack;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class QookDataGeneration implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        ExistingFileHelper helper = ExistingFileHelper.withResourcesFromArg();
        Pack pack = generator.createPack();
        Qook.REGISTRATE.setupDatagen(pack, helper);
        Qook.gatherData(pack);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.CONFIGURED_FEATURE, QookConfiguredFeatures::bootstrap);
        registryBuilder.add(Registries.PLACED_FEATURE, QookPlacedFeatures::bootstrap);
    }
}
