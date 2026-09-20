package com.shifen.twtdlcore.material;

import net.minecraft.resources.Identifier;

import java.util.*;

public class MaterialRegistry {
    private static final Map<Identifier, Material> REGISTRY = new LinkedHashMap<>();

    private static boolean frozen = false;

    private MaterialRegistry(){
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
            throw new IllegalStateException("on material for" + id);
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
        private int color = 0xFFFFFF;
        private int mass = 0;
        private final Set<MaterialForm> forms = new LinkedHashSet<>();

        private Builder(Identifier id) {
            this.id = id;
        }

        public Builder color(int color) {
            this.color = color;
            return this;
        }

        public Builder mass(int mass) {
            this.mass = mass;
            return this;
        }

        public Builder form(MaterialForm form) {
            this.forms.add(form);
            return this;
        }

        public Builder forms(MaterialForm... forms) {
            for (MaterialForm form : forms) {
                this.forms.add(form);
            }
            return this;
        }

        public Material build() {
            if (frozen) {
                throw new IllegalStateException("material registry is frozen");
            }
            if (REGISTRY.containsKey(id)) {
                throw new IllegalStateException("duplicate material " + id);
            }
            Material material = new Material(id, color, mass, Set.copyOf(forms));
            REGISTRY.put(id, material);
            return material;
        }
    }
}
