module com.example.chessgame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.example.chessgame.Controllers to javafx.fxml;
    exports com.example.chessgame.Controllers;
    opens com.example.chessgame.Pieces to javafx.fxml;
    exports com.example.chessgame.Pieces;
    opens com.example.chessgame to javafx.fxml;
    exports com.example.chessgame;
    exports com.example.chessgame.Enums;
    opens com.example.chessgame.Enums to javafx.fxml;
    exports com.example.chessgame.Miscellaneous;
    opens com.example.chessgame.Miscellaneous to javafx.fxml;
}