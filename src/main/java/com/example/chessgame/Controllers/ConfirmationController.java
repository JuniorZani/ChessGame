package com.example.chessgame.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static com.example.chessgame.Controllers.ChessBoardController.tied;

public class ConfirmationController {
    @FXML
    Text title;

    @FXML
    ImageView image;

    Image flag = new Image("com/example/chessgame/images/white-flag.png");
    Image handshake = new Image("com/example/chessgame/images/handshake.png");

    public static boolean actionConfirmed = false;

    public void initialize(){
        if(tied){
            title.setText("O adversário propôs um empate");
            image.setImage(handshake);
        }else {
            title.setText("Render-se?");
            image.setImage(flag);
        }
    }

    public void confirm(ActionEvent actionEvent){
        actionConfirmed = true;
        Stage currentStage = (Stage) ((Node)(actionEvent.getSource())).getScene().getWindow();
        currentStage.close();
    }

    public void deny(ActionEvent actionEvent){
        actionConfirmed = false;
        Stage currentStage = (Stage) ((Node)(actionEvent.getSource())).getScene().getWindow();
        currentStage.close();
    }
}
