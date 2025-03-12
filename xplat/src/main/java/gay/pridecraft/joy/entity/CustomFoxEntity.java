package gay.pridecraft.joy.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.world.World;

public class CustomFoxEntity extends FoxEntity {
    public CustomFoxEntity(EntityType<? extends FoxEntity> entityType, World world) {
        super(entityType, world);
    }

    public static class SockFoxEntity extends CustomFoxEntity {
        public SockFoxEntity(EntityType<? extends SockFoxEntity> entityType, World world) {
            super(entityType, world);
        }
    }
}
