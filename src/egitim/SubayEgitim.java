package egitim;

public class SubayEgitim extends AskeriPersonelEgitim {

    public SubayEgitim() {
    }

    public SubayEgitim(String EgitimAd, String HaftalikEgitimSaat, String EgitimTuru, String EgitimciKomutanAd, String EgitilenAskerNumara) {
        super(EgitimciKomutanAd, EgitilenAskerNumara, EgitimAd, HaftalikEgitimSaat, EgitimTuru);
    }

    @Override
    public String mesaj() {
        return "Subay Eğitim Eklendi";
    }

}
