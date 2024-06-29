package gay.pridecraft.joymod.painting;

import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import static gay.pridecraft.joymod.JoyMod.MOD_ID;

public class ModPaintings {
    public static final RegistryKey<PaintingVariant> ACE = of("ace");
    public static final RegistryKey<PaintingVariant> AGENDER = of("agender");
    public static final RegistryKey<PaintingVariant> ARO = of("aro");
    public static final RegistryKey<PaintingVariant> AROACE = of("aroace");
    public static final RegistryKey<PaintingVariant> BIGENDER = of("bigender");
    public static final RegistryKey<PaintingVariant> BISEXUAL = of("bisexual");
    public static final RegistryKey<PaintingVariant> ENBY = of("enby");
    public static final RegistryKey<PaintingVariant> GAY = of("gay");
    public static final RegistryKey<PaintingVariant> INTERSEX = of("intersex");
    public static final RegistryKey<PaintingVariant> LESBIAN = of("lesbian");
    public static final RegistryKey<PaintingVariant> MLM = of("mlm");
    public static final RegistryKey<PaintingVariant> PAN = of("pan");
    public static final RegistryKey<PaintingVariant> PROGRESS = of("progress");
    public static final RegistryKey<PaintingVariant> QUEER = of("queer");
    public static final RegistryKey<PaintingVariant> STRAIGHT_ALLY = of("straight_ally");
    public static final RegistryKey<PaintingVariant> TRANS = of("trans");

    private static RegistryKey<PaintingVariant> of(String id) {
        return RegistryKey.of(RegistryKeys.PAINTING_VARIANT, Identifier.of(MOD_ID, id));
    }
}