package personel;

public class Doktor extends SivilPersonel {

    public Doktor() {
        super();
    }

    public Doktor(String Ad, String Soyad, String DogumYeri, String DogumTarihi, String KayitTarihi) {
        super(Ad, Soyad, DogumYeri, DogumTarihi, KayitTarihi);
    }
    
    @Override
    public String mesaj() {
        return "Doktor Eklendi";
    }

}
