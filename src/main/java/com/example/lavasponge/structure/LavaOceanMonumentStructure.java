package com.example.lavasponge.structure;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;

import java.util.Optional;

public class LavaOceanMonumentStructure extends Structure {

    public static final MapCodec<LavaOceanMonumentStructure> CODEC = simpleCodec(LavaOceanMonumentStructure::new);

    public LavaOceanMonumentStructure(StructureSettings settings) {
        super(settings);
    }

    @Override
    protected Optional<GenerationStub> findGenerationPoint(GenerationContext context) {
        int x = context.chunkPos().getMiddleBlockX();
        int z = context.chunkPos().getMiddleBlockZ();
        int y = context.chunkGenerator().getFirstOccupiedHeight(
                x, z, Heightmap.Types.WORLD_SURFACE_WG, context.heightAccessor(), context.randomState());

        int maxY = context.heightAccessor().getMaxBuildHeight() - 6;
        if (y > maxY) {
            y = maxY;
        }

        BlockPos pos = new BlockPos(x, y, z);
        return Optional.of(new GenerationStub(pos, builder -> builder.addPiece(new LavaOceanMonumentPiece(pos.getX(), pos.getY(), pos.getZ()))));
    }

    @Override
    public StructureType<?> type() {
        return ModStructures.LAVA_OCEAN_MONUMENT.get();
    }
}
