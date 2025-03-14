package gay.pridecraft.joy.mixin.minecraft;

import net.minecraft.entity.passive.FrogBrain;
import net.minecraft.entity.passive.FrogEntity;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

/**
 * @author Ampflower
 * @since 1.0.0
 **/
@Mixin(FrogBrain.class)
public interface AccessorFrogBrain {
    @Invoker
    static void invokeCoolDownLongJump(FrogEntity frog, Random random) {
        throw new AssertionError();
    }
}
