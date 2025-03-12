package gay.pridecraft.joy.mixin.client;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import gay.pridecraft.joy.item.CuddlyItem;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel.ArmPose;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PlayerEntityRenderer.class)
public class PlayerEntityRendererMixin {
    @WrapMethod(
            method = "getArmPose(Lnet/minecraft/client/network/AbstractClientPlayerEntity;Lnet/minecraft/util/Hand;)Lnet/minecraft/client/render/entity/model/BipedEntityModel$ArmPose;"
    )
    private static ArmPose cuddleBlahaj(AbstractClientPlayerEntity player, Hand hand, Operation<ArmPose> original) {
        return player.getStackInHand(hand).getItem() instanceof CuddlyItem ? ArmPose.CROSSBOW_HOLD : original.call(player, hand);
    }
}
