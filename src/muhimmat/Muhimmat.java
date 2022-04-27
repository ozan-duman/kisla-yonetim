package muhimmat;

public class Muhimmat {

    protected String Ad;
    protected String SeriNo;
    protected String Adet;

    public Muhimmat() {
    }

    public Muhimmat(String Ad, String SeriNo, String Adet) {
        this.Ad = Ad;
        this.SeriNo = SeriNo;
        this.Adet = Adet;
    }

    public String getAd() {
        return Ad;
    }

    public void setAd(String Ad) {
        this.Ad = Ad;
    }

    public String getSeriNo() {
        return SeriNo;
    }

    public void setSeriNo(String SeriNo) {
        this.SeriNo = SeriNo;
    }

    public String getAdet() {
        return Adet;
    }

    public void setAdet(String Adet) {
        this.Adet = Adet;
    }

    public String mesaj() {
        return "Ekrana yazıldı";
    }

}
