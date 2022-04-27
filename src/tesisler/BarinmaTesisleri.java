package tesisler;

public class BarinmaTesisleri extends Tesisler {

    protected int binaYasi;
    

    public BarinmaTesisleri() {
        super();

    }

    public BarinmaTesisleri(String ad, int odaSayisi, int katSayisi, int metrekare, int kapasite, int binaYasi) {
        super(ad, odaSayisi, katSayisi, metrekare, kapasite);
        setBinaYasi(binaYasi);
        //hata olabilir
    }

    public BarinmaTesisleri(String ad, int odaSayisi, int katSayisi, int metrekare, int kapasite) {

        this.ad = ad;
        this.odaSayisi = odaSayisi;
        this.katSayisi = katSayisi;
        this.metrekare = metrekare;
    }

    public int getBinaYasi() {
        return binaYasi;
    }

    public void setBinaYasi(int binaYasi) {
        this.binaYasi = binaYasi;
    }
    
    
    @Override
     public String mesaj(){
        return "Barinma Tesis Eklendi";
    }

}
