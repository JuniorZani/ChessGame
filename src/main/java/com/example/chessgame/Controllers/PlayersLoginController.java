package com.example.chessgame.Controllers;


import com.example.chessgame.ChessGameApplication;
import com.example.chessgame.ColorType;
import com.example.chessgame.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class PlayersLoginController {
    @FXML
    Button OK = new Button();

    @FXML
    TextField blackField;

    @FXML
    TextField whiteField;

    public static Player blackPlayer, whitePlayer;

    public void goToMenu(ActionEvent actionEvent) throws IOException {
        blackPlayer = new Player(blackField.getText(), ColorType.BLACK);
        whitePlayer = new Player(whiteField.getText(), ColorType.WHITE);

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        ChessGameApplication.changeScene(stage,"fxmls/ChessBoard.fxml",950,750);
    }
}
