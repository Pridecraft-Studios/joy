package gay.pridecraft.joy.util;

import gay.pridecraft.joy.Joy;
import gay.pridecraft.joy.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BedTextureProvider {
    public static final List<Block> BEDS = Arrays.asList(
            ModBlocks.ACE_BED,
            ModBlocks.AGENDER_BED,
            ModBlocks.APLATONIC_BED,
            ModBlocks.BISEXUAL_BED,
            ModBlocks.ARO_BED,
            ModBlocks.BIGENDER_BED,
            ModBlocks.ENBY_BED,
            ModBlocks.PAN_BED,
            ModBlocks.MLM_BED,
            ModBlocks.TRANS_BED,
            ModBlocks.PROGRESS_BED,
            ModBlocks.LESBIAN_BED,
            ModBlocks.GENDER_FLUID_BED,
            ModBlocks.GAY_BED,
            ModBlocks.INTERSEX_BED,
            ModBlocks.AROACE_BED
    );

    private static final Map<String, Integer> BED_INDEX_MAP = new HashMap<>();

    static {
        for (int i = 0; i < BEDS.size(); i++) {
            String toPut = BEDS.get(i).getTranslationKey();
            BED_INDEX_MAP.put(extractBedName(toPut), i);
        }
    }

    public static final Identifier BEDS_ATLAS_TEXTURE = Identifier.of("textures/atlas/beds.png");

    public static final SpriteIdentifier[] BED_TEXTURES = BEDS.stream()
            .map(bedBlock -> {
                Identifier bedTextureId = Identifier.of(Joy.MOD_ID, "entity/bed/" + extractBedName(bedBlock.getTranslationKey()));
                return new SpriteIdentifier(BEDS_ATLAS_TEXTURE, bedTextureId);
            })
            .toArray(SpriteIdentifier[]::new);

    public static SpriteIdentifier getSpriteIdentifierForBed(Block bedBlock) {
        Integer index = BED_INDEX_MAP.get(extractBedName(bedBlock.getTranslationKey()));
        return index != null ? BED_TEXTURES[index] : null;
    }

    public static String extractBedName(String translationKey) {
        String prefix = "block." + Joy.MOD_ID + ".";
        if (translationKey.startsWith(prefix)) {
            return translationKey.substring(prefix.length());
        }
        return translationKey;
    }
}
