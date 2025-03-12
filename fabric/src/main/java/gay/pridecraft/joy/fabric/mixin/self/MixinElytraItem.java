package gay.pridecraft.joy.fabric.mixin.self;

import gay.pridecraft.joy.item.CustomElytraItem;
import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import org.spongepowered.asm.mixin.Mixin;

/**
 * @author Ampflower
 * @since 1.0.0
 **/
@Mixin(CustomElytraItem.class)
public class MixinElytraItem implements FabricElytraItem {
}
