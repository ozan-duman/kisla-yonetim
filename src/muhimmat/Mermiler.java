package muhimmat;

public class Mermiler extends Muhimmat {

    protected String boyut;

    public Mermiler() {
        super();
    }

    public Mermiler(String boyut, String Ad, String SeriNo, String Adet) {
        super(Ad, SeriNo, Adet);
        this.boyut = boyut;
    }

    public String getBoyut() {
        return boyut;
    }

    public void setBoyut(String boyut) {
        this.boyut = boyut;
    }
    
    @Override
    public String mesaj() {
        return "Mermi Eklendi";
    }

}
