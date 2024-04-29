package gay.pridecraft.joymod.item;


import gay.pridecraft.joymod.JoyMod;
import gay.pridecraft.joymod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup JOYMOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(JoyMod.MOD_ID, "joymod"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.joymod_group"))
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
                        entries.add(ModItems.PRIDE_SLIME_BALL);
                        entries.add(ModItems.PRIDE_ELYTRA);
                        entries.add(ModItems.THIGH_HIGH_FOX_SPAWN_EGG);
                        entries.add(ModItems.PRIDE_BII_SPAWN_EGG);
                        entries.add(ModItems.PRIDE_AXOLOTL_SPAWN_EGG);
                        entries.add(ModItems.PRIDE_FROG_SPAWN_EGG);
                        entries.add(ModItems.PRIDE_SLIME_SPAWN_EGG);
                        entries.add(ModItems.PRIDE_SNIFFER_SPAWN_EGG);
                    }).build());

    public static void registerItemGroups() {
        // JoyMod.LOGGER.info("Making the gay items in" + JoyMod.MOD_ID, "have a group...");
    }
}
