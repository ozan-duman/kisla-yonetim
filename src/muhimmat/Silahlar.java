package muhimmat;

public class Silahlar extends Muhimmat {

    protected String Tur;

    public Silahlar() {
        super();
    }

    public Silahlar(String Ad, String SeriNo, String Adet, String Tur) {
        super(Ad, SeriNo, Adet);
        this.Tur = Tur;
    }

    public String getTur() {
        return Tur;
    }

    public void setTur(String Tur) {
        this.Tur = Tur;
    }

    @Override
    public String mesaj() {
        return "Silah Eklendi";
    }
}
