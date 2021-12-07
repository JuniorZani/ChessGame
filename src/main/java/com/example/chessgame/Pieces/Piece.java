package com.example.chessgame.Pieces;

import com.example.chessgame.Enums.ColorType;
import com.example.chessgame.Miscellaneous.Coordinates;
import com.example.chessgame.Enums.PieceType;

import static com.example.chessgame.Controllers.ChessBoardController.tiles;

public abstract class Piece {
    private final ColorType color;
    private final Coordinates coordinate;
    private final PieceType type;

    public ColorType getColor() {
        return color;
    }

    public Coordinates getCoordinate() {
        return coordinate;
    }

    public PieceType getType() {
        return type;
    }

    public Piece(ColorType color, PieceType type, int row, int column) {
        this.color = color;
        this.type = type;
        coordinate = new Coordinates(row, column);
    }

    public abstract boolean canMove(int targetRow, int targetColumn);

    public boolean canEat(int targetRow, int targetColumn) {
        if(tiles[targetRow][targetColumn].isTileEmpty())
            return true;
        return tiles[targetRow][targetColumn].getPieceOnTile().getColor() != this.getColor();
    }

}
