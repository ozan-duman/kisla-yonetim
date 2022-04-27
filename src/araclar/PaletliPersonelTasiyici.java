package araclar;

public class PaletliPersonelTasiyici extends PaletliAraclar {

    public PaletliPersonelTasiyici() {
    }

    public PaletliPersonelTasiyici(String Ad, String Hiz, String Agirlik, String MotorHacim, String DepoKapasitesi) {
        super(Ad, Hiz, Agirlik, MotorHacim, DepoKapasitesi);
    }

    @Override
    public String mesaj() {
        return "Paletli Personel Taşıyıcı Eklendi";
    }
}
