package com.chess;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class BoardController implements Initializable {

    @FXML
    private ImageView boardImage;
    @FXML
    private GridPane gridPane;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        boardImage.setImage(new Image("file:src/main/resources/boardImage.jpg"));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                AnchorPane anchorPane = new AnchorPane();
                anchorPane.setId(String.valueOf((char)(65+i))+String.valueOf(8-j));
                anchorPane.setOnMouseClicked(this::onAnchorPaneClicked);
                gridPane.add(anchorPane, i, j);
            }
        }
    }

    public void onAnchorPaneClicked(MouseEvent event){
        AnchorPane anchorPane = (AnchorPane) event.getSource();
        System.out.println(anchorPane.getId());
    }
}