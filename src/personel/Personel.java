package personel;

public class Personel {

    protected String Ad;
    protected String Soyad;
    protected String DogumYeri;
    protected String DogumTarihi;

    public Personel() {
    }

    public Personel(String Ad, String Soyad, String DogumYeri, String DogumTarihi) {
        this.Ad = Ad;
        this.Soyad = Soyad;
        this.DogumYeri = DogumYeri;
        this.DogumTarihi = DogumTarihi;
    }

    public String getAd() {
        return Ad;
    }

    public void setAd(String Ad) {
        this.Ad = Ad;
    }

    public String getSoyad() {
        return Soyad;
    }

    public void setSoyad(String Soyad) {
        this.Soyad = Soyad;
    }

    public String getDogumYeri() {
        return DogumYeri;
    }

    public void setDogumYeri(String DogumYeri) {
        this.DogumYeri = DogumYeri;
    }

    public String getDogumTarihi() {
        return DogumTarihi;
    }

    public void setDogumTarihi(String DogumTarihi) {
        this.DogumTarihi = DogumTarihi;
    }
    
    public String mesaj(){
        return "Ekrana yazıldı";
    }

}
