package gay.pridecraft.joy.mixin.client.minecraft;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import gay.pridecraft.joy.tags.JoyItemTags;
import net.minecraft.client.render.entity.feature.CapeFeatureRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/**
 * @author Ampflower
 * @since 1.0.0
 **/
@Mixin(CapeFeatureRenderer.class)
public class MixinCapeFeatureRenderer {
    @WrapOperation(
        method = "render",
        at = @At(value = "INVOKE",
            target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
    private static boolean isElytra(ItemStack self, Item ref, Operation<Boolean> operation) {
        if (self.isIn(JoyItemTags.ELYTRA)) {
            return true;
        }
        return operation.call(self, ref);
    }
}
