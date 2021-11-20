package com.example.chessgame.Pieces;

import com.example.chessgame.ColorType;

public class Bishop extends Piece{

    public Bishop(ColorType color, int row, int column) {
        super(color, row, column);
    }

    @Override
    public boolean canMove(int targetRow, int targetColumn) {
        return true;
    }
}
