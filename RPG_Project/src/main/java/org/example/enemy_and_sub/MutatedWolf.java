package org.example.enemy_and_sub;

import org.example.Player;
import org.example.moves.Move;

import java.util.HashMap;
import java.util.Map;

public class MutatedWolf extends Enemy {
    private final Move.Type weakness = Move.Type.Physical;

    public MutatedWolf(String name, float health, float maxHealth, Map<Move.Status, Integer> statusEffects) {
        super(name, health, maxHealth, statusEffects);
    }

    @Override
    public void takeDamage(int damage, Move move) {

    }

    @Override
    public Enemy cloneEnemy() {
        return new MutatedWolf(this.getName(), this.getHealth(), this.getMaxHealth(), new HashMap<>());
    }

    @Override
    public Enemy cloneEnemy(float maxHealth) {
        return new MutatedWolf(this.getName(), maxHealth, maxHealth, new HashMap<>());
    }
}
