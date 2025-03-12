package gay.pridecraft.joy.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import gay.pridecraft.joy.client.SplashUtil;
import net.minecraft.client.gui.screen.SplashTextRenderer;
import net.minecraft.client.resource.SplashTextResourceSupplier;
import net.minecraft.resource.ResourceManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(SplashTextResourceSupplier.class)
public class SplashTextResourceSupplierMixin {
    @ModifyReturnValue(method = "prepare", at = @At("RETURN"))
    private List<String> onPrepare(List<String> original, @Local(argsOnly = true) ResourceManager resourceManager) {
        original.addAll(SplashUtil.prepare(resourceManager));

        return original;
    }

    @Inject(method = "get", at = @At("HEAD"), cancellable = true)
    private void onGet(CallbackInfoReturnable<SplashTextRenderer> ci) {
        String birthday = SplashUtil.getBirthday(.5);

        if (birthday != null) {
            ci.setReturnValue(new SplashTextRenderer(birthday));
        }
    }
}

//Thanks for helping us so much Wolren, we couldn't have made any of this without you.
// Answer: Thanks, hope more people will be interested in working on it once we get the first release ;)
