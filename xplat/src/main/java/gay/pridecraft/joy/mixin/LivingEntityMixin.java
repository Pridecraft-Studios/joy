package gay.pridecraft.joy.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import gay.pridecraft.joy.tags.JoyItemTags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @WrapOperation(method = "tryUseTotem",
        at = @At(value = "INVOKE",
            target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
    private boolean onCheckTotem(ItemStack self, Item other, Operation<Boolean> operation) {
        if (self.isIn(JoyItemTags.TOTEM_OF_UNDYING)) {
            return true;
        }
        return operation.call(self, other);
    }

    @ModifyArg(method = "tryUseTotem",
        at = @At(value = "INVOKE",
            target = "Lnet/minecraft/stat/StatType;getOrCreateStat(Ljava/lang/Object;)Lnet/minecraft/stat/Stat;"))
    private Object modifyStatArgument(Object original, @Local ItemStack real) {
        if (real != null && !real.isEmpty()) {
            return real.getItem();
        }
        return original;
    }
}
