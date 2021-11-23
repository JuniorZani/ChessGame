package com.example.chessgame.Pieces;

import com.example.chessgame.ColorType;
import com.example.chessgame.Coordinates;

public abstract class Piece {
    private final ColorType color;
    private Coordinates coordinate;

    public ColorType getColor() {
        return color;
    }

    public Coordinates getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinates coordinate) {
        this.coordinate = coordinate;
    }

    public Piece(ColorType color, int row, int column) {
        this.color = color;
        coordinate = new Coordinates(row, column);
    }

    public abstract boolean canMove(int targetRow, int targetColumn);
    public abstract boolean canEat(int targetRow, int targetColumn);
}
