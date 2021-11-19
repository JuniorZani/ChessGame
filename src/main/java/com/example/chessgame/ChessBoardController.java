package com.example.chessgame;

import com.example.chessgame.Pieces.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;



public class ChessBoardController {
    @FXML
    GridPane board =  new GridPane();

    Button [][] buttonMatrix = new Button[8][8];

    Tile [][] tileMatrix = new Tile[8][8];

    public void initialize(){
        createBoard();
    }

    public void createBoard(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                buttonMatrix[i][j] = new Button();
                buttonMatrix[i][j].setOnAction(this::gridSensibility);
                tileMatrix[i][j] = new Tile();

                if((i + j) % 2 == 0)
                    buttonMatrix[i][j].setStyle("-fx-background-color: #E8EDF9;");
                else
                    buttonMatrix[i][j].setStyle("-fx-background-color: #B7C0D8;");

                buttonMatrix[i][j].setPrefSize(100, 100);
                board.add(buttonMatrix[i][j], j, i);
            }
        }
        setPieces();
    }

    public void setPieces(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                //BlackPieces
                if(i == 0){
                    if( j == 0 || j == 7) {
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/blackRook.png");
                        tileMatrix[i][j].setPieceOnTile(new Rook("Black"));
                    }
                    if( j == 1 || j == 6) {
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/blackKnight.png");
                        tileMatrix[i][j].setPieceOnTile(new Knight("Black"));
                    }
                    if(j == 2 || j == 5) {
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/blackBishop.png");
                        tileMatrix[i][j].setPieceOnTile(new Bishop("Black"));
                    }
                    if(j == 3){
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/blackQueen.png");
                        tileMatrix[i][j++].setPieceOnTile(new Queen("Black"));
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/blackKing.png");
                        tileMatrix[i][j].setPieceOnTile(new King("Black"));
                    }
                }
                if(i == 1) {
                    setImages(buttonMatrix[i][j], "com/example/chessgame/images/blackPawn.png");
                    tileMatrix[i][j].setPieceOnTile(new Pawn("Black"));
                }


                //WhitePieces
                if(i == 6) {
                    setImages(buttonMatrix[i][j], "com/example/chessgame/images/whitePawn.png");
                    tileMatrix[i][j].setPieceOnTile(new Pawn("White"));
                }
                if(i == 7){
                    if(j == 0 || j == 7) {
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/whiteRook.png");
                        tileMatrix[i][j].setPieceOnTile(new Rook("White"));
                    }
                    if(j == 1 || j == 6) {
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/whiteKnight.png");
                        tileMatrix[i][j].setPieceOnTile(new Knight("White"));
                    }
                    if(j == 2 || j == 5) {
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/whiteBishop.png");
                        tileMatrix[i][j].setPieceOnTile(new Bishop("White"));
                    }
                    if(j == 3) {
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/whiteQueen.png");
                        tileMatrix[i][j++].setPieceOnTile(new Queen("White"));
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/whiteKing.png");
                        tileMatrix[i][j].setPieceOnTile(new King("White"));
                    }
                }
            }
        }
    }

    public void setImages(Button newButton, String Url){
        ImageView newImageView = new ImageView();
        newImageView.setImage(new Image(Url));
        newImageView.setFitHeight(80);
        newImageView.setFitWidth(80);
        newButton.setGraphic(newImageView);
    }

    public void gridSensibility(ActionEvent actionEvent){
        Node clickedNode = (Node)actionEvent.getTarget();

        int row = GridPane.getRowIndex(clickedNode);
        int column = GridPane.getColumnIndex(clickedNode);

        System.out.println("Row: " + row + " Column: " + column);
        System.out.println("Piece on tile: " + tileMatrix[row][column].getPieceOnTile() + "\nPiece Color: " + tileMatrix[row][column].getPieceOnTile().getColor());
    }
}