package gay.pridecraft.joy.mixin;

import gay.pridecraft.joy.item.ModItems;
import gay.pridecraft.joy.particle.ModParticles;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
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
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientPlayNetworkHandler.class)
public abstract class ClientPlayNetworkHandlerMixin {

    @Shadow
    public abstract ClientWorld getWorld();

    @Inject(at = @At("HEAD"), method = "getActiveTotemOfUndying", cancellable = true)
    private static void modifyTotemOfUndyingAnimation(PlayerEntity player, CallbackInfoReturnable<ItemStack> cir) {
        for (Hand hand : Hand.values()) {
            ItemStack itemStack = player.getStackInHand(hand);
            if (itemStack.isOf(ModItems.TOTEM_OF_PRIDE)) {
                cir.setReturnValue(itemStack);
            }
        }
    }

    @Unique
    private static ItemStack modifyTotem(PlayerEntity player) {
        for (Hand hand : Hand.values()) {
            ItemStack itemStack = player.getStackInHand(hand);
            if (itemStack.isOf(ModItems.TOTEM_OF_PRIDE)) {
                return itemStack;
            }
        }

        return null;
    }

    @Inject(at = @At("HEAD"), method = "onEntityStatus")
    private void onCustomEntityStatus(EntityStatusS2CPacket packet, CallbackInfo ci) {
        if (this.getWorld() != null) {
            Entity entity = packet.getEntity(this.getWorld());
            if (entity != null) {
                int status = packet.getStatus();
                if (status == 36) {
                    MinecraftClient.getInstance().particleManager.addEmitter(entity, ModParticles.TOTEM_OF_PRIDE_PARTICLE, 30);
                    playSound(entity);
                    if (entity == MinecraftClient.getInstance().player) {
                        MinecraftClient.getInstance().gameRenderer.showFloatingItem(modifyTotem(MinecraftClient.getInstance().player));
                    }
                }
            }
        }
    }

    @Unique
    private void playSound(Entity entity) {
        if (MinecraftClient.getInstance().world != null) {
            MinecraftClient.getInstance().world.playSound(entity.getX(), entity.getY(), entity.getZ(), SoundEvents.ITEM_TOTEM_USE, entity.getSoundCategory(), 1.0F, 1.0F, false);
        }
    }
}
