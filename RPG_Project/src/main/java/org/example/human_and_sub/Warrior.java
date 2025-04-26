package org.example.human_and_sub;

import org.example.items.Armor;
import org.example.items.Item;
import org.example.items.Weapon;
import org.example.moves.Move;

import java.util.ArrayList;
import java.util.List;

public class Warrior extends Human {
    private final Move.Type weakness = Move.Type.Ghost;

    // Normal constructor
    public Warrior(String name) {
        super(name, 100, 100,"" ,null, null, new ArrayList<>(), new ArrayList<>());
    }

    // For importing from saves
    public Warrior(String name, int health, int maxHealth, List<Item> inventory, List<Move> moves, Armor equippedArmor, Weapon equippedWeapon, String statusEffect) {
        super(name, maxHealth, health, statusEffect,equippedWeapon, equippedArmor, moves, inventory);
    }

    @Override
    public void takeDamage(int damage, Move.Type moveType) {
        int multi = 1;
        if (moveType.equals(weakness)) {
            multi = 2;
        }
        this.health -= (multi * (this.equippedArmor.getProtection() * damage));
    }
}
