package kislayonetim;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.layout.AnchorPane;

public class TesissecimekraniController implements Initializable {

    @FXML
    private AnchorPane SecimPane;

    @FXML
    void garajButon(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Garaj.fxml"));
        SecimPane.getChildren().setAll(pane);
    }

    @FXML
    void depoButon(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Depo.fxml"));
        SecimPane.getChildren().setAll(pane);
    }

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Anasayfa.fxml"));
        SecimPane.getChildren().setAll(pane);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
