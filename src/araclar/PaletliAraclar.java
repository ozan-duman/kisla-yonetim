package araclar;

public class PaletliAraclar extends Araclar {

    protected String DepoKapasitesi;

    public PaletliAraclar() {
    }

    public PaletliAraclar(String Ad, String Hiz, String Agirlik, String MotorHacim, String DepoKapasitesi) {
        super(Ad, Hiz, Agirlik, MotorHacim);
        this.DepoKapasitesi = DepoKapasitesi;
    }

    public String getDepoKapasitesi() {
        return DepoKapasitesi;
    }

    public void setDepoKapasitesi(String DepoKapasitesi) {
        this.DepoKapasitesi = DepoKapasitesi;
    }

}
