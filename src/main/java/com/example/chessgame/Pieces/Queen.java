package com.example.chessgame.Pieces;

import com.example.chessgame.ColorType;

import static com.example.chessgame.ChessBoardController.tileMatrix;

public class Queen extends Piece{

    public Queen(ColorType color, int row, int column) {
        super(color, row, column);
    }

    @Override
    public boolean canMove(int targetRow, int targetColumn) {
        int currentRow = getCoordinate().getRow();
        int currentColumn = getCoordinate().getColumn();

        Bishop bishop = new Bishop(this.getColor(), currentRow, currentColumn);
        Rook rook =  new Rook(this.getColor(), currentRow, currentColumn);

        return (bishop.canMove(targetRow, targetColumn) || rook.canMove(targetRow, targetColumn));

    }

    @Override
    public boolean canEat(int targetRow, int targetColumn) {
        if(tileMatrix[targetRow][targetColumn].isTileEmpty())
            return true;
        return tileMatrix[targetRow][targetColumn].getPieceOnTile().getColor() != this.getColor();
    }
}
