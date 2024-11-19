package gay.pridecraft.joy.entity;

import gay.pridecraft.joy.config.Config;
import gay.pridecraft.joy.registry.JoyEntities;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;

public class SpawnModifier {
    public static void modifySpawning() {
        if (!Config.foxNaturalSpawn) return;

        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(
                        BiomeKeys.GROVE,
                        BiomeKeys.TAIGA,
                        BiomeKeys.SNOWY_TAIGA,
                        BiomeKeys.OLD_GROWTH_PINE_TAIGA,
                        BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA
                ),
                JoyEntities.SOCK_FOX.getSpawnGroup(),
                JoyEntities.SOCK_FOX,
                Config.foxWeight,
                Config.foxMinGroupSize,
                Config.foxMaxGroupSize
        );
    }
}
