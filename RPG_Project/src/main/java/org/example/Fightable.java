package org.example;

import org.example.moves.Move;

public interface Fightable {
    int getHealth();
    String getName();
    boolean isAlive();
    void takeDamage(int damage);
    Move choseMove(Player player);
}
