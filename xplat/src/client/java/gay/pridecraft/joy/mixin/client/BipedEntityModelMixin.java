package gay.pridecraft.joy.mixin.client;

import gay.pridecraft.joy.item.CuddlyItem;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BipedEntityModel.class)
public class BipedEntityModelMixin {

	@Shadow
	public @Final ModelPart rightArm;

	@Shadow
	public @Final ModelPart leftArm;

	@Inject(
		method = {"positionRightArm", "positionLeftArm"},
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/client/render/entity/model/CrossbowPosing;hold(Lnet/minecraft/client/model/ModelPart;Lnet/minecraft/client/model/ModelPart;Lnet/minecraft/client/model/ModelPart;Z)V",
			shift = Shift.AFTER
		)
	)
	public void poseArms(LivingEntity entity, CallbackInfo ci) {
        if (!(entity.getMainHandStack().getItem() instanceof CuddlyItem) && !(entity.getOffHandStack().getItem() instanceof CuddlyItem))
            return;

        this.rightArm.pitch = -0.95F;
        this.rightArm.yaw = -MathHelper.PI / 8;

        this.leftArm.pitch = -0.90F;
        this.leftArm.yaw = MathHelper.PI / 8;
    }
}
