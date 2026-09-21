package com.shifen.twtdlcore.material;

import com.shifen.twtdlcore.material.data.FluidData;
import com.shifen.twtdlcore.material.data.MaterialDataType;
import com.shifen.twtdlcore.material.data.MaterialDataUse;
import net.minecraft.resources.Identifier;

import java.util.*;

public final class Material {
    private final Identifier id;
    private final Map<MaterialDataType<?>, MaterialDataUse<?>> data;
    private final Set<MaterialForm> forms;
    private final FluidData fluidData;

    Material(Identifier id, Map<MaterialDataType<?>, MaterialDataUse<?>> data, Set<MaterialForm> forms, FluidData fluidData) {
        this.id = id;
        this.data = Map.copyOf(data);
        this.forms = Set.copyOf(forms);
        this.fluidData = fluidData;
    }

    public Identifier id() {
        return id;
    }

    public Set<MaterialForm> forms() {
        return forms;
    }

    public Optional<FluidData> fluidData () {
        return Optional.ofNullable(fluidData);
    }

    @SuppressWarnings("unchecked")
    public <D> Optional<D> data(MaterialDataType<D> type) {
        MaterialDataUse<?> use = data.get(type);
        if (use == null) {
            return Optional.empty();
        }
        return Optional.of((D) use.data());
    }
}
