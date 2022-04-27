package kislayonetim;

import araclar.PaletliPersonelTasiyici;
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

public class PaletliPersonelTasiyiciController implements Initializable {

    @FXML
    private AnchorPane PaletliPersonelTasiyiciPane;

    @FXML
    private TableView<PaletliPersonelTasiyici> PaletliPersonelTasiyiciTablo;

    @FXML
    private TableColumn<PaletliPersonelTasiyici, String> PaletliAdTablo;

    @FXML
    private TableColumn<PaletliPersonelTasiyici, String> PaletliHizTablo;

    @FXML
    private TableColumn<PaletliPersonelTasiyici, String> PaletliAgirlikTablo;

    @FXML
    private TableColumn<PaletliPersonelTasiyici, String> PaletliMotorHacimTablo;

    @FXML
    private TableColumn<PaletliPersonelTasiyici, String> PaletliDepoKapasitesiTablo;

    @FXML
    private TextField PaletAd;

    @FXML
    private TextField PaletHiz;

    @FXML
    private TextField PaletAgirlik;

    @FXML
    private TextField PaletMotorHacim;

    @FXML
    private TextField PaletDepoKapasitesi;

    @FXML
    private Label PaletliTasiyiciLabel;

    PaletliPersonelTasiyici ppt = new PaletliPersonelTasiyici();
    DosyaIslemleri ds = new DosyaIslemleri();
    ObservableList<PaletliPersonelTasiyici> listele = FXCollections.observableArrayList();

    @FXML
    void Ekle(ActionEvent event) throws IOException {
        ppt.setAd(PaletAd.getText().toString());
        ppt.setHiz(PaletHiz.getText().toString());
        ppt.setAgirlik(PaletAgirlik.getText().toString());
        ppt.setMotorHacim(PaletMotorHacim.getText().toString());
        ppt.setDepoKapasitesi(PaletDepoKapasitesi.getText().toString());
        ds.PaletliPersonelTasiyiciEkle(ppt.getAd(), ppt.getHiz(), ppt.getAgirlik(), ppt.getMotorHacim(), ppt.getDepoKapasitesi());
        
        PaletliTasiyiciLabel.setText(ppt.mesaj());
    }

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("PaletliAracSecim.fxml"));
        PaletliPersonelTasiyiciPane.getChildren().setAll(pane);
    }

    @FXML
    void Yenile(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("PaletliPersonelTasiyici.fxml"));
        PaletliPersonelTasiyiciPane.getChildren().setAll(pane);
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File ppt = new File("PaletliPersonelTasiyici.txt");
        if (!ppt.exists()) {
            try {
                ppt.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(ppt);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String line;

        BufferedReader br = new BufferedReader(fileReader);
        int i = 0;

        try {
            byte ax = 0;
            String Ad = "", Hiz = "", Agirlik = "", MotorHacim = "", DepoKapasitesi = "";
            while ((line = br.readLine()) != null) {
                ax++;
                if (ax == 1) {
                    Ad = line;
                } else if (ax == 2) {
                    Hiz = line;
                } else if (ax == 3) {
                    Agirlik = line;
                } else if (ax == 4) {
                    MotorHacim = line;
                } else if (ax == 5) {
                    DepoKapasitesi = line;
                } else if (ax == 6) {
                    listele.add(new PaletliPersonelTasiyici(Ad, Hiz, Agirlik, MotorHacim, DepoKapasitesi));
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
        PaletliPersonelTasiyiciTablo.setItems(listele);
        PaletliAdTablo.setCellValueFactory(new PropertyValueFactory<PaletliPersonelTasiyici, String>("Ad"));
        PaletliHizTablo.setCellValueFactory(new PropertyValueFactory<PaletliPersonelTasiyici, String>("Hiz"));
        PaletliAgirlikTablo.setCellValueFactory(new PropertyValueFactory<PaletliPersonelTasiyici, String>("Agirlik"));
        PaletliMotorHacimTablo.setCellValueFactory(new PropertyValueFactory<PaletliPersonelTasiyici, String>("MotorHacim"));
        PaletliDepoKapasitesiTablo.setCellValueFactory(new PropertyValueFactory<PaletliPersonelTasiyici, String>("DepoKapasitesi"));

    }

}
