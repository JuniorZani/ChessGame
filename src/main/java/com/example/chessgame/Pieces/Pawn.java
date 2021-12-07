package com.example.chessgame.Pieces;

import com.example.chessgame.Enums.ColorType;
import com.example.chessgame.Enums.PieceType;

import static com.example.chessgame.Controllers.ChessBoardController.tiles;
public class Pawn extends Piece{


    public Pawn(ColorType color, int row, int column) {
        super(color, PieceType.PAWN, row, column);
    }

    @Override
    public boolean canMove(int targetRow, int targetColumn) {
        int currentRow = getCoordinate().getRow();
        int currentColumn = getCoordinate().getColumn();

        //Movement Verification
        if(currentColumn == targetColumn) {
            if (this.getColor() == ColorType.WHITE) {
                if ( currentRow - 1 > 0 && !tiles[currentRow - 1][currentColumn].isTileEmpty()){
                    return false;
                }else{
                    if (currentRow == 6){
                        if (!tiles[currentRow - 2][currentColumn].isTileEmpty()){
                            return (Math.abs(currentRow - targetRow) == 1);
                        }

                        else
                            return (currentRow - targetRow > 0 && currentRow - targetRow <= 2);
                    }else{
                        return (currentRow - targetRow == 1);
                    }
                }
            } else {
                if (currentRow + 1 < 8 && !tiles[currentRow + 1][currentColumn].isTileEmpty()){
                    return false;
                }else{
                    if (currentRow == 1){
                        if (!tiles[currentRow + 2][currentColumn].isTileEmpty())
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

        if(this.getCoordinate().getRow() == targetRow && this.getCoordinate().getColumn() == targetColumn)
            return false;

        if (currentColumn != targetColumn) {
            if (this.getColor() == ColorType.WHITE) {
                if (currentRow - 1 == targetRow) {
                    if (!tiles[targetRow][targetColumn].isTileEmpty() && this.getColor() != tiles[targetRow][targetColumn].getPieceOnTile().getColor())
                        return currentColumn + 1 == targetColumn || currentColumn - 1 == targetColumn;
                }
            } else {
                if (currentRow + 1 == targetRow) {
                    if (!tiles[targetRow][targetColumn].isTileEmpty() && this.getColor() != tiles[targetRow][targetColumn].getPieceOnTile().getColor())
                        return currentColumn + 1 == targetColumn || currentColumn - 1 == targetColumn;
                }
            }

        }else{
            return (tiles[targetRow][targetColumn].isTileEmpty());
        }
        return false;
    }
}