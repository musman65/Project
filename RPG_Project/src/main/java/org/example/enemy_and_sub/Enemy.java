package org.example.enemy_and_sub;

import org.example.Player;
import org.example.human_and_sub.Human;
import org.example.moves.Move;
import org.example.moves.MoveStrategy;

import java.util.*;

/*
notes (delete later):

    at least 4 damage moves to each enemy
    at least 1 status and heal move to each enemy



 */
public abstract class Enemy extends Player implements MoveStrategy {
    protected List<Move> moves;

    private Random rand = new Random();

    public Enemy(String name, float health, float maxHealth, Map<Move.Status, Integer> statusEffects, List<Move> moves) {
        super(name, maxHealth, health, statusEffects);
        this.moves = moves;
    }

    public List<Move> assortMovesEffect(Move.Effect effectToFind) {
        int randInt = rand.nextInt(1,3);
        List<Move> filteredMoves = this.moves;

        if (randInt == 1) {
            filteredMoves.sort(new Move.MoveComp("descending"));
        } else {
            filteredMoves.sort(new Move.MoveComp("ascending"));
        }

        filteredMoves = filteredMoves.stream()
                .filter(move -> {
                    if (move.getEffect() == effectToFind) {
                        return true;
                    } else {
                        return false;
                    }
                })
                .toList();

        return filteredMoves;
    }

    public List<Move> assortMovesEffect(Move.Effect effectToFind, String order) {
        int randInt = rand.nextInt(1,3);
        List<Move> filteredMoves = this.moves;

        filteredMoves.sort(new Move.MoveComp(order));

        filteredMoves = filteredMoves.stream()
                .filter(move -> {
                    if (move.getEffect() == effectToFind) {
                        return true;
                    } else {
                        return false;
                    }
                })
                .toList();

        return filteredMoves;
    }

    public List<Move> assortMovesStatus(Move.Status statusToFind) {
        int randInt = rand.nextInt(1,3);
        List<Move> filteredMoves = this.moves;

        if (randInt == 1) {
            filteredMoves.sort(new Move.MoveComp("descending"));
        } else {
            filteredMoves.sort(new Move.MoveComp("ascending"));
        }

        filteredMoves = filteredMoves.stream()
                .filter(move -> {
                    if (move.getStatus() == statusToFind) {
                        return true;
                    } else {
                        return false;
                    }
                })
                .toList();

        if (filteredMoves.isEmpty()) {
            return null;
        } else {
            return filteredMoves;
        }
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

        if (move.getEffect() != Move.Effect.Damage) {
            move.use(this);
            return;
        }

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

        enemy.takeDamage((int) (move.getBuff() * multi), move);
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
        if (human.getHealth() >= 0.90 * human.getMaxHealth() && health >= maxHealth * 0.90) {
            int num1 = rand.nextInt(1, 3);
            if (num1 == 1) {
                return assortMovesEffect(Move.Effect.Status).get(1);
            } else if (num1 == 2) {
                return assortMovesEffect(Move.Effect.Damage).get(2);
            }
        }

        if (health <= maxHealth * 0.10 && rand.nextInt(1, 5) < 3) {
            return assortMovesEffect(Move.Effect.Damage, "a").get(0);
        }

        if (human.getHealth() >= human.getMaxHealth() * 0.5 && rand.nextInt(1, 6) == 1) {
            return assortMovesStatus(Move.Status.Stun) != null ? assortMovesStatus(Move.Status.Stun).get(0) : assortMovesEffect(Move.Effect.Status).get(0);
        }

        if (human.getHealth() >= 0.60 * human.getMaxHealth() && health <= maxHealth * 0.30) {
            if (rand.nextInt(1, 5) == 1) {
                return assortMovesEffect(Move.Effect.Damage).get(0);
            }

            if (health <= maxHealth * 0.10 && rand.nextInt(1, 5) == 1) {
                List<Move> healMoves = assortMovesEffect(Move.Effect.Heal);
                return healMoves.get(0);
            }
            if (health <= maxHealth * 0.20 && rand.nextInt(1, 3) == 1) {
                List<Move> healMoves = assortMovesEffect(Move.Effect.Heal);
                return healMoves.get(1);
            }
            if (health <= maxHealth * 0.30 && rand.nextInt(1, 4) == 1) {
                List<Move> healMoves = assortMovesEffect(Move.Effect.Heal);
                return healMoves.get(1);
            }
        }

        if (health <= maxHealth * 0.15 && rand.nextInt(1, 5) == 1) {
            return assortMovesEffect(Move.Effect.Heal,"a").get(0);
        }

        if (human.getHealth() <= 0.30 * human.getMaxHealth()) {
            if (rand.nextInt(1, 3) == 1) {
                return assortMovesEffect(Move.Effect.Damage).get(1);
            }
        }

        if (human.getHealth() <= 0.40 * human.getMaxHealth() && rand.nextInt(1, 5) == 1) {
            return assortMovesEffect(Move.Effect.Status).get(0);
        }

        return assortMovesEffect(Move.Effect.Damage).get(rand.nextInt(0, 3));
    }

    /**
     * Chooses a move for the enemy based on the conditions (strategy)
     * @param player the player that the move will be used on
     * @return a Move to use for the enemy
     */
    @Override
    public Move chooseMove(Player player) {
        if (player instanceof Human h) {
            Move m1 = selectMoveStrategy(this, h);
            System.out.println("The enemy used " + m1.getName());
            return m1;
        }
        return null;
    }

}
