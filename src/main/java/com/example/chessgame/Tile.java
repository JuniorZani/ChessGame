package com.example.chessgame;

import com.example.chessgame.Pieces.Piece;

public class Tile{
    private Piece pieceOnTile = null;

    public Piece getPieceOnTile() {
        return pieceOnTile;
    }

    public void setPieceOnTile(Piece pieceOnTile) {
        this.pieceOnTile = pieceOnTile;
    }
}

