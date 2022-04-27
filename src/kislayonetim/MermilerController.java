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
import muhimmat.Mermiler;

/**
 * FXML Controller class
 *
 * @author odoza
 */
public class MermilerController implements Initializable {

    @FXML
    private AnchorPane mermilerPane;

    @FXML
    private TableView<Mermiler> mermilerTablo;

    @FXML
    private TableColumn<Mermiler, String> mermilerTabload;

    @FXML
    private TableColumn<Mermiler, String> mermilerTabloserinumarasi;

    @FXML
    private TableColumn<Mermiler, String> mermilerTabloadet;

    @FXML
    private TableColumn<Mermiler, String> mermilerTabloboyut;

    @FXML
    private TextField mermilerAd;

    @FXML
    private TextField mermilerSerinumarasi;

    @FXML
    private TextField mermilerAdet;

    @FXML
    private TextField mermilerBoyut;

    @FXML
    private Label MermiLabel;

    Mermiler mermi = new Mermiler();
    DosyaIslemleri ds = new DosyaIslemleri();
    ObservableList<Mermiler> listele = FXCollections.observableArrayList();

    @FXML
    void Ekle(ActionEvent event) {

        mermi.setAd(mermilerAd.getText().toString());
        mermi.setSeriNo(mermilerSerinumarasi.getText().toString());
        mermi.setAdet(mermilerAdet.getText().toString());
        mermi.setBoyut(mermilerBoyut.getText().toString());
        ds.MermilerEkle(mermi.getAd(), mermi.getSeriNo(), mermi.getAdet(), mermi.getBoyut());
        
        MermiLabel.setText(mermi.mesaj());

    }

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Anasayfa.fxml"));
        mermilerPane.getChildren().setAll(pane);

    }

    @FXML
    void Yenile(ActionEvent event) throws IOException {

        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Mermiler.fxml"));
        mermilerPane.getChildren().setAll(pane);

    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        File mermi = new File("Mermiler.txt");
        if (!mermi.exists()) {
            try {
                mermi.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(mermi);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String line;

        BufferedReader br = new BufferedReader(fileReader);
        int i = 0;

        try {
            byte ax = 0;
            String Ad = "", SeriNo = "", Adet = "", boyut = "";

            while ((line = br.readLine()) != null) {
                ax++;
                if (ax == 1) {
                    Ad = line;
                } else if (ax == 2) {
                    SeriNo = line;
                } else if (ax == 3) {
                    Adet = line;
                } else if (ax == 4) {
                    boyut = line;
                } else if (ax == 5) {
                    listele.add(new Mermiler(Ad, SeriNo, Adet, boyut));
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
        mermilerTablo.setItems(listele);
        mermilerTabload.setCellValueFactory(new PropertyValueFactory<Mermiler, String>("ad"));
        mermilerTabloserinumarasi.setCellValueFactory(new PropertyValueFactory<Mermiler, String>("SeriNo"));
        mermilerTabloadet.setCellValueFactory(new PropertyValueFactory<Mermiler, String>("Adet"));
        mermilerTabloboyut.setCellValueFactory(new PropertyValueFactory<Mermiler, String>("boyut"));

    }
    // TODO
}
