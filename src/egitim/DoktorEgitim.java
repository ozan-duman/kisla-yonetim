package egitim;

public class DoktorEgitim extends SivilPersonelEgitim {

    public DoktorEgitim() {
    }

    public DoktorEgitim(String OgretmenAd, String OgretmenAlan, String EgitimAd, String HaftalikEgitimSaat, String EgitimTuru) {
        super(OgretmenAd, OgretmenAlan, EgitimAd, HaftalikEgitimSaat, EgitimTuru);
    }

    @Override
    public String mesaj() {
        return "Doktor Eğitim Eklendi";
    }
}
