package com.devvoid.amethyst_stairs.datagen;

import com.devvoid.amethyst_stairs.AmethystStairsMod;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.AmethystBlock;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

public class ModelGenerator extends FabricModelProvider {
    public ModelGenerator(FabricDataOutput generator) {
        super(generator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blocks) {
        var reg = AmethystStairsMod.BLOCKS;

        BlockStateModelGenerator.BlockTexturePool pool = blocks.registerCubeAllModelTexturePool(Blocks.AMETHYST_BLOCK);

        pool.stairs(reg.get("amethyst_stairs"));
        pool.slab(reg.get("amethyst_slab"));
        pool.wall(reg.get("amethyst_wall"));
    }

    @Override
    public void generateItemModels(ItemModelGenerator items) {}
}
