package com.example.lavasponge.block;

import com.example.lavasponge.LavaSpongeMod;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(LavaSpongeMod.MOD_ID);

    public static final DeferredBlock<LavaSpongeBlock> LAVA_SPONGE = BLOCKS.register("lava_sponge",
            () -> new LavaSpongeBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_ORANGE)
                    .strength(0.6F)
                    .sound(SoundType.SPONGE)));

    public static final DeferredBlock<WetLavaSpongeBlock> WET_LAVA_SPONGE = BLOCKS.register("lava_sponge_wet",
            () -> new WetLavaSpongeBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GRAY)
                    .strength(0.6F)
                    .sound(SoundType.SPONGE)));

    public static final DeferredBlock<PrismarineBlock> PRISMIANE = BLOCKS.register("prissian",
            () -> new PrismarineBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLUE)
                    .strength(1.0F)
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<MagmarineBlock> MAGMARINE = BLOCKS.register("magmarine",
            () -> new MagmarineBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GRAY)
                    .strength(1.5F)
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<SeaLanternBlock> MAGMA_LANTERN = BLOCKS.register("magma_lantern",
            SeaLanternBlock::new);

    public static final DeferredBlock<Block> PRISSIAN_BRICKS = BLOCKS.register("prissian_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).strength(1.0F).sound(SoundType.STONE)));

    public static final DeferredBlock<Block> PRISSIAN_CHISELED = BLOCKS.register("prissian_chiseled",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).strength(1.0F).sound(SoundType.STONE)));

    public static final DeferredBlock<Block> PRISSIAN_PILLAR = BLOCKS.register("prissian_pillar",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).strength(1.0F).sound(SoundType.STONE)));

    public static final DeferredBlock<Block> PRISSIAN_SLAB = BLOCKS.register("prissian_slab",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).strength(1.0F).sound(SoundType.STONE)));

    public static final DeferredBlock<Block> PRISSIAN_STAIRS = BLOCKS.register("prissian_stairs",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).strength(1.0F).sound(SoundType.STONE)));

    public static final DeferredBlock<Block> PRISSIAN_TILES = BLOCKS.register("prissian_tiles",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).strength(1.0F).sound(SoundType.STONE)));

    public static final DeferredBlock<Block> PRISSIAN_WALL = BLOCKS.register("prissian_wall",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).strength(1.0F).sound(SoundType.STONE)));

    private ModBlocks() {
    }
}
