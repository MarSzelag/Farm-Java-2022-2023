package farm;

import plants.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Farm {
    private String owner;
    private Double cash = 1000000.00;
    private Integer landOwned; // W ha
    private Integer turnCounter = 0; // 52 tury to rok

    private Corn corn = new Corn("Kukurydza", 100, 1200, 16, 18, 38, 41, 0.80, 1.50);





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

    //Rośliny

    //Zwierzęta

    //Budynki


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
