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
import maas.MaasOdeme;

public class MaasController implements Initializable {

    @FXML
    private TextField operasyonF;

    @FXML
    private TextField NobetF;

    @FXML
    private TextField NumaraF;

    @FXML
    private TableView<MaasOdeme> OdemeTablo;

    @FXML
    private TableColumn<MaasOdeme, String> PersonelTablo;

    @FXML
    private TableColumn<MaasOdeme, Integer> OperasyonTablo;

    @FXML
    private TableColumn<MaasOdeme, Integer> NobetTablo;

    @FXML
    private TableColumn<MaasOdeme, String> NumaraTablo;

    @FXML
    private TableColumn<MaasOdeme, Integer> MaasTablo;

    @FXML
    private AnchorPane MaasPane;

    @FXML
    private Label MaasLabel;

    MaasOdeme maas = new MaasOdeme();
    DosyaIslemleri ds = new DosyaIslemleri();
    ObservableList<MaasOdeme> listele = FXCollections.observableArrayList();

    @FXML
    void Geri(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Anasayfa.fxml"));
        MaasPane.getChildren().setAll(pane);
    }

    @FXML
    void Ode(ActionEvent event) throws IOException {
        ds.MaasOde(maas.getPersonelTuru(), maas.getOperasyonSayisi(), maas.getNobetSayisi(), maas.getPersonelNumarasi(), maas.getMaas());
        MaasLabel.setText(maas.mesaj());
    }

    @FXML
    void Yenile(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Maas.fxml"));
        MaasPane.getChildren().setAll(pane);
    }

    @FXML
    void asciMaas(ActionEvent event) throws IOException {
        maas.setOperasyonSayisi(Integer.valueOf(operasyonF.getText().toString()));
        maas.setNobetSayisi(Integer.valueOf(NobetF.getText().toString()));
        maas.setPersonelNumarasi(NumaraF.getText().toString());
        maas.setMaas(maas.AsciOdeme(maas.getNobetSayisi()));
        maas.setPersonelTuru("Aşçı");
    }

    @FXML
    void astsubayMaas(ActionEvent event) throws IOException {
        maas.setOperasyonSayisi(Integer.valueOf(operasyonF.getText().toString()));
        maas.setNobetSayisi(Integer.valueOf(NobetF.getText().toString()));
        maas.setPersonelNumarasi(NumaraF.getText().toString());
        maas.setMaas(maas.AstsubayOdeme(maas.getOperasyonSayisi(), maas.getNobetSayisi()));
        maas.setPersonelTuru("Astsubay");
    }

    @FXML
    void doktorMaas(ActionEvent event) throws IOException {
        maas.setOperasyonSayisi(Integer.valueOf(operasyonF.getText().toString()));
        maas.setNobetSayisi(Integer.valueOf(NobetF.getText().toString()));
        maas.setPersonelNumarasi(NumaraF.getText().toString());
        maas.setMaas(maas.DoktorOdeme(maas.getOperasyonSayisi(), maas.getNobetSayisi()));
        maas.setPersonelTuru("Doktor");
    }

    @FXML
    void erMaas(ActionEvent event) throws IOException {
        maas.setOperasyonSayisi(Integer.valueOf(operasyonF.getText().toString()));
        maas.setNobetSayisi(Integer.valueOf(NobetF.getText().toString()));
        maas.setPersonelNumarasi(NumaraF.getText().toString());
        maas.setMaas(maas.ErOdeme(maas.getOperasyonSayisi(), maas.getNobetSayisi()));
        maas.setPersonelTuru("Er");
    }

    @FXML
    void memurMaas(ActionEvent event) throws IOException {
        maas.setOperasyonSayisi(Integer.valueOf(operasyonF.getText().toString()));
        maas.setNobetSayisi(Integer.valueOf(NobetF.getText().toString()));
        maas.setPersonelNumarasi(NumaraF.getText().toString());
        maas.setMaas(maas.MemurOdeme(maas.getNobetSayisi()));
        maas.setPersonelTuru("Memur");
    }

    @FXML
    void subayMaas(ActionEvent event) throws IOException {
        maas.setOperasyonSayisi(Integer.valueOf(operasyonF.getText().toString()));
        maas.setNobetSayisi(Integer.valueOf(NobetF.getText().toString()));
        maas.setPersonelNumarasi(NumaraF.getText().toString());
        maas.setMaas(maas.SubayOdeme(maas.getNobetSayisi(), maas.getOperasyonSayisi()));
        maas.setPersonelTuru("Subay");
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File maas = new File("Maas.txt");
        if (!maas.exists()) {
            try {
                maas.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(maas);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String line;

        BufferedReader br = new BufferedReader(fileReader);
        int i = 0;

        try {
            byte ax = 0;
            String PersonelTuru = "", PersonelNumarasi = "";
            int OperasyonSayisi = 0, NobetSayisi = 0, Maas = 0;
            while ((line = br.readLine()) != null) {
                ax++;
                if (ax == 1) {
                    PersonelTuru = line;
                } else if (ax == 2) {
                    OperasyonSayisi = Integer.valueOf(line);
                } else if (ax == 3) {
                    NobetSayisi = Integer.valueOf(line);
                } else if (ax == 4) {
                    PersonelNumarasi = line;
                } else if (ax == 5) {
                    Maas = Integer.valueOf(line);
                } else if (ax == 6) {
                    listele.add(new MaasOdeme(PersonelTuru, OperasyonSayisi, NobetSayisi, PersonelNumarasi, Maas));
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
        OdemeTablo.setItems(listele);
        PersonelTablo.setCellValueFactory(new PropertyValueFactory<MaasOdeme, String>("PersonelTuru"));
        OperasyonTablo.setCellValueFactory(new PropertyValueFactory<MaasOdeme, Integer>("OperasyonSayisi"));
        NobetTablo.setCellValueFactory(new PropertyValueFactory<MaasOdeme, Integer>("NobetSayisi"));
        NumaraTablo.setCellValueFactory(new PropertyValueFactory<MaasOdeme, String>("PersonelNumarasi"));
        MaasTablo.setCellValueFactory(new PropertyValueFactory<MaasOdeme, Integer>("Maas"));
    }

}
