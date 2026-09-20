package com.shifen.twtdlcore;

import com.gto.registrylib.util.entry.RegistryEntry;
import net.minecraft.world.item.CreativeModeTab;

import java.util.Map;

public final class BuiltinSHJTCreativeTabs {
    public static final RegistryEntry<CreativeModeTab, CreativeModeTab> MATERIALS;

    private BuiltinSHJTCreativeTabs() {
    }

    public static void init() {
    }

    static {
        MATERIALS = Twtdlcore.REGISTRY.creativeTab("materials", "SHJTech Materials", Map.of());
    }
}
