package araclar;

public class Tanklar extends PaletliAraclar {

    public Tanklar() {
    }

    public Tanklar(String Ad, String Hiz, String Agirlik, String MotorHacim, String DepoKapasitesi) {
        super(Ad, Hiz, Agirlik, MotorHacim, DepoKapasitesi);
    }

    @Override
    public String mesaj() {
        return "Tank Eklendi";
    }
}
