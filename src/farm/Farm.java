package farm;

import animals.*;
import buildings.*;
import land.Land;
import plants.*;
import shop.Shop;

import java.util.*;

public class Farm {

    Scanner scan = new Scanner(System.in);

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
    private LatePotato latePotato = new LatePotato();
    private LateRape lateRape = new LateRape();
    private LateRye lateRye = new LateRye();
    private SpringBarley springBarley = new SpringBarley();
    private WhiteBeet whiteBeet = new WhiteBeet();
    private WinterWheat winterWheat = new WinterWheat();
    //Animal initiallization
    private List<Chicken> chickenList = new LinkedList<>();
    private List<Cow> cowList = new LinkedList<>();
    private List<Goat> goatList = new LinkedList<>();
    private List<Goose> gooseList = new LinkedList<>();
    private List<Pig> pigList = new LinkedList<>();
    private List<Sheep> sheepList = new LinkedList<>();
    private List<Turkey> turkeyList = new LinkedList<>();
    private List<Sown> sown = new LinkedList<>();


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

    public void setCorn(Integer kg) {
        this.corn.setStoredInKg(this.corn.getStoredInKg() + kg);
    }

    public LatePotato getLatePotato() {
        return latePotato;
    }

    public void setLatePotato(Integer kg) {
        this.latePotato.setStoredInKg(this.corn.getStoredInKg() + kg);
    }

    public LateRape getLateRape() {
        return lateRape;
    }

    public void setLateRape(Integer kg) {
        this.lateRape.setStoredInKg(this.corn.getStoredInKg() + kg);
    }

    public LateRye getLateRye() {
        return lateRye;
    }

    public void setLateRye(Integer kg) {
        this.lateRye.setStoredInKg(this.corn.getStoredInKg() + kg);
    }

    public SpringBarley getSpringBarley() {
        return springBarley;
    }

    public void setSpringBarley(Integer kg) {
        this.springBarley.setStoredInKg(this.corn.getStoredInKg() + kg);
    }

    public WhiteBeet getWhiteBeet() {
        return whiteBeet;
    }

    public void setWhiteBeet(Integer kg) {
        this.springBarley.setStoredInKg(this.corn.getStoredInKg() + kg);
    }

    public WinterWheat getWinterWheat() {
        return winterWheat;
    }

    public void setWinterWheat(Integer kg) {
        this.winterWheat.setStoredInKg(this.corn.getStoredInKg() + kg);
    }

    public List<Chicken> getChickenList() {
        return chickenList;
    }

    public void setChickenList(List<Chicken> chickenList) {
        this.chickenList = chickenList;
    }

    public void addChicken(List<Chicken> chickenList, Integer numberOfChickens) {
        for (int i = 0; i < numberOfChickens; i++) {
            chickenList.add(new Chicken());
        }
    }

    public void removeChicken(List<Chicken> chickenList, Integer numberOfChickens) {
        for (int i = 0; i < numberOfChickens; i++) {
            chickenList.remove(chickenList.size() - 1);
        }
    }

    public List<Cow> getCowList() {
        return cowList;
    }

    public void setCowList(List<Cow> cowList) {
        this.cowList = cowList;
    }

    public void addCow(List<Cow> cowList, Integer numberOfCows) {
        for (int i = 0; i < numberOfCows; i++) {
            cowList.add(new Cow());
        }
    }

    public void removeCow(List<Cow> cowList, Integer numberofCows) {
        for (int i = 0; i < numberofCows; i++) {
            cowList.remove(cowList.size() - 1);
        }
    }

    public List<Goat> getGoatList() {
        return goatList;
    }

    public void setGoatList(List<Goat> goatList) {
        this.goatList = goatList;
    }

    public void addGoat(List<Goat> goatList, Integer numberOfGoats) {
        for (int i = 0; i < numberOfGoats; i++) {
            goatList.add(new Goat());
        }
    }

    public void removeGoat(List<Goat> goatList, Integer numberOfGoats) {
        for (int i = 0; i < numberOfGoats; i++) {
            goatList.remove(goatList.size() - 1);
        }
    }

    public List<Goose> getGooseList() {
        return gooseList;
    }

    public void setGooseList(List<Goose> gooseList) {
        this.gooseList = gooseList;
    }

    public void addGoose(List<Goose> GooseList, Integer numberOfGoose) {
        for (int i = 0; i < numberOfGoose; i++) {
            gooseList.add(new Goose());
        }
    }

