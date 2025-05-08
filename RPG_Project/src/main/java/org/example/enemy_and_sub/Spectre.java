package org.example.enemy_and_sub;

import org.example.Player;
import org.example.moves.Move;

import java.util.HashMap;
import java.util.Map;

public class Spectre extends Enemy {
    private final Move.Type weakness = Move.Type.Ghost;

    public Spectre(String name, float health, float maxHealth, Map<Move.Status, Integer> statusEffects) {
        super(name, health, maxHealth, statusEffects);
    }

    @Override
    public void takeDamage(int damage, Move move) {

    }

    @Override
    public Enemy cloneEnemy() {
        return new Spectre(this.getName(), this.getHealth(), this.getMaxHealth(), new HashMap<>());
    }

    @Override
    public Enemy cloneEnemy(float maxHealth) {
        return new Spectre(this.getName(), maxHealth, maxHealth, new HashMap<>());
    }
}
