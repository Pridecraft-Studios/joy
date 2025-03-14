package gay.pridecraft.joy.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import gay.pridecraft.joy.misc.ParticleEmitter;
import gay.pridecraft.joy.tags.JoyItemTags;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ClientPlayNetworkHandler.class)
public abstract class ClientPlayNetworkHandlerMixin {

    @WrapOperation(method = "getActiveTotemOfUndying", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
    private static boolean modifyTotemOfUndyingAnimation(ItemStack instance, Item item, Operation<Boolean> original) {
        return instance.isIn(JoyItemTags.TOTEM_OF_UNDYING) || original.call(instance, item);
    }

    @ModifyArg(method = "onEntityStatus",
        at = @At(value = "INVOKE",
            target = "Lnet/minecraft/client/particle/ParticleManager;addEmitter(Lnet/minecraft/entity/Entity;Lnet/minecraft/particle/ParticleEffect;I)V"))
    private ParticleEffect changeTotemParticle(Entity entity, ParticleEffect original, int maxAge) {
        if (entity instanceof LivingEntity living &&
            getActiveTotemOfUndying(living).getItem() instanceof ParticleEmitter emitter) {
            return emitter.joy$getEffect();
        }
        return original;
    }

    @Unique
    private static ItemStack getActiveTotemOfUndying(LivingEntity player) {
        for (Hand hand : Hand.values()) {
            ItemStack itemStack = player.getStackInHand(hand);
            if (itemStack.isIn(JoyItemTags.TOTEM_OF_UNDYING)) {
                return itemStack;
            }
        }

        return ItemStack.EMPTY;
    }
}
