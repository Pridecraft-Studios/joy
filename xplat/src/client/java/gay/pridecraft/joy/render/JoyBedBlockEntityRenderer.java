package gay.pridecraft.joy.render;

import gay.pridecraft.joy.BedTextureProvider;
import gay.pridecraft.joy.block.entity.JoyBedBlockEntity;
import net.minecraft.block.BedBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.DoubleBlockProperties;
import net.minecraft.block.entity.BedBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.enums.BedPart;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.block.entity.LightmapCoordinatesRetriever;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.World;

public class JoyBedBlockEntityRenderer implements BlockEntityRenderer<JoyBedBlockEntity> {
    private final ModelPart bedHead;
    private final ModelPart bedFoot;

    public JoyBedBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        this.bedHead = ctx.getLayerModelPart(EntityModelLayers.BED_HEAD);
        this.bedFoot = ctx.getLayerModelPart(EntityModelLayers.BED_FOOT);
    }

    @Override
    public void render(JoyBedBlockEntity bedBlockEntity, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light, int overlay) {
        BlockState blockState = bedBlockEntity.getCachedState();

        SpriteIdentifier spriteIdentifier = BedTextureProvider.getSpriteIdentifierForBed(blockState.getBlock());
        if (spriteIdentifier == null) throw new IllegalStateException();

        World world = bedBlockEntity.getWorld();

        if (world == null) {
            this.renderPart(matrixStack, vertexConsumerProvider, this.bedHead, Direction.SOUTH, spriteIdentifier, light, overlay, false);
            this.renderPart(matrixStack, vertexConsumerProvider, this.bedFoot, Direction.SOUTH, spriteIdentifier, light, overlay, true);

            return;
        }

        DoubleBlockProperties.PropertySource<? extends BedBlockEntity> propertySource = DoubleBlockProperties.toPropertySource(
                BlockEntityType.BED,
                BedBlock::getBedPart,
                BedBlock::getOppositePartDirection,
                ChestBlock.FACING,
                blockState,
                world,
                bedBlockEntity.getPos(),
                (w, pos) -> false
        );

        this.renderPart(
                matrixStack,
                vertexConsumerProvider,
                blockState.get(BedBlock.PART) == BedPart.HEAD ? this.bedHead : this.bedFoot,
                blockState.get(BedBlock.FACING),
                spriteIdentifier,
                propertySource.apply(new LightmapCoordinatesRetriever<>()).get(light),
                overlay,
                false
        );
    }

    private void renderPart(
            MatrixStack matrices,
            VertexConsumerProvider vertexConsumers,
            ModelPart part,
            Direction direction,
            SpriteIdentifier sprite,
            int light,
            int overlay,
            boolean isFoot
    ) {
        matrices.push();
        matrices.translate(0.0F, 0.5625F, isFoot ? -1.0F : 0.0F);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.0F));
        matrices.translate(0.5F, 0.5F, 0.5F);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(180.0F + direction.asRotation()));
        matrices.translate(-0.5F, -0.5F, -0.5F);
        VertexConsumer vertexConsumer = sprite.getVertexConsumer(vertexConsumers, RenderLayer::getEntitySolid);
        part.render(matrices, vertexConsumer, light, overlay);
        matrices.pop();
    }
}
