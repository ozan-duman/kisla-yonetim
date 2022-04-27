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
import tesisler.Depo;


/**
 * FXML Controller class
 *
 * @author odoza
 */
public class DepoController implements Initializable {
    
    @FXML
    private AnchorPane DepoPane;

    @FXML
    private TableView<Depo> DepoTablo;

    @FXML
    private TableColumn<Depo, String> depoTabload;

    @FXML
    private TableColumn<Depo, Integer> depoTabloodasayisi;

    @FXML
    private TableColumn<Depo, Integer> depoTablokatsayisi;

    @FXML
    private TableColumn<Depo, Integer> depoTablometrekare;

    @FXML
    private TableColumn<Depo, Integer> depoTablokapasite;

    @FXML
    private TextField depoAd;

    @FXML
    private TextField depoOdasayisi;

    @FXML
    private TextField depoKatsayisi;

    @FXML
    private TextField depoMetrekare;

    @FXML
    private TextField depoKapasite;
    
    @FXML
    private Label DepoLabel;

    Depo depo = new Depo();
    DosyaIslemleri ds = new DosyaIslemleri();
    ObservableList<Depo> listele = FXCollections.observableArrayList();
    
    @FXML
    void Ekle(ActionEvent event) {
        depo.setAd(depoAd.getText().toString());
        depo.setOdaSayisi(Integer.valueOf(depoOdasayisi.getText().toString()));
        depo.setKatSayisi(Integer.valueOf(depoKatsayisi.getText().toString()));
        depo.setMetrekare(Integer.valueOf(depoMetrekare.getText().toString()));
        depo.setKapasite(Integer.valueOf(depoKapasite.getText().toString()));
        ds.DepoEkle(depo.getAd(), depo.getOdaSayisi(), depo.getKatSayisi(), depo.getMetrekare(), depo.getKapasite());
        
        DepoLabel.setText(depo.mesaj());
    }

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Tesissecimekrani.fxml"));
        DepoPane.getChildren().setAll(pane);

    }

    @FXML
    void Yenile(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Depo.fxml"));
        DepoPane.getChildren().setAll(pane);

    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File depo = new File("Depo.txt");
        if (!depo.exists()) {
            try {
                depo.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(depo);
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
            int odaSayisi = 0, katSayisi = 0, metrekare = 0, kapasite = 0;
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
                    listele.add(new Depo(ad, odaSayisi, katSayisi, metrekare, kapasite));
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
        DepoTablo.setItems(listele);
        depoTabload.setCellValueFactory(new PropertyValueFactory<Depo, String>("ad"));
        depoTabloodasayisi.setCellValueFactory(new PropertyValueFactory<Depo, Integer>("odaSayisi"));
        depoTablokatsayisi.setCellValueFactory(new PropertyValueFactory<Depo, Integer>("katSayisi"));
        depoTablometrekare.setCellValueFactory(new PropertyValueFactory<Depo, Integer>("metrekare"));
        depoTablokapasite.setCellValueFactory(new PropertyValueFactory<Depo, Integer>("kapasite"));

    }
        // TODO
    }    
    

