package com.example.chessgame.Miscellaneous;

import com.example.chessgame.Enums.PieceType;

import java.io.FileWriter;
import java.io.PrintWriter;

import static com.example.chessgame.Controllers.ChessBoardController.tiles;

public class Log {
    public FileWriter file;
    public PrintWriter printFile;
    public int playersRound = 0;

    public void saveMove(int srcRow, int srcColumn, int destRow, int destColumn, int moves) {
        PieceType type = tiles[srcRow][srcColumn].getPieceOnTile().getType();
        if(playersRound == 0)
            printFile.printf(moves + ".");

        // Imprime o tipo de peça
        switch(type){
            case KING -> printFile.printf("K");
            case ROOK -> printFile.printf("R");
            case QUEEN -> printFile.printf("Q");
            case BISHOP -> printFile.printf("B");
            case KNIGHT -> printFile.printf("N");
        }

        // Caso ocorra uma captura de peça
        if(!tiles[destRow][destColumn].isTileEmpty()){
            if(type.equals(PieceType.PAWN))
                printFile.print(convertColumn(srcColumn));
            printFile.printf("x");
        }

        printFile.printf(convertColumn(destColumn) + convertRow(destRow));

        if(playersRound == 0) {
            printFile.printf(" ");
            playersRound = 1;
        }else{
            printFile.printf("\n");
            playersRound = 0;
        }
    }

    public void loadGame(){

    }

    public int convertRow(int row){
        return switch (row) {
            case 0 -> 8;
            case 1 -> 7;
            case 2 -> 6;
            case 3 -> 5;
            case 4 -> 4;
            case 5 -> 3;
            case 6 -> 2;
            case 7 -> 1;
            default -> 0;
        };
    }

    public String convertColumn(int column){
        return switch (column) {
            case 0 -> "a";
            case 1 -> "b";
            case 2 -> "c";
            case 3 -> "d";
            case 4 -> "e";
            case 5 -> "f";
            case 6 -> "g";
            case 7 -> "h";
            default -> " ";
        };
    }
}
