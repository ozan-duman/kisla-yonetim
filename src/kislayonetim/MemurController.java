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
import personel.Memur;

public class MemurController implements Initializable {

    @FXML
    private AnchorPane MemurPane;

    @FXML
    private TableView<Memur> MemurTablo;

    @FXML
    private TableColumn<Memur, String> MemurTabloAd;

    @FXML
    private TableColumn<Memur, String> MemurTabloSoyad;

    @FXML
    private TableColumn<Memur, String> MemurDogumYeriTablo;

    @FXML
    private TableColumn<Memur, String> MemurDogumTarihiTablo;

    @FXML
    private TableColumn<Memur, String> MemurKayitTarihiTablo;

    @FXML
    private TextField MemurAd;

    @FXML
    private TextField MemurSoyad;

    @FXML
    private TextField MemurDogumYeri;

    @FXML
    private TextField MemurDogumTarihi;

    @FXML
    private TextField MemurTarih;

    @FXML
    private Label MemurLabel;

    Memur memur = new Memur();
    DosyaIslemleri ds = new DosyaIslemleri();
    ObservableList<Memur> listele = FXCollections.observableArrayList();

    @FXML
    void Ekle(ActionEvent event) throws IOException {
        memur.setAd(MemurAd.getText().toString());
        memur.setSoyad(MemurSoyad.getText().toString());
        memur.setDogumYeri(MemurDogumYeri.getText().toString());
        memur.setDogumTarihi(MemurDogumTarihi.getText().toString());
        memur.setKayitTarihi(MemurTarih.getText().toString());
        ds.MemurEkle(memur.getAd(), memur.getSoyad(), memur.getDogumYeri(), memur.getDogumTarihi(), memur.getKayitTarihi());
        
        MemurLabel.setText(memur.mesaj());
    }

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("SivilPersonelSecim.fxml"));
        MemurPane.getChildren().setAll(pane);
    }

    @FXML
    void Yenile(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Memur.fxml"));
        MemurPane.getChildren().setAll(pane);
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File memur = new File("Memur.txt");
        if (!memur.exists()) {
            try {
                memur.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(memur);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String line;

        BufferedReader br = new BufferedReader(fileReader);
        int i = 0;

        try {
            byte ax = 0;
            String Ad = "", Soyad = "", DogumYeri = "", DogumTarihi = "", KayitTarihi = "";
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
                    KayitTarihi = line;
                } else if (ax == 6) {
                    listele.add(new Memur(Ad, Soyad, DogumYeri, DogumTarihi, KayitTarihi));
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
        MemurTablo.setItems(listele);
        MemurTabloAd.setCellValueFactory(new PropertyValueFactory<Memur, String>("Ad"));
        MemurTabloSoyad.setCellValueFactory(new PropertyValueFactory<Memur, String>("Soyad"));
        MemurDogumYeriTablo.setCellValueFactory(new PropertyValueFactory<Memur, String>("DogumYeri"));
        MemurDogumTarihiTablo.setCellValueFactory(new PropertyValueFactory<Memur, String>("DogumTarihi"));
        MemurKayitTarihiTablo.setCellValueFactory(new PropertyValueFactory<Memur, String>("KayitTarihi"));
    }

}
