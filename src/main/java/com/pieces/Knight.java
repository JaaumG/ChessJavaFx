package com.pieces;

import com.Enums.Colors;
import com.chess.ChessPieces;
import javafx.scene.layout.AnchorPane;

public class Knight extends ChessPieces {


    public Knight(Enum<Colors> color, AnchorPane position) {
        super(color, position);
    }

    @Override
    public AnchorPane[] PossibleMoves(){
        return null;
    }

}
