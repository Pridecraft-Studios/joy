package gay.pridecraft.pridemod.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions {

    public static final Potion GENDER_FLUID =
            Registry.register(Registries.POTION, new Identifier("pridemod", "gender_fluid"),
                    new Potion(new StatusEffectInstance(StatusEffects.LUCK, 500, 1)));

    public static void registerPotions(){

    }

    public static void registerPotionsRecipes(){

        BrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, Items.BEDROCK, ModPotions.GENDER_FLUID);

    }

}
