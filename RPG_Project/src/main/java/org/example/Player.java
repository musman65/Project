package org.example;

import org.example.moves.Move;

import java.util.Map;
import java.util.Objects;

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
     * Inflicts a status effect on the player entity
     * @param move the move that was used
     */
    public void inflictStatus(Move move) {
        statusEffects.put(move.getStatus(), statusEffects.get(move.getStatus()) + move.getBuff());
    }

    /**
     * Checks to see if the player object is alive
     * @return a boolean representing if it is alive or not
     */
    public boolean isAlive() {
        return !(health == 0);
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", health=" + health +
                ", maxHealth=" + maxHealth;
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
