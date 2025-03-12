package gay.pridecraft.joy.config;

import eu.midnightdust.lib.config.MidnightConfig;

public class Config extends MidnightConfig {
    @Entry(category = "spawn", name = "Enable Mob Spawning")
    public static boolean mobSpawning = true;

    @Comment(category = "spawn") public static Comment spacer0;
    @Entry(category = "spawn", name = "Enable Pride Axolotl Spawning")
    public static boolean axolotlNaturalSpawn = true;

    @Entry(category = "spawn", name = "Pride Axolotl Weight", min = 0)
    public static int axolotlWeight = 10;

    @Entry(category = "spawn", name = "Pride Axolotl Group Size", min = 0)
    public static int axolotlMinGroupSize = 4;

    @Entry(category = "spawn", name = "Pride Axolotl Group Size", min = 0)
    public static int axolotlMaxGroupSize = 6;

    @Comment(category = "spawn") public static Comment spacer1;

    @Entry(category = "spawn", name = "Enable Thigh High Fox Spawning")
    public static boolean foxNaturalSpawn = true;

    @Entry(category = "spawn", name = "Thigh High Fox Weight", min = 0)
    public static int foxWeight = 8;

    @Entry(category = "spawn", name = "Thigh High Fox Minimum Group Size", min = 0)
    public static int foxMinGroupSize = 2;

    @Entry(category = "spawn", name = "Thigh High Fox Maximum Group Size", min = 0)
    public static int foxMaxGroupSize = 4;

    @Comment(category = "spawn") public static Comment spacer2;

    @Entry(category = "spawn", name = "Pride Frog Weight", min = 0)
    public static int frogWeight = 10;

    @Entry(category = "spawn", name = "Pride Frog Group Size", min = 0)
    public static int frogMinGroupSize = 2;

    @Entry(category = "spawn", name = "Pride Frog Group Size", min = 0)
    public static int frogMaxGroupSize = 5;
}

// what is this config