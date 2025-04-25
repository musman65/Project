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
        super(name, 100, 100, new ArrayList<>(), new ArrayList<>(), new Armor(), new Weapon());
    }

    // For importing from saves
    public Wizard(String name, int health, int maxHealth, List<Item> inventory, List<Move> moves, Armor equippedArmor, Weapon equippedWeapon) {
        super(name, health, maxHealth, inventory, moves, equippedArmor, equippedWeapon);
    }

    public String easyExport() {
        String str = "";
        str += this.name + ",";
        str += this.health + ",";
        str += this.maxHealth + ",";
        str += this.equippedArmor + ",";
        str += this.equippedWeapon + ",";

        for (int i = 0; i < inventory.size(); i++) {
            str += inventory.get(i).getName() + ",";
        }
        for (int i = 0; i < moves.size(); i++) {
            if (i == moves.size() - 1) {
                str += moves.get(i).getName() + "\n";
            } else {
                str += moves.get(i).getName() + ",";
            }
        }

        return str;
    }
}
