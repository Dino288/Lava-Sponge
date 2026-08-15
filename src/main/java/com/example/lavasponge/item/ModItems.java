package com.example.lavasponge.item;

import com.example.lavasponge.LavaSpongeMod;
import com.example.lavasponge.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(LavaSpongeMod.MOD_ID);

    public static final DeferredItem<BlockItem> LAVA_SPONGE = ITEMS.registerItem("lava_sponge",
            properties -> new BlockItem(ModBlocks.LAVA_SPONGE.get(), properties));

    public static final DeferredItem<BlockItem> WET_LAVA_SPONGE = ITEMS.registerItem("lava_sponge_wet",
            properties -> new BlockItem(ModBlocks.WET_LAVA_SPONGE.get(), properties));

    public static final DeferredItem<BlockItem> PRISMIANE = ITEMS.registerItem("prissian",
            properties -> new BlockItem(ModBlocks.PRISMIANE.get(), properties));

    public static final DeferredItem<BlockItem> MAGMARINE = ITEMS.registerItem("magmarine",
            properties -> new BlockItem(ModBlocks.MAGMARINE.get(), properties));

    public static final DeferredItem<BlockItem> MAGMA_LANTERN = ITEMS.registerItem("magma_lantern",
            properties -> new BlockItem(ModBlocks.MAGMA_LANTERN.get(), properties));

    public static final DeferredItem<BlockItem> PRISSIAN_BRICKS = ITEMS.registerItem("prissian_bricks",
            properties -> new BlockItem(ModBlocks.PRISSIAN_BRICKS.get(), properties));

    public static final DeferredItem<BlockItem> PRISSIAN_CHISELED = ITEMS.registerItem("prissian_chiseled",
            properties -> new BlockItem(ModBlocks.PRISSIAN_CHISELED.get(), properties));

    public static final DeferredItem<BlockItem> PRISSIAN_PILLAR = ITEMS.registerItem("prissian_pillar",
            properties -> new BlockItem(ModBlocks.PRISSIAN_PILLAR.get(), properties));

    public static final DeferredItem<BlockItem> PRISSIAN_SLAB = ITEMS.registerItem("prissian_slab",
            properties -> new BlockItem(ModBlocks.PRISSIAN_SLAB.get(), properties));

    public static final DeferredItem<BlockItem> PRISSIAN_STAIRS = ITEMS.registerItem("prissian_stairs",
            properties -> new BlockItem(ModBlocks.PRISSIAN_STAIRS.get(), properties));

    public static final DeferredItem<BlockItem> PRISSIAN_TILES = ITEMS.registerItem("prissian_tiles",
            properties -> new BlockItem(ModBlocks.PRISSIAN_TILES.get(), properties));

    public static final DeferredItem<BlockItem> PRISSIAN_WALL = ITEMS.registerItem("prissian_wall",
            properties -> new BlockItem(ModBlocks.PRISSIAN_WALL.get(), properties));

    private ModItems() {
    }
}
