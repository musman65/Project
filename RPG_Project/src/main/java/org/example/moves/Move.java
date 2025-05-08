package org.example.moves;

import com.sun.security.jgss.GSSUtil;
import org.example.Player;
import org.example.enemy_and_sub.Enemy;

import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class Move {
    private String name;
    private int buff;
    private Type moveType; // Ghost or Physical
    private final Effect effect; // What does the move do? Damage, heal or de-buff/buff?
    private final Status status; // What kind of status effects does the move inflict?

    public Move(String name, Type moveType, int buff, Effect effect, Status status) {
        this.name = name;
        this.moveType = moveType;
        this.buff = buff;
        this.effect = effect;
        this.status = status;
    }

    /**
     * Uses a move (only for non-damaging moves)
     * @param player the player entity that is using the move
     */
    public void use(Player player) {
        if (status == Status.None && effect == Effect.Damage) {
            System.out.println("Error" + player.getName() + this.name);
            return;
        }
        if (effect == Effect.Heal) {
            player.addHealth(this);
        } else if (effect == Effect.Status) {
            Random rand = new Random();
            int turns = 0;
            switch (status) {
                case ArmorUp -> turns = rand.nextInt(1, 3 + 1);
                case Regen -> turns = 5;
                case DamageBuff -> turns = rand.nextInt(1, 4 + 1);
            }
            Map<Status, Integer> map = player.getStatusEffects();
            map.put(status, turns); // the effect should not stack
            player.setStatusEffects(map);
        }
    }

    @Override
    public String toString() {
        return "Move Name: \"" + name + "\"" +
                "\n\tType = " + moveType +
                "\n\tDamage = " + buff;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return buff == move.buff && Objects.equals(name, move.name) && moveType == move.moveType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, moveType, (Integer) buff, effect);
    }

    public Effect getEffect() {
        return effect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getMoveType() {
        return moveType;
    }

    public void setMoveType(Type moveType) {
        this.moveType = moveType;
    }

    public int getBuff() {
        return buff;
    }

    public Status getStatus() {
        return status;
    }

    public void setBuff(int buff) {
        this.buff = buff;
    }

    public enum Status {
        Stun, // Player cannot do anything for 1 - 2 turn, however, his move has a chance (20%) to go through the stun
        Hypnotize, // 50% chance of player using the move on themselves, lasts for 3 turns
        Burn, // Player loses a little bit of health every turn for 2 - 5
        Sleep, // Player cannot do anything for 2 - 3 but can wake up randomly whenever
        Spook, // Player does 50% less damage || boss only buff
        ArmorBreak, // Player's armor protection is decreased 2x
        ArmorUp, // Player's armor protection is increased 2x
        DamageBuff, // Player does 2x more damage
        Regen, // Player gets a little bit every turn for 5 turns
        None
    }

    public enum Effect {
        Heal, Damage, Status
    }

    public enum Type {
        Ghost,Physical
    }
}
