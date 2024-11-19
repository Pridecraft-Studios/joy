package gay.pridecraft.joy.block;

import gay.pridecraft.joy.Blahaj;
import gay.pridecraft.joy.item.CuddlyItem;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.util.*;

import java.util.*;

public class BlahajBlocks {

	public static final Identifier GRAY_SHARK_ID = Identifier.of(Blahaj.MOD_ID, "gray_shark");
	public static final Identifier BLAHAJ_ID = Identifier.of(Blahaj.MOD_ID, "blue_shark");
	public static final Identifier BLAVINGAD_ID = Identifier.of(Blahaj.MOD_ID, "blue_whale");
	public static final Identifier BREAD_ID = Identifier.of(Blahaj.MOD_ID, "bread");
	public static final Identifier BROWN_BEAR_ID = Identifier.of(Blahaj.MOD_ID, "brown_bear");

	public static Block GRAY_SHARK_BLOCK;
	public static Item GRAY_SHARK_ITEM;
	public static Block BLAHAJ_BLOCK;
	public static Item BLAHAJ_ITEM;
	public static Block BLAVINGAD_BLOCK;
	public static Item BLAVINGAD_ITEM;
	public static Block BREAD_BLOCK;
	public static Item BREAD_ITEM;
	public static Block BROWN_BEAR_BLOCK;
	public static Item BROWN_BEAR_ITEM;

	public static final List<String> PRIDE_NAMES = List.of(
		"ace", "agender", "aro", "aroace", "bi", "demiboy", "demigirl",
		"demi_r", "demi_s", "enby", "gay", "genderfluid", "genderqueer", "greyrose",
		"grey_r", "grey_s", "intersex", "lesbian", "pan", "poly", "pride", "trans");

	public static List<Block> PRIDE_BLOCKS = new ArrayList<>();
	public static List<Item> PRIDE_ITEMS = new ArrayList<>();

	public static void register() {
		GRAY_SHARK_BLOCK = Registry.register(Registries.BLOCK, GRAY_SHARK_ID, new CuddlyBlock(AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_WOOL)));
		BLAHAJ_BLOCK = Registry.register(Registries.BLOCK, BLAHAJ_ID, new CuddlyBlock(AbstractBlock.Settings.copy(Blocks.CYAN_WOOL)));
		BLAVINGAD_BLOCK = Registry.register(Registries.BLOCK, BLAVINGAD_ID, new CuddlyBlock(AbstractBlock.Settings.copy(Blocks.BLUE_WOOL)));
		BREAD_BLOCK = Registry.register(Registries.BLOCK, BREAD_ID, new CuddlyBlock(AbstractBlock.Settings.copy(Blocks.ORANGE_WOOL)));
		BROWN_BEAR_BLOCK = Registry.register(Registries.BLOCK, BROWN_BEAR_ID, new CuddlyBlock(AbstractBlock.Settings.copy(Blocks.BROWN_WOOL)));

		GRAY_SHARK_ITEM = Registry.register(Registries.ITEM, GRAY_SHARK_ID, new CuddlyItem(GRAY_SHARK_BLOCK, new Item.Settings().maxCount(1).attributeModifiers(CuddlyItem.createAttributeModifiers()), "block.joy.gray_shark.tooltip"));
		BLAHAJ_ITEM = Registry.register(Registries.ITEM, BLAHAJ_ID, new CuddlyItem(BLAHAJ_BLOCK, new Item.Settings().maxCount(1).attributeModifiers(CuddlyItem.createAttributeModifiers()), "block.joy.blue_shark.tooltip"));
		BLAVINGAD_ITEM = Registry.register(Registries.ITEM, BLAVINGAD_ID, new CuddlyItem(BLAVINGAD_BLOCK, new Item.Settings().maxCount(1).attributeModifiers(CuddlyItem.createAttributeModifiers()), "block.joy.blue_whale.tooltip"));
		BREAD_ITEM = Registry.register(Registries.ITEM, BREAD_ID, new CuddlyItem(BREAD_BLOCK, new Item.Settings().maxCount(1).attributeModifiers(CuddlyItem.createAttributeModifiers()), null));
		BROWN_BEAR_ITEM = Registry.register(Registries.ITEM, BROWN_BEAR_ID, new CuddlyItem(BROWN_BEAR_BLOCK, new Item.Settings().maxCount(1).attributeModifiers(CuddlyItem.createAttributeModifiers()), "block.joy.brown_bear.tooltip"));

		for (String name : PRIDE_NAMES) {
			Identifier id = Identifier.of(Blahaj.MOD_ID, name + "_shark");
			Block block = Registry.register(Registries.BLOCK, id, new CuddlyBlock(AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)));
			Item item = Registry.register(Registries.ITEM, id, new CuddlyItem(block, new Item.Settings().maxCount(1).attributeModifiers(CuddlyItem.createAttributeModifiers()), "block.joy.blue_shark.tooltip"));

			PRIDE_BLOCKS.add(block);
			PRIDE_ITEMS.add(item);

		}

/*		ItemGroupEvents.modifyEntriesEvent(ModItemGroups.HAJS).register(entries -> {
			entries.add(new ItemStack(GRAY_SHARK_ITEM));
			entries.add(new ItemStack(BLAHAJ_ITEM));
			entries.add(new ItemStack(BLAVINGAD_ITEM));
			entries.add(new ItemStack(BREAD_ITEM));
			entries.add(new ItemStack(BROWN_BEAR_ITEM));

			for (Item item : PRIDE_ITEMS) {
				entries.add(new ItemStack(item));
			}
		});
	} */

/*	public static void registerClient() {
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), GRAY_SHARK_BLOCK, BLAHAJ_BLOCK, BLAVINGAD_BLOCK, BREAD_BLOCK, BROWN_BEAR_BLOCK);
		for (Block block : PRIDE_BLOCKS) {
			BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
		} */
	}

}
