package org.example;

import org.example.moves.Move;

public interface Fightable {
    // The methods required for any entity that is fightable
    int getHealth();
    String getName();
    boolean isAlive();
    void takeDamage(int damage);
    Move choseMove(Player player);
}
