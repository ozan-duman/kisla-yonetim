package personel;

public class Subay extends AskeriPersonel {

    protected String KayitTarihi;

    public Subay() {
        super();
    }

    public Subay(String Ad, String Soyad, String DogumYeri, String DogumTarihi, String Rutbe, String KayitTarihi) {
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
        return "Subay Eklendi";
    }

}
