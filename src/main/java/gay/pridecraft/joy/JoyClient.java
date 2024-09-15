package gay.pridecraft.joy;

import gay.pridecraft.joy.block.ModBlocks;
import gay.pridecraft.joy.entity.ModEntities;
import gay.pridecraft.joy.particle.ModParticles;
import gay.pridecraft.joy.particle.TotemOfPrideParticle;
import gay.pridecraft.joy.renderer.entity.*;
import gay.pridecraft.joy.renderer.feature.CustomElytraFeatureRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class JoyClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererFactories.register(ModEntities.CUSTOM_BED_BLOCK_ENTITY, CustomBedBlockRenderer::new);

        registerBedBlockRenderLayers();
        registerEntityRenderers();

        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> {
            Identifier elytra = Identifier.ofVanilla("textures/entity/elytra.png");
            registrationHelper.register(new CustomElytraFeatureRenderer<>(entityRenderer, context.getModelLoader(), elytra));
        });

        ParticleFactoryRegistry.getInstance().register(ModParticles.TOTEM_OF_PRIDE_PARTICLE, TotemOfPrideParticle.Factory::new);
    }

    private static void registerBedBlockRenderLayers() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACE_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TRANS_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AGENDER_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BISEXUAL_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.APLATONIC_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ARO_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AROACE_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AGENDER_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ENBY_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GAY_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GENDER_FLUID_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LESBIAN_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BIGENDER_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MLM_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PAN_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PROGRESS_BED, RenderLayer.getCutout());
    }

    private static void registerEntityRenderers() {
        EntityRendererRegistry.register(ModEntities.SOCK_FOX, SockFoxRenderer::new);
        EntityRendererRegistry.register(ModEntities.BII, BiiRenderer::new);
        EntityRendererRegistry.register(ModEntities.ENBEE, EnbeeRenderer::new);
        EntityRendererRegistry.register(ModEntities.TREE, TreeRenderer::new);
        EntityRendererRegistry.register(ModEntities.PRIDE_AXOLOTL, PrideAxolotlRenderer::new);
        EntityRendererRegistry.register(ModEntities.PRIDE_FROG, PrideFrogRenderer::new);
        EntityRendererRegistry.register(ModEntities.PRIDE_SLIME, PrideSlimeRenderer::new);
        EntityRendererRegistry.register(ModEntities.PRIDE_SNIFFER, PrideSnifferRenderer::new);
    }
}
