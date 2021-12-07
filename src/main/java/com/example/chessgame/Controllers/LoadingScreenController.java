package com.example.chessgame.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import static com.example.chessgame.ChessGameApplication.*;

public class LoadingScreenController{

    @FXML
    ProgressBar progressBar;

    @FXML
    Button goOn;

    double i = 0;

    public void initialize() {
            setProgressBar();
    }

    public void setProgressBar(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(i < 1)
                progressBar.setProgress(i = i + 0.001);
                else{
                    timer.cancel();
                    goOn.setVisible(true);
                }
            }
        }, 0, 2);
    }

    public void finishedLoading(ActionEvent actionEvent) throws IOException {
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        changeScene(currentStage, "fxmls/PlayersLogin.fxml", 400, 300);
    }

}