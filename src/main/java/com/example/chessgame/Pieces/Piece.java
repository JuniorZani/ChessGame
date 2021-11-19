package com.example.chessgame.Pieces;

import com.example.chessgame.ColorType;

public abstract class Piece {
    private final ColorType color;
    private int row, column;

    public ColorType getColor() {
        return color;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Piece(ColorType color, int row, int column) {
        this.color = color;
        this.row = row;
        this.column = column;
    }

    public abstract boolean canMove(int targetRow, int targetColumn);
}
