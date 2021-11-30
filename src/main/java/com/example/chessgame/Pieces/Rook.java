package com.example.chessgame.Pieces;

import com.example.chessgame.ColorType;

import static com.example.chessgame.ChessBoardController.tileMatrix;


public class Rook extends Piece{

    public Rook(ColorType color, int row, int column) {
        super(color, row, column);
    }

    @Override
    public boolean canMove(int targetRow, int targetColumn) {
        int currentRow = getCoordinate().getRow();
        int currentColumn = getCoordinate().getColumn();

        if (currentRow != targetRow && currentColumn != targetColumn) {
            return false;
        }

        if (currentRow == targetRow) {
            if (currentColumn > targetColumn) {
                for (int j = currentColumn - 1; j > targetColumn; j--) {
                    if (!tileMatrix[currentRow][j].isTileEmpty())
                        return false;
                }
            }else {
                for (int j = currentColumn + 1; j < targetColumn; j++) {
                    if (!tileMatrix[currentRow][j].isTileEmpty())
                        return false;
                }
            }
        } else {
            if (currentRow > targetRow) {
                for (int i = currentRow - 1; i > targetRow; i--) {
                    if (!tileMatrix[i][currentColumn].isTileEmpty())
                        return false;
                }
            }else {
                for (int i = currentRow + 1; i < targetRow; i++) {
                    if (!tileMatrix[i][currentColumn].isTileEmpty())
                        return false;
                }
            }
        }
        return true;
    }
}
