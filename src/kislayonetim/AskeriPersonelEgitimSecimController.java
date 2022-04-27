package kislayonetim;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class AskeriPersonelEgitimSecimController implements Initializable {

    @FXML
    private AnchorPane AskeriPersonelEgitimSecimPane;

    @FXML
    void AstsubayEgitimButon(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("AstsubayEgitim.fxml"));
        AskeriPersonelEgitimSecimPane.getChildren().setAll(pane);
    }

    @FXML
    void ErEgitimButon(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("ErEgitim.fxml"));
        AskeriPersonelEgitimSecimPane.getChildren().setAll(pane);
    }

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Anasayfa.fxml"));
        AskeriPersonelEgitimSecimPane.getChildren().setAll(pane);
    }

    @FXML
    void SubayEgitimButon(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("SubayEgitim.fxml"));
        AskeriPersonelEgitimSecimPane.getChildren().setAll(pane);
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
