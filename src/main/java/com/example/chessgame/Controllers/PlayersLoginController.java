package com.example.chessgame.Controllers;


import com.example.chessgame.ChessGameApplication;
import com.example.chessgame.Enums.ColorType;
import com.example.chessgame.Miscellaneous.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PlayersLoginController {
    @FXML
    Button OK = new Button();

    @FXML
    TextField blackField = null;

    @FXML
    TextField whiteField = null;

    public static Player blackPlayer, whitePlayer;

    public void goToBoard(ActionEvent actionEvent) throws IOException {
        if(blackField.getText().equals(""))
            blackPlayer = new Player("Preto", ColorType.BLACK);
        else
            blackPlayer = new Player(blackField.getText(), ColorType.BLACK);

        if(whiteField.getText().equals(""))
            whitePlayer = new Player("Branco", ColorType.WHITE);
        else
            whitePlayer = new Player(whiteField.getText(), ColorType.WHITE);


        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        ChessGameApplication.changeScene(stage,"fxmls/ChessBoard.fxml",950,750);

    }
}
