package com.pieces;

import com.Enums.Colors;
import com.chess.ChessPieces;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import org.kordamp.ikonli.javafx.FontIcon;

import java.util.ArrayList;
import java.util.List;

public class King extends ChessPieces {

    private boolean check;
    private FontIcon symbol = new FontIcon();

    public King(Enum<Colors> color, String position, GridPane gridPane, AnchorPane[][] anchorPanes) {
        super(color, position, gridPane, anchorPanes);
        symbol.setIconLiteral("mdi2c-chess-king");
        symbol.setIconSize(50);
        if (color.equals(Colors.WHITE)){
            symbol.setFill(Paint.valueOf("#FFFFFF"));
        }else{
            symbol.setFill(Paint.valueOf("#000000"));
        }
        AnchorPane.setBottomAnchor(symbol, 0.0);
        AnchorPane.setTopAnchor(symbol, 0.0);
        AnchorPane.setLeftAnchor(symbol, 0.0);
        AnchorPane.setRightAnchor(symbol, 0.0);
        this.getPositioningridpane().getChildren().add(symbol);
    }

    @Override
    public AnchorPane[] PossibleMoves(boolean diagonal, boolean straight){
        int positionx = getAnchorPaneX(), positiony = getAnchorPaneY();
        ArrayList<AnchorPane> listPossibleMoves = new ArrayList<>();
        if (positionx - 1 >= 0) {
            listPossibleMoves.add(getAnchorPanes()[positionx - 1][positiony]); //W
        }if (positionx + 1 <= 7) {
            listPossibleMoves.add(getAnchorPanes()[positionx + 1][positiony]); //E
        }if(positiony-1>=0){
            listPossibleMoves.add(getAnchorPanes()[positionx][positiony - 1]); //N
        }if (positiony + 1 <= 7) {
            listPossibleMoves.add(getAnchorPanes()[positionx][positiony + 1]); //S
        }
        if (positionx - 1 >= 0 && positiony - 1 >= 0) {
            listPossibleMoves.add(getAnchorPanes()[positionx - 1][positiony - 1]);//NW
        }if (positionx + 1 <= 7 && positiony + 1 <= 7) {
            listPossibleMoves.add(getAnchorPanes()[positionx + 1][positiony + 1]);//SE
        }if (positionx - 1 >= 0 && positiony + 1 <= 7) {
            listPossibleMoves.add(getAnchorPanes()[positionx - 1][positiony + 1]);//SW
        }if (positionx + 1 <= 7 && positiony - 1 >= 0) {
            listPossibleMoves.add(getAnchorPanes()[positionx + 1][positiony - 1]); //NE
        }
        int listSize = listPossibleMoves.size();
        AnchorPane[] possibleMovesAsArray = new AnchorPane[listSize];
        for (int i = 0; i < listSize; i++) {
            possibleMovesAsArray[i] = listPossibleMoves.get(i);
        }
        return possibleMovesAsArray;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

}
