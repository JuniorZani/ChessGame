package com.example.chessgame.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static com.example.chessgame.ChessBoardController.tied;

public class ConfirmationController {
    @FXML
    Text title;

    public static boolean actionConfirmed = false;

    public void initialize(){
        if(tied){
            title.setText("O adversário propôs um empate");
        }else
            title.setText("Render-se?");
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
