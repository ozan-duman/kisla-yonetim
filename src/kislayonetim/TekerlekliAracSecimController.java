package kislayonetim;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class TekerlekliAracSecimController implements Initializable {

    @FXML
    private AnchorPane TekerlekliAracSecimPane;

    @FXML
    void AskeriAracButon(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("AskeriArac.fxml"));
        TekerlekliAracSecimPane.getChildren().setAll(pane);
    }

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Anasayfa.fxml"));
        TekerlekliAracSecimPane.getChildren().setAll(pane);
    }

    @FXML
    void SivilAracButon(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("SivilArac.fxml"));
        TekerlekliAracSecimPane.getChildren().setAll(pane);
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
