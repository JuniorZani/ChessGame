package com.example.chessgame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChessGameApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        System.setProperty("prism.lcdtext", "false");
        FXMLLoader fxmlLoader = new FXMLLoader(ChessGameApplication.class.getResource("fxmls/PlayersLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        stage.setTitle("Chess Game");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void changeScene(Stage stage, String fxmlPath, int width, int height) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ChessGameApplication.class.getResource(fxmlPath));
        Scene scene = new Scene(fxmlLoader.load(), width, height);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}