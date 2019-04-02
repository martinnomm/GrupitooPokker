import java.util.Arrays;

public class TestKlass {

    public static void main(String[] args) {
        Kaart[] kaardiList = new Kaart[]{
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
                new Kaart("poti",13)
        };

        Kaart[] kaardid = new Kaart[]{
                new Kaart("ärtu",8),
                new Kaart("ruutu",8),
                new Kaart("ärtu",9),
                new Kaart("ärtu",10),
                new Kaart("ärtu",11),
                new Kaart("ärtu",12),
                new Kaart("ärtu",13),
                new Kaart("ärtu",1),
                new Kaart("ruutu",1),
                new Kaart("poti", 1),
                new Kaart("risti",1)};

        Meetodid meetodid = new Meetodid();

        System.out.println("Royal Flush " + meetodid.royalFlush(kaardid));
        System.out.println("Straight Flush " + meetodid.straightFlush(kaardid));
        System.out.println("Four of a Kind " + meetodid.fourOfAKind(kaardid));
        System.out.println("Full house " + meetodid.fullHouse(kaardid));
        System.out.println("Flush " + meetodid.flush(kaardid));
        System.out.println("Straight " + meetodid.straight(kaardid));
        System.out.println("Three of a Kind " + meetodid.threeOfAKind(kaardid));
        System.out.println("Two pairs " + meetodid.twoPairs(kaardid));
        System.out.println("Pair " + meetodid.Pair(kaardid));
    }
}
