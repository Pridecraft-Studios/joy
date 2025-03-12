package gay.pridecraft.joy.fabric.client.mixin.self;

import gay.pridecraft.joy.client.SplashUtil;
import gay.pridecraft.joy.fabric.FabricUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author Ampflower
 * @since 1.0.0
 **/
@Mixin(SplashUtil.class)
public class MixinSplashUtil {
    /**
     * @author Ampflower
     * @reason Quick & dirty hack.
     */
    @Overwrite(remap = false)
    private static List<String> makeContributors() {
        final var metadata = FabricUtil.joyContainer.getMetadata();

        final var authors = metadata.getAuthors()
            .stream()
            .map(person -> "Joy, made by " + person.getName() + "!");

        final var contributors = metadata.getContributors()
            .stream()
            .map(person -> "Joy, aided by " + person.getName() + "!");

        return Stream.concat(authors, contributors).toList();
    }
}
