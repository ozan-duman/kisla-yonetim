package kislayonetim;

import dosyaIslemleri.DosyaIslemleri;
import egitim.ErEgitim;
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

public class ErEgitimController implements Initializable {

    @FXML
    private AnchorPane ErEgitimPane;

    @FXML
    private TableView<ErEgitim> ErEgitimTablo;

    @FXML
    private TableColumn<ErEgitim, String> ErEgitimAdTablo;

    @FXML
    private TableColumn<ErEgitim, String> ErEgitimSaatTablo;

    @FXML
    private TableColumn<ErEgitim, String> ErEgitimTuruTablo;

    @FXML
    private TableColumn<ErEgitim, String> ErKomutanAdTablo;

    @FXML
    private TableColumn<ErEgitim, String> ErAskerNumaraTablo;

    @FXML
    private TextField ErEgitimAd;

    @FXML
    private TextField ErEgitimSaat;

    @FXML
    private TextField ErEgitimTur;

    @FXML
    private TextField ErKomutanAd;

    @FXML
    private TextField ErAskerNumara;
    
    @FXML
    private Label ErEgitimLabel;

    ErEgitim eregtm = new ErEgitim();
    DosyaIslemleri ds = new DosyaIslemleri();
    ObservableList<ErEgitim> listele = FXCollections.observableArrayList();

    @FXML
    void Ekle(ActionEvent event) throws IOException {
        eregtm.setEgitimAd(ErEgitimAd.getText().toString());
        eregtm.setHaftalikEgitimSaat(ErEgitimSaat.getText().toString());
        eregtm.setEgitimTuru(ErEgitimTur.getText().toString());
        eregtm.setEgitimciKomutanAd(ErKomutanAd.getText().toString());
        eregtm.setEgitilenAskerNumara(ErAskerNumara.getText().toString());
        ds.ErEgitimEkle(eregtm.getEgitimAd(), eregtm.getHaftalikEgitimSaat(), eregtm.getEgitimTuru(), eregtm.getEgitimciKomutanAd(), eregtm.getEgitilenAskerNumara());
        
        ErEgitimLabel.setText(eregtm.mesaj());
    }

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("AskeriPersonelEgitimSecim.fxml"));
        ErEgitimPane.getChildren().setAll(pane);
    }

    @FXML
    void Yenile(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("ErEgitim.fxml"));
        ErEgitimPane.getChildren().setAll(pane);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File eregtm = new File("ErEgitim.txt");
        if (!eregtm.exists()) {
            try {
                eregtm.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(eregtm);
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
                    listele.add(new ErEgitim(EgitimAd, HaftalikEgitimSaat, EgitimTuru, EgitimciKomutanAd, EgitilenAskerNumara));
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
        ErEgitimTablo.setItems(listele);
        ErEgitimAdTablo.setCellValueFactory(new PropertyValueFactory<ErEgitim, String>("EgitimAd"));
        ErEgitimSaatTablo.setCellValueFactory(new PropertyValueFactory<ErEgitim, String>("HaftalikEgitimSaat"));
        ErEgitimTuruTablo.setCellValueFactory(new PropertyValueFactory<ErEgitim, String>("EgitimTuru"));
        ErKomutanAdTablo.setCellValueFactory(new PropertyValueFactory<ErEgitim, String>("EgitimciKomutanAd"));
        ErAskerNumaraTablo.setCellValueFactory(new PropertyValueFactory<ErEgitim, String>("EgitilenAskerNumara"));

    }

}
