package kislayonetim;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class SivilPersonelSecimController implements Initializable {

    @FXML
    private AnchorPane SivilPersonelSecimPane;

    @FXML
    void AsciButon(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Asci.fxml"));
        SivilPersonelSecimPane.getChildren().setAll(pane);
    }

    @FXML
    void DoktorButon(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Doktor.fxml"));
        SivilPersonelSecimPane.getChildren().setAll(pane);
    }

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Anasayfa.fxml"));
        SivilPersonelSecimPane.getChildren().setAll(pane);
    }

    @FXML
    void MemurButon(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Memur.fxml"));
        SivilPersonelSecimPane.getChildren().setAll(pane);
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
