package gay.pridecraft.joy.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CustomBeeEntity extends BeeEntity {

    public CustomBeeEntity(EntityType<? extends BeeEntity> entityType, World world) {
        super(entityType, world);
    }

    @Nullable
    @Override
    public BeeEntity createChild(final ServerWorld serverWorld, final PassiveEntity passiveEntity) {
        return (BeeEntity) this.getType().create(serverWorld);
    }

    public static class BiiEntity extends CustomBeeEntity {
        public BiiEntity(EntityType<? extends BiiEntity> entityType, World world) {
            super(entityType, world);
        }
    }

    public static class EnbeeEntity extends CustomBeeEntity {
        public EnbeeEntity(EntityType<? extends EnbeeEntity> entityType, World world) {
            super(entityType, world);
        }
    }

    public static class TransBeeEntity extends CustomBeeEntity {
        public TransBeeEntity(EntityType<? extends TransBeeEntity> entityType, World world) {super(entityType, world);}
    }

    public static class TreeEntity extends CustomBeeEntity {
        public TreeEntity(EntityType<? extends TreeEntity> entityType, World world) {super(entityType, world);}
    }

}
