package egitim;

public class SivilPersonelEgitim extends Egitim {

    protected String OgretmenAd;
    protected String OgretmenAlan;

    public SivilPersonelEgitim() {
        super();
    }

    public SivilPersonelEgitim(String OgretmenAd, String OgretmenAlan, String EgitimAd, String HaftalikEgitimSaat, String EgitimTuru) {
        super(EgitimAd, HaftalikEgitimSaat, EgitimTuru);
        setOgretmenAd(OgretmenAd);
        setOgretmenAlan(OgretmenAlan);
    }

    public String getOgretmenAd() {
        return OgretmenAd;
    }

    public void setOgretmenAd(String OgretmenAd) {
        this.OgretmenAd = OgretmenAd;
    }

    public String getOgretmenAlan() {
        return OgretmenAlan;
    }

    public void setOgretmenAlan(String OgretmenAlan) {
        this.OgretmenAlan = OgretmenAlan;
    }

}
