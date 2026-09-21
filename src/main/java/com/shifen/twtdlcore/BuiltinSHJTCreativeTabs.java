package com.shifen.twtdlcore;

import com.gto.registrylib.util.entry.RegistryEntry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

import java.util.Map;

public final class BuiltinSHJTCreativeTabs {
    public static final RegistryEntry<CreativeModeTab, CreativeModeTab> MATERIALS;
    public static final RegistryEntry<CreativeModeTab, CreativeModeTab> FLUIDS;

    private BuiltinSHJTCreativeTabs() {
    }

    public static void init() {
    }

    static {
        MATERIALS = Twtdlcore.REGISTRY.creativeTab("materials", "SHJTech Materials", Map.of());
        FLUIDS = Twtdlcore.REGISTRY.creativeTab("fluids", "SHJTTech Fluids", Map.of());

        Twtdlcore.REGISTRY.defaultCreativeTab(
                ResourceKey.create(Registries.CREATIVE_MODE_TAB,
                        Identifier.fromNamespaceAndPath("twtdlcore", "materials"))
        );
    }
}
