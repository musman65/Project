package org.example;

import org.example.moves.Move;

import java.util.Map;
import java.util.Objects;
import java.util.Random;

public abstract class Player implements Fightable {
    protected String name;
    protected float health;
    protected float maxHealth;
    protected Map<Move.Status, Integer> statusEffects;

    public Player(String name, float health, float maxHealth, Map<Move.Status, Integer> statusEffects) {
        this.maxHealth = maxHealth;
        this.health = health;
        this.name = name;
        this.statusEffects = statusEffects;
        statusEffects.put(Move.Status.Sleep, 0);
        statusEffects.put(Move.Status.Stun, 0);
        statusEffects.put(Move.Status.Spook, 0);
        statusEffects.put(Move.Status.DamageBuff, 0);
        statusEffects.put(Move.Status.Hypnotize, 0);
        statusEffects.put(Move.Status.ArmorBreak, 0);
        statusEffects.put(Move.Status.ArmorUp, 0);
        statusEffects.put(Move.Status.Burn, 0);
        statusEffects.put(Move.Status.Regen, 0);
    }

    /**
     * The main logic of the takeDamage method in the enemy and user classes
     * @param move
     * @return
     */
    public int[] takeDamageMainLogic(Move move) {
        Random rand = new Random();
        int[] nums = new int[2];
        int multi = 1;
        int nullify = 1;

        if (move.getStatus() != Move.Status.None) {
            int turns = 0;

            switch (move.getStatus()) { // added +1 because its exclusive and for better visualization of actual turn value
                case Stun -> turns = rand.nextInt(1, 2 + 1);
                case Hypnotize -> turns = 3;
                case Burn -> turns = rand.nextInt(2, 5 + 1);
                case Sleep, ArmorBreak -> turns = rand.nextInt(2 , 3 + 1);
                case Spook -> turns = 2;
            }
            this.statusEffects.put(move.getStatus(), turns);
        }

        if (this.statusEffects.get(Move.Status.Burn) > 0) {
            this.health -= 5;
            this.statusEffects.put(Move.Status.Burn, this.statusEffects.get(Move.Status.Burn) - 1);
        }
        nums[0] = multi;
        nums[1] = nullify;

        return nums;
    }

    /**
     * Uses a move (adds health)
     * @param move the potion that will be used
     */
    public void addHealth(Move move) {
        if (move.getBuff() + health > maxHealth) {
            health = maxHealth;
        } else {
            health += move.getBuff();
        }
    }

    /**
     * Does damage also checks for status effects
     * @param move the move that was used
     * @param player the enemy the entity is using the move against
     */
    public abstract void doDamage(Move move, Player player);

    /**
     * Checks to see if the player object is alive
     * @return a boolean representing if it is alive or not
     */
    public boolean isAlive() {
        return !(health <= 0);
    }

    @Override
    public String toString() {
        return "\nName = " + name + "\n" +
                "Health = " + health;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return health == player.health && maxHealth == player.maxHealth && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, health, maxHealth);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public float getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(float maxHealth) {
        this.maxHealth = maxHealth;
    }

    public Map<Move.Status, Integer> getStatusEffects() {
        return statusEffects;
    }

    public void setStatusEffects(Map<Move.Status, Integer> statusEffects) {
        this.statusEffects = statusEffects;
    }
}
