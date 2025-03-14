package gay.pridecraft.joy.entity;

import gay.pridecraft.joy.mixin.minecraft.AccessorFrogBrain;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.FrogEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CustomFrogEntity extends FrogEntity {
    public CustomFrogEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Nullable
    @Override
    public FrogEntity createChild(final ServerWorld serverWorld, final PassiveEntity passiveEntity) {
        final var frog = (FrogEntity) this.getType().create(serverWorld);
        if (frog != null) {
            AccessorFrogBrain.invokeCoolDownLongJump(frog, serverWorld.getRandom());
        }
        return frog;
    }

    public static class FrogEntity extends CustomFrogEntity {
        public FrogEntity(EntityType<? extends FrogEntity> entityType, World world) {
            super(entityType, world);
        }
    }
}
