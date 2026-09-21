package com.shifen.twtdlcore.material;

import com.shifen.twtdlcore.material.data.MaterialDataTypes;

public final class Materials {
    public static final Material IRON;

    private Materials() {
    }


    static {
        IRON = MaterialRegistry.register("iron")
                .data(MaterialDataTypes.PRIMARY_COLOR.rgb(0xD8D8D8))
                .data(MaterialDataTypes.MASS.mass(56))
                .forms(MaterialForm.INGOT, MaterialForm.DUST, MaterialForm.PLATE, MaterialForm.GEAR)
                .build();
    }

    public static void init() {
        MaterialDataTypes.init();
    }
}