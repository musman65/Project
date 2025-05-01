package org.example.human_and_sub;

import org.example.items.Armor;
import org.example.items.Item;
import org.example.items.Weapon;
import org.example.moves.Move;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Warrior extends Human {
    private final Move.Type weakness = Move.Type.Ghost;

    // Normal constructor
    public Warrior(String name) {
        super(name, 100, 100, null, null, new ArrayList<>(), new ArrayList<>(), new HashMap<>());
    }

    // For importing from saves
    public Warrior(String name, int health, int maxHealth, List<Item> inventory, List<Move> moves, Armor equippedArmor, Weapon equippedWeapon, Map<Move.Status, Integer> map) {
        super(name, health, maxHealth ,equippedWeapon, equippedArmor, moves, inventory, map);
    }

    /**
     * Allows the user to take damage while taking into account of its weakness
     * @param damage how much damage it takes
     * @param moveType the type of move that was used to check if the entity is weak to the move
     */
    @Override
    public void takeDamage(int damage, Move.Type moveType) {
        int multi = 1;
        int armorStatus = 1;
        float currentProt = this.equippedArmor == null ? 1 : this.equippedArmor.getProtection();
        if (moveType.equals(weakness)) {
            multi = 2;
        }
        this.health -= (multi * (currentProt * damage));
    }
}
