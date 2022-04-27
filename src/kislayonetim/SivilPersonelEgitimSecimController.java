package kislayonetim;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class SivilPersonelEgitimSecimController implements Initializable {

    @FXML
    private AnchorPane SivilPersonelEgitimPane;

    @FXML
    void AsciEgitimButon(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("AsciEgitim.fxml"));
        SivilPersonelEgitimPane.getChildren().setAll(pane);
    }

    @FXML
    void DoktorEgitimButon(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("DoktorEgitim.fxml"));
        SivilPersonelEgitimPane.getChildren().setAll(pane);
    }

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Anasayfa.fxml"));
        SivilPersonelEgitimPane.getChildren().setAll(pane);
    }

    @FXML
    void MemurEgitimButon(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("MemurEgitim.fxml"));
        SivilPersonelEgitimPane.getChildren().setAll(pane);
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
