module com.example.chessgame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.example.chessgame.Pieces to javafx.fxml;
    exports com.example.chessgame.Pieces;
    opens com.example.chessgame to javafx.fxml;
    exports com.example.chessgame;
}