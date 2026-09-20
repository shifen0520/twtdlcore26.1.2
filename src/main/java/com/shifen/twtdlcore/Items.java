package com.shifen.twtdlcore;

import com.shifen.twtdlcore.material.Material;
import com.shifen.twtdlcore.material.MaterialForm;
import com.shifen.twtdlcore.material.MaterialRegistry;
import net.minecraft.world.item.Item;

public final class Items {
    private Items() {
    }

    public static void register(){
        for (Material material : MaterialRegistry.registered()) {
            for (MaterialForm form : material.forms()) {
                String name = material.id().getPath() + "_" + form.suffix();
                String displayName = material.id().getPath() + " " + form.suffix();

                Twtdlcore.REGISTRY
                        .item(name, Item::new)
                        .lang(displayName)
                        .register();}
        }
    }

    private static String toDisplayName(String path) {
        String[] words = path.split("_");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                if (!sb.isEmpty()) sb.append(" ");
                sb.append(Character.toUpperCase(word.charAt(0)));
                sb.append(word.substring(1));
            }
        }
        return sb.toString();
    }

}
