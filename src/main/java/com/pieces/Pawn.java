package com.pieces;

import com.Enums.Colors;
import com.chess.ChessPieces;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import org.kordamp.ikonli.javafx.FontIcon;

import java.util.ArrayList;

public class Pawn extends ChessPieces {

    private FontIcon symbol = new FontIcon();
    public Pawn(Enum<Colors> color, String position, GridPane gridPane, AnchorPane[][] anchorPanes) {
        super(color, position, gridPane, anchorPanes);
        symbol.setIconLiteral("mdi2c-chess-pawn");
        symbol.setOnMouseClicked(event -> {
            for (Object anchorpane: gridPane.getChildren().toArray()) {
                AnchorPane anchorPane = (AnchorPane) anchorpane;
                anchorPane.setBackground(null);
            }
            AnchorPane[] originalPossibleMoves = PossibleMoves();
            for (AnchorPane anchorpane:originalPossibleMoves) {
                anchorpane.setBackground(new Background(new BackgroundFill(Paint.valueOf("#555555"),null,null)));
            }

        });
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
    public AnchorPane[] PossibleMoves(){
        int positionx = getAnchorPaneX(), positiony = getAnchorPaneY(), k=0,l=0;
        ArrayList<AnchorPane> listPossibleMoves = new ArrayList<>();
        if(getColor().equals(Colors.WHITE)) {
            if (getMoveCount() == 0) {
                listPossibleMoves.add(getAnchorPanes()[positionx][positiony - 1]); //N
                listPossibleMoves.add(getAnchorPanes()[positionx][positiony - 2]); //N
            } else {
                listPossibleMoves.add(getAnchorPanes()[positionx][positiony - 1]); //N
            }
        }else{
            if (getMoveCount() == 0) {
                listPossibleMoves.add(getAnchorPanes()[positionx][positiony + 1]); //N
                listPossibleMoves.add(getAnchorPanes()[positionx][positiony + 2]); //N
            } else {
                listPossibleMoves.add(getAnchorPanes()[positionx][positiony + 1]); //N
            }
        }
        int listSize = listPossibleMoves.size();
        AnchorPane[] possibleMovesAsArray = new AnchorPane[listSize];
        for (int i = 0; i < listSize; i++) {
            possibleMovesAsArray[i] = listPossibleMoves.get(i);
        }
        return possibleMovesAsArray;
    }

}
