package com.shifen.twtdlcore.material;

import net.minecraft.resources.Identifier;

import java.util.Set;

public record Material (Identifier id, int color, int mass, Set<MaterialForm> forms) {
}
