package gay.pridecraft.joy.renderer.feature;

import gay.pridecraft.joy.entity.custom.living.CustomFoxEntity;
import gay.pridecraft.joy.renderer.model.SockFoxEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RotationAxis;

@Environment(EnvType.CLIENT)
public class SockFoxHeldItemFeatureRenderer extends FeatureRenderer<CustomFoxEntity.SockFoxEntity, SockFoxEntityModel<CustomFoxEntity.SockFoxEntity>> {
    private final HeldItemRenderer heldItemRenderer;

    public SockFoxHeldItemFeatureRenderer(FeatureRendererContext<CustomFoxEntity.SockFoxEntity, SockFoxEntityModel<CustomFoxEntity.SockFoxEntity>> context, HeldItemRenderer heldItemRenderer) {
        super(context);
        this.heldItemRenderer = heldItemRenderer;
    }

    public void render(
            MatrixStack matrixStack,
            VertexConsumerProvider vertexConsumerProvider,
            int i,
            CustomFoxEntity.SockFoxEntity foxEntity,
            float f,
            float g,
            float h,
            float j,
            float k,
            float l
    ) {
        boolean bl = foxEntity.isSleeping();
        boolean bl2 = foxEntity.isBaby();
        matrixStack.push();
        if (bl2) {
            float m = 0.75F;
            matrixStack.scale(0.75F, 0.75F, 0.75F);
            matrixStack.translate(0.0F, 0.5F, 0.209375F);
        }

        matrixStack.translate(
                this.getContextModel().head.pivotX / 16.0F, this.getContextModel().head.pivotY / 16.0F, this.getContextModel().head.pivotZ / 16.0F
        );
        float m = foxEntity.getHeadRoll(h);
        matrixStack.multiply(RotationAxis.POSITIVE_Z.rotation(m));
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(k));
        matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(l));
        if (foxEntity.isBaby()) {
            if (bl) {
                matrixStack.translate(0.4F, 0.26F, 0.15F);
            } else {
                matrixStack.translate(0.06F, 0.26F, -0.5F);
            }
        } else if (bl) {
            matrixStack.translate(0.46F, 0.26F, 0.22F);
        } else {
            matrixStack.translate(0.06F, 0.27F, -0.5F);
        }

        matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.0F));
        if (bl) {
            matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(90.0F));
        }

        ItemStack itemStack = foxEntity.getEquippedStack(EquipmentSlot.MAINHAND);
        this.heldItemRenderer.renderItem(foxEntity, itemStack, ModelTransformationMode.GROUND, false, matrixStack, vertexConsumerProvider, i);
        matrixStack.pop();
    }
}

