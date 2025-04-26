package org.example;

import java.util.Objects;

public abstract class Player implements Fightable {
    protected String name;
    protected float health;
    protected float maxHealth;
    protected String statusEffects;

    public Player(String statusEffects, float maxHealth, float health, String name) {
        this.statusEffects = statusEffects;
        this.maxHealth = maxHealth;
        this.health = health;
        this.name = name;
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

    public String getStatusEffects() {
        return statusEffects;
    }

    public void setStatusEffects(String statusEffects) {
        this.statusEffects = statusEffects;
    }
}
