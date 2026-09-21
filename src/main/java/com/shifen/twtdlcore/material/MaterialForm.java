package com.shifen.twtdlcore.material;

public enum MaterialForm {
    INGOT("ingot", "锭", "item/material/ingot"),
    DUST("dust", "粉", "item/material/dust"),
    PLATE("plate", "板", "item/material/plate"),
    GEAR("gear", "齿轮", "item/material/gear"),
    FLUID("fluid", "流体", "block/fluid/fluid");

    private final String suffix;
    private final String zhCn;
    private final String texturePath;

    MaterialForm(String suffix, String zhCn, String texturePath) {
        this.suffix = suffix;
        this.zhCn = zhCn;
        this.texturePath = texturePath;
    }

    public String suffix() {
        return suffix;
    }

    public String zhCn() {
        return zhCn;
    }

    public String texturePath() {
        return texturePath;
    }
}