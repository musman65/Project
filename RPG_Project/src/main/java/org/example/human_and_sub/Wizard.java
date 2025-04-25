package org.example.human_and_sub;

import org.example.items.Armor;
import org.example.items.Item;
import org.example.items.Weapon;
import org.example.moves.Move;

import java.util.ArrayList;
import java.util.List;

public class Wizard extends Human{
    private final Move.Type selfType = Move.Type.Ghost;
    private final Move.Type weakness = Move.Type.Physical;

    // Normal constructor
    public Wizard(String name) {
        super(name, 100, 100, new ArrayList<>(), new ArrayList<>(), null, null);
    }

    // For importing from saves
    public Wizard(String name, int health, int maxHealth, List<Item> inventory, List<Move> moves, Armor equippedArmor, Weapon equippedWeapon) {
        super(name, health, maxHealth, inventory, moves, equippedArmor, equippedWeapon);
    }


}
