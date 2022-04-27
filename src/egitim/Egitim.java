package egitim;

public class Egitim {

    protected String EgitimAd;
    protected String HaftalikEgitimSaat;
    protected String EgitimTuru;

    public Egitim() {

    }

    public Egitim(String EgitimAd, String HaftalikEgitimSaat, String EgitimTuru) {
        this.EgitimAd = EgitimAd;
        this.HaftalikEgitimSaat = HaftalikEgitimSaat;
        this.EgitimTuru = EgitimTuru;
    }

    public String getEgitimAd() {
        return EgitimAd;
    }

    public void setEgitimAd(String EgitimAd) {
        this.EgitimAd = EgitimAd;
    }

    public String getHaftalikEgitimSaat() {
        return HaftalikEgitimSaat;
    }

    public void setHaftalikEgitimSaat(String HaftalikEgitimSaat) {
        this.HaftalikEgitimSaat = HaftalikEgitimSaat;
    }

    public String getEgitimTuru() {
        return EgitimTuru;
    }

    public void setEgitimTuru(String EgitimTuru) {
        this.EgitimTuru = EgitimTuru;
    }

    public String mesaj() {
        return "Ekrana yazıldı";
    }

}
