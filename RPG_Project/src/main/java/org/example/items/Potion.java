package org.example.items;

public class Potion extends Item {
    private int buff;
    private String potionType;

    public Potion(String name, String description, String rarity, int buff, String potionType) {
        super(name, description, rarity);
        this.buff = buff;
        this.potionType = potionType;
    }

    public int getBuff() {
        return buff;
    }

    public void setBuff(int buff) {
        this.buff = buff;
    }

    public String getPotionType() {
        return potionType;
    }

    public void setPotionType(String potionType) {
        this.potionType = potionType;
    }
}
