package dosyaIslemleri;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DosyaIslemleri {

    public void AstsubayEkle(String Ad, String Soyad, String DogumYeri, String DogumTarihi, String Rutbe, String KayitTarihi) {
        File astsby = new File("Astsubay.txt");
        if (!astsby.exists()) {
            try {
                astsby.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(astsby, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(Ad);
        out.println(Soyad);
        out.println(DogumYeri);
        out.println(DogumTarihi);
        out.println(Rutbe);
        out.println(KayitTarihi);
        out.println("-");
        out.close();
    }

    public void ErEkle(String Ad, String Soyad, String DogumYeri, String DogumTarihi, String Rutbe, String KayitTarihi) {
        File er = new File("Er.txt");
        if (!er.exists()) {
            try {
                er.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(er, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(Ad);
        out.println(Soyad);
        out.println(DogumYeri);
        out.println(DogumTarihi);
        out.println(Rutbe);
        out.println(KayitTarihi);
        out.println("-");
        out.close();
    }

    public void SubayEkle(String Ad, String Soyad, String DogumYeri, String DogumTarihi, String Rutbe, String KayitTarihi) {
        File sby = new File("Subay.txt");
        if (!sby.exists()) {
            try {
                sby.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(sby, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(Ad);
        out.println(Soyad);
        out.println(DogumYeri);
        out.println(DogumTarihi);
        out.println(Rutbe);
        out.println(KayitTarihi);
        out.println("-");
        out.close();
    }

    public void DoktorEkle(String Ad, String Soyad, String DogumYeri, String DogumTarihi, String KayitTarihi) {
        File dr = new File("Doktor.txt");
        if (!dr.exists()) {
            try {
                dr.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(dr, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(Ad);
        out.println(Soyad);
        out.println(DogumYeri);
        out.println(DogumTarihi);
        out.println(KayitTarihi);
        out.println("-");
        out.close();
    }

    public void MemurEkle(String Ad, String Soyad, String DogumYeri, String DogumTarihi, String KayitTarihi) {
        File memur = new File("Memur.txt");
        if (!memur.exists()) {
            try {
                memur.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(memur, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(Ad);
        out.println(Soyad);
        out.println(DogumYeri);
        out.println(DogumTarihi);
        out.println(KayitTarihi);
        out.println("-");
        out.close();
    }

    public void AsciEkle(String Ad, String Soyad, String DogumYeri, String DogumTarihi, String KayitTarihi) {
        File asci = new File("Asci.txt");
        if (!asci.exists()) {
            try {
                asci.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(asci, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(Ad);
        out.println(Soyad);
        out.println(DogumYeri);
        out.println(DogumTarihi);
        out.println(KayitTarihi);
        out.println("-");
        out.close();
    }

    public void SubayEgitimEkle(String EgitimAd, String HaftalikEgitimSaat, String EgitimTuru, String EgitimciKomutanAd, String EgitilenAskerNumara) {
        File sbyegtm = new File("SubayEgitim.txt");
        if (!sbyegtm.exists()) {
            try {
                sbyegtm.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(sbyegtm, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(EgitimAd);
        out.println(HaftalikEgitimSaat);
        out.println(EgitimTuru);
        out.println(EgitimciKomutanAd);
        out.println(EgitilenAskerNumara);
        out.println("-");
        out.close();
    }

    public void AstsubayEgitimEkle(String EgitimAd, String HaftalikEgitimSaat, String EgitimTuru, String EgitimciKomutanAd, String EgitilenAskerNumara) {
        File astegtm = new File("AstsubayEgitim.txt");
        if (!astegtm.exists()) {
            try {
                astegtm.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(astegtm, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(EgitimAd);
        out.println(HaftalikEgitimSaat);
        out.println(EgitimTuru);
        out.println(EgitimciKomutanAd);
        out.println(EgitilenAskerNumara);
        out.println("-");
        out.close();
    }

    public void ErEgitimEkle(String EgitimAd, String HaftalikEgitimSaat, String EgitimTuru, String EgitimciKomutanAd, String EgitilenAskerNumara) {
        File eregtm = new File("ErEgitim.txt");
        if (!eregtm.exists()) {
            try {
                eregtm.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(eregtm, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(EgitimAd);
        out.println(HaftalikEgitimSaat);
        out.println(EgitimTuru);
        out.println(EgitimciKomutanAd);
        out.println(EgitilenAskerNumara);
        out.println("-");
        out.close();
    }

    public void AsciEgitimEkle(String OgretmenAd, String OgretmenAlan, String EgitimAd, String HaftalikEgitimSaat, String EgitimTuru) {
        File ascegtm = new File("AsciEgitim.txt");
        if (!ascegtm.exists()) {
            try {
                ascegtm.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(ascegtm, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(OgretmenAd);
        out.println(OgretmenAlan);
        out.println(EgitimAd);
        out.println(HaftalikEgitimSaat);
        out.println(EgitimTuru);
        out.println("-");
        out.close();
    }

    public void MemurEgitimEkle(String OgretmenAd, String OgretmenAlan, String EgitimAd, String HaftalikEgitimSaat, String EgitimTuru) {
        File mmregtm = new File("MemurEgitim.txt");
        if (!mmregtm.exists()) {
            try {
                mmregtm.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(mmregtm, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(OgretmenAd);
        out.println(OgretmenAlan);
        out.println(EgitimAd);
        out.println(HaftalikEgitimSaat);
        out.println(EgitimTuru);
        out.println("-");
        out.close();
    }

    public void DoktorEgitimEkle(String OgretmenAd, String OgretmenAlan, String EgitimAd, String HaftalikEgitimSaat, String EgitimTuru) {
        File dregtm = new File("DoktorEgitim.txt");
        if (!dregtm.exists()) {
            try {
                dregtm.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(dregtm, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(OgretmenAd);
        out.println(OgretmenAlan);
        out.println(EgitimAd);
        out.println(HaftalikEgitimSaat);
        out.println(EgitimTuru);
        out.println("-");
        out.close();
    }

    public void PaletliPersonelTasiyiciEkle(String Ad, String Hiz, String Agirlik, String MotorHacim, String DepoKapasitesi) {
        File ppt = new File("PaletliPersonelTasiyici.txt");
        if (!ppt.exists()) {
            try {
                ppt.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(ppt, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(Ad);
        out.println(Hiz);
        out.println(Agirlik);
        out.println(MotorHacim);
        out.println(DepoKapasitesi);
        out.println("-");
        out.close();
    }

    public void TankEkle(String Ad, String Hiz, String Agirlik, String MotorHacim, String DepoKapasitesi) {
        File tnk = new File("Tanklar.txt");
        if (!tnk.exists()) {
            try {
                tnk.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(tnk, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(Ad);
        out.println(Hiz);
        out.println(Agirlik);
        out.println(MotorHacim);
        out.println(DepoKapasitesi);
        out.println("-");
        out.close();
    }

    public void AskeriAracEkle(String Ad, String Hiz, String Agirlik, String MotorHacim, String TekerSayisi) {
        File askrarc = new File("AskeriArac.txt");
        if (!askrarc.exists()) {
            try {
                askrarc.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(askrarc, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(Ad);
        out.println(Hiz);
        out.println(Agirlik);
        out.println(MotorHacim);
        out.println(TekerSayisi);
        out.println("-");
        out.close();
    }

    public void SivilAracAracEkle(String Ad, String Hiz, String Agirlik, String MotorHacim, String TekerSayisi) {
        File svlarc = new File("SivilArac.txt");
        if (!svlarc.exists()) {
            try {
                svlarc.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(svlarc, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(Ad);
        out.println(Hiz);
        out.println(Agirlik);
        out.println(MotorHacim);
        out.println(TekerSayisi);
        out.println("-");
        out.close();
    }

    public void CokAmacliTesislerEkle(String ad, int odaSayisi, int katSayisi, int metrekare, int kapasite, String etkinlikGunleri) {
        File CokAmacli = new File("CokAmacliTesisler.txt");
        if (!CokAmacli.exists()) {
            try {
                CokAmacli.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(CokAmacli, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(ad);
        out.println(odaSayisi);
        out.println(katSayisi);
        out.println(metrekare);
        out.println(kapasite);
        out.println(etkinlikGunleri);
        out.println("-");
        out.close();

    }

    public void AskeriPersonelEkle(String Ad, String Soyad, String DogumYeri, int DogumYili, String Rutbe) {
        File Askeri = new File("AskeriPersonel.txt");
        if (!Askeri.exists()) {
            try {
                Askeri.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(Askeri, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(Ad);
        out.println(Soyad);
        out.println(DogumYeri);
        out.println(DogumYili);
        out.println(Rutbe);
        out.println("-");
        out.close();
    }

    public void SivilPersonelEkle(String Ad, String Soyad, String DogumYeri, int DogumYili, String Meslek) {
        File Sivil = new File("SivilPersonel.txt");
        if (!Sivil.exists()) {
            try {
                Sivil.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(Sivil, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(Ad);
        out.println(Soyad);
        out.println(DogumYeri);
        out.println(DogumYili);
        out.println(Meslek);
        out.println("-");
        out.close();
    }

    public void PaletliAracEkle(String Ad, int Hiz, int Agirlik, int MotorHacim, int DepoKapasitesi, int Toplam) {
        File Palet = new File("PaletliArac.txt");
        if (!Palet.exists()) {
            try {
                Palet.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(Palet, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(Ad);
        out.println(Hiz);
        out.println(Agirlik);
        out.println(MotorHacim);
        out.println(DepoKapasitesi);
        out.println(Toplam);
        out.println("-");
        out.close();
    }

    public void TekerlekliAracEkle(String Ad, int Hiz, int Agirlik, int MotorHacim, int DepoKapasitesi, int Toplam) {
        File Tekerlek = new File("TekerlekliArac.txt");
        if (!Tekerlek.exists()) {
            try {
                Tekerlek.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(Tekerlek, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(Ad);
        out.println(Hiz);
        out.println(Agirlik);
        out.println(MotorHacim);
        out.println(DepoKapasitesi);
        out.println(Toplam);
        out.println("-");
        out.close();
    }

    public void BarinmaTesisleriEkle(String ad, int odaSayisi, int katSayisi, int metrekare, int kapasite, int binaYasi) {
        File Barinma = new File("BarinmaTesisleri.txt");
        if (!Barinma.exists()) {
            try {
                Barinma.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(Barinma, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(ad);
        out.println(odaSayisi);
        out.println(katSayisi);
        out.println(metrekare);
        out.println(kapasite);
        out.println(binaYasi);
        out.println("-");
        out.close();

    }

    public void SaglikTesisleriEkle(String ad, int odaSayisi, int katSayisi, int metrekare, int kapasite, int tedaviOdasi) {
        File SaglikTesis = new File("SaglikTesisleri.txt");
        if (!SaglikTesis.exists()) {
            try {
                SaglikTesis.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(SaglikTesis, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(ad);
        out.println(odaSayisi);
        out.println(katSayisi);
        out.println(metrekare);
        out.println(kapasite);
        out.println(tedaviOdasi);
        out.println("-");
        out.close();

    }

    public void IlaclarEkle(String Ad, int sonKullanmaTarihi, int gunlukDozMiktarı, String yanEtkileri) {
        File Ilaclar = new File("Ilaclar.txt");
        if (!Ilaclar.exists()) {
            try {
                Ilaclar.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(Ilaclar, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(Ad);
        out.println(sonKullanmaTarihi);
        out.println(gunlukDozMiktarı);
        out.println(yanEtkileri);
        out.println("-");
        out.close();
    }

    public void ProteinUrunleriEkle(String Ad, int sonKullanmaTarihi, int kaloriMiktari, int proteinMiktari, int adet) {
        File ProteinUrunleri = new File("ProteinUrunleri.txt");
        if (!ProteinUrunleri.exists()) {
            try {
                ProteinUrunleri.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(ProteinUrunleri, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(Ad);
        out.println(sonKullanmaTarihi);
        out.println(kaloriMiktari);
        out.println(proteinMiktari);
        out.println(adet);
        out.println("-");
        out.close();
    }

    public void IceceklerEkle(String Ad, int sonKullanmaTarihi, int kaloriMiktari, int litre, int adet) {
        File Icecekler = new File("Icecekler.txt");
        if (!Icecekler.exists()) {
            try {
                Icecekler.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(Icecekler, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(Ad);
        out.println(sonKullanmaTarihi);
        out.println(kaloriMiktari);
        out.println(litre);
        out.println(adet);
        out.println("-");
        out.close();
    }

    public void GarajEkle(String ad, int odaSayisi, int katSayisi, int metrekare, int kapasite) {
        File Garaj = new File("Garaj.txt");
        if (!Garaj.exists()) {
            try {
                Garaj.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(Garaj, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(ad);
        out.println(odaSayisi);
        out.println(katSayisi);
        out.println(metrekare);
        out.println(kapasite);
        out.println("-");
        out.close();
    }

    public void DepoEkle(String ad, int odaSayisi, int katSayisi, int metrekare, int kapasite) {
        File Depo = new File("Depo.txt");
        if (!Depo.exists()) {
            try {
                Depo.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(Depo, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(ad);
        out.println(odaSayisi);
        out.println(katSayisi);
        out.println(metrekare);
        out.println(kapasite);

        out.println("-");
        out.close();
    }

    public void KarbonhidratUrunleriEkle(String Ad, int sonKullanmaTarihi, int kaloriMiktari, int enerjiMiktari, int adet) {
        File karbonhidrat = new File("KarbonhidratUrunleri.txt");
        if (!karbonhidrat.exists()) {
            try {
                karbonhidrat.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(karbonhidrat, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(Ad);
        out.println(sonKullanmaTarihi);
        out.println(kaloriMiktari);
        out.println(enerjiMiktari);
        out.println(adet);
        out.println("-");
        out.close();
    }

    public void SilahlarEkle(String Ad, String SeriNo, String adet, String Tur) {
        File silah = new File("Silahlar.txt");
        if (!silah.exists()) {
            try {
                silah.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(silah, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(Ad);
        out.println(SeriNo);
        out.println(adet);
        out.println(Tur);
        out.println("-");
        out.close();
    }

    public void PatlayicilarEkle(String Ad, String SeriNo, String adet, String EtkiliOlduguMenzil) {
        File patlayici = new File("Patlayicilar.txt");
        if (!patlayici.exists()) {
            try {
                patlayici.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(patlayici, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(Ad);
        out.println(SeriNo);
        out.println(adet);
        out.println(EtkiliOlduguMenzil);
        out.println("-");
        out.close();
    }

    public void MermilerEkle(String Ad, String SeriNo, String adet, String boyut) {
        File mermi = new File("Mermiler.txt");
        if (!mermi.exists()) {
            try {
                mermi.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(mermi, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(Ad);
        out.println(SeriNo);
        out.println(adet);
        out.println(boyut);
        out.println("-");
        out.close();
    }

    public void MaasOde(String PersonelTuru, int OperasyonSayisi, int NobetSayisi, String PersonelNumarasi, int Maas) {
        File maas = new File("Maas.txt");
        if (!maas.exists()) {
            try {
                maas.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(maas, true)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        out.println(PersonelTuru);
        out.println(OperasyonSayisi);
        out.println(NobetSayisi);
        out.println(PersonelNumarasi);
        out.println(Maas);
        out.println("-");
        out.close();
    }
}
