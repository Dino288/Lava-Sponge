package com.example.lavasponge;

import com.example.lavasponge.block.ModBlocks;
import com.example.lavasponge.item.ModItems;
import com.example.lavasponge.structure.ModStructures;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

@Mod(LavaSpongeMod.MOD_ID)
public class LavaSpongeMod {
    public static final String MOD_ID = "lavasponge";

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final Supplier<CreativeModeTab> LAVA_SPONGE_TAB = CREATIVE_MODE_TABS.register("lavasponge_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.lavasponge"))
                    .icon(() -> new ItemStack(ModBlocks.LAVA_SPONGE.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.LAVA_SPONGE.get());
                        output.accept(ModItems.WET_LAVA_SPONGE.get());
                        output.accept(ModItems.PRISMIANE.get());
                        output.accept(ModItems.MAGMARINE.get());
                        output.accept(ModItems.MAGMA_LANTERN.get());
                        output.accept(ModItems.PRISSIAN_BRICKS.get());
                        output.accept(ModItems.PRISSIAN_CHISELED.get());
                        output.accept(ModItems.PRISSIAN_PILLAR.get());
                        output.accept(ModItems.PRISSIAN_SLAB.get());
                        output.accept(ModItems.PRISSIAN_STAIRS.get());
                        output.accept(ModItems.PRISSIAN_TILES.get());
                        output.accept(ModItems.PRISSIAN_WALL.get());
                    })
                    .build());

    public LavaSpongeMod(IEventBus modEventBus) {
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModStructures.STRUCTURE_TYPES.register(modEventBus);
        ModStructures.STRUCTURE_PIECE_TYPES.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}
