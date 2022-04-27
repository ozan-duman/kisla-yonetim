package kislayonetim;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
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
import tesisler.Garaj;

public class GarajController implements Initializable {

    @FXML
    private AnchorPane GarajPane;

    @FXML
    private TableView<Garaj> GarajTablo;

    @FXML
    private TableColumn<Garaj, String> garajTabload;

    @FXML
    private TableColumn<Garaj, Integer> garajTabloodasayisi;

    @FXML
    private TableColumn<Garaj, Integer> garajTablokatsayisi;

    @FXML
    private TableColumn<Garaj, Integer> garajTablometrekare;

    @FXML
    private TableColumn<Garaj, Integer> garajTablokapasite;

    @FXML
    private TextField garajAd;

    @FXML
    private TextField garajOdasayisi;

    @FXML
    private TextField garajKatsayisi;

    @FXML
    private TextField garajMetrekare;

    @FXML
    private TextField garajKapasite;

    @FXML
    private Label GarajLabel;

    Garaj garaj = new Garaj();
    DosyaIslemleri ds = new DosyaIslemleri();
    ObservableList<Garaj> listele = FXCollections.observableArrayList();

    @FXML
    void Ekle(ActionEvent event) {
        garaj.setAd(garajAd.getText().toString());
        garaj.setOdaSayisi(Integer.valueOf(garajOdasayisi.getText().toString()));
        garaj.setKatSayisi(Integer.valueOf(garajKatsayisi.getText().toString()));
        garaj.setMetrekare(Integer.valueOf(garajMetrekare.getText().toString()));
        garaj.setKapasite(Integer.valueOf(garajKapasite.getText().toString()));
        ds.GarajEkle(garaj.getAd(), garaj.getOdaSayisi(), garaj.getKatSayisi(), garaj.getMetrekare(), garaj.getKapasite());

        GarajLabel.setText(garaj.mesaj());
    }

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Tesissecimekrani.fxml"));
        GarajPane.getChildren().setAll(pane);

    }

    @FXML
    void Yenile(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Garaj.fxml"));
        GarajPane.getChildren().setAll(pane);

    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File brnts = new File("Garaj.txt");
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
                    listele.add(new Garaj(ad, odaSayisi, katSayisi, metrekare, kapasite));
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
        GarajTablo.setItems(listele);
        garajTabload.setCellValueFactory(new PropertyValueFactory<Garaj, String>("ad"));
        garajTabloodasayisi.setCellValueFactory(new PropertyValueFactory<Garaj, Integer>("odaSayisi"));
        garajTablokatsayisi.setCellValueFactory(new PropertyValueFactory<Garaj, Integer>("katSayisi"));
        garajTablometrekare.setCellValueFactory(new PropertyValueFactory<Garaj, Integer>("metrekare"));
        garajTablokapasite.setCellValueFactory(new PropertyValueFactory<Garaj, Integer>("kapasite"));

    }
    // TODO
}
