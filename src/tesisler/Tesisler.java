package tesisler;

public class Tesisler {

    protected String ad;
    protected int odaSayisi;
    protected int katSayisi;
    protected int metrekare;
    protected int kapasite;

    public Tesisler() {
    }

    public Tesisler(String ad, int odaSayisi, int katSayisi, int metrekare, int kapasite) {

        this.ad = ad;
        this.odaSayisi = odaSayisi;
        this.katSayisi = katSayisi;
        this.metrekare = metrekare;
        this.kapasite = kapasite;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getOdaSayisi() {
        return odaSayisi;
    }

    public void setOdaSayisi(int odaSayisi) {
        this.odaSayisi = odaSayisi;
    }

    public int getKatSayisi() {
        return katSayisi;
    }

    public void setKatSayisi(int katSayisi) {
        this.katSayisi = katSayisi;
    }

    public int getMetrekare() {
        return metrekare;
    }

    public void setMetrekare(int metrekare) {
        this.metrekare = metrekare;
    }

    public int getKapasite() {
        return kapasite;
    }

    public void setKapasite(int kapasite) {
        this.kapasite = kapasite;
    }
    
     public String mesaj(){
        return "Ekrana yazıldı";
    }
}
