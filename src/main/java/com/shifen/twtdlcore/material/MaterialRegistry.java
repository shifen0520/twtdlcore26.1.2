package com.shifen.twtdlcore.material;

import com.shifen.twtdlcore.material.data.FluidData;
import com.shifen.twtdlcore.material.data.MaterialDataType;
import com.shifen.twtdlcore.material.data.MaterialDataUse;
import net.minecraft.resources.Identifier;

import java.util.*;

public final class MaterialRegistry {
    private static final Map<Identifier, Material> REGISTRY = new LinkedHashMap<>();
    private static boolean frozen = false;

    private MaterialRegistry() {
    }

    public static Builder register(String path) {
        return register(Identifier.fromNamespaceAndPath("twtdlcore", path));
    }

    public static Builder register(Identifier id) {
        return new Builder(id);
    }

    public static Material require(Identifier id) {
        Material material = REGISTRY.get(id);
        if (material == null) {
            throw new IllegalStateException("no material for " + id);
        }
        return material;
    }

    public static List<Material> registered() {
        return List.copyOf(REGISTRY.values());
    }

    public static boolean isFrozen() {
        return frozen;
    }

    public static void freeze() {
        frozen = true;
    }

    public static final class Builder {
        private final Identifier id;
        private final Map<MaterialDataType<?>, MaterialDataUse<?>> data = new LinkedHashMap<>();
        private final Set<MaterialForm> forms = new LinkedHashSet<>();
        private FluidData fluidData;

        private Builder(Identifier id) {
            this.id = id;
        }

        public Builder data(MaterialDataUse<?> use) {
            if (data.containsKey(use.type())) {
                throw new IllegalStateException("duplicate data type " + use.type().id());
            }
            data.put(use.type(), use);
            return this;
        }

        public Builder forms(MaterialForm... forms) {
            this.forms.addAll(List.of(forms));
            return this;
        }

        public Material build() {
            if (frozen) {
                throw new IllegalStateException("material registry is frozen");
            }
            if (REGISTRY.containsKey(id)) {
                throw new IllegalStateException("duplicate material " + id);
            }
            Material material = new Material(id, data, forms, fluidData);
            REGISTRY.put(id, material);
            return material;
        }
        public Builder fluid(int density, int viscosity, int temperature, int tintColor) {
            this.fluidData = new FluidData(density, viscosity, temperature, tintColor);
            this.forms.add(MaterialForm.FLUID);   // 自动加 FLUID 形态
            return this;
        }
    }
}