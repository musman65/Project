package org.example.items;

import java.util.Objects;

public class Armor extends Item {
    private float protection;

    public Armor(String name, String description, String rarity, float protection) {
        super(name, description, rarity);
        this.protection = protection;
    }

    @Override
    public String toString() {
        return super.toString() +
                "[Protection]: " + (100 - (protection * 100)) + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Armor armor = (Armor) o;
        return protection == armor.protection;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(protection);
    }

    public float getProtection() {
        return protection;
    }

    public void setProtection(float protection) {
        this.protection = protection;
    }
}
