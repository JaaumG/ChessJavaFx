package com.chess;

import com.Enums.Colors;
import javafx.scene.layout.AnchorPane;

public class ChessPieces {

    private final Enum<Colors> color;
    private AnchorPane position;
    private int moveCount = 0;

    public ChessPieces(Enum<Colors> color, AnchorPane position) {
        this.color = color;
        this.position = position;
    }

    public AnchorPane[] PossibleMoves(){
        return null;
    }

    public void setPosition(AnchorPane position) {
        this.position = position;
    }

    public Enum<Colors> getColor() {
        return color;
    }

    public AnchorPane getPosition() {
        return position;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
