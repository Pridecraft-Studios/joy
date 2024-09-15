package gay.pridecraft.joy.renderer.entity;

import gay.pridecraft.joy.Joy;
import gay.pridecraft.joy.entity.custom.living.CustomAxolotlEntity;
import gay.pridecraft.joy.renderer.model.AxolotlEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.entity.passive.AxolotlEntity;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

@Environment(EnvType.CLIENT)
public class AxolotlRenderer extends MobEntityRenderer<CustomAxolotlEntity.AxolotlEntity, AxolotlEntityModel<CustomAxolotlEntity.AxolotlEntity>> {
    private static final Map<AxolotlEntity.Variant, Identifier> TEXTURES = new HashMap<>();

    static {
        TEXTURES.put(net.minecraft.entity.passive.AxolotlEntity.Variant.BLUE, Identifier.of(Joy.MOD_ID, "textures/entity/axolotl/axolotl_blue.png"));
        TEXTURES.put(net.minecraft.entity.passive.AxolotlEntity.Variant.GOLD, Identifier.of(Joy.MOD_ID, "textures/entity/axolotl/axolotl_gold.png"));
        TEXTURES.put(net.minecraft.entity.passive.AxolotlEntity.Variant.CYAN, Identifier.of(Joy.MOD_ID, "textures/entity/axolotl/axolotl_cyan.png"));
        TEXTURES.put(net.minecraft.entity.passive.AxolotlEntity.Variant.LUCY, Identifier.of(Joy.MOD_ID, "textures/entity/axolotl/axolotl_lucy.png"));
        TEXTURES.put(net.minecraft.entity.passive.AxolotlEntity.Variant.WILD, Identifier.of(Joy.MOD_ID, "textures/entity/axolotl/axolotl_wild.png"));
    }

    public AxolotlRenderer(EntityRendererFactory.Context context) {
        super(context, new AxolotlEntityModel<>(context.getPart(EntityModelLayers.AXOLOTL)), 0.5F);
    }

    @Override
    public Identifier getTexture(CustomAxolotlEntity.AxolotlEntity entity) {
        AxolotlEntity.Variant variant = entity.getVariant();
        return TEXTURES.get(variant);
    }
}
