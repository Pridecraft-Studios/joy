package gay.pridecraft.joymod.entity.custom.living;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.world.World;

public class CustomSlimeEntity extends SlimeEntity {
    public CustomSlimeEntity(EntityType<? extends SlimeEntity> entityType, World world) {
        super(entityType, world);
    }

    public static class PrideSlimeEntity extends CustomSlimeEntity {
        public PrideSlimeEntity (EntityType<? extends PrideSlimeEntity> entityType, World world) {
            super(entityType, world);
        }
    }
}
