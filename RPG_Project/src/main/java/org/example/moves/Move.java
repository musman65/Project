package org.example.moves;

import java.util.Objects;

public class Move {
    private String name;
    private Type moveType;
    private int damage;

    public Move(String name, Type moveType, int damage) {
        this.name = name;
        this.moveType = moveType;
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "Move Name: \"" + name + "\"" +
                "\n\tType = " + moveType +
                "\n\tDamage = " + damage;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return damage == move.damage && Objects.equals(name, move.name) && moveType == move.moveType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, moveType, damage);
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

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public enum Type {
        Ghost,Physical
    }
}
