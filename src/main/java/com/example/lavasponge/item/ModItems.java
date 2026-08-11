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

    private ModItems() {
    }
}
