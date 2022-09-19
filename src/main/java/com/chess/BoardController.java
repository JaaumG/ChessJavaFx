package com.chess;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class BoardController implements Initializable {

    @FXML
    private ImageView boardImage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        boardImage.setImage(new Image("file:src/main/resources/boardImage.jpg"));
    }
}