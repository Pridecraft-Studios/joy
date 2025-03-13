package gay.pridecraft.joy.render.entity;

import gay.pridecraft.joy.JoyUtil;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.BeeEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.util.Identifier;

public class TreeRenderer<T extends BeeEntity> extends MobEntityRenderer<T, BeeEntityModel<T>> {
    private final Identifier angryTexture;
    private final Identifier angryNectarTexture;
    private final Identifier passiveTexture;
    private final Identifier nectarTexture;

    private TreeRenderer(Builder<T> builder, EntityRendererFactory.Context context) {
        super(context, new BeeEntityModel<>(context.getPart(EntityModelLayers.BEE)), 0.4F);

        this.angryTexture = builder.angryTexture();
        this.angryNectarTexture = builder.angryNectarTexture();
        this.passiveTexture = builder.passiveTexture();
        this.nectarTexture = builder.nectarTexture();
    }

    @Override
    public Identifier getTexture(final T entity) {
        if (entity.hasAngerTime()) {
            return entity.hasNectar() ? angryNectarTexture : angryTexture;
        } else {
            return entity.hasNectar() ? nectarTexture : passiveTexture;
        }
    }

    public static <T extends BeeEntity> Builder<T> factory(String base) {
        return new Builder<T>(
            JoyUtil.id("textures/entity/bee/" + base + "_angry.png"),
            JoyUtil.id("textures/entity/bee/" + base + "_angry_nectar.png"),
            JoyUtil.id("textures/entity/bee/" + base + ".png"),
            JoyUtil.id("textures/entity/bee/" + base + "_nectar.png")
        );
    }

    private record Builder<T extends BeeEntity>(
        Identifier angryTexture,
        Identifier angryNectarTexture,
        Identifier passiveTexture,
        Identifier nectarTexture
    ) implements EntityRendererFactory<T> {

        @Override
        public EntityRenderer<T> create(final Context ctx) {
            return new TreeRenderer<>(this, ctx);
        }
    }
}
