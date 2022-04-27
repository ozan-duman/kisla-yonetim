package kislayonetim;

import araclar.AskeriArac;
import araclar.SivilArac;
import dosyaIslemleri.DosyaIslemleri;
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

public class SivilAracController implements Initializable {

    @FXML
    private AnchorPane SivilAracPane;

    @FXML
    private TableView<SivilArac> SivilAracTablo;

    @FXML
    private TableColumn<SivilArac, String> SivilAracAdTablo;

    @FXML
    private TableColumn<SivilArac, String> SivilAracHizTablo;

    @FXML
    private TableColumn<SivilArac, String> SivilAracAgirlikTablo;

    @FXML
    private TableColumn<SivilArac, String> SivilAracMotorHacimTablo;

    @FXML
    private TableColumn<SivilArac, String> SivilAracTekerSayisiTablo;

    @FXML
    private TextField SivilAracAd;

    @FXML
    private TextField SivilAracHiz;

    @FXML
    private TextField SivilAracAgirlik;

    @FXML
    private TextField SivilAracMotorHacim;

    @FXML
    private TextField SivilAracTekerlekSayisi;

    @FXML
    private Label SivilAracLabel;

    SivilArac svlarc = new SivilArac();
    DosyaIslemleri ds = new DosyaIslemleri();
    ObservableList<SivilArac> listele = FXCollections.observableArrayList();

    @FXML
    void Ekle(ActionEvent event) throws IOException {
        svlarc.setAd(SivilAracAd.getText().toString());
        svlarc.setHiz(SivilAracHiz.getText().toString());
        svlarc.setAgirlik(SivilAracAgirlik.getText().toString());
        svlarc.setMotorHacim(SivilAracMotorHacim.getText().toString());
        svlarc.setTekerSayisi(SivilAracTekerlekSayisi.getText().toString());
        ds.SivilAracAracEkle(svlarc.getAd(), svlarc.getHiz(), svlarc.getAgirlik(), svlarc.getMotorHacim(), svlarc.getTekerSayisi());
        
        SivilAracLabel.setText(svlarc.mesaj());
    }

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("TekerlekliAracSecim.fxml"));
        SivilAracPane.getChildren().setAll(pane);
    }

    @FXML
    void Yenile(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("SivilArac.fxml"));
        SivilAracPane.getChildren().setAll(pane);
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File svlarc = new File("SivilArac.txt");
        if (!svlarc.exists()) {
            try {
                svlarc.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(svlarc);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String line;

        BufferedReader br = new BufferedReader(fileReader);
        int i = 0;

        try {
            byte ax = 0;
            String Ad = "", Hiz = "", Agirlik = "", MotorHacim = "", TekerSayisi = "";
            while ((line = br.readLine()) != null) {
                ax++;
                if (ax == 1) {
                    Ad = line;
                } else if (ax == 2) {
                    Hiz = line;
                } else if (ax == 3) {
                    Agirlik = line;
                } else if (ax == 4) {
                    MotorHacim = line;
                } else if (ax == 5) {
                    TekerSayisi = line;
                } else if (ax == 6) {
                    listele.add(new SivilArac(Ad, Hiz, Agirlik, MotorHacim, TekerSayisi));
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
        SivilAracTablo.setItems(listele);
        SivilAracAdTablo.setCellValueFactory(new PropertyValueFactory<SivilArac, String>("Ad"));
        SivilAracHizTablo.setCellValueFactory(new PropertyValueFactory<SivilArac, String>("Hiz"));
        SivilAracAgirlikTablo.setCellValueFactory(new PropertyValueFactory<SivilArac, String>("Agirlik"));
        SivilAracMotorHacimTablo.setCellValueFactory(new PropertyValueFactory<SivilArac, String>("MotorHacim"));
        SivilAracTekerSayisiTablo.setCellValueFactory(new PropertyValueFactory<SivilArac, String>("TekerSayisi"));

    }

}
