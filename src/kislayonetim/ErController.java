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
import personel.Er;

public class ErController implements Initializable {

    @FXML
    private AnchorPane ErPane;

    @FXML
    private TableView<Er> ErTablo;

    @FXML
    private TableColumn<Er, String> ErAdTablo;

    @FXML
    private TableColumn<Er, String> ErSoyadTablo;

    @FXML
    private TableColumn<Er, String> ErDogumYeriTablo;

    @FXML
    private TableColumn<Er, String> ErDogumTarihiTablo;

    @FXML
    private TableColumn<Er, String> ErRutbeTablo;

    @FXML
    private TableColumn<Er, String> ErKayitTarihTablo;

    @FXML
    private TextField ErAd;

    @FXML
    private TextField ErSoyad;

    @FXML
    private TextField ErDogumYeri;

    @FXML
    private TextField ErDogumTarihi;

    @FXML
    private TextField ErRutbe;

    @FXML
    private TextField ErTarih;
    
    @FXML
    private Label ErLabel;
    
    Er er = new Er();
    DosyaIslemleri ds = new DosyaIslemleri();
    ObservableList<Er> listele = FXCollections.observableArrayList();

    @FXML
    void Ekle(ActionEvent event) throws IOException {
        er.setAd(ErAd.getText().toString());
        er.setSoyad(ErSoyad.getText().toString());
        er.setDogumYeri(ErDogumYeri.getText().toString());
        er.setDogumTarihi(ErDogumTarihi.getText().toString());
        er.setRutbe(ErRutbe.getText().toString());
        er.setKayitTarihi(ErTarih.getText().toString());
        ds.ErEkle(er.getAd(), er.getSoyad(), er.getDogumYeri(), er.getDogumTarihi(), er.getRutbe(), er.getKayitTarihi());
        
        ErLabel.setText(er.mesaj());
    }

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("AskeriPersonelSecim.fxml"));
        ErPane.getChildren().setAll(pane);
    }

    @FXML
    void Yenile(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Er.fxml"));
        ErPane.getChildren().setAll(pane);
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File er = new File("Er.txt");
        if (!er.exists()) {
            try {
                er.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(er);
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
                    listele.add(new Er(Ad, Soyad, DogumYeri, DogumTarihi, Rutbe, KayitTarihi));
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
        ErTablo.setItems(listele);
        ErAdTablo.setCellValueFactory(new PropertyValueFactory<Er, String>("Ad"));
        ErSoyadTablo.setCellValueFactory(new PropertyValueFactory<Er, String>("Soyad"));
        ErDogumYeriTablo.setCellValueFactory(new PropertyValueFactory<Er, String>("DogumYeri"));
        ErDogumTarihiTablo.setCellValueFactory(new PropertyValueFactory<Er, String>("DogumTarihi"));
        ErRutbeTablo.setCellValueFactory(new PropertyValueFactory<Er, String>("Rutbe"));
        ErKayitTarihTablo.setCellValueFactory(new PropertyValueFactory<Er, String>("KayitTarihi"));
    }

}
