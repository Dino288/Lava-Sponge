package com.example.lavasponge.structure;

import com.example.lavasponge.LavaSpongeMod;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModStructures {
    public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPES =
            DeferredRegister.create(Registries.STRUCTURE_TYPE, LavaSpongeMod.MOD_ID);

    public static final DeferredRegister<StructurePieceType> STRUCTURE_PIECE_TYPES =
            DeferredRegister.create(Registries.STRUCTURE_PIECE, LavaSpongeMod.MOD_ID);

    public static final DeferredHolder<StructureType<?>, StructureType<LavaOceanMonumentStructure>> LAVA_OCEAN_MONUMENT =
            STRUCTURE_TYPES.register("lava_ocean_monument",
                    () -> explicitStructureTypeTyping(LavaOceanMonumentStructure.CODEC));

    public static final DeferredHolder<StructurePieceType, StructurePieceType> LAVA_OCEAN_MONUMENT_PIECE =
            STRUCTURE_PIECE_TYPES.register("lava_ocean_monument",
                    () -> (StructurePieceType) LavaOceanMonumentPiece::create);

    private static <T extends Structure> StructureType<T> explicitStructureTypeTyping(MapCodec<T> structureCodec) {
        return () -> structureCodec;
    }

    private ModStructures() {
    }
}
