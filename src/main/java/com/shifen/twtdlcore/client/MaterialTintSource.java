package com.shifen.twtdlcore.client;

import com.mojang.serialization.MapCodec;
import com.shifen.twtdlcore.material.Material;
import com.shifen.twtdlcore.material.MaterialRegistry;
import com.shifen.twtdlcore.material.data.MaterialDataTypes;
import com.shifen.twtdlcore.material.data.RgbColorData;
import net.minecraft.client.color.item.ItemTintSource;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public record MaterialTintSource() implements ItemTintSource {

    public static final MaterialTintSource INSTANCE = new MaterialTintSource();
    public static final MapCodec<MaterialTintSource> MAP_CODEC = MapCodec.unit(INSTANCE);

    @Override
    public int calculate(ItemStack stack, @Nullable ClientLevel level, @Nullable LivingEntity entity) {
        Identifier itemId = BuiltInRegistries.ITEM.getKey(stack.getItem());
        String path = itemId.getPath();

        // 从物品 ID 反推材料：iron_ingot -> iron
        for (Material material : MaterialRegistry.registered()) {
            if (path.startsWith(material.id().getPath() + "_")) {
                return material.data(MaterialDataTypes.PRIMARY_COLOR)
                        .map(RgbColorData::rgb)
                        .orElse(0xFFFFFF);
            }
        }
        return 0xFFFFFF;
    }

    @Override
    public MapCodec<? extends ItemTintSource> type() {
        return MAP_CODEC;
    }
}