    public void removeGoose(List<Goose> gooseList, Integer numberOfGoose) {
        for (int i = 0; i < numberOfGoose; i++) {
            gooseList.remove(gooseList.size() - 1);
        }
    }

    public List<Pig> getPigList() {
        return pigList;
    }

    public void setPigList(List<Pig> pigList) {
        this.pigList = pigList;
    }

    public void addPig(List<Pig> pigList, Integer numberOfPigs) {
        for (int i = 0; i < numberOfPigs; i++) {
            pigList.add(new Pig());
        }
    }

    public void removePig(List<Pig> pigList, Integer numberOfPigs) {
        for (int i = 0; i < numberOfPigs; i++) {
            pigList.remove(pigList.size() - 1);
        }
    }

    public List<Sheep> getSheepList() {
        return sheepList;
    }

    public void setSheepList(List<Sheep> sheepList) {
        this.sheepList = sheepList;
    }

    public void addSheep(List<Sheep> SheepList, Integer numberOfSheep) {
        for (int i = 0; i < numberOfSheep; i++) {
            sheepList.add(new Sheep());
        }
    }

    public void removeSheep(List<Sheep> sheepList, Integer numberofSheep) {
        for (int i = 0; i < numberofSheep; i++) {
            sheepList.remove(sheepList.size() - 1);
        }
    }

    public List<Turkey> getTurkeyList() {
        return turkeyList;
    }

    public void setTurkeyList(List<Turkey> turkeyList) {
        this.turkeyList = turkeyList;
    }

    public void addTurkey(List<Turkey> turkeyList, Integer numberOfTurkey) {
        for (int i = 0; i < numberOfTurkey; i++) {
            turkeyList.add(new Turkey());
        }
    }

