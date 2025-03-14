package gay.pridecraft.joy.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.SnifferEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CustomSnifferEntity extends SnifferEntity {

    public CustomSnifferEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Nullable
    @Override
    public SnifferEntity createChild(final ServerWorld serverWorld, final PassiveEntity passiveEntity) {
        return (SnifferEntity) this.getType().create(serverWorld);
    }

    public static class SnifferEntity extends CustomSnifferEntity {
        public SnifferEntity(EntityType<? extends SnifferEntity> entityType, World world) {
            super(entityType, world);
        }
    }
}
