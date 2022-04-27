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
import tesisler.SaglikTesisleri;

/**
 * FXML Controller class
 *
 * @author 90531
 */
public class SaglikTesisleriController implements Initializable {

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @FXML
    private AnchorPane SaglikTesisleriPane;

    @FXML
    private TableView<SaglikTesisleri> saglikTesisleriTablo;

    @FXML
    private TableColumn<SaglikTesisleri, String> saglikTabloBinaAdi;

    @FXML
    private TableColumn<SaglikTesisleri, Integer> saglikTabloOdaSayisi;

    @FXML
    private TableColumn<SaglikTesisleri, Integer> saglikTabloKatSayisi;

    @FXML
    private TableColumn<SaglikTesisleri, Integer> saglikTabloMetrekare;

    @FXML
    private TableColumn<SaglikTesisleri, Integer> saglikTabloHastaKapasitesi;

    @FXML
    private TableColumn<SaglikTesisleri, Integer> saglikTabloTedaviOdasi;

    @FXML
    private TextField saglikBinaAdi;

    @FXML
    private TextField saglikOdaSayisi;

    @FXML
    private TextField saglikKatSayisi;

    @FXML
    private TextField saglikMetrekare;

    @FXML
    private TextField saglikKapasite;

    @FXML
    private TextField saglikTedaviOdasi;

    @FXML
    private Label SaglikTesisLabel;

    SaglikTesisleri sglkts = new SaglikTesisleri();
    DosyaIslemleri ds = new DosyaIslemleri();
    ObservableList<SaglikTesisleri> listele = FXCollections.observableArrayList();

    @FXML
    void Ekle(ActionEvent event) {
        sglkts.setAd(saglikBinaAdi.getText().toString());
        sglkts.setOdaSayisi(Integer.valueOf(saglikOdaSayisi.getText().toString()));
        sglkts.setKatSayisi(Integer.valueOf(saglikKatSayisi.getText().toString()));
        sglkts.setMetrekare(Integer.valueOf(saglikMetrekare.getText().toString()));
        sglkts.setKapasite(Integer.valueOf(saglikKapasite.getText().toString()));
        sglkts.setTedaviOdasi(Integer.valueOf(saglikTedaviOdasi.getText().toString()));
        ds.SaglikTesisleriEkle(sglkts.getAd(), sglkts.getOdaSayisi(), sglkts.getKatSayisi(), sglkts.getMetrekare(), sglkts.getKapasite(), sglkts.getTedaviOdasi());
        SaglikTesisLabel.setText(sglkts.mesaj());
    }

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Anasayfa.fxml"));
        SaglikTesisleriPane.getChildren().setAll(pane);
    }

    @FXML
    void Yenile(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("SaglikTesisleri.fxml"));
        SaglikTesisleriPane.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File sglkts = new File("SaglikTesisleri.txt");
        if (!sglkts.exists()) {
            try {
                sglkts.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(sglkts);
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
            int odaSayisi = 0, katSayisi = 0, metrekare = 0, kapasite = 0, tedaviOdasi = 0;
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
                    tedaviOdasi = Integer.valueOf(line);
                } else if (ax == 7) {
                    listele.add(new SaglikTesisleri(ad, odaSayisi, katSayisi, metrekare, kapasite, tedaviOdasi));
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
        saglikTesisleriTablo.setItems(listele);
        saglikTabloBinaAdi.setCellValueFactory(new PropertyValueFactory<SaglikTesisleri, String>("ad"));
        saglikTabloOdaSayisi.setCellValueFactory(new PropertyValueFactory<SaglikTesisleri, Integer>("odaSayisi"));
        saglikTabloKatSayisi.setCellValueFactory(new PropertyValueFactory<SaglikTesisleri, Integer>("katSayisi"));
        saglikTabloMetrekare.setCellValueFactory(new PropertyValueFactory<SaglikTesisleri, Integer>("metrekare"));
        saglikTabloHastaKapasitesi.setCellValueFactory(new PropertyValueFactory<SaglikTesisleri, Integer>("kapasite"));
        saglikTabloTedaviOdasi.setCellValueFactory(new PropertyValueFactory<SaglikTesisleri, Integer>("tedaviOdasi"));
    }
    // TODO
}
