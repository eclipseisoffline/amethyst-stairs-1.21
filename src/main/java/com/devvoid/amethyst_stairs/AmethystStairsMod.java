package com.devvoid.amethyst_stairs;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public class AmethystStairsMod implements ModInitializer {

	public static AbstractBlock.Settings AMETHYST = AbstractBlock.Settings.create()
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

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content ->
				content.addAfter(Items.AMETHYST_BLOCK,
					BLOCKS.get("amethyst_stairs"),
					BLOCKS.get("amethyst_slab"),
					BLOCKS.get("amethyst_wall")));
	}

	private static void register(String name, Block block) {
		register(name, block, new Item.Settings());
	}

	private static void register(String name, Block block, Item.Settings settings) {
		var id = Identifier.of("amethyst_stairs", name);

		var reg_block = Registry.register(Registries.BLOCK, id, block);
		BLOCKS.put(name, reg_block);

		var reg_item = Registry.register(Registries.ITEM, id, new BlockItem(block, settings));
		ITEMS.put(name, reg_item);
	}
}