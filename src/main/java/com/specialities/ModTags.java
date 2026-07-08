package com.specialities;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public final class ModTags {
	/** All weapons (melee + ranged), for the combat skill (see data/specialities/tags/item/). */
	public static final TagKey<Item> WEAPONS = TagKey.create(Registries.ITEM, Specialities.id("weapons"));
	/** Swords, spears, trident, mace — the arms mastery skill. */
	public static final TagKey<Item> MELEE_WEAPONS = TagKey.create(Registries.ITEM, Specialities.id("melee_weapons"));
	/** Bows and crossbows — the archery skill. */
	public static final TagKey<Item> RANGED_WEAPONS = TagKey.create(Registries.ITEM, Specialities.id("ranged_weapons"));
	/** Armor that dampens the sneaking skill's detection bonus (leather/elytra/heads excluded). */
	public static final TagKey<Item> HEAVY_ARMOR = TagKey.create(Registries.ITEM, Specialities.id("heavy_armor"));
	/** Non-armor items whose crafting trains smithing (armor is detected via the equippable component). */
	public static final TagKey<Item> SMITHING_ITEMS = TagKey.create(Registries.ITEM, Specialities.id("smithing_items"));
	/** Furnace outputs eligible for the smithing smelting multicraft. */
	public static final TagKey<Item> SMELTED_METALS = TagKey.create(Registries.ITEM, Specialities.id("smelted_metals"));

	private ModTags() {
	}
}
