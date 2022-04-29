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

    exports bum4.browsing_football_rest_api.UI;
    opens bum4.browsing_football_rest_api.UI to javafx.fxml;
    exports bum4.browsing_football_rest_api.domain_logic;
    opens bum4.browsing_football_rest_api.domain_logic to javafx.fxml;
    exports bum4.browsing_football_rest_api;
    opens bum4.browsing_football_rest_api to javafx.fxml;
}