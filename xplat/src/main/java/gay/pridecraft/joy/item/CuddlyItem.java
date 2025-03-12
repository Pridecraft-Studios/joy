package gay.pridecraft.joy.item;

import gay.pridecraft.joy.BlahajDataComponentTypes;
import gay.pridecraft.joy.JoyUtil;
import net.minecraft.block.Block;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.List;

public class CuddlyItem extends BlockItem {
    private final Text subtitle;

    public CuddlyItem(Block block, Settings settings, String subtitle) {
        super(block, settings);
        this.subtitle = subtitle == null ? null : Text.translatable(subtitle).formatted(Formatting.GRAY);
    }

    @Override
    public void onCraftByPlayer(ItemStack stack, World world, PlayerEntity player) {
        super.onCraftByPlayer(stack, world, player);

        // in case of crafter
        if (player != null) stack.set(BlahajDataComponentTypes.OWNER, player.getName());
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);

        if (this.subtitle != null) tooltip.add(this.subtitle);

        Text ownerName = stack.get(BlahajDataComponentTypes.OWNER);
        if (ownerName == null) return;

        Text customName = stack.get(DataComponentTypes.CUSTOM_NAME);
        if (customName == null) {
            tooltip.add(Text.translatable("tooltip.blahaj.owner.craft", ownerName).formatted(Formatting.GRAY));
            return;
        }

        tooltip.add(Text.translatable("tooltip.blahaj.owner.rename", customName, ownerName).formatted(Formatting.GRAY));
    }

    public static final Identifier MINING_SPEED_MODIFIER_ID = JoyUtil.id("base_attack_damage");

    public static AttributeModifiersComponent createAttributeModifiers() {
        return AttributeModifiersComponent.builder()
                .add(
                        EntityAttributes.PLAYER_BLOCK_BREAK_SPEED,
                        new EntityAttributeModifier(
                                MINING_SPEED_MODIFIER_ID,
                                -3.0, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
                        ),
                        AttributeModifierSlot.MAINHAND
                )
                .add(
                        EntityAttributes.GENERIC_ATTACK_DAMAGE,
                        new EntityAttributeModifier(
                                BASE_ATTACK_DAMAGE_MODIFIER_ID,
                                -2.0,
                                EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
                        ),
                        AttributeModifierSlot.MAINHAND
                )
                .build();
    }
}
