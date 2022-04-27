package personel;

public class Er extends AskeriPersonel {

    protected String KayitTarihi;

    public Er() {
        super();
    }

    public Er(String Ad, String Soyad, String DogumYeri, String DogumTarihi, String Rutbe, String KayitTarihi) {
        super(Ad, Soyad, DogumYeri, DogumTarihi, Rutbe);
        setKayitTarihi(KayitTarihi);
    }

    public String getKayitTarihi() {
        return KayitTarihi;
    }

    public void setKayitTarihi(String KayitTarihi) {
        this.KayitTarihi = KayitTarihi;
    }
    
    @Override
    public String mesaj() {
        return "Er Eklendi";
    }

}
