package com.example.chessgame;

import com.example.chessgame.Pieces.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import static com.example.chessgame.Controllers.PlayersLoginController.blackPlayer;
import static com.example.chessgame.Controllers.PlayersLoginController.whitePlayer;


public class ChessBoardController {
    @FXML
    GridPane board =  new GridPane();
    @FXML
    Text currentPlayerName;
    @FXML
    ImageView currentPlayerPiece;

    Button [][] buttonMatrix = new Button[8][8];
    public static Tile [][] tiles = new Tile[8][8];
    Player currentPlayer = whitePlayer;
    Image blackPawn = new Image("com/example/chessgame/images/blackPawn.png"), whitePawn = new Image("com/example/chessgame/images/whitePawn.png");
    boolean clickStatus = false;
    int kingRow, kingColumn;
    int sourceRow, sourceColumn;
    int destinationRow, destinationColumn;

    public void initialize(){
        createBoard();
        currentPlayerName.setText(currentPlayer.getName());
        currentPlayerPiece.setImage(whitePawn);
    }

    public void setButtonColor(int row, int column){
        if((row + column) % 2 == 0)
            buttonMatrix[row][column].setStyle("-fx-background-color: #E8EDF9;");
        else
            buttonMatrix[row][column].setStyle("-fx-background-color: #B7C0D8;");
    }

