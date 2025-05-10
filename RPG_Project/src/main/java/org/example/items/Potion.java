package org.example.items;

public class Potion extends Item {
    private int buff;

    public Potion(String name, String description, String rarity, int buff) {
        super(name, description, rarity);
        this.buff = buff;
    }

    public int getBuff() {
        return buff;
    }

    public void setBuff(int buff) {
        this.buff = buff;
    }
}
