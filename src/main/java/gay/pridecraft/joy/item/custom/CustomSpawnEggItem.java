package gay.pridecraft.joy.item.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;

public class CustomSpawnEggItem extends net.minecraft.item.SpawnEggItem {
    public CustomSpawnEggItem(EntityType<? extends MobEntity> type, int primaryColor, int secondaryColor, Settings settings) {
        super(type, primaryColor, secondaryColor, settings);
    }
}
