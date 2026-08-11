package com.example.lavasponge.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;

public class WetLavaSpongeBlock extends Block {
    private static final Direction[] ALL_DIRECTIONS = Direction.values();

    public WetLavaSpongeBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        if (!oldState.is(state.getBlock())) {
            this.tryDryLavaSponge(level, pos);
        }
        super.onPlace(state, level, pos, oldState, movedByPiston);
    }

    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, BlockPos neighborPos, boolean movedByPiston) {
        if (level.getFluidState(neighborPos).is(Fluids.WATER)) {
            this.tryDryLavaSponge(level, pos);
        }
        super.neighborChanged(state, level, pos, neighborBlock, neighborPos, movedByPiston);
    }

    private void tryDryLavaSponge(Level level, BlockPos pos) {
        if (this.shouldDry(level, pos)) {
            level.setBlock(pos, ModBlocks.LAVA_SPONGE.get().defaultBlockState(), Block.UPDATE_ALL_IMMEDIATE);
            level.playSound(null, pos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 1.0F, 1.0F);
            if (level instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(ParticleTypes.SMOKE,
                        pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D,
                        16, 0.4D, 0.4D, 0.4D, 0.01D);
            }
        }
    }

    private boolean shouldDry(Level level, BlockPos pos) {
        if (level.dimension() == Level.END) {
            return true;
        }
        for (Direction direction : ALL_DIRECTIONS) {
            if (level.getFluidState(pos.relative(direction)).is(Fluids.WATER)) {
                return true;
            }
        }
        return false;
    }
}
