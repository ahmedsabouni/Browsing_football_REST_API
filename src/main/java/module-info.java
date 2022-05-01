module bum4.browsing_football_rest_api {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;
    requires okhttp3;
    requires java.desktop;
    requires batik.transcoder;
    requires javafx.swing;
    exports UI;
    opens UI to javafx.fxml;
    exports doman_logic;
    opens doman_logic to javafx.fxml;
}