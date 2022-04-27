package personel;

public class Astsubay extends AskeriPersonel {

    protected String KayitTarihi;
    protected int AstsubayMaas;

    public int getAstsubayMaas() {
        return AstsubayMaas;
    }

    public void setAstsubayMaas(int AstsubayMaas) {
        this.AstsubayMaas = AstsubayMaas;
    }

    public Astsubay() {
        super();
    }

    public Astsubay(String Ad, String Soyad, String DogumYeri, String DogumTarihi, String Rutbe, String KayitTarihi) {
        super(Ad, Soyad, DogumYeri, DogumTarihi, Rutbe);
        setKayitTarihi(KayitTarihi);
    }

    public String getKayitTarihi() {
        return KayitTarihi;
    }

    public void setKayitTarihi(String KayitTarihi) {
        this.KayitTarihi = KayitTarihi;
    }

    @Override
    public String mesaj() {
        return "Astsubay Eklendi";
    }

}
