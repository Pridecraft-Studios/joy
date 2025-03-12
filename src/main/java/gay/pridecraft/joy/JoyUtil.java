package gay.pridecraft.joy;

import net.minecraft.util.Identifier;

/**
 * @author Ampflower
 * @since 1.0.0
 **/
public final class JoyUtil {
    public static Identifier id(String name) {
        return Identifier.of(Joy.MOD_ID, name);
    }
}
