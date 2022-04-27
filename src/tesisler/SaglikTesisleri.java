package tesisler;

public class SaglikTesisleri extends Tesisler {

    protected int tedaviOdasi;

    public SaglikTesisleri() {
        super();
    }

    public SaglikTesisleri(String ad, int odaSayisi, int katSayisi, int metrekare, int kapasite, int tedaviOdasi) {
        super(ad, odaSayisi, katSayisi, metrekare, kapasite);
        setTedaviOdasi(tedaviOdasi);
    }
    
    public SaglikTesisleri(String ad, int odaSayisi, int katSayisi, int metrekare, int tedaviOdasi) {

        this.ad = ad;
        this.odaSayisi = odaSayisi;
        this.katSayisi = katSayisi;
        this.metrekare = metrekare;
    }

    public int getTedaviOdasi() {
        return tedaviOdasi;
    }

    public void setTedaviOdasi(int tedaviOdasi) {
        this.tedaviOdasi = tedaviOdasi;
    }
    
     @Override
     public String mesaj(){
        return "Saglik Tesis Eklendi";
    }
}
