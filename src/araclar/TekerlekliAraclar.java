package araclar;

public class TekerlekliAraclar extends Araclar {

    protected String TekerSayisi;

    public TekerlekliAraclar() {
    }

    public TekerlekliAraclar(String Ad, String Hiz, String Agirlik, String MotorHacim, String TekerSayisi) {
        super(Ad, Hiz, Agirlik, MotorHacim);
        this.TekerSayisi = TekerSayisi;
    }

    public String getTekerSayisi() {
        return TekerSayisi;
    }

    public void setTekerSayisi(String TekerSayisi) {
        this.TekerSayisi = TekerSayisi;
    }

    @Override
    public String mesaj() {
        return "Tekerlekli Araç Eklendi";
    }

}
