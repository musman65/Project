package org.example.items;

import java.util.Objects;

public class Item {
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
                "[Rartiy]: " + rarity +
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
}
