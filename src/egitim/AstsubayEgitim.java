package egitim;

public class AstsubayEgitim extends AskeriPersonelEgitim {

    public AstsubayEgitim() {
    }

    public AstsubayEgitim(String EgitimciKomutanAd, String EgitilenAskerNumara, String EgitimAd, String HaftalikEgitimSaat, String EgitimTuru) {
        super(EgitimciKomutanAd, EgitilenAskerNumara, EgitimAd, HaftalikEgitimSaat, EgitimTuru);
    }

    @Override
    public String mesaj() {
        return "Astsubay Eğitim Eklendi";
    }
}
