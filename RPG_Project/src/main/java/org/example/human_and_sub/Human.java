package org.example.human_and_sub;

import org.example.Player;
import org.example.enemy_and_sub.Enemy;
import org.example.items.Armor;
import org.example.items.Item;
import org.example.items.Potion;
import org.example.items.Weapon;
import org.example.moves.Move;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public abstract class Human extends Player { // User Class
    protected Weapon equippedWeapon;
    protected Armor equippedArmor;
    protected List<Move> moves;
    protected List<Item> inventory;

    public Scanner in = new Scanner(System.in);

    public Human(String name, float health, float maxHealth, Weapon equippedWeapon, Armor equippedArmor, List<Move> moves, List<Item> inventory, Map<Move.Status, Integer> statusEffects) {
        super(name, health, maxHealth, statusEffects);
        this.equippedWeapon = equippedWeapon;
        this.equippedArmor = equippedArmor;
        this.moves = moves;
        this.inventory = inventory;
    }

    /**
     * Handles all the damage dealt with what move was used, what weapon is equipped and any status effects active
     * @param move the move that is used
     * @param enemy the enemy the move is being used against
     */
    @Override
    public void doDamage(Move move, Player enemy) {
        Random rand = new Random();
        float multi = 1;

        if (this.statusEffects.get(Move.Status.DamageBuff) > 0) {
            multi = 2;
            this.statusEffects.put(Move.Status.DamageBuff, this.statusEffects.get(Move.Status.DamageBuff) - 1);
        } else if (this.statusEffects.get(Move.Status.Spook) > 0) {
            multi = 0.5f;
            this.statusEffects.put(Move.Status.Spook, this.statusEffects.get(Move.Status.Spook) - 1);
        }

        // Checks for stun
        if (this.statusEffects.get(Move.Status.Stun) > 0) {
            int willYouBreakFreeFromTheStun = rand.nextInt(1, 6);

            // 20% chance to break free from the stun
            if (willYouBreakFreeFromTheStun == 4) {

                System.out.println("The stun wore off!");
                this.statusEffects.put(Move.Status.Stun, 0); // Sets turns left to 0

                if (move.getEffect() != Move.Effect.Damage) {
                    move.use(this);
                    return;
                }

                enemy.takeDamage((int) (move.getBuff() + equippedWeapon.getDamage() * multi), move);
            } else {
                System.out.println("You are stunned!");
                this.statusEffects.put(Move.Status.Stun, this.statusEffects.get(Move.Status.Stun) - 1);
            }

            if (this.statusEffects.get(Move.Status.Stun) == 0) {
                System.out.println("The stun was lifted, you will be able to attack next round!");
            }

            return;
        }
        //Checks for hypnosis
        if (this.statusEffects.get(Move.Status.Hypnotize) > 0) {
            int willYouHitYourself = rand.nextInt(1, 3);

            // Checks to see if you hit yourself or not
            if (willYouHitYourself == 1) {

                System.out.println("Because you were hypnotized, you ended up hitting yourself!");
                this.takeDamage((int) (move.getBuff() + equippedWeapon.getDamage() * multi), move);
                this.statusEffects.put(Move.Status.Hypnotize, this.statusEffects.get(Move.Status.Hypnotize) - 1);

            } else { // If you don't hit yourself, the move works

                System.out.println("Your move manage to hit to correct target!");
                this.statusEffects.put(Move.Status.Hypnotize, this.statusEffects.get(Move.Status.Hypnotize) - 1);
                if (move.getEffect() != Move.Effect.Damage) {
                    move.use(this); // Uses move if it is a healing or status move
                    return;
                }
                enemy.takeDamage((int) (move.getBuff() + equippedWeapon.getDamage() * multi), move);
            }

            // Lets the person know if the hypnosis ran out
            if (this.statusEffects.get(Move.Status.Hypnotize) == 0) {
                System.out.println("Your hypnosis wore off, you will be able to attack next round!");
            }

            return;
        }

        if (this.statusEffects.get(Move.Status.Sleep) > 0) {
            int willYouWakeUp = rand.nextInt(1, 5); // 20% chance to wake up

            if (willYouWakeUp == 1) {
                System.out.println("You suddenly wake up from your slumber!");
                this.statusEffects.put(Move.Status.Sleep, 0);
                enemy.takeDamage((int) (move.getBuff() + equippedWeapon.getDamage() * multi), move);
                return;
            } else {
                System.out.println("You are snoozing on the battlefield! What are you doing?!?!");
                this.statusEffects.put(Move.Status.Sleep, this.statusEffects.get(Move.Status.Sleep) - 1);
            }

            if (this.statusEffects.get(Move.Status.Sleep) == 0) {
                System.out.println("Looks like you woke up!");
            }

            return;
        }

//        return 0;
    }

    /**
     * Asks the user to select a move for him to use
     * @param player the opposing player damage will be dealt to
     * @return the move that was used
     */
    @Override
    public Move chooseMove(Player player) {
        for (int i = 1; i <= moves.size(); i++) {
            System.out.print(i + ".)");
            System.out.println(moves.get(i - 1));
        }

        System.out.println("What move do you want to use?");
        return moves.get(in.nextInt() - 1);
    }

    /**
     * Uses a potion (adds health)
     * @param potion the potion that will be used
     */
    public void addHealth(Potion potion) {
        if (potion.getBuff() + this.health > maxHealth) {
            health = maxHealth;
        } else {
            health += potion.getBuff();
        }
    }

    /**
     * Equips a piece of Armor or Weapon on the user's character, stores the already equipped item in to the inventory and changes all the stats accordingly
     * @param item the item to be equipped
     */
    public void equipItem(Item item) {
        if (item == null) {
            return;
        }

        if (inventory.contains(item)) {
            if (item instanceof Armor a) {
                float currentProt = this.equippedArmor == null ? 0 : this.equippedArmor.getProtection();
                this.inventory.add(this.equippedArmor);
                if (!(currentProt == 0)) {
                    this.maxHealth -= (100 - (currentProt * 100));
                }
                this.inventory.remove(a);
                this.equippedArmor = a;
                this.maxHealth += (100 - (a.getProtection() * 100));
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
     * Overload method of addMoveToMoves() if multiple moves need to be added at once
     * @param moves the list of moves
     */
    public void addMoveToMoves(List<Move> moves) {
        this.moves = moves;
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

        for (Item item : inventory) {
            str += item.getName() + ",";
            str += item.getDescription() + ",";
            str += item.getRarity() + ",";
        }
        for (int i = 0; i < moves.size(); i++) {
            if (i == moves.size() - 1) {
                str += moves.get(i).getName() + ",";
                str += moves.get(i).getMoveType() + ",";
                str += moves.get(i).getBuff() + "\n";
            } else {
                str += moves.get(i).getName() + ",";
                str += moves.get(i).getMoveType() + ",";
                str += moves.get(i).getBuff() + ",";
            }
        }

        return str;
    }

    @Override
    public String toString() {
        String invStr = "";
        String moveStr = "";

        for (Item item : inventory) {
            invStr += item.toString() + ", ";
        }
        for (Move move : moves) {
            moveStr += "\n" + move.toString() + ",";
        }

        return super.toString() +
                ", equippedWeapon=" + equippedWeapon +
                ", equippedArmor=" + equippedArmor +
                ", moves= {" + moveStr + "}" +
                ", inventory= {" + invStr + "}";
    }
}
