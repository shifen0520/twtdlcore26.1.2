package com.shifen.twtdlcore.material.data;

import net.minecraft.resources.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

public class MaterialDataRegistry {
    private static final Map<Identifier, MaterialDataType<?>> REGISTRY = new LinkedHashMap<>();

    public static <D, H extends MaterialDataType<D>> H register(String path, H handle) {
        REGISTRY.put(Identifier.fromNamespaceAndPath("twtdlcore", path), handle);
        return handle;
    }

    static <D> MaterialDataUse<D> use(MaterialDataType<D> type, D data) {
        return new MaterialDataUse<>(type, data);
    }
}
