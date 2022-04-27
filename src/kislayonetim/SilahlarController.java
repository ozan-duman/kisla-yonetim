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
import muhimmat.Silahlar;

public class SilahlarController implements Initializable {

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @FXML
    private AnchorPane silahlarPane;

    @FXML
    private TableView<Silahlar> silahlarTablo;

    @FXML
    private TableColumn<Silahlar, String> silahlarTabload;

    @FXML
    private TableColumn<Silahlar, String> silahlarTabloserinumarasi;

    @FXML
    private TableColumn<Silahlar, String> silahlarTabloadet;

    @FXML
    private TableColumn<Silahlar, String> silahlarTabloturu;

    @FXML
    private TextField silahlarAd;

    @FXML
    private TextField silahlarSerinumarasi;

    @FXML
    private TextField silahlarAdet;

    @FXML
    private TextField silahlarTuru;

    @FXML
    private Label SilahLabel;

    Silahlar silah = new Silahlar();
    DosyaIslemleri ds = new DosyaIslemleri();
    ObservableList<Silahlar> listele = FXCollections.observableArrayList();

    @FXML
    void Ekle(ActionEvent event) {

        silah.setAd(silahlarAd.getText().toString());
        silah.setSeriNo(silahlarSerinumarasi.getText().toString());
        silah.setAdet(silahlarAdet.getText().toString());
        silah.setTur(silahlarTuru.getText().toString());
        ds.SilahlarEkle(silah.getAd(), silah.getSeriNo(), silah.getAdet(), silah.getTur());
        
        SilahLabel.setText(silah.mesaj());
    }

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Anasayfa.fxml"));
        silahlarPane.getChildren().setAll(pane);
    }

    @FXML
    void Yenile(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Silahlar.fxml"));
        silahlarPane.getChildren().setAll(pane);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File silah = new File("Silahlar.txt");
        if (!silah.exists()) {
            try {
                silah.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(silah);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String line;

        BufferedReader br = new BufferedReader(fileReader);
        int i = 0;

        try {
            byte ax = 0;
            String Ad = "", SeriNo = "", Adet = "", Tur = "";

            while ((line = br.readLine()) != null) {
                ax++;
                if (ax == 1) {
                    Ad = line;
                } else if (ax == 2) {
                    SeriNo = line;
                } else if (ax == 3) {
                    Adet = line;
                } else if (ax == 4) {
                    Tur = line;
                } else if (ax == 5) {
                    listele.add(new Silahlar(Ad, SeriNo, Adet, Tur));
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
        silahlarTablo.setItems(listele);
        silahlarTabload.setCellValueFactory(new PropertyValueFactory<Silahlar, String>("ad"));
        silahlarTabloserinumarasi.setCellValueFactory(new PropertyValueFactory<Silahlar, String>("SeriNo"));
        silahlarTabloadet.setCellValueFactory(new PropertyValueFactory<Silahlar, String>("Adet"));
        silahlarTabloturu.setCellValueFactory(new PropertyValueFactory<Silahlar, String>("Tur"));

    }
    // TODO
}
