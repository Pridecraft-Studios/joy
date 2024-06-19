package gay.pridecraft.joymod.renderer.feature;

import gay.pridecraft.joymod.JoyMod;
import gay.pridecraft.joymod.item.ModItems;
import gay.pridecraft.joymod.item.custom.CustomElytraItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.ElytraEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

@Environment(EnvType.CLIENT)
public class CustomElytraFeatureRenderer<T extends LivingEntity, M extends EntityModel<T>> extends FeatureRenderer<T, M> {
    private final Identifier defaultElytraTexture;
    public final ElytraEntityModel<T> elytra;
    private final Map<Item, Identifier> elytraTextures;

    public CustomElytraFeatureRenderer(FeatureRendererContext<T, M> context, EntityModelLoader loader, Identifier defaultElytraTexture) {
        super(context);
        this.defaultElytraTexture = defaultElytraTexture;
        this.elytraTextures = new HashMap<>();
        this.elytraTextures.put(ModItems.PRIDE_ELYTRA, Identifier.of(JoyMod.MOD_ID + ":textures/entity/pride_elytra.png"));

        this.elytra = new ElytraEntityModel<>(loader.getModelPart(EntityModelLayers.ELYTRA));
    }

    @Override
    public void render(
            MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l
    ) {
        ItemStack itemStack = livingEntity.getEquippedStack(EquipmentSlot.CHEST);
        if (itemStack.getItem() instanceof CustomElytraItem) {
            Identifier elytraTexture = this.elytraTextures.getOrDefault(itemStack.getItem(), this.defaultElytraTexture);
            matrixStack.push();
            matrixStack.translate(0.0F, 0.0F, 0.125F);
            this.getContextModel().copyStateTo(this.elytra);
            this.elytra.setAngles(livingEntity, f, g, j, k, l);
            VertexConsumer vertexConsumer = ItemRenderer.getArmorGlintConsumer(
                    vertexConsumerProvider, RenderLayer.getArmorCutoutNoCull(elytraTexture), false
            );
            this.elytra.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV);
            matrixStack.pop();
        }
    }
}

