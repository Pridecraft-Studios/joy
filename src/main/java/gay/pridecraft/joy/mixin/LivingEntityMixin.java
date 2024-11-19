package gay.pridecraft.joy.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import gay.pridecraft.joy.registry.JoyItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    @Shadow public abstract ItemStack getStackInHand(Hand hand);

    @Shadow public abstract void setHealth(float health);

    @Shadow public abstract boolean clearStatusEffects();

    @Shadow public abstract boolean addStatusEffect(StatusEffectInstance effect);

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @WrapMethod(method = "tryUseTotem")
    public boolean useCustomTotem(DamageSource source, Operation<Boolean> original) {
        LivingEntityMixin entity = this;

        ItemStack offhandStack = entity.getStackInHand(Hand.OFF_HAND);
        ItemStack mainHandStack = entity.getStackInHand(Hand.MAIN_HAND);

        if (!offhandStack.isOf(JoyItems.TOTEM_OF_PRIDE) && !mainHandStack.isOf(JoyItems.TOTEM_OF_PRIDE)) return original.call(source);

        if (offhandStack.isOf(JoyItems.TOTEM_OF_PRIDE)) offhandStack.decrement(1);
        else if (mainHandStack.isOf(JoyItems.TOTEM_OF_PRIDE)) mainHandStack.decrement(1);


        this.setHealth(1.0F);
        this.clearStatusEffects();

        this.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 45 * 20, 1));
        this.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 40 * 20, 0));
        this.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 5 * 20, 1));

        this.getWorld().sendEntityStatus(entity, (byte) 36);

        return true;
    }
}
