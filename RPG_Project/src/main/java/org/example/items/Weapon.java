package org.example.items;

import java.util.Objects;

public class Weapon extends Item {
    private int damage;

    public Weapon(String name, String description, String rarity, int damage) {
        super(name, description, rarity);
        this.damage = damage;
    }

    @Override
    public String toString() {
        return super.toString() +
                "[Damage]: " + damage + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Weapon weapon = (Weapon) o;
        return damage == weapon.damage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), damage);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
