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
                    .icon(() -> new ItemStack(Items.WHITE_BED)).entries((displayContext, entries) -> {

                        entries.add(Items.DIRT);

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

                        entries.add(ModBlocks.ULTIMATER_ULTIMATE_GAY);

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
                    .icon(() -> new ItemStack(Items.PAINTING)).entries((displayContext, entries) -> {

                        entries.add(Items.DIRT);

                    }).build());
    
    public static void registerItemGroups() {
        PrideMod.LOGGER.info("Making the gay items in" + PrideMod.MOD_ID, "have a group...");
    }






}
