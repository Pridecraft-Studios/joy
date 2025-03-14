package gay.pridecraft.joy.fabric.client;

import gay.pridecraft.joy.client.SplashUtil;
import gay.pridecraft.joy.fabric.FabricUtil;
import gay.pridecraft.joy.particle.TotemOfPrideParticle;
import gay.pridecraft.joy.registry.JoyBlockEntityTypes;
import gay.pridecraft.joy.registry.JoyBlocks;
import gay.pridecraft.joy.registry.JoyEntities;
import gay.pridecraft.joy.registry.JoyParticles;
import gay.pridecraft.joy.render.JoyBedBlockEntityRenderer;
import gay.pridecraft.joy.render.entity.FrogRenderer;
import gay.pridecraft.joy.render.entity.PrideSnifferRenderer;
import gay.pridecraft.joy.render.entity.SockFoxRenderer;
import gay.pridecraft.joy.render.entity.TreeRenderer;
import gay.pridecraft.joy.render.feature.CustomElytraFeatureRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class JoyClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererFactories.register(
            JoyBlockEntityTypes.JOY_BED_BLOCK_ENTITY,
            JoyBedBlockEntityRenderer::new
        );

        registerBedBlockRenderLayers();
        registerEntityRenderers();

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
            JoyBlocks.PINK_ALLIUM,
            JoyBlocks.BLUE_ALLIUM,
            JoyBlocks.WHITE_ALLIUM,
            JoyBlocks.TRANS_ALLIUM,
            JoyBlocks.POTTED_PINK_ALLIUM,
            JoyBlocks.POTTED_BLUE_ALLIUM,
            JoyBlocks.POTTED_WHITE_ALLIUM,
            JoyBlocks.POTTED_TRANS_ALLIUM
        );

        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> {
            Identifier elytra = Identifier.ofVanilla("textures/entity/elytra.png");
            registrationHelper.register(new CustomElytraFeatureRenderer<>(entityRenderer, context.getModelLoader(), elytra));
        });

        ParticleFactoryRegistry.getInstance().register(JoyParticles.TOTEM_OF_PRIDE_PARTICLE, TotemOfPrideParticle.Factory::new);

        FabricUtil.registerEnabledPack("menu", Text.of("Joy's Main Menu & HUD"));
        FabricUtil.registerEnabledPack("glint", Text.of("Joy's Enchantment Glint"));

        SplashUtil.init();
    }

    private static void registerBedBlockRenderLayers() {
        BlockRenderLayerMap.INSTANCE.putBlock(JoyBlocks.ACE_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JoyBlocks.TRANS_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JoyBlocks.AGENDER_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JoyBlocks.BISEXUAL_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JoyBlocks.APLATONIC_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JoyBlocks.ARO_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JoyBlocks.AROACE_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JoyBlocks.AGENDER_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JoyBlocks.ENBY_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JoyBlocks.GAY_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JoyBlocks.GENDERFLUID_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JoyBlocks.LESBIAN_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JoyBlocks.BIGENDER_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JoyBlocks.MLM_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JoyBlocks.PAN_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JoyBlocks.PROGRESS_BED, RenderLayer.getCutout());
    }

    private static void registerEntityRenderers() {
        EntityRendererRegistry.register(JoyEntities.SOCK_FOX, SockFoxRenderer::new);
        EntityRendererRegistry.register(JoyEntities.BII, TreeRenderer.factory("bii"));
        EntityRendererRegistry.register(JoyEntities.ENBEE, TreeRenderer.factory("enbee"));
        EntityRendererRegistry.register(JoyEntities.TRANS_BEE, TreeRenderer.factory("trans_bee"));
        EntityRendererRegistry.register(JoyEntities.TREE, TreeRenderer.factory("tree"));
        EntityRendererRegistry.register(JoyEntities.FROG, FrogRenderer::new);
        EntityRendererRegistry.register(JoyEntities.SNIFFER, PrideSnifferRenderer::new);
    }
}
