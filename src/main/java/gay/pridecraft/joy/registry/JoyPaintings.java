package gay.pridecraft.joy.registry;

import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import static gay.pridecraft.joy.Joy.MOD_ID;

public class JoyPaintings {
    public static final RegistryKey<PaintingVariant> ACE = of("ace");
    public static final RegistryKey<PaintingVariant> AGENDER = of("agender");
    public static final RegistryKey<PaintingVariant> ALLY = of("ally");
    public static final RegistryKey<PaintingVariant> ARO = of("aro");
    public static final RegistryKey<PaintingVariant> AROACE = of("aroace");
    public static final RegistryKey<PaintingVariant> BI = of("bi");
    public static final RegistryKey<PaintingVariant> BIGENDER = of("bigender");
    public static final RegistryKey<PaintingVariant> BIRB = of("birb");
    public static final RegistryKey<PaintingVariant> DEMIROMANTIC = of("demiromantic");
    public static final RegistryKey<PaintingVariant> DEMISEXUAL = of("demisexual");
    public static final RegistryKey<PaintingVariant> ENBY = of("enby");
    public static final RegistryKey<PaintingVariant> FLOATING_BEES = of("floating_bees");
    public static final RegistryKey<PaintingVariant> FLOATING_TREES = of("floating_trees");
    public static final RegistryKey<PaintingVariant> INTERSEX = of("intersex");
    public static final RegistryKey<PaintingVariant> LESBIAN = of("lesbian");
    public static final RegistryKey<PaintingVariant> MLM = of("mlm");
    public static final RegistryKey<PaintingVariant> PAN = of("pan");
    public static final RegistryKey<PaintingVariant> POLYSEXUAL = of("polysexual");
    public static final RegistryKey<PaintingVariant> PROGRESS = of("progress");
    public static final RegistryKey<PaintingVariant> QUEER = of("queer");
    public static final RegistryKey<PaintingVariant> RAINBOW = of("rainbow");
    public static final RegistryKey<PaintingVariant> TRANS = of("trans");

    private static RegistryKey<PaintingVariant> of(String id) {
        return RegistryKey.of(RegistryKeys.PAINTING_VARIANT, Identifier.of(MOD_ID, id));
    }
}