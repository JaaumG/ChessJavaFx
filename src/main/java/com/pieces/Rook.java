package com.pieces;

import com.Enums.Colors;
import com.chess.ChessPieces;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import org.kordamp.ikonli.javafx.FontIcon;

import java.util.ArrayList;

public class Rook extends ChessPieces {

    private FontIcon symbol = new FontIcon();
    public Rook(Enum<Colors> color, String position, GridPane gridPane, AnchorPane[][] anchorPanes) {
        super(color, position, gridPane, anchorPanes);
        symbol.setIconLiteral("mdi2c-chess-rook");
        symbol.setOnMouseClicked(event -> {
            for (Object anchorpane: gridPane.getChildren().toArray()) {
                AnchorPane anchorPane = (AnchorPane) anchorpane;
                anchorPane.setBackground(null);
            }
            AnchorPane[] originalPossibleMoves = PossibleMoves((FontIcon) event.getSource());
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
    public AnchorPane[] PossibleMoves(FontIcon fontIcon){
        int positionx = getAnchorPaneX(), positiony = getAnchorPaneY(), k=0,l=0;
        ArrayList<AnchorPane> listPossibleMoves = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            if (positionx - i >= 0) {
                if(getAnchorPanes()[positionx - i][positiony].getChildren().size()==0) {
                    listPossibleMoves.add(getAnchorPanes()[positionx - i][positiony]); //W
                }else{
                    break;
                }
            }
        }for (int i = 1; i < 8; i++) {
            if (positionx + i <= 7) {
                if(getAnchorPanes()[positionx + i][positiony].getChildren().size()==0) {
                    listPossibleMoves.add(getAnchorPanes()[positionx + i][positiony]); //E
                }else{
                    break;
                }
            }
        }for (int i = 1; i < 8; i++) {
            if(positiony-i>=0){
                if(getAnchorPanes()[positionx][positiony - i].getChildren().size()==0) {
                    listPossibleMoves.add(getAnchorPanes()[positionx][positiony - i]); //N
                }else{
                    break;
                }
            }
        }for (int i = 1; i < 8; i++) {
            if (positiony + i <= 7) {
                if(getAnchorPanes()[positionx][positiony + i].getChildren().size()==0) {
                    listPossibleMoves.add(getAnchorPanes()[positionx][positiony + i]); //S
                }else {
                    break;
                }
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
