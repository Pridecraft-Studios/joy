package gay.pridecraft.joy.entity.custom.living;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.world.World;

public class CustomBeeEntity extends BeeEntity {

    public CustomBeeEntity(EntityType<? extends BeeEntity> entityType, World world) {
        super(entityType, world);
    }

    public static class PrideBiiEntity extends CustomBeeEntity {
        public PrideBiiEntity(EntityType<? extends PrideBiiEntity> entityType, World world) {
            super(entityType, world);
        }
    }
}
