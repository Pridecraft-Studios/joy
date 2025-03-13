package gay.pridecraft.joy.registry;


import gay.pridecraft.joy.JoyUtil;
import gay.pridecraft.joy.Pivot;
import gay.pridecraft.joy.item.CustomElytraItem;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.BundleContentsComponent;
import net.minecraft.item.BrushItem;
import net.minecraft.item.BundleItem;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Rarity;

import java.util.List;

public final class JoyItems {
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

    // region bundles
    public static final Item
        QUEER_BUNDLE = registerBundle("queer_bundle"),
        GAY_BUNDLE = registerBundle("gay_bundle"),
        ENBY_BUNDLE = registerBundle("enby_bundle"),
        INTERSEX_BUNDLE = registerBundle("intersex_bundle"),
        AGENDER_BUNDLE = registerBundle("agender_bundle"),
        BIGENDER_BUNDLE = registerBundle("bigender_bundle"),
        BISEXUAL_BUNDLE = registerBundle("bisexual_bundle"),
        MLM_BUNDLE = registerBundle("mlm_bundle"),
        ACE_BUNDLE = registerBundle("ace_bundle"),
        ARO_BUNDLE = registerBundle("aro_bundle"),
        APLATONIC_BUNDLE = registerBundle("aplatonic_bundle"),
        GENDER_FLUID_BUNDLE = registerBundle("gender_fluid_bundle"),
        PAN_BUNDLE = registerBundle("pan_bundle"),
        TRANS_BUNDLE = registerBundle("trans_bundle"),
        AROACE_BUNDLE = registerBundle("aroace_bundle"),
        LESBIAN_BUNDLE = registerBundle("lesbian_bundle"),
        PROGRESS_BUNDLE = registerBundle("progress_bundle");

    public static final List<Item> BUNDLES = List.of(
        QUEER_BUNDLE,
        GAY_BUNDLE,
        ENBY_BUNDLE,
        INTERSEX_BUNDLE,
        AGENDER_BUNDLE,
        BIGENDER_BUNDLE,
        BISEXUAL_BUNDLE,
        MLM_BUNDLE,
        ACE_BUNDLE,
        ARO_BUNDLE,
        APLATONIC_BUNDLE,
        GENDER_FLUID_BUNDLE,
        PAN_BUNDLE,
        TRANS_BUNDLE,
        AROACE_BUNDLE,
        LESBIAN_BUNDLE,
        PROGRESS_BUNDLE
    );

    private static Item registerBundle(String name) {
        return registerItem(name, new BundleItem(new Item.Settings()
            .maxCount(1)
            .component(DataComponentTypes.BUNDLE_CONTENTS, BundleContentsComponent.DEFAULT)
        ));
    }

    // endregion

    // region rosette

    public static final Item
        GAY_ROSETTE = registerDummy("gay_rosette"),
        ENBY_ROSETTE = registerDummy("enby_rosette"),
        BISEXUAL_ROSETTE = registerDummy("bisexual_rosette"),
        MLM_ROSETTE = registerDummy("mlm_rosette"),
        ACE_ROSETTE = registerDummy("ace_rosette"),
        ARO_ROSETTE = registerDummy("aro_rosette"),
        PAN_ROSETTE = registerDummy("pan_rosette"),
        TRANS_ROSETTE = registerDummy("trans_rosette"),
        LESBIAN_ROSETTE = registerDummy("lesbian_rosette"),
        PLURAL_ROSETTE = registerDummy("plural_rosette");

    public static final List<Item> ROSETTES = List.of(
        GAY_ROSETTE,
        ENBY_ROSETTE,
        BISEXUAL_ROSETTE,
        MLM_ROSETTE,
        ACE_ROSETTE,
        ARO_ROSETTE,
        PAN_ROSETTE,
        TRANS_ROSETTE,
        LESBIAN_ROSETTE,
        PLURAL_ROSETTE
    );
    // endregion

    // Currently inaccessible, only exists to serve as an example.
    public static final Item
        DOUGLAS_DISC = registerDisc("douglas"),
        MELANCOLIE_DISC = registerDisc("melancolie");

    private static Item registerDisc(String name) {
        return registerItem(name + "_disc", new Item(new Item.Settings()
            .maxCount(1)
            .rarity(Rarity.RARE)
            .jukeboxPlayable(RegistryKey.of(RegistryKeys.JUKEBOX_SONG, JoyUtil.id(name)))
        ));
    }

    private static Item registerDummy(String name) {
        return registerItem(name, new Item(new Item.Settings()));
    }

    private static Item registerItem(String name, Item item) {
        return Pivot.INSTANCE.register(RegistryKeys.ITEM, name, item);
    }

    /**
     * Workaround to force classloading
     */
    public static void init() {
        // NO-OP
    }
}

