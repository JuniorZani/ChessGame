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

        if (!(Math.abs(targetRow - currentRow) <= 1 &&  Math.abs(targetColumn - currentColumn) <= 1) || this.isDestinationChecked(targetRow, targetColumn)) {
            return false;
        }

        if(tileMatrix[targetRow][targetColumn].getPieceOnTile() == null || this.getColor() != tileMatrix[targetRow][targetColumn].getPieceOnTile().getColor()){
            return true;
        }else
            return tileMatrix[targetRow][targetColumn].isTileEmpty();
    }

    public boolean isDestinationChecked(int targetRow, int targetColumn){
        for(int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if(!tileMatrix[i][j].isTileEmpty() && tileMatrix[i][j].getPieceOnTile().getColor() != this.getColor()){
                    if(tileMatrix[i][j].getPieceOnTile().canMove(targetRow, targetColumn)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isChecked(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j< 8; j++){
                if(!tileMatrix[i][j].isTileEmpty() && tileMatrix[i][j].getPieceOnTile().getColor() != this.getColor())
                    if(tileMatrix[i][j].getPieceOnTile().canEat(this.getCoordinate().getRow(), this.getCoordinate().getRow()))
                        return true;
            }
        }
        return false;
    }
}
