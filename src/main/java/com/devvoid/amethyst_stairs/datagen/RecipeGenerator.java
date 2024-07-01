package com.devvoid.amethyst_stairs.datagen;

import com.devvoid.amethyst_stairs.AmethystStairsMod;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

public class RecipeGenerator extends FabricRecipeProvider {


    public RecipeGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        var reg = AmethystStairsMod.BLOCKS;

        var cat = RecipeCategory.BUILDING_BLOCKS;
        var stairs = reg.get("amethyst_stairs");
        var slab = reg.get("amethyst_slab");
        var wall = reg.get("amethyst_wall");
        var block = Blocks.AMETHYST_BLOCK;

        // Crafting table
        createStairsRecipe(stairs, Ingredient.ofItems(block))
                .criterion(hasItem(block), conditionsFromItem(block))
                .offerTo(exporter);

        offerSlabRecipe(exporter, cat, slab, block);
        offerWallRecipe(exporter, cat, wall, block);

        // Stonecutter
        offerStonecuttingRecipe(exporter, cat, stairs, block);
        offerStonecuttingRecipe(exporter, cat, slab, block, 2);
        offerStonecuttingRecipe(exporter, cat, wall, block);
    }
}
