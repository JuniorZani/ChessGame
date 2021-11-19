package com.example.chessgame.Pieces;

import javafx.scene.image.Image;

public abstract class Piece {
    private String color;

    public String getColor() {
        return color;
    }

    public Piece(String color) {
        this.color = color;
    }
}
