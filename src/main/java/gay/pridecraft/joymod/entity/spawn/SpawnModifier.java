package gay.pridecraft.joymod.entity.spawn;

import gay.pridecraft.joymod.config.Config;
import gay.pridecraft.joymod.entity.ModEntities;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;

public class SpawnModifier {
    public static void modifySpawning() {
        if (Config.foxNaturalSpawn) {
            BiomeModifications.addSpawn(
                    BiomeSelectors.includeByKey(
                            BiomeKeys.GROVE,
                            BiomeKeys.TAIGA,
                            BiomeKeys.SNOWY_TAIGA,
                            BiomeKeys.OLD_GROWTH_PINE_TAIGA,
                            BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA),
                    ModEntities.THIGH_HIGH_FOX.getSpawnGroup(),
                    ModEntities.THIGH_HIGH_FOX,
                    Config.foxWeight,
                    Config.foxMinGroupSize,
                    Config.foxMaxGroupSize
            );
        }
    }
}
