package com.example.chessgame.Controllers;


import com.example.chessgame.ChessGameApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PlayersLoginController {

    @FXML
    Button OK = new Button();

    public void goToMenu(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        ChessGameApplication.changeScene(stage,"fxmls/ChessBoard.fxml",600,600);
    }
}
