package araclar;

public class Araclar {

    protected String Ad;
    protected String Hiz;
    protected String Agirlik;
    protected String MotorHacim;

    public Araclar() {

    }

    public Araclar(String Ad, String Hiz, String Agirlik, String MotorHacim) {
        this.Ad = Ad;
        this.Hiz = Hiz;
        this.Agirlik = Agirlik;
        this.MotorHacim = MotorHacim;
    }

    public String getAd() {
        return Ad;
    }

    public void setAd(String Ad) {
        this.Ad = Ad;
    }

    public String getHiz() {
        return Hiz;
    }

    public void setHiz(String Hiz) {
        this.Hiz = Hiz;
    }

    public String getAgirlik() {
        return Agirlik;
    }

    public void setAgirlik(String Agirlik) {
        this.Agirlik = Agirlik;
    }

    public String getMotorHacim() {
        return MotorHacim;
    }

    public void setMotorHacim(String MotorHacim) {
        this.MotorHacim = MotorHacim;
    }

    public String mesaj() {
        return "Ekrana yazıldı";
    }

}
