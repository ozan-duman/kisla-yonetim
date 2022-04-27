package kislayonetim;

import dosyaIslemleri.DosyaIslemleri;
import egitim.AsciEgitim;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class AsciEgitimController implements Initializable {

    @FXML
    private AnchorPane AsciEgitimPane;

    @FXML
    private TableView<AsciEgitim> AsciEgitimTablo;

    @FXML
    private TableColumn<AsciEgitim, String> AsciOgretmenAdTablo;

    @FXML
    private TableColumn<AsciEgitim, String> AsciOgretmenAlanTablo;

    @FXML
    private TableColumn<AsciEgitim, String> AsciEgitimAdTablo;

    @FXML
    private TableColumn<AsciEgitim, String> AsciEgitimSaatTablo;

    @FXML
    private TableColumn<AsciEgitim, String> AsciEgitimTuruTablo;

    @FXML
    private TextField AsciOgretmenAd;

    @FXML
    private TextField AsciOgretmenAlan;

    @FXML
    private TextField AsciEgitimAd;

    @FXML
    private TextField AsciHaftalikSaat;

    @FXML
    private TextField AsciEgitimTuru;

    @FXML
    private Label AsciEgitimLabel;

    AsciEgitim ascegtm = new AsciEgitim();
    DosyaIslemleri ds = new DosyaIslemleri();
    ObservableList<AsciEgitim> listele = FXCollections.observableArrayList();

    @FXML
    void Ekle(ActionEvent event) throws IOException {
        ascegtm.setOgretmenAd(AsciOgretmenAd.getText().toString());
        ascegtm.setOgretmenAlan(AsciOgretmenAlan.getText().toString());
        ascegtm.setEgitimAd(AsciEgitimAd.getText().toString());
        ascegtm.setHaftalikEgitimSaat(AsciHaftalikSaat.getText().toString());
        ascegtm.setEgitimTuru(AsciEgitimTuru.getText().toString());
        ds.AsciEgitimEkle(ascegtm.getOgretmenAd(), ascegtm.getOgretmenAlan(), ascegtm.getEgitimAd(), ascegtm.getHaftalikEgitimSaat(), ascegtm.getEgitimTuru());
        
        AsciEgitimLabel.setText(ascegtm.mesaj());
    }

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("SivilPersonelEgitimSecim.fxml"));
        AsciEgitimPane.getChildren().setAll(pane);
    }

    @FXML
    void Yenile(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("AsciEgitim.fxml"));
        AsciEgitimPane.getChildren().setAll(pane);
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File ascegtm = new File("AsciEgitim.txt");
        if (!ascegtm.exists()) {
            try {
                ascegtm.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(ascegtm);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String line;

        BufferedReader br = new BufferedReader(fileReader);
        int i = 0;

        try {
            byte ax = 0;
            String OgretmenAd = "", OgretmenAlan = "", EgitimAd = "", HaftalikEgitimSaat = "", EgitimTuru = "";
            while ((line = br.readLine()) != null) {
                ax++;
                if (ax == 1) {
                    OgretmenAd = line;
                } else if (ax == 2) {
                    OgretmenAlan = line;
                } else if (ax == 3) {
                    EgitimAd = line;
                } else if (ax == 4) {
                    HaftalikEgitimSaat = line;
                } else if (ax == 5) {
                    EgitimTuru = line;
                } else if (ax == 6) {
                    listele.add(new AsciEgitim(OgretmenAd, OgretmenAlan, EgitimAd, HaftalikEgitimSaat, EgitimTuru));
                    ax = 0;
                }

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            br.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        AsciEgitimTablo.setItems(listele);
        AsciOgretmenAdTablo.setCellValueFactory(new PropertyValueFactory<AsciEgitim, String>("OgretmenAd"));
        AsciOgretmenAlanTablo.setCellValueFactory(new PropertyValueFactory<AsciEgitim, String>("OgretmenAlan"));
        AsciEgitimAdTablo.setCellValueFactory(new PropertyValueFactory<AsciEgitim, String>("EgitimAd"));
        AsciEgitimSaatTablo.setCellValueFactory(new PropertyValueFactory<AsciEgitim, String>("HaftalikEgitimSaat"));
        AsciEgitimTuruTablo.setCellValueFactory(new PropertyValueFactory<AsciEgitim, String>("EgitimTuru"));
    }

}
