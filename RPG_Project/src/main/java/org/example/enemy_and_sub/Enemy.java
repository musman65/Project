package org.example.enemy_and_sub;

import org.example.Player;
import org.example.moves.Move;
import org.example.moves.MoveStrategy;

public class Enemy extends Player implements MoveStrategy {
    public Enemy(String name, int health, int maxHealth) {
        super(name, health, maxHealth);
    }

    @Override
    public void takeDamage(int damage) {

    }

    @Override
    public Move choseMove(Player player) {
        return null;
    }
}
