package gay.pridecraft.joy.renderer.entity;

import gay.pridecraft.joy.Joy;
import gay.pridecraft.joy.entity.custom.living.CustomAxolotlEntity;
import gay.pridecraft.joy.renderer.model.PrideAxolotlEntityModel;
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
public class PrideAxolotlRenderer extends MobEntityRenderer<CustomAxolotlEntity.PrideAxolotlEntity, PrideAxolotlEntityModel<CustomAxolotlEntity.PrideAxolotlEntity>> {
    private static final Map<AxolotlEntity.Variant, Identifier> TEXTURES = new HashMap<>();

    static {
        TEXTURES.put(AxolotlEntity.Variant.BLUE, Identifier.of(Joy.MOD_ID, "textures/entity/axolotl/pride_axolotl_blue.png"));
        TEXTURES.put(AxolotlEntity.Variant.GOLD, Identifier.of(Joy.MOD_ID, "textures/entity/axolotl/pride_axolotl_gold.png"));
        TEXTURES.put(AxolotlEntity.Variant.CYAN, Identifier.of(Joy.MOD_ID, "textures/entity/axolotl/pride_axolotl_cyan.png"));
        TEXTURES.put(AxolotlEntity.Variant.LUCY, Identifier.of(Joy.MOD_ID, "textures/entity/axolotl/pride_axolotl_lucy.png"));
        TEXTURES.put(AxolotlEntity.Variant.WILD, Identifier.of(Joy.MOD_ID, "textures/entity/axolotl/pride_axolotl_wild.png"));
    }

    public PrideAxolotlRenderer(EntityRendererFactory.Context context) {
        super(context, new PrideAxolotlEntityModel<>(context.getPart(EntityModelLayers.AXOLOTL)), 0.5F);
    }

    @Override
    public Identifier getTexture(CustomAxolotlEntity.PrideAxolotlEntity entity) {
        AxolotlEntity.Variant variant = entity.getVariant();
        return TEXTURES.get(variant);
    }
}
