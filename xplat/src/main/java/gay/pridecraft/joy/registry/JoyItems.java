package gay.pridecraft.joy.registry;


import gay.pridecraft.joy.JoyUtil;
import gay.pridecraft.joy.Pivot;
import gay.pridecraft.joy.item.CustomElytraItem;
import gay.pridecraft.joy.item.ParticleEmittingItem;
import gay.pridecraft.joy.item.PrideDyeItem;
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
        new ParticleEmittingItem(new Item.Settings().maxCount(1), JoyParticles.TOTEM_OF_PRIDE_PARTICLE)
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
        GENDER_FLUID_BUNDLE = registerBundle("genderfluid_bundle"),
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

    // region dyes

    public static final Item
        QUEER_DYE = registerDye("queer_dye"),
        GAY_DYE = registerDye("gay_dye"),
        ENBY_DYE = registerDye("enby_dye"),
        INTERSEX_DYE = registerDye("intersex_dye"),
        AGENDER_DYE = registerDye("agender_dye"),
        BIGENDER_DYE = registerDye("bigender_dye"),
        BISEXUAL_DYE = registerDye("bisexual_dye"),
        MLM_DYE = registerDye("mlm_dye"),
        ARO_DYE = registerDye("aro_dye"),
        ACE_DYE = registerDye("ace_dye"),
        APLATONIC_DYE = registerDye("aplatonic_dye"),
        DEMIROMANTIC_DYE = registerDye("demiromantic_dye"),
        DEMISEXUAL_DYE = registerDye("demisexual_dye"),
        GREYARO_DYE = registerDye("greyaro_dye"),
        GREYACE_DYE = registerDye("greyace_dye"),
        GREYROSE_DYE = registerDye("greyrose_dye"),
        GENDERFLUID_DYE = registerDye("genderfluid_dye"),
        GENDERQUEER_DYE = registerDye("genderqueer_dye"),
        PAN_DYE = registerDye("pan_dye"),
        TRANS_DYE = registerDye("trans_dye"),
        AROACE_DYE = registerDye("aroace_dye"),
        LESBIAN_DYE = registerDye("lesbian_dye"),
        PROGRESS_DYE = registerDye("progress_dye"),
        PLURAL_DYE = registerDye("plural_dye"),
        POLYAM_DYE = registerDye("polyam_dye");

    public static final List<Item> PRIDE_DYES = List.of(
        QUEER_DYE,
        GAY_DYE,
        ENBY_DYE,
        INTERSEX_DYE,
        AGENDER_DYE,
        BIGENDER_DYE,
        BISEXUAL_DYE,
        MLM_DYE,
        ACE_DYE,
        ARO_DYE,
        APLATONIC_DYE,
        DEMIROMANTIC_DYE,
        DEMISEXUAL_DYE,
        GREYARO_DYE,
        GREYACE_DYE,
        GREYROSE_DYE,
        GENDERFLUID_DYE,
        GENDERQUEER_DYE,
        PAN_DYE,
        TRANS_DYE,
        AROACE_DYE,
        LESBIAN_DYE,
        PROGRESS_DYE,
        PLURAL_DYE,
        POLYAM_DYE
    );

    private static Item registerDye(String name) {
        return registerItem(name, new PrideDyeItem(new Item.Settings()));
    }

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

