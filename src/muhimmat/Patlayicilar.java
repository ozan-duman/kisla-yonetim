package muhimmat;

public class Patlayicilar extends Muhimmat {

    protected String EtkiliOlduguMenzil;

    public Patlayicilar() {
        super();
    }

    public Patlayicilar(String Ad, String SeriNo, String Adet, String EtkiliOlduguMenzil) {
        super(Ad, SeriNo, Adet);
        this.EtkiliOlduguMenzil = EtkiliOlduguMenzil;
    }

    public String getEtkiliOlduguMenzil() {
        return EtkiliOlduguMenzil;
    }

    public void setEtkiliOlduguMenzil(String EtkiliOlduguMenzil) {
        this.EtkiliOlduguMenzil = EtkiliOlduguMenzil;
    }

    @Override
    public String mesaj() {
        return "Patlayıcı Eklendi";
    }
}
