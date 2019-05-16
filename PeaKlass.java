import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class PeaKlass {

    public static void väljastaTõenäosused(int paariArv, ArrayList<Paar> paarid, ArrayList<Kaart> lauaKaardid, ArrayList<Kaart> kasutamataKaardid, Meetodid meetod){
        Tõenäosused tõenäosus= arvutaTõenäosused(paarid, lauaKaardid, kasutamataKaardid, meetod);

        System.out.println(" ------ TÕENÄOSUSED VÕITMISEKS ------ " + System.lineSeparator());

        for(Paar paar : paarid){
            System.out.println("PAAR " + paariArv + " (" +paar+ ") : "+ (int)(tõenäosus.getPaariTõenäosused().get(paar)*100) + "%" + System.lineSeparator());
            paariArv ++;
        }
        System.out.println("Spliti tõenäosus: " + (int)(tõenäosus.getSplitiTõenäosus()*100) + "%" + System.lineSeparator());
    }

    public static Tõenäosused arvutaTõenäosused(ArrayList<Paar> paarid, ArrayList<Kaart> lauaKaardid, ArrayList<Kaart> kasutamataKaardid, Meetodid meetod){
        HashMap<Paar, Double> paarideTulemus = new HashMap<>();
        for(Paar paar : paarid){
            paarideTulemus.put(paar, 0.0);
        }

        int split = 0;

        Map<Paar, Integer> enneTulemust = new HashMap<>();

        if(lauaKaardid.size() == 3){
            for(int kaart1 = 0; kaart1 < kasutamataKaardid.size() - 1; kaart1++ ){
                for(int kaart2 = kaart1 + 1; kaart2 < kasutamataKaardid.size(); kaart2++ ){
                    Map<Paar, Kombinatsioon> kõrgemadKombinatsioonid = new HashMap<>();
                    for(Paar paar : paarid){
                        ArrayList<Kaart> vaadeldavadKaardid = new ArrayList<>(lauaKaardid);
                        Collections.addAll(vaadeldavadKaardid, paar.getEsimeneKaart(), paar.getTeineKaart(), kasutamataKaardid.get(kaart1), kasutamataKaardid.get(kaart2));

                        Kombinatsioon kõrgemKombinatsioon = meetod.highCard(vaadeldavadKaardid);
                        if (meetod.Pair(vaadeldavadKaardid).onEsineb()){
                            kõrgemKombinatsioon = meetod.Pair(vaadeldavadKaardid);
                        } if (meetod.twoPairs(vaadeldavadKaardid).onEsineb()){
                            kõrgemKombinatsioon = meetod.twoPairs(vaadeldavadKaardid);
                        } if (meetod.threeOfAKind(vaadeldavadKaardid).onEsineb()){
                            kõrgemKombinatsioon = meetod.threeOfAKind(vaadeldavadKaardid);
                        } if (meetod.straight(vaadeldavadKaardid).onEsineb()){
                            kõrgemKombinatsioon = meetod.straight(vaadeldavadKaardid);
                        } if (meetod.flush(vaadeldavadKaardid).onEsineb()){
                            kõrgemKombinatsioon = meetod.flush(vaadeldavadKaardid);
                        } if (meetod.fullHouse(vaadeldavadKaardid).onEsineb()){
                            kõrgemKombinatsioon = meetod.fullHouse(vaadeldavadKaardid);
                        } if (meetod.fourOfAKind(vaadeldavadKaardid).onEsineb()){
                            kõrgemKombinatsioon = meetod.fourOfAKind(vaadeldavadKaardid);
                        } if (meetod.straightFlush(vaadeldavadKaardid).onEsineb()){
                            kõrgemKombinatsioon = meetod.straightFlush(vaadeldavadKaardid);
                        } if (meetod.royalFlush(vaadeldavadKaardid).onEsineb()){
                            kõrgemKombinatsioon = meetod.royalFlush(vaadeldavadKaardid);
                        }
                        kõrgemadKombinatsioonid.put(paar, kõrgemKombinatsioon);
                    }

                    Map<Paar, Kombinatsioon> kõrgeimad = new HashMap<>();
                    int kõrgeimaKombinatsiooniNumber = 0;
                    for(Paar paar : paarid){
                        if(kõrgemadKombinatsioonid.get(paar).getKombinatsioon() > kõrgeimaKombinatsiooniNumber){
                            kõrgeimad.clear();
                            kõrgeimad.put(paar, kõrgemadKombinatsioonid.get(paar));
                            kõrgeimaKombinatsiooniNumber = kõrgemadKombinatsioonid.get(paar).getKombinatsioon();
                        } else if(kõrgemadKombinatsioonid.get(paar).getKombinatsioon() == kõrgeimaKombinatsiooniNumber){
                            kõrgeimad.put(paar, kõrgemadKombinatsioonid.get(paar));
                        }
                    }
                    System.out.println(kaart1 +" "+ kaart2 +" "+ kõrgeimad + "   " + kasutamataKaardid.get(kaart1) +" "+ kasutamataKaardid.get(kaart2));

                    if(kõrgeimad.size() == 1){
                        for(Paar paar : kõrgeimad.keySet()){
                            if(enneTulemust.containsKey(paar)){
                                enneTulemust.put(paar, enneTulemust.get(paar) + 1);
                            } else {
                                enneTulemust.put(paar, 1);
                            }
                        }
                    } else {

                        for(int index = 4; index > -1; index-- ){
                            int kõrgeim = 0;
                            for(Paar paar : kõrgeimad.keySet()){
                                if(kõrgeimad.get(paar).getKõrgemadKaardid().get(index) == 1){
                                    kõrgeim = 1;
                                    break;
                                } else if(kõrgeimad.get(paar).getKõrgemadKaardid().get(index) > kõrgeim){
                                    kõrgeim = kõrgeimad.get(paar).getKõrgemadKaardid().get(index);
                                }
                            }

                            if(kõrgeim == 1){
                                ArrayList<Paar> kustutatavad = new ArrayList<>();
                                for(Paar paar : kõrgeimad.keySet()){
                                    if(kõrgeimad.get(paar).getKõrgemadKaardid().get(index) != 1){
                                        kustutatavad.add(paar);
                                    }
                                }
                                for(Paar paar : kustutatavad){
                                    kõrgeimad.remove(paar);
                                }
                                kustutatavad.clear();
                            } else {
                                ArrayList<Paar> kustutatavad = new ArrayList<>();
                                for(Paar paar : kõrgeimad.keySet()){
                                    if(kõrgeimad.get(paar).getKõrgemadKaardid().get(index) < kõrgeim){
                                        kustutatavad.add(paar);
                                    }
                                }
                                for(Paar paar : kustutatavad){
                                    kõrgeimad.remove(paar);
                                }
                                kustutatavad.clear();
                            }
                        }
                        if(kõrgeimad.size() > 1){
                            split += 1;
                            System.out.println("Split = " + split);
                        } else {
                            for(Paar paar : kõrgeimad.keySet()){
                                System.out.println(paar + " --- " + kõrgeimad.get(paar));
                                if(enneTulemust.containsKey(paar)){
                                    enneTulemust.put(paar, enneTulemust.get(paar) + 1);
                                } else {
                                    enneTulemust.put(paar, 1);
                                }
                            }
                        }
                    }
                }
            }
        } else if(lauaKaardid.size() == 4){
            for(int kaart1 = 0; kaart1 < kasutamataKaardid.size(); kaart1++){
                Map<Paar, Kombinatsioon> kõrgemadKombinatsioonid = new HashMap<>();
                for(Paar paar : paarid){
                    ArrayList<Kaart> vaadeldavadKaardid = new ArrayList<>(lauaKaardid);
                    Collections.addAll(vaadeldavadKaardid, paar.getEsimeneKaart(), paar.getTeineKaart(), kasutamataKaardid.get(kaart1));

                    Kombinatsioon kõrgemKombinatsioon = meetod.highCard(vaadeldavadKaardid);
                    if (meetod.Pair(vaadeldavadKaardid).onEsineb()){
                        kõrgemKombinatsioon = meetod.Pair(vaadeldavadKaardid);
                    } if (meetod.twoPairs(vaadeldavadKaardid).onEsineb()){
                        kõrgemKombinatsioon = meetod.twoPairs(vaadeldavadKaardid);
                    } if (meetod.threeOfAKind(vaadeldavadKaardid).onEsineb()){
                        kõrgemKombinatsioon = meetod.threeOfAKind(vaadeldavadKaardid);
                    } if (meetod.straight(vaadeldavadKaardid).onEsineb()){
                        kõrgemKombinatsioon = meetod.straight(vaadeldavadKaardid);
                    } if (meetod.flush(vaadeldavadKaardid).onEsineb()){
                        kõrgemKombinatsioon = meetod.flush(vaadeldavadKaardid);
                    } if (meetod.fullHouse(vaadeldavadKaardid).onEsineb()){
                        kõrgemKombinatsioon = meetod.fullHouse(vaadeldavadKaardid);
                    } if (meetod.fourOfAKind(vaadeldavadKaardid).onEsineb()){
                        kõrgemKombinatsioon = meetod.fourOfAKind(vaadeldavadKaardid);
                    } if (meetod.straightFlush(vaadeldavadKaardid).onEsineb()){
                        kõrgemKombinatsioon = meetod.straightFlush(vaadeldavadKaardid);
                    } if (meetod.royalFlush(vaadeldavadKaardid).onEsineb()){
                        kõrgemKombinatsioon = meetod.royalFlush(vaadeldavadKaardid);
                    }
                    kõrgemadKombinatsioonid.put(paar, kõrgemKombinatsioon);
                }

                Map<Paar, Kombinatsioon> kõrgeimad = new HashMap<>();
                int kõrgeimaKombinatsiooniNumber = 0;
                for(Paar paar : paarid){
                    if(kõrgemadKombinatsioonid.get(paar).getKombinatsioon() > kõrgeimaKombinatsiooniNumber){
                        kõrgeimad.clear();
                        kõrgeimad.put(paar, kõrgemadKombinatsioonid.get(paar));
                        kõrgeimaKombinatsiooniNumber = kõrgemadKombinatsioonid.get(paar).getKombinatsioon();
                    } else if(kõrgemadKombinatsioonid.get(paar).getKombinatsioon() == kõrgeimaKombinatsiooniNumber){
                        kõrgeimad.put(paar, kõrgemadKombinatsioonid.get(paar));
                    }
                }
                System.out.println(kaart1 +" "+ kõrgeimad + "   " + kasutamataKaardid.get(kaart1));

                if(kõrgeimad.size() == 1){
                    for(Paar paar : kõrgeimad.keySet()){
                        if(enneTulemust.containsKey(paar)){
                            enneTulemust.put(paar, enneTulemust.get(paar) + 1);
                        } else {
                            enneTulemust.put(paar, 1);
                        }
                    }
                } else {

                    for(int index = 4; index > -1; index-- ){
                        int kõrgeim = 0;
                        for(Paar paar : kõrgeimad.keySet()){
                            if(kõrgeimad.get(paar).getKõrgemadKaardid().get(index) == 1){
                                kõrgeim = 1;
                                break;
                            } else if(kõrgeimad.get(paar).getKõrgemadKaardid().get(index) > kõrgeim){
                                kõrgeim = kõrgeimad.get(paar).getKõrgemadKaardid().get(index);
                            }
                        }

                        if(kõrgeim == 1){
                            ArrayList<Paar> kustutatavad = new ArrayList<>();
                            for(Paar paar : kõrgeimad.keySet()){
                                if(kõrgeimad.get(paar).getKõrgemadKaardid().get(index) != 1){
                                    kustutatavad.add(paar);
                                }
                            }
                            for(Paar paar : kustutatavad){
                                kõrgeimad.remove(paar);
                            }
                            kustutatavad.clear();
                        } else {
                            ArrayList<Paar> kustutatavad = new ArrayList<>();
                            for(Paar paar : kõrgeimad.keySet()){
                                if(kõrgeimad.get(paar).getKõrgemadKaardid().get(index) < kõrgeim){
                                    kustutatavad.add(paar);
                                }
                            }
                            for(Paar paar : kustutatavad){
                                kõrgeimad.remove(paar);
                            }
                            kustutatavad.clear();
                        }
                    }
                    if(kõrgeimad.size() > 1){
                        split += 1;
                        System.out.println("Split = " + split);
                    } else {
                        for(Paar paar : kõrgeimad.keySet()){
                            System.out.println(paar + " --- " + kõrgeimad.get(paar));
                            if(enneTulemust.containsKey(paar)){
                                enneTulemust.put(paar, enneTulemust.get(paar) + 1);
                            } else {
                                enneTulemust.put(paar, 1);
                            }
                        }
                    }
                }
            }
        } else if(lauaKaardid.size() == 5){
            Map<Paar, Kombinatsioon> kõrgemadKombinatsioonid = new HashMap<>();
            for(Paar paar : paarid){
                ArrayList<Kaart> vaadeldavadKaardid = new ArrayList<>(lauaKaardid);
                Collections.addAll(vaadeldavadKaardid, paar.getEsimeneKaart(), paar.getTeineKaart());

                Kombinatsioon kõrgemKombinatsioon = meetod.highCard(vaadeldavadKaardid);
                if (meetod.Pair(vaadeldavadKaardid).onEsineb()){
                    kõrgemKombinatsioon = meetod.Pair(vaadeldavadKaardid);
                } if (meetod.twoPairs(vaadeldavadKaardid).onEsineb()){
                    kõrgemKombinatsioon = meetod.twoPairs(vaadeldavadKaardid);
                } if (meetod.threeOfAKind(vaadeldavadKaardid).onEsineb()){
                    kõrgemKombinatsioon = meetod.threeOfAKind(vaadeldavadKaardid);
                } if (meetod.straight(vaadeldavadKaardid).onEsineb()){
                    kõrgemKombinatsioon = meetod.straight(vaadeldavadKaardid);
                } if (meetod.flush(vaadeldavadKaardid).onEsineb()){
                    kõrgemKombinatsioon = meetod.flush(vaadeldavadKaardid);
                } if (meetod.fullHouse(vaadeldavadKaardid).onEsineb()){
                    kõrgemKombinatsioon = meetod.fullHouse(vaadeldavadKaardid);
                } if (meetod.fourOfAKind(vaadeldavadKaardid).onEsineb()){
                    kõrgemKombinatsioon = meetod.fourOfAKind(vaadeldavadKaardid);
                } if (meetod.straightFlush(vaadeldavadKaardid).onEsineb()){
                    kõrgemKombinatsioon = meetod.straightFlush(vaadeldavadKaardid);
                } if (meetod.royalFlush(vaadeldavadKaardid).onEsineb()){
                    kõrgemKombinatsioon = meetod.royalFlush(vaadeldavadKaardid);
                }
                kõrgemadKombinatsioonid.put(paar, kõrgemKombinatsioon);
            }

            Map<Paar, Kombinatsioon> kõrgeimad = new HashMap<>();
            int kõrgeimaKombinatsiooniNumber = 0;
            for(Paar paar : paarid){
                if(kõrgemadKombinatsioonid.get(paar).getKombinatsioon() > kõrgeimaKombinatsiooniNumber){
                    kõrgeimad.clear();
                    kõrgeimad.put(paar, kõrgemadKombinatsioonid.get(paar));
                    kõrgeimaKombinatsiooniNumber = kõrgemadKombinatsioonid.get(paar).getKombinatsioon();
                } else if(kõrgemadKombinatsioonid.get(paar).getKombinatsioon() == kõrgeimaKombinatsiooniNumber){
                    kõrgeimad.put(paar, kõrgemadKombinatsioonid.get(paar));
                }
            }
            System.out.println(kõrgeimad);

            if(kõrgeimad.size() == 1){
                for(Paar paar : kõrgeimad.keySet()){
                    if(enneTulemust.containsKey(paar)){
                        enneTulemust.put(paar, enneTulemust.get(paar) + 1);
                    } else {
                        enneTulemust.put(paar, 1);
                    }
                }
            } else {

                for(int index = 4; index > -1; index-- ){
                    int kõrgeim = 0;
                    for(Paar paar : kõrgeimad.keySet()){
                        if(kõrgeimad.get(paar).getKõrgemadKaardid().get(index) == 1){
                            kõrgeim = 1;
                            break;
                        } else if(kõrgeimad.get(paar).getKõrgemadKaardid().get(index) > kõrgeim){
                            kõrgeim = kõrgeimad.get(paar).getKõrgemadKaardid().get(index);
                        }
                    }

                    if(kõrgeim == 1){
                        ArrayList<Paar> kustutatavad = new ArrayList<>();
                        for(Paar paar : kõrgeimad.keySet()){
                            if(kõrgeimad.get(paar).getKõrgemadKaardid().get(index) != 1){
                                kustutatavad.add(paar);
                            }
                        }
                        for(Paar paar : kustutatavad){
                            kõrgeimad.remove(paar);
                        }
                        kustutatavad.clear();
                    } else {
                        ArrayList<Paar> kustutatavad = new ArrayList<>();
                        for(Paar paar : kõrgeimad.keySet()){
                            if(kõrgeimad.get(paar).getKõrgemadKaardid().get(index) < kõrgeim){
                                kustutatavad.add(paar);
                            }
                        }
                        for(Paar paar : kustutatavad){
                            kõrgeimad.remove(paar);
                        }
                        kustutatavad.clear();
                    }
                }
                if(kõrgeimad.size() > 1){
                    split += 1;
                    System.out.println("Split = " + split);
                } else {
                    for(Paar paar : kõrgeimad.keySet()){
                        System.out.println(paar + " --- " + kõrgeimad.get(paar));
                        if(enneTulemust.containsKey(paar)){
                            enneTulemust.put(paar, enneTulemust.get(paar) + 1);
                        } else {
                            enneTulemust.put(paar, 1);
                        }
                    }
                }
            }
        }

        System.out.println(enneTulemust);

        int kõikVõimalused = 0;
        for(int i = 1; i < kasutamataKaardid.size(); i++ ){
            kõikVõimalused += i;
        }
        if(lauaKaardid.size() == 3){
            for (Paar paar : enneTulemust.keySet()){
                paarideTulemus.put(paar, new BigDecimal((double)enneTulemust.get(paar)/(double)kõikVõimalused).setScale(2, RoundingMode.HALF_UP).doubleValue());
            }
            return new Tõenäosused(new BigDecimal((double)split/(double)kõikVõimalused).setScale(2, RoundingMode.HALF_UP).doubleValue(), paarideTulemus);
        } else if(lauaKaardid.size() == 4){
            for (Paar paar : enneTulemust.keySet()) {
                paarideTulemus.put(paar, new BigDecimal((double) enneTulemust.get(paar) / (double)kasutamataKaardid.size()).setScale(2, RoundingMode.HALF_UP).doubleValue());
            }
            return new Tõenäosused(new BigDecimal((double) split / (double)kasutamataKaardid.size()).setScale(2, RoundingMode.HALF_UP).doubleValue(), paarideTulemus);
        } else if(lauaKaardid.size() == 5){
            for (Paar paar : enneTulemust.keySet()) {
                paarideTulemus.put(paar, new BigDecimal((double) enneTulemust.get(paar) / 1.0).setScale(2, RoundingMode.HALF_UP).doubleValue());
            }
            return new Tõenäosused(new BigDecimal((double) split / 1.0).setScale(2, RoundingMode.HALF_UP).doubleValue(), paarideTulemus);
        }
        return null;
    }








    public static void main(String[] args) {

        ArrayList<Kaart> kasutamataKaardid = new ArrayList<>();
        Collections.addAll(kasutamataKaardid,
                new Kaart("ärtu",1),
                new Kaart("ärtu",2),
                new Kaart("ärtu",3),
                new Kaart("ärtu",4),
                new Kaart("ärtu",5),
                new Kaart("ärtu",6),
                new Kaart("ärtu",7),
                new Kaart("ärtu",8),
                new Kaart("ärtu",9),
                new Kaart("ärtu",10),
                new Kaart("ärtu",11),
                new Kaart("ärtu",12),
                new Kaart("ärtu",13),
                new Kaart("ruutu",1),
                new Kaart("ruutu",2),
                new Kaart("ruutu",3),
                new Kaart("ruutu",4),
                new Kaart("ruutu",5),
                new Kaart("ruutu",6),
                new Kaart("ruutu",7),
                new Kaart("ruutu",8),
                new Kaart("ruutu",9),
                new Kaart("ruutu",10),
                new Kaart("ruutu",11),
                new Kaart("ruutu",12),
                new Kaart("ruutu",13),
                new Kaart("risti",1),
                new Kaart("risti",2),
                new Kaart("risti",3),
                new Kaart("risti",4),
                new Kaart("risti",5),
                new Kaart("risti",6),
                new Kaart("risti",7),
                new Kaart("risti",8),
                new Kaart("risti",9),
                new Kaart("risti",10),
                new Kaart("risti",11),
                new Kaart("risti",12),
                new Kaart("risti",13),
                new Kaart("poti",1),
                new Kaart("poti",2),
                new Kaart("poti",3),
                new Kaart("poti",4),
                new Kaart("poti",5),
                new Kaart("poti",6),
                new Kaart("poti",7),
                new Kaart("poti",8),
                new Kaart("poti",9),
                new Kaart("poti",10),
                new Kaart("poti",11),
                new Kaart("poti",12),
                new Kaart("poti",13));

        ArrayList<Kaart> kasutatudKaardid = new ArrayList<>();

        ArrayList<Kaart> lauaKaardid = new ArrayList<>();

        ArrayList<Paar> paarid = new ArrayList<>();

        Meetodid kombinatsiooniTõeväärtus = new Meetodid();

        System.out.println("");
        System.out.println("FLOPI SISESTAMINE"+System.lineSeparator());

        while(true){
            if(lauaKaardid.size() == 3){
                break;
            }
            Scanner sisestus = new Scanner(System.in);

            System.out.println("Sisestage flopi kaart('poti' v 'risti' v 'ärtu' v 'ruutu' + 'tühik' + 'number'(nt '1' - äss, '2' - 2, '13' - kuningas) : ");
            String kaartAlgvorm = sisestus.nextLine();
            String[] eraldatud= kaartAlgvorm.split(" ");
            Kaart ajutine = new Kaart(eraldatud[0], Integer.parseInt(eraldatud[1]));

            boolean kasOnListis = false;
            for(Kaart elem : kasutatudKaardid){
                if(ajutine.equals(elem)){
                    kasOnListis = true;
                }
            }

            if(kasOnListis){
                System.out.println("Selline kaart on juba kasutuses, valige uus!");
            } else {
                kasutatudKaardid.add(new Kaart(eraldatud[0], Integer.parseInt(eraldatud[1])));
                kasutamataKaardid.remove(new Kaart(eraldatud[0], Integer.parseInt(eraldatud[1])));
                lauaKaardid.add(new Kaart(eraldatud[0], Integer.parseInt(eraldatud[1])));
                System.out.println("Sisestatud kaart: "+ kasutatudKaardid.get(kasutatudKaardid.size()-1));
            }

            System.out.println(" ");
        }

        System.out.println("");
        System.out.println("PAARIDE SISESTAMINE"+System.lineSeparator());

        while(true){
            if(paarid.size() > 20){
                break;
            }

            Scanner sisestus = new Scanner(System.in);

            System.out.println("Sisestage paari esimene kaart('poti' v 'risti' v 'ärtu' v 'ruutu' + 'tühik' + 'number'(nt '1' - äss, '2' - 2, '13' - kuningas) : ");
            String esimeneKaartAlgvorm = sisestus.nextLine();
            String[] eraldatud1 = esimeneKaartAlgvorm.split(" ");
            Kaart ajutine1 = new Kaart(eraldatud1[0], Integer.parseInt(eraldatud1[1]));

            boolean kasOnListis1 = false;
            for(Kaart elem : kasutatudKaardid){
                if(ajutine1.equals(elem)){
                    kasOnListis1 = true;
                }
            }

            System.out.println("Sisestage paari teine kaart('poti' v 'risti' v 'ärtu' v 'ruutu' + 'tühik' + 'number'(nt '1' - äss, '2' - 2, '13' - kuningas) : ");
            String teineKaartAlgvorm = sisestus.nextLine();
            String[] eraldatud2 = teineKaartAlgvorm.split(" ");
            Kaart ajutine2 = new Kaart(eraldatud2[0], Integer.parseInt(eraldatud2[1]));

            boolean kasOnListis2 = false;
            for(Kaart elem : kasutatudKaardid){
                if(ajutine2.equals(elem)){
                    kasOnListis2 = true;
                }
            }

            if(kasOnListis1 || kasOnListis2){
                System.out.println("Valitud kaardid/kaart on juba kasutuses, valige uus paar!");
            } else {
                kasutatudKaardid.add(new Kaart(eraldatud1[0], Integer.parseInt(eraldatud1[1])));
                kasutatudKaardid.add(new Kaart(eraldatud2[0], Integer.parseInt(eraldatud2[1])));
                System.out.println("Sisestatud paar: "+ kasutatudKaardid.get(kasutatudKaardid.size()-1) + " " + kasutatudKaardid.get(kasutatudKaardid.size()-2)+System.lineSeparator());
                kasutamataKaardid.remove(new Kaart(eraldatud1[0], Integer.parseInt(eraldatud1[1])));
                kasutamataKaardid.remove(new Kaart(eraldatud2[0], Integer.parseInt(eraldatud2[1])));
                paarid.add(new Paar(ajutine1, ajutine2));


                boolean lõpetab = false;

                while(true){
                    System.out.println("Kas soovite veel kaardipaare lisada?(y/n) : ");
                    String otsus = sisestus.nextLine();
                    if(otsus.equals("y") || otsus.equals("n")){
                        if(otsus.equals("n")){
                            lõpetab = true;
                        }
                        break;
                    } else {
                        System.out.println("Väär sisestus, sisestage uuesti!"+System.lineSeparator());
                    }
                }

                if(lõpetab){
                    System.out.println(" ");
                    break;
                }
            }

            System.out.println(" ");
        }

        väljastaTõenäosused(1, paarid, lauaKaardid, kasutamataKaardid, kombinatsiooniTõeväärtus);

        while(true){
            Scanner sisestus = new Scanner(System.in);
            System.out.print("Sisestage turni kaart('poti' v 'risti' v 'ärtu' v 'ruutu' + 'tühik' + 'number'(nt '1' - äss, '2' - 2, '13' - kuningas) : ");
            String kaartAlgvorm = sisestus.nextLine();
            String[] eraldatud = kaartAlgvorm.split(" ");
            Kaart ajutine = new Kaart(eraldatud[0], Integer.parseInt(eraldatud[1]));

            boolean kasOnListis = false;
            for(Kaart elem : kasutatudKaardid){
                if(ajutine.equals(elem)){
                    kasOnListis = true;
                }
            }

            if(kasOnListis){
                System.out.println("Selline kaart on juba kasutuses, valige uus!");
            } else {
                kasutatudKaardid.add(new Kaart(eraldatud[0], Integer.parseInt(eraldatud[1])));
                kasutamataKaardid.remove(new Kaart(eraldatud[0], Integer.parseInt(eraldatud[1])));
                lauaKaardid.add(new Kaart(eraldatud[0], Integer.parseInt(eraldatud[1])));
                System.out.println("Sisestatud kaart: "+ kasutatudKaardid.get(kasutatudKaardid.size()-1)+System.lineSeparator());
                break;
            }


        }

        väljastaTõenäosused(1, paarid, lauaKaardid, kasutamataKaardid, kombinatsiooniTõeväärtus);

        while(true){
            Scanner sisestus = new Scanner(System.in);
            System.out.print("Sisestage riveri kaart('poti' v 'risti' v 'ärtu' v 'ruutu' + 'tühik' + 'number'(nt '1' - äss, '2' - 2, '13' - kuningas) : ");
            String kaartAlgvorm = sisestus.nextLine();
            String[] eraldatud = kaartAlgvorm.split(" ");
            Kaart ajutine = new Kaart(eraldatud[0], Integer.parseInt(eraldatud[1]));

            boolean kasOnListis = false;
            for(Kaart elem : kasutatudKaardid){
                if(ajutine.equals(elem)){
                    kasOnListis = true;
                }
            }

            if(kasOnListis){
                System.out.println("Selline kaart on juba kasutuses, valige uus!");
            } else {
                kasutatudKaardid.add(new Kaart(eraldatud[0], Integer.parseInt(eraldatud[1])));
                kasutamataKaardid.remove(new Kaart(eraldatud[0], Integer.parseInt(eraldatud[1])));
                lauaKaardid.add(new Kaart(eraldatud[0], Integer.parseInt(eraldatud[1])));
                System.out.println("Sisestatud kaart: "+ kasutatudKaardid.get(kasutatudKaardid.size()-1)+System.lineSeparator());
                break;
            }


        }

        väljastaTõenäosused(1, paarid, lauaKaardid, kasutamataKaardid, kombinatsiooniTõeväärtus);

        System.out.println("PROGRAMMI LÕPP.");



    }
}
