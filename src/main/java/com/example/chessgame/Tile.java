package com.example.chessgame;

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

    public Tile(Piece pieceOnTile) {
        this.pieceOnTile = pieceOnTile;
    }
}

