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
public class IlaclarController implements Initializable {

    @FXML
    private AnchorPane IlaclarPane;

    @FXML
    private TableView<Ilaclar> IlaclarTablo;

    @FXML
    private TableColumn<Ilaclar, String> ilaclarTabload;

    @FXML
    private TableColumn<Ilaclar, Integer> ilaclarTablosonkullanmatarihi;

    @FXML
    private TableColumn<Ilaclar, Integer> ilaclarTablogunlukdoz;

    @FXML
    private TableColumn<Ilaclar, String> ilaclarTabloyanetkiler;

    @FXML
    private TextField ilaclarAd;

    @FXML
    private TextField ilaclarTarih;

    @FXML
    private TextField ilaclarDoz;

    @FXML
    private TextField ilaclarYanetkiler;

    @FXML
    private Label ilacLabel;

    @FXML
    void Ekle(ActionEvent event) {
        ilac.setAd(ilaclarAd.getText().toString());
        ilac.setSonKullanmaTarihi(Integer.valueOf(ilaclarTarih.getText().toString()));
        ilac.setGunlukDozMiktarı(Integer.valueOf(ilaclarDoz.getText().toString()));
        ilac.setYanEtkileri(ilaclarYanetkiler.getText().toString());

        ds.IlaclarEkle(ilac.getAd(), ilac.getSonKullanmaTarihi(), ilac.getGunlukDozMiktarı(), ilac.getYanEtkileri());
        
        ilacLabel.setText(ilac.mesaj());
    }

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Anasayfa.fxml"));
        IlaclarPane.getChildren().setAll(pane);

    }

    @FXML
    void Yenile(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Ilaclar.fxml"));
        IlaclarPane.getChildren().setAll(pane);

    }
    Ilaclar ilac = new Ilaclar();
    DosyaIslemleri ds = new DosyaIslemleri();
    ObservableList<Ilaclar> listele = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File ilac = new File("Ilaclar.txt");
        if (!ilac.exists()) {
            try {
                ilac.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(ilac);
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
            String yanEtkileri = "";
            int sonKullanmaTarihi = 0, gunlukDozMiktarı = 0;
            while ((line = br.readLine()) != null) {
                ax++;
                if (ax == 1) {
                    ad = line;
                } else if (ax == 2) {
                    sonKullanmaTarihi = Integer.valueOf(line);
                } else if (ax == 3) {
                    gunlukDozMiktarı = Integer.valueOf(line);
                } else if (ax == 4) {
                    yanEtkileri = line;
                } else if (ax == 5) {
                    listele.add(new Ilaclar(ad, sonKullanmaTarihi, gunlukDozMiktarı, yanEtkileri));
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
        IlaclarTablo.setItems(listele);
        ilaclarTabload.setCellValueFactory(new PropertyValueFactory<Ilaclar, String>("ad"));
        ilaclarTablosonkullanmatarihi.setCellValueFactory(new PropertyValueFactory<Ilaclar, Integer>("sonKullanmaTarihi"));
        ilaclarTablogunlukdoz.setCellValueFactory(new PropertyValueFactory<Ilaclar, Integer>("gunlukDozMiktarı"));
        ilaclarTabloyanetkiler.setCellValueFactory(new PropertyValueFactory<Ilaclar, String>("yanEtkileri"));

    }
}
