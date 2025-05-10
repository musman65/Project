package org.example.human_and_sub;

import org.example.items.Armor;
import org.example.items.Item;
import org.example.items.Weapon;
import org.example.moves.Move;

import java.util.*;

public class Warrior extends Human {
    private final Move.Type weakness = Move.Type.Ghost;

    // Normal constructor
    public Warrior(String name, List<Move> moves) {
        super(name, 250, 250, new Weapon("Steel Sword", "The default blade!", "Common", 10), new Armor("Steel armor", "The default armor!", "Common", 0.90f), moves, new ArrayList<>(), new HashMap<>());
    }

    // For importing from saves
    public Warrior(String name, int health, int maxHealth, List<Item> inventory, List<Move> moves, Armor equippedArmor, Weapon equippedWeapon, Map<Move.Status, Integer> map) {
        super(name, health, maxHealth ,equippedWeapon, equippedArmor, moves, inventory, map);
    }

    /**
     * Allows the user to take damage while taking into account of its weakness
     * @param damage how much damage it takes
     * @param move the move that was used
     */
    @Override
    public void takeDamage(int damage, Move move) {
        int[] nums = takeDamageMainLogic(move);
        float currentProt = this.equippedArmor == null ? 1 : this.equippedArmor.getProtection();

        if (this.statusEffects.get(Move.Status.ArmorBreak) > 0) {
            currentProt *= 2;
            this.statusEffects.put(Move.Status.ArmorBreak, this.statusEffects.get(Move.Status.ArmorBreak) - 1);
        }
        if (this.statusEffects.get(Move.Status.ArmorUp) > 0) {
            currentProt /= 2;
            this.statusEffects.put(Move.Status.ArmorUp, this.statusEffects.get(Move.Status.ArmorUp) - 1);
        }

        if (move.getMoveType().equals(weakness)) {
            nums[0] = 2;
        }

        this.health -= nums[1] * (nums[0] * (currentProt * damage));
    }
}
