package personel;

public class AskeriPersonel extends Personel {

    protected String Rutbe;

    public AskeriPersonel() {
        super();
    }

    public AskeriPersonel(String Ad, String Soyad, String DogumYeri, String DogumTarihi, String Rutbe) {
        super(Ad, Soyad, DogumYeri, DogumTarihi);
        setRutbe(Rutbe);
    }

    public String getRutbe() {
        return Rutbe;
    }

    public void setRutbe(String Rutbe) {
        this.Rutbe = Rutbe;
    }

}
