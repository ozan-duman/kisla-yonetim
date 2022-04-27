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
import personel.Subay;

public class SubayController implements Initializable {

    @FXML
    private AnchorPane SubayPane;

    @FXML
    private TableView<Subay> SubayTablo;

    @FXML
    private TableColumn<Subay, String> SubayAdTablo;

    @FXML
    private TableColumn<Subay, String> SubaySoyadTablo;

    @FXML
    private TableColumn<Subay, String> SubayDogumYeriTablo;

    @FXML
    private TableColumn<Subay, String> SubayDogumTarihiTablo;

    @FXML
    private TableColumn<Subay, String> SubayRutbeTablo;

    @FXML
    private TableColumn<Subay, String> SubayKayitTarihTablo;

    @FXML
    private TextField SubayAd;

    @FXML
    private TextField SubaySoyad;

    @FXML
    private TextField SubayDogumYeri;

    @FXML
    private TextField SubayDogumTarihi;

    @FXML
    private TextField SubayRutbe;

    @FXML
    private TextField SubayTarih;

    @FXML
    private Label SubayLabel;

    Subay sby = new Subay();
    DosyaIslemleri ds = new DosyaIslemleri();
    ObservableList<Subay> listele = FXCollections.observableArrayList();

    @FXML
    void Ekle(ActionEvent event) throws IOException {
        sby.setAd(SubayAd.getText().toString());
        sby.setSoyad(SubaySoyad.getText().toString());
        sby.setDogumYeri(SubayDogumYeri.getText().toString());
        sby.setDogumTarihi(SubayDogumTarihi.getText().toString());
        sby.setRutbe(SubayRutbe.getText().toString());
        sby.setKayitTarihi(SubayTarih.getText().toString());
        ds.SubayEkle(sby.getAd(), sby.getSoyad(), sby.getDogumYeri(), sby.getDogumTarihi(), sby.getRutbe(), sby.getKayitTarihi());
        
        SubayLabel.setText(sby.mesaj());
    }

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("AskeriPersonelSecim.fxml"));
        SubayPane.getChildren().setAll(pane);
    }

    @FXML
    void Yenile(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Subay.fxml"));
        SubayPane.getChildren().setAll(pane);
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File sby = new File("Subay.txt");
        if (!sby.exists()) {
            try {
                sby.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(sby);
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
                    listele.add(new Subay(Ad, Soyad, DogumYeri, DogumTarihi, Rutbe, KayitTarihi));
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
        SubayTablo.setItems(listele);
        SubayAdTablo.setCellValueFactory(new PropertyValueFactory<Subay, String>("Ad"));
        SubaySoyadTablo.setCellValueFactory(new PropertyValueFactory<Subay, String>("Soyad"));
        SubayDogumYeriTablo.setCellValueFactory(new PropertyValueFactory<Subay, String>("DogumYeri"));
        SubayDogumTarihiTablo.setCellValueFactory(new PropertyValueFactory<Subay, String>("DogumTarihi"));
        SubayRutbeTablo.setCellValueFactory(new PropertyValueFactory<Subay, String>("Rutbe"));
        SubayKayitTarihTablo.setCellValueFactory(new PropertyValueFactory<Subay, String>("KayitTarihi"));
    }

}
