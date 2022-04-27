package araclar;

public class AskeriArac extends TekerlekliAraclar {

    public AskeriArac() {
    }

    public AskeriArac(String Ad, String Hiz, String Agirlik, String MotorHacim, String TekerSayisi) {
        super(Ad, Hiz, Agirlik, MotorHacim, TekerSayisi);
    }
    
    @Override
    public String mesaj() {
        return "Askeri Araç Eklendi";
    }
}
