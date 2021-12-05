package com.example.chessgame.Pieces;

import com.example.chessgame.ColorType;
import com.example.chessgame.PieceType;

import static com.example.chessgame.Controllers.ChessBoardController.tiles;
import static com.example.chessgame.Controllers.ChessBoardController.buttonMatrix;

public class King extends Piece{

    public King(ColorType color, int row, int column) {
        super(color, PieceType.KING, row, column);
    }

    @Override
    public boolean canMove(int targetRow, int targetColumn) {
        int currentRow = getCoordinate().getRow();
        int currentColumn = getCoordinate().getColumn();

        if (!(Math.abs(targetRow - currentRow) <= 1 &&  Math.abs(targetColumn - currentColumn) <= 1) || this.isChecked(targetRow, targetColumn)) {
            return false;
        }

        if(tiles[targetRow][targetColumn].getPieceOnTile() == null || this.getColor() != tiles[targetRow][targetColumn].getPieceOnTile().getColor()){
            return true;
        }else
            return tiles[targetRow][targetColumn].isTileEmpty();
    }

    public boolean isChecked(int targetRow, int targetColumn){
        for(int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if(!tiles[i][j].isTileEmpty() && tiles[i][j].getPieceOnTile().getColor() != this.getColor()){
                    if(tiles[i][j].getPieceOnTile().canMove(targetRow, targetColumn)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean isChecked(){
        for(int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if(!tiles[i][j].isTileEmpty() && tiles[i][j].getPieceOnTile().getColor() != this.getColor()){
                    if(tiles[i][j].getPieceOnTile().canMove(this.getCoordinate().getRow(), this.getCoordinate().getColumn())){
                        System.out.println("Linha: " + this.getCoordinate().getRow() + "Coluna: " + this.getCoordinate().getColumn());
                        buttonMatrix[this.getCoordinate().getRow()][this.getCoordinate().getColumn()].setStyle("-fx-background-color: #E49E9E;");
                        return true;
                    }
                }
            }
        }
        return false;
    }


}
