package gay.pridecraft.joy.data;

import com.mojang.logging.LogUtils;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.Bootstrap;
import net.minecraft.SharedConstants;
import org.slf4j.Logger;

/**
 * @author Ampflower
 * @since 1.0.0
 **/
public class JoyData implements DataGeneratorEntrypoint {
    private static final Logger logger = LogUtils.getLogger();

    @Override
    public void onInitializeDataGenerator(final FabricDataGenerator fabricDataGenerator) {
        SharedConstants.isDevelopment = true;

        final var pack = fabricDataGenerator.createPack();

        pack.addProvider(JoyBlockTagProvider::new);
        pack.addProvider(JoyEntityTagProvider::new);
        pack.addProvider(JoyModelProvider::new);

        for (final var translation : Bootstrap.getMissingTranslations()) {
            logger.warn("Missing translation: {}", translation);
        }
    }
}
