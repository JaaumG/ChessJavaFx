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

public class Knight extends ChessPieces {

    private FontIcon symbol = new FontIcon();
    public Knight(Enum<Colors> color, String position, GridPane gridPane, AnchorPane[][] anchorPanes) {
        super(color, position, gridPane, anchorPanes);
        symbol.setIconLiteral("mdi2c-chess-knight");
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
        int positionx = getAnchorPaneX(), positiony = getAnchorPaneY();
        ArrayList<AnchorPane> listPossibleMoves = new ArrayList<>();
        if (positionx - 1 >= 0 && positiony - 2 >= 0) {
            if(getAnchorPanes()[positionx - 1][positiony - 2].getChildren().size()==0 || ((FontIcon)getAnchorPanes()[positionx - 1][positiony - 2].getChildren().get(0)).getFill()!=symbol.getFill()) {
                listPossibleMoves.add(getAnchorPanes()[positionx - 1][positiony - 2]);//NW
            }
        }if (positionx + 1 <= 7 && positiony + 2 <= 7) {
            if (getAnchorPanes()[positionx + 1][positiony + 2].getChildren().size()==0 || ((FontIcon)getAnchorPanes()[positionx + 1][positiony + 2].getChildren().get(0)).getFill()!=symbol.getFill()) {
                listPossibleMoves.add(getAnchorPanes()[positionx + 1][positiony + 2]);//SE
            }
        }if (positionx - 1 >= 0 && positiony + 2 <= 7) {
            if(getAnchorPanes()[positionx - 1][positiony + 2].getChildren().size()==0 || ((FontIcon)getAnchorPanes()[positionx - 1][positiony + 2].getChildren().get(0)).getFill()!=symbol.getFill()) {
                listPossibleMoves.add(getAnchorPanes()[positionx - 1][positiony + 2]);//SW
            }
        }if (positionx + 1 <= 7 && positiony - 2 >= 0) {
            if(getAnchorPanes()[positionx + 1][positiony - 2].getChildren().size()==0 || ((FontIcon)getAnchorPanes()[positionx + 1][positiony - 2].getChildren().get(0)).getFill()!=symbol.getFill()) {
                listPossibleMoves.add(getAnchorPanes()[positionx + 1][positiony - 2]); //NE
            }
        }if (positionx - 2 >= 0 && positiony - 1 >= 0) {
            if(getAnchorPanes()[positionx - 2][positiony - 1].getChildren().size()==0 || ((FontIcon)getAnchorPanes()[positionx - 2][positiony - 1].getChildren().get(0)).getFill()!=symbol.getFill()){
                listPossibleMoves.add(getAnchorPanes()[positionx - 2][positiony - 1]);//NW
            }
        }if (positionx + 2 <= 7 && positiony + 1 <= 7) {
            if(getAnchorPanes()[positionx + 2][positiony + 1].getChildren().size()==0|| ((FontIcon)getAnchorPanes()[positionx + 2][positiony + 1].getChildren().get(0)).getFill()!=symbol.getFill()) {
                listPossibleMoves.add(getAnchorPanes()[positionx + 2][positiony + 1]);//SE
            }
        }if (positionx - 2 >= 0 && positiony + 1 <= 7) {
            if(getAnchorPanes()[positionx - 2][positiony + 1].getChildren().size()==0|| ((FontIcon)getAnchorPanes()[positionx -2][positiony + 1].getChildren().get(0)).getFill()!=symbol.getFill()) {
                listPossibleMoves.add(getAnchorPanes()[positionx - 2][positiony + 1]);//SW
            }
        }if (positionx + 2 <= 7 && positiony - 1 >= 0) {
            if(getAnchorPanes()[positionx + 2][positiony - 1].getChildren().size()==0|| ((FontIcon)getAnchorPanes()[positionx + 2][positiony - 1].getChildren().get(0)).getFill()!=symbol.getFill()) {
                listPossibleMoves.add(getAnchorPanes()[positionx + 2][positiony - 1]); //NE
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
