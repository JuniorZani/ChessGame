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
        int j;
        //Diagonal movement verification
        if (!(Math.abs(targetRow - currentRow) == Math.abs(targetColumn - currentColumn))) {
            return false;
        }
        //top diagonals
        if (currentRow > targetRow) {
            j = currentColumn;
            //i-- and j--
            if (currentColumn > targetColumn) {
                j = j - 1;
                for (int i = currentRow - 1; i > targetRow; i--) {
                    if(j < targetColumn)
                        break;
                    else
                        if (!tileMatrix[i][j].isTileEmpty())
                            return false;
                        j--;
                }
            } else {
                //i-- and j++
                if (currentColumn < targetColumn) {
                    j = j + 1;
                    for (int i = currentRow - 1; i > targetRow; i--) {
                        if(j > targetColumn)
                            break;
                        else
                            if (!tileMatrix[i][j].isTileEmpty())
                                return false;
                            j++;
                    }
                }
            }
        } else {
            //bottom diagonals
            if (currentRow < targetRow) {
                j = currentColumn;
                //i++ and j--
                if (currentColumn > targetColumn) {
                    j = j - 1;
                    for (int i = currentRow + 1; i < targetRow; i++) {
                        if(j < targetColumn)
                            break;
                        else
                            if (!tileMatrix[i][j].isTileEmpty())
                                return false;
                            j--;
                    }
                } else {
                    //i++ and j++
                    j = j + 1;
                    for (int i = currentRow + 1; i < targetRow; i++) {
                        if (j > targetColumn)
                            break;
                        else {
                            if (!tileMatrix[i][j].isTileEmpty())
                                return false;
                            j++;
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean canEat(int targetRow, int targetColumn) {
        if(tileMatrix[targetRow][targetColumn].isTileEmpty())
            return true;
        return tileMatrix[targetRow][targetColumn].getPieceOnTile().getColor() != this.getColor();
    }
}
