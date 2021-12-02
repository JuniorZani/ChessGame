package com.example.chessgame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class ChessGameApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        System.setProperty("prism.lcdtext", "false");
        FXMLLoader fxmlLoader = new FXMLLoader(ChessGameApplication.class.getResource("fxmls/PlayersLogin.fxml"));
        Image Icon = new Image("com/example/chessgame/Images/blackRook.png");
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);

        stage.setTitle("Chess Game");
        stage.getIcons().add(Icon);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void changeScene(Stage stage, String fxmlPath, int width, int height) throws IOException {
        System.setProperty("prism.lcdtext", "false");
        FXMLLoader fxmlLoader = new FXMLLoader(ChessGameApplication.class.getResource(fxmlPath));
        Scene scene = new Scene(fxmlLoader.load(), width, height);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public static void popUp(String fxmlPath, int width, int height) throws IOException {
            System.setProperty("prism.lcdtext", "false");
            Stage popUpStage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(ChessGameApplication.class.getResource(fxmlPath));
            Scene scene = new Scene(fxmlLoader.load(), width, height);
            popUpStage.setScene(scene);
            popUpStage.centerOnScreen();
            popUpStage.showAndWait();
//            popUpStage.close();


    }

    public static void main(String[] args) {
        launch();
    }
}