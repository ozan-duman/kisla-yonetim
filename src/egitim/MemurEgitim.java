package egitim;

public class MemurEgitim extends SivilPersonelEgitim {

    public MemurEgitim() {
    }

    public MemurEgitim(String OgretmenAd, String OgretmenAlan, String EgitimAd, String HaftalikEgitimSaat, String EgitimTuru) {
        super(OgretmenAd, OgretmenAlan, EgitimAd, HaftalikEgitimSaat, EgitimTuru);
    }

    @Override
    public String mesaj() {
        return "Memur Eğitim Eklendi";
    }

}
