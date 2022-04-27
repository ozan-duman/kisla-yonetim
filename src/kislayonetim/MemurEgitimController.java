package kislayonetim;

import dosyaIslemleri.DosyaIslemleri;
import egitim.MemurEgitim;
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

public class MemurEgitimController implements Initializable {

    @FXML
    private AnchorPane MemurEgitimPane;

    @FXML
    private TableView<MemurEgitim> MemurEgitimTablo;

    @FXML
    private TableColumn<MemurEgitim, String> MemurOgretmenAdTablo;

    @FXML
    private TableColumn<MemurEgitim, String> MemurOgretmenAlanTablo;

    @FXML
    private TableColumn<MemurEgitim, String> MemurEgitimAdTablo;

    @FXML
    private TableColumn<MemurEgitim, String> MemurEgitimSaatTablo;

    @FXML
    private TableColumn<MemurEgitim, String> MemurEgitimTuruTablo;

    @FXML
    private TextField MemurOgretmenAd;

    @FXML
    private TextField MemurOgretmenAlan;

    @FXML
    private TextField MemurEgitimAd;

    @FXML
    private TextField MemurHaftalikSaat;

    @FXML
    private TextField MemurEgitimTuru;
    
    @FXML
    private Label MemurEgitimLabel;

    MemurEgitim mmregtm = new MemurEgitim();
    DosyaIslemleri ds = new DosyaIslemleri();
    ObservableList<MemurEgitim> listele = FXCollections.observableArrayList();

    @FXML
    void Ekle(ActionEvent event) throws IOException {
        mmregtm.setOgretmenAd(MemurOgretmenAd.getText().toString());
        mmregtm.setOgretmenAlan(MemurOgretmenAlan.getText().toString());
        mmregtm.setEgitimAd(MemurEgitimAd.getText().toString());
        mmregtm.setHaftalikEgitimSaat(MemurHaftalikSaat.getText().toString());
        mmregtm.setEgitimTuru(MemurEgitimTuru.getText().toString());
        ds.MemurEgitimEkle(mmregtm.getOgretmenAd(), mmregtm.getOgretmenAlan(), mmregtm.getEgitimAd(), mmregtm.getHaftalikEgitimSaat(), mmregtm.getEgitimTuru());
        
        MemurEgitimLabel.setText(mmregtm.mesaj());
    }

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("SivilPersonelEgitimSecim.fxml"));
        MemurEgitimPane.getChildren().setAll(pane);
    }

    @FXML
    void Yenile(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("MemurEgitim.fxml"));
        MemurEgitimPane.getChildren().setAll(pane);
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File mmregtm = new File("MemurEgitim.txt");
        if (!mmregtm.exists()) {
            try {
                mmregtm.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(mmregtm);
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
                    listele.add(new MemurEgitim(OgretmenAd, OgretmenAlan, EgitimAd, HaftalikEgitimSaat, EgitimTuru));
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
        MemurEgitimTablo.setItems(listele);
        MemurOgretmenAdTablo.setCellValueFactory(new PropertyValueFactory<MemurEgitim, String>("OgretmenAd"));
        MemurOgretmenAlanTablo.setCellValueFactory(new PropertyValueFactory<MemurEgitim, String>("OgretmenAlan"));
        MemurEgitimAdTablo.setCellValueFactory(new PropertyValueFactory<MemurEgitim, String>("EgitimAd"));
        MemurEgitimSaatTablo.setCellValueFactory(new PropertyValueFactory<MemurEgitim, String>("HaftalikEgitimSaat"));
        MemurEgitimTuruTablo.setCellValueFactory(new PropertyValueFactory<MemurEgitim, String>("EgitimTuru"));
    }

}
