package com.waterstylus331.shartmod.item;

import com.waterstylus331.shartmod.entity.PoopProjectile;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PoopItem extends Item {
    public PoopItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player plr, InteractionHand hand) {
        ItemStack itemstack = plr.getItemInHand(hand);
        level.playSound(null, plr.getX(), plr.getY(), plr.getZ(),
                SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!level.isClientSide) {
            PoopProjectile projectile = new PoopProjectile(level, plr);
            projectile.shootFromRotation(plr, plr.getXRot(), plr.getYRot(), 0.0F, 1.2F, 1.0F);
            level.addFreshEntity(projectile);
        }

        plr.awardStat(Stats.ITEM_USED.get(this));
        if (!plr.getAbilities().instabuild) {
            itemstack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }
}
