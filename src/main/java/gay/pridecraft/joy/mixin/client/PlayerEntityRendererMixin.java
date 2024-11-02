package gay.pridecraft.joy.mixin.client;

import gay.pridecraft.joy.block.CuddlyItem;
import gay.pridecraft.joy.block.*;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel.ArmPose;
import net.minecraft.util.Hand;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntityRenderer.class)
public class PlayerEntityRendererMixin {
	@Inject(
		method = "getArmPose(Lnet/minecraft/client/network/AbstractClientPlayerEntity;Lnet/minecraft/util/Hand;)Lnet/minecraft/client/render/entity/model/BipedEntityModel$ArmPose;",
		at = @At("TAIL"),
		cancellable = true
	)
	private static void cuddleBlahaj(AbstractClientPlayerEntity player, Hand hand, CallbackInfoReturnable<ArmPose> ci) {
		if(player.getStackInHand(hand).getItem() instanceof CuddlyItem) {
			ci.setReturnValue(ArmPose.CROSSBOW_HOLD);
			ci.cancel();
		}
	}
}
