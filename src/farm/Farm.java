package farm;

import plants.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Farm {
    private String owner;
    private Double cash = 1000000.00;
    private Integer landOwned; // W ha
    private Integer turnCounter = 0; // Około 52 tury to rok
    //Plants

    private Corn corn = new Corn("Kukurydza", 100, 1200, 16, 18, 38, 41, 0.80, 1.50);
    private LatePotato latePotato  = new LatePotato("Ziemniak późny", 2200, 20000, 15, 17, 33, 41, 0.65, 0.95);
    private LateRape LateRape = new LateRape("Rzepak ozimy", 3, 3400, 31, 36, 29, 33, 2.17, 3.20);
    private LateRye Laterye = new LateRye("Żyto ozime", 250, 3600, 36, 39, 28, 33, 0.55, 0.77);
    private SpringBarley springBarley= new SpringBarley("Jęczmień jary", 270, 3300, 9, 15, 29, 31, 0.45, 1.12);
    private WhiteBeet whiteBeet= new WhiteBeet("Burak cukrowy", 700, 4000, 16, 19, 40, 44, 0.86, 1.32);
    private WinterWheat winterWheat = new WinterWheat("Pszenica ozima", 240, 5000, 37, 42, 28, 31, 0.65, 0.95);
    //Animals
    //Buildings


    public Calendar calendar = new GregorianCalendar(Locale.GERMAN);

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Integer getLandOwned() {
        return landOwned;
    }

    public void setLandOwned(Integer landOwned) {
        this.landOwned = landOwned;
    }
/*
    public Integer getTurnCounter() {
        return turnCounter;
    }*/

    public void setTurnCounter(Integer turnCounter) {
        this.turnCounter = turnCounter;
    }



    public void possesions() {

    }

    public Farm generateFarm() {
        Farm farm = new Farm();
        farm.calendar.set(2020, 0, 1);
        return farm;
    }

    public void buy() {

    }

    public void sell() {

    }

    public void sow() {

    }

    public void harvest() {

    }

    public void nextWeek(){
        this.calendar.add(Calendar.DAY_OF_WEEK, 7);
    }

    public void nextTurn(){
        this.turnCounter++;
    }

    public Integer getWeekOfYear(){
       return this.calendar.get(Calendar.WEEK_OF_YEAR);
    }

    public void getTime(){ //Zmienić void, jaki zwracany typ?
        this.calendar.getTime();
    }

}
