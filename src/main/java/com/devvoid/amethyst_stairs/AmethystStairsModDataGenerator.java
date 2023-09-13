package com.devvoid.amethyst_stairs;

import com.devvoid.amethyst_stairs.datagen.LootTableGenerator;
import com.devvoid.amethyst_stairs.datagen.ModelGenerator;
import com.devvoid.amethyst_stairs.datagen.RecipeGenerator;
import com.devvoid.amethyst_stairs.datagen.TagGenerator;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class AmethystStairsModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(TagGenerator::new);
		pack.addProvider(RecipeGenerator::new);
		pack.addProvider(LootTableGenerator::new);
		pack.addProvider(ModelGenerator::new);
	}
}

