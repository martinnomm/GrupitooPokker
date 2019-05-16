import java.util.ArrayList;
import java.util.Collections;

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
    public boolean leidub (ArrayList<Kaart> kaardid, int väärtus, String mast) {
        for (Kaart kaart : kaardid) if ((kaart.getVäärtus() == väärtus) && (kaart.getMast().equals(mast))) return true;
        return false;
    }



    public Kombinatsioon royalFlush (ArrayList<Kaart> kaardid) {
        ArrayList<Integer> kõrgemadKaardid = new ArrayList<>();
        Collections.addAll(kõrgemadKaardid, 10, 11 , 12, 13, 1);
        int ärtu = 0;
        int poti = 0;
        int ruutu = 0;
        int risti = 0;
        for (Kaart kaart : kaardid) { // Loendab iga masti kohta, mitu kaarti mastis
            if(kaart.getMast().equals("ärtu")) ärtu += 1;
            else if (kaart.getMast().equals("risti")) risti += 1;
            else if (kaart.getMast().equals("ruutu")) ruutu += 1;
            else if (kaart.getMast().equals("poti")) poti += 1;
        } // Kui mingis mastist 5 või rohkem kaarti, otsib kas leiab royal flushi mingi masti kaudu
        if(ärtu >=5 || risti >= 5 || ruutu >= 5 || poti >= 5) {
            if (leidub(kaardid,1,"ärtu") &
                    leidub(kaardid,10,"ärtu") &
                    leidub(kaardid,11,"ärtu") &
                    leidub(kaardid,12,"ärtu") &
                    leidub(kaardid,13,"ärtu")) return new Kombinatsioon(10, true, kõrgemadKaardid);

            else if (leidub(kaardid,1,"ruutu") &
                    leidub(kaardid,10,"ruutu") &
                    leidub(kaardid,11,"ruutu") &
                    leidub(kaardid,12,"ruutu") &
                    leidub(kaardid,13,"ruutu")) return new Kombinatsioon(10, true, kõrgemadKaardid);

            else if (leidub(kaardid,1,"risti") &
                    leidub(kaardid,10,"risti") &
                    leidub(kaardid,11,"risti") &
                    leidub(kaardid,12,"risti") &
                    leidub(kaardid,13,"risti")) return new Kombinatsioon(10, true, kõrgemadKaardid);

            else if (leidub(kaardid,1,"poti") &
                    leidub(kaardid,10,"poti") &
                    leidub(kaardid,11,"poti") &
                    leidub(kaardid,12,"poti") &
                    leidub(kaardid,13,"poti")) return new Kombinatsioon(10, true, kõrgemadKaardid);
        }
        return new Kombinatsioon(10, false, new ArrayList<>());
    }

    public Kombinatsioon straightFlush (ArrayList<Kaart> kaardid) {
        ArrayList<Integer> kõrgemadKaardid = new ArrayList<>();
        Collections.sort(kaardid);
        ArrayList<Kaart> ärtu = new ArrayList<>();
        ArrayList<Kaart> ruutu = new ArrayList<>();
        ArrayList<Kaart> poti = new ArrayList<>();
        ArrayList<Kaart> risti = new ArrayList<>();

        for(Kaart kaart : kaardid) {
            if (kaart.getMast().equals("ärtu")) {
                if (ärtu.size() == 0) {
                    ärtu.add(kaart);
                } else {
                    if(kaart.getVäärtus()-1 == ärtu.get(ärtu.size()-1).getVäärtus() && kaart.getMast().equals(ärtu.get(ärtu.size() -1).getMast())){
                        ärtu.add(kaart);
                    } else {
                        ärtu.clear();
                        ärtu.add(kaart);
                    }
                }
            } //ärtu rea kontrollimine
            if(ärtu.size() == 5){
                for(Kaart k : ärtu){
                    kõrgemadKaardid.add(k.getVäärtus());
                }
                return new Kombinatsioon(9, true, kõrgemadKaardid);
            } //tõeväärtuse tagastamine

            if (kaart.getMast().equals("ruutu")) {
                if (ruutu.size() == 0) {
                    ruutu.add(kaart);
                } else {
                    if(kaart.getVäärtus()-1 == ruutu.get(ruutu.size()-1).getVäärtus() && kaart.getMast().equals(ruutu.get(ruutu.size() -1).getMast())){
                        ruutu.add(kaart);
                    } else {
                        ruutu.clear();
                        ruutu.add(kaart);
                    }
                }
            } //ruutu rea kontrollimine
            if(ruutu.size() == 5){
                for(Kaart k : ruutu){
                    kõrgemadKaardid.add(k.getVäärtus());
                }
                return new Kombinatsioon(9, true, kõrgemadKaardid);
            } //tõeväärtuse tagastamine

            if (kaart.getMast().equals("poti")) {
                if (poti.size() == 0) {
                    poti.add(kaart);
                } else {
                    if(kaart.getVäärtus()-1 == poti.get(poti.size()-1).getVäärtus() && kaart.getMast().equals(poti.get(poti.size() -1).getMast())){
                        poti.add(kaart);
                    } else {
                        poti.clear();
                        poti.add(kaart);
                    }
                }
            } //poti rea kontrollimine
            if(poti.size() == 5){
                for(Kaart k : poti){
                    kõrgemadKaardid.add(k.getVäärtus());
                }
                return new Kombinatsioon(9, true, kõrgemadKaardid);
            } //tõeväärtuse tagastamine

            if (kaart.getMast().equals("risti")) {
                if (risti.size() == 0) {
                    risti.add(kaart);
                } else {
                    if(kaart.getVäärtus()-1 == risti.get(risti.size()-1).getVäärtus() && kaart.getMast().equals(risti.get(risti.size() -1).getMast())){
                        risti.add(kaart);
                    } else {
                        risti.clear();
                        risti.add(kaart);
                    }
                }
            } //risti rea kontrollimine
            if(risti.size() == 5){
                for(Kaart k : risti){
                    kõrgemadKaardid.add(k.getVäärtus());
                }
                return new Kombinatsioon(9, true, kõrgemadKaardid);
            } //tõeväärtuse tagastamine
        }
        return new Kombinatsioon(9, false, new ArrayList<>());
    } //stright flush

    public Kombinatsioon fourOfAKind (ArrayList<Kaart> kaardid) {
        ArrayList<Integer> kõrgemadKaardid = new ArrayList<>();
        Collections.sort(kaardid); // Sorteerib massiivi kaardi väärtuse kaudu
        int kordusi = 0; // See, mitu korda leiab sama väärtuse kaardi
        int valitudVäärtus = 0; // Millise väärtusega kaarte otsib
        for (Kaart kaart : kaardid) {
            if(kordusi == 0) { // Kui esimene kaart, võtab selle väärtuse ja hakkab loendama
                valitudVäärtus = kaart.getVäärtus();
                kordusi = 1;
                kõrgemadKaardid.add(valitudVäärtus);
                continue;
            }
            else if (kordusi == 4) break; // Kui 4 kaarti käes, breakib loopi
            else if (kaart.getVäärtus() == valitudVäärtus) { // Kui uue kaardi väärtus sama, mis eelmisel, lisab loetutesse
                kordusi += 1;
                kõrgemadKaardid.add(valitudVäärtus);
                continue;
            }
            else { // Kui erineva väärtusega kaart, hakkab uuest väärtusest lugema ja kordused resetivad
                valitudVäärtus = kaart.getVäärtus();
                kõrgemadKaardid.clear();
                kõrgemadKaardid.add(valitudVäärtus);
                kordusi = 1;
            }
        }
        if (kordusi >= 4){
            int kõrgemVäärtus = 0;
            for(Kaart kaart : kaardid){
                if(!kõrgemadKaardid.contains(kaart.getVäärtus())){
                    if(kaart.getVäärtus() == 1){
                        kõrgemVäärtus = 1;
                        break;
                    } else if(kaart.getVäärtus() > kõrgemVäärtus) {
                        kõrgemVäärtus = kaart.getVäärtus();
                    }
                }
            }
            kõrgemadKaardid.add(0, kõrgemVäärtus);
            return new Kombinatsioon(8, true, kõrgemadKaardid); // Kui leiab 4 korduvat kaarti, tagastab true
        }
        return new Kombinatsioon(8, false, new ArrayList<>());
    }

    public Kombinatsioon fullHouse (ArrayList<Kaart> kaardid) {
        ArrayList<Integer> kõrgemadKaardid = new ArrayList<>();
        Collections.sort(kaardid);
        int kolmikuKordumine = 0;
        int kolmikuVäärtus = 0;
        for(Kaart kaart : kaardid) {
            if (kolmikuKordumine == 0) {
                kolmikuVäärtus = kaart.getVäärtus();
                kolmikuKordumine = 1;
                continue;
            }
            else if (kolmikuKordumine == 3){
                break;
            }
            else if(kaart.getVäärtus() == kolmikuVäärtus) {
                kolmikuKordumine += 1;
                continue;
            }
            else {
                kolmikuVäärtus = kaart.getVäärtus();
                kolmikuKordumine = 1;
            }
        }
        if (!(kolmikuKordumine == 3)) return new Kombinatsioon(7, false, new ArrayList<>());
        else {
            int paariKordumine = 0;
            int paariVäärtus = 0;
            for(Kaart kaart : kaardid) { ;
                if (kaart.getVäärtus() != kolmikuVäärtus) {
                    if(paariKordumine == 0) {
                        paariKordumine = 1;
                        paariVäärtus = kaart.getVäärtus();
                        continue;
                    }
                    else if (paariKordumine == 2){
                        break;
                    }
                    else if (kaart.getVäärtus() == paariVäärtus) {
                        paariKordumine += 1;
                        continue;
                    }
                    else {
                        paariKordumine = 1;
                        paariVäärtus  = kaart.getVäärtus();
                    }
                }
            }

            if(paariKordumine == 2){
                kõrgemadKaardid.add(paariVäärtus);
                kõrgemadKaardid.add(paariVäärtus);
                kõrgemadKaardid.add(kolmikuVäärtus);
                kõrgemadKaardid.add(kolmikuVäärtus);
                kõrgemadKaardid.add(kolmikuVäärtus);

                return new Kombinatsioon(7, true, kõrgemadKaardid);
            }
            return new Kombinatsioon(7, false, new ArrayList<>());
        }
    }

    public Kombinatsioon flush (ArrayList<Kaart> kaardid) {
        ArrayList<Integer> kõrgemadKaardid = new ArrayList<>();
        // Kuna flush on 5 samast mastist kaarti, loendab iga masti kohta, mitu kaarti on massiivis masti kohta
        int ärtu = 0;
        int ruutu =0;
        int poti = 0;
        int risti = 0;
        String võitjaMast = "";

        for (Kaart kaart : kaardid) { // Läbib kaartide massiivi, lugedes üle mitu masti kohta on
            if (kaart.getMast().equals("ärtu")) ärtu +=1;
            else if (kaart.getMast().equals("ruutu")) ruutu +=1;
            else if (kaart.getMast().equals("poti")) poti += 1;
            else if (kaart.getMast().equals("risti")) risti += 1;
        }

        if(ärtu >= 5) võitjaMast = "ärtu";
        else if(risti >= 5) võitjaMast = "risti";
        else if(poti >= 5) võitjaMast = "poti";
        else if(ruutu >= 5) võitjaMast = "ruutu";

        for(Kaart kaart : kaardid){
            if(kaart.getMast().equals(võitjaMast)){
                kõrgemadKaardid.add(kaart.getVäärtus());
            }
        }
        Collections.sort(kõrgemadKaardid);

        if(!(võitjaMast.equals(""))) return new Kombinatsioon(6, true, kõrgemadKaardid); // Kui mingis mastis on 5 kaarti, tagastab true
        return new Kombinatsioon(6, false, new ArrayList<>());
    }

    public Kombinatsioon straight (ArrayList<Kaart> kaardid) {
        ArrayList<Integer> kõrgemadKaardid = new ArrayList<>();
        Collections.sort(kaardid); // Sorteerib massiivi
        int kordusi = 0;
        int väärtus = 0;// Põhiliselt sama, nagu mõni eelmine meetod. Otsib 5 kaarti, mis järjest väärtused
        for (Kaart kaart : kaardid) {
            if (kordusi == 0) {
                väärtus = kaart.getVäärtus();
                kordusi = 1;
                kõrgemadKaardid.add(väärtus);
                continue;
            }
            else if (kordusi == 5) break;
            else if (väärtus + 1 == kaart.getVäärtus()) {
                kordusi += 1;
                väärtus += 1;
                kõrgemadKaardid.add(väärtus);
                if(väärtus == 13 && kordusi == 4){
                    if(kaardid.get(0).getVäärtus() == 1){
                        kordusi += 1;
                        väärtus = 1;
                        kõrgemadKaardid.add(väärtus);
                    }
                }
                continue;
            }
            else {
                kordusi = 1;
                väärtus = kaart.getVäärtus();
                kõrgemadKaardid.clear();
                kõrgemadKaardid.add(väärtus);
                continue;
            }
        }
        if (kordusi>=5) return new Kombinatsioon(5, true, kõrgemadKaardid);
        return new Kombinatsioon(5, false, new ArrayList<>());
    }

    public Kombinatsioon threeOfAKind (ArrayList<Kaart> kaardid) {
        ArrayList<Kaart> kõrgemadKaardidKaardikujul = new ArrayList<>();
        ArrayList<Integer> kõrgemadKaardid = new ArrayList<>();
        Collections.sort(kaardid); // Otsib kolmikut kaartide massiivist, seega sorteerib
        int kordusi = 0; // Mitu korda esineb mingi kaart
        int valitudVäärtus = 0; // Millist kaardi väärtust otsib
        for (Kaart kaart : kaardid) {
            if(kordusi == 0) { // Kui esimene, siis määrab selle järgi väärtuse
                valitudVäärtus = kaart.getVäärtus();
                kordusi = 1;
                kõrgemadKaardidKaardikujul.add(kaart);
                continue;
            }
            else if (kordusi == 3) break; // Kui leidnud 4, siis breakib loopi
            else if (kaart.getVäärtus() == valitudVäärtus) {  // Kui leitud kaart on valitud väärtusega, lisab loendusesse
                kordusi += 1;
                kõrgemadKaardidKaardikujul.add(kaart);
                continue;
            }
            else { // Kui uus kaart, võtab uued väärtused
                valitudVäärtus = kaart.getVäärtus();
                kordusi = 1;
                kõrgemadKaardidKaardikujul.clear();
                kõrgemadKaardidKaardikujul.add(kaart);
            }
        }
        for(int i = 0; i < 2; i++){
            Kaart kõrgemKaart = new Kaart("", 0);
            for(Kaart kaart : kaardid){
                if(!kõrgemadKaardidKaardikujul.contains(kaart)){
                    if(kaart.getVäärtus() == 1){
                        kõrgemKaart.setMast(kaart.getMast());
                        kõrgemKaart.setVäärtus(1);
                        break;
                    } else if(kaart.getVäärtus() > kõrgemKaart.getVäärtus()) {
                        kõrgemKaart.setMast(kaart.getMast());
                        kõrgemKaart.setVäärtus(kaart.getVäärtus());
                    }
                }
            }
            kõrgemadKaardidKaardikujul.add(0, kõrgemKaart);
        }

        for(Kaart kaart : kõrgemadKaardidKaardikujul){
            kõrgemadKaardid.add(kaart.getVäärtus());
        }

        if (kordusi >= 3) return new Kombinatsioon(4, true, kõrgemadKaardid); // Kui kolm sama väärtusega kaarti, tagastab true
        return new Kombinatsioon(4, false, new ArrayList<>());
    }

    // Üks kohutavalt pikk funktsioon
    // Sarnane kolmik-paarile, otsib ühe paari ja teise paari. Teise puhul väldib väärtusi, mis esimeses kasutatud
    public Kombinatsioon twoPairs (ArrayList<Kaart> kaardid) {
        ArrayList<Integer> kõrgemadKaardid = new ArrayList<>();
        Collections.sort(kaardid);
        Collections.reverse(kaardid);
        ArrayList<Kaart> liigutamine = new ArrayList<>();
        for(Kaart kaart : kaardid){
            if(kaart.getVäärtus() == 1){
                liigutamine.add(kaart);
            }
        }
        for(Kaart kaart : liigutamine){
            kaardid.remove(kaart);
            kaardid.add(0, kaart);
        }

        int esimesePaariKordumine = 0;
        int esimesePaariVäärtus = 0;
        for(Kaart kaart : kaardid) {
            if (esimesePaariKordumine == 0) {
                esimesePaariVäärtus = kaart.getVäärtus();
                esimesePaariKordumine = 1;
                continue;
            }
            else if (esimesePaariKordumine == 2){
                break;
            }
            else if(kaart.getVäärtus() == esimesePaariVäärtus) {
                esimesePaariKordumine += 1;
                continue;
            }
            else {
                esimesePaariVäärtus = kaart.getVäärtus();
                esimesePaariKordumine = 1;
            }
        }
        if (!(esimesePaariKordumine == 2)) return new Kombinatsioon(3, false, new ArrayList<>());
        else {
            int teisePaariKordumine = 0;
            int teisePaariVäärtus = 0;
            for(Kaart kaart : kaardid) {
                if (kaart.getVäärtus() != esimesePaariVäärtus) {
                    if(teisePaariKordumine == 0) {
                        teisePaariVäärtus = kaart.getVäärtus();
                        teisePaariKordumine = 1;
                        continue;
                    }
                    else if (teisePaariKordumine == 2){
                        break;
                    }
                    else if (kaart.getVäärtus() == teisePaariVäärtus) {
                        teisePaariKordumine += 1;
                        continue;
                    }
                    else {
                        teisePaariVäärtus  = kaart.getVäärtus();
                        teisePaariKordumine = 1;
                    }
                }
            }

            if(teisePaariKordumine == 2){
                kõrgemadKaardid.add(esimesePaariVäärtus);
                kõrgemadKaardid.add(esimesePaariVäärtus);
                kõrgemadKaardid.add(teisePaariVäärtus);
                kõrgemadKaardid.add(teisePaariVäärtus);
                Collections.sort(kõrgemadKaardid);
                if(kõrgemadKaardid.contains(1) && kõrgemadKaardid.get(3) != 1){
                    Collections.reverse(kõrgemadKaardid);
                }

                int kõrgemVäärtus = 0;
                for(Kaart kaart : kaardid){
                    if(!kõrgemadKaardid.contains(kaart.getVäärtus())){
                        if(kaart.getVäärtus() == 1){
                            kõrgemVäärtus = 1;
                            break;
                        } else if(kaart.getVäärtus() > kõrgemVäärtus) {
                            kõrgemVäärtus = kaart.getVäärtus();
                        }
                    }
                }
                kõrgemadKaardid.add(0, kõrgemVäärtus);

                return new Kombinatsioon(3, true, kõrgemadKaardid);
            }
            return new Kombinatsioon(3, false, new ArrayList<>());
        }
    }


    public Kombinatsioon Pair (ArrayList<Kaart> kaardid) {
        ArrayList<Kaart> kõrgemadKaardidKaardikujul = new ArrayList<>();
        ArrayList<Integer> kõrgemadKaardid = new ArrayList<>();
        Collections.sort(kaardid); // Sorteerib massiivi. Peab leidma ühe paari kaartidest
        int kordumine = 0; // Mitu kordumist kaartidel
        int väärtus = 0; // Otsitava kaardi väärtus
        for(Kaart kaart : kaardid) {
            if (kordumine == 0) { // Kui esimene kaart, siis määratakse väärtused
                väärtus = kaart.getVäärtus();
                kordumine = 1;
                kõrgemadKaardidKaardikujul.add(kaart);
                continue;
            }
            else if (kordumine == 2) break; // Kui 2 kordust ehk paar leitud, breakib loopi
            else if(kaart.getVäärtus()== väärtus) { // Kui väärtus sama, lisab loendusesse
                kordumine += 1;
                kõrgemadKaardidKaardikujul.add(kaart);
                continue;
            }
            else { // Kui pole korduv väärtus, võtab uue kaardi otsitavaks
                väärtus = kaart.getVäärtus();
                kordumine = 1;
                kõrgemadKaardidKaardikujul.clear();
                kõrgemadKaardidKaardikujul.add(kaart);

            }
        }

        for(int i = 0; i < 3; i++){
            Kaart kõrgemKaart = new Kaart("", 0);
            for(Kaart kaart : kaardid){
                if(!kõrgemadKaardidKaardikujul.contains(kaart)){
                    if(kaart.getVäärtus() == 1){
                        kõrgemKaart.setMast(kaart.getMast());
                        kõrgemKaart.setVäärtus(1);
                        break;
                    } else if(kaart.getVäärtus() > kõrgemKaart.getVäärtus()) {
                        kõrgemKaart.setMast(kaart.getMast());
                        kõrgemKaart.setVäärtus(kaart.getVäärtus());
                    }
                }
            }
            kõrgemadKaardidKaardikujul.add(0, kõrgemKaart);
        }

        for(Kaart kaart : kõrgemadKaardidKaardikujul){
            kõrgemadKaardid.add(kaart.getVäärtus());
        }

        if (kordumine == 2) return new Kombinatsioon(2, true, kõrgemadKaardid); // Kui 2 korda kordub, tagastab true
        return new Kombinatsioon(2, false, new ArrayList<>());
    }

    public Kombinatsioon highCard(ArrayList<Kaart> kaardid) {
        ArrayList<Kaart> kõrgemadKaardidKaardikujul = new ArrayList<>();
        ArrayList<Integer> kõrgemadKaardid = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            Kaart kõrgemKaart = new Kaart("", 0);
            for(Kaart kaart : kaardid){
                if(!kõrgemadKaardidKaardikujul.contains(kaart)){
                    if(kaart.getVäärtus() == 1){
                        kõrgemKaart.setMast(kaart.getMast());
                        kõrgemKaart.setVäärtus(1);
                        break;
                    } else if(kaart.getVäärtus() > kõrgemKaart.getVäärtus()) {
                        kõrgemKaart.setMast(kaart.getMast());
                        kõrgemKaart.setVäärtus(kaart.getVäärtus());
                    }
                }
            }
            kõrgemadKaardidKaardikujul.add(0, kõrgemKaart);
        }

        for(Kaart kaart : kõrgemadKaardidKaardikujul){
            kõrgemadKaardid.add(kaart.getVäärtus());
        }

        return new Kombinatsioon(1, true, kõrgemadKaardid);
    }
}