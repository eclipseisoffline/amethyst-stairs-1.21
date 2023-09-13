package com.devvoid.amethyst_stairs.datagen;

import com.devvoid.amethyst_stairs.AmethystStairsMod;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class LootTableGenerator extends FabricBlockLootTableProvider {
    public LootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        var reg = AmethystStairsMod.BLOCKS;
        addDrop(reg.get("amethyst_stairs"));
        addDrop(reg.get("amethyst_slab"), slabDrops(reg.get("amethyst_slab")));
        addDrop(reg.get("amethyst_wall"));
    }
}
