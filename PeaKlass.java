package oop;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
public class PeaKlass extends Application {

    Scene sceneMenu,sceneMast,sceneVäärtus,scenePaar,sceneTõenäosused;
    static String hetkeMast;
    Label labelMastPealkiri = new Label();
    Label labelsplitiTN = new Label();
    String paariOsa1,paariOsa2 = null;
    boolean paariValimine = true;
    HBox lahtrid = new HBox();



    @Override
    public void start(Stage aken) {

        ArrayList<Kaart> kasutamataKaardid = looKasutamataKaardid();

        ArrayList<Kaart> kasutatudKaardid = new ArrayList<>();

        ArrayList<Kaart> lauaKaardid = new ArrayList<>();

        ArrayList<Paar> paarid = new ArrayList<>();

        Meetodid meetodid = new Meetodid();

        // Stseen Menu, start ja exit
        Button buttonMenuExit = new Button("EXIT"); buttonMenuExit.setMinSize(180,90); buttonMenuExit.setFont(new Font(40));
        Button buttonMenuStart = new Button("START"); buttonMenuStart.setMinSize(200,100); buttonMenuStart.setFont(new Font(40));
        buttonMenuExit.setOnAction(e -> aken.close());
        buttonMenuStart.setOnAction(e -> aken.setScene(sceneMast));
        VBox layoutMenu = new VBox();
        layoutMenu.getChildren().addAll(buttonMenuStart, buttonMenuExit);
        layoutMenu.setAlignment(Pos.CENTER); layoutMenu.setSpacing(10);
        sceneMenu = new Scene(layoutMenu,400,400);

        // Stseen Mast
        labelMastPealkiri = new Label("Flopi  esimene kaart"); labelMastPealkiri.setFont(new Font(20));
        Button buttonMastRuutu = new Button(/*Ruutu -> */"\u2666"); buttonMastRuutu.setFont(new Font(40));
        buttonMastRuutu.setOnAction(e -> mastiNupuVajutus("ruutu",aken,sceneVäärtus)); buttonMastRuutu.setStyle("-fx-text-fill: red");
        Button buttonMastRisti = new Button(/*Risti -> */"\u2663"); buttonMastRisti.setFont(new Font(40));
        buttonMastRisti.setOnAction(e -> mastiNupuVajutus("risti",aken,sceneVäärtus));
        Button buttonMastÄrtu = new Button(/*Ärtu -> */"\u2665"); buttonMastÄrtu.setFont(new Font(40));
        buttonMastÄrtu.setOnAction(e -> mastiNupuVajutus("ärtu",aken,sceneVäärtus)); buttonMastÄrtu.setStyle("-fx-text-fill: red");
        Button buttonMastPoti = new Button(/*Poti -> */"\u2660"); buttonMastPoti.setFont(new Font(40));
        buttonMastPoti.setOnAction(e -> mastiNupuVajutus("poti",aken,sceneVäärtus));
        VBox layoutMast = new VBox();
        HBox layoutMastSise = new HBox();
        this.labelMastPealkiri.setFont(new Font(30));
        layoutMastSise.getChildren().addAll(buttonMastPoti,buttonMastRisti,buttonMastÄrtu,buttonMastRuutu);
        layoutMast.getChildren().addAll(labelMastPealkiri,layoutMastSise);
        layoutMast.setAlignment(Pos.CENTER); layoutMast.setSpacing(5); layoutMast.setPadding(new Insets(10));
        layoutMastSise.setAlignment(Pos.CENTER); layoutMastSise.setSpacing(5);
        sceneMast = new Scene(layoutMast,400,400);

        // Stseen Väärtus
        Label labelVäärtusPealkiri = new Label("Vali kaardi väärtus"); labelVäärtusPealkiri.setFont(new Font(30));
        Button buttonVäärtus1 = new Button("äss"); buttonVäärtus1.setOnAction(e -> väärtuseNupuVajutus("1",aken,sceneMast,kasutamataKaardid,kasutatudKaardid,lauaKaardid,paarid, scenePaar, meetodid));
        Button buttonVäärtus2 = new Button("2"); buttonVäärtus2.setOnAction(e -> väärtuseNupuVajutus("2",aken,sceneMast,kasutamataKaardid,kasutatudKaardid,lauaKaardid,paarid, scenePaar, meetodid));
        Button buttonVäärtus3 = new Button("3"); buttonVäärtus3.setOnAction(e -> väärtuseNupuVajutus("3",aken,sceneMast,kasutamataKaardid,kasutatudKaardid,lauaKaardid,paarid, scenePaar, meetodid));
        Button buttonVäärtus4 = new Button("4"); buttonVäärtus4.setOnAction(e -> väärtuseNupuVajutus("4",aken,sceneMast,kasutamataKaardid,kasutatudKaardid,lauaKaardid,paarid, scenePaar, meetodid));
        Button buttonVäärtus5 = new Button("5"); buttonVäärtus5.setOnAction(e -> väärtuseNupuVajutus("5",aken,sceneMast,kasutamataKaardid,kasutatudKaardid,lauaKaardid,paarid, scenePaar, meetodid));
        Button buttonVäärtus6 = new Button("6"); buttonVäärtus6.setOnAction(e -> väärtuseNupuVajutus("6",aken,sceneMast,kasutamataKaardid,kasutatudKaardid,lauaKaardid,paarid, scenePaar, meetodid));
        Button buttonVäärtus7 = new Button("7"); buttonVäärtus7.setOnAction(e -> väärtuseNupuVajutus("7",aken,sceneMast,kasutamataKaardid,kasutatudKaardid,lauaKaardid,paarid, scenePaar, meetodid));
        Button buttonVäärtus8 = new Button("8"); buttonVäärtus8.setOnAction(e -> väärtuseNupuVajutus("8",aken,sceneMast,kasutamataKaardid,kasutatudKaardid,lauaKaardid,paarid, scenePaar, meetodid));
        Button buttonVäärtus9 = new Button("9"); buttonVäärtus9.setOnAction(e -> väärtuseNupuVajutus("9",aken,sceneMast,kasutamataKaardid,kasutatudKaardid,lauaKaardid,paarid, scenePaar, meetodid));
        Button buttonVäärtus10 = new Button("10"); buttonVäärtus10.setOnAction(e -> väärtuseNupuVajutus("10",aken,sceneMast,kasutamataKaardid,kasutatudKaardid,lauaKaardid,paarid, scenePaar, meetodid));
        Button buttonVäärtus11 = new Button("poiss"); buttonVäärtus11.setOnAction(e -> väärtuseNupuVajutus("11",aken,sceneMast,kasutamataKaardid,kasutatudKaardid,lauaKaardid,paarid, scenePaar, meetodid));
        Button buttonVäärtus12 = new Button("emand"); buttonVäärtus12.setOnAction(e -> väärtuseNupuVajutus("12",aken,sceneMast,kasutamataKaardid,kasutatudKaardid,lauaKaardid,paarid, scenePaar, meetodid));
        Button buttonVäärtus13 = new Button("kuningas"); buttonVäärtus13.setOnAction(e -> väärtuseNupuVajutus("13",aken,sceneMast,kasutamataKaardid,kasutatudKaardid,lauaKaardid,paarid, scenePaar, meetodid));
        VBox layoutVäärtus = new VBox();
        HBox layoutVäärtusRida1 = new HBox(); HBox layoutVäärtusRida2 = new HBox(); HBox layoutVäärtusRida3 = new HBox();
        layoutVäärtusRida1.getChildren().addAll(buttonVäärtus1,buttonVäärtus2,buttonVäärtus3,buttonVäärtus4,buttonVäärtus5);
        layoutVäärtusRida2.getChildren().addAll(buttonVäärtus6,buttonVäärtus7,buttonVäärtus8,buttonVäärtus9,buttonVäärtus10);
        layoutVäärtusRida3.getChildren().addAll(buttonVäärtus11,buttonVäärtus12,buttonVäärtus13);
        layoutVäärtus.getChildren().addAll(labelVäärtusPealkiri,layoutVäärtusRida1,layoutVäärtusRida2,layoutVäärtusRida3);
        layoutVäärtusRida1.setSpacing(10); layoutVäärtusRida1.setAlignment(Pos.CENTER);
        layoutVäärtusRida2.setSpacing(10); layoutVäärtusRida2.setAlignment(Pos.CENTER);
        layoutVäärtusRida3.setSpacing(10); layoutVäärtusRida3.setAlignment(Pos.CENTER);
        layoutVäärtus.setSpacing(5); layoutVäärtus.setAlignment(Pos.CENTER);
        sceneVäärtus = new Scene(layoutVäärtus,400,400);

        // Stseen Paar
        Label labelPaarPealkiri = new Label("Kas soovite lisada juurde paari?"); labelPaarPealkiri.setFont(new Font(25));
        Button buttonPaarJah = new Button("JAH"); buttonPaarJah.setOnAction(e -> paariLisamiseNupuVajutus(true,aken,sceneMast, paarid, lauaKaardid, kasutamataKaardid, meetodid));
        Button buttonPaarEi = new Button("EI"); buttonPaarEi.setOnAction(e -> paariLisamiseNupuVajutus(false,aken,sceneTõenäosused, paarid, lauaKaardid, kasutamataKaardid, meetodid));
        buttonPaarEi.setFont(new Font(20)); buttonPaarJah.setFont(new Font(20));
        VBox layoutPaar = new VBox(); layoutPaar.setAlignment(Pos.CENTER); layoutPaar.setSpacing(10);
        HBox layoutPaarSise = new HBox(); layoutPaarSise.setAlignment(Pos.CENTER); layoutPaarSise.setSpacing(20);
        layoutPaarSise.getChildren().addAll(buttonPaarJah,buttonPaarEi);
        layoutPaar.getChildren().addAll(labelPaarPealkiri,layoutPaarSise);
        scenePaar = new Scene(layoutPaar,400,400);

        // Stseen tõenäosus
        Label labelTõenäosus = new Label("Paaride võidu tõenäosused on:"); labelTõenäosus.setFont(new Font(20));
        this.labelsplitiTN = new Label("Spliti tõenäosus on: ");
        VBox layoutTõenäosus = new VBox();
        layoutTõenäosus.setSpacing(10);
        Button buttonTõenäosus = new Button("Turni kaart"); buttonTõenäosus.setOnAction(e -> tõenäosuseNupuVajutus(aken, sceneMast, buttonTõenäosus, lauaKaardid));
        layoutTõenäosus.minHeight(200);
        layoutTõenäosus.setAlignment(Pos.CENTER);
        ScrollPane layoutTõenäosusScroll = new ScrollPane();
        layoutTõenäosusScroll.setPadding(new Insets(10));
        this.lahtrid.setSpacing(5);
        layoutTõenäosusScroll.setContent(this.lahtrid);
        layoutTõenäosusScroll.setPadding(new Insets(20));
        layoutTõenäosus.getChildren().addAll(labelTõenäosus, layoutTõenäosusScroll,this.labelsplitiTN,buttonTõenäosus);
        sceneTõenäosused = new Scene(layoutTõenäosus,400,400);


        aken.setTitle("PokkeriProgramm");
        aken.setScene(sceneMenu);
        aken.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void tõenäosuseNupuVajutus(Stage lava, Scene stseen,Button button, ArrayList<Kaart> lauakaardid) {
        if(lauakaardid.size() == 3) {
            labelMastPealkiri.setText("Turni kaart");
            lava.setScene(stseen);
            button.setText("Riveri kaart");
        } else if (lauakaardid.size() == 4) {
            labelMastPealkiri.setText("Riveri kaart");
            lava.setScene(stseen);
            button.setText("EXIT");
        } else if(lauakaardid.size()== 5) {
            lava.close();
        } else System.out.println("wat");
    }
    private void mastiNupuVajutus(String mast, Stage lava, Scene stseen){
        lava.setScene(stseen);
        hetkeMast = mast;
    }

    private void paariLisamiseNupuVajutus(boolean condition, Stage lava, Scene stseen, ArrayList<Paar> paarid, ArrayList<Kaart> lauaKaardid, ArrayList<Kaart> kasutamataKaardid, Meetodid meetodid) {
        if(condition && paarid.size() > 19) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Rohkem paare ei saa lisada!");
            alert.showAndWait();
        } else {
            lava.setScene(stseen);
            paariValimine = condition;
        }
        if(!condition) {
            for(Paar paar : paarid) {
                Label paariNimi = new Label("Paar: " + paar.toString());
                //////////// TÕENÄOSUSE SISESTUS  ////////////
                Label paariTN = new Label("" + kombinatsiooniTõenäosus(paar, lauaKaardid, kasutamataKaardid, 2,meetodid));
                VBox lahter = new VBox();
                lahter.getChildren().addAll(paariNimi,paariTN);
                lahter.setPadding(new Insets(10));
                lahter.setStyle("-fx-background-color: linear-gradient(#E4EAA2, #9CD672);");
                lahtrid.getChildren().add(lahter);
            }
            this.labelsplitiTN.setText("Spliti tõenäosus on: " + "");
            lava.setScene(stseen);
            paariValimine = condition;
        }
    }

