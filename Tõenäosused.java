import java.util.Map;

public class Tõenäosused {
    private double splitiTõenäosus;
    private Map<Paar, Double> paariTõenäosused;

    public Tõenäosused(double splitiTõenäosus, Map<Paar, Double> paariTõenäosused) {
        this.splitiTõenäosus = splitiTõenäosus;
        this.paariTõenäosused = paariTõenäosused;
    }

    public double getSplitiTõenäosus() {
        return splitiTõenäosus;
    }

    public Map<Paar, Double> getPaariTõenäosused() {
        return paariTõenäosused;
    }
}
