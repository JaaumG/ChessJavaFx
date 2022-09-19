module com.chess.chessjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.chess to javafx.fxml;
    exports com.chess;
}