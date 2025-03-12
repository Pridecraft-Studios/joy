package gay.pridecraft.joy.mixin;

import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.entity.decoration.painting.PaintingVariants;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static gay.pridecraft.joy.registry.JoyPaintings.ACE;
import static gay.pridecraft.joy.registry.JoyPaintings.AGENDER;
import static gay.pridecraft.joy.registry.JoyPaintings.ALLY;
import static gay.pridecraft.joy.registry.JoyPaintings.ARO;
import static gay.pridecraft.joy.registry.JoyPaintings.AROACE;
import static gay.pridecraft.joy.registry.JoyPaintings.BIGENDER;
import static gay.pridecraft.joy.registry.JoyPaintings.BIRB;
import static gay.pridecraft.joy.registry.JoyPaintings.BISEXUAL;
import static gay.pridecraft.joy.registry.JoyPaintings.DEMIROMANTIC;
import static gay.pridecraft.joy.registry.JoyPaintings.DEMISEXUAL;
import static gay.pridecraft.joy.registry.JoyPaintings.ENBY;
import static gay.pridecraft.joy.registry.JoyPaintings.FLOATING_BEES;
import static gay.pridecraft.joy.registry.JoyPaintings.FLOATING_TREES;
import static gay.pridecraft.joy.registry.JoyPaintings.INTERSEX;
import static gay.pridecraft.joy.registry.JoyPaintings.LESBIAN;
import static gay.pridecraft.joy.registry.JoyPaintings.MLM;
import static gay.pridecraft.joy.registry.JoyPaintings.PAN;
import static gay.pridecraft.joy.registry.JoyPaintings.POLYSEXUAL;
import static gay.pridecraft.joy.registry.JoyPaintings.PROGRESS;
import static gay.pridecraft.joy.registry.JoyPaintings.QUEER;
import static gay.pridecraft.joy.registry.JoyPaintings.RAINBOW;
import static gay.pridecraft.joy.registry.JoyPaintings.TRANS;

@Mixin(PaintingVariants.class)
public abstract class PaintingVariantsMixin {
    @Shadow
    private static void register(Registerable<PaintingVariant> registry, RegistryKey<PaintingVariant> key, int width, int height) {
    }

    @Inject(method = "bootstrap", at = @At("RETURN"))
    private static void bootstrap(Registerable<PaintingVariant> registry, CallbackInfo ci) {
        register(registry, ACE, 2, 1);
        register(registry, AGENDER, 1, 1);
        register(registry, ALLY, 2, 2);
        register(registry, ARO, 2, 1);
        register(registry, AROACE, 4, 3);
        register(registry, BISEXUAL, 2, 2);
        register(registry, BIGENDER, 1, 1);
        register(registry, BIRB, 2, 2);
        register(registry, DEMIROMANTIC, 2, 2);
        register(registry, DEMISEXUAL, 2, 2);
        register(registry, ENBY, 2, 2);
        register(registry, FLOATING_TREES, 2, 2);
        register(registry, FLOATING_BEES, 2, 2);
        register(registry, INTERSEX, 4, 4);
        register(registry, LESBIAN, 4, 3);
        register(registry, MLM, 1, 1);
        register(registry, PAN, 2, 2);
        register(registry, POLYSEXUAL, 2, 2);
        register(registry, PROGRESS, 4, 4);
        register(registry, QUEER, 1, 1);
        register(registry, RAINBOW, 2, 2);
        register(registry, TRANS, 2, 2);
    }
}
