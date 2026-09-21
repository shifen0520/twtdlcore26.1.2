package com.shifen.twtdlcore.material.data;

import com.shifen.twtdlcore.material.MaterialRegistry;
import net.minecraft.resources.Identifier;

public class MaterialDataTypes {

    public static final RgbColorDataType PRIMARY_COLOR = MaterialDataRegistry.register(
            "primary_color", new RgbColorDataType(Identifier.fromNamespaceAndPath("twtdlcore", "primary_color"))
    );

    public static final MassDataType MASS = MaterialDataRegistry.register(
            "mass", new MassDataType(Identifier.fromNamespaceAndPath("twtdlcore", "mass"))
    );

    public static void init() {

    }
}
