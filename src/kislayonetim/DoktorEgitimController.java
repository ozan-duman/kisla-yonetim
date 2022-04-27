package kislayonetim;

import dosyaIslemleri.DosyaIslemleri;
import egitim.DoktorEgitim;
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

public class DoktorEgitimController implements Initializable {

    @FXML
    private AnchorPane DoktorEgitimPane;

    @FXML
    private TableView<DoktorEgitim> DoktorEgitimTablo;

    @FXML
    private TableColumn<DoktorEgitim, String> DoktorOgretmenAdTablo;

    @FXML
    private TableColumn<DoktorEgitim, String> DoktorOgretmenAlanTablo;

    @FXML
    private TableColumn<DoktorEgitim, String> DoktorEgitimAdTablo;

    @FXML
    private TableColumn<DoktorEgitim, String> DoktorEgitimSaatTablo;

    @FXML
    private TableColumn<DoktorEgitim, String> DoktorEgitimTuruTablo;

    @FXML
    private TextField DoktorOgretmenAd;

    @FXML
    private TextField DoktorOgretmenAlan;

    @FXML
    private TextField DoktorEgitimAd;

    @FXML
    private TextField DoktorHaftalikSaat;

    @FXML
    private TextField DoktorEgitimTuru;
    
    @FXML
    private Label DoktorEgitimLabel;

    DoktorEgitim dregtm = new DoktorEgitim();
    DosyaIslemleri ds = new DosyaIslemleri();
    ObservableList<DoktorEgitim> listele = FXCollections.observableArrayList();

    @FXML
    void Ekle(ActionEvent event) throws IOException {
        dregtm.setOgretmenAd(DoktorOgretmenAd.getText().toString());
        dregtm.setOgretmenAlan(DoktorOgretmenAlan.getText().toString());
        dregtm.setEgitimAd(DoktorEgitimAd.getText().toString());
        dregtm.setHaftalikEgitimSaat(DoktorHaftalikSaat.getText().toString());
        dregtm.setEgitimTuru(DoktorEgitimTuru.getText().toString());
        ds.DoktorEgitimEkle(dregtm.getOgretmenAd(), dregtm.getOgretmenAlan(), dregtm.getEgitimAd(), dregtm.getHaftalikEgitimSaat(), dregtm.getEgitimTuru());
        
        DoktorEgitimLabel.setText(dregtm.mesaj());
    }

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("SivilPersonelEgitimSecim.fxml"));
        DoktorEgitimPane.getChildren().setAll(pane);
    }

    @FXML
    void Yenile(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("DoktorEgitim.fxml"));
        DoktorEgitimPane.getChildren().setAll(pane);
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File dregtm = new File("DoktorEgitim.txt");
        if (!dregtm.exists()) {
            try {
                dregtm.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(dregtm);
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
                    listele.add(new DoktorEgitim(OgretmenAd, OgretmenAlan, EgitimAd, HaftalikEgitimSaat, EgitimTuru));
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
        DoktorEgitimTablo.setItems(listele);
        DoktorOgretmenAdTablo.setCellValueFactory(new PropertyValueFactory<DoktorEgitim, String>("OgretmenAd"));
        DoktorOgretmenAlanTablo.setCellValueFactory(new PropertyValueFactory<DoktorEgitim, String>("OgretmenAlan"));
        DoktorEgitimAdTablo.setCellValueFactory(new PropertyValueFactory<DoktorEgitim, String>("EgitimAd"));
        DoktorEgitimSaatTablo.setCellValueFactory(new PropertyValueFactory<DoktorEgitim, String>("HaftalikEgitimSaat"));
        DoktorEgitimTuruTablo.setCellValueFactory(new PropertyValueFactory<DoktorEgitim, String>("EgitimTuru"));
    }

}
