package com.example.chessgame.Miscellaneous;

import com.example.chessgame.Pieces.Piece;

public class Tile{
    private Piece pieceOnTile;

    public Piece getPieceOnTile() {
        return pieceOnTile;
    }

    public void setPieceOnTile(Piece pieceOnTile) {
        this.pieceOnTile = pieceOnTile;
    }

    public boolean isTileEmpty(){
        return(getPieceOnTile() == null);
    }

    public Tile(Piece pieceOnTile, int row, int column) {
        this.pieceOnTile = pieceOnTile;
        this.pieceOnTile.getCoordinate().setRow(row);
        this.pieceOnTile.getCoordinate().setColumn(column);
    }

    public Tile(Piece pieceOnTile) {
        this.pieceOnTile = pieceOnTile;
    }
}

