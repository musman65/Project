package org.example.enemy_and_sub;

import org.example.Player;
import org.example.moves.Move;

import java.util.HashMap;
import java.util.Map;

public class ThePhantomKing extends Enemy { // No weaknesses

    public ThePhantomKing(String name, float health, float maxHealth, Map<Move.Status, Integer> statusEffects) {
        super(name, health, maxHealth, statusEffects);
    }

    @Override
    public void takeDamage(int damage, Move move) {

    }

    @Override
    public Enemy cloneEnemy() {
        return new ThePhantomKing(this.getName(), this.getHealth(), this.getMaxHealth(), new HashMap<>());
    }

    @Override
    public Enemy cloneEnemy(float maxHealth) {
        return new ThePhantomKing(this.getName(), maxHealth, maxHealth, new HashMap<>());
    }
}
