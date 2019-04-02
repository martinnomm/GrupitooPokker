import java.util.Arrays;

public class Meetodid {

    /*public boolean leidub (Kaart[] kaardid, int väärtus) {
        for (Kaart kaart : kaardid) if (kaart.getVäärtus() == väärtus) return true;
        return false;
    }

    public boolean leidub (Kaart[] kaardid, String mast) {
        for (Kaart kaart : kaardid) if (kaart.getMast() == mast) return true;
        return false;
    }*/

    // Vaatab, kas kaardi massiivis leidub sellise väärtuse ja mastiga kaart
    public boolean leidub (Kaart[] kaardid, int väärtus, String mast) {
        for (Kaart kaart : kaardid) if (kaart.getVäärtus() == väärtus & kaart.getMast() == mast) return true;
        return false;
    }

    public boolean royalFlush (Kaart[] kaardid) {
        // Määrab igale masti kaartidele koguse, mida loendab
        int ärtu = 0;
        int poti = 0;
        int ruutu = 0;
        int risti = 0;
        for (Kaart kaart : kaardid) { // Loendab iga masti kohta, mitu kaarti mastis
            if(kaart.getMast() == "ärtu") ärtu += 1;
            else if (kaart.getMast() == "risti") risti += 1;
            else if (kaart.getMast() == "ruutu") ruutu += 1;
            else if (kaart.getMast() == "poti") poti += 1;
        } // Kui mingis mastist 5 või rohkem kaarti, otsib kas leiab royal flushi mingi masti kaudu
        if(ärtu >=5 || risti >= 5 || ruutu >= 5 || poti >= 5) {
            if (leidub(kaardid,1,"ärtu") &
                    leidub(kaardid,10,"ärtu") &
                    leidub(kaardid,11,"ärtu") &
                    leidub(kaardid,12,"ärtu") &
                    leidub(kaardid,13,"ärtu")) return true;

            else if (leidub(kaardid,1,"ruutu") &
                    leidub(kaardid,10,"ruutu") &
                    leidub(kaardid,11,"ruutu") &
                    leidub(kaardid,12,"ruutu") &
                    leidub(kaardid,13,"ruutu")) return true;

            else if (leidub(kaardid,1,"risti") &
                    leidub(kaardid,10,"risti") &
                    leidub(kaardid,11,"risti") &
                    leidub(kaardid,12,"risti") &
                    leidub(kaardid,13,"risti")) return true;

            else if (leidub(kaardid,1,"poti") &
                    leidub(kaardid,10,"poti") &
                    leidub(kaardid,11,"poti") &
                    leidub(kaardid,12,"poti") &
                    leidub(kaardid,13,"poti")) return true;
        }
        return false;
    }

    public boolean straightFlush (Kaart[] kaardid) {
        Arrays.sort(kaardid); // Massiivis kaardid sorteeritud väärtuse järgi, väiksemast suuremaks
        int eelmineVäärtus = 0;  // Määrab kasutamiseks int arvu, millega võrdleb järgmise kaardi väärtust
        String valitudMast = "tühi"; // Valitud masti märge, millega võrdleb, kas ostib ikka sama masti kaarte
        int samasid = 1; // Loeb, mitu sama mastiga  ja järgneva suurusega kaarti leidub
        for (Kaart kaart : kaardid) {
            if (eelmineVäärtus == 0) { // Kui esimene, määrab esimese väärtused mastiks ja kaardi väärtuseks
                eelmineVäärtus = kaart.getVäärtus();
                valitudMast = kaart.getMast();
                continue;
            } // Kui kaart on eelmisega samast mastist ja 1 väärtus suurem, lisab selle kogusse
            else if (kaart.getMast() == valitudMast & kaart.getVäärtus() == eelmineVäärtus + 1) {
                eelmineVäärtus = kaart.getVäärtus();
                samasid += 1;
                continue;
            }
            else { // Kui kaart erinev mast või mitte järgnev väärtus, alustab uuesti uute lugemisega
                eelmineVäärtus = kaart.getVäärtus();
                valitudMast = kaart.getMast();
                samasid = 1;
                continue;
            }
        }
        if (samasid >= 5) return true; // Kui 5 järjestikust kaarti samast mastist, returnib true
        else return false;
    }

