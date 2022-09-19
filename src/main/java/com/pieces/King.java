package com.pieces;

import com.Enums.Colors;
import com.chess.ChessPieces;
import javafx.scene.layout.AnchorPane;

public class King extends ChessPieces {

    private boolean check;

    public King(Enum<Colors> color, AnchorPane position) {
        super(color, position);
    }

    @Override
    public AnchorPane[] PossibleMoves(){
        return null;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
