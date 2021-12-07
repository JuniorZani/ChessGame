package com.example.chessgame.Miscellaneous;

public class Coordinates {
    int row, column;

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

    public Coordinates(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
