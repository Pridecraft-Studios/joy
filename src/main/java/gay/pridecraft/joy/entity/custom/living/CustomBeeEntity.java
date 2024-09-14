package gay.pridecraft.joy.entity.custom.living;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.world.World;

public class CustomBeeEntity extends BeeEntity {

    public CustomBeeEntity(EntityType<? extends BeeEntity> entityType, World world) {
        super(entityType, world);
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

    public static class TreeEntity extends CustomBeeEntity {
        public TreeEntity(EntityType<? extends TreeEntity> entityType, World world) {
            super(entityType, world);
        }
    }

}
