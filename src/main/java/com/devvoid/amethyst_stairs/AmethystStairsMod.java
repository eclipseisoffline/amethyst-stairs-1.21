package com.devvoid.amethyst_stairs;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public class AmethystStairsMod implements ModInitializer {
    //public static final Logger LOGGER = LoggerFactory.getLogger("amethyst_stairs");

	public static FabricBlockSettings AMETHYST = FabricBlockSettings.create()
			.mapColor(MapColor.PURPLE)
			.strength(1.5f)
			.sounds(BlockSoundGroup.AMETHYST_BLOCK)
			.requiresTool();

	public static HashMap<String, Block> BLOCKS = new HashMap<>();
	public static HashMap<String, Item> ITEMS = new HashMap<>();

	@Override
	public void onInitialize() {
		register("amethyst_stairs", new StairsBlock(Blocks.AMETHYST_BLOCK.getDefaultState(), AMETHYST));
		register("amethyst_slab", new SlabBlock(AMETHYST));
		register("amethyst_wall", new WallBlock(AMETHYST));
	}

	private static void register(String name, Block block) {
		register(name, block, new FabricItemSettings());
	}

	private static void register(String name, Block block, FabricItemSettings settings) {
		var id = new Identifier("amethyst_stairs", name);

		var reg_block = Registry.register(Registries.BLOCK, id, block);
		BLOCKS.put(name, reg_block);

		var reg_item = Registry.register(Registries.ITEM, id, new BlockItem(block, settings));
		ITEMS.put(name, reg_item);
	}
}