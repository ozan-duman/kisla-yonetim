package erzaklar;

public class KarbonhidratUrunleri extends Erzaklar {

    public KarbonhidratUrunleri() {
        super();

    }

    public KarbonhidratUrunleri(String ad, int sonKullanmaTarihi, int kaloriMiktarı, int enerjiMiktarı, int adet) {
        super(ad, sonKullanmaTarihi, kaloriMiktarı, enerjiMiktarı, adet);

    }

    @Override
    public String mesaj() {
        return "Karbonhidrat Ürünü Eklendi";
    }

}
