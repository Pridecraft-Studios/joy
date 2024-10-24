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

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Mixin(SplashTextResourceSupplier.class)
public class SplashTextResourceSupplierMixin {
    @Inject(method = "prepare*", at = @At("RETURN"), cancellable = true)
    private void onPrepare(ResourceManager resourceManager, Profiler profiler, CallbackInfoReturnable<List<String>> cir) {
        List<String> splashes = cir.getReturnValue();
        List<String> bdSplash = new ArrayList<>();

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

        LocalDateTime now = LocalDateTime.now();

        if (now.getMonth() == Month.MARCH && now.getDayOfMonth() == 18) {
            bdSplash.add("Happy Birthday, TheClashFruit!");
        }

        if (now.getMonth() == Month.SEPTEMBER && now.getDayOfMonth() == 14) {
            bdSplash.add("Happy Birthday, Blurry!");
        }

        if (now.getMonth() == Month.NOVEMBER && now.getDayOfMonth() == 8) {
            bdSplash.add("Happy Birthday, Fery!");
        }

        if (!bdSplash.isEmpty()) {
            cir.setReturnValue(bdSplash);
        } else {
            cir.setReturnValue(splashes);
        }
    }
}

//Thanks for helping us so much Wolren, we couldn't have made any of this without you.
// Answer: Thanks, hope more people will be interested in working on it once we get the first release ;)
