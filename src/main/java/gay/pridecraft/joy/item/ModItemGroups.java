package gay.pridecraft.joy.item;

import gay.pridecraft.joy.Joy;
import gay.pridecraft.joy.registry.JoyBlocks;
import gay.pridecraft.joy.block.BlahajBlocks;
import gay.pridecraft.joy.registry.JoyItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static gay.pridecraft.joy.block.BlahajBlocks.*;

public class ModItemGroups {
    public static final ItemGroup JOY_BEDS =  Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Joy.MOD_ID, "joy"),FabricItemGroup.builder().displayName(Text.translatable("itemgroup.joy_beds_group"))
                    .icon(() -> new ItemStack(JoyBlocks.GAY_BED)).entries((displayContext, entries) -> {

                        entries.add(JoyBlocks.GAY_BED);
                        entries.add(JoyBlocks.ENBY_BED);
                        entries.add(JoyBlocks.INTERSEX_BED);
                        entries.add(JoyBlocks.AGENDER_BED);
                        entries.add(JoyBlocks.BIGENDER_BED);
                        entries.add(JoyBlocks.BISEXUAL_BED);
                        entries.add(JoyBlocks.MLM_BED);
                        entries.add(JoyBlocks.ACE_BED);
                        entries.add(JoyBlocks.ARO_BED);
                        entries.add(JoyBlocks.APLATONIC_BED);
                        entries.add(JoyBlocks.GENDER_FLUID_BED);
                        entries.add(JoyBlocks.PAN_BED);
                        entries.add(JoyBlocks.TRANS_BED);
                        entries.add(JoyBlocks.AROACE_BED);
                        entries.add(JoyBlocks.LESBIAN_BED);
                        entries.add(JoyBlocks.PROGRESS_BED);

                    }).build());

    public static final ItemGroup JOY_CANDLES =  Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Joy.MOD_ID, "joy_candles"),FabricItemGroup.builder().displayName(Text.translatable("itemgroup.joy_candles_group"))
                    .icon(() -> new ItemStack(JoyBlocks.GAY_CANDLE)).entries((displayContext, entries) -> {

                        entries.add(JoyBlocks.QUEER_CANDLE);
                        entries.add(JoyBlocks.GAY_CANDLE);
                        entries.add(JoyBlocks.ENBY_CANDLE);
                        entries.add(JoyBlocks.INTERSEX_CANDLE);
                        entries.add(JoyBlocks.AGENDER_CANDLE);
                        entries.add(JoyBlocks.BIGENDER_CANDLE);
                        entries.add(JoyBlocks.BISEXUAL_CANDLE);
                        entries.add(JoyBlocks.MLM_CANDLE);
                        entries.add(JoyBlocks.ACE_CANDLE);
                        entries.add(JoyBlocks.ARO_CANDLE);
                        entries.add(JoyBlocks.APLATONIC_CANDLE);
                        entries.add(JoyBlocks.GENDER_FLUID_CANDLE);
                        entries.add(JoyBlocks.PAN_CANDLE);
                        entries.add(JoyBlocks.TRANS_CANDLE);
                        entries.add(JoyBlocks.AROACE_CANDLE);
                        entries.add(JoyBlocks.LESBIAN_CANDLE);
                        entries.add(JoyBlocks.PROGRESS_CANDLE);

                    }).build());
    public static final ItemGroup JOY_ENTITIES =  Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Joy.MOD_ID, "joy_entities"),FabricItemGroup.builder().displayName(Text.translatable("itemgroup.joy_entities_group"))
                    .icon(() -> new ItemStack(Blocks.BEEHIVE)).entries((displayContext, entries) -> {

                        entries.add(JoyItems.SOCK_FOX_SPAWN_EGG);
                        entries.add(JoyItems.BII_SPAWN_EGG);
                        entries.add(JoyItems.ENBEE_SPAWN_EGG);
                        entries.add(JoyItems.TRANS_BEE_SPAWN_EGG);
                        entries.add(JoyItems.TREE_SPAWN_EGG);
                        entries.add(JoyItems.FROG_SPAWN_EGG);
                        entries.add(JoyItems.SNIFFER_SPAWN_EGG);

                    }).build());

//    public static final List<String> PRIDE_NAMES = List.of(
//            "ace", "agender", "aro", "aroace", "bi", "demiboy", "demigirl",
//            "demi_r", "demi_s", "enby", "gay", "genderfluid", "genderqueer", "greyrose",
//            "grey_r", "grey_s", "intersex", "lesbian", "pan", "poly", "pride", "trans"
//    ).stream().distinct().toList();

    public static final ItemGroup HAJS =  Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Joy.MOD_ID, "hajs"),FabricItemGroup.builder().displayName(Text.translatable("itemgroup.hajs_group"))
                    .icon(() -> new ItemStack(BlahajBlocks.BLAHAJ_BLOCK)).entries((displayContext, entries) -> {

                        entries.add(BlahajBlocks.GRAY_SHARK_ITEM);
                        entries.add(BlahajBlocks.BLAHAJ_ITEM);
                        entries.add(BlahajBlocks.BLAVINGAD_ITEM);
                        entries.add(BlahajBlocks.BREAD_ITEM);
                        entries.add(BlahajBlocks.BROWN_BEAR_ITEM);

                        for (Item item : PRIDE_ITEMS) {
                            entries.add(new ItemStack(item));
                        }


                    }).build());

    public static final ItemGroup JOY_BLOCKS =  Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Joy.MOD_ID, "joy_blocks"),FabricItemGroup.builder().displayName(Text.translatable("itemgroup.joy_blocks_group"))
                    .icon(() -> new ItemStack(Blocks.DIRT)).entries((displayContext, entries) -> {

                        entries.add(Blocks.DIRT);

                    }).build());
    public static final ItemGroup JOY_MISC =  Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Joy.MOD_ID, "joy_misc"),FabricItemGroup.builder().displayName(Text.translatable("itemgroup.joy_misc_group"))
                    .icon(() -> new ItemStack(JoyItems.PRIDE_BRUSH)).entries((displayContext, entries) -> {

                        entries.add(JoyItems.TOTEM_OF_PRIDE);
                        entries.add(JoyItems.PRIDE_BRUSH);
                        entries.add(JoyItems.PRIDE_ELYTRA);

                    }).build());




    public static void registerItemGroups() {
        // Joy.LOGGER.info("Making the gay items in" + Joy.MOD_ID, "have a group...");
    }
}
