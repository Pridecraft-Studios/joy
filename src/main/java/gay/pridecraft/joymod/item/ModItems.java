package gay.pridecraft.joymod.item;


import gay.pridecraft.joymod.JoyMod;
import gay.pridecraft.joymod.entity.ModEntities;
import gay.pridecraft.joymod.item.custom.CustomElytraItem;
import gay.pridecraft.joymod.item.custom.RainbowSpawnEggItem;
import net.minecraft.item.BrushItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item PRIDE_ELYTRA = registerItem("pride_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1)));

    public static final Item TOTEM_OF_PRIDE = registerItem("totem_of_pride",
            new Item(new Item.Settings().maxCount(1)));
    public static final Item PRIDE_BRUSH = registerItem("pride_brush", new BrushItem(new Item.Settings()));
    public static final Item PRIDE_SLIME_BALL = registerItem("pride_slime_ball", new Item(new Item.Settings()));
    public static final Item THIGH_HIGH_FOX_SPAWN_EGG = registerItem("thigh_high_fox_spawn_egg", new RainbowSpawnEggItem(ModEntities.THIGH_HIGH_FOX, 14005919, 0xff80bf, new Item.Settings()));
    public static final Item PRIDE_BII_SPAWN_EGG = registerItem("pride_bii_spawn_egg", new RainbowSpawnEggItem(ModEntities.PRIDE_BII, 15582019, 0xFF69B4, new Item.Settings()));
    public static final Item PRIDE_AXOLOTL_SPAWN_EGG = registerItem("pride_axolotl_spawn_egg", new RainbowSpawnEggItem(ModEntities.PRIDE_AXOLOTL, 16499171, 0xff80bf, new Item.Settings()));
    public static final Item PRIDE_FROG_SPAWN_EGG = registerItem("pride_frog_spawn_egg", new RainbowSpawnEggItem(ModEntities.PRIDE_FROG, 13661252, 0xff80bf, new Item.Settings()));
    public static final Item PRIDE_SLIME_SPAWN_EGG = registerItem("pride_slime_spawn_egg", new RainbowSpawnEggItem(ModEntities.PRIDE_SLIME, 5349438, 0xff80bf, new Item.Settings()));
    public static final Item PRIDE_SNIFFER_SPAWN_EGG = registerItem("pride_sniffer_spawn_egg", new RainbowSpawnEggItem(ModEntities.PRIDE_SNIFFER, 8855049, 0xff80bf, new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(JoyMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        // JoyMod.LOGGER.info("Making the gay items from" + JoyMod.MOD_ID);
    }
}

