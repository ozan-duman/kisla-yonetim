/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kislayonetim;

import dosyaIslemleri.DosyaIslemleri;

import erzaklar.ProteinUrunleri;
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
 * @author 90531
 */
public class ProteinUrunleriController implements Initializable {

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @FXML
    private AnchorPane ProteinUrunleriPane;

    @FXML
    private TableView<ProteinUrunleri> proteinTablo;

    @FXML
    private TableColumn<ProteinUrunleri, String> proteinTabload;

    @FXML
    private TableColumn<ProteinUrunleri, Integer> proteinTablosonkullanmatarihi;

    @FXML
    private TableColumn<ProteinUrunleri, Integer> proteinTablokalorimiktari;

    @FXML
    private TableColumn<ProteinUrunleri, Integer> proteinTabloproteinmiktari;

    @FXML
    private TableColumn<ProteinUrunleri, Integer> proteinTabloadet;

    @FXML
    private TextField proteinAd;

    @FXML
    private TextField proteinSonkullanmatarihi;

    @FXML
    private TextField proteinKalorimiktari;

    @FXML
    private TextField proteinMiktari;

    @FXML
    private TextField proteinAdet;

    @FXML
    private Label proteinLabel;

    ProteinUrunleri protein = new ProteinUrunleri();
    DosyaIslemleri ds = new DosyaIslemleri();
    ObservableList<ProteinUrunleri> listele = FXCollections.observableArrayList();

    @FXML
    void Yenile(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("ProteinUrunleri.fxml"));
        ProteinUrunleriPane.getChildren().setAll(pane);

    }

    @FXML
    void Ekle(ActionEvent event) {
        protein.setAd(proteinAd.getText().toString());
        protein.setSonKullanmaTarihi(Integer.valueOf(proteinSonkullanmatarihi.getText().toString()));
        protein.setKaloriMiktari(Integer.valueOf(proteinKalorimiktari.getText().toString()));
        protein.setProteinMiktari(Integer.valueOf(proteinMiktari.getText().toString()));
        protein.setAdet(Integer.valueOf(proteinAdet.getText().toString()));

        ds.ProteinUrunleriEkle(protein.getAd(), protein.getSonKullanmaTarihi(), protein.getKaloriMiktari(), protein.getProteinMiktari(), protein.getAdet());
        
        proteinLabel.setText(protein.mesaj());
    }

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Anasayfa.fxml"));
        ProteinUrunleriPane.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File protein = new File("ProteinUrunleri.txt");
        if (!protein.exists()) {
            try {
                protein.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(protein);
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
            int sonKullanmaTarihi = 0, kaloriMiktari = 0, proteinMiktari = 0, adet = 0;
            while ((line = br.readLine()) != null) {
                ax++;
                if (ax == 1) {
                    ad = line;
                } else if (ax == 2) {
                    sonKullanmaTarihi = Integer.valueOf(line);
                } else if (ax == 3) {
                    kaloriMiktari = Integer.valueOf(line);
                } else if (ax == 4) {
                    proteinMiktari = Integer.valueOf(line);
                } else if (ax == 5) {
                    adet = Integer.valueOf(line);
                } else if (ax == 6) {
                    listele.add(new ProteinUrunleri(ad, sonKullanmaTarihi, kaloriMiktari, proteinMiktari, adet));
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
        proteinTablo.setItems(listele);
        proteinTabload.setCellValueFactory(new PropertyValueFactory<ProteinUrunleri, String>("ad"));
        proteinTablosonkullanmatarihi.setCellValueFactory(new PropertyValueFactory<ProteinUrunleri, Integer>("sonKullanmaTarihi"));
        proteinTablokalorimiktari.setCellValueFactory(new PropertyValueFactory<ProteinUrunleri, Integer>("kaloriMiktari"));
        proteinTabloproteinmiktari.setCellValueFactory(new PropertyValueFactory<ProteinUrunleri, Integer>("proteinMiktari"));
        proteinTabloadet.setCellValueFactory(new PropertyValueFactory<ProteinUrunleri, Integer>("adet"));

    }
    // TODO
}
