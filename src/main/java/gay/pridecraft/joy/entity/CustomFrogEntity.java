package gay.pridecraft.joy.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.FrogEntity;
import net.minecraft.world.World;

public class CustomFrogEntity extends FrogEntity {
    public CustomFrogEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    public static class FrogEntity extends CustomFrogEntity {
        public FrogEntity(EntityType<? extends FrogEntity> entityType, World world) {
            super(entityType, world);
        }
    }
}
