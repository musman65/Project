package org.example;

import org.example.moves.Move;

public interface Fightable {
    // The methods required for any entity that is fightable
    float getHealth();
    String getName();
    boolean isAlive();
    void takeDamage(int damage, Move.Type moveType);
    Move choseMove(Player player);
}
