package gay.pridecraft.joy.item;

import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.minecraft.item.ElytraItem;

public class CustomElytraItem extends ElytraItem implements FabricElytraItem {
    public CustomElytraItem(Settings settings) {
        super(settings.maxDamage(432));
    }

    //not mapped method might be required
}
