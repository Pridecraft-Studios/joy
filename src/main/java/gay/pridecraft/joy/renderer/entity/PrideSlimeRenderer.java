package gay.pridecraft.joy.renderer.entity;

import gay.pridecraft.joy.Joy;
import gay.pridecraft.joy.entity.custom.living.CustomSlimeEntity;
import gay.pridecraft.joy.renderer.feature.PrideSlimeOverlayFeatureRenderer;
import gay.pridecraft.joy.renderer.model.PrideSlimeEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class PrideSlimeRenderer extends MobEntityRenderer<CustomSlimeEntity.PrideSlimeEntity, PrideSlimeEntityModel<CustomSlimeEntity.PrideSlimeEntity>> {
    private static final Identifier TEXTURE = Identifier.of(Joy.MOD_ID, "textures/entity/slime/pride_slime.png");

    public PrideSlimeRenderer(EntityRendererFactory.Context context) {
        super(context, new PrideSlimeEntityModel<>(context.getPart(EntityModelLayers.SLIME)), 0.25F);
        this.addFeature(new PrideSlimeOverlayFeatureRenderer<>(this, context.getModelLoader()));
    }

    @Override
    public Identifier getTexture(CustomSlimeEntity.PrideSlimeEntity entity) {
        return TEXTURE;
    }

    public void render(CustomSlimeEntity.PrideSlimeEntity slimeEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        this.shadowRadius = 0.25F * (float)slimeEntity.getSize();
        super.render(slimeEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    protected void scale(CustomSlimeEntity.PrideSlimeEntity slimeEntity, MatrixStack matrixStack, float f) {
        float g = 0.999F;
        matrixStack.scale(0.999F, 0.999F, 0.999F);
        matrixStack.translate(0.0F, 0.001F, 0.0F);
        float h = (float) slimeEntity.getSize();
        float i = MathHelper.lerp(f, slimeEntity.lastStretch, slimeEntity.stretch) / (h * 0.5F + 1.0F);
        float j = 1.0F / (i + 1.0F);
        matrixStack.scale(j * h, 1.0F / j * h, j * h);
    }
}

