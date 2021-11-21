package com.example.chessgame.Pieces;

import com.example.chessgame.ColorType;

public class Knight extends Piece{

    public Knight(ColorType color, int row, int column) {
        super(color, row, column);
    }

    @Override
    public boolean canMove(int targetRow, int targetColumn) {
        int currentRow = getCoordinate().getRow();
        int currentColumn = getCoordinate().getColumn();

        return (Math.abs(targetRow - currentRow) == 1 && Math.abs(targetColumn - currentColumn) == 2) ||
                (Math.abs(targetRow - currentRow) == 2 && Math.abs(targetColumn - currentColumn) == 1);
    }
}
