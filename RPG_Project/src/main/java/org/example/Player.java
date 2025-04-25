package org.example;

import java.util.Objects;

public abstract class Player implements Fightable {
    protected String name;
    protected int health;
    protected int maxHealth;

    public Player(String name, int health, int maxHealth) {
        this.name = name;
        this.health = health;
        this.maxHealth = maxHealth;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
}
