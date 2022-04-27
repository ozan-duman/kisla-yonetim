package personel;

public class Asci extends SivilPersonel {

    public Asci() {
        super();
    }

    public Asci(String Ad, String Soyad, String DogumYeri, String DogumTarihi, String KayitTarihi) {
        super(Ad, Soyad, DogumYeri, DogumTarihi, KayitTarihi);
    }
    
    @Override
    public String mesaj() {
        return "Aşçı Eklendi";
    }

}
