package com.example.lavasponge.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

public class SeaLanternBlock extends Block {
    public SeaLanternBlock() {
        super(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_YELLOW)
            .strength(0.6F)
            .sound(SoundType.GLASS));
    }
}