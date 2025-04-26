package org.example.human_and_sub;

import org.example.Player;
import org.example.items.Armor;
import org.example.items.Item;
import org.example.items.Potion;
import org.example.items.Weapon;
import org.example.moves.Move;

import java.util.List;
import java.util.Scanner;

public abstract class Human extends Player { // User Class
    protected Weapon equippedWeapon;
    protected Armor equippedArmor;
    protected List<Move> moves;
    protected List<Item> inventory;

    public Scanner in = new Scanner(System.in);

    public Human(String name, float health, float maxHealth, List<Item> inventory, List<Move> moves, Armor equippedArmor, Weapon equippedWeapon) {
        super(name, health, maxHealth);
        this.equippedArmor = equippedArmor;
        this.equippedWeapon = equippedWeapon;
        this.moves = moves;
        this.inventory = inventory;
    }

    @Override
    public Move choseMove(Player player) {
        for (int i = 1; i <= moves.size(); i++) {
            System.out.print(i + ".)");
            System.out.println(moves.get(i - 1));
        }

        System.out.println("What move do you want to use?");
        return moves.get(in.nextInt() - 1);
    }

    public void usePotion(Potion potion) {
        //TODO: make a use potion (check for potion type)
    }

    public void equipItem(Item item) {
        if (inventory.contains(item)) {
            if (item instanceof Armor a) {
                this.inventory.add(this.equippedArmor);
                this.maxHealth -= (100 - (this.equippedArmor.getProtection() * 100));
                this.inventory.remove(a);
                this.equippedArmor = a;
                this.maxHealth += (100 - (this.equippedArmor.getProtection() * 100));
                System.out.println("Equipped " + equippedArmor.getName() + "!");
            } else if (item instanceof Weapon w) {
                this.inventory.add(this.equippedWeapon);
                this.inventory.remove(w);
                this.equippedWeapon = w;
                System.out.println("Equipped " + equippedWeapon.getName() + "!");
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

    /**
     * Allows the exportation of the save file of the Human class to a .txt file
     * @return the string to export into to the .txt file
     */
    public String easyExportHuman() {
        String str = "";
        str += this.name + ",";
        str += this.health + ",";
        str += this.maxHealth + ",";
        str += this.equippedArmor + ",";
        str += this.equippedWeapon + ",";

        for (int i = 0; i < inventory.size(); i++) {
            str += inventory.get(i).getName() + ",";
            str += inventory.get(i).getDescription() + ",";
            str += inventory.get(i).getRarity() + ",";
        }
        for (int i = 0; i < moves.size(); i++) {
            if (i == moves.size() - 1) {
                str += moves.get(i).getName() + ",";
                str += moves.get(i).getMoveType() + ",";
                str += moves.get(i).getDamage() + "\n";
            } else {
                str += moves.get(i).getName() + ",";
                str += moves.get(i).getMoveType() + ",";
                str += moves.get(i).getDamage() + ",";
            }
        }

        return str;
    }

    @Override
    public String toString() {
        String invStr = "inventory = {";
        String moveStr = "moves = {";

        for (int i = 0; i < inventory.size(); i++) {
            invStr += inventory.get(i).toString() + ", ";
        }
        for (int i = 0; i < moves.size(); i++) {
            moveStr += "\n" + moves.get(i).toString() + ",";
        }

        return super.toString() +
                ", equippedWeapon=" + equippedWeapon +
                ", equippedArmor=" + equippedArmor +
                ", moves=" + moveStr +
                ", inventory=" + invStr;
    }
}
