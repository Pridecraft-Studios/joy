package gay.pridecraft.joy.item;


import gay.pridecraft.joy.Joy;
import gay.pridecraft.joy.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup JOY_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Joy.MOD_ID, "joy"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.joy_group"))
                    .icon(() -> new ItemStack(ModItems.PRIDE_BRUSH)).entries((displayContext, entries) -> {

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

                        entries.add(ModItems.TOTEM_OF_PRIDE);
                        entries.add(ModItems.PRIDE_BRUSH);
                        entries.add(ModItems.PRIDE_ELYTRA);
                        entries.add(ModItems.SOCK_FOX_SPAWN_EGG);
                        entries.add(ModItems.BII_SPAWN_EGG);
                        entries.add(ModItems.ENBEE_SPAWN_EGG);
                        entries.add(ModItems.TRANS_BEE_SPAWN_EGG);
                        entries.add(ModItems.TREE_SPAWN_EGG);
                        entries.add(ModItems.AXOLOTL_SPAWN_EGG);
                        entries.add(ModItems.FROG_SPAWN_EGG);
                        entries.add(ModItems.SNIFFER_SPAWN_EGG);
                    }).build());

    public static void registerItemGroups() {
        // Joy.LOGGER.info("Making the gay items in" + Joy.MOD_ID, "have a group...");
    }
}
