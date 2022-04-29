package bum4.browsing_football_rest_api;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;

public class CompetionsBrowse extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CompetionsBrowse.class.getResource("Browser.fxml"));
        System.out.println(fxmlLoader.getLocation());
        Scene scene = new Scene(fxmlLoader.load(), 970, 430);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());

        stage.sizeToScene();
        stage.setTitle("Football competions  Browsing");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}