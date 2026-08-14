package com.example.lavasponge.structure;

import com.example.lavasponge.LavaSpongeMod;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.TemplateStructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

public class LavaOceanMonumentPiece extends TemplateStructurePiece {

    private static final ResourceLocation TEMPLATE = ResourceLocation.fromNamespaceAndPath(LavaSpongeMod.MOD_ID, "lava_monument");

    public LavaOceanMonumentPiece(StructureTemplateManager templateManager, int x, int y, int z) {
        super(
                ModStructures.LAVA_OCEAN_MONUMENT_PIECE.get(),
                0,
                templateManager,
                TEMPLATE,
                TEMPLATE.toString(),
                makeSettings(),
                centeredPosition(templateManager, new BlockPos(x, y, z)));
    }

    public LavaOceanMonumentPiece(StructureTemplateManager templateManager, CompoundTag tag) {
        super(ModStructures.LAVA_OCEAN_MONUMENT_PIECE.get(), tag, templateManager, location -> makeSettings());
    }

    public static StructurePiece create(StructurePieceSerializationContext context, CompoundTag tag) {
        return new LavaOceanMonumentPiece(context.structureTemplateManager(), tag);
    }

    private static StructurePlaceSettings makeSettings() {
        return new StructurePlaceSettings()
                .setIgnoreEntities(false)
                .setFinalizeEntities(true)
                .setKnownShape(true);
    }

    private static BlockPos centeredPosition(StructureTemplateManager templateManager, BlockPos locatePos) {
        StructureTemplate template = templateManager.getOrCreate(TEMPLATE);
        return locatePos.offset(-template.getSize().getX() / 2, 0, -template.getSize().getZ() / 2);
    }

    @Override
    protected void handleDataMarker(String metadata, BlockPos pos, ServerLevelAccessor level,
                                    RandomSource random, BoundingBox box) {
    }
}
