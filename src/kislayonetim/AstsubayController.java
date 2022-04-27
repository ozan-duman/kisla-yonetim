package kislayonetim;

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
import personel.Astsubay;
import personel.Personel;

public class AstsubayController implements Initializable {

    @FXML
    private Label AstsubayLabel;

    @FXML
    private AnchorPane AstsubayPane;

    @FXML
    private TableView<Astsubay> AstsubayTablo;

    @FXML
    private TableColumn<Astsubay, String> AstsubayAdTablo;

    @FXML
    private TableColumn<Astsubay, String> AstsubaySoyadTablo;

    @FXML
    private TableColumn<Astsubay, String> AstsubayDogumYeriTablo;

    @FXML
    private TableColumn<Astsubay, String> AstsubayDogumTarihiTablo;

    @FXML
    private TableColumn<Astsubay, String> AstsubayRutbeTablo;

    @FXML
    private TableColumn<Astsubay, String> AstsubayKayitTarihTablo;

    @FXML
    private TextField AstsubayAd;

    @FXML
    private TextField AstsubaySoyad;

    @FXML
    private TextField AstsubayDogumYeri;

    @FXML
    private TextField AstsubayDogumTarihi;

    @FXML
    private TextField AstsubayRutbe;

    @FXML
    private TextField AstsubayTarih;


    Astsubay astsby = new Astsubay();
    Personel per = new Personel();
    DosyaIslemleri ds = new DosyaIslemleri();
    ObservableList<Astsubay> listele = FXCollections.observableArrayList();

    @FXML
    void Ekle(ActionEvent event) throws IOException {
        astsby.setAd(AstsubayAd.getText().toString());
        astsby.setSoyad(AstsubaySoyad.getText().toString());
        astsby.setDogumYeri(AstsubayDogumYeri.getText().toString());
        astsby.setDogumTarihi(AstsubayDogumTarihi.getText().toString());
        astsby.setRutbe(AstsubayRutbe.getText().toString());
        astsby.setKayitTarihi(AstsubayTarih.getText().toString());
        ds.AstsubayEkle(astsby.getAd(), astsby.getSoyad(), astsby.getDogumYeri(), astsby.getDogumTarihi(), astsby.getRutbe(), astsby.getKayitTarihi());

        AstsubayLabel.setText(astsby.mesaj());

    }

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("AskeriPersonelSecim.fxml"));
        AstsubayPane.getChildren().setAll(pane);
    }

    @FXML
    void Yenile(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Astsubay.fxml"));
        AstsubayPane.getChildren().setAll(pane);
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File astsby = new File("Astsubay.txt");
        if (!astsby.exists()) {
            try {
                astsby.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(astsby);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String line;

        BufferedReader br = new BufferedReader(fileReader);
        int i = 0;

        try {
            byte ax = 0;

            String Ad = "", Soyad = "", DogumYeri = "", DogumTarihi = "", Rutbe = "", KayitTarihi = "";
            while ((line = br.readLine()) != null) {
                ax++;
                if (ax == 1) {
                    Ad = line;
                } else if (ax == 2) {
                    Soyad = line;
                } else if (ax == 3) {
                    DogumYeri = line;
                } else if (ax == 4) {
                    DogumTarihi = line;
                } else if (ax == 5) {
                    Rutbe = line;
                } else if (ax == 6) {
                    KayitTarihi = line;
                } else if (ax == 7) {
                    listele.add(new Astsubay(Ad, Soyad, DogumYeri, DogumTarihi, Rutbe, KayitTarihi));
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
        AstsubayTablo.setItems(listele);
        AstsubayAdTablo.setCellValueFactory(new PropertyValueFactory<Astsubay, String>("Ad"));
        AstsubaySoyadTablo.setCellValueFactory(new PropertyValueFactory<Astsubay, String>("Soyad"));
        AstsubayDogumYeriTablo.setCellValueFactory(new PropertyValueFactory<Astsubay, String>("DogumYeri"));
        AstsubayDogumTarihiTablo.setCellValueFactory(new PropertyValueFactory<Astsubay, String>("DogumTarihi"));
        AstsubayRutbeTablo.setCellValueFactory(new PropertyValueFactory<Astsubay, String>("Rutbe"));
        AstsubayKayitTarihTablo.setCellValueFactory(new PropertyValueFactory<Astsubay, String>("KayitTarihi"));

    }

}
