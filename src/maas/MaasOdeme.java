package maas;

public class MaasOdeme implements IMaas {

    private final int Nobet_ikramiye = 75;
    private final int Operasyon_ikramiye = 1500;
    protected String PersonelTuru;
    protected int OperasyonSayisi;
    protected int NobetSayisi;
    protected String PersonelNumarasi;
    protected int Maas;

    public MaasOdeme() {
    }

    public MaasOdeme(String PersonelTuru, int OperasyonSayisi, int NobetSayisi, String PersonelNumarasi, int Maas) {
        this.PersonelTuru = PersonelTuru;
        this.OperasyonSayisi = OperasyonSayisi;
        this.NobetSayisi = NobetSayisi;
        this.PersonelNumarasi = PersonelNumarasi;
        this.Maas = Maas;
    }

    @Override
    public int SubayOdeme(int NobetSayisi, int OperasyonSayisi) {
        int SubayMaas = 6500;
        int toplamMaas;
        toplamMaas = (Nobet_ikramiye * NobetSayisi) + (Operasyon_ikramiye * OperasyonSayisi) + SubayMaas;
        return toplamMaas;
    }

    @Override
    public int AstsubayOdeme(int NobetSayisi, int OperasyonSayisi) {
        int AstsubayMaas = 5000;
        int toplamMaas;
        toplamMaas = (Nobet_ikramiye * NobetSayisi) + (Operasyon_ikramiye * OperasyonSayisi) + AstsubayMaas;
        return toplamMaas;
    }

    @Override
    public int ErOdeme(int NobetSayisi, int OperasyonSayisi) {
        int ErMaas = 4500;
        int toplamMaas;
        toplamMaas = (Nobet_ikramiye * NobetSayisi) + (Operasyon_ikramiye * OperasyonSayisi) + ErMaas;
        return toplamMaas;
    }

    @Override
    public int DoktorOdeme(int NobetSayisi, int OperasyonSayisi) {
        int DoktorMaas = 8000;
        int toplamMaas;
        toplamMaas = (Nobet_ikramiye * NobetSayisi) + (Operasyon_ikramiye * OperasyonSayisi) + DoktorMaas;
        return toplamMaas;
    }

    @Override
    public int MemurOdeme(int NobetSayisi) {
        int MemurMaas = 4000;
        int toplamMaas;
        toplamMaas = (Nobet_ikramiye * NobetSayisi) + MemurMaas;
        return toplamMaas;
    }

    @Override
    public int AsciOdeme(int NobetSayisi) {
        int AsciMaas = 4000;
        int toplamMaas;
        toplamMaas = (Nobet_ikramiye * NobetSayisi) + AsciMaas;
        return toplamMaas;
    }

    public String mesaj() {
        return "Ödeme Başarılı";
    }

    public String getPersonelTuru() {
        return PersonelTuru;
    }

    public void setPersonelTuru(String PersonelTuru) {
        this.PersonelTuru = PersonelTuru;
    }

    public int getOperasyonSayisi() {
        return OperasyonSayisi;
    }

    public void setOperasyonSayisi(int OperasyonSayisi) {
        this.OperasyonSayisi = OperasyonSayisi;
    }

    public int getNobetSayisi() {
        return NobetSayisi;
    }

    public void setNobetSayisi(int NobetSayisi) {
        this.NobetSayisi = NobetSayisi;
    }

    public String getPersonelNumarasi() {
        return PersonelNumarasi;
    }

    public void setPersonelNumarasi(String PersonelNumarasi) {
        this.PersonelNumarasi = PersonelNumarasi;
    }

    public int getMaas() {
        return Maas;
    }

    public void setMaas(int Maas) {
        this.Maas = Maas;
    }
}
