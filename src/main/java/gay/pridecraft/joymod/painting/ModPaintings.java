package gay.pridecraft.joymod.painting;

import gay.pridecraft.joymod.JoyMod;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPaintings {
    public static final PaintingVariant ACE = registerPainting("ace", new PaintingVariant(32, 16));
    public static final PaintingVariant AGENDER = registerPainting("agender", new PaintingVariant(16, 16));
    public static final PaintingVariant ARO = registerPainting("aro", new PaintingVariant(32, 16));
    public static final PaintingVariant AROACE = registerPainting("aroace", new PaintingVariant(64, 48));
    public static final PaintingVariant BIGENDER = registerPainting("bigender", new PaintingVariant(16, 16));
    public static final PaintingVariant BISEXUAL = registerPainting("bisexual", new PaintingVariant(32, 32));
    public static final PaintingVariant ENBY = registerPainting("enby", new PaintingVariant(32, 32));
    public static final PaintingVariant GAY = registerPainting("gay", new PaintingVariant(32, 32));
    public static final PaintingVariant INTERSEX = registerPainting("intersex", new PaintingVariant(64, 64));
    public static final PaintingVariant LESBIAN = registerPainting("lesbian", new PaintingVariant(64, 48));
    public static final PaintingVariant MLM = registerPainting("mlm", new PaintingVariant(16, 16));
    public static final PaintingVariant PAN = registerPainting("pan", new PaintingVariant(32, 32));
    public static final PaintingVariant PROGRESS = registerPainting("progress", new PaintingVariant(64, 64));
    public static final PaintingVariant QUEER = registerPainting("queer", new PaintingVariant(16, 16));
    public static final PaintingVariant STRAIGHT_ALLY = registerPainting("straight_ally", new PaintingVariant(32, 32));
    public static final PaintingVariant TRANS = registerPainting("trans", new PaintingVariant(32, 32));

    private static PaintingVariant registerPainting(String name, PaintingVariant paintingVariant) {
        return Registry.register(Registries.PAINTING_VARIANT, new Identifier(JoyMod.MOD_ID, name), paintingVariant);
    }

    public static void registerPaintings() {
        JoyMod.LOGGER.info("Registering Paintings for " + JoyMod.MOD_ID);
    }
}