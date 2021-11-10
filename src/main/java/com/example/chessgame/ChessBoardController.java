package com.example.chessgame;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class ChessBoardController {
    @FXML
    GridPane board =  new GridPane();



    @FXML
    ImageView [][] sprite = new ImageView[8][8];


    public void initialize(){
        createBoard();
    }

    public void createBoard(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                Button newButton = new Button();
                sprite[i][j] = new ImageView();
                sprite[i][j].setFitWidth(64);
                sprite[i][j].setFitHeight(64);
                newButton.setGraphic(sprite[i][j]);

                if((i + j)%2 == 0){
                    newButton.setStyle("-fx-background-color: #779556;");
                    newButton.setPrefSize(100, 100);
                }else {
                    newButton.setStyle("-fx-background-color: #EBECD0;");
                    newButton.setPrefSize(100, 100);
                }
                board.add(newButton, i, j);
            }
        }
        setSprites();
    }

    public void setSprites(){
        Image asset = new Image("com/example/chessgame/Images/blackKing.png");
        Image asset2 = new Image("com/example/chessgame/Images/icons8-pawn-50.png");
        Image asset3 = new Image("com/example/chessgame/Images/rook.png");
        sprite[0][0].setImage(asset);
        sprite[7][0].setImage(asset2);
        sprite[4][0].setImage(asset3);

    }

}