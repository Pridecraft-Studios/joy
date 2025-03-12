package gay.pridecraft.joy.item;

import net.minecraft.item.ElytraItem;

public class CustomElytraItem extends ElytraItem {
    public CustomElytraItem(Settings settings) {
        super(settings.maxDamage(432));
    }
}
