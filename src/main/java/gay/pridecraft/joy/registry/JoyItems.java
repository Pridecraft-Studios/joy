package gay.pridecraft.joy.registry;


import gay.pridecraft.joy.item.CustomElytraItem;
import net.minecraft.item.BrushItem;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import static gay.pridecraft.joy.Joy.*;

public class JoyItems {
    public static final Item PRIDE_ELYTRA = registerItem(
            "pride_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1))
    );

    public static final Item TOTEM_OF_PRIDE = registerItem(
            "totem_of_pride",
            new Item(new Item.Settings().maxCount(1))
    );

    public static final Item PRIDE_BRUSH = registerItem(
            "pride_brush",
            new BrushItem(new Item.Settings())
    );

    // region Spawn Eggs
    public static final Item SOCK_FOX_SPAWN_EGG = registerItem(
            "sock_fox_spawn_egg",
            new SpawnEggItem(
                    JoyEntities.SOCK_FOX, 0xd5b69f, 0xff80bf, new Item.Settings())
    );

    public static final Item BII_SPAWN_EGG = registerItem(
            "bii_spawn_egg",
            new SpawnEggItem(
                    JoyEntities.BII, 0xedc343, 0xFF69B4, new Item.Settings())
    );

    public static final Item ENBEE_SPAWN_EGG = registerItem(
            "enbee_spawn_egg",
            new SpawnEggItem(
                    JoyEntities.ENBEE, 0xfcf434, 0x9C59D1, new Item.Settings())
    );

    public static final Item TRANS_BEE_SPAWN_EGG = registerItem(
            "trans_bee_spawn_egg",
            new SpawnEggItem(
                    JoyEntities.TRANS_BEE, 0x2fa637c, 0x48B518, new Item.Settings())
    );

    public static final Item TREE_SPAWN_EGG = registerItem(
            "tree_spawn_egg",
            new SpawnEggItem(
                    JoyEntities.TREE, 0xfcf434, 0x9C59D1, new Item.Settings())
    );

    public static final Item FROG_SPAWN_EGG = registerItem(
            "frog_spawn_egg",
            new SpawnEggItem(
                    JoyEntities.FROG, 0xd07444, 0xff80bf, new Item.Settings())
    );

    public static final Item SNIFFER_SPAWN_EGG = registerItem(
            "sniffer_spawn_egg",
            new SpawnEggItem(
                    JoyEntities.SNIFFER, 0x871E09, 0xFF80BF, new Item.Settings())
    );
    // endregion

    // Test disc item that can be used as template in case someone wants to create one. Note: it's not added to any item group, only obtainable via commands.
    public static final Item TEST_DISC = registerItem("test_disc", new Item(new Item.Settings().maxCount(1).rarity(Rarity.RARE).jukeboxPlayable(RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(MOD_ID, "douglas")))));
    public static final Item TEST_DISK = registerItem("test_disk", new Item(new Item.Settings().maxCount(1).rarity(Rarity.RARE).jukeboxPlayable(RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(MOD_ID, "melancolie")))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MOD_ID, name), item);
    }

    /**
     * Workaround to force classloading
     */
    public static void init() {
        // NO-OP
    }
}

