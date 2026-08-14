package com.example.lavasponge.structure;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;

import java.util.Optional;

public class LavaOceanMonumentStructure extends Structure {

    public static final MapCodec<LavaOceanMonumentStructure> CODEC = simpleCodec(LavaOceanMonumentStructure::new);
    private static final int NETHER_MONUMENT_Y = 48;

    public LavaOceanMonumentStructure(StructureSettings settings) {
        super(settings);
    }

    @Override
    protected Optional<GenerationStub> findGenerationPoint(GenerationContext context) {
        int x = context.chunkPos().getMiddleBlockX();
        int z = context.chunkPos().getMiddleBlockZ();
        int minY = context.heightAccessor().getMinBuildHeight() + 8;
        int maxY = context.heightAccessor().getMaxBuildHeight() - 32;
        int y = Math.max(minY, Math.min(NETHER_MONUMENT_Y, maxY));

        BlockPos pos = new BlockPos(x, y, z);
        return Optional.of(new GenerationStub(pos, builder -> builder.addPiece(new LavaOceanMonumentPiece(
                context.structureTemplateManager(), pos.getX(), pos.getY(), pos.getZ()))));
    }

    @Override
    public StructureType<?> type() {
        return ModStructures.LAVA_OCEAN_MONUMENT.get();
    }
}
