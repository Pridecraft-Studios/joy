package gay.pridecraft.joy.item;

import gay.pridecraft.joy.Joy;
import gay.pridecraft.joy.block.ModBlocks;
import gay.pridecraft.joy.block.BlahajBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static gay.pridecraft.joy.block.BlahajBlocks.PRIDE_ITEMS;

public class ModItemGroups {
    public static final ItemGroup JOY_BEDS =  Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Joy.MOD_ID, "joy"),FabricItemGroup.builder().displayName(Text.translatable("itemgroup.joy_beds_group"))
                    .icon(() -> new ItemStack(ModBlocks.GAY_BED)).entries((displayContext, entries) -> {

                        entries.add(ModBlocks.GAY_BED);
                        entries.add(ModBlocks.ENBY_BED);
                        entries.add(ModBlocks.INTERSEX_BED);
                        entries.add(ModBlocks.AGENDER_BED);
                        entries.add(ModBlocks.BIGENDER_BED);
                        entries.add(ModBlocks.BISEXUAL_BED);
                        entries.add(ModBlocks.MLM_BED);
                        entries.add(ModBlocks.ACE_BED);
                        entries.add(ModBlocks.ARO_BED);
                        entries.add(ModBlocks.APLATONIC_BED);
                        entries.add(ModBlocks.GENDER_FLUID_BED);
                        entries.add(ModBlocks.PAN_BED);
                        entries.add(ModBlocks.TRANS_BED);
                        entries.add(ModBlocks.AROACE_BED);
                        entries.add(ModBlocks.LESBIAN_BED);
                        entries.add(ModBlocks.PROGRESS_BED);

                    }).build());

    public static final ItemGroup JOY_CANDLES =  Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Joy.MOD_ID, "joy_candles"),FabricItemGroup.builder().displayName(Text.translatable("itemgroup.joy_candles_group"))
                    .icon(() -> new ItemStack(ModBlocks.GAY_CANDLE)).entries((displayContext, entries) -> {

                        entries.add(ModBlocks.QUEER_CANDLE);
                        entries.add(ModBlocks.GAY_CANDLE);
                        entries.add(ModBlocks.ENBY_CANDLE);
                        entries.add(ModBlocks.INTERSEX_CANDLE);
                        entries.add(ModBlocks.AGENDER_CANDLE);
                        entries.add(ModBlocks.BIGENDER_CANDLE);
                        entries.add(ModBlocks.BISEXUAL_CANDLE);
                        entries.add(ModBlocks.MLM_CANDLE);
                        entries.add(ModBlocks.ACE_CANDLE);
                        entries.add(ModBlocks.ARO_CANDLE);
                        entries.add(ModBlocks.APLATONIC_CANDLE);
                        entries.add(ModBlocks.GENDER_FLUID_CANDLE);
                        entries.add(ModBlocks.PAN_CANDLE);
                        entries.add(ModBlocks.TRANS_CANDLE);
                        entries.add(ModBlocks.AROACE_CANDLE);
                        entries.add(ModBlocks.LESBIAN_CANDLE);
                        entries.add(ModBlocks.PROGRESS_CANDLE);

                    }).build());
    public static final ItemGroup JOY_ENTITIES =  Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Joy.MOD_ID, "joy_entities"),FabricItemGroup.builder().displayName(Text.translatable("itemgroup.joy_entities_group"))
                    .icon(() -> new ItemStack(Blocks.BEEHIVE)).entries((displayContext, entries) -> {

                        entries.add(ModItems.SOCK_FOX_SPAWN_EGG);
                        entries.add(ModItems.BII_SPAWN_EGG);
                        entries.add(ModItems.ENBEE_SPAWN_EGG);
                        entries.add(ModItems.TRANS_BEE_SPAWN_EGG);
                        entries.add(ModItems.TREE_SPAWN_EGG);
                        entries.add(ModItems.FROG_SPAWN_EGG);
                        entries.add(ModItems.SNIFFER_SPAWN_EGG);

                    }).build());
    public static final ItemGroup HAJS =  Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Joy.MOD_ID, "hajs"),FabricItemGroup.builder().displayName(Text.translatable("itemgroup.hajs_group"))
                    .icon(() -> new ItemStack(BlahajBlocks.BLAHAJ_BLOCK)).entries((displayContext, entries) -> {

                        entries.add(BlahajBlocks.GRAY_SHARK_ITEM);
                        entries.add(BlahajBlocks.BLAHAJ_ITEM);
                        entries.add(BlahajBlocks.BLAVINGAD_ITEM);
                        entries.add(BlahajBlocks.BREAD_ITEM);
                        entries.add(BlahajBlocks.BROWN_BEAR_ITEM);

                      /*for (Item item : PRIDE_ITEMS) {
                            entries.add(BlahajBlocks.item);         To anyone who feels like figuring this out, pls do i give up
                        } */

                    }).build());

    public static final ItemGroup JOY_BLOCKS =  Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Joy.MOD_ID, "joy_blocks"),FabricItemGroup.builder().displayName(Text.translatable("itemgroup.joy_blocks_group"))
                    .icon(() -> new ItemStack(Blocks.DIRT)).entries((displayContext, entries) -> {

                        entries.add(Blocks.DIRT);

                    }).build());
    public static final ItemGroup JOY_MISC =  Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Joy.MOD_ID, "joy_misc"),FabricItemGroup.builder().displayName(Text.translatable("itemgroup.joy_misc_group"))
                    .icon(() -> new ItemStack(ModItems.PRIDE_BRUSH)).entries((displayContext, entries) -> {

                        entries.add(ModItems.TOTEM_OF_PRIDE);
                        entries.add(ModItems.PRIDE_BRUSH);
                        entries.add(ModItems.PRIDE_ELYTRA);

                    }).build());




    public static void registerItemGroups() {
        // Joy.LOGGER.info("Making the gay items in" + Joy.MOD_ID, "have a group...");
    }
}
