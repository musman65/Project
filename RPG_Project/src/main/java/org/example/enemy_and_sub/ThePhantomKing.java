package org.example.enemy_and_sub;

import org.example.moves.Move;

public class ThePhantomKing extends Enemy { // No weaknesses
    public ThePhantomKing(String name, int health, int maxHealth) {
        super(name, health, maxHealth);
    }

    /**
     * Takes damage by removing health from the health field by taking weaknesses into account
     * @param damage the damage dealt (how much should be removed)
     * @param moveType the type of move that was used
     */
    @Override
    public void takeDamage(int damage, Move.Type moveType) {

    }
}
