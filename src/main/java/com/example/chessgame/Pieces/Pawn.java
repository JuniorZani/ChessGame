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
        int movementValue = 1;
        int i = 1;
        if(currentColumn == targetColumn) {
            if (this.getColor() == ColorType.WHITE){
                if (currentRow == 6)
                    movementValue = 2;
                while(i < movementValue + 1){
                    if(!tileMatrix[currentRow - i][currentColumn].isTileEmpty())//TODO can eat
                        return false;
                    i++;
                }
                return (currentRow - targetRow > 0 && currentRow - targetRow <= movementValue);
            }else {
                if(currentRow == 1)
                    movementValue = 2;
                while(i < movementValue + 1){
                    if(!tileMatrix[currentRow + i][currentColumn].isTileEmpty())
                        return false;
                    i++;
                }
                return (targetRow - currentRow > 0 && targetRow - currentRow <= movementValue);
            }
        }
        return false;
    }

    @Override
    public boolean canEat(int targetRow, int targetColumn) {
        if(tileMatrix[targetRow][targetColumn].isTileEmpty())
            return true;
        return tileMatrix[targetRow][targetColumn].getPieceOnTile().getColor() != this.getColor();
    }
}
