package com.devvoid.amethyst_stairs.datagen;

import com.devvoid.amethyst_stairs.AmethystStairsMod;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class TagGenerator extends FabricTagProvider.BlockTagProvider {
    public TagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        var reg = AmethystStairsMod.BLOCKS;
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(reg.get("amethyst_stairs"))
                .add(reg.get("amethyst_slab"))
                .add(reg.get("amethyst_wall"));

        getOrCreateTagBuilder(BlockTags.CRYSTAL_SOUND_BLOCKS)
                .add(reg.get("amethyst_stairs"))
                .add(reg.get("amethyst_slab"))
                .add(reg.get("amethyst_wall"));

        getOrCreateTagBuilder(BlockTags.STAIRS).add(reg.get("amethyst_stairs"));
        getOrCreateTagBuilder(BlockTags.SLABS).add(reg.get("amethyst_slab"));
        getOrCreateTagBuilder(BlockTags.WALLS).add(reg.get("amethyst_wall"));
    }
}