    // Saatanast nupp, mida ma ei taha enam näha
    private void väärtuseNupuVajutus(String väärtus, Stage lava, Scene stseen,ArrayList<Kaart> kasutamataKaardid, ArrayList<Kaart> kasutatudKaardid, ArrayList<Kaart> lauaKaardid,ArrayList<Paar> paarid, Scene paariScene, Meetodid meetodid) {
        Kaart ajutine = new Kaart(hetkeMast, Integer.parseInt(väärtus));
        if(lauaKaardid.size() == 3 && paariValimine) { // Kui kolm kaarti laual, hakkab paaride sisestamine.
            if(paariOsa1 == null) { // Kui esimest kaarti pole, seab selle
                boolean kasOnListis = false;
                for(Kaart elem : kasutatudKaardid){
                    if(ajutine.equals(elem)) kasOnListis = true;
                }
                if(kasOnListis){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("See kaart on juba sisestatud!");
                    alert.showAndWait();
                } else {
                    kasutatudKaardid.add(new Kaart(hetkeMast,Integer.parseInt(väärtus)));
                    kasutamataKaardid.remove(new Kaart(hetkeMast,Integer.parseInt(väärtus)));
                    paariOsa1 = hetkeMast + " " + väärtus;
                }
                labelMastPealkiri.setText("Paari teine kaart");
                lava.setScene(stseen);
            } else { // Kui teist kaarti pole, seab selle
                boolean kasOnListis = false;
                for(Kaart elem : kasutatudKaardid){
                    if(ajutine.equals(elem)) kasOnListis = true;
                }
                if(kasOnListis){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("See kaart on juba sisestatud!");
                    alert.showAndWait();
                    lava.setScene(stseen);
                } else {
                    kasutatudKaardid.add(new Kaart(hetkeMast,Integer.parseInt(väärtus)));
                    kasutamataKaardid.remove(new Kaart(hetkeMast,Integer.parseInt(väärtus)));
                    paariOsa2 = hetkeMast + " " + väärtus;
                    String[] paar1Eraldi = paariOsa1.split(" "); String[] paar2Eraldi = paariOsa2.split(" ");
                    paarid.add(new Paar(new Kaart(paar1Eraldi[0],Integer.parseInt(paar1Eraldi[1])),new Kaart(paar2Eraldi[0],Integer.parseInt(paar2Eraldi[1]))));
                    paariOsa1 = null; paariOsa2 = null;
                    lava.setScene(paariScene);
                    labelMastPealkiri.setText("Paari esimene kaart");
                }

            }
        } else if((lauaKaardid.size() == 3 || lauaKaardid.size() == 4) && !paariValimine) {
            boolean kasOnListis = false;
            for(Kaart elem : kasutatudKaardid){
                if(ajutine.equals(elem)) kasOnListis = true;
            }
            if(kasOnListis){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("See kaart on juba sisestatud!");
                alert.showAndWait();
            } else {
                kasutatudKaardid.add(new Kaart(hetkeMast,Integer.parseInt(väärtus)));
                kasutamataKaardid.remove(new Kaart(hetkeMast,Integer.parseInt(väärtus)));
                lauaKaardid.add(new Kaart(hetkeMast,Integer.parseInt(väärtus)));
            }
            lava.setScene(sceneTõenäosused);
            this.lahtrid.getChildren().clear();
            for(Paar paar : paarid) {
                Label paariNimi = new Label("Paar: " + paar.toString());
                //////////// TÕENÄOSUSE SISESTUS  ////////////
                Label paariTN = new Label("" + kombinatsiooniTõenäosus(paar, lauaKaardid, kasutamataKaardid, 2,meetodid));
                VBox lahter = new VBox();
                lahter.getChildren().addAll(paariNimi,paariTN);
                lahter.setPadding(new Insets(10));
                lahter.setStyle("-fx-background-color: linear-gradient(#E4EAA2, #9CD672);");
                this.lahtrid.getChildren().add(lahter);
            }

            this.labelsplitiTN.setText("Spliti tõenäosus on: " + "");

        } else { // Kui on lauale kaartide panemise aeg
            boolean kasOnListis = false;
            for(Kaart elem : kasutatudKaardid){
                if(ajutine.equals(elem)) kasOnListis = true;
            }
            if(kasOnListis){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("See kaart on juba sisestatud!");
                alert.showAndWait();
            } else {
                kasutatudKaardid.add(new Kaart(hetkeMast,Integer.parseInt(väärtus)));
                kasutamataKaardid.remove(new Kaart(hetkeMast,Integer.parseInt(väärtus)));
                lauaKaardid.add(new Kaart(hetkeMast,Integer.parseInt(väärtus)));
                if (lauaKaardid.size() == 3) labelMastPealkiri.setText("Paari esimene kaart");
            }
            lava.setScene(stseen);
            switch (lauaKaardid.size()) {
                case 1: labelMastPealkiri.setText("Flopi teine kaart");
                    break;
                case 2: labelMastPealkiri.setText("Flopi kolmas kaart");
                    break;
                default:break;
            }
        }

    }

