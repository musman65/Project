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
        //TODO: equip the armor or weapon, and storing the other piece in the inventory
    }
}
