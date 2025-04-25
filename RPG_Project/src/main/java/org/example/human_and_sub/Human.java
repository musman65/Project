package org.example.human_and_sub;

import org.example.Player;
import org.example.items.Armor;
import org.example.items.Item;
import org.example.items.Potion;
import org.example.items.Weapon;
import org.example.moves.Move;

import java.util.List;

public abstract class Human extends Player { // User Class
    protected Weapon equippedWeapon;
    protected Armor equippedArmor;
    protected List<Move> moves;
    protected List<Item> inventory;

    public Human(String name, int health, int maxHealth, List<Item> inventory, List<Move> moves, Armor equippedArmor, Weapon equippedWeapon) {
        super(name, health, maxHealth);
        this.inventory = inventory;
        this.moves = moves;
        this.equippedArmor = equippedArmor;
        this.equippedWeapon = equippedWeapon;
    }

    @Override
    public Move choseMove(Player player) {
        //TODO: loop thru moves and make user chose one
        return null;
    }

    @Override
    public void takeDamage(int damage) {
        //TODO: check armor buff and take less dmg // check if weak to typing
    }

    public void usePotion(Potion potion) {
        //TODO: use potion
    }

    public void equipItem(Item item) {
        if (inventory.contains(item)) {
            if (item instanceof Armor a) {
                this.inventory.add(this.equippedArmor);
                this.inventory.remove(a);
                this.equippedArmor = a;
                //TODO: print equipped status, requires armor class to be developed
            } else if (item instanceof Weapon w) {
                this.inventory.add(this.equippedWeapon);
                this.inventory.remove(w);
                this.equippedWeapon = w;
                //TODO: print equipped status, requires weapon class to be developed
            } else {
                System.out.println("Cannot equip that item!");
            }
        } else {
            System.out.println("You don't own that item"); // Should never run if code is  maintained well, but it's just in case
        }
    }

    /**
     * Adds an item to the List of items: inventory
     * @param item the item to add in the inventory
     */
    public void addItemToInventory(Item item) {
        this.inventory.add(item);
    }

    /**
     * Adds a move to the List of moves: moves
     * @param move the move to add in the moves
     */
    public void addMoveToMoves(Move move) {
        this.moves.add(move);
    }
}
