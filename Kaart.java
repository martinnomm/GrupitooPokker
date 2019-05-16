import java.util.Objects;

public class Kaart implements Comparable<Kaart> {
    private String mast;
    private int väärtus;

    public Kaart(String mast, int väärtus) {
        this.mast = mast;
        this.väärtus = väärtus;
    }

    public String getMast() {
        return mast;
    }

    public int getVäärtus() {
        return väärtus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kaart kaart = (Kaart) o;
        return väärtus == kaart.väärtus &&
                Objects.equals(mast, kaart.mast);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mast, väärtus);
    }

    @Override 
    public String toString() {

        switch (väärtus){
            case 1:
                return "{" + mast + '-' + "äss" + '}';
            case 2:
                return "{" + mast + '-' + "2" + '}';
            case 3:
                return "{" + mast + '-' + "3" + '}';
            case 4:
                return "{" + mast + '-' + "4" + '}';
            case 5:
                return "{" + mast + '-' + "5" + '}';
            case 6:
                return "{" + mast + '-' + "6" + '}';
            case 7:
                return "{" + mast + '-' + "7" + '}';
            case 8:
                return "{" + mast + '-' + "8" + '}';
            case 9:
                return "{" + mast + '-' + "9" + '}';
            case 10:
                return "{" + mast + '-' + "10" + '}';
            case 11:
                return "{" + mast + '-' + "poiss" + '}';
            case 12:
                return "{" + mast + '-' + "emand" + '}';
            case 13:
                return "{" + mast + '-' + "kuningas" + '}';
        }
        return "Kaardi sisestatud valesti.";
    }

    @Override
    public int compareTo(Kaart võrreldav) {
        if (getVäärtus() > võrreldav.getVäärtus()) return 1;
        if (getVäärtus() < võrreldav.getVäärtus()) return -1;
        return 0;
    }

    public void setMast(String mast) {
        this.mast = mast;
    }

    public void setVäärtus(int väärtus) {
        this.väärtus = väärtus;
    }
}
