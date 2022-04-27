package kislayonetim;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class AnasayfaController implements Initializable {

    @FXML
    private AnchorPane AnaPane;

    @FXML
    void AskeriEgitim(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("AskeriPersonelEgitimSecim.fxml"));
        AnaPane.getChildren().setAll(pane);
    }

    @FXML
    void SivilEgitim(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("SivilPersonelEgitimSecim.fxml"));
        AnaPane.getChildren().setAll(pane);
    }

    @FXML
    void AskeriPersonel(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("AskeriPersonelSecim.fxml"));
        AnaPane.getChildren().setAll(pane);
    }

    @FXML
    void BarinmaTesisleri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("BarinmaTesisleri.fxml"));
        AnaPane.getChildren().setAll(pane);
    }

    @FXML
    void CokAmacliTesisler(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Tesissecimekrani.fxml"));
        AnaPane.getChildren().setAll(pane);

    }

    @FXML
    void FizikselEgitim(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("FizikselEgitim.fxml"));
        AnaPane.getChildren().setAll(pane);
    }

    @FXML
    void KarbonhidratUrunleri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("KarbonhidratUrunleri.fxml"));
        AnaPane.getChildren().setAll(pane);
    }

    @FXML
    void Mermiler(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Mermiler.fxml"));
        AnaPane.getChildren().setAll(pane);
    }

    @FXML
    void PaletliAraclar(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("PaletliAracSecim.fxml"));
        AnaPane.getChildren().setAll(pane);
    }

    @FXML
    void Patlayicilar(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Patlayicilar.fxml"));
        AnaPane.getChildren().setAll(pane);
    }

    @FXML
    void ProteinUrunleri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("ProteinUrunleri.fxml"));
        AnaPane.getChildren().setAll(pane);
    }

    @FXML
    void SaglıkTesisleri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("SaglikTesisleri.fxml"));
        AnaPane.getChildren().setAll(pane);
    }

    @FXML
    void Silahlar(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Silahlar.fxml"));
        AnaPane.getChildren().setAll(pane);
    }

    @FXML
    void SivilPersonel(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("SivilPersonelSecim.fxml"));
        AnaPane.getChildren().setAll(pane);
    }

    @FXML
    void TekerlekliAraclar(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("TekerlekliAracSecim.fxml"));
        AnaPane.getChildren().setAll(pane);
    }

    @FXML
    void Icecekler(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Icecekler.fxml"));
        AnaPane.getChildren().setAll(pane);
    }

    @FXML
    void Ilaclar(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Ilaclar.fxml"));
        AnaPane.getChildren().setAll(pane);
    }

    @FXML
    void MaasButon(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Maas.fxml"));
        AnaPane.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
