package egitim;

public class AskeriPersonelEgitim extends Egitim {

    protected String EgitimciKomutanAd;
    protected String EgitilenAskerNumara;

    public AskeriPersonelEgitim() {
        super();
    }

    public AskeriPersonelEgitim(String EgitimciKomutanAd, String EgitilenAskerNumara, String EgitimAd, String HaftalikEgitimSaat, String EgitimTuru) {
        super(EgitimAd, HaftalikEgitimSaat, EgitimTuru);
        setEgitimciKomutanAd(EgitimciKomutanAd);
        setEgitilenAskerNumara(EgitilenAskerNumara);
    }

    public String getEgitimciKomutanAd() {
        return EgitimciKomutanAd;
    }

    public void setEgitimciKomutanAd(String EgitimciKomutanAd) {
        this.EgitimciKomutanAd = EgitimciKomutanAd;
    }

    public String getEgitilenAskerNumara() {
        return EgitilenAskerNumara;
    }

    public void setEgitilenAskerNumara(String EgitilenAskerNumara) {
        this.EgitilenAskerNumara = EgitilenAskerNumara;
    }

}