    public void removeTurkey(List<Turkey> turkeyList, Integer numberofTurkey) {
        for (int i = 0; i < numberofTurkey; i++) {
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


    public void possesionsLand(){
        System.out.println("Twoja ziemia:");
        System.out.println(this.land.getLandSizeInHa() + " ha ziemi, w tym " + this.land.getSownLandInHa() + " ha ziemi obsianej i " + this.land.getFreeLand() + " ha ziemi nieobsianej.");
    }
    public void possesionsPlants(){
        System.out.println("Twoje rośliny:  ");
        System.out.println(this.corn.getStoredInKg() + " kg kukurydzy.");
        System.out.println(this.latePotato.getStoredInKg() + " kg ziemniaka późnego.");
        System.out.println(this.lateRape.getStoredInKg() + " kg rzepaka ozimego.");
        System.out.println(this.lateRye.getStoredInKg() + " kg żyta ozimego.");
        System.out.println(this.springBarley.getStoredInKg() + " kg jęczmienia jarego.");
        System.out.println(this.whiteBeet.getStoredInKg() + " kg buraka cukrowego.");
        System.out.println(this.winterWheat.getStoredInKg() + " kg przenicy ozimej.");
    }
    public void possessionsAnimal(){        // TODO Animals
        System.out.println("Twoje zwierzęta:  ");
        System.out.println(this.getChickenList().size() + " kór.");
        System.out.println(this.getCowList().size() + " krów.");
        System.out.println(this.getGoatList().size() + " kóz.");
        System.out.println(this.getGooseList().size() + " gęsi.");
        System.out.println(this.getPigList().size() + " świń.");
        System.out.println(this.getSheepList().size() + " owiec.");
        System.out.println(this.getTurkeyList().size() + " indyków.");
    }
    public void possesionsBuilding(){        // TODO Building
        System.out.println("Twoje budynki:  ");
        System.out.println(this.barn.getQuantityOfThisBuildingType() + " stodół.");
        System.out.println(this.chickenCoop.getQuantityOfThisBuildingType() + " kurników.");
        System.out.println(this.cowShed.getQuantityOfThisBuildingType() + " obór.");
        System.out.println(this.goatBarn.getQuantityOfThisBuildingType() + " stodół dla kóz.");
        System.out.println(this.gooseCoop.getQuantityOfThisBuildingType() + " gęsich kórników.");
        System.out.println(this.pigsty.getQuantityOfThisBuildingType() + " chlewów.");
        System.out.println(this.sheepfold.getQuantityOfThisBuildingType() + " owczarń");
        System.out.println(this.turkeyCoop.getQuantityOfThisBuildingType() + " kórników dla indyków.");

    }
    public void possesions() {
        // TODO data, tydzień roku??? tura
        possesionsLand();
        possesionsPlants();
        possessionsAnimal();
        possesionsBuilding();
        System.out.println();
    }

    public Farm generateFarm() {
        Farm farm = new Farm();
        farm.calendar.set(2020, 0, 1);
        randomStartingValues(farm);
        return farm;
    }

    public Farm generateManyFarms(){
        Integer farmNumber;
        Farm[] farmarr = new Farm[3];

        for(int i = 0; i <= 2; i++){
            farmarr[i] = generateFarm();
            System.out.println("Farma nr " + (i + 1));
            farmarr[i].possesions();
        }

        System.out.println("Wybierz swoją startową farmę spośród trzech powyżej dostępnych wpisując wartość 1, 2 lub 3: ");
        farmNumber = scan.nextInt();

        return farmarr[farmNumber - 1];
    }

    public void randomStartingValues(Farm farm) {
        Integer flag = 0;

        this.land.setLandSizeInHa(rand.nextInt(2) + 2);
        while (flag < 2) {
            if (rand.nextBoolean() && flag < 3) {
                farm.corn.setStoredInKg(farm.corn.getStoredInKg() + rand.nextInt(20) + 100); //100
                flag++;
            }
            if (rand.nextBoolean() && flag < 3) {
                farm.latePotato.setStoredInKg(farm.latePotato.getStoredInKg() + rand.nextInt(20) + 100); //100
                flag++;
            }
            if (rand.nextBoolean() && flag < 3) {
                farm.lateRape.setStoredInKg(farm.lateRape.getStoredInKg() + rand.nextInt(20) + 100); //100
                flag++;
            }
            if (rand.nextBoolean() && flag < 3) {
                farm.lateRye.setStoredInKg(farm.lateRye.getStoredInKg() + rand.nextInt(20) + 100); //100
                flag++;
            }
            if (rand.nextBoolean() && flag < 3) {
                farm.springBarley.setStoredInKg(farm.springBarley.getStoredInKg() + rand.nextInt(20) + 100); //100
                flag++;
            }
            if (rand.nextBoolean() && flag < 3) {
                farm.whiteBeet.setStoredInKg(farm.whiteBeet.getStoredInKg() + rand.nextInt(20) + 100); //100
                flag++;
            }
            if (rand.nextBoolean() && flag < 3) {
                farm.winterWheat.setStoredInKg(farm.winterWheat.getStoredInKg() + rand.nextInt(20) + 100); //100
                flag++;
            }
        }
        farm.getLand().setLandSizeInHa(rand.nextInt(5) + 3);

    }

    public Integer allPlantsKg() {
        return this.getCorn().getStoredInKg() + this.getLatePotato().getStoredInKg() + this.getLateRape().getStoredInKg() + this.getLateRye().getStoredInKg() + this.getSpringBarley().getStoredInKg() + this.getWhiteBeet().getStoredInKg() + this.getWinterWheat().getStoredInKg();
    }



    public void startOfTheTurn(){
        System.out.println("Jest " + getTime() + " czyli " + getWeekOfYear() + " tydzień roku. " + turnCounter + " tura.");
        harvestSown();
        /*
        - Wyświetlić datę, tydzień roku i numer tury *
        - Zbiory *
        - Eventy
         */
    }
    public void nextTurn() {
        /*TODO
        - Zmienić tydzień i datę *
        - Zmienić numer tury *
        - Wiek zwierząt, rozmnażanie i zebranie produktów od nich
        - Sprawdzić winningConditions *
         */
        this.calendar.add(Calendar.DAY_OF_WEEK, 7); // Next week
        //Zwiększenie masy zwierząt, zmniejszenie czasu do zbiorów, eventy
        this.winningConditions();
        this.turnCounter++;
    }

    public Integer getWeekOfYear() {
        return this.calendar.get(Calendar.WEEK_OF_YEAR);
    }

    public Date getTime() { //Zmienić void, jaki zwracany typ?

        return this.calendar.getTime();
    }
    public void addSown(Plant plant) {
        Sown sown = new Sown().addToSown(plant, this);
        if(sown != null) {
            this.sown.add(sown);
        }
    }

    public void harvestSown(){
        for(int i = 0; i < this.sown.size(); i++){
            sown.get(i).minusWeeksToHarvest(this);
        }
    }

    public void winningConditions() {
        //20ha ziemi, 5 różncyh gatunków zwierząt, 5 różnych gatunków roślin i jedzenie dla zwierząt na rok.
        final Integer landArea = 20;
        final Integer plantSpecies = 5;
        final Integer animalSpecies = 5;
        Integer plantSpeciesCounter = 0;
        Integer animalSpeciesCounter = 0;
        Integer springBarleyCounter = this.getSpringBarley().getStoredInKg();
        boolean barleyFlag = true;


        if (!this.getChickenList().isEmpty()) {
            if (this.getCorn().getStoredInKg() >= Math.floor(this.getChickenList().get(0).getFoodEatenPerWeek() * this.getChickenList().size() * 52))
                animalSpeciesCounter++;
        }
        if (!this.getCowList().isEmpty()) {
            if (this.getWinterWheat().getStoredInKg() >= Math.floor(this.getCowList().get(0).getFoodEatenPerWeek() * this.getCowList().size() * 52))
                animalSpeciesCounter++;
        }
        if (!this.getGoatList().isEmpty()) {
            if (springBarleyCounter >= Math.floor(this.getGoatList().get(0).getFoodEatenPerWeek() * this.getGoatList().size() * 52)) { //Spring Barley
                springBarleyCounter = springBarleyCounter - (int) (this.getGoatList().get(0).getFoodEatenPerWeek() * this.getGoatList().size() * 52);
                if (springBarleyCounter < 0)
                    barleyFlag = false;
                animalSpeciesCounter++;
            }
        }
        if (!this.getGooseList().isEmpty()) {
            if (springBarleyCounter >= Math.floor(this.getGooseList().get(0).getFoodEatenPerWeek() * this.getGooseList().size() * 52)) { //Spring Barley
                springBarleyCounter = springBarleyCounter - (int) (this.getGooseList().get(0).getFoodEatenPerWeek() * this.getGooseList().size() * 52);
                if (springBarleyCounter < 0)
                    barleyFlag = false;
                animalSpeciesCounter++;
            }
        }
        if (!this.getPigList().isEmpty()) {
            if (this.getLatePotato().getStoredInKg() >= Math.floor(this.getPigList().get(0).getFoodEatenPerWeek() * this.getPigList().size() * 52))
                ;
            animalSpeciesCounter++;
        }
        if (!this.getSheepList().isEmpty()) {
            if (springBarleyCounter >= Math.floor(this.getSheepList().get(0).getFoodEatenPerWeek() * this.getSheepList().size() * 52)) { //Spring Barley
                springBarleyCounter = springBarleyCounter - (int) (this.getSheepList().get(0).getFoodEatenPerWeek() * this.getSheepList().size() * 52);
                if (springBarleyCounter < 0)
                    barleyFlag = false;
                animalSpeciesCounter++;
            }
        }
        if (!this.getTurkeyList().isEmpty()) {
            if (springBarleyCounter >= Math.floor(this.getTurkeyList().get(0).getFoodEatenPerWeek() * this.getTurkeyList().size() * 52)) { //Spring Barley
                springBarleyCounter = springBarleyCounter - (int) (this.getTurkeyList().get(0).getFoodEatenPerWeek() * this.getTurkeyList().size() * 52);
                if (springBarleyCounter < 0)
                    barleyFlag = false;
                animalSpeciesCounter++;
            }
        }

        if (this.getCorn().getStoredInKg() > 0)
            plantSpeciesCounter++;
        if (this.getLatePotato().getStoredInKg() > 0)
            plantSpeciesCounter++;
        if (this.getLateRape().getStoredInKg() > 0)
            plantSpeciesCounter++;
        if (this.getLateRye().getStoredInKg() > 0)
            plantSpeciesCounter++;
        if (this.getSpringBarley().getStoredInKg() > 0)
            plantSpeciesCounter++;
        if (this.getWhiteBeet().getStoredInKg() > 0)
            plantSpeciesCounter++;
        if (this.getWinterWheat().getStoredInKg() > 0)
            plantSpeciesCounter++;

        if (animalSpeciesCounter >= animalSpecies && plantSpeciesCounter >= plantSpecies && this.getLand().getLandSizeInHa() >= landArea && barleyFlag == true) {
            System.out.println("Gratulacje!!! Udało ci się osiągnąć cel gry, jakim jest zebranie jednocześnie przynajmniej: ");
            System.out.println("- 20 ha ziemi;");
            System.out.println("- Pięciu gatunków roślin;");
            System.out.println("- Pięciu gatunków zwierząt;");
            System.out.println("- Karmy dla zwierząt na okres przynajmniej roku.");
            System.out.println();
            System.out.println("Stałeś się rolnikiem doskonałym. Cały świat chyli czoło przed twoimi wybitnymi osiągnięciami i otrzymujesz listy gratulacyjne z całego świata!");
        }

    }
}
