package org.example.levels;

import org.example.enemy_and_sub.*;

import java.util.*;

public class Level<T extends Enemy> {
    private String name;
    private int tier;
    private List<Enemy> enemyList;

    private Random rand = new Random();

    public Level(String name, int tier) {
        this.name = name;
        this.tier = tier;
        enemyList = new LinkedList<>();
    }

    /**
     * Initializes a level
     * @param enemy the enemy that will be cloned throughout the level
     */
    public void initializeLevel(T enemy) {
        makeEnemies(enemy, 1);
    }

    /**
     * Clones enemies to put them in one list
     * @param enemy the enemy to clone
     * @param amount how many enemies needed
     */
    public void makeEnemies(T enemy, int amount) {
        for (int i = 0; i < amount; i++) {
            int upperBound;
            int healthRemoved;
            if (i < amount - 1) {
                healthRemoved = -50; // extra buff
            } else {
                upperBound = ((int) enemy.getMaxHealth() * tier) / 4;
                healthRemoved = rand.nextInt(0, upperBound);
            }
            enemyList.add(enemy.cloneEnemy(enemy.getMaxHealth() * (tier) - healthRemoved));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public List<Enemy> getEnemyList() {
        return enemyList;
    }

    public void setEnemyList(List<Enemy> enemyList) {
        this.enemyList = enemyList;
    }
}
