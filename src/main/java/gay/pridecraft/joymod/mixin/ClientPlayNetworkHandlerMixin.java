package gay.pridecraft.joymod.mixin;

import gay.pridecraft.joymod.item.ModItems;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientPlayNetworkHandler.class)
public class ClientPlayNetworkHandlerMixin {

    @Inject(at = @At("HEAD"), method = "getActiveTotemOfUndying", cancellable = true)
    private static void modifyTotemOfUndyingAnimation(PlayerEntity player, CallbackInfoReturnable<ItemStack> cir) {
        for(Hand hand : Hand.values()) {
            ItemStack itemStack = player.getStackInHand(hand);
            if (itemStack.isOf(ModItems.TOTEM_OF_PRIDE)) {
                cir.setReturnValue(itemStack);
            }
        }
    }
}
