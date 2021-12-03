package com.example.chessgame.Controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import static com.example.chessgame.ChessBoardController.*;
import static com.example.chessgame.Controllers.PlayersLoginController.*;

public class EndGamePopUpController {
    @FXML
    Text endGameTitle;

    @FXML
    Text endGameText;

    @FXML
    Button backToMenu;

    public void initialize(){
        if(tied) {
            endGameTitle.setText("Empate");
            endGameText.setText(endGameReason);
        }else{
            if(currentPlayer == blackPlayer)
                currentPlayer = whitePlayer;
            else
                currentPlayer = blackPlayer;
            endGameTitle.setText("Vitória de " + currentPlayer.getName() + "!");
            endGameText.setText(endGameReason);
        }
    }

    public void closePopUp(ActionEvent actionEvent) {
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }
}