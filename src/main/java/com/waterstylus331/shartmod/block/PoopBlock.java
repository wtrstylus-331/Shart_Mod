package com.waterstylus331.shartmod.block;

import com.waterstylus331.shartmod.effect.ModEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class PoopBlock extends Block {
    public PoopBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public void stepOn(Level level, BlockPos blockpos, BlockState blockstate, Entity entity) {
        if (level.isClientSide()) return;

        if (entity instanceof Player) {
            Player plr = (Player) entity;
            plr.addEffect(new MobEffectInstance(ModEffects.STINKY.getHolder().get(), 900));
        }
        super.stepOn(level, blockpos, blockstate, entity);
    }

    @Override
    public void onBlockExploded(BlockState state, Level level, BlockPos pos, Explosion explosion) {
        level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
        this.wasExploded(level, pos, explosion);

        super.onBlockExploded(state, level, pos, explosion);
    }
}
