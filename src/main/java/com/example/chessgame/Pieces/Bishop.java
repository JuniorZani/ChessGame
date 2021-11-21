package com.example.chessgame.Pieces;

import com.example.chessgame.ColorType;
import static com.example.chessgame.ChessBoardController.tileMatrix;

public class Bishop extends Piece {

    public Bishop(ColorType color, int row, int column) {
        super(color, row, column);
    }

    @Override
    public boolean canMove(int targetRow, int targetColumn) {
        int currentRow = getCoordinate().getRow();
        int currentColumn = getCoordinate().getColumn();

        if (!(Math.abs(targetRow - currentRow) == Math.abs(targetColumn - currentColumn))) {
            return false;
        }
        //i-- and j--
        if (currentRow > targetRow) {
            if (currentColumn > targetColumn) {
                for (int i = currentRow - 1; i > targetRow; i--) {
                    for (int j = currentColumn - 1; j > targetColumn; j--) {
                        if (!tileMatrix[i][j].isTileEmpty())
                            return false;
                    }
                }
            }
            //i-- and j++
            if (currentColumn < targetColumn) {
                for (int i = currentRow - 1; i > targetRow; i--) {
                    for (int j = currentColumn + 1; j < targetColumn; j++) {
                        if (!tileMatrix[i][j].isTileEmpty())
                            return false;
                    }
                }
            }
        }else
                //i++ and j--
                if (currentColumn > targetColumn) {
                    for (int i = currentRow + 1; i < targetRow; i++) {
                        for (int j = currentColumn - 1; j > targetColumn; j--) {
                            if (!tileMatrix[i][j].isTileEmpty())
                                return false;
                        }
                    }
                } else
                    //i++ and j++
                    for (int i = currentRow + 1; i < targetRow; i++) {
                        for (int j = currentColumn + 1; j < targetColumn; j++) {
                            if (!tileMatrix[i][j].isTileEmpty())
                                return false;
                        }
                    }
        return true;
        }
    }
