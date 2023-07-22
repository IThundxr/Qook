package dev.ithundxr.qook.datagen;

import dev.ithundxr.qook.Qook;
import io.github.fabricators_of_create.porting_lib.data.ExistingFileHelper;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator.Pack;

public class QookDataGeneration implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        ExistingFileHelper helper = ExistingFileHelper.withResourcesFromArg();
        Pack pack = generator.createPack();
        Qook.REGISTRATE.setupDatagen(generator.createPack(), helper);
        Qook.gatherData(pack, helper);
    }
}
