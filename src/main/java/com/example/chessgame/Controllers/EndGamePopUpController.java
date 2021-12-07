package com.example.chessgame.Controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import static com.example.chessgame.Controllers.ChessBoardController.*;
import static com.example.chessgame.Controllers.PlayersLoginController.*;

public class EndGamePopUpController {
    @FXML
    Label endGameTitle;

    @FXML
    Text endGameText;

    @FXML
    ImageView image;

    Image confetti = new Image("com/example/chessgame/images/confetties.png");
    Image handshake = new Image("com/example/chessgame/images/handshakes.png");

    public void initialize(){
        if(tied) {
            endGameTitle.setText("Empate");
            image.setImage(handshake);
        }else{
            if(currentPlayer == blackPlayer)
                currentPlayer = whitePlayer;
            else
                currentPlayer = blackPlayer;
            endGameTitle.setText("Vitória de " + currentPlayer.getName() + "!");
            image.setImage(confetti);
        }
        endGameText.setText(endGameReason);
    }

    public void closePopUp(ActionEvent actionEvent) {
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }
}