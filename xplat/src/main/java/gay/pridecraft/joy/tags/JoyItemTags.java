package gay.pridecraft.joy.tags;

import gay.pridecraft.joy.JoyUtil;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

/**
 * @author Ampflower
 * @since 1.0.0
 **/
public final class JoyItemTags {
    public static final TagKey<Item>
        GLIDERS = common("gliders"),
        ELYTRA = common("elytra"),
        TOTEM_OF_UNDYING = common("totem_of_undying");

    public static final TagKey<Item>
        PLUSHIES = joy("plushies"),
        SHARKS = joy("sharks");

    private static TagKey<Item> joy(String name) {
        return TagKey.of(RegistryKeys.ITEM, JoyUtil.id(name));
    }

    private static TagKey<Item> common(String name) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of("c", name));
    }
}
