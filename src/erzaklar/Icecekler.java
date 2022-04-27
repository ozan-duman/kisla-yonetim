package erzaklar;

public class Icecekler extends Erzaklar {

    int litre;

    public Icecekler() {
        super();
    }

    public Icecekler(String ad, int sonKullanmaTarihi, int kaloriMiktari, int litre, int adet) {
        super(ad, sonKullanmaTarihi, kaloriMiktari, litre, adet);
        this.litre = litre;
    }

    public int getLitre() {
        return litre;
    }

    public void setLitre(int litre) {
        this.litre = litre;
    }

    @Override
    public String mesaj() {
        return "İçeçek Eklendi";
    }

}
