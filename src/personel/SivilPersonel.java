package personel;

public class SivilPersonel extends Personel {

    protected String KayitTarihi;

    public SivilPersonel() {
        super();
    }

    public SivilPersonel(String Ad, String Soyad, String DogumYeri, String DogumTarihi, String KayitTarihi) {
        super(Ad, Soyad, DogumYeri, DogumTarihi);
        setKayitTarihi(KayitTarihi);
    }

    public String getKayitTarihi() {
        return KayitTarihi;
    }

    public void setKayitTarihi(String KayitTarihi) {
        this.KayitTarihi = KayitTarihi;
    }

}
