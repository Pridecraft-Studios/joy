package gay.pridecraft.joy.item;


import gay.pridecraft.joy.Joy;
import gay.pridecraft.joy.entity.ModEntities;
import gay.pridecraft.joy.item.custom.CustomElytraItem;
import gay.pridecraft.joy.item.custom.RainbowSpawnEggItem;
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
    public static final Item SOCK_FOX_SPAWN_EGG = registerItem("thigh_high_fox_spawn_egg", new RainbowSpawnEggItem(ModEntities.SOCK_FOX, 14005919, 0xff80bf, new Item.Settings()));
    public static final Item BII_SPAWN_EGG = registerItem("bii_spawn_egg", new RainbowSpawnEggItem(ModEntities.BII, 15582019, 0xFF69B4, new Item.Settings()));
    public static final Item ENBEE_SPAWN_EGG = registerItem("bii_spawn_egg", new RainbowSpawnEggItem(ModEntities.ENBEE, 16577588, 0x9C59D1, new Item.Settings()));
    public static final Item TREE_SPAWN_EGG = registerItem("tree_spawn_egg", new RainbowSpawnEggItem(ModEntities.TRANS_BEE, 16577588, 0x9C59D1, new Item.Settings()));
    public static final Item PRIDE_AXOLOTL_SPAWN_EGG = registerItem("pride_axolotl_spawn_egg", new RainbowSpawnEggItem(ModEntities.AXOLOTL, 16499171, 0xff80bf, new Item.Settings()));
    public static final Item PRIDE_FROG_SPAWN_EGG = registerItem("pride_frog_spawn_egg", new RainbowSpawnEggItem(ModEntities.FROG, 13661252, 0xff80bf, new Item.Settings()));
    public static final Item PRIDE_SNIFFER_SPAWN_EGG = registerItem("pride_sniffer_spawn_egg", new RainbowSpawnEggItem(ModEntities.SNIFFER, 8855049, 0xff80bf, new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Joy.MOD_ID, name), item);
    }

    public static void registerModItems() {
        // Joy.LOGGER.info("Making the gay items from" + Joy.MOD_ID);
    }
}