    public boolean fourOfAKind (Kaart[] kaardid) {
        Arrays.sort(kaardid); // Sorteerib massiivi kaardi väärtuse kaudu
        int kordusi = 0; // See, mitu korda leiab sama väärtuse kaardi
        int valitudVäärtus = 0; // Millise väärtusega kaarte otsib
        for (Kaart kaart : kaardid) {
            if(kordusi == 0) { // Kui esimene kaart, võtab selle väärtuse ja hakkab loendama
                valitudVäärtus = kaart.getVäärtus();
                kordusi = 1;
                continue;
            }
            else if (kordusi == 4) break; // Kui 4 kaarti käes, breakib loopi
            else if (kaart.getVäärtus() == valitudVäärtus) { // Kui uue kaardi väärtus sama, mis eelmisel, lisab loetutesse
                kordusi += 1;
                continue;
            }
            else { // Kui erineva väärtusega kaart, hakkab uuest väärtusest lugema ja kordused resetivad
                valitudVäärtus = kaart.getVäärtus();
                kordusi = 1;
            }
        }
        if (kordusi >= 4) return true; // Kui leiab 4 korduvat kaarti, tagastab true
        else return false;
    }

    public boolean fullHouse (Kaart[] kaardid) {
        Arrays.sort(kaardid);
        int korduvKolm = 0; // Sama, mis varasematel, siin otsib 3 kaarti, mis sama väärtusega
        int kolmVäärtus = 0;
        for (Kaart kaart : kaardid) {
            if (korduvKolm == 0) {
                kolmVäärtus = kaart.getVäärtus();
                korduvKolm = 1;
            }
            else if (korduvKolm == 3) break;
            else if (kaart.getVäärtus() == kolmVäärtus) {
                korduvKolm += 1;
                continue;
            }
            else {
                kolmVäärtus = kaart.getVäärtus();
                korduvKolm = 1;
            }
        }
        if (!(korduvKolm>=3)) { // kui ei leia kaartide kolmikut, tagastab kohe false
            return false;
        }
        else {
            int korduvKaks = 0;
            int kaksVäärtus = 0;
            for (Kaart kaart : kaardid) {
                if (korduvKaks == 2) break;
                else if (kaart.getVäärtus() != kolmVäärtus) { // Siin kontrollib, et paaride jaoks otsitav kaart poleks sama väärtusega, mis kolmikul oli
                    if (korduvKaks == 0) {
                        kaksVäärtus = kaart.getVäärtus();
                        korduvKaks = 1;
                        continue;
                    }
                    else if (kaart.getVäärtus() == kaksVäärtus) {
                        korduvKaks += 1;
                        continue;
                    }
                    else {
                        kaksVäärtus = kaart.getVäärtus();
                        korduvKaks = 1;
                    }
                }
                else {
                    korduvKaks = 0;
                    kaksVäärtus = 0;
                }
            }
            if (korduvKaks == 2) return true; // Kui varem leitud kolmik ja nüüd paar, tagastab true
            else return false;
        }
    }

    public boolean flush (Kaart[] kaardid) {
        // Kuna flush on 5 samast mastist kaarti, loendab iga masti kohta, mitu kaarti on massiivis masti kohta
        int ärtu = 0;
        int ruutu =0;
        int poti = 0;
        int risti = 0;

        for (Kaart kaart : kaardid) { // Läbib kaartide massiivi, lugedes üle mitu masti kohta on
            if (kaart.getMast() == "ärtu") ärtu +=1;
            else if (kaart.getMast() == "ruutu") ruutu +=1;
            else if (kaart.getMast() == "poti") poti += 1;
            else if (kaart.getMast() == "risti") risti += 1;
        }

        if(ärtu >=5 || risti >= 5 || ruutu >= 5 || poti >= 5) return true; // Kui mingis mastis on 5 kaarti, tagastab true
        else return false;
    }

    public boolean straight (Kaart[] kaardid) {
        Arrays.sort(kaardid); // Sorteerib massiivi
        int kordusi = 0;
        int väärtus = 0;// Põhiliselt sama, nagu mõni eelmine meetod. Otsib 5 kaarti, mis järjest väärtused
        for (Kaart kaart : kaardid) {
            if (kordusi == 0) {
                väärtus = kaart.getVäärtus();
                kordusi = 1;
                continue;
            }
            else if (kordusi == 5) break;
            else if (väärtus + 1 == kaart.getVäärtus()) {
                kordusi += 1;
                väärtus += 1;
                continue;
            }
            else {
                kordusi = 1;
                väärtus = kaart.getVäärtus();
                continue;
            }
        }
        if (kordusi>=5) return true;
        else return false;
    }

