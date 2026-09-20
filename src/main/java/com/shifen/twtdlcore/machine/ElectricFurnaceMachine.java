package com.shifen.twtdlcore.machine;

import cn.howxu.mmcr.api.publicapi.MachineDefinitionProvider;
import cn.howxu.mmcr.api.publicapi.event.MMCRMachineDefinationsEvent;
import cn.howxu.mmcr.api.publicapi.machine.MachineBuilder;
import cn.howxu.mmcr.api.publicapi.machine.MachineDefinition;
import net.minecraft.resources.Identifier;

public class ElectricFurnaceMachine implements MachineDefinitionProvider {
    private static final Identifier ELECTRIC_FURNACE =
            Identifier.tryParse("electric_furnace");

    @Override
    public void register(MMCRMachineDefinationsEvent event) {
        if (event.definitions().containsKey(ELECTRIC_FURNACE)) {
            return;
        }
        MachineDefinition definition = MachineBuilder
                .machine(ELECTRIC_FURNACE)
                .displayNameKey("machine.electric_furnace")
                .appearance(a -> a.machineBasicBlock(Identifier.parse("minecraft:iron_block")))
                .build();
        event.registerMachine(definition);
    }
}
