package com.shifen.twtdlcore;

import com.shifen.twtdlcore.material.Material;
import com.shifen.twtdlcore.material.MaterialRegistry;
import com.shifen.twtdlcore.material.data.FluidData;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;

public final class Fluids {
    private Fluids() {
    }

    public static void register() {
        for (Material material : MaterialRegistry.registered()) {
            if (material.fluidData().isEmpty()) {
                continue;
            }
            FluidData fd = material.fluidData().get();
            String name = material.id().getPath() + "_fluid";

            Identifier still = Identifier.fromNamespaceAndPath("twtdlcore", "block/fluid/" + material.id().getPath() + "_still");
            Identifier flow  = Identifier.fromNamespaceAndPath("twtdlcore", "block/fluid/" + material.id().getPath() + "_flow");

            Twtdlcore.REGISTRY
                    .fluid(name, still, flow, BaseFlowingFluid.Flowing::new)
                    .properties(p -> p.density(fd.density()).viscosity(fd.viscosity()).temperature(fd.temperature()))
                    .lang(material.id().getPath() + " Fluid")
                    .clientExtension(still, flow, fd.tintColor())
                    .register();
        }
    }
}
