package com.example.chessgame.Pieces;

import com.example.chessgame.Enums.ColorType;
import com.example.chessgame.Enums.PieceType;

import static com.example.chessgame.Controllers.ChessBoardController.tiles;

public class Bishop extends Piece {

    public Bishop(ColorType color, int row, int column) {
        super(color, PieceType.BISHOP, row, column);
    }

    @Override
    public boolean canMove(int targetRow, int targetColumn) {
        int currentRow = getCoordinate().getRow();
        int currentColumn = getCoordinate().getColumn();
        int j;

        //Diagonal movement verification
        if (!(Math.abs(targetRow - currentRow) == Math.abs(targetColumn - currentColumn)) || (this.getCoordinate().getRow() == targetRow && this.getCoordinate().getColumn() == targetColumn)) {
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
                        if (!tiles[i][j].isTileEmpty())
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
                            if (!tiles[i][j].isTileEmpty())
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
                            if (!tiles[i][j].isTileEmpty())
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
                            if (!tiles[i][j].isTileEmpty())
                                return false;
                            j++;
                        }
                    }
                }
            }
        }
        return true;
    }

}
