/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kislayonetim;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import dosyaIslemleri.DosyaIslemleri;
import erzaklar.Icecekler;
import erzaklar.Ilaclar;
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
public class IceceklerController implements Initializable {

    @FXML
    private AnchorPane IceceklerPane;

    @FXML
    private TableView<Icecekler> IceceklerTablo;

    @FXML
    private TableColumn<Icecekler, String> iceceklerTabload;

    @FXML
    private TableColumn<Icecekler, Integer> iceceklerTablosonkullanmatarihi;

    @FXML
    private TableColumn<Icecekler, Integer> iceceklerTablokalorimiktari;

    @FXML
    private TableColumn<Icecekler, Integer> iceceklerTablolitre;

    @FXML
    private TableColumn<Icecekler, Integer> iceceklerTabloadet;

    @FXML
    private TextField iceceklerAd;

    @FXML
    private TextField iceceklerSonkullanmatarihi;

    @FXML
    private TextField iceceklerLitre;

    @FXML
    private TextField iceceklerKalorimiktari;

    @FXML
    private TextField iceceklerAdet;

    @FXML
    private Label icecekLabel;

    Icecekler icecek = new Icecekler();
    DosyaIslemleri ds = new DosyaIslemleri();
    ObservableList<Icecekler> listele = FXCollections.observableArrayList();

    @FXML
    void Ekle(ActionEvent event) {
        icecek.setAd(iceceklerAd.getText().toString());
        icecek.setSonKullanmaTarihi(Integer.valueOf(iceceklerSonkullanmatarihi.getText().toString()));
        icecek.setKaloriMiktari(Integer.valueOf(iceceklerKalorimiktari.getText().toString()));
        icecek.setLitre(Integer.valueOf(iceceklerLitre.getText().toString()));
        icecek.setAdet(Integer.valueOf(iceceklerAdet.getText().toString()));

        ds.IceceklerEkle(icecek.getAd(), icecek.getSonKullanmaTarihi(), icecek.getKaloriMiktari(), icecek.getLitre(), icecek.getAdet());
        
        icecekLabel.setText(icecek.mesaj());

    }

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Anasayfa.fxml"));
        IceceklerPane.getChildren().setAll(pane);

    }

    @FXML
    void Yenile(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Icecekler.fxml"));
        IceceklerPane.getChildren().setAll(pane);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File icecek = new File("Icecekler.txt");
        if (!icecek.exists()) {
            try {
                icecek.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(icecek);
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
            int sonKullanmaTarihi = 0, kaloriMiktari = 0, litre = 0, adet = 0;
            while ((line = br.readLine()) != null) {
                ax++;
                if (ax == 1) {
                    ad = line;
                } else if (ax == 2) {
                    sonKullanmaTarihi = Integer.valueOf(line);
                } else if (ax == 3) {
                    kaloriMiktari = Integer.valueOf(line);
                } else if (ax == 4) {
                    litre = Integer.valueOf(line);
                } else if (ax == 5) {
                    adet = Integer.valueOf(line);
                } else if (ax == 6) {
                    listele.add(new Icecekler(ad, sonKullanmaTarihi, kaloriMiktari, litre, adet));
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
        IceceklerTablo.setItems(listele);
        iceceklerTabload.setCellValueFactory(new PropertyValueFactory<Icecekler, String>("ad"));
        iceceklerTablosonkullanmatarihi.setCellValueFactory(new PropertyValueFactory<Icecekler, Integer>("sonKullanmaTarihi"));
        iceceklerTablokalorimiktari.setCellValueFactory(new PropertyValueFactory<Icecekler, Integer>("kaloriMiktari"));
        iceceklerTablolitre.setCellValueFactory(new PropertyValueFactory<Icecekler, Integer>("litre"));
        iceceklerTabloadet.setCellValueFactory(new PropertyValueFactory<Icecekler, Integer>("adet"));

    }
    // TODO
}
