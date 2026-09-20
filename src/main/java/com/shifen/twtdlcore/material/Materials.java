package com.shifen.twtdlcore.material;

public final class Materials {
    public static final Material IRON ;

    private Materials(){
    }

    static{
        IRON = MaterialRegistry.register("iron")
                .color(0xD8D8D8)
                .mass(56)
                .forms(MaterialForm.INGOT, MaterialForm.DUST, MaterialForm.PLATE, MaterialForm.GEAR)
                .build();
    }

    public static void init() {
    }
}
