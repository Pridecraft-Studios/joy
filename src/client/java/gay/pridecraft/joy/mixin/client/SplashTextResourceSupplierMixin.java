package gay.pridecraft.joy.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
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
import java.util.List;

@Mixin(SplashTextResourceSupplier.class)
public class SplashTextResourceSupplierMixin {
    @ModifyReturnValue(method = "prepare(Lnet/minecraft/resource/ResourceManager;Lnet/minecraft/util/profiler/Profiler;)Ljava/util/List;", at = @At("RETURN"))
    private List<String> onPrepare(List<String> original) {
        List<String> bdSplash = new ArrayList<>();

        FabricLoader
                .getInstance()
                .getModContainer(Joy.MOD_ID)
                .ifPresent(modContainer ->
                        modContainer
                                .getMetadata()
                                .getAuthors()
                                .forEach(author ->
                                        original.add("Made by " + author.getName() + "!")
                                )
                );

        LocalDateTime now = LocalDateTime.now();

        if (now.getMonth() == Month.MARCH && now.getDayOfMonth() == 18)
            bdSplash.add("Happy Birthday, TheClashFruit!");

        if (now.getMonth() == Month.SEPTEMBER && now.getDayOfMonth() == 14)
            bdSplash.add("Happy Birthday, Blurry!");

        if (now.getMonth() == Month.NOVEMBER && now.getDayOfMonth() == 8)
            bdSplash.add("Happy Birthday, Fery!");

        return !bdSplash.isEmpty() ? bdSplash : original;
    }
}

//Thanks for helping us so much Wolren, we couldn't have made any of this without you.
// Answer: Thanks, hope more people will be interested in working on it once we get the first release ;)
