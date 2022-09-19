module com.chess.chessjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.materialdesign2;
    requires org.kordamp.ikonli.javafx;

    opens com.chess to javafx.fxml;
    exports com.chess;
}