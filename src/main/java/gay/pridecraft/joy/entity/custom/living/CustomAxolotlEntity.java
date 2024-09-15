package gay.pridecraft.joy.entity.custom.living;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AxolotlEntity;
import net.minecraft.world.World;

public class CustomAxolotlEntity extends AxolotlEntity {
    public CustomAxolotlEntity(EntityType<? extends net.minecraft.entity.passive.AxolotlEntity> entityType, World world) {
        super(entityType, world);
    }

    public static class AxolotlEntity extends CustomAxolotlEntity {
        public AxolotlEntity(EntityType<? extends AxolotlEntity> entityType, World world) {
            super(entityType, world);
        }
    }
}
