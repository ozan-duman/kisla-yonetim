package kislayonetim;

import dosyaIslemleri.DosyaIslemleri;
import egitim.AstsubayEgitim;
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

public class AstsubayEgitimController implements Initializable {

    @FXML
    private AnchorPane AstsubayEgitimPane;

    @FXML
    private TableView<AstsubayEgitim> AstsubayEgitimTablo;

    @FXML
    private TableColumn<AstsubayEgitim, String> AstEgitimAdTablo;

    @FXML
    private TableColumn<AstsubayEgitim, String> AstEgitimSaatTablo;

    @FXML
    private TableColumn<AstsubayEgitim, String> AstEgitimTuruTablo;

    @FXML
    private TableColumn<AstsubayEgitim, String> AstKomutanAdTablo;

    @FXML
    private TableColumn<AstsubayEgitim, String> AstAskerNumaraTablo;

    @FXML
    private TextField AstEgitimAd;

    @FXML
    private TextField AstEgitimSaat;

    @FXML
    private TextField AstEgitimTur;

    @FXML
    private TextField AstKomutanAd;

    @FXML
    private TextField AstAskerNumara;

    @FXML
    private Label AstsubayEgitimLabel;

    AstsubayEgitim astegtm = new AstsubayEgitim();
    DosyaIslemleri ds = new DosyaIslemleri();
    ObservableList<AstsubayEgitim> listele = FXCollections.observableArrayList();

    @FXML
    void Ekle(ActionEvent event) throws IOException {
        astegtm.setEgitimAd(AstEgitimAd.getText().toString());
        astegtm.setHaftalikEgitimSaat(AstEgitimSaat.getText().toString());
        astegtm.setEgitimTuru(AstEgitimTur.getText().toString());
        astegtm.setEgitimciKomutanAd(AstKomutanAd.getText().toString());
        astegtm.setEgitilenAskerNumara(AstAskerNumara.getText().toString());
        ds.AstsubayEgitimEkle(astegtm.getEgitimAd(), astegtm.getHaftalikEgitimSaat(), astegtm.getEgitimTuru(), astegtm.getEgitimciKomutanAd(), astegtm.getEgitilenAskerNumara());
        
        AstsubayEgitimLabel.setText(astegtm.mesaj());
    }

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("AskeriPersonelEgitimSecim.fxml"));
        AstsubayEgitimPane.getChildren().setAll(pane);
    }

    @FXML
    void Yenile(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("AstsubayEgitim.fxml"));
        AstsubayEgitimPane.getChildren().setAll(pane);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File astegtm = new File("AstsubayEgitim.txt");
        if (!astegtm.exists()) {
            try {
                astegtm.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(astegtm);
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
                    listele.add(new AstsubayEgitim(EgitimAd, HaftalikEgitimSaat, EgitimTuru, EgitimciKomutanAd, EgitilenAskerNumara));
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
        AstsubayEgitimTablo.setItems(listele);
        AstEgitimAdTablo.setCellValueFactory(new PropertyValueFactory<AstsubayEgitim, String>("EgitimAd"));
        AstEgitimSaatTablo.setCellValueFactory(new PropertyValueFactory<AstsubayEgitim, String>("HaftalikEgitimSaat"));
        AstEgitimTuruTablo.setCellValueFactory(new PropertyValueFactory<AstsubayEgitim, String>("EgitimTuru"));
        AstKomutanAdTablo.setCellValueFactory(new PropertyValueFactory<AstsubayEgitim, String>("EgitimciKomutanAd"));
        AstAskerNumaraTablo.setCellValueFactory(new PropertyValueFactory<AstsubayEgitim, String>("EgitilenAskerNumara"));

    }

}
