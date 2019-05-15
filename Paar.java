package oop;
public class Paar {
    private Kaart esimeneKaart;
    private Kaart teineKaart;

    public Paar(Kaart esimeneKaart, Kaart teineKaart){
        this.esimeneKaart = esimeneKaart;
        this.teineKaart = teineKaart;
    }

    @Override
    public String toString() {
        return esimeneKaart + " " + teineKaart;
    }

    public Kaart getEsimeneKaart() {
        return esimeneKaart;
    }

    public Kaart getTeineKaart() {
        return teineKaart;
    }
}
