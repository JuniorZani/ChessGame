package com.example.chessgame.Pieces;

import com.example.chessgame.ColorType;
import static com.example.chessgame.ChessBoardController.tileMatrix;

public class King extends Piece{

    public King(ColorType color, int row, int column) {
        super(color, row, column);
    }

    @Override
    public boolean canMove(int targetRow, int targetColumn) {
        int currentRow = getCoordinate().getRow();
        int currentColumn = getCoordinate().getColumn();

        if (!(Math.abs(targetRow - currentRow) <= 1 &&  Math.abs(targetColumn - currentColumn) <= 1)) {
            return false;
        }

        if(tileMatrix[targetRow][targetColumn].getPieceOnTile() == null || this.getColor() != tileMatrix[targetRow][targetColumn].getPieceOnTile().getColor()){
            return true;
        }else
            return tileMatrix[targetRow][targetColumn].isTileEmpty();
    }
}
