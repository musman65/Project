package org.example.enemy_and_sub;

import org.example.Player;
import org.example.moves.Move;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MutatedWolf extends Enemy {
    private final Move.Type weakness = Move.Type.Physical;

    public MutatedWolf(String name, float health, float maxHealth, Map<Move.Status, Integer> statusEffects, List<Move> moves) {
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

        if (move.getMoveType().equals(weakness)) {
            nums[0] = 2;
        }

        this.health -= nums[1] * (nums[0] * (damage));
    }

    @Override
    public Enemy cloneEnemy() {
        return new MutatedWolf(this.getName(), this.getHealth(), this.getMaxHealth(), new HashMap<>(), this.moves);
    }

    @Override
    public Enemy cloneEnemy(float maxHealth) {
        return new MutatedWolf(this.getName(), maxHealth, maxHealth, new HashMap<>(), this.moves);
    }
}
