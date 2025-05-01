package org.example.enemy_and_sub;

import org.example.Player;
import org.example.human_and_sub.Human;
import org.example.moves.Move;
import org.example.moves.MoveStrategy;

import java.util.*;

public abstract class Enemy extends Player implements MoveStrategy {
    protected List<Move> moves = new ArrayList<>();

    public Enemy(String name, int health, int maxHealth) {
        super(name, maxHealth, health);
    }

    public Map<String, Integer> moveSorter (Move.Type moveType, List<Move> moves) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < moves.size(); i++) {
//            if (map.put(i))
        }

        return map;
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
     * Chooses a move for the enemy based on the conditions (strategy)
     * @param player the player that the move will be used on
     * @return a Move to use for the enemy
     */
    @Override
    public Move chooseMove(Player player) {
        return null;
    }
}
