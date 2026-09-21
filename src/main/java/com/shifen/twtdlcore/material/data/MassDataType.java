package com.shifen.twtdlcore.material.data;

import net.minecraft.resources.Identifier;

public final class MassDataType extends MaterialDataType<Integer> {
    public MassDataType(Identifier id) {
        super(id);
    }

    public MaterialDataUse<Integer> mass(int mass) {
        return use(mass);
    }
}
