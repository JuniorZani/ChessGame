package com.example.chessgame;

import com.example.chessgame.Pieces.Piece;
import com.example.chessgame.Pieces.Rook;

import java.util.ArrayList;

public class Player {
    private final String name;
    private final ColorType color;
    private final ArrayList<Piece> playerPieces = new ArrayList<>();

    public String getName() {
        return name;
    }

    public ColorType getColor() {
        return color;
    }

    public ArrayList<Piece> getPieces() {
        return playerPieces;
    }

    public int numPieces(){
        return this.playerPieces.size();
    }

    public Piece has(PieceType type){
        for (Piece piece : playerPieces) {
            if(piece.getType() == type)
                return piece;
        }
        return null;
    }

    public Player(String name, ColorType color) {
        this.name = name;
        this.color = color;
    }
}
