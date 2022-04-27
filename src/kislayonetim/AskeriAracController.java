package kislayonetim;

import araclar.AskeriArac;
import araclar.Tanklar;
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

public class AskeriAracController implements Initializable {

    @FXML
    private AnchorPane AskeriAracPane;

    @FXML
    private TableView<AskeriArac> AskeriAracTablo;

    @FXML
    private TableColumn<AskeriArac, String> AskeriAracAdTablo;

    @FXML
    private TableColumn<AskeriArac, String> AskeriAracHizTablo;

    @FXML
    private TableColumn<AskeriArac, String> AskeriAracAgirlikTablo;

    @FXML
    private TableColumn<AskeriArac, String> AskeriAracMotorHacimTablo;

    @FXML
    private TableColumn<AskeriArac, String> AskeriAracTekerSayisiTablo;

    @FXML
    private TextField AskeriAracAd;

    @FXML
    private TextField AskeriAracHiz;

    @FXML
    private TextField AskeriAracAgirlik;

    @FXML
    private TextField AskeriAracMotorHacim;

    @FXML
    private TextField AskeriAracTekerlekSayisi;

    @FXML
    private Label AskeriAracLabel;

    AskeriArac askrarc = new AskeriArac();
    DosyaIslemleri ds = new DosyaIslemleri();
    ObservableList<AskeriArac> listele = FXCollections.observableArrayList();

    @FXML
    void Ekle(ActionEvent event) throws IOException {
        askrarc.setAd(AskeriAracAd.getText().toString());
        askrarc.setHiz(AskeriAracHiz.getText().toString());
        askrarc.setAgirlik(AskeriAracAgirlik.getText().toString());
        askrarc.setMotorHacim(AskeriAracMotorHacim.getText().toString());
        askrarc.setTekerSayisi(AskeriAracTekerlekSayisi.getText().toString());
        ds.AskeriAracEkle(askrarc.getAd(), askrarc.getHiz(), askrarc.getAgirlik(), askrarc.getMotorHacim(), askrarc.getTekerSayisi());
        
        AskeriAracLabel.setText(askrarc.mesaj());
    }

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("TekerlekliAracSecim.fxml"));
        AskeriAracPane.getChildren().setAll(pane);
    }

    @FXML
    void Yenile(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("AskeriArac.fxml"));
        AskeriAracPane.getChildren().setAll(pane);
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File askrarc = new File("AskeriArac.txt");
        if (!askrarc.exists()) {
            try {
                askrarc.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(askrarc);
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
                    listele.add(new AskeriArac(Ad, Hiz, Agirlik, MotorHacim, TekerSayisi));
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
        AskeriAracTablo.setItems(listele);
        AskeriAracAdTablo.setCellValueFactory(new PropertyValueFactory<AskeriArac, String>("Ad"));
        AskeriAracHizTablo.setCellValueFactory(new PropertyValueFactory<AskeriArac, String>("Hiz"));
        AskeriAracAgirlikTablo.setCellValueFactory(new PropertyValueFactory<AskeriArac, String>("Agirlik"));
        AskeriAracMotorHacimTablo.setCellValueFactory(new PropertyValueFactory<AskeriArac, String>("MotorHacim"));
        AskeriAracTekerSayisiTablo.setCellValueFactory(new PropertyValueFactory<AskeriArac, String>("TekerSayisi"));

    }

}
