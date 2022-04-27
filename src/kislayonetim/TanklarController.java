package kislayonetim;

import araclar.Tanklar;
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

public class TanklarController implements Initializable {

    @FXML
    private AnchorPane TanklarPane;

    @FXML
    private TableView<Tanklar> TanklarTablo;

    @FXML
    private TableColumn<Tanklar, String> TankAdTablo;

    @FXML
    private TableColumn<Tanklar, String> TankHizTablo;

    @FXML
    private TableColumn<Tanklar, String> TankAgirlikTablo;

    @FXML
    private TableColumn<Tanklar, String> TankMotorHacimTablo;

    @FXML
    private TableColumn<Tanklar, String> TankDepoKapasitesiTablo;

    @FXML
    private TextField TankAd;

    @FXML
    private TextField TankHiz;

    @FXML
    private TextField TankAgirlik;

    @FXML
    private TextField TankMotorHacim;

    @FXML
    private TextField TankDepoKapasitesi;

    @FXML
    private Label TankLabel;

    Tanklar tnk = new Tanklar();
    DosyaIslemleri ds = new DosyaIslemleri();
    ObservableList<Tanklar> listele = FXCollections.observableArrayList();

    @FXML
    void Ekle(ActionEvent event) throws IOException {
        tnk.setAd(TankAd.getText().toString());
        tnk.setHiz(TankHiz.getText().toString());
        tnk.setAgirlik(TankAgirlik.getText().toString());
        tnk.setMotorHacim(TankMotorHacim.getText().toString());
        tnk.setDepoKapasitesi(TankDepoKapasitesi.getText().toString());
        ds.TankEkle(tnk.getAd(), tnk.getHiz(), tnk.getAgirlik(), tnk.getMotorHacim(), tnk.getDepoKapasitesi());
        
        TankLabel.setText(tnk.mesaj());
    }

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("PaletliAracSecim.fxml"));
        TanklarPane.getChildren().setAll(pane);
    }

    @FXML
    void Yenile(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Tanklar.fxml"));
        TanklarPane.getChildren().setAll(pane);
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File tnk = new File("Tanklar.txt");
        if (!tnk.exists()) {
            try {
                tnk.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(tnk);
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
                    listele.add(new Tanklar(Ad, Hiz, Agirlik, MotorHacim, DepoKapasitesi));
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
        TanklarTablo.setItems(listele);
        TankAdTablo.setCellValueFactory(new PropertyValueFactory<Tanklar, String>("Ad"));
        TankHizTablo.setCellValueFactory(new PropertyValueFactory<Tanklar, String>("Hiz"));
        TankAgirlikTablo.setCellValueFactory(new PropertyValueFactory<Tanklar, String>("Agirlik"));
        TankMotorHacimTablo.setCellValueFactory(new PropertyValueFactory<Tanklar, String>("MotorHacim"));
        TankDepoKapasitesiTablo.setCellValueFactory(new PropertyValueFactory<Tanklar, String>("DepoKapasitesi"));

    }

}
