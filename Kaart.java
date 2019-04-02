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
    public String toString() {
        return "{" + mast + '-' + väärtus + '}';
    }

    @Override
    public int compareTo(Kaart võrreldav) {
        if (getVäärtus() > võrreldav.getVäärtus()) return 1;
        if (getVäärtus() < võrreldav.getVäärtus()) return -1;
        return 0;
    }
}
