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

    boolean clickStatus = false;
    int sourceRow, sourceColumn;
    int destinationRow, destinationColumn;
    public static Tile [][] tileMatrix = new Tile[8][8];

    public void initialize(){
        createBoard();
    }

    public void createBoard(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                buttonMatrix[i][j] = new Button();
                buttonMatrix[i][j].setOnAction(this::click);
                tileMatrix[i][j] = new Tile(null);

                if((i + j) % 2 == 0)
                    buttonMatrix[i][j].setStyle("-fx-background-color: #E8EDF9;");
                else
                    buttonMatrix[i][j].setStyle("-fx-background-color: #B7C0D8;");

                buttonMatrix[i][j].setPrefSize(75, 75);
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
                        tileMatrix[i][j].setPieceOnTile(new Rook(ColorType.BLACK, i, j));
                    }
                    if( j == 1 || j == 6) {
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/blackKnight.png");
                        tileMatrix[i][j].setPieceOnTile(new Knight(ColorType.BLACK, i, j));
                    }
                    if(j == 2 || j == 5) {
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/blackBishop.png");
                        tileMatrix[i][j].setPieceOnTile(new Bishop(ColorType.BLACK, i, j));
                    }
                    if(j == 3){
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/blackQueen.png");
                        tileMatrix[i][j++].setPieceOnTile(new Queen(ColorType.BLACK, i, j));
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/blackKing.png");
                        tileMatrix[i][j].setPieceOnTile(new King(ColorType.BLACK, i, j));
                    }
                }
                if(i == 1) {
                    setImages(buttonMatrix[i][j], "com/example/chessgame/images/blackPawn.png");
                    tileMatrix[i][j].setPieceOnTile(new Pawn(ColorType.BLACK, i, j));
                }

                //WhitePieces
                if(i == 6) {
                    setImages(buttonMatrix[i][j], "com/example/chessgame/images/whitePawn.png");
                    tileMatrix[i][j].setPieceOnTile(new Pawn(ColorType.WHITE, i, j));
                }
                if(i == 7){
                    if(j == 0 || j == 7) {
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/whiteRook.png");
                        tileMatrix[i][j].setPieceOnTile(new Rook(ColorType.WHITE, i, j));
                    }
                    if(j == 1 || j == 6) {
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/whiteKnight.png");
                        tileMatrix[i][j].setPieceOnTile(new Knight(ColorType.WHITE, i, j));
                    }
                    if(j == 2 || j == 5) {
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/whiteBishop.png");
                        tileMatrix[i][j].setPieceOnTile(new Bishop(ColorType.WHITE, i, j));
                    }
                    if(j == 3) {
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/whiteQueen.png");
                        tileMatrix[i][j++].setPieceOnTile(new Queen(ColorType.WHITE, i, j));
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/whiteKing.png");
                        tileMatrix[i][j].setPieceOnTile(new King(ColorType.WHITE, i, j));
                    }
                }
            }
        }
    }

    public void setImages(Button selectedButton, String Url){
        ImageView newImageView = new ImageView();
        newImageView.setImage(new Image(Url));
        newImageView.setFitHeight(60);
        newImageView.setFitWidth(60);
        selectedButton.setGraphic(newImageView);
    }


    public void click(ActionEvent actionEvent){
        Button clickedButton = (Button) actionEvent.getTarget();
        int row = GridPane.getRowIndex(clickedButton);
        int column = GridPane.getColumnIndex(clickedButton);

        if(!clickStatus){
            if(tileMatrix[row][column].getPieceOnTile() == null)
                return;
            sourceRow = row;
            sourceColumn = column;
            buttonMatrix[sourceRow][sourceColumn].setStyle("-fx-background-color: #7B61FF;");
            System.out.println("First Click");

        }else{
            if((sourceRow != row || sourceColumn != column) && tileMatrix[sourceRow][sourceColumn].getPieceOnTile().canMove(row, column)) {
                destinationRow = row;
                destinationColumn = column;
                tradePositions();
                System.out.println("Second Click");
            }
            if((sourceRow + sourceColumn) % 2 == 0)
                buttonMatrix[sourceRow][sourceColumn].setStyle("-fx-background-color: #E8EDF9;");
            else
                buttonMatrix[sourceRow][sourceColumn].setStyle("-fx-background-color: #B7C0D8;");
        }
        clickStatus = !clickStatus;
    }

    public void tradePositions() {
        tileMatrix[destinationRow][destinationColumn].setPieceOnTile(tileMatrix[sourceRow][sourceColumn].getPieceOnTile());
        tileMatrix[destinationRow][destinationColumn].getPieceOnTile().getCoordinate().setRow(destinationRow);
        tileMatrix[destinationRow][destinationColumn].getPieceOnTile().getCoordinate().setColumn(destinationColumn);
        tileMatrix[sourceRow][sourceColumn] = new Tile(null);
        buttonMatrix[destinationRow][destinationColumn].setGraphic(buttonMatrix[sourceRow][sourceColumn].getGraphic());
        buttonMatrix[sourceRow][sourceColumn].setGraphic(null);
    }
}