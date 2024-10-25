/*
 * Based on: https://github.com/AkashiiKun/MoreAxolotlVariantsAPI-Common/blob/c692a509be0bab64b9a6087f6eed090409d98a27/Common/src/main/java/io/github/akashiikun/mavapi/v1/mixin/MobBucketItemMixin.java
 * Original Author KxmischesDomi | https://github.com/kxmischesdomi
 * Translated into Yarn mappings and modified by rotgruengelb
 *
 * Provided originally by Akashii and KxmischesDomi under the MIT license:
 *
 * The MIT License (MIT)
 *
 * Copyright (c) 2021 - 2024 Akashii, 2023 - 2024 KxmischesDomi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package gay.pridecraft.joy.mixin.fix.mavapi;

import io.github.akashiikun.mavapi.v1.impl.AxolotlTypeExtension;
import io.github.akashiikun.mavapi.v1.impl.MoreAxolotlVariant;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AxolotlEntity;
import net.minecraft.item.EntityBucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Locale;

/**
 * Based on: <a href="https://github.com/AkashiiKun/MoreAxolotlVariantsAPI-Common/blob/c692a509be0bab64b9a6087f6eed090409d98a27/Common/src/main/java/io/github/akashiikun/mavapi/v1/mixin/MobBucketItemMixin.java">...</a>
 * Original Author KxmischesDomi <a href="https://github.com/kxmischesdomi">...</a>
 * Translated into Yarn mappings and modified by rotgruengelb<br>
 * Provided originally by Akashii and KxmischesDomi under the MIT license see Top of file for
 * more information.
 */
@Mixin(EntityBucketItem.class)
public abstract class EntityBucketItemMixin {
	@Shadow private EntityType<?> entityType;

	@Inject(method = "appendTooltip", at = @At(value = "HEAD"))
	public void appendTooltip(ItemStack itemStack, Item.TooltipContext tooltipContext, List<Text> list, TooltipType tooltipFlag, CallbackInfo ci) {
		if (entityType == EntityType.AXOLOTL) {
			NbtCompound nbtCompound = itemStack.get(DataComponentTypes.BUCKET_ENTITY_DATA)
					.copyNbt();
			if (nbtCompound != null && nbtCompound.contains(AxolotlEntity.VARIANT_KEY, NbtElement.STRING_TYPE)) {
				String variantIdentifier = nbtCompound.getString(AxolotlEntity.VARIANT_KEY);

				for (AxolotlEntity.Variant variant : AxolotlEntity.Variant.values()) {

					MoreAxolotlVariant metadata = ((AxolotlTypeExtension) (Object) variant).mavapi$metadata();

					Identifier id = metadata.getId();
					if (id.equals(Identifier.of(variantIdentifier))) {

						int age = nbtCompound.getInt("Age");

						MutableText component = Text.translatable("mavapi.bucket.format", age < 0 ? Text.translatable("mavapi.bucket.translation.baby") : Text.translatable("mavapi.bucket.translation.adult"), translateOrFormat(String.format("mavapi.variant.%s.%s", id.getNamespace(), id.getPath()), id.getPath()), translateOrFormat(String.format("mavapi.mod.%s", id.getNamespace()), id.getNamespace()));
						component.setStyle(Style.EMPTY.withColor(Formatting.GRAY));
						list.add(component);
						break;
					}
				}

			}
		}
	}

	private MutableText translateOrFormat(String translation, String toFormat) {
		try {
			MutableText component = Text.translatable(translation);
			if (!I18n.hasTranslation(translation)) {
				component = Text.literal(formatName(toFormat));
			}
			return component;
		} catch (Exception e) {
			return Text.literal("Error in gay.pridecraft.joy.mixin.fix.mavapi.EntityBucketItemMixin#translateOrFormat");
		}
	}

	private String formatName(String s) {
		s = s.replace("_", " ");
		s = String.valueOf(s.charAt(0))
				.toUpperCase(Locale.ROOT) + s.substring(1);
		return s;
	}

}