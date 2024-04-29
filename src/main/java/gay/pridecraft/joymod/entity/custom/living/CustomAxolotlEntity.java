package gay.pridecraft.joymod.entity.custom.living;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AxolotlEntity;
import net.minecraft.world.World;

public class CustomAxolotlEntity extends AxolotlEntity {
    public CustomAxolotlEntity(EntityType<? extends AxolotlEntity> entityType, World world) {
        super(entityType, world);
    }

    public static class PrideAxolotlEntity extends CustomAxolotlEntity {
        public PrideAxolotlEntity(EntityType<? extends PrideAxolotlEntity> entityType, World world) {
            super(entityType, world);
        }
    }
}
