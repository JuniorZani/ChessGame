package com.example.chessgame.Controllers;

import com.example.chessgame.ChessGameApplication;
import com.example.chessgame.Enums.ColorType;
import com.example.chessgame.Enums.PieceType;
import com.example.chessgame.Miscellaneous.Log;
import com.example.chessgame.Pieces.*;
import com.example.chessgame.Miscellaneous.Player;
import com.example.chessgame.Miscellaneous.Tile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.chessgame.ChessGameApplication.changeScene;
import static com.example.chessgame.ChessGameApplication.popUp;
import static com.example.chessgame.Controllers.ConfirmationController.actionConfirmed;
import static com.example.chessgame.Controllers.PlayersLoginController.blackPlayer;
import static com.example.chessgame.Controllers.PlayersLoginController.whitePlayer;

public class ChessBoardController {
    @FXML
    GridPane board = new GridPane();
    @FXML
    Text currentPlayerName;
    @FXML
    ImageView currentPlayerPiece;
    @FXML
    Button tie;

    public static boolean tied = false;
    public static String endGameReason;
    public static Tile[][] tiles = new Tile[8][8];
    public static Button[][] buttonMatrix = new Button[8][8];
    public static Player currentPlayer;

    int sourceRow, sourceColumn;
    int destinationRow, destinationColumn;
    int turns = 0, moves = 1;
    boolean clickStatus = false;
    boolean whiteKingChecked, blackKingChecked = false;
    Log gameLog = new Log();

    King blackPlayerKing, whitePlayerKing;
    Image blackPawn = new Image("com/example/chessgame/images/blackPawn.png"), whitePawn = new Image("com/example/chessgame/images/whitePawn.png");


    public void initialize() throws IOException {
        createBoard();
        currentPlayer = whitePlayer;
        whitePlayerKing = (King) whitePlayer.getKing();
        blackPlayerKing = (King) blackPlayer.getKing();
        currentPlayerName.setText(currentPlayer.getName());
        currentPlayerPiece.setImage(whitePawn);

        String logName = new SimpleDateFormat("yyyy-MM-dd-HHmmss'.txt'").format(new Date());
        gameLog.file = new FileWriter("src/main/resources/com/example/chessgame/logs/" + logName);
        gameLog.printFile = new PrintWriter(gameLog.file);
    }


