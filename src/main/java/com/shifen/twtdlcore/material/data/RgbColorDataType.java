package com.shifen.twtdlcore.material.data;

import net.minecraft.resources.Identifier;

public final class RgbColorDataType extends MaterialDataType<RgbColorData> {
    public RgbColorDataType(Identifier id) {
        super(id);
    }

    public MaterialDataUse<RgbColorData> rgb(int rgb) {
        return use(RgbColorData.create(rgb));
    }
}