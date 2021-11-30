package com.example.chessgame.Pieces;

import com.example.chessgame.ColorType;
import static com.example.chessgame.ChessBoardController.tileMatrix;
public class Pawn extends Piece{

    public Pawn(ColorType color, int row, int column) {
        super(color, row, column);
    }

    @Override
    public boolean canMove(int targetRow, int targetColumn) {
        int currentRow = getCoordinate().getRow();
        int currentColumn = getCoordinate().getColumn();

        //Movement Verification
        if(currentColumn == targetColumn) {
            if (this.getColor() == ColorType.WHITE) {
                if (!tileMatrix[currentRow - 1][currentColumn].isTileEmpty()){
                    return false;
                }else{
                    if (currentRow == 6){
                        if (!tileMatrix[currentRow - 2][currentColumn].isTileEmpty())
                            return (Math.abs(currentRow - targetRow) == 1);
                        else
                            return (currentRow - targetRow > 0 && currentRow - targetRow <= 2);
                    }else{
                        return (currentRow - targetRow == 1);
                    }
                }
            } else {
                if (!tileMatrix[currentRow + 1][currentColumn].isTileEmpty()){
                    return false;
                }else{
                    if (currentRow == 1){
                        if (!tileMatrix[currentRow + 2][currentColumn].isTileEmpty())
                            return (Math.abs(currentRow - targetRow) == 1);
                        else
                            return (targetRow - currentRow > 0 && targetRow - currentRow <= 2);
                    }else{
                        return (targetRow - currentRow == 1);
                    }
                }
            }
        }
        else{
            return this.canEat(targetRow, targetColumn);
        }
    }

    @Override
    public boolean canEat(int targetRow, int targetColumn) {
        int currentRow = getCoordinate().getRow();
        int currentColumn = getCoordinate().getColumn();

        if (currentColumn != targetColumn) {
            if (this.getColor() == ColorType.WHITE) {
                if (currentRow - 1 == targetRow) {
                    if (!tileMatrix[targetRow][targetColumn].isTileEmpty() && this.getColor() != tileMatrix[targetRow][targetColumn].getPieceOnTile().getColor())
                        return currentColumn + 1 == targetColumn || currentColumn - 1 == targetColumn;
                }
            } else {
                if (currentRow + 1 == targetRow) {
                    if (!tileMatrix[targetRow][targetColumn].isTileEmpty() && this.getColor() != tileMatrix[targetRow][targetColumn].getPieceOnTile().getColor())
                        return currentColumn + 1 == targetColumn || currentColumn - 1 == targetColumn;
                }
            }

        }else{
            return (tileMatrix[targetRow][targetColumn].isTileEmpty());
        }
        return false;
    }
}