package erzaklar;

public class ProteinUrunleri extends Erzaklar {

    int proteinMiktari;

    public ProteinUrunleri() {
        super();
    }

    public ProteinUrunleri(String ad, int sonKullanmaTarihi, int kaloriMiktari, int proteinMiktari, int adet) {
        super(ad, sonKullanmaTarihi, kaloriMiktari, proteinMiktari, adet);
        this.proteinMiktari=proteinMiktari;
    }

    public int getProteinMiktari() {
        return proteinMiktari;
    }

    public void setProteinMiktari(int proteinMiktari) {
        this.proteinMiktari = proteinMiktari;
    }

    @Override
    public String mesaj() {
        return "Protein Ürünü Eklendi";
    }
}
