package org.example.human_and_sub;

import org.example.items.Armor;
import org.example.items.Item;
import org.example.items.Weapon;
import org.example.moves.Move;

import java.sql.SQLOutput;
import java.util.*;

public class Wizard extends Human{
    private final Move.Type weakness = Move.Type.Physical;

    // Normal constructor
    public Wizard(String name) {
        super(name, 100, 100, null, null, new ArrayList<>(), new ArrayList<>(), new HashMap<>());
    }

    // For importing from saves
    public Wizard(String name, int health, int maxHealth, List<Item> inventory, List<Move> moves, Armor equippedArmor, Weapon equippedWeapon, Map<Move.Status, Integer> map) {
        super(name, health, maxHealth, equippedWeapon, equippedArmor, moves, inventory, map);
    }

    /**
     * Allows the user to take damage while taking into account of its weakness
     * @param damage how much damage it takes
     * @param move the move that was used
     */
    @Override
    public void takeDamage(int damage, Move move) {
        int multi = 1;
        float currentProt = this.equippedArmor == null ? 1 : this.equippedArmor.getProtection();
        int nullify = 1;

        //todo: check for status effects

        if (this.statusEffects.get(Move.Status.ArmorBreak) > 0) {
            currentProt *= 2;
            this.statusEffects.put(Move.Status.ArmorBreak, this.statusEffects.get(Move.Status.ArmorBreak) - 1);
        }
        if (this.statusEffects.get(Move.Status.ArmorUp) > 0) {
            currentProt /= 2;
            this.statusEffects.put(Move.Status.ArmorUp, this.statusEffects.get(Move.Status.ArmorUp) - 1);
        }
        if (this.statusEffects.get(Move.Status.Burn) > 0) {
            this.health -= 5;
            this.statusEffects.put(Move.Status.Burn, this.statusEffects.get(Move.Status.Burn) - 1);
        }

        if (move.getMoveType().equals(weakness)) {
            multi = 2;
        }

        this.health -= nullify * (multi * (currentProt * damage));
    }
}