    public void createBoard(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                buttonMatrix[i][j] = new Button();
                //buttonMatrix[i][j].setOnAction(this::click);
                buttonMatrix[i][j].setOnMouseClicked(this::click);
                tiles[i][j] = new Tile(null);
                setButtonColor(i, j);
                buttonMatrix[i][j].setPrefSize(75, 75);
                board.add(buttonMatrix[i][j], j, i);
            }
        }
        setPieces();
    }

    public void setPieces(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                //BlackPieces
                if(i == 0){
                    if( j == 0 || j == 7) {
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/blackRook.png", 60);
                        tiles[i][j].setPieceOnTile(new Rook(ColorType.BLACK, i, j));
                        blackPlayer.getPieces().add(tiles[i][j].getPieceOnTile());
                    }
                    if( j == 1 || j == 6) {
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/blackKnight.png", 60);
                        tiles[i][j].setPieceOnTile(new Knight(ColorType.BLACK, i, j));
                        blackPlayer.getPieces().add(tiles[i][j].getPieceOnTile());
                    }
                    if(j == 2 || j == 5) {
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/blackBishop.png", 60);
                        tiles[i][j].setPieceOnTile(new Bishop(ColorType.BLACK, i, j));
                        blackPlayer.getPieces().add(tiles[i][j].getPieceOnTile());
                    }
                    if(j == 3) {
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/blackQueen.png", 60);
                        tiles[i][j].setPieceOnTile(new Queen(ColorType.BLACK, i, j));
                        blackPlayer.getPieces().add(tiles[i][j].getPieceOnTile());
                    }
                    if(j == 4){
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/blackKing.png", 60);
                        tiles[i][j].setPieceOnTile(new King(ColorType.BLACK, i, j));
                        blackPlayer.getPieces().add(tiles[i][j].getPieceOnTile());
                    }
                }
                if(i == 1) {
                    setImages(buttonMatrix[i][j], "com/example/chessgame/images/blackPawn.png", 60);
                    tiles[i][j].setPieceOnTile(new Pawn(ColorType.BLACK, i, j));
                    blackPlayer.getPieces().add(tiles[i][j].getPieceOnTile());
                }

                //WhitePieces
                if(i == 6) {
                    setImages(buttonMatrix[i][j], "com/example/chessgame/images/whitePawn.png", 60);
                    tiles[i][j].setPieceOnTile(new Pawn(ColorType.WHITE, i, j));
                    whitePlayer.getPieces().add(tiles[i][j].getPieceOnTile());
                }
                if(i == 7){
                    if(j == 0 || j == 7) {
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/whiteRook.png", 60);
                        tiles[i][j].setPieceOnTile(new Rook(ColorType.WHITE, i, j));
                        whitePlayer.getPieces().add(tiles[i][j].getPieceOnTile());
                    }
                    if(j == 1 || j == 6) {
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/whiteKnight.png", 60);
                        tiles[i][j].setPieceOnTile(new Knight(ColorType.WHITE, i, j));
                        whitePlayer.getPieces().add(tiles[i][j].getPieceOnTile());
                    }
                    if(j == 2 || j == 5) {
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/whiteBishop.png", 60);
                        tiles[i][j].setPieceOnTile(new Bishop(ColorType.WHITE, i, j));
                        whitePlayer.getPieces().add(tiles[i][j].getPieceOnTile());
                    }
                    if(j == 3) {
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/whiteQueen.png", 60);
                        tiles[i][j].setPieceOnTile(new Queen(ColorType.WHITE, i, j));
                        whitePlayer.getPieces().add(tiles[i][j].getPieceOnTile());
                    }
                    if(j == 4){
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/whiteKing.png", 60);
                        tiles[i][j].setPieceOnTile(new King(ColorType.WHITE, i, j));
                        whitePlayer.getPieces().add(tiles[i][j].getPieceOnTile());
                    }
                }
            }
        }
    }

    public void setImages(Button selectedButton, String Url, int dimensions){
        ImageView newImageView = new ImageView();
        newImageView.setImage(new Image(Url));
        newImageView.setFitHeight(dimensions);
        newImageView.setFitWidth(dimensions);
        selectedButton.setGraphic(newImageView);
    }

    public void showPossibleMoves(boolean clickStatus){
        if(!clickStatus){
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    if(tiles[i][j].isTileEmpty() && tiles[sourceRow][sourceColumn].getPieceOnTile().canMove(i, j)){
                        setImages(buttonMatrix[i][j], "com/example/chessgame/images/Overlay.png", 16);
                    }else{
                        if(tiles[sourceRow][sourceColumn].getPieceOnTile().canMove(i, j) && tiles[sourceRow][sourceColumn].getPieceOnTile().canEat(i, j)){
                            buttonMatrix[i][j].setStyle("-fx-background-color: #E49E9E;");
                        }
                    }
                }
            }
        }else{
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    setButtonColor(i,j);
                    if(tiles[i][j].isTileEmpty())
                        buttonMatrix[i][j].setGraphic(null);
                }
            }
        }

    }

    public void click(MouseEvent actionEvent){
        Button clickedButton = (Button) actionEvent.getTarget();
        int row = GridPane.getRowIndex(clickedButton);
        int column = GridPane.getColumnIndex(clickedButton);

        if(!clickStatus){
            if(tiles[row][column].getPieceOnTile() == null)// || tileMatrix[row][column].getPieceOnTile().getColor() != currentPlayer.getColor())
                return;

//            King king = (King) currentPlayer.has(PieceType.KING);
//
//            if(king != null)
//                System.out.println("TEM");
//            else
//                System.out.println("N TEM");

            sourceRow = row;
            sourceColumn = column;
            buttonMatrix[sourceRow][sourceColumn].setStyle("-fx-background-color: #7B61FF;");
            showPossibleMoves(clickStatus);

        }else{
            if((sourceRow != row || sourceColumn != column) && tiles[sourceRow][sourceColumn].getPieceOnTile().canMove(row, column) && tiles[sourceRow][sourceColumn].getPieceOnTile().canEat(row, column)){
                destinationRow = row;
                destinationColumn = column;
                tradePositions();
            }
            showPossibleMoves(clickStatus);
            setButtonColor(sourceRow, sourceColumn);
        }
        currentPlayerName.setText(currentPlayer.getName());
        clickStatus = !clickStatus;
    }

    public void tradePositions() {
        if(currentPlayer == whitePlayer) {
            //In case a black piece is eaten
            if(!tiles[destinationRow][destinationColumn].isTileEmpty())
                blackPlayer.getPieces().remove(tiles[destinationRow][destinationColumn].getPieceOnTile());

            currentPlayer = blackPlayer;
            currentPlayerPiece.setImage(blackPawn);
        }else{
            //In case a white piece is eaten
            if(!tiles[destinationRow][destinationColumn].isTileEmpty())
                whitePlayer.getPieces().remove(tiles[destinationRow][destinationColumn].getPieceOnTile());
            currentPlayer = whitePlayer;
            currentPlayerPiece.setImage(whitePawn);
        }

        tiles[destinationRow][destinationColumn].setPieceOnTile(tiles[sourceRow][sourceColumn].getPieceOnTile());
        tiles[destinationRow][destinationColumn].getPieceOnTile().getCoordinate().setRow(destinationRow);
        tiles[destinationRow][destinationColumn].getPieceOnTile().getCoordinate().setColumn(destinationColumn);
        tiles[sourceRow][sourceColumn] = new Tile(null);
        buttonMatrix[destinationRow][destinationColumn].setGraphic(buttonMatrix[sourceRow][sourceColumn].getGraphic());
        buttonMatrix[sourceRow][sourceColumn].setGraphic(null);
    }
}