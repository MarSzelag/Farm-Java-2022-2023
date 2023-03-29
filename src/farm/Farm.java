package farm;

import animals.*;
import buildings.*;
import land.Land;
import plants.*;
import shop.Shop;

import java.util.*;

public class Farm {

    Random rand = new Random();
    private String owner;
    private Double cash = 1000.00;

    private Integer turnCounter = 0; // Około 52 tury to rok
    //Plants
    private Land land = new Land();
    //Buildings initialization
    private Barn barn = new Barn();
    private ChickenCoop chickenCoop = new ChickenCoop();
    private CowShed cowShed = new CowShed();
    private GoatBarn goatBarn = new GoatBarn();
    private GooseCoop gooseCoop = new GooseCoop();
    private Pigsty pigsty = new Pigsty();
    private Sheepfold sheepfold = new Sheepfold();
    private TurkeyCoop turkeyCoop = new TurkeyCoop();
    //Plants initialization
    private Corn corn = new Corn();
    private LatePotato latePotato  = new LatePotato();
    private LateRape lateRape = new LateRape();
    private LateRye lateRye = new LateRye();
    private SpringBarley springBarley= new SpringBarley();
    private WhiteBeet whiteBeet= new WhiteBeet();
    private WinterWheat winterWheat = new WinterWheat();
    //Animal initiallization
    private List<Chicken> chickenList = new LinkedList<>();
    private List<Cow> cowList = new LinkedList<>();
    private List<Goat> goatList = new LinkedList<>();
    private List<Goose> gooseList = new LinkedList<>();
    private List<Pig> pigList = new LinkedList<>();
    private List<Sheep> sheepList = new LinkedList<>();
    private List<Turkey> turkeyList = new LinkedList<>();


    public Shop shop = new Shop(this);



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

    public Land getLand() {
        return land;
    }

    public void setLand(Land land) {
        this.land = land;
    }

    public Barn getBarn() {
        return barn;
    }

    public void setBarn(Barn barn) {
        this.barn = barn;
    }

    public ChickenCoop getChickenCoop() {
        return chickenCoop;
    }

    public void setChickenCoop(ChickenCoop chickenCoop) {
        this.chickenCoop = chickenCoop;
    }

    public CowShed getCowShed() {
        return cowShed;
    }

    public void setCowShed(CowShed cowShed) {
        this.cowShed = cowShed;
    }

    public GoatBarn getGoatBarn() {
        return goatBarn;
    }

    public void setGoatBarn(GoatBarn goatBarn) {
        this.goatBarn = goatBarn;
    }

    public GooseCoop getGooseCoop() {
        return gooseCoop;
    }

    public void setGooseCoop(GooseCoop gooseCoop) {
        this.gooseCoop = gooseCoop;
    }

    public Pigsty getPigsty() {
        return pigsty;
    }

    public void setPigsty(Pigsty pigsty) {
        this.pigsty = pigsty;
    }

    public Sheepfold getSheepfold() {
        return sheepfold;
    }

    public void setSheepfold(Sheepfold sheepfold) {
        this.sheepfold = sheepfold;
    }

    public TurkeyCoop getTurkeyCoop() {
        return turkeyCoop;
    }

    public void setTurkeyCoop(TurkeyCoop turkeyCoop) {
        this.turkeyCoop = turkeyCoop;
    }

    public Corn getCorn() {
        return corn;
    }

    public void setCorn(Corn corn) {
        this.corn = corn;
    }

    public LatePotato getLatePotato() {
        return latePotato;
    }

    public void setLatePotato(LatePotato latePotato) {
        this.latePotato = latePotato;
    }

    public LateRape getLateRape() {
        return lateRape;
    }

    public void setLateRape(LateRape lateRape) {
        this.lateRape = lateRape;
    }

    public LateRye getLateRye() {
        return lateRye;
    }

    public void setLateRye(LateRye lateRye) {
        this.lateRye = lateRye;
    }

    public SpringBarley getSpringBarley() {
        return springBarley;
    }

    public void setSpringBarley(SpringBarley springBarley) {
        this.springBarley = springBarley;
    }

    public WhiteBeet getWhiteBeet() {
        return whiteBeet;
    }

    public void setWhiteBeet(WhiteBeet whiteBeet) {
        this.whiteBeet = whiteBeet;
    }

    public WinterWheat getWinterWheat() {
        return winterWheat;
    }

    public void setWinterWheat(WinterWheat winterWheat) {
        this.winterWheat = winterWheat;
    }

    public List<Chicken> getChickenList() {
        return chickenList;
    }

    public void setChickenList(List<Chicken> chickenList) {
        this.chickenList = chickenList;
    }
    public void addChicken(List<Chicken> chickenList, Integer numberOfChickens){
        for(int i = 0; i < numberOfChickens; i++){
            chickenList.add(new Chicken());
        }
    }

    public void removeChicken(List<Chicken> chickenList, Integer numberOfChickens){
        for(int i = 0; i < numberOfChickens; i++){
            chickenList.remove(chickenList.size() - 1);
        }
    }

    public List<Cow> getCowList() {
        return cowList;
    }

    public void setCowList(List<Cow> cowList) {
        this.cowList = cowList;
    }

