package org.example.enemy_and_sub;

import org.example.Player;
import org.example.moves.Move;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Goblin extends Enemy {
    private final Move.Type weakness = Move.Type.Physical;

    public Goblin(String name, float health, float maxHealth, Map<Move.Status, Integer> statusEffects) {
        super(name, health, maxHealth, statusEffects);
    }

    /**
     * Takes damage by removing health from the health field by taking weaknesses into account
     * @param damage how much damage it takes
     * @param move the move that was used
     */
    @Override
    public void takeDamage(int damage, Move move) {

    }


    @Override
    public Enemy cloneEnemy() {
        return new Goblin(this.getName(), this.getHealth(), this.getMaxHealth(), new HashMap<>());
    }

    @Override
    public Enemy cloneEnemy(float maxHealth) {
        return new Goblin(this.getName(), maxHealth, maxHealth, new HashMap<>());
    }
}
