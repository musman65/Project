package org.example.enemy_and_sub;

import org.example.Player;
import org.example.moves.Move;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThePhantomKing extends Enemy { // No weaknesses

    public ThePhantomKing(String name, float health, float maxHealth, Map<Move.Status, Integer> statusEffects, List<Move> moves) {
        super(name, health, maxHealth, statusEffects, moves);
    }

    /**
     * Takes damage by removing health from the health field by taking weaknesses into account
     * @param damage how much damage it takes
     * @param move the move that was used
     */
    @Override
    public void takeDamage(int damage, Move move) {
        int[] nums = takeDamageMainLogic(move);

        nums[0] = 1;

        this.health -= nums[1] * (nums[0] * (damage));
    }

    @Override
    public Enemy cloneEnemy() {
        return new ThePhantomKing(this.getName(), this.getHealth(), this.getMaxHealth(), new HashMap<>(), this.moves);
    }

    @Override
    public Enemy cloneEnemy(float maxHealth) {
        return new ThePhantomKing(this.getName(), maxHealth, maxHealth, new HashMap<>(), this.moves);
    }
}
