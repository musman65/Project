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
        super(name, 100, 100, new ArrayList<>(), new ArrayList<>(), new Armor(), new Weapon());
    }

    // For importing from saves
    public Warrior(String name, int health, int maxHealth, List<Item> inventory, List<Move> moves, Armor equippedArmor, Weapon equippedWeapon) {
        super(name, health, maxHealth, inventory, moves, equippedArmor, equippedWeapon);
    }
}
