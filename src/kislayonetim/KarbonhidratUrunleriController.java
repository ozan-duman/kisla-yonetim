/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kislayonetim;

import dosyaIslemleri.DosyaIslemleri;
import erzaklar.Ilaclar;
import erzaklar.KarbonhidratUrunleri;
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

/**
 * FXML Controller class
 *
 * @author odoza
 */
public class KarbonhidratUrunleriController implements Initializable {

    @FXML
    private AnchorPane karbonhidratPane;

    @FXML
    private TableView<KarbonhidratUrunleri> karbonhidratTablo;

    @FXML
    private TableColumn<KarbonhidratUrunleri, String> karbonhidratTabload;

    @FXML
    private TableColumn<KarbonhidratUrunleri, Integer> karbonhidratTablosonkullanmatarihi;

    @FXML
    private TableColumn<KarbonhidratUrunleri, Integer> karbonhidratTablokalorimiktari;

    @FXML
    private TableColumn<KarbonhidratUrunleri, Integer> karbonhidratTabloenerjimiktari;

    @FXML
    private TableColumn<KarbonhidratUrunleri, Integer> karbonhidratTablotoplam;

    @FXML
    private TextField karbonhidratAd;

    @FXML
    private TextField karbonhidratSonkullanmatarihi;

    @FXML
    private TextField karbonhidratKalorimiktari;

    @FXML
    private TextField karbonhidratEnerjimiktari;

    @FXML
    private TextField karbonhidratToplam;

    @FXML
    private Label karbonhidratLabel;

    KarbonhidratUrunleri karbonhidrat = new KarbonhidratUrunleri();
    DosyaIslemleri ds = new DosyaIslemleri();
    ObservableList<KarbonhidratUrunleri> listele = FXCollections.observableArrayList();

    @FXML
    void Ekle(ActionEvent event) throws IOException {
        karbonhidrat.setAd(karbonhidratAd.getText().toString());
        karbonhidrat.setSonKullanmaTarihi(Integer.valueOf(karbonhidratSonkullanmatarihi.getText().toString()));
        karbonhidrat.setKaloriMiktari(Integer.valueOf(karbonhidratKalorimiktari.getText().toString()));
        karbonhidrat.setEnerjiMiktari(Integer.valueOf(karbonhidratEnerjimiktari.getText().toString()));
        karbonhidrat.setAdet(Integer.valueOf(karbonhidratToplam.getText().toString()));

        ds.KarbonhidratUrunleriEkle(karbonhidrat.getAd(), karbonhidrat.getSonKullanmaTarihi(), karbonhidrat.getKaloriMiktari(), karbonhidrat.getEnerjiMiktari(), karbonhidrat.getAdet());
        
        karbonhidratLabel.setText(karbonhidrat.mesaj());
    }

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Anasayfa.fxml"));
        karbonhidratPane.getChildren().setAll(pane);

    }

    @FXML
    void Yenile(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("KarbonhidratUrunleri.fxml"));
        karbonhidratPane.getChildren().setAll(pane);

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File karbonhidrat = new File("KarbonhidratUrunleri.txt");
        if (!karbonhidrat.exists()) {
            try {
                karbonhidrat.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(karbonhidrat);
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

            int sonKullanmaTarihi = 0, kaloriMiktari = 0, enerjiMiktari = 0, adet = 0;
            while ((line = br.readLine()) != null) {
                ax++;
                if (ax == 1) {
                    ad = line;
                } else if (ax == 2) {
                    sonKullanmaTarihi = Integer.valueOf(line);
                } else if (ax == 3) {
                    kaloriMiktari = Integer.valueOf(line);
                } else if (ax == 4) {
                    enerjiMiktari = Integer.valueOf(line);
                } else if (ax == 5) {
                    adet = Integer.valueOf(line);
                } else if (ax == 6) {
                    listele.add(new KarbonhidratUrunleri(ad, sonKullanmaTarihi, kaloriMiktari, enerjiMiktari, adet));
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
        karbonhidratTablo.setItems(listele);
        karbonhidratTabload.setCellValueFactory(new PropertyValueFactory<KarbonhidratUrunleri, String>("ad"));
        karbonhidratTablosonkullanmatarihi.setCellValueFactory(new PropertyValueFactory<KarbonhidratUrunleri, Integer>("sonKullanmaTarihi"));
        karbonhidratTablokalorimiktari.setCellValueFactory(new PropertyValueFactory<KarbonhidratUrunleri, Integer>("kaloriMiktari"));
        karbonhidratTabloenerjimiktari.setCellValueFactory(new PropertyValueFactory<KarbonhidratUrunleri, Integer>("enerjiMiktari"));
        karbonhidratTablotoplam.setCellValueFactory(new PropertyValueFactory<KarbonhidratUrunleri, Integer>("adet"));

    }
    // TODO
}
