package gay.pridecraft.joy.mixin;

import gay.pridecraft.joy.Joy;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.resource.SplashTextResourceSupplier;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.resource.ResourceManager;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(SplashTextResourceSupplier.class)
public class SplashTextResourceSupplierMixin {
    @Inject(method = "prepare*", at = @At("RETURN"), cancellable = true)
    private void onPrepare(ResourceManager resourceManager, Profiler profiler, CallbackInfoReturnable<List<String>> cir) {
        List<String> splashes = cir.getReturnValue();

        FabricLoader
                .getInstance()
                .getModContainer(Joy.MOD_ID)
                .ifPresent(modContainer ->
                        modContainer
                                .getMetadata()
                                .getAuthors()
                                .forEach(author ->
                                        splashes.add("Made by " + author.getName() + "!")
                                )
                );

        cir.setReturnValue(splashes);
    }
}

//Thanks for helping us so much Wolren, we couldn't have made any of this without you.
// Answer: Thanks, hope more people will be interested in working on it once we get the first release ;)
