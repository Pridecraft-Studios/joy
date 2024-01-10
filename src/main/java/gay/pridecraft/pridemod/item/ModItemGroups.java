package gay.pridecraft.pridemod.item;

import gay.pridecraft.pridemod.PrideMod;
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
            new Identifier(PrideMod.MOD_ID, "test"),
            FabricItemGroup.builder().displayName(Text.translatable("pridebeds.pridemod"))
                    .icon(() -> new ItemStack(Items.WHITE_BED)).entries((displayContext, entries) -> {

                        entries.add(Items.DIRT);

                    }).build());

    public static final ItemGroup FLAGS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(PrideMod.MOD_ID, "test2"),
            FabricItemGroup.builder().displayName(Text.translatable("prideflags.pridemod"))
                    .icon(() -> new ItemStack(Items.WHITE_BANNER)).entries((displayContext, entries) -> {

                        entries.add(Items.DIRT);

                    }).build());

    public static final ItemGroup ENTITIES_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(PrideMod.MOD_ID, "test3"),
            FabricItemGroup.builder().displayName(Text.translatable("pridemobs.pridemod"))
                    .icon(() -> new ItemStack(Items.BEE_SPAWN_EGG)).entries((displayContext, entries) -> {

                        entries.add(Items.DIRT);

                    }).build());

    public static void registerItemGroups() {
        PrideMod.LOGGER.info("Making the gay items in" + PrideMod.MOD_ID, "have a group...");
    }






}
