package com.example.chessgame;

public class Player {
    private final String name;
    private final ColorType color;

    public String getName() {
        return name;
    }

    public ColorType getColor() {
        return color;
    }

    public Player(String name, ColorType color) {
        this.name = name;
        this.color = color;
    }
}
