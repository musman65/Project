package org.example.items;

import java.util.Comparator;
import java.util.Objects;

public abstract class Item {
    private String name;
    private String description;
    private String rarity;

    public Item(String name, String description, String rarity) {
        this.name = name;
        this.description = description;
        this.rarity = rarity;
    }

    @Override
    public String toString() {
        return "\n[Name]: \"" + name.substring(0, 1).toUpperCase() + name.substring(1) + "\"\n" +
                "[Rarity]: " + rarity + "\n" +
                "\t\"" + description + "\"\n" ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }
}
