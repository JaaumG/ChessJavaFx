package com.pieces;

import com.Enums.Colors;
import com.chess.ChessPieces;
import javafx.scene.layout.AnchorPane;

public class Queen extends ChessPieces {


    public Queen(Enum<Colors> color, AnchorPane position) {
        super(color, position);
    }

    @Override
    public AnchorPane[] PossibleMoves(){
        return null;
    }

}
