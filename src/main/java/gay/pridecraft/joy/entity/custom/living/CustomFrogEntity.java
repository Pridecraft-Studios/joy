package gay.pridecraft.joy.entity.custom.living;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.FrogEntity;
import net.minecraft.world.World;

public class CustomFrogEntity extends FrogEntity {
    public CustomFrogEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    public static class PrideFrogEntity extends CustomFrogEntity {
        public PrideFrogEntity(EntityType<? extends PrideFrogEntity> entityType, World world) {
            super(entityType, world);
        }
    }
}
