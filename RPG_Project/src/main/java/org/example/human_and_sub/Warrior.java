package org.example.human_and_sub;

import org.example.items.Armor;
import org.example.items.Item;
import org.example.items.Weapon;
import org.example.moves.Move;

import java.util.ArrayList;
import java.util.List;

public class Warrior extends Human {
    private final Move.Type selfType = Move.Type.Physical;
    private final Move.Type weakness = Move.Type.Ghost;

    // Normal constructor
    public Warrior(String name) {
        super(name, 100, 100, new ArrayList<>(), new ArrayList<>(), new Armor("Steelguard Armor", "Forged in the heart of the Emberforge and quenched in sacred waters, the Steelguard Armor\n\tis a relic of the Old Order. Its polished plates gleam with the pride of a thousand battles, and runes etched along \n\tits seams pulse faintly when danger draws near. Worn by knights sworn to protect the realm, it offers not just defense, \n\tbut a legacy.", "Common" ,0.75f), null);
    }

    // For importing from saves
    public Warrior(String name, int health, int maxHealth, List<Item> inventory, List<Move> moves, Armor equippedArmor, Weapon equippedWeapon) {
        super(name, health, maxHealth, inventory, moves, equippedArmor, equippedWeapon);
    }


}
