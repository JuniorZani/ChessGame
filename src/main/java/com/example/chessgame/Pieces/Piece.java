package com.example.chessgame.Pieces;

import com.example.chessgame.ColorType;
import com.example.chessgame.Coordinates;

import static com.example.chessgame.ChessBoardController.tileMatrix;

public abstract class Piece {
    private final ColorType color;
    private final Coordinates coordinate;

    public ColorType getColor() {
        return color;
    }

    public Coordinates getCoordinate() {
        return coordinate;
    }

    public Piece(ColorType color, int row, int column) {
        this.color = color;
        coordinate = new Coordinates(row, column);
    }

    public abstract boolean canMove(int targetRow, int targetColumn);

    public boolean canEat(int targetRow, int targetColumn) {
        if(tileMatrix[targetRow][targetColumn].isTileEmpty())
            return true;
        return tileMatrix[targetRow][targetColumn].getPieceOnTile().getColor() != this.getColor();
    }
}
