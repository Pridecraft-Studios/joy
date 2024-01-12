package gay.pridecraft.pridemod.item;

import gay.pridecraft.pridemod.PrideMod;
import gay.pridecraft.pridemod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup BEDS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(PrideMod.MOD_ID, "pridebeds"),
            FabricItemGroup.builder().displayName(Text.translatable("pridebeds.pridemod"))
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

    public static final ItemGroup FLAGS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(PrideMod.MOD_ID, "prideflags"),
            FabricItemGroup.builder().displayName(Text.translatable("prideflags.pridemod"))
                    .icon(() -> new ItemStack(Items.WHITE_BANNER)).entries((displayContext, entries) -> {

                        entries.add(Items.DIRT);

                    }).build());

    public static final ItemGroup ENTITIES_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(PrideMod.MOD_ID, "pridemobs"),
            FabricItemGroup.builder().displayName(Text.translatable("pridemobs.pridemod"))
                    .icon(() -> new ItemStack(Items.BEE_SPAWN_EGG)).entries((displayContext, entries) -> {

                        entries.add(Items.DIRT);

                    }).build());

    public static final ItemGroup BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(PrideMod.MOD_ID, "prideblocks"),
            FabricItemGroup.builder().displayName(Text.translatable("prideblocks.pridemod"))
                    .icon(() -> new ItemStack(Items.WHITE_WOOL)).entries((displayContext, entries) -> {

                        entries.add(Items.DIRT);

                    }).build());

    public static final ItemGroup PAINTINGS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(PrideMod.MOD_ID, "pridepaintings"),
            FabricItemGroup.builder().displayName(Text.translatable("pridepaintings.pridemod"))
                    .icon(() -> new ItemStack(Items.PAINTING)).entries((displayContext, entries) -> {

                        entries.add(Items.DIRT);

                    }).build());

    public static final ItemGroup MISC_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(PrideMod.MOD_ID, "miscpride"),
            FabricItemGroup.builder().displayName(Text.translatable("miscitemgroup.pridemod"))
                    .icon(() -> new ItemStack(Items.DEBUG_STICK)).entries((displayContext, entries) -> {

                        entries.add(Items.DIRT);

                    }).build());

    public static void registerItemGroups() {
        // PrideMod.LOGGER.info("Making the gay items in" + PrideMod.MOD_ID, "have a group...");
    }
}
