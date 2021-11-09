package com.example.chessgame;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class ChessBoardController {
    @FXML
    GridPane board =  new GridPane();

    Button [][] newButton =  new Button[8][8];

    public void initialize(){
        createBoard();
    }

    public void createBoard(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                newButton[i][j] = new Button();
                if((i + j)%2 == 0){
                    newButton[i][j].setStyle("-fx-background-color: #779556;");
                    newButton[i][j].setPrefSize(112.5, 112.5);
                }else {
                    newButton[i][j].setStyle("-fx-background-color: #EBECD0;");
                    newButton[i][j].setPrefSize(112.5, 112.5);
                }
                board.add( newButton[i][j], i, j);
            }
        }
    }

}