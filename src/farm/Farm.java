package farm;

import land.Land;
import plants.*;

import java.util.*;

public class Farm {

    Random rand = new Random();
    private String owner;
    private Double cash = 1000000.00;

    private Integer turnCounter = 0; // Około 52 tury to rok
    //Plants
    private Land land = new Land();
    public Corn corn = new Corn();
    private LatePotato latePotato  = new LatePotato();
    private LateRape lateRape = new LateRape();
    private LateRye laterye = new LateRye();
    private SpringBarley springBarley= new SpringBarley();
    private WhiteBeet whiteBeet= new WhiteBeet();
    private WinterWheat winterWheat = new WinterWheat();



    /*
    public List<Plant> sownPlantsList = new LinkedList<>(); // Plus przy losowanich, minus przy wyszukiwaniu konkretnej rośliny

    public void setSownPlantsList() {
        this.sownPlantsList.add(corn);
        this.sownPlantsList.add(latePotato);

        this.sownPlantsList.get(1).setPlantName("Dziobu");

        for(int i = 0; i < this.sownPlantsList.size(); i++){
            System.out.println(this.sownPlantsList.get(i).getPlantName());
        }
    }*/
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
/*
    public Integer getLandOwned() {
        return landOwned;
    }

    public void setLandOwned(Integer landOwned) {
        this.landOwned = landOwned;
    }

 */
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
        randomStartingValues();
        return farm;
    }

    public void randomStartingValues(){
        Integer flag = 0;

        this.land.setSizeInHa(rand.nextInt(5) + 3);
        while(flag < 3) {
            if (rand.nextBoolean() && flag < 3) {
                this.corn.setStoredInKg(this.corn.getStoredInKg() + rand.nextInt(20) + 100); //100
                flag++;
            }
            if (rand.nextBoolean() && flag < 3) {
                this.latePotato.setStoredInKg(this.latePotato.getStoredInKg() + rand.nextInt(20) + 100); //100
                flag++;
            }
            if (rand.nextBoolean() && flag < 3) {
                this.lateRape.setStoredInKg(this.lateRape.getStoredInKg() + rand.nextInt(20) + 100); //100
                flag++;
            }
            if (rand.nextBoolean() && flag < 3) {
                this.laterye.setStoredInKg(this.laterye.getStoredInKg() + rand.nextInt(20) + 100); //100
                flag++;
            }
            if (rand.nextBoolean() && flag < 3) {
                this.springBarley.setStoredInKg(this.springBarley.getStoredInKg() + rand.nextInt(20) + 100); //100
                flag++;
            }
            if (rand.nextBoolean() && flag < 3) {
                this.whiteBeet.setStoredInKg(this.whiteBeet.getStoredInKg() + rand.nextInt(20) + 100); //100
                flag++;
            }
            if (rand.nextBoolean() && flag < 3) {
                this.winterWheat.setStoredInKg(this.winterWheat.getStoredInKg() + rand.nextInt(20) + 100); //100
                flag++;
            }
        }

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
