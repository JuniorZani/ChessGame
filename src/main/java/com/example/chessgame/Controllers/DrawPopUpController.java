package com.example.chessgame.Controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.chessgame.ChessBoardController.finalizationReason;
import static com.example.chessgame.ChessGameApplication.changeScene;

public class DrawPopUpController {
    @FXML
    Text drawReason;

    @FXML
    Button backToMenu;

    public void initialize(){
        drawReason.setText(finalizationReason);
    }

    public void closePopUp(ActionEvent actionEvent) {
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }
}
