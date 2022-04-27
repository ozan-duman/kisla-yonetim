package araclar;

public class SivilArac extends TekerlekliAraclar {

    public SivilArac() {
    }

    public SivilArac(String Ad, String Hiz, String Agirlik, String MotorHacim, String TekerSayisi) {
        super(Ad, Hiz, Agirlik, MotorHacim, TekerSayisi);
    }

    @Override
    public String mesaj() {
        return "Sivil Araç Eklendi";
    }
}
