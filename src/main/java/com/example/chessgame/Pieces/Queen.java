package com.example.chessgame.Pieces;

import com.example.chessgame.ColorType;

public class Queen extends Piece{

    public Queen(ColorType color, int row, int column) {
        super(color, row, column);
    }

    @Override
    public boolean canMove(int targetRow, int targetColumn) {
        int currentRow = getCoordinate().getRow();
        int currentColumn = getCoordinate().getColumn();

        Piece rook = new Rook(this.getColor(), currentRow, currentColumn);
        Piece bishop = new Bishop(this.getColor(), currentRow, currentColumn);

        return (rook.canMove(targetRow, targetColumn) || bishop.canMove(targetRow, targetColumn));
    }
}
