package gay.pridecraft.joy.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CustomFoxEntity extends FoxEntity {
    public CustomFoxEntity(EntityType<? extends FoxEntity> entityType, World world) {
        super(entityType, world);
    }

    @Nullable
    @Override
    public FoxEntity createChild(final ServerWorld serverWorld, final PassiveEntity passiveEntity) {
        final var fox = (FoxEntity) this.getType().create(serverWorld);
        if (fox != null) {
            fox.setVariant(this.random.nextBoolean() ? this.getVariant() : ((FoxEntity) passiveEntity).getVariant());
        }
        return fox;
    }

    public static class SockFoxEntity extends CustomFoxEntity {
        public SockFoxEntity(EntityType<? extends SockFoxEntity> entityType, World world) {
            super(entityType, world);
        }
    }
}
