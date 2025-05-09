package org.example;

import org.example.moves.Move;

public interface Fightable {
    // The methods required for any entity that is fightable

    /**
     * Gets how much health the entity has remaining
     * @return the amount of health
     */
    float getHealth();

    /**
     * Gets the name of the entity
     * @return the name
     */
    String getName();

    /**
     * Checks if the entity is alive
     * @return a boolean representing if it is alive or not
     */
    boolean isAlive();

    /**
     * Lets the entity take damage
     * @param damage how much damage it takes
     * @param move the move that was used
     */
    void takeDamage(int damage, Move move);

    /**
     * Makes the entity chose a move
     * @param player The player that is choosing a move (human or enemy)
     * @return the Move chosen
     */
    Move chooseMove(Player player);
}
