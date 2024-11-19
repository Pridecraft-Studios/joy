package gay.pridecraft.joy.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import gay.pridecraft.joy.registry.JoyItems;
import gay.pridecraft.joy.registry.JoyParticles;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.EntityStatusS2CPacket;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public abstract class ClientPlayNetworkHandlerMixin {
    @Shadow
    public abstract ClientWorld getWorld();

    @WrapOperation(method = "getActiveTotemOfUndying", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
    private static boolean modifyTotemOfUndyingAnimation(ItemStack instance, Item item, Operation<Boolean> original) {
        return instance.isOf(JoyItems.TOTEM_OF_PRIDE) || original.call(instance, item);
    }

    @Inject(at = @At("HEAD"), method = "onEntityStatus")
    private void onCustomEntityStatus(EntityStatusS2CPacket packet, CallbackInfo ci) {
        if (this.getWorld() == null) return;
        Entity entity = packet.getEntity(this.getWorld());
        if (entity == null) return;

        int status = packet.getStatus();
        if (status != 36) return;

        MinecraftClient.getInstance().particleManager.addEmitter(entity, JoyParticles.TOTEM_OF_PRIDE_PARTICLE, 30);

        if (MinecraftClient.getInstance().world != null) {
            MinecraftClient.getInstance().world.playSound(entity.getX(), entity.getY(), entity.getZ(), SoundEvents.ITEM_TOTEM_USE, entity.getSoundCategory(), 1.0F, 1.0F, false);
        }

        if (entity == MinecraftClient.getInstance().player)
            MinecraftClient.getInstance().gameRenderer.showFloatingItem(modifyTotem(MinecraftClient.getInstance().player));
    }

    @Unique
    private static ItemStack modifyTotem(PlayerEntity player) {
        for (Hand hand : Hand.values()) {
            ItemStack itemStack = player.getStackInHand(hand);
            if (itemStack.isOf(JoyItems.TOTEM_OF_PRIDE)) {
                return itemStack;
            }
        }

        return null;
    }
}
