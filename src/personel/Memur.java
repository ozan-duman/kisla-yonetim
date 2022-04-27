package personel;

public class Memur extends SivilPersonel {

    public Memur() {
        super();
    }

    public Memur(String Ad, String Soyad, String DogumYeri, String DogumTarihi, String KayitTarihi) {
        super(Ad, Soyad, DogumYeri, DogumTarihi, KayitTarihi);
    }

    @Override
    public String mesaj() {
        return "Memur Eklendi";
    }

}
