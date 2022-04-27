package erzaklar;

public class Ilaclar {

    protected String ad;
    protected int sonKullanmaTarihi;
    protected int gunlukDozMiktarı;
    protected String yanEtkileri;

    public Ilaclar(String ad, int sonKullanmaTarihi, int gunlukDozMiktarı, String yanEtkileri) {
        this.ad = ad;
        this.sonKullanmaTarihi = sonKullanmaTarihi;
        this.gunlukDozMiktarı = gunlukDozMiktarı;
        this.yanEtkileri = yanEtkileri;
    }

    public Ilaclar() {

    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getSonKullanmaTarihi() {
        return sonKullanmaTarihi;
    }

    public void setSonKullanmaTarihi(int sonKullanmaTarihi) {
        this.sonKullanmaTarihi = sonKullanmaTarihi;
    }

    public int getGunlukDozMiktarı() {
        return gunlukDozMiktarı;
    }

    public void setGunlukDozMiktarı(int gunlukDozMiktarı) {
        this.gunlukDozMiktarı = gunlukDozMiktarı;
    }

    public String getYanEtkileri() {
        return yanEtkileri;
    }

    public void setYanEtkileri(String yanEtkileri) {
        this.yanEtkileri = yanEtkileri;
    }

    public String mesaj() {
        return "İlaç Eklendi";
    }

}
