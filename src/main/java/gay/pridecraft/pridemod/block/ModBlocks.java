package gay.pridecraft.pridemod.block;

import gay.pridecraft.pridemod.PrideMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block ULTIMATER_ULTIMATE_GAY = registerBlock("ultimater_ultimate_gay",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK).sounds(BlockSoundGroup.WOOL)));





    private static Block registerBlock(String name, Block block) {

        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(PrideMod.MOD_ID, name), block);

    }
    private static Item registerBlockItem(String name, Block block) {

        return Registry.register(Registries.ITEM, new Identifier(PrideMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));

    }


    public static void registerModBlocks() {
        PrideMod.LOGGER.info("Adding gay blocks from" + PrideMod.MOD_ID);
    }


}
