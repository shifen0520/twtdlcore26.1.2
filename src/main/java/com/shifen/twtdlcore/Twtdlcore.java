package com.shifen.twtdlcore;

import com.gto.registrylib.RegistryCore;

import com.shifen.twtdlcore.material.MaterialRegistry;
import com.shifen.twtdlcore.material.Materials;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(Twtdlcore.MODID)
public class Twtdlcore {
    public static final String MODID = "twtdlcore";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);
    public static final RegistryCore REGISTRY = RegistryCore.create(MODID);

    public Twtdlcore(IEventBus modEventBus, ModContainer modContainer) {
        NeoForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        BuiltinSHJTCreativeTabs.init();
        Materials.init();
        MaterialRegistry.freeze();
        Items.register();
        Fluids.register();
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }
}
