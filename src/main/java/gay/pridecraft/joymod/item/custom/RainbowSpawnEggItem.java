package gay.pridecraft.joymod.item.custom;

import gay.pridecraft.joymod.entity.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.NbtCompound;
import org.jetbrains.annotations.Nullable;

public class RainbowSpawnEggItem extends SpawnEggItem {
    public RainbowSpawnEggItem(EntityType<? extends MobEntity> type, int primaryColor, int secondaryColor, Settings settings) {
        super(type, primaryColor, secondaryColor, settings);
    }

    public EntityType<?> method_8015(@Nullable NbtCompound nbtCompound) {
        return ModEntities.THIGH_HIGH_FOX;
    }
}
