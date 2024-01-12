package gay.pridecraft.pridemod.block;

import gay.pridecraft.pridemod.PrideMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block GAY_BED = registerBlock("gay_bed",
            new BedBlock(DyeColor.RED, FabricBlockSettings.copyOf(Blocks.RED_BED)));

    public static final Block ENBY_BED = registerBlock("enby_bed",
            new BedBlock(DyeColor.BLACK, FabricBlockSettings.copyOf(Blocks.BLACK_BED)));

    public static final Block INTERSEX_BED = registerBlock("intersex_bed",
            new BedBlock(DyeColor.GREEN, FabricBlockSettings.copyOf(Blocks.GREEN_BED)));

    public static final Block AGENDER_BED = registerBlock("agender_bed",
            new BedBlock(DyeColor.BROWN, FabricBlockSettings.copyOf(Blocks.BROWN_BED)));

    public static final Block BIGENDER_BED = registerBlock("bigender_bed",
            new BedBlock(DyeColor.BLUE, FabricBlockSettings.copyOf(Blocks.BLUE_BED)));

    public static final Block BISEXUAL_BED = registerBlock("bisexual_bed",
            new BedBlock(DyeColor.PURPLE, FabricBlockSettings.copyOf(Blocks.PURPLE_BED)));

    public static final Block MLM_BED = registerBlock("mlm_bed",
            new BedBlock(DyeColor.CYAN, FabricBlockSettings.copyOf(Blocks.CYAN_BED)));

    public static final Block ACE_BED = registerBlock("ace_bed",
            new BedBlock(DyeColor.LIGHT_GRAY, FabricBlockSettings.copyOf(Blocks.LIGHT_GRAY_BED)));

    public static final Block ARO_BED = registerBlock("aro_bed",
            new BedBlock(DyeColor.GRAY, FabricBlockSettings.copyOf(Blocks.GRAY_BED)));

    public static final Block APLATONIC_BED = registerBlock("aplatonic_bed",
            new BedBlock(DyeColor.PINK, FabricBlockSettings.copyOf(Blocks.PINK_BED)));

    public static final Block GENDER_FLUID_BED = registerBlock("gender_fluid_bed",
            new BedBlock(DyeColor.LIME, FabricBlockSettings.copyOf(Blocks.LIME_BED)));

    public static final Block PAN_BED = registerBlock("pan_bed",
            new BedBlock(DyeColor.YELLOW, FabricBlockSettings.copyOf(Blocks.YELLOW_BED)));

    public static final Block TRANS_BED = registerBlock("trans_bed",
            new BedBlock(DyeColor.LIGHT_BLUE, FabricBlockSettings.copyOf(Blocks.LIGHT_BLUE_BED)));

    public static final Block AROACE_BED = registerBlock("aroace_bed",
            new BedBlock(DyeColor.MAGENTA, FabricBlockSettings.copyOf(Blocks.MAGENTA_BED)));

    public static final Block LESBIAN_BED = registerBlock("lesbian_bed",
            new BedBlock(DyeColor.ORANGE, FabricBlockSettings.copyOf(Blocks.ORANGE_BED)));

    public static final Block PROGRESS_BED = registerBlock("progress_bed",
            new BedBlock(DyeColor.WHITE, FabricBlockSettings.copyOf(Blocks.WHITE_BED)));

    private static Block registerBlock(String name, Block block) {

        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(PrideMod.MOD_ID, name), block);

    }
    private static Item registerBlockItem(String name, Block block) {

        return Registry.register(Registries.ITEM, new Identifier(PrideMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));

    }


    public static void registerModBlocks() {
        // PrideMod.LOGGER.info("Adding gay blocks from" + PrideMod.MOD_ID);
    }


}
