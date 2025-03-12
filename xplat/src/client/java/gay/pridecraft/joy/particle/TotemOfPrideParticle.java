package gay.pridecraft.joy.particle;

import net.minecraft.client.particle.AnimatedParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;

import java.util.Arrays;
import java.util.List;

public class TotemOfPrideParticle extends AnimatedParticle {
    public static final List<int[]> LGBT_COLORS = Arrays.asList(
            new int[]{228, 3, 3}, // Red
            new int[]{255, 140, 0}, // Orange
            new int[]{255, 237, 0}, // Yellow
            new int[]{0, 128, 38}, // Green
            new int[]{36, 64, 142}, // Blue
            new int[]{115, 41, 130} // Purple
    );

    private final int colorIndex;

    public TotemOfPrideParticle(ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ, SpriteProvider spriteProvider, int colorIndex) {
        super(world, x, y, z, spriteProvider, 1.25F);
        this.velocityMultiplier = 0.6F;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.velocityZ = velocityZ;
        this.scale *= 0.75F;
        this.maxAge = 60 + this.random.nextInt(12);
        this.setSpriteForAge(spriteProvider);
        this.colorIndex = colorIndex;
        this.setColor(LGBT_COLORS.get(colorIndex % LGBT_COLORS.size()));
    }

    @Override
    public void tick() {
        super.tick();
        if (this.age % 10 == 0) {
            this.setColor(LGBT_COLORS.get((this.colorIndex + 1) % LGBT_COLORS.size()));
        }
    }

    private void setColor(int[] rgb) {
        this.red = rgb[0] / 255.0F;
        this.green = rgb[1] / 255.0F;
        this.blue = rgb[2] / 255.0F;
    }

    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private static int colorCounter = 0;
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        public Particle createParticle(
            SimpleParticleType defaultParticleType, ClientWorld clientWorld, double d, double e, double f, double g, double h, double i
        ) {
            int colorIndex = colorCounter % LGBT_COLORS.size();
            colorCounter++;
            return new TotemOfPrideParticle(clientWorld, d, e, f, g, h, i, this.spriteProvider, colorIndex);
        }
    }

}