    public boolean threeOfAKind (Kaart[] kaardid) {
        Arrays.sort(kaardid); // Otsib kolmikut kaartide massiivist, seega sorteerib
        int kordusi = 0; // Mitu korda esineb mingi kaart
        int valitudVäärtus = 0; // Millist kaardi väärtust otsib
        for (Kaart kaart : kaardid) {
            if(kordusi == 0) { // Kui esimene, siis määrab selle järgi väärtuse
                valitudVäärtus = kaart.getVäärtus();
                kordusi = 1;
                continue;
            }
            else if (kordusi == 3) break; // Kui leidnud 4, siis breakib loopi
            else if (kaart.getVäärtus() == valitudVäärtus) {  // Kui leitud kaart on valitud väärtusega, lisab loendusesse
                kordusi += 1;
                continue;
            }
            else { // Kui uus kaart, võtab uued väärtused
                valitudVäärtus = kaart.getVäärtus();
                kordusi = 1;
            }
        }
        if (kordusi >= 3) return true; // Kui kolm sama väärtusega kaarti, tagastab true
        else return false;
    }

    // Üks kohutavalt pikk funktsioon
    // Sarnane kolmik-paarile, otsib ühe paari ja teise paari. Teise puhul väldib väärtusi, mis esimeses kasutatud
    public boolean twoPairs (Kaart[] kaardid) {
        Arrays.sort(kaardid);
        int esimesePaariKordumine = 0;
        int esimesePaariVäärtus = 0;
        for(Kaart kaart : kaardid) {
            if (esimesePaariKordumine == 0) {
                esimesePaariVäärtus = kaart.getVäärtus();
                esimesePaariKordumine = 1;
                continue;
            }
            else if (esimesePaariKordumine == 2) break;
            else if(kaart.getVäärtus()== esimesePaariVäärtus) {
                esimesePaariKordumine += 1;
                continue;
            }
            else {
                esimesePaariVäärtus = kaart.getVäärtus();
                esimesePaariKordumine = 1;

            }
        }
        if (!(esimesePaariKordumine == 2)) return false;
        else {
            int teisePaariKordumine = 0;
            int teisePaariVäärtus = 0;
            for(Kaart kaart : kaardid) {
                if (kaart.getVäärtus() != esimesePaariVäärtus) {
                    if(teisePaariKordumine == 0) {
                        teisePaariKordumine = 1;
                        teisePaariVäärtus = kaart.getVäärtus();
                        continue;
                    }
                    else if (teisePaariKordumine == 2) break;
                    else if (kaart.getVäärtus() == teisePaariVäärtus) {
                        teisePaariKordumine += 1;
                        continue;
                    }
                    else {
                        teisePaariKordumine = 1;
                        teisePaariVäärtus  = kaart.getVäärtus();
                    }
                }
                else {
                    esimesePaariKordumine = 0;
                    esimesePaariVäärtus = 0;
                }
            }
            if(teisePaariKordumine == 2) return true;
            else return false;
        }
    }


    public boolean Pair (Kaart[] kaardid) {
        Arrays.sort(kaardid); // Sorteerib massiivi. Peab leidma ühe paari kaartidest
        int kordumine = 0; // Mitu kordumist kaartidel
        int väärtus = 0; // Otsitava kaardi väärtus
        for(Kaart kaart : kaardid) {
            if (kordumine == 0) { // Kui esimene kaart, siis määratakse väärtused
                väärtus = kaart.getVäärtus();
                kordumine = 1;
                continue;
            }
            else if (kordumine == 2) break; // Kui 2 kordust ehk paar leitud, breakib loopi
            else if(kaart.getVäärtus()== väärtus) { // Kui väärtus sama, lisab loendusesse
                kordumine += 1;
                continue;
            }
            else { // Kui pole korduv väärtus, võtab uue kaardi otsitavaks
                väärtus = kaart.getVäärtus();
                kordumine = 1;

            }
        }
        if (kordumine == 2) return true; // Kui 2 korda kordub, tagastab true
        else return false;
    }
}