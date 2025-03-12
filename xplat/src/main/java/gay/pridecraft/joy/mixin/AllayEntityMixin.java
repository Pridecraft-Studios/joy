package gay.pridecraft.joy.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import gay.pridecraft.joy.item.CuddlyItem;
import net.minecraft.entity.passive.AllayEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(AllayEntity.class)
public class AllayEntityMixin {

    @WrapMethod(method = "interactMob")
    public ActionResult preventTakePlush(PlayerEntity player, Hand hand, Operation<ActionResult> original) {
        return player.getStackInHand(hand).getItem() instanceof CuddlyItem ?
                ActionResult.PASS :
                original.call(player, hand);
    }
}
