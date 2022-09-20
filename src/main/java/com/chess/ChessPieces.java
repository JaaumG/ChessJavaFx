package com.chess;

import com.Enums.Colors;
import javafx.event.EventHandler;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import org.kordamp.ikonli.javafx.FontIcon;

import java.util.ArrayList;

public abstract class ChessPieces {

    private final Enum<Colors> color;
    private String position;
    private AnchorPane positioningridpane;

    public AnchorPane[][] getAnchorPanes() {
        return anchorPanes;
    }

    private AnchorPane[][] anchorPanes;
    private int moveCount = 0;
    private FontIcon symbol = new FontIcon();

    public ChessPieces(Enum<Colors> color, String position, GridPane gridPane, AnchorPane[][] anchorPanes) {
        this.color = color;
        this.position = position;
        this.anchorPanes = anchorPanes;
        positioningridpane = getAnchorPaneAsChessNotation(position, gridPane);
    }
    public int getAnchorPaneX(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(this.getAnchorPanes()[i][j]==this.getPositioningridpane()){
                    return i;
                }
            }
        }
        return 0;
    }
    public int getAnchorPaneY(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(this.getAnchorPanes()[i][j]==this.getPositioningridpane()){
                    return j;
                }
            }
        }
        return 0;
    }
    public AnchorPane getAnchorPaneAsChessNotation(String position,GridPane gridPane){
        for (int i = 0; i < 64; i++) {
            if(gridPane.getChildren().get(i).getId().equals(position)){
                return (AnchorPane) gridPane.getChildren().get(i);
            }
        }
        return null;
    }
    public void increaseMoveCount(){
        moveCount+=1;
    }

    public AnchorPane[] PossibleMoves() {
        int positionx = getAnchorPaneX(), positiony = getAnchorPaneY(), k=0,l=0;
        ArrayList<AnchorPane> listPossibleMoves = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            if (positionx - i >= 0) {
                listPossibleMoves.add(getAnchorPanes()[positionx - i][positiony]); //W
            }if (positionx + i <= 7) {
                listPossibleMoves.add(getAnchorPanes()[positionx + i][positiony]); //E
            }if(positiony-i>=0){
                listPossibleMoves.add(getAnchorPanes()[positionx][positiony - i]); //N
            }if (positiony + i <= 7) {
                listPossibleMoves.add(getAnchorPanes()[positionx][positiony + i]); //S
            }
            if (positionx - i >= 0 && positiony - i >= 0) {
                listPossibleMoves.add(getAnchorPanes()[positionx - i][positiony - i]);//NW
            }if (positionx + i <= 7 && positiony + i <= 7) {
                        listPossibleMoves.add(getAnchorPanes()[positionx + i][positiony + i]);//SE
            }if (positionx - i >= 0 && positiony + i <= 7) {
                    listPossibleMoves.add(getAnchorPanes()[positionx - i][positiony + i]);//SW
            }if (positionx + i <= 7 && positiony - i >= 0) {
                    listPossibleMoves.add(getAnchorPanes()[positionx + i][positiony - i]); //NE
            }
        }
        int listSize = listPossibleMoves.size();
        AnchorPane[] possibleMovesAsArray = new AnchorPane[listSize];
        for (int i = 0; i < listSize; i++) {
            possibleMovesAsArray[i] = listPossibleMoves.get(i);
        }
        return possibleMovesAsArray;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Enum<Colors> getColor() {
        return color;
    }

    public String getPosition() {
        return positioningridpane.getId();
    }

    public int getMoveCount() {
        return moveCount;
    }

    public AnchorPane getPositioningridpane() {
        return positioningridpane;
    }

    public void setPositioningridpane(AnchorPane positioningridpane, AnchorPane previousposition) {
        previousposition.getChildren().removeAll();
        positioningridpane.getChildren().add(symbol);
        this.positioningridpane = positioningridpane;
    }
    public void setPositioningridpane(String position, GridPane gridPane) {
        positioningridpane = getAnchorPaneAsChessNotation(position, gridPane);
    }

}
