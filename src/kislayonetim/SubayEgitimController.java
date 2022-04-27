package kislayonetim;

import dosyaIslemleri.DosyaIslemleri;
import egitim.SubayEgitim;
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

public class SubayEgitimController implements Initializable {

    @FXML
    private AnchorPane SubayEgitimPane;

    @FXML
    private TableView<SubayEgitim> SubayEgitimTablo;

    @FXML
    private TableColumn<SubayEgitim, String> EgitimAdTablo;

    @FXML
    private TableColumn<SubayEgitim, String> EgitimSaatTablo;

    @FXML
    private TableColumn<SubayEgitim, String> EgitimTuruTablo;

    @FXML
    private TableColumn<SubayEgitim, String> KomutanAdTablo;

    @FXML
    private TableColumn<SubayEgitim, String> AskerNumaraTablo;

    @FXML
    private TextField EgitimAd;

    @FXML
    private TextField EgitimSaat;

    @FXML
    private TextField EgitimTur;

    @FXML
    private TextField KomutanAd;

    @FXML
    private TextField AskerNumara;
    
    @FXML
    private Label SubayEgitimLabel;

    SubayEgitim sbyegtm = new SubayEgitim();
    DosyaIslemleri ds = new DosyaIslemleri();
    ObservableList<SubayEgitim> listele = FXCollections.observableArrayList();

    @FXML
    void Ekle(ActionEvent event) throws IOException {
        sbyegtm.setEgitimAd(EgitimAd.getText().toString());
        sbyegtm.setHaftalikEgitimSaat(EgitimSaat.getText().toString());
        sbyegtm.setEgitimTuru(EgitimTur.getText().toString());
        sbyegtm.setEgitimciKomutanAd(KomutanAd.getText().toString());
        sbyegtm.setEgitilenAskerNumara(AskerNumara.getText().toString());
        ds.SubayEgitimEkle(sbyegtm.getEgitimAd(), sbyegtm.getHaftalikEgitimSaat(), sbyegtm.getEgitimTuru(), sbyegtm.getEgitimciKomutanAd(), sbyegtm.getEgitilenAskerNumara());
        
        SubayEgitimLabel.setText(sbyegtm.mesaj());
    }

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("AskeriPersonelEgitimSecim.fxml"));
        SubayEgitimPane.getChildren().setAll(pane);
    }

    @FXML
    void Yenile(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("SubayEgitim.fxml"));
        SubayEgitimPane.getChildren().setAll(pane);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File sbyegtm = new File("SubayEgitim.txt");
        if (!sbyegtm.exists()) {
            try {
                sbyegtm.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(sbyegtm);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String line;

        BufferedReader br = new BufferedReader(fileReader);
        int i = 0;

        try {
            byte ax = 0;
            String EgitimAd = "", HaftalikEgitimSaat = "", EgitimTuru = "", EgitimciKomutanAd = "", EgitilenAskerNumara = "";
            while ((line = br.readLine()) != null) {
                ax++;
                if (ax == 1) {
                    EgitimAd = line;
                } else if (ax == 2) {
                    HaftalikEgitimSaat = line;
                } else if (ax == 3) {
                    EgitimTuru = line;
                } else if (ax == 4) {
                    EgitimciKomutanAd = line;
                } else if (ax == 5) {
                    EgitilenAskerNumara = line;
                } else if (ax == 6) {
                    listele.add(new SubayEgitim(EgitimAd, HaftalikEgitimSaat, EgitimTuru, EgitimciKomutanAd, EgitilenAskerNumara));
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
        SubayEgitimTablo.setItems(listele);
        EgitimAdTablo.setCellValueFactory(new PropertyValueFactory<SubayEgitim, String>("EgitimAd"));
        EgitimSaatTablo.setCellValueFactory(new PropertyValueFactory<SubayEgitim, String>("HaftalikEgitimSaat"));
        EgitimTuruTablo.setCellValueFactory(new PropertyValueFactory<SubayEgitim, String>("EgitimTuru"));
        KomutanAdTablo.setCellValueFactory(new PropertyValueFactory<SubayEgitim, String>("EgitimciKomutanAd"));
        AskerNumaraTablo.setCellValueFactory(new PropertyValueFactory<SubayEgitim, String>("EgitilenAskerNumara"));
    }

}