    public void addCow(List<Cow> cowList, Integer numberOfCows){
        for(int i = 0; i < numberOfCows; i++){
            cowList.add(new Cow());
        }
    }

    public void removeCow(List<Cow> cowList, Integer numberofCows){
        for(int i = 0; i < numberofCows; i++){
            cowList.remove(cowList.size() - 1);
        }
    }

    public List<Goat> getGoatList() {
        return goatList;
    }

    public void setGoatList(List<Goat> goatList) {
        this.goatList = goatList;
    }
    public void addGoat(List<Goat> goatList, Integer numberOfGoats){
        for(int i = 0; i < numberOfGoats; i++){
            goatList.add(new Goat());
        }
    }

    public void removeGoat(List<Goat> goatList, Integer numberOfGoats){
        for(int i = 0; i < numberOfGoats; i++){
            goatList.remove(goatList.size() - 1);
        }
    }

    public List<Goose> getGooseList() {
        return gooseList;
    }

    public void setGooseList(List<Goose> gooseList) {
        this.gooseList = gooseList;
    }
    public void addGoose(List<Goose> GooseList, Integer numberOfGoose){
        for(int i = 0; i < numberOfGoose; i++){
            gooseList.add(new Goose());
        }
    }

    public void removeGoose(List<Goose> gooseList, Integer numberOfGoose){
        for(int i = 0; i < numberOfGoose; i++){
            gooseList.remove(gooseList.size() - 1);
        }
    }

    public List<Pig> getPigList() {
        return pigList;
    }

    public void setPigList(List<Pig> pigList) {
        this.pigList = pigList;
    }
    public void addPig(List<Pig> pigList, Integer numberOfPigs){
        for(int i = 0; i < numberOfPigs; i++){
            pigList.add(new Pig());
        }
    }

    public void removePig(List<Pig> pigList, Integer numberOfPigs){
        for(int i = 0; i < numberOfPigs; i++){
            pigList.remove(pigList.size() - 1);
        }
    }

    public List<Sheep> getSheepList() {
        return sheepList;
    }

    public void setSheepList(List<Sheep> sheepList) {
        this.sheepList = sheepList;
    }
    public void addSheep(List<Sheep>SheepList, Integer numberOfSheep){
        for(int i = 0; i < numberOfSheep; i++){
            sheepList.add(new Sheep());
        }
    }

    public void removeSheep(List<Sheep> sheepList, Integer numberofSheep){
        for(int i = 0; i < numberofSheep; i++){
           sheepList.remove(sheepList.size() - 1);
        }
    }

    public List<Turkey> getTurkeyList() {
        return turkeyList;
    }

    public void setTurkeyList(List<Turkey> turkeyList) {
        this.turkeyList = turkeyList;
    }
    public void addTurkey(List<Turkey> turkeyList, Integer numberOfTurkey){
        for(int i = 0; i < numberOfTurkey; i++){
            turkeyList.add(new Turkey());
        }
    }

    public void removeTurkey(List<Turkey> turkeyList, Integer numberofTurkey){
        for(int i = 0; i < numberofTurkey; i++){
            turkeyList.remove(turkeyList.size() - 1);
        }
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
        // TODO data, tydzień roku??? tura
        System.out.println(this.owner + " aktualnie jesteś w posiadaniu: ");
        System.out.println(this.land.getLandSizeInHa() + " ha ziemi, w tym " + this.land.getSownLandInHa() + " ha ziemi obsianej i " + this.land.getFreeLand() + " ha ziemi nieobsianej.");
        System.out.println(this.corn.getStoredInKg() + " kg kukurydzy.");
        System.out.println(this.latePotato.getStoredInKg() + " kg ziemniaka późnego.");
        System.out.println(this.lateRape.getStoredInKg() + " kg rzepaka ozimego.");
        System.out.println(this.lateRye.getStoredInKg() + " kg żyta ozimego.");
        System.out.println(this.springBarley.getStoredInKg() + " kg jęczmienia jarego.");
        System.out.println(this.whiteBeet.getStoredInKg() + " kg buraka cukrowego.");
        System.out.println(this.winterWheat.getStoredInKg() + " kg przenicy ozimej.");

        // TODO Animals
        // TODO Building
    }

    public Farm generateFarm() {
        Farm farm = new Farm();
        farm.calendar.set(2020, 0, 1);
        randomStartingValues();
        return farm;
    }

    public void randomStartingValues(){
        Integer flag = 0;

        this.land.setLandSizeInHa(rand.nextInt(2) + 2);
        while(flag < 2) {
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
                this.lateRye.setStoredInKg(this.lateRye.getStoredInKg() + rand.nextInt(20) + 100); //100
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
        this.getLand().setLandSizeInHa(rand.nextInt(5) + 3);

    }

    public Integer allPlantsKg(){
        return this.getCorn().getStoredInKg() + this.getLatePotato().getStoredInKg() + this.getLateRape().getStoredInKg() + this.getLateRye().getStoredInKg() + this.getSpringBarley().getStoredInKg() + this.getWhiteBeet().getStoredInKg() + this.getWinterWheat().getStoredInKg();
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