    private static ArrayList<Kaart> looKasutamataKaardid(){
        ArrayList<Kaart> tagastusList = new ArrayList<>();
        Collections.addAll(tagastusList,
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
        return tagastusList;
    }

    public static String kombinatsiooniTõenäosus(Paar paar, ArrayList<Kaart> lauaKaardid, ArrayList<Kaart> kasutamataKaardid, int kombinatsioon, Meetodid meetod){
        ArrayList<Kaart> vaadeldavadKaardid = new ArrayList<>();
        vaadeldavadKaardid.add(paar.getEsimeneKaart());
        vaadeldavadKaardid.add(paar.getTeineKaart());
        for(Kaart kaart : lauaKaardid){
            vaadeldavadKaardid.add(kaart);
        }

        if(kombinatsioon == 10){
            int soodsadKaardid = 0;
            if(meetod.royalFlush(vaadeldavadKaardid)){
                return "Esineb";
            } else {
                for(Kaart kaart : kasutamataKaardid){
                    vaadeldavadKaardid.add(kaart);
                    if(meetod.royalFlush(vaadeldavadKaardid)){
                        soodsadKaardid ++;
                    }
                    vaadeldavadKaardid.remove(kaart);
                }
                return " Ühe kaardi lisades on tõenäosus: "+(double)soodsadKaardid/(double)kasutamataKaardid.size();
            }
        }
        if(kombinatsioon == 9){
            int soodsadKaardid = 0;
            if(meetod.straightFlush(vaadeldavadKaardid)){
                return "Esineb";
            } else {
                for(Kaart kaart : kasutamataKaardid){
                    vaadeldavadKaardid.add(kaart);
                    if(meetod.straightFlush(vaadeldavadKaardid)){
                        soodsadKaardid ++;
                    }
                    vaadeldavadKaardid.remove(kaart);
                }
                return "Ühe kaardi lisades on tõenäosus: "+(double)soodsadKaardid/(double)kasutamataKaardid.size();
            }
        }
        if(kombinatsioon == 8){
            int soodsadKaardid = 0;
            if(meetod.fourOfAKind(vaadeldavadKaardid)){
                return "Esineb";
            } else {
                for(Kaart kaart : kasutamataKaardid){
                    vaadeldavadKaardid.add(kaart);
                    if(meetod.fourOfAKind(vaadeldavadKaardid)){
                        soodsadKaardid ++;
                    }
                    vaadeldavadKaardid.remove(kaart);
                }
                return "Ühe kaardi lisades on tõenäosus: "+(double)soodsadKaardid/(double)kasutamataKaardid.size();
            }
        }
        if(kombinatsioon == 7){
            int soodsadKaardid = 0;
            if(meetod.fullHouse(vaadeldavadKaardid)){
                return "Esineb";
            } else {
                for(Kaart kaart : kasutamataKaardid){
                    vaadeldavadKaardid.add(kaart);
                    if(meetod.fullHouse(vaadeldavadKaardid)){
                        soodsadKaardid ++;
                    }
                    vaadeldavadKaardid.remove(kaart);
                }
                return "Ühe kaardi lisades on tõenäosus: "+(double)soodsadKaardid/(double)kasutamataKaardid.size();
            }
        }
        if(kombinatsioon == 6){
            int soodsadKaardid = 0;
            if(meetod.flush(vaadeldavadKaardid)){
                return "Esineb";
            } else {
                for(Kaart kaart : kasutamataKaardid){
                    vaadeldavadKaardid.add(kaart);
                    if(meetod.flush(vaadeldavadKaardid)){
                        soodsadKaardid ++;
                    }
                    vaadeldavadKaardid.remove(kaart);
                }
                return "Ühe kaardi lisades on tõenäosus: "+(double)soodsadKaardid/(double)kasutamataKaardid.size();
            }
        }
        if(kombinatsioon == 5){
            int soodsadKaardid = 0;
            if(meetod.straight(vaadeldavadKaardid)){
                return "Esineb";
            } else {
                for(Kaart kaart : kasutamataKaardid){
                    vaadeldavadKaardid.add(kaart);
                    if(meetod.straight(vaadeldavadKaardid)){
                        soodsadKaardid ++;
                    }
                    vaadeldavadKaardid.remove(kaart);
                }
                return "Ühe kaardi lisades on tõenäosus: "+(double)soodsadKaardid/(double)kasutamataKaardid.size();
            }
        }
        if(kombinatsioon == 4){
            int soodsadKaardid = 0;
            if(meetod.threeOfAKind(vaadeldavadKaardid)){
                return "Esineb";
            } else {
                for(Kaart kaart : kasutamataKaardid){
                    vaadeldavadKaardid.add(kaart);
                    if(meetod.threeOfAKind(vaadeldavadKaardid)){
                        soodsadKaardid ++;
                    }
                    vaadeldavadKaardid.remove(kaart);
                }
                return "Ühe kaardi lisades on tõenäosus: "+(double)soodsadKaardid/(double)kasutamataKaardid.size();
            }
        }
        if(kombinatsioon == 3){
            int soodsadKaardid = 0;
            if(meetod.twoPairs(vaadeldavadKaardid)){
                return "Esineb";
            } else {
                for(Kaart kaart : kasutamataKaardid){
                    vaadeldavadKaardid.add(kaart);
                    if(meetod.twoPairs(vaadeldavadKaardid)){
                        soodsadKaardid ++;
                    }
                    vaadeldavadKaardid.remove(kaart);
                }
                return "Ühe kaardi lisades on tõenäosus: "+(double)soodsadKaardid/(double)kasutamataKaardid.size();
            }
        }
        if(kombinatsioon == 2){
            int soodsadKaardid = 0;
            if(meetod.Pair(vaadeldavadKaardid)){
                return "Esineb";
            } else {
                for(Kaart kaart : kasutamataKaardid){
                    vaadeldavadKaardid.add(kaart);
                    if(meetod.Pair(vaadeldavadKaardid)){
                        soodsadKaardid ++;
                    }
                    vaadeldavadKaardid.remove(kaart);
                }
                return "Ühe kaardi lisades on tõenäosus: "+(double)soodsadKaardid/(double)kasutamataKaardid.size();
            }
        }
        return "nothing";
    }
}
