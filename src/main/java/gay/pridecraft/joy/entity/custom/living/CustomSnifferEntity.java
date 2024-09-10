package gay.pridecraft.joy.entity.custom.living;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.SnifferEntity;
import net.minecraft.world.World;

public class CustomSnifferEntity extends SnifferEntity {

    public CustomSnifferEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    public static class PrideSnifferEntity extends CustomSnifferEntity {
        public PrideSnifferEntity(EntityType<? extends PrideSnifferEntity> entityType, World world) {
            super(entityType, world);
        }
    }
}
