package com.specialities.mixin;

import com.specialities.ModTags;
import com.specialities.skills.Artisan;
import com.specialities.skills.Skill;
import com.specialities.skills.SkillManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.FurnaceResultSlot;
import net.minecraft.world.item.ItemStack;

/**
 * Smithing smelting multicraft: withdrawing smelted metal from a furnace can
 * multiply it x2/x4/x8 per item (rarer for higher multipliers).
 */
@Mixin(FurnaceResultSlot.class)
public abstract class FurnaceResultSlotMixin {
	@Inject(method = "onTake", at = @At("HEAD"))
	private void specialities$smeltMulticraft(final Player player, final ItemStack carried, final CallbackInfo ci) {
		if (!(player instanceof ServerPlayer serverPlayer) || serverPlayer.isCreative()
				|| !carried.is(ModTags.SMELTED_METALS)) {
			return;
		}

		int level = SkillManager.get(serverPlayer).level(Skill.SMITHING);
		if (level <= 0) {
			return;
		}

		RandomSource random = serverPlayer.getRandom();
		int extra = 0;

		for (int i = 0; i < carried.getCount(); i++) {
			extra += Artisan.rollSmeltMultiplier(random, level) - 1;
		}

		while (extra > 0) {
			int count = Math.min(extra, carried.getMaxStackSize());
			serverPlayer.getInventory().placeItemBackInInventory(new ItemStack(carried.getItem(), count));
			extra -= count;
		}
	}
}
