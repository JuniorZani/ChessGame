package com.example.chessgame.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;

public class LoadingScreenController {

    @FXML
    ProgressBar progressBar;

    public void initialize(){
       setProgressBar(0);
    }

    public void loading() throws InterruptedException {
        for(double i = 0; i <= 100; i++){
            setProgressBar(i);
            Thread.sleep(100);
        }
    }

    public void setProgressBar(double progress){
        progressBar.setProgress(progress);
    }
}
