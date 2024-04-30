package gay.pridecraft.joymod.mixin;

import net.minecraft.client.resource.SplashTextResourceSupplier;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.resource.ResourceManager;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(SplashTextResourceSupplier.class)
public class SplashTextResourceSupplierMixin {
    @Unique
    private static final List<String> AUTHORS = List.of("Wolren", "Blurryface", "Sake", "Ampflower", "Pridecraft Studios", "UnlikePaladin"); //Honestly Wolren should be first as they did... literally all the mod apart from textures

    @Inject(method = "prepare*", at = @At("RETURN"), cancellable = true)
    private void onPrepare(ResourceManager resourceManager, Profiler profiler, CallbackInfoReturnable<List<String>> cir) {
        List<String> splashes = cir.getReturnValue();

        for (String author : AUTHORS) {
            splashes.add("Made by " + author + "!");
        }

        cir.setReturnValue(splashes);
    }
}

//Thanks for helping us so much Wolren, we couldn't have made any of this without you.
