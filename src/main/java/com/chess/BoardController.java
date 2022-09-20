package com.chess;

import com.Enums.Colors;
import com.pieces.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.util.ResourceBundle;

public class BoardController implements Initializable {

    @FXML
    private ImageView boardImage;
    @FXML
    private GridPane gridPane;
    private ChessPieces[] chessPieces = new ChessPieces[32];

    public AnchorPane[][] anchorPanes = new AnchorPane[8][8];
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        boardImage.setImage(new Image("file:src/main/resources/boardImage.jpg"));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                AnchorPane anchorPane = new AnchorPane();
                anchorPane.setId(String.valueOf((char)(65+i))+String.valueOf(8-j));
                anchorPane.setOnMouseClicked(this::onAnchorPaneClicked);
                gridPane.add(anchorPane, i, j);
                anchorPanes[i][j]= anchorPane;
            }
        }
        SetPieces();
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public void onAnchorPaneClicked(MouseEvent event){
        AnchorPane anchorPane = (AnchorPane) event.getSource();
        System.out.println(anchorPane.getId());
    }

    private void SetPieces(){
        King whiteKing = new King(Colors.WHITE, "E1", gridPane, anchorPanes);
        King blackKing = new King(Colors.BLACK, "E8",gridPane, anchorPanes);
        Queen whiteQueen = new Queen(Colors.WHITE, "D1", gridPane, anchorPanes);
        Queen blackQueen = new Queen(Colors.BLACK, "D8", gridPane, anchorPanes);
        Bishop whiteBishopLeft = new Bishop(Colors.WHITE, "C1", gridPane, anchorPanes);
        Bishop whiteBishopRight = new Bishop(Colors.WHITE, "F1", gridPane, anchorPanes);
        Bishop blackBishopLeft = new Bishop(Colors.BLACK, "C8", gridPane, anchorPanes);
        Bishop blackBishopRight = new Bishop(Colors.BLACK, "F8", gridPane, anchorPanes);
        Knight whiteKnightLeft = new Knight(Colors.WHITE, "B1", gridPane, anchorPanes);
        Knight whiteKnightRight = new Knight(Colors.WHITE, "G1", gridPane, anchorPanes);
        Knight blackKnightLeft = new Knight(Colors.BLACK, "B8", gridPane, anchorPanes);
        Knight blackKnightRight = new Knight(Colors.BLACK, "G8", gridPane, anchorPanes);
        Rook whiteRookLeft = new Rook(Colors.WHITE, "A1", gridPane, anchorPanes);
        Rook whiteRookRight = new Rook(Colors.WHITE, "H1", gridPane, anchorPanes);
        Rook blackRookLeft = new Rook(Colors.BLACK, "A8", gridPane, anchorPanes);
        Rook blackRookRight = new Rook(Colors.BLACK, "H8", gridPane, anchorPanes);
        Pawn whitePawA = new Pawn(Colors.WHITE, "A2",gridPane, anchorPanes);
        Pawn whitePawB = new Pawn(Colors.WHITE, "B2",gridPane, anchorPanes);
        Pawn whitePawC = new Pawn(Colors.WHITE, "C2",gridPane, anchorPanes);
        Pawn whitePawD = new Pawn(Colors.WHITE, "D2",gridPane, anchorPanes);
        Pawn whitePawE = new Pawn(Colors.WHITE, "E2",gridPane, anchorPanes);
        Pawn whitePawF = new Pawn(Colors.WHITE, "F2",gridPane, anchorPanes);
        Pawn whitePawG = new Pawn(Colors.WHITE, "G2",gridPane, anchorPanes);
        Pawn whitePawH = new Pawn(Colors.WHITE, "H2",gridPane, anchorPanes);
        Pawn blackPawA = new Pawn(Colors.BLACK, "A7",gridPane, anchorPanes);
        Pawn blackPawB = new Pawn(Colors.BLACK, "B7",gridPane, anchorPanes);
        Pawn blackPawC = new Pawn(Colors.BLACK, "C7",gridPane, anchorPanes);
        Pawn blackPawD = new Pawn(Colors.BLACK, "D7",gridPane, anchorPanes);
        Pawn blackPawE = new Pawn(Colors.BLACK, "E7",gridPane, anchorPanes);
        Pawn blackPawF = new Pawn(Colors.BLACK, "F7",gridPane, anchorPanes);
        Pawn blackPawG = new Pawn(Colors.BLACK, "G7",gridPane, anchorPanes);
        Pawn blackPawH = new Pawn(Colors.BLACK, "H7",gridPane, anchorPanes);
        chessPieces = new ChessPieces[]{whiteKing, blackKing, whiteQueen, blackQueen, whiteBishopLeft, whiteBishopRight, blackBishopLeft, blackBishopRight, whiteKnightLeft, whiteKnightRight, blackKnightLeft, blackKnightRight,whiteRookLeft, whiteRookRight, blackRookRight, blackRookLeft, whitePawA, whitePawB,whitePawC,whitePawD,whitePawE,whitePawF,whitePawG,whitePawH,blackPawA,blackPawB,blackPawC,blackPawD,blackPawE,blackPawF,blackPawG,blackPawH};


    }
}