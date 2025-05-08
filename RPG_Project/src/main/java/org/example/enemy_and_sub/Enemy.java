package org.example.enemy_and_sub;

import org.example.Player;
import org.example.human_and_sub.Human;
import org.example.moves.Move;
import org.example.moves.MoveStrategy;

import java.util.*;

public abstract class Enemy extends Player implements MoveStrategy {
    protected List<Move> moves = new ArrayList<>();

    public Enemy(String name, float health, float maxHealth, Map<Move.Status, Integer> statusEffects) {
        super(name, maxHealth, health, statusEffects);
    }

    public Map<String, Integer> moveSorter (Move.Type moveType, List<Move> moves) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < moves.size(); i++) {
//            if (map.put(i))
        }

        return map;
    }

    /**
     * Does damage also checks for status effects
     * @param move the move that was used
     * @param enemy the enemy the entity is using the move against
     */
    @Override
    public void doDamage(Move move, Player enemy) {
        Random rand = new Random();
        float multi = 1;

        if (this.statusEffects.get(Move.Status.DamageBuff) > 0) {
            multi = 2;
            System.out.println("The enemy has a damage buff, his move will 2x MORE damage");
            this.statusEffects.put(Move.Status.DamageBuff, this.statusEffects.get(Move.Status.DamageBuff) - 1);
        } else if (this.statusEffects.get(Move.Status.Spook) > 0) { // Should be impossible that the enemy gets this unless if I change something so that's why I left it here
            System.out.println("The enemy has been spooked, his move will 2x LESS damage");
            multi = 0.5f;
            this.statusEffects.put(Move.Status.Spook, this.statusEffects.get(Move.Status.Spook) - 1);
        }

        // Checks for stun
        if (this.statusEffects.get(Move.Status.Stun) > 0) {
            int willYouBreakFreeFromTheStun = rand.nextInt(1, 6);

            // 20% chance to break free from the stun
            if (willYouBreakFreeFromTheStun == 4) {

                System.out.println("The enemy's stun wore off!");
                this.statusEffects.put(Move.Status.Stun, 0); // Sets turns left to 0

                if (move.getEffect() != Move.Effect.Damage) {
                    move.use(this);
                    return;
                }

                enemy.takeDamage((int) (move.getBuff() * multi), move);
            } else {
                System.out.println("The enemy is stunned!");
                this.statusEffects.put(Move.Status.Stun, this.statusEffects.get(Move.Status.Stun) - 1);
            }

            if (this.statusEffects.get(Move.Status.Stun) == 0) {
                System.out.println("The enemy's stun was lifted!");
            }

            return;
        }
        //Checks for hypnosis
        if (this.statusEffects.get(Move.Status.Hypnotize) > 0) {
            int willYouHitYourself = rand.nextInt(1, 3);

            // Checks to see if you hit yourself or not
            if (willYouHitYourself == 1) {

                System.out.println("Because the enemy was hypnotized, it ended up hitting itself!");
                this.takeDamage((int) (move.getBuff() * multi), move);
                this.statusEffects.put(Move.Status.Hypnotize, this.statusEffects.get(Move.Status.Hypnotize) - 1);

            } else { // If you don't hit yourself, the move works
                this.statusEffects.put(Move.Status.Hypnotize, this.statusEffects.get(Move.Status.Hypnotize) - 1);
                if (move.getEffect() != Move.Effect.Damage) {
                    move.use(this); // Uses move if it is a healing or status move
                    return;
                }
                enemy.takeDamage((int) (move.getBuff() * multi), move);
            }

            // Lets the person know if the hypnosis ran out
            if (this.statusEffects.get(Move.Status.Hypnotize) == 0) {
                System.out.println("The enemy's hypnosis wore off!");
            }

            return;
        }

        if (this.statusEffects.get(Move.Status.Sleep) > 0) {
            int willYouWakeUp = rand.nextInt(1, 5); // 20% chance to wake up

            if (willYouWakeUp == 1) {
                System.out.println("The enemy suddenly wakes up from his slumber!");
                this.statusEffects.put(Move.Status.Sleep, 0);
                enemy.takeDamage((int) (move.getBuff() * multi), move);
                return;
            } else {
                System.out.println("The enemy looks fast asleep... is he snoring????");
                this.statusEffects.put(Move.Status.Sleep, this.statusEffects.get(Move.Status.Sleep) - 1);
            }

            if (this.statusEffects.get(Move.Status.Sleep) == 0) {
                System.out.println("Looks like it woke up!");
            }

            return;
        }

//        return 0;
    }

    /**
     * Clones an enemy (itself)
     * @return a new object containing the cloned enemy
     */
    public abstract Enemy cloneEnemy();

    /**
     * Overload method of cloneEnemy, if the enemy needs to be made much stronger
     * @param maxHealth max health that the enemy will have
     * @return a new object containing the cloned enemy
     */
    public abstract Enemy cloneEnemy(float maxHealth);

    /**
     * Selects a move strategy for the enemy to base itself upon when choosing a move
     * @param enemy the enemy that is using the move
     * @param human the user
     * @return wisest move choice
     */
    @Override
    public Move selectMoveStrategy(Enemy enemy, Human human) {


        return null;
    }

    /**
     * Chooses a move for the enemy based on the conditions (strategy)
     * @param player the player that the move will be used on
     * @return a Move to use for the enemy
     */
    @Override
    public Move chooseMove(Player player) {
        return null;
    }
}
