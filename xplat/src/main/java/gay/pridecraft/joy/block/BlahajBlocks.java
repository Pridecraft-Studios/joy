package gay.pridecraft.joy.block;

import gay.pridecraft.joy.Pivot;
import gay.pridecraft.joy.item.CuddlyItem;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class BlahajBlocks {

    public static final Block
        GRAY_SHARK_BLOCK = mkBlock("gray_shark", Blocks.LIGHT_GRAY_WOOL),
        BLAHAJ_BLOCK = mkBlock("blue_shark", Blocks.CYAN_WOOL),
        BLAVINGAD_BLOCK = mkBlock("blue_whale", Blocks.BLUE_WOOL, CuddlyBlock.WHALE_SHAPES),
        BREAD_BLOCK = mkBlock("bread", Blocks.ORANGE_WOOL, CuddlyBlock.BREAD_SHAPES),
        BROWN_BEAR_BLOCK = mkBlock("brown_bear", Blocks.BROWN_WOOL, CuddlyBlock.BEAR_SHAPES);

    public static final Item
        GRAY_SHARK_ITEM = mkItem(GRAY_SHARK_BLOCK),
        BLAHAJ_ITEM = mkItem(BLAHAJ_BLOCK),
        BLAVINGAD_ITEM = mkItem(BLAVINGAD_BLOCK),
        BREAD_ITEM = mkItem(BREAD_BLOCK, null),
        BROWN_BEAR_ITEM = mkItem(BROWN_BEAR_BLOCK);

    private static final List<String> PRIDE_NAMES = List.of(
        "ace", "agender", "aro", "aroace", "bi", "demiboy", "demigirl",
        "demi_r", "demi_s", "enby", "gay", "genderfluid", "genderqueer", "greyrose",
        "grey_r", "grey_s", "intersex", "lesbian", "pan", "poly", "pride", "trans");

    public static final List<Block> PRIDE_BLOCKS;
    public static final List<Item> PRIDE_ITEMS;

    static {
        final var prideBlocks = new ArrayList<Block>();
        final var prideItems = new ArrayList<Item>();

        // Required to be a single-run.
        for (String name : PRIDE_NAMES) {
            String id = (name + "_shark");
            Block block = mkBlock(id, Blocks.WHITE_WOOL);
            Item item = mkItem(block, "block.joy.blue_shark.tooltip");

            prideBlocks.add(block);
            prideItems.add(item);
        }

        PRIDE_BLOCKS = List.copyOf(prideBlocks);
        PRIDE_ITEMS = List.copyOf(prideItems);
    }

    public static void init() {
        /*
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), GRAY_SHARK_BLOCK, BLAHAJ_BLOCK, BLAVINGAD_BLOCK, BREAD_BLOCK, BROWN_BEAR_BLOCK);
		for (Block block : PRIDE_BLOCKS) {
			BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
		} */
    }

    private static Block mkBlock(String id, Block block, Map<Direction, VoxelShape> shapes) {
        return register(id, new CuddlyBlock(AbstractBlock.Settings.copy(block), shapes));
    }

    private static Block mkBlock(String id, Block block) {
        return register(id, new CuddlyBlock(AbstractBlock.Settings.copy(block)));
    }

    private static Item mkItem(Block block) {
        final var id = Registries.BLOCK.getId(block);
        return mkItem(block, "block.joy." + id.getPath() + ".tooltip");
    }

    private static Item mkItem(Block block, String subtitle) {
        final var id = Registries.BLOCK.getId(block);
        return register(id.getPath(), new CuddlyItem(block, new Item.Settings()
            .maxCount(1)
            .attributeModifiers(CuddlyItem.createAttributeModifiers()),
            subtitle));
    }

    private static Block register(String id, Block block) {
        return Pivot.INSTANCE.register(RegistryKeys.BLOCK, id, block);
    }

    private static Item register(String id, Item item) {
        return Pivot.INSTANCE.register(RegistryKeys.ITEM, id, item);
    }

}
