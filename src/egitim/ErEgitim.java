package egitim;

public class ErEgitim extends AskeriPersonelEgitim {

    public ErEgitim() {
    }

    public ErEgitim(String EgitimciKomutanAd, String EgitilenAskerNumara, String EgitimAd, String HaftalikEgitimSaat, String EgitimTuru) {
        super(EgitimciKomutanAd, EgitilenAskerNumara, EgitimAd, HaftalikEgitimSaat, EgitimTuru);
    }

    @Override
    public String mesaj() {
        return "Er Eğitim Eklendi";
    }

}