    public void createBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                buttonMatrix[i][j] = new Button();
                buttonMatrix[i][j].setOnAction(this::click);
                tiles[i][j] = new Tile(null);
                setButtonColor(i, j);
                buttonMatrix[i][j].setPrefSize(75, 75);
                board.add(buttonMatrix[i][j], j, i);
            }
        }
        setPieces();
    }

    public void setButtonColor(int row, int column) {
        if ((row + column) % 2 == 0)
            buttonMatrix[row][column].setStyle("-fx-background-color: #E8EDF9;");
        else
            buttonMatrix[row][column].setStyle("-fx-background-color: #B7C0D8;");
    }

    public void setPieces() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                //BlackPieces
                if (i == 0) {
                    if (j == 0 || j == 7) {
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/blackRook.png", 60);
                        tiles[i][j].setPieceOnTile(new Rook(ColorType.BLACK, i, j));
                        blackPlayer.getPieces().add(tiles[i][j].getPieceOnTile());
                    }
                    if (j == 1 || j == 6) {
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/blackKnight.png", 60);
                        tiles[i][j].setPieceOnTile(new Knight(ColorType.BLACK, i, j));
                        blackPlayer.getPieces().add(tiles[i][j].getPieceOnTile());
                    }
                    if (j == 2 || j == 5) {
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/blackBishop.png", 60);
                        tiles[i][j].setPieceOnTile(new Bishop(ColorType.BLACK, i, j));
                        blackPlayer.getPieces().add(tiles[i][j].getPieceOnTile());
                    }
                    if (j == 3) {
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/blackQueen.png", 60);
                        tiles[i][j].setPieceOnTile(new Queen(ColorType.BLACK, i, j));
                        blackPlayer.getPieces().add(tiles[i][j].getPieceOnTile());
                    }
                    if (j == 4) {
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/blackKing.png", 60);
                        tiles[i][j].setPieceOnTile(new King(ColorType.BLACK, i, j));
                        blackPlayer.getPieces().add(tiles[i][j].getPieceOnTile());
                    }
                }
                if (i == 1) {
                    setImages(buttonMatrix[i][j], "com/example/chessgame/images/blackPawn.png", 60);
                    tiles[i][j].setPieceOnTile(new Pawn(ColorType.BLACK, i, j));
                    blackPlayer.getPieces().add(tiles[i][j].getPieceOnTile());
                }

                //WhitePieces
                if (i == 6) {
                    setImages(buttonMatrix[i][j], "com/example/chessgame/images/whitePawn.png", 60);
                    tiles[i][j].setPieceOnTile(new Pawn(ColorType.WHITE, i, j));
                    whitePlayer.getPieces().add(tiles[i][j].getPieceOnTile());
                }
                if (i == 7) {
                    if (j == 0 || j == 7) {
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/whiteRook.png", 60);
                        tiles[i][j].setPieceOnTile(new Rook(ColorType.WHITE, i, j));
                        whitePlayer.getPieces().add(tiles[i][j].getPieceOnTile());
                    }
                    if (j == 1 || j == 6) {
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/whiteKnight.png", 60);
                        tiles[i][j].setPieceOnTile(new Knight(ColorType.WHITE, i, j));
                        whitePlayer.getPieces().add(tiles[i][j].getPieceOnTile());
                    }
                    if (j == 2 || j == 5) {
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/whiteBishop.png", 60);
                        tiles[i][j].setPieceOnTile(new Bishop(ColorType.WHITE, i, j));
                        whitePlayer.getPieces().add(tiles[i][j].getPieceOnTile());
                    }
                    if (j == 3) {
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/whiteQueen.png", 60);
                        tiles[i][j].setPieceOnTile(new Queen(ColorType.WHITE, i, j));
                        whitePlayer.getPieces().add(tiles[i][j].getPieceOnTile());
                    }
                    if (j == 4) {
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/whiteKing.png", 60);
                        tiles[i][j].setPieceOnTile(new King(ColorType.WHITE, i, j));
                        whitePlayer.getPieces().add(tiles[i][j].getPieceOnTile());
                    }
                }
            }
        }
    }

    public void setImages(Button selectedButton, String Url, int dimensions) {
        ImageView newImageView = new ImageView();
        newImageView.setImage(new Image(Url));
        newImageView.setFitHeight(dimensions);
        newImageView.setFitWidth(dimensions);
        selectedButton.setGraphic(newImageView);
    }

    public void click(ActionEvent actionEvent) {
        Button clickedButton = (Button) actionEvent.getTarget();
        int row = GridPane.getRowIndex(clickedButton);
        int column = GridPane.getColumnIndex(clickedButton);

        if (currentPlayer == whitePlayer && blackPlayerKing.isChecked() || currentPlayer == blackPlayer && whitePlayerKing.isChecked()) {
            if (currentPlayer == whitePlayer) {
                currentPlayer = blackPlayer;
            } else
                currentPlayer = whitePlayer;
            endGameReason = "O rei advers??rio foi capturado";
            tied = false;
            endGame(actionEvent);
        }

        if (whitePlayerKing.isChecked())
            whiteKingChecked = true;
        else if (blackPlayerKing.isChecked())
            blackKingChecked = true;

        // Primeiro Clique
        if (!clickStatus) {
            if (tiles[row][column].getPieceOnTile() == null || tiles[row][column].getPieceOnTile().getColor() != currentPlayer.getColor())
                return;
            sourceRow = row;
            sourceColumn = column;
            buttonMatrix[sourceRow][sourceColumn].setStyle("-fx-background-color: #7B61FF;");
            showPossibleMoves();

        // Segundo clique
        } else {
            if (tiles[sourceRow][sourceColumn].getPieceOnTile().canMove(row, column) && tiles[sourceRow][sourceColumn].getPieceOnTile().canEat(row, column)) {
                destinationRow = row;
                destinationColumn = column;
                gameLog.saveMove(sourceRow, sourceColumn, destinationRow, destinationColumn, moves);
                if(currentPlayer.getColor().equals(ColorType.BLACK))
                    moves++;

                tradePositions();


                if (whiteKingChecked) {
                    endGameReason = "O rei advers??rio foi capturado";
                    currentPlayer = whitePlayer;
                    tied = false;
                    endGame(actionEvent);
                } else if (blackKingChecked) {
                    endGameReason = "O rei advers??rio foi capturado";
                    currentPlayer = blackPlayer;
                    tied = false;
                    endGame(actionEvent);
                }
            }
            showPossibleMoves();
            setButtonColor(sourceRow, sourceColumn);
        }

        if (verifyEndGame())
            endGame(actionEvent);

        clickStatus = !clickStatus;
        currentPlayerName.setText(currentPlayer.getName());
    }

    public void showPossibleMoves() {
        if (!clickStatus) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (tiles[i][j].isTileEmpty() && tiles[sourceRow][sourceColumn].getPieceOnTile().canMove(i, j)) {
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/overlay.png", 16);
                    } else {
                        if (tiles[sourceRow][sourceColumn].getPieceOnTile().canMove(i, j) && tiles[sourceRow][sourceColumn].getPieceOnTile().canEat(i, j)) {
                            buttonMatrix[i][j].setStyle("-fx-background-color: #E49E9E;");
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    setButtonColor(i, j);
                    if (tiles[i][j].isTileEmpty())
                        buttonMatrix[i][j].setGraphic(null);
                }
            }
        }

    }

    public void tradePositions() {
        if (currentPlayer == whitePlayer) {
            //In case a black piece is eaten
            if (!tiles[destinationRow][destinationColumn].isTileEmpty() || tiles[sourceRow][sourceColumn].getPieceOnTile().getType() == PieceType.PAWN) {
                blackPlayer.getPieces().remove(tiles[destinationRow][destinationColumn].getPieceOnTile());
                turns = 0;
            } else
                turns++;
            currentPlayer = blackPlayer;
            currentPlayerPiece.setImage(blackPawn);
        } else {
            //In case a white piece is eaten
            if (!tiles[destinationRow][destinationColumn].isTileEmpty() || tiles[sourceRow][sourceColumn].getPieceOnTile().getType() == PieceType.PAWN) {
                whitePlayer.getPieces().remove(tiles[destinationRow][destinationColumn].getPieceOnTile());
                turns = 0;
            } else
                turns++;
            currentPlayer = whitePlayer;
            currentPlayerPiece.setImage(whitePawn);
        }

        tiles[destinationRow][destinationColumn].setPieceOnTile(tiles[sourceRow][sourceColumn].getPieceOnTile());
        tiles[destinationRow][destinationColumn].getPieceOnTile().getCoordinate().setRow(destinationRow);
        tiles[destinationRow][destinationColumn].getPieceOnTile().getCoordinate().setColumn(destinationColumn);
        tiles[sourceRow][sourceColumn] = new Tile(null);
        buttonMatrix[destinationRow][destinationColumn].setGraphic(buttonMatrix[sourceRow][sourceColumn].getGraphic());
        buttonMatrix[sourceRow][sourceColumn].setGraphic(null);

        if (!blackPlayerKing.isChecked()) {
            blackKingChecked = false;
        }

        if (!whitePlayerKing.isChecked()) {
            whiteKingChecked = false;
        }
    }


    public boolean verifyEndGame() {

        boolean pawnsUnmoved = turns == 50;

        if (pawnsUnmoved) {
            endGameReason = "Os pe??es n??o foram movimentados e nenhuma pe??a foi capturada durante 50 turnos do jogo";
            tied = true;
            return true;
        } else
            return false;
    }

    public void endGame(ActionEvent actionEvent) {
        try {
            gameLog.file.close();
            popUp("Fim de Jogo", "com/example/chessgame/images/blackRook.png", "fxmls/EndGamePopUp.fxml", 350, 250);
            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            changeScene(currentStage, "fxmls/PlayersLogin.fxml", 400, 300);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void proposeTie(ActionEvent actionEvent) throws IOException {
        tied = true;
        popUp("Proposta De Empate", "com/example/chessgame/images/handshake.png", "fxmls/Confirmation.fxml", 350, 250);
        if (actionConfirmed) {
            endGameReason = "Ambos os jogadores aceitaram o fim do jogo";
            endGame(actionEvent);
        }
    }

    public void surrender(ActionEvent actionEvent) throws IOException {
        tied = false;
        popUp("Confirma????o de Desist??ncia", "com/example/chessgame/images/white-flag.png", "fxmls/Confirmation.fxml", 350, 250);
        if (actionConfirmed) {
            endGameReason = "O jogador advers??rio se rendeu";
            endGame(actionEvent);
        }
    }

    public void backToMenu(ActionEvent actionEvent) throws IOException {
        gameLog.file.close();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        ChessGameApplication.changeScene(stage,"fxmls/PlayersLogin.fxml",400,300);
    }
}