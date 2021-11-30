package com.example.chessgame;

import com.example.chessgame.Pieces.Piece;
import com.example.chessgame.Pieces.Rook;

import java.util.ArrayList;

public class Player {
    private final String name;
    private final ColorType color;
    private final ArrayList<Piece> capturedPieces = new ArrayList<>();

    public String getName() {
        return name;
    }

    public ColorType getColor() {
        return color;
    }

    public ArrayList<Piece> getCapturedPieces() {
        return capturedPieces;
    }

    public int numPieces(){
        return this.capturedPieces.size();
    }

    public boolean has(Class<?> targetPieceType){
        for (Piece piece : capturedPieces) {
            if(piece.getClass().equals(targetPieceType))
                return false;
        }
        return true;
    }

    public Player(String name, ColorType color) {
        this.name = name;
        this.color = color;
    }
}
