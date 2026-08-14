package com.example.lavasponge.structure;

import com.example.lavasponge.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;

public class LavaOceanMonumentPiece extends StructurePiece {

    private static final int SIZE = 4;

    public LavaOceanMonumentPiece(int x, int y, int z) {
        super(ModStructures.LAVA_OCEAN_MONUMENT_PIECE.get(), 0,
                new BoundingBox(x - SIZE, y, z - SIZE, x + SIZE, y + 4, z + SIZE));
    }

    public LavaOceanMonumentPiece(StructurePieceType type, CompoundTag tag) {
        super(type, tag);
    }

    public static StructurePiece create(StructurePieceSerializationContext context, CompoundTag tag) {
        return new LavaOceanMonumentPiece(ModStructures.LAVA_OCEAN_MONUMENT_PIECE.get(), tag);
    }

    @Override
    protected void addAdditionalSaveData(StructurePieceSerializationContext context, CompoundTag tag) {
    }

    @Override
    public void postProcess(WorldGenLevel level, StructureManager structureManager, ChunkGenerator chunkGenerator,
                            RandomSource randomSource, BoundingBox chunkBox, ChunkPos chunkPos, BlockPos pos) {
        BlockState prissian = ModBlocks.PRISMIANE.get().defaultBlockState();
        BlockState magmarine = ModBlocks.MAGMARINE.get().defaultBlockState();
        BlockState glowstone = ModBlocks.SEA_LANTERN.get().defaultBlockState();
        BlockState netherite = Blocks.NETHERITE_BLOCK.defaultBlockState();
        BlockState lava = Blocks.LAVA.defaultBlockState();

        // base platform
        for (int dx = -SIZE; dx <= SIZE; dx++) {
            for (int dz = -SIZE; dz <= SIZE; dz++) {
                this.placeBlock(level, prissian, SIZE + dx, 0, SIZE + dz, chunkBox);
            }
        }

        // walls
        for (int dy = 1; dy <= 3; dy++) {
            for (int dx = -SIZE; dx <= SIZE; dx++) {
                this.placeBlock(level, prissian, SIZE + dx, dy, 0, chunkBox);
                this.placeBlock(level, prissian, SIZE + dx, dy, 2 * SIZE, chunkBox);
                this.placeBlock(level, prissian, 0, dy, SIZE + dx, chunkBox);
                this.placeBlock(level, prissian, 2 * SIZE, dy, SIZE + dx, chunkBox);
            }
        }

        // corner pillars (magmarine)
        for (int dy = 1; dy <= 4; dy++) {
            this.placeBlock(level, magmarine, 0, dy, 0, chunkBox);
            this.placeBlock(level, magmarine, 0, dy, 2 * SIZE, chunkBox);
            this.placeBlock(level, magmarine, 2 * SIZE, dy, 0, chunkBox);
            this.placeBlock(level, magmarine, 2 * SIZE, dy, 2 * SIZE, chunkBox);
        }

        // netherite "gold room" - ring of 8 on the interior floor
        for (int dx = -1; dx <= 1; dx++) {
            for (int dz = -1; dz <= 1; dz++) {
                if (dx == 0 && dz == 0) {
                    continue;
                }
                this.placeBlock(level, netherite, SIZE + dx, 1, SIZE + dz, chunkBox);
            }
        }

        // fill interior with lava
        for (int dy = 2; dy <= 3; dy++) {
            for (int dx = -(SIZE - 1); dx <= SIZE - 1; dx++) {
                for (int dz = -(SIZE - 1); dz <= SIZE - 1; dz++) {
                    this.placeBlock(level, lava, SIZE + dx, dy, SIZE + dz, chunkBox);
                }
            }
        }

        // ceiling with glowstone accents (corners stay as pillars)
        for (int dx = -SIZE; dx <= SIZE; dx++) {
            for (int dz = -SIZE; dz <= SIZE; dz++) {
                if ((dx == -SIZE || dx == SIZE) && (dz == -SIZE || dz == SIZE)) {
                    continue;
                }
                if ((dx % 2 == 0) && (dz % 2 == 0)) {
                    this.placeBlock(level, glowstone, SIZE + dx, 4, SIZE + dz, chunkBox);
                } else {
                    this.placeBlock(level, prissian, SIZE + dx, 4, SIZE + dz, chunkBox);
                }
            }
        }
    }
}
