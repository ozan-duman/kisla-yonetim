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
import personel.Asci;

public class AsciController implements Initializable {

    @FXML
    private AnchorPane AsciPane;

    @FXML
    private TableView<Asci> AsciTablo;

    @FXML
    private TableColumn<Asci, String> AsciTabloAd;

    @FXML
    private TableColumn<Asci, String> AsciTabloSoyad;

    @FXML
    private TableColumn<Asci, String> AsciDogumYeriTablo;

    @FXML
    private TableColumn<Asci, String> AsciDogumTarihiTablo;

    @FXML
    private TableColumn<Asci, String> AsciKayitTarihiTablo;

    @FXML
    private TextField AsciAd;

    @FXML
    private TextField AsciSoyad;

    @FXML
    private TextField AsciDogumYeri;

    @FXML
    private TextField AsciDogumTarihi;

    @FXML
    private TextField AsciTarih;
    
    @FXML
    private Label AsciLabel;

    Asci asci = new Asci();
    DosyaIslemleri ds = new DosyaIslemleri();
    ObservableList<Asci> listele = FXCollections.observableArrayList();

    @FXML
    void Ekle(ActionEvent event) throws IOException {
        asci.setAd(AsciAd.getText().toString());
        asci.setSoyad(AsciSoyad.getText().toString());
        asci.setDogumYeri(AsciDogumYeri.getText().toString());
        asci.setDogumTarihi(AsciDogumTarihi.getText().toString());
        asci.setKayitTarihi(AsciTarih.getText().toString());
        ds.AsciEkle(asci.getAd(), asci.getSoyad(), asci.getDogumYeri(), asci.getDogumTarihi(), asci.getKayitTarihi());
        
        AsciLabel.setText(asci.mesaj());
    }

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("SivilPersonelSecim.fxml"));
        AsciPane.getChildren().setAll(pane);
    }

    @FXML
    void Yenile(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Asci.fxml"));
        AsciPane.getChildren().setAll(pane);
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File asci = new File("Asci.txt");
        if (!asci.exists()) {
            try {
                asci.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(asci);
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
                    listele.add(new Asci(Ad, Soyad, DogumYeri, DogumTarihi, KayitTarihi));
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
        AsciTablo.setItems(listele);
        AsciTabloAd.setCellValueFactory(new PropertyValueFactory<Asci, String>("Ad"));
        AsciTabloSoyad.setCellValueFactory(new PropertyValueFactory<Asci, String>("Soyad"));
        AsciDogumYeriTablo.setCellValueFactory(new PropertyValueFactory<Asci, String>("DogumYeri"));
        AsciDogumTarihiTablo.setCellValueFactory(new PropertyValueFactory<Asci, String>("DogumTarihi"));
        AsciKayitTarihiTablo.setCellValueFactory(new PropertyValueFactory<Asci, String>("KayitTarihi"));
    }

}
