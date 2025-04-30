package org.example.enemy_and_sub;

import org.example.Player;
import org.example.human_and_sub.Human;
import org.example.moves.Move;
import org.example.moves.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Enemy extends Player implements MoveStrategy {
    protected List<Move> moves = new ArrayList<>();

    public Enemy(String name, int health, int maxHealth) {
        super(name, maxHealth, health);
    }

    /**
     * Selects a move strategy for the enemy to base itself upon when choosing a move
     * @param enemy the enemy that is using the move
     * @param human the user
     * @return wisest move choice
     */
    @Override
    public Move selectMoveStrategy(Enemy enemy, Human human) {
        return null;
    }

    /**
     * Takes damage by removing health from the health field by taking weaknesses into account
     * @param damage the damage dealt (how much should be removed)
     * @param moveType the type of move that was used
     */
    @Override
    public void takeDamage(int damage, Move.Type moveType) {

    }

    /**
     * Chooses a move for the enemy based on the conditions (strategy)
     * @param player the player that the move will be used on
     * @return a Move to use for the enemy
     */
    @Override
    public Move choseMove(Player player) {
        return null;
    }
}
