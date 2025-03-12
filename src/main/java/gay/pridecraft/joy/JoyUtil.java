package gay.pridecraft.joy;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

/**
 * @author Ampflower
 * @since 1.0.0
 **/
public final class JoyUtil {
    public static final ModContainer joyContainer =
            FabricLoader.getInstance().getModContainer(Joy.MOD_ID).orElseThrow();

    public static Identifier id(String name) {
        return Identifier.of(Joy.MOD_ID, name);
    }

    public static void registerEnabledPack(String name, Text text) {
        registerPack(name, text, ResourcePackActivationType.DEFAULT_ENABLED);
    }

    public static void registerPack(String name, Text text) {
        registerPack(name, text, ResourcePackActivationType.NORMAL);
    }

    public static void registerPack(String name, Text text, ResourcePackActivationType type) {
        ResourceManagerHelper.registerBuiltinResourcePack(JoyUtil.id(name), joyContainer, text, type);
    }
}
