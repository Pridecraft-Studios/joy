package gay.pridecraft.joy.mixin.minecraft;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import gay.pridecraft.joy.tags.JoyItemTags;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/**
 * @author Ampflower
 * @since 1.0.0
 **/
@Mixin(PlayerEntity.class)
public class MixinPlayerEntity {
    @WrapOperation(
        method = "checkFallFlying",
        at = @At(value = "INVOKE",
            target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
    private static boolean isElytra(ItemStack self, Item ref, Operation<Boolean> operation) {
        if (self.isIn(JoyItemTags.GLIDERS)) {
            return true;
        }
        return operation.call(self, ref);
    }
}
