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

import tesisler.BarinmaTesisleri;

/**
 * FXML Controller class
 *
 * @author odoza
 */
public class BarinmaTesisleriController implements Initializable {

    @FXML
    private AnchorPane BarinmaTesisleriPane;

    @FXML
    private TableView<BarinmaTesisleri> BarinmaTesisleriTablo;

    @FXML
    private TableColumn<BarinmaTesisleri, String> BarinmaTabloAd;

    @FXML
    private TableColumn<BarinmaTesisleri, Integer> BarinmaTabloOdaSayisi;

    @FXML
    private TableColumn<BarinmaTesisleri, Integer> BarinmaTabloKatSayisi;

    @FXML
    private TableColumn<BarinmaTesisleri, Integer> BarinmaTabloMetrekare;

    @FXML
    private TableColumn<BarinmaTesisleri, Integer> BarinmaTabloKapasite;

    @FXML
    private TableColumn<BarinmaTesisleri, Integer> BarinmaTabloBinaYasi;

    @FXML
    private TextField barinmaAd;

    @FXML
    private TextField barinmaOdaSayisi;

    @FXML
    private TextField barinmaKatSayisi;

    @FXML
    private TextField barinmaMetrekare;

    @FXML
    private TextField barinmaKapasite;

    @FXML
    private TextField barinmaBinaYasi;

    @FXML
    private Label BarinmaLabel;

    BarinmaTesisleri brnts = new BarinmaTesisleri();
    DosyaIslemleri ds = new DosyaIslemleri();
    ObservableList<BarinmaTesisleri> listele = FXCollections.observableArrayList();

    @FXML
    void Ekle(ActionEvent event) {
        brnts.setAd(barinmaAd.getText().toString());
        brnts.setOdaSayisi(Integer.valueOf(barinmaOdaSayisi.getText().toString()));
        brnts.setKatSayisi(Integer.valueOf(barinmaKatSayisi.getText().toString()));
        brnts.setMetrekare(Integer.valueOf(barinmaMetrekare.getText().toString()));
        brnts.setKapasite(Integer.valueOf(barinmaKapasite.getText().toString()));
        brnts.setBinaYasi(Integer.valueOf(barinmaBinaYasi.getText().toString()));
        ds.BarinmaTesisleriEkle(brnts.getAd(), brnts.getOdaSayisi(), brnts.getKatSayisi(), brnts.getMetrekare(), brnts.getKapasite(), brnts.getBinaYasi());
        BarinmaLabel.setText(brnts.mesaj());
    }

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Anasayfa.fxml"));
        BarinmaTesisleriPane.getChildren().setAll(pane);
    }

    @FXML
    void Yenile(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("BarinmaTesisleri.fxml"));
        BarinmaTesisleriPane.getChildren().setAll(pane);

    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File brnts = new File("BarinmaTesisleri.txt");
        if (!brnts.exists()) {
            try {
                brnts.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(brnts);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String line;

        BufferedReader br = new BufferedReader(fileReader);
        int i = 0;

        try {
            byte ax = 0;
            String ad = "";
            int odaSayisi = 0, katSayisi = 0, metrekare = 0, kapasite = 0, binaYasi = 0;
            while ((line = br.readLine()) != null) {
                ax++;
                if (ax == 1) {
                    ad = line;
                } else if (ax == 2) {
                    odaSayisi = Integer.valueOf(line);
                } else if (ax == 3) {
                    katSayisi = Integer.valueOf(line);
                } else if (ax == 4) {
                    metrekare = Integer.valueOf(line);
                } else if (ax == 5) {
                    kapasite = Integer.valueOf(line);
                } else if (ax == 6) {
                    binaYasi = Integer.valueOf(line);
                } else if (ax == 7) {
                    listele.add(new BarinmaTesisleri(ad, odaSayisi, katSayisi, metrekare, kapasite, binaYasi));
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
        BarinmaTesisleriTablo.setItems(listele);
        BarinmaTabloAd.setCellValueFactory(new PropertyValueFactory<BarinmaTesisleri, String>("ad"));
        BarinmaTabloOdaSayisi.setCellValueFactory(new PropertyValueFactory<BarinmaTesisleri, Integer>("odaSayisi"));
        BarinmaTabloKatSayisi.setCellValueFactory(new PropertyValueFactory<BarinmaTesisleri, Integer>("katSayisi"));
        BarinmaTabloMetrekare.setCellValueFactory(new PropertyValueFactory<BarinmaTesisleri, Integer>("metrekare"));
        BarinmaTabloKapasite.setCellValueFactory(new PropertyValueFactory<BarinmaTesisleri, Integer>("kapasite"));
        BarinmaTabloBinaYasi.setCellValueFactory(new PropertyValueFactory<BarinmaTesisleri, Integer>("binaYasi"));
    }

}
