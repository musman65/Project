package org.example.levels;

import org.example.enemy_and_sub.*;

import java.util.*;

public class Level<T extends Enemy> {
    private String name;
    private int tier;
    private Queue<Enemy> enemyQueue;

    private Random rand = new Random();

    public Level(String name, int tier) {
        this.name = name;
        this.tier = tier;
        enemyQueue = new LinkedList<>();
    }

    public void initializeLevel(T enemy) {
        makeEnemies(enemy, rand.nextInt(1 , tier + 2));
    }

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
            enemyQueue.add(enemy.cloneEnemy(enemy.getMaxHealth() * (tier) - healthRemoved));
        }
    }
}
