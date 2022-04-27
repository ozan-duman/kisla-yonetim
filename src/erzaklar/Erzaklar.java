package erzaklar;

public class Erzaklar {

    protected String ad;
    protected int sonKullanmaTarihi;
    protected int kaloriMiktari;
    protected int enerjiMiktari;
    protected int adet;
    protected int Agirlik;

    public Erzaklar() {
    }

    public Erzaklar(String ad, int sonKullanmaTarihi, int kaloriMiktari, int enerjiMiktari, int adet) {

        this.ad = ad;
        this.sonKullanmaTarihi = sonKullanmaTarihi;
        this.kaloriMiktari = kaloriMiktari;
        this.enerjiMiktari = enerjiMiktari;
        this.adet = adet;
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

    public int getKaloriMiktari() {
        return kaloriMiktari;
    }

    public void setKaloriMiktari(int kaloriMiktari) {
        this.kaloriMiktari = kaloriMiktari;
    }

    public int getEnerjiMiktari() {
        return enerjiMiktari;
    }

    public void setEnerjiMiktari(int enerjiMiktari) {
        this.enerjiMiktari = enerjiMiktari;
    }

    public int getAgirlik() {
        return Agirlik;
    }

    public void setAgirlik(int Agirlik) {
        this.Agirlik = Agirlik;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    public String mesaj() {
        return "Ekrana yazıldı";
    }

}
