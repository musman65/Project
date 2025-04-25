package org.example.moves;

public class Move {
    private String name;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public enum Type {
        Ghost,Physical
    }
}
