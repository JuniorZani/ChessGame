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

        //Rook movement verification
        if ((currentRow != targetRow && currentColumn != targetColumn)) {
            //Bishop movement verification
            if (!(Math.abs(targetRow - currentRow) == Math.abs(targetColumn - currentColumn))){
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
        }else{
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

    @Override
    public boolean canEat(int targetRow, int targetColumn) {
        if(tileMatrix[targetRow][targetColumn].isTileEmpty())
            return true;
        return tileMatrix[targetRow][targetColumn].getPieceOnTile().getColor() != this.getColor();
    }
}
