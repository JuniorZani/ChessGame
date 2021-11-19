package com.example.chessgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class ChessBoardController {
    @FXML
    GridPane board =  new GridPane();

    @FXML
    Button [][] buttonMatrix = new Button[8][8];

    Tile [][] tileMatrix = new Tile[8][8];

    public void initialize(){
        createBoard();
    }

    public void createBoard(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                buttonMatrix[i][j] = new Button();
                buttonMatrix[i][j].setOnAction(this::gridSensivel);
                tileMatrix[i][j] = new Tile();

                if((i + j) % 2 == 0){
                    buttonMatrix[i][j].setStyle("-fx-background-color: #779556;");
                    buttonMatrix[i][j].setPrefSize(100, 100);
                }else {
                    buttonMatrix[i][j].setStyle("-fx-background-color: #EBECD0;");
                    buttonMatrix[i][j].setPrefSize(100, 100);
                }
                board.add(buttonMatrix[i][j], j, i);
            }
        }
    }
    public void gridSensivel(ActionEvent actionEvent){
        Node clickedNode = (Node)actionEvent.getTarget();

        int row = GridPane.getRowIndex(clickedNode);
        int column = GridPane.getColumnIndex(clickedNode);

        System.out.println("Row: " + row + " Column:" + column);
    }

}