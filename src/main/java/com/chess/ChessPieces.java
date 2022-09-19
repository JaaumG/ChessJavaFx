package com.chess;

import com.Enums.Colors;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class ChessPieces {

    private final Enum<Colors> color;
    private String position;
    private AnchorPane positioningridpane;
    private int moveCount = 0;

    public ChessPieces(Enum<Colors> color, String position, GridPane gridPane) {
        this.color = color;
        this.position = position;
        for (int i = 0; i < 63; i++) {
            if(gridPane.getChildren().get(i).getId().equals(position)){
                positioningridpane = (AnchorPane) gridPane.getChildren().get(i);
                return;
            }
        }
    }

    public AnchorPane[] PossibleMoves(){
        return null;
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

    public void setPositioningridpane(AnchorPane positioningridpane) {
        this.positioningridpane = positioningridpane;
    }
    public void setPositioningridpane(String position, GridPane gridPane) {
        for (int i = 0; i < 63; i++) {
            if(gridPane.getChildren().get(i).getId().equals(position)){
                positioningridpane = (AnchorPane) gridPane.getChildren().get(i);
                return;
            }
        }
    }
}
