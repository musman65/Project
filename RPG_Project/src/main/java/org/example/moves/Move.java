package org.example.moves;

import java.util.Objects;

public class Move {
    private String name;
    private Type moveType;
    private int buff;
    private Effect effect;

    public Move(String name, Type moveType, int buff, Effect effect) {
        this.name = name;
        this.moveType = moveType;
        this.buff = buff;
        this.effect = effect;
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

    public void setEffect(Effect effect) {
        this.effect = effect;
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

    public void setBuff(int buff) {
        this.buff = buff;
    }

    public enum Status {
        Stun, // Player cannot do anything for 1 - 2 turn, however, his move has a chance (20%) to go through the stun
        Hypnotize, // Slight change of player using the move on themselves
        Burn, // Player loses a little bit of health every turn for 2 - 5
        Sleep, // Player cannot do anything for 2 - 3 but can wake up randomly whenever (cannot do anything on the turn he wakes up)
        Spook, // Player does 50% less damage || boss only buff
        ArmorBreak, // Player's armor protection is decreased 2x
        ArmorUp, // Player's armor protection is increased 2x
        DamageBuff, // Player does 2x more damage
        Regen // Player gets a little bit every turn for 5 turns
    }

    public enum Effect {
        Heal, Damage, Status
    }

    public enum Type {
        Ghost,Physical
    }
}
