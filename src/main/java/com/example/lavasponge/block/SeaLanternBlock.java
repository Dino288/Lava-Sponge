package com.example.lavasponge.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

public class SeaLanternBlock extends Block {
    public SeaLanternBlock() {
        super(BlockBehaviour.Properties.of()
                .mapColor(MapColor.COLOR_ORANGE)
                .strength(0.3F)
                .lightLevel(state -> 15)
                .sound(SoundType.GLASS));
    }
}
