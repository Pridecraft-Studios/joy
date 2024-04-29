package gay.pridecraft.joymod.item.custom;

import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.minecraft.item.ElytraItem;
import net.minecraft.util.Rarity;

public class CustomElytraItem extends ElytraItem implements FabricElytraItem {
    public CustomElytraItem(Settings settings) {
        super(settings.maxDamage(432).rarity(Rarity.EPIC));
    }

    //not mapped method might be required
}
