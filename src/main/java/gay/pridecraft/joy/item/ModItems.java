package gay.pridecraft.joy.item;


import gay.pridecraft.joy.entity.ModEntities;
import gay.pridecraft.joy.item.custom.CustomElytraItem;
import gay.pridecraft.joy.item.custom.CustomSpawnEggItem;
import net.minecraft.item.BrushItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import static gay.pridecraft.joy.Joy.*;

public class ModItems {

    public static final Item PRIDE_ELYTRA = registerItem("pride_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1)));

    public static final Item TOTEM_OF_PRIDE = registerItem("totem_of_pride",
            new Item(new Item.Settings().maxCount(1)));
    public static final Item PRIDE_BRUSH = registerItem("pride_brush", new BrushItem(new Item.Settings()));
    public static final Item SOCK_FOX_SPAWN_EGG = registerItem("sock_fox_spawn_egg", new CustomSpawnEggItem(ModEntities.SOCK_FOX, 14005919, 0xff80bf, new Item.Settings()));
    public static final Item BII_SPAWN_EGG = registerItem("bii_spawn_egg", new CustomSpawnEggItem(ModEntities.BII, 15582019, 0xFF69B4, new Item.Settings()));
    public static final Item ENBEE_SPAWN_EGG = registerItem("enbee_spawn_egg", new CustomSpawnEggItem(ModEntities.ENBEE, 16577588, 0x9C59D1, new Item.Settings()));
    public static final Item TRANS_BEE_SPAWN_EGG = registerItem("trans_bee_spawn_egg", new CustomSpawnEggItem(ModEntities.TRANS_BEE, 49963900, 0x48B518, new Item.Settings()));
    public static final Item TREE_SPAWN_EGG = registerItem("tree_spawn_egg", new CustomSpawnEggItem(ModEntities.TREE, 16577588, 0x9C59D1, new Item.Settings()));
    public static final Item FROG_SPAWN_EGG = registerItem("frog_spawn_egg", new CustomSpawnEggItem(ModEntities.FROG, 13661252, 0xff80bf, new Item.Settings()));
    public static final Item SNIFFER_SPAWN_EGG = registerItem("sniffer_spawn_egg", new CustomSpawnEggItem(ModEntities.SNIFFER, 8855049, 0xff80bf, new Item.Settings()));
    // Test disc item that can be used as template in case someone wants to create one. Note: it's not added to any item group, only obtainable via commands.
    public static final Item TEST_DISC = registerItem("test_disc", new Item(new Item.Settings().maxCount(1).rarity(Rarity.RARE).jukeboxPlayable(RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(MOD_ID, "douglas")))));
    public static final Item TEST_DISK = registerItem("test_disk", new Item(new Item.Settings().maxCount(1).rarity(Rarity.RARE).jukeboxPlayable(RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(MOD_ID, "melancolie")))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MOD_ID, name), item);
    }

    public static void registerModItems() {
        // Joy.LOGGER.info("Making the gay items from" + Joy.MOD_ID);
    }
}

