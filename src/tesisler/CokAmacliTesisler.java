package tesisler;

public class CokAmacliTesisler extends Tesisler {

    protected String etkinlikGunleri;

    public CokAmacliTesisler() {
        super();

    }

    public CokAmacliTesisler(String ad, int odaSayisi, int katSayisi, int metrekare, int kapasite, String etkinlikGunleri) {
        super(ad, odaSayisi, katSayisi, metrekare, kapasite);
        setEtkinlikGunleri(etkinlikGunleri);

    }

    public CokAmacliTesisler(String ad, int odaSayisi, int katSayisi, int metrekare, int kapasite) {

        this.ad = ad;
        this.odaSayisi = odaSayisi;
        this.katSayisi = katSayisi;
        this.metrekare = metrekare;
    }

    public String getEtkinlikGunleri() {
        return etkinlikGunleri;
    }

    public void setEtkinlikGunleri(String etkinlikGunleri) {
        this.etkinlikGunleri = etkinlikGunleri;
    }

}
