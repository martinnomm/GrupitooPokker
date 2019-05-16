import java.util.ArrayList;

public class Kombinatsioon {
    private int kombinatsioon;
    private boolean esineb;
    private ArrayList<Integer> kõrgemadKaardid;

    public Kombinatsioon(int kombinatsioon, boolean esineb, ArrayList<Integer> kõrgemadKaardid) {
        this.kombinatsioon = kombinatsioon;
        this.esineb = esineb;
        this.kõrgemadKaardid = kõrgemadKaardid;
    }

    public int getKombinatsioon() {
        return kombinatsioon;
    }

    public boolean onEsineb() {
        return esineb;
    }

    public ArrayList<Integer> getKõrgemadKaardid() {
        return kõrgemadKaardid;
    }

    @Override
    public String toString() {
        return "Kombinatsioon{" +
                "kombinatsioon=" + kombinatsioon +
                ", esineb=" + esineb +
                ", kõrgemadKaardid=" + kõrgemadKaardid +
                '}';
    }
}
