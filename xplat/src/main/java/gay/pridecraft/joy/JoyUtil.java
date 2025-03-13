package gay.pridecraft.joy;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import java.util.stream.Stream;

/**
 * @author Ampflower
 * @since 1.0.0
 **/
public final class JoyUtil {
    public static final String id = "joy";

    private JoyUtil() {
    }

    public static Identifier id(String name) {
        return Identifier.of(id, name);
    }

    public static Stream<BlockState> streamBlockStates(Block block) {
        return block.getStateManager().getStates().stream();
    }

    public static <T> RegistryEntry<T> getEntry(RegistryKey<T> entry) {
        return Pivot.getRegistry(entry.getRegistryRef()).entryOf(entry);
    }
}
