/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import muhimmat.Patlayicilar;
import muhimmat.Silahlar;

/**
 * FXML Controller class
 *
 * @author odoza
 */
public class PatlayicilarController implements Initializable {

    @FXML
    private AnchorPane patlayicilarPane;

    @FXML
    private TableView<Patlayicilar> patlayicilarTablo;

    @FXML
    private TableColumn<Patlayicilar, String> patlayicilarTabload;

    @FXML
    private TableColumn<Patlayicilar, String> patlayicilarTabloserinumarasi;

    @FXML
    private TableColumn<Patlayicilar, String> patlayicilarTabloadet;

    @FXML
    private TableColumn<Patlayicilar, String> patlayicilarTablomenzil;

    @FXML
    private TextField patlayicilarAd;

    @FXML
    private TextField patlayicilarSerinumarasi;

    @FXML
    private TextField patlayicilarAdet;

    @FXML
    private TextField patlayicilarMenzil;

    @FXML
    private Label PatlayiciLabel;

    Patlayicilar patlayici = new Patlayicilar();
    DosyaIslemleri ds = new DosyaIslemleri();
    ObservableList<Patlayicilar> listele = FXCollections.observableArrayList();

    @FXML
    void Ekle(ActionEvent event) {

        patlayici.setAd(patlayicilarAd.getText().toString());
        patlayici.setSeriNo(patlayicilarSerinumarasi.getText().toString());
        patlayici.setAdet(patlayicilarAdet.getText().toString());
        patlayici.setEtkiliOlduguMenzil(patlayicilarMenzil.getText().toString());
        ds.PatlayicilarEkle(patlayici.getAd(), patlayici.getSeriNo(), patlayici.getAdet(), patlayici.getEtkiliOlduguMenzil());
        
        PatlayiciLabel.setText(patlayici.mesaj());
    }

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Anasayfa.fxml"));
        patlayicilarPane.getChildren().setAll(pane);

    }

    @FXML
    void Yenile(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Patlayicilar.fxml"));
        patlayicilarPane.getChildren().setAll(pane);

    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        File patlayici = new File("Patlayicilar.txt");
        if (!patlayici.exists()) {
            try {
                patlayici.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(patlayici);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String line;

        BufferedReader br = new BufferedReader(fileReader);
        int i = 0;

        try {
            byte ax = 0;
            String Ad = "", SeriNo = "", Adet = "", EtkiliOlduguMenzil = "";

            while ((line = br.readLine()) != null) {
                ax++;
                if (ax == 1) {
                    Ad = line;
                } else if (ax == 2) {
                    SeriNo = line;
                } else if (ax == 3) {
                    Adet = line;
                } else if (ax == 4) {
                    EtkiliOlduguMenzil = line;
                } else if (ax == 5) {
                    listele.add(new Patlayicilar(Ad, SeriNo, Adet, EtkiliOlduguMenzil));
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
        patlayicilarTablo.setItems(listele);
        patlayicilarTabload.setCellValueFactory(new PropertyValueFactory<Patlayicilar, String>("ad"));
        patlayicilarTabloserinumarasi.setCellValueFactory(new PropertyValueFactory<Patlayicilar, String>("SeriNo"));
        patlayicilarTabloadet.setCellValueFactory(new PropertyValueFactory<Patlayicilar, String>("Adet"));
        patlayicilarTablomenzil.setCellValueFactory(new PropertyValueFactory<Patlayicilar, String>("EtkiliOlduguMenzil"));

    }
    // TODO
}
