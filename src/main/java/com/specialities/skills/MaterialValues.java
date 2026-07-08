package com.specialities.skills;

import java.util.Map;

import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

/**
 * Smithing XP value of crafting materials. Calibrated so maxing the skill
 * takes roughly 200 diamonds, 800 iron ingots, or 2000 copper ingots.
 */
public final class MaterialValues {
	private static final int DEFAULT_VALUE = 5;

	private static final Map<Item, Integer> VALUES = Map.ofEntries(
			Map.entry(Items.NETHERITE_INGOT, 1200),
			Map.entry(Items.NETHERITE_SCRAP, 300),
			Map.entry(Items.DIAMOND, 400),
			Map.entry(Items.EMERALD, 200),
			Map.entry(Items.IRON_INGOT, 100),
			Map.entry(Items.GOLD_INGOT, 80),
			Map.entry(Items.COPPER_INGOT, 40),
			Map.entry(Items.OBSIDIAN, 50),
			Map.entry(Items.LEATHER, 30),
			Map.entry(Items.STRING, 15),
			Map.entry(Items.FLINT, 10),
			Map.entry(Items.STICK, 2));

	private MaterialValues() {
	}

	public static int value(final ItemStack stack) {
		Integer direct = VALUES.get(stack.getItem());
		if (direct != null) {
			return direct;
		}

		if (stack.is(ItemTags.PLANKS)) {
			return 3;
		}

		return DEFAULT_VALUE;
	}
}
