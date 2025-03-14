package gay.pridecraft.joy.tags;

import gay.pridecraft.joy.JoyUtil;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

/**
 * @author Ampflower
 * @since 1.0.0
 **/
public final class JoyBlockTags {
    public static final TagKey<Block>
        PRIDE_DYEABLE = joy("pride_dyeable"),
        PLUSHIES = joy("plushies"),
        SHARKS = joy("sharks");

    private static TagKey<Block> joy(String name) {
        return TagKey.of(RegistryKeys.BLOCK, JoyUtil.id(name));
    }

    private static TagKey<Block> common(String name) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", name));
    }
}
