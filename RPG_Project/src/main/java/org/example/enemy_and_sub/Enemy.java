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

    public Enemy(String name, float health, float maxHealth, List<Move> moves) {
        super(name, health, maxHealth);
        this.moves = moves;
    }

    @Override
    public Move selectMoveStrategy(Enemy enemy, Human human) {
        return null;
    }

    @Override
    public void takeDamage(int damage, Move.Type moveType) {

    }

    @Override
    public Move choseMove(Player player) {
        return null;
    }
}
