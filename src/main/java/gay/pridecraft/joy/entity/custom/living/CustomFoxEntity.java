package gay.pridecraft.joy.entity.custom.living;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.world.World;

public class CustomFoxEntity extends FoxEntity {
    public CustomFoxEntity(EntityType<? extends FoxEntity> entityType, World world) {
        super(entityType, world);
    }

    public static class ThighHighFoxEntity extends CustomFoxEntity {
        public ThighHighFoxEntity(EntityType<? extends ThighHighFoxEntity> entityType, World world) {
            super(entityType, world);
        }
    }
}
