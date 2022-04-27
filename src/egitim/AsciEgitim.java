package egitim;

public class AsciEgitim extends SivilPersonelEgitim {

    public AsciEgitim() {
    }

    public AsciEgitim(String OgretmenAd, String OgretmenAlan, String EgitimAd, String HaftalikEgitimSaat, String EgitimTuru) {
        super(OgretmenAd, OgretmenAlan, EgitimAd, HaftalikEgitimSaat, EgitimTuru);
    }

    @Override
    public String mesaj() {
        return "Aşçı Eğitim Eklendi";
    }
}
