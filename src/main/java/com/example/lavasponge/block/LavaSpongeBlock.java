package com.example.lavasponge.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.core.particles.ParticleTypes;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LavaSpongeBlock extends Block {
    public static final int MAX_DEPTH = 6;
    private static final Direction[] ALL_DIRECTIONS = Direction.values();

    public LavaSpongeBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        if (!oldState.is(state.getBlock())) {
            this.tryAbsorbLava(level, pos);
        }
        super.onPlace(state, level, pos, oldState, movedByPiston);
    }

    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, BlockPos neighborPos, boolean movedByPiston) {
        if (level.getFluidState(neighborPos).is(Fluids.LAVA)) {
            this.tryAbsorbLava(level, pos);
        }
        super.neighborChanged(state, level, pos, neighborBlock, neighborPos, movedByPiston);
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(net.minecraft.world.item.context.BlockPlaceContext context) {
        if (this.removeLavaBreadthFirstSearch(context.getLevel(), context.getClickedPos())) {
            return ModBlocks.WET_LAVA_SPONGE.get().defaultBlockState();
        }
        return super.getStateForPlacement(context);
    }

    protected void tryAbsorbLava(Level level, BlockPos pos) {
        if (this.removeLavaBreadthFirstSearch(level, pos)) {
            level.setBlock(pos, ModBlocks.WET_LAVA_SPONGE.get().defaultBlockState(), Block.UPDATE_ALL_IMMEDIATE);
            level.playSound(null, pos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 1.0F, 1.0F);
            if (level instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(ParticleTypes.SMOKE,
                        pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D,
                        16, 0.4D, 0.4D, 0.4D, 0.01D);
            }
        }
    }

    private boolean removeLavaBreadthFirstSearch(Level level, BlockPos pos) {
        Deque<BlockPos> deque = new ArrayDeque<>();
        boolean flag = false;
        deque.add(pos);

        for (int i = 0; i < MAX_DEPTH && !deque.isEmpty(); i++) {
            List<BlockPos> snapshot = new ArrayList<>(deque);
            deque.clear();
            for (BlockPos blockpos : snapshot) {
                for (Direction direction : ALL_DIRECTIONS) {
                    BlockPos blockpos1 = blockpos.relative(direction);
                    BlockState blockstate = level.getBlockState(blockpos1);
                    if (blockstate.getFluidState().is(Fluids.LAVA)) {
                        level.setBlock(blockpos1, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL_IMMEDIATE);
                        deque.add(blockpos1);
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }
}
