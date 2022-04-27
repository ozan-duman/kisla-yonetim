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
import personel.Doktor;

public class DoktorController implements Initializable {

    @FXML
    private AnchorPane DoktorPane;

    @FXML
    private TableView<Doktor> DoktorTablo;

    @FXML
    private TableColumn<Doktor, String> DoktorTabloAd;

    @FXML
    private TableColumn<Doktor, String> DoktorTabloSoyad;

    @FXML
    private TableColumn<Doktor, String> DoktorDogumYeriTablo;

    @FXML
    private TableColumn<Doktor, String> DoktorDogumTarihiTablo;

    @FXML
    private TableColumn<Doktor, String> DoktorKayitTarihiTablo;

    @FXML
    private TextField DoktorAd;

    @FXML
    private TextField DoktorSoyad;

    @FXML
    private TextField DoktorDogumYeri;

    @FXML
    private TextField DoktorDogumTarihi;

    @FXML
    private TextField DoktorTarih;
    
    @FXML
    private Label DoktorLabel;

    Doktor dr = new Doktor();
    DosyaIslemleri ds = new DosyaIslemleri();
    ObservableList<Doktor> listele = FXCollections.observableArrayList();

    @FXML
    void Ekle(ActionEvent event) throws IOException {
        dr.setAd(DoktorAd.getText().toString());
        dr.setSoyad(DoktorSoyad.getText().toString());
        dr.setDogumYeri(DoktorDogumYeri.getText().toString());
        dr.setDogumTarihi(DoktorDogumTarihi.getText().toString());
        dr.setKayitTarihi(DoktorTarih.getText().toString());
        ds.DoktorEkle(dr.getAd(), dr.getSoyad(), dr.getDogumYeri(), dr.getDogumTarihi(), dr.getKayitTarihi());
        
        DoktorLabel.setText(dr.mesaj());
    }

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("SivilPersonelSecim.fxml"));
        DoktorPane.getChildren().setAll(pane);
    }

    @FXML
    void Yenile(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Doktor.fxml"));
        DoktorPane.getChildren().setAll(pane);
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File dr = new File("Doktor.txt");
        if (!dr.exists()) {
            try {
                dr.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(dr);
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
                    listele.add(new Doktor(Ad, Soyad, DogumYeri, DogumTarihi, KayitTarihi));
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
        DoktorTablo.setItems(listele);
        DoktorTabloAd.setCellValueFactory(new PropertyValueFactory<Doktor, String>("Ad"));
        DoktorTabloSoyad.setCellValueFactory(new PropertyValueFactory<Doktor, String>("Soyad"));
        DoktorDogumYeriTablo.setCellValueFactory(new PropertyValueFactory<Doktor, String>("DogumYeri"));
        DoktorDogumTarihiTablo.setCellValueFactory(new PropertyValueFactory<Doktor, String>("DogumTarihi"));
        DoktorKayitTarihiTablo.setCellValueFactory(new PropertyValueFactory<Doktor, String>("KayitTarihi"));
    }

}
