package bum4.browsing_football_rest_api;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import javafx.embed.swing.SwingFXUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class BrowserController {
    public TextField areaIdField;
    public TextField areaNameField;
    public TextField areaCountryCodeField;
    public TextField startDate;
    public TextField endDate;
    public TextField competitionNameField;
    public TextField competionIdField;
    public Manager manager=new Manager();
    public ImageView emblemeView;

    List<Competition> competitions = manager.competions();

    public static int i=0;

    @FXML
    public void initialize() throws IOException {
    insert( manager.competions().get(0) );
    }

    public void insert(Competition competition) throws IOException {
        emblemeView.setImage(null);
        competionIdField.setText(String.valueOf(competition.id));
        competitionNameField.setText(competition.name);
        endDate.setText(competition.currentSeason.endDate);
        startDate.setText(competition.currentSeason.startDate);
        areaIdField.setText(String.valueOf(competition.area.id));
        areaNameField.setText(competition.area.name);
        areaCountryCodeField.setText(competition.area.countryCode);

        if (competition.emblemUrl != null ) {
            if (competition.emblemUrl.substring(competition.emblemUrl.lastIndexOf(".")).equals(".svg")) {
            BufferedImageTranscoder transcoder = new BufferedImageTranscoder();
            URL url = new URL(competition.emblemUrl);
            URLConnection urlConnection = url.openConnection();
            try (InputStream file = urlConnection.getInputStream()
            ) {
                TranscoderInput transIn = new TranscoderInput(file);
                try {
                    transcoder.transcode(transIn, null);
                    WritableImage img = SwingFXUtils.toFXImage(transcoder.getBufferedImage(), null);
                    emblemeView.setImage(img);
                } catch (TranscoderException ex) {
                    ex.printStackTrace();
                }
            }
            catch (IOException io) {
                io.printStackTrace();
            }}
        else if (competition.emblemUrl.substring(competition.emblemUrl.lastIndexOf(".")).equals(".png")) {
            Image image = new Image(competition.emblemUrl);
            emblemeView.setImage(image);
            }
        else {
                System.out.println("format not supported");
            }
        }


    }
    public void previousCompetion(ActionEvent actionEvent) throws IOException {
        if(i>0){
            i--;
            Competition competition = competitions.get(i);
            insert(competition);
        }
    }
    public void nextCompetion(ActionEvent actionEvent) throws IOException {

        if(i<competitions.size()-1){
            i++;
            Competition competition = competitions.get(i);
            insert(competition);
        }
    }}
