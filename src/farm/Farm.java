package farm;

import animals.*;
import buildings.*;
import events.Drought;
import events.Events;
import events.Flood;
import events.PotatoBeetle;
import land.Land;
import plants.*;
import shop.Shop;

import java.util.*;

public class Farm {

    Scanner scan = new Scanner(System.in);

    Random rand = new Random();
    private String owner;
    private Double cash = 150000.00;

    private Integer turnCounter = 1;
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

    private Integer totalNumberOfChicken, totalNumberOfCow, totalNumberOfGoat, totalNumberOfGoose, totalNumberOfPig, totalNumberOfSheep, totalNumberOfTurkey;
    private Integer totalNumberOfAdultChicken, totalNumberOfAdultCow, totalNumberOfAdultGoat, totalNumberOfAdultGoose, totalNumberOfAdultPig, totalNumberOfAdultSheep, totalNumberOfAdultTurkey;
    private List<Sown> sownList = new LinkedList<>();
    private Drought drought = new Drought();
    private Flood flood = new Flood();
    private PotatoBeetle potatoBeetle = new PotatoBeetle();

    private Animal animal = new Animal();


    public Shop shop = new Shop(this);


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


    public Corn getCorn() {
        return corn;
    }

    public void setCorn(double kg) {
        this.corn.setStoredInKg(this.corn.getStoredInKg() + kg);
    }

    public LatePotato getLatePotato() {
        return latePotato;
    }

    public void setLatePotato(double kg) {
        this.latePotato.setStoredInKg(this.corn.getStoredInKg() + kg);
    }

    public LateRape getLateRape() {
        return lateRape;
    }

    public void setLateRape(double kg) {
        this.lateRape.setStoredInKg(this.corn.getStoredInKg() + kg);
    }

    public LateRye getLateRye() {
        return lateRye;
    }

    public void setLateRye(double kg) {
        this.lateRye.setStoredInKg(this.corn.getStoredInKg() + kg);
    }

    public SpringBarley getSpringBarley() {
        return springBarley;
    }

    public void setSpringBarley(double kg) {
        this.springBarley.setStoredInKg(this.corn.getStoredInKg() + kg);
    }

    public WhiteBeet getWhiteBeet() {
        return whiteBeet;
    }

    public void setWhiteBeet(double kg) {
        this.springBarley.setStoredInKg(this.corn.getStoredInKg() + kg);
    }

    public WinterWheat getWinterWheat() {
        return winterWheat;
    }

    public void setWinterWheat(double kg) {
        this.winterWheat.setStoredInKg(this.corn.getStoredInKg() + kg);
    }

    public List<Chicken> getChickenList() {
        return chickenList;
    }

    public void setChickenList(List<Chicken> chickenList) {
        this.chickenList = chickenList;
    }

    public void addChicken(List<Chicken> chickenList, Integer numberOfChickens) {
        chickenList.add(new Chicken());
        chickenList.get(chickenList.size() - 1).setNumberOfAnimal(numberOfChickens);
    }

    public List<Cow> getCowList() {
        return cowList;
    }

    public void setCowList(List<Cow> cowList) {
        this.cowList = cowList;
    }

    public void addCow(List<Cow> cowList, Integer numberOfCows) {
        cowList.add(new Cow());
        cowList.get(cowList.size() - 1).setNumberOfAnimal(numberOfCows);
    }

    public List<Goat> getGoatList() {
        return goatList;
    }

    public void setGoatList(List<Goat> goatList) {
        this.goatList = goatList;
    }

    public void addGoat(List<Goat> goatList, Integer numberOfGoats) {
        goatList.add(new Goat());
        goatList.get(goatList.size() - 1).setNumberOfAnimal(numberOfGoats);
    }

    public List<Goose> getGooseList() {
        return gooseList;
    }

    public void setGooseList(List<Goose> gooseList) {
        this.gooseList = gooseList;
    }

    public void addGoose(List<Goose> gooseList, Integer numberOfGoose) {
        gooseList.add(new Goose());
        gooseList.get(gooseList.size() - 1).setNumberOfAnimal(numberOfGoose);
    }

    public List<Pig> getPigList() {
        return pigList;
    }

    public void setPigList(List<Pig> pigList) {
        this.pigList = pigList;
    }

    public void addPig(List<Pig> pigList, Integer numberOfPigs) {
        pigList.add(new Pig());
        pigList.get(pigList.size() - 1).setNumberOfAnimal(numberOfPigs);
    }

    public List<Sheep> getSheepList() {
        return sheepList;
    }

    public void setSheepList(List<Sheep> sheepList) {
        this.sheepList = sheepList;
    }

    public void addSheep(List<Sheep> SheepList, Integer numberOfSheep) {
        sheepList.add(new Sheep());
        sheepList.get(cowList.size() - 1).setNumberOfAnimal(numberOfSheep);
    }

    public List<Turkey> getTurkeyList() {
        return turkeyList;
    }

    public void setTurkeyList(List<Turkey> turkeyList) {
        this.turkeyList = turkeyList;
    }

    public void addTurkey(List<Turkey> turkeyList, Integer numberOfTurkey) {
        turkeyList.add(new Turkey());
        turkeyList.get(turkeyList.size() - 1).setNumberOfAnimal(numberOfTurkey);
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

    public void setTurnCounter(Integer turnCounter) {
        this.turnCounter = turnCounter;
    }

    public Integer getTotalNumberOfChicken() {
        return totalNumberOfChicken;
    }

    public void setTotalNumberOfChicken(Integer totalNumberOfChicken) {
        this.totalNumberOfChicken = totalNumberOfChicken;
    }

    public Integer getTotalNumberOfCow() {
        return totalNumberOfCow;
    }

    public void setTotalNumberOfCow(Integer totalNumberOfCow) {
        this.totalNumberOfCow = totalNumberOfCow;
    }

    public Integer getTotalNumberOfGoat() {
        return totalNumberOfGoat;
    }

    public void setTotalNumberOfGoat(Integer totalNumberOfGoat) {
        this.totalNumberOfGoat = totalNumberOfGoat;
    }

    public Integer getTotalNumberOfGoose() {
        return totalNumberOfGoose;
    }

    public void setTotalNumberOfGoose(Integer totalNumberOfGoose) {
        this.totalNumberOfGoose = totalNumberOfGoose;
    }

    public Integer getTotalNumberOfPig() {
        return totalNumberOfPig;
    }

    public void setTotalNumberOfPig(Integer totalNumberOfPig) {
        this.totalNumberOfPig = totalNumberOfPig;
    }

    public Integer getTotalNumberOfSheep() {
        return totalNumberOfSheep;
    }

    public void setTotalNumberOfSheep(Integer totalNumberOfSheep) {
        this.totalNumberOfSheep = totalNumberOfSheep;
    }

    public Integer getTotalNumberOfTurkey() {
        return totalNumberOfTurkey;
    }

    public void setTotalNumberOfTurkey(Integer totalNumberOfTurkey) {
        this.totalNumberOfTurkey = totalNumberOfTurkey;
    }

    public Integer getTotalNumberOfAdultChicken() {
        return totalNumberOfAdultChicken;
    }

    public void setTotalNumberOfAdultChicken(Integer totalNumberOfAdultChicken) {
        this.totalNumberOfAdultChicken = totalNumberOfAdultChicken;
    }

    public Integer getTotalNumberOfAdultCow() {
        return totalNumberOfAdultCow;
    }

    public void setTotalNumberOfAdultCow(Integer totalNumberOfAdultCow) {
        this.totalNumberOfAdultCow = totalNumberOfAdultCow;
    }

    public Integer getTotalNumberOfAdultGoat() {
        return totalNumberOfAdultGoat;
    }

    public void setTotalNumberOfAdultGoat(Integer totalNumberOfAdultGoat) {
        this.totalNumberOfAdultGoat = totalNumberOfAdultGoat;
    }

    public Integer getTotalNumberOfAdultGoose() {
        return totalNumberOfAdultGoose;
    }

    public void setTotalNumberOfAdultGoose(Integer totalNumberOfAdultGoose) {
        this.totalNumberOfAdultGoose = totalNumberOfAdultGoose;
    }

    public Integer getTotalNumberOfAdultPig() {
        return totalNumberOfAdultPig;
    }

    public void setTotalNumberOfAdultPig(Integer totalNumberOfAdultPig) {
        this.totalNumberOfAdultPig = totalNumberOfAdultPig;
    }

    public Integer getTotalNumberOfAdultSheep() {
        return totalNumberOfAdultSheep;
    }

    public void setTotalNumberOfAdultSheep(Integer totalNumberOfAdultSheep) {
        this.totalNumberOfAdultSheep = totalNumberOfAdultSheep;
    }

    public Integer getTotalNumberOfAdultTurkey() {
        return totalNumberOfAdultTurkey;
    }

    public void setTotalNumberOfAdultTurkey(Integer totalNumberOfAdultTurkey) {
        this.totalNumberOfAdultTurkey = totalNumberOfAdultTurkey;
    }

    public List<Sown> getSownList() {
        return sownList;
    }

    public void setSownList(List<Sown> sownList) {
        this.sownList = sownList;
    }


    public Drought getDrought() {
        return drought;
    }

    public void setDrought(Drought drought) {
        this.drought = drought;
    }

    public Flood getFlood() {
        return flood;
    }

    public void setFlood(Flood flood) {
        this.flood = flood;
    }

    public PotatoBeetle getPotatoBeetle() {
        return potatoBeetle;
    }

    public void setPotatoBeetle(PotatoBeetle potatoBeetle) {
        this.potatoBeetle = potatoBeetle;
    }
    public void possessionsCash(){
        System.out.println("Posiadasz " + this.getCash() + "zł.");
    }

    public void possessionsLand() {
        System.out.println("Twoja ziemia:");
        System.out.println(this.land.getLandSizeInHa() + " ha ziemi, w tym " + this.land.getSownLandInHa() + " ha ziemi obsianej i " + this.land.getFreeLand() + " ha ziemi nieobsianej.");
    }

    public void possessionsPlants() {
        System.out.println("Twoje rośliny:  ");
        System.out.println(this.corn.getStoredInKg() + " kg kukurydzy. Obsiewanie od " + this.corn.getSowingTimeFromWeek() + " do " + this.corn.getSowingTimeToWeek() + " tygodnia roku.");
        System.out.println(this.latePotato.getStoredInKg() + " kg ziemniaka późnego. Obsiewane od " + this.latePotato.getSowingTimeFromWeek() + " do " + this.latePotato.getSowingTimeToWeek() + " tygodnia roku.");
        System.out.println(this.lateRape.getStoredInKg() + " kg rzepaka ozimego. Obsiewane od " + this.lateRape.getSowingTimeFromWeek() + " do " + this.lateRape.getSowingTimeToWeek() + " tygodnia roku.");
        System.out.println(this.lateRye.getStoredInKg() + " kg żyta ozimego. Obsiewane od " + this.lateRye.getSowingTimeFromWeek() + " do " + this.lateRye.getSowingTimeToWeek() + " tygodnia roku.");
        System.out.println(this.springBarley.getStoredInKg() + " kg jęczmienia jarego. Obsiewane od " + this.springBarley.getSowingTimeFromWeek() + " do " + this.springBarley.getSowingTimeToWeek() + " tygodnia roku.");
        System.out.println(this.whiteBeet.getStoredInKg() + " kg buraka cukrowego. Obsiewane od " + this.whiteBeet.getSowingTimeFromWeek() + " do " + this.whiteBeet.getSowingTimeToWeek() + " tygodnia roku.");
        System.out.println(this.winterWheat.getStoredInKg() + " kg przenicy ozimej. Obsiewane od " + this.winterWheat.getSowingTimeFromWeek() + " do " + this.winterWheat.getSowingTimeToWeek() + " tygodnia roku.");
    }

    public void possessionsAnimal() {
        System.out.println("Twoje zwierzęta:  ");
        System.out.println(this.getChickenList().size() + " kór.");
        System.out.println(this.getCowList().size() + " krów.");
        System.out.println(this.getGoatList().size() + " kóz.");
        System.out.println(this.getGooseList().size() + " gęsi.");
        System.out.println(this.getPigList().size() + " świń.");
        System.out.println(this.getSheepList().size() + " owiec.");
        System.out.println(this.getTurkeyList().size() + " indyków.");
    }

    public void possessionsBuilding() {
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

    public void possessionsSownPlants(){
        System.out.println("Rośliny, które zostały zasiane: ");
        for (int i = 0; i < this.sownList.size(); i++) {
            System.out.println(sownList.get(i).getName() + ", obsiane " + sownList.get(i).getHaSown() + "ha, pozostało " + sownList.get(i).getWeeksToHarvest() + " tygodni do zbiorów.");
        }
    }

    public void possessions() {
        System.out.println("--------------------------------------------------------------------------------------------");
        currentTime();
        System.out.println("--------------------------------------------------------------------------------------------");
        possessionsCash();
        System.out.println("--------------------------------------------------------------------------------------------");
        possessionsLand();
        System.out.println("--------------------------------------------------------------------------------------------");
        possessionsPlants();
        System.out.println("--------------------------------------------------------------------------------------------");
        possessionsSownPlants();
        System.out.println("--------------------------------------------------------------------------------------------");
        possessionsAnimal();
        System.out.println("--------------------------------------------------------------------------------------------");
        possessionsBuilding();
        System.out.println("--------------------------------------------------------------------------------------------");
    }

    public Farm generateFarm() {
        Farm farm = new Farm();
        farm.calendar.set(2020, 0, 1);
        randomStartingValues(farm);
        return farm;
    }

    public Farm generateManyFarms() {
        Integer farmNumber = 0;
        Farm[] farmarr = new Farm[3];

        for (int i = 0; i <= 2; i++) {
            farmarr[i] = generateFarm();
            System.out.println("Farma nr " + (i + 1));
            farmarr[i].possessions();
        }

        while (farmNumber != 1 && farmNumber != 2 && farmNumber != 3) {
            try {
                System.out.println("Wybierz swoją startową farmę spośród trzech powyżej dostępnych wpisując wartość 1, 2 lub 3: ");
                farmNumber = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wprowadź prawidłową wartość.");
                farmNumber = 0;
            }
        }

        return farmarr[farmNumber - 1];
    }

    public void randomStartingValues(Farm farm) {
        Integer flag = 0;

        farm.getLand().setLandSizeInHa(rand.nextInt(10) + 5);
        farm.land.setFreeLand(farm.land.getLandSizeInHa());
        farm.barn.setQuantityOfThisBuildingType(1);

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
            farm.springBarley.setStoredInKg(500.0); //TODO TEST
            if (rand.nextBoolean() && flag < 3) {
                farm.whiteBeet.setStoredInKg(farm.whiteBeet.getStoredInKg() + rand.nextInt(20) + 100); //100
                flag++;
            }
            if (rand.nextBoolean() && flag < 3) {
                farm.winterWheat.setStoredInKg(farm.winterWheat.getStoredInKg() + rand.nextInt(20) + 100); //100
                flag++;
            }
        }


    }

    public Double allPlantsKg() {
        return this.getCorn().getStoredInKg() + this.getLatePotato().getStoredInKg() + this.getLateRape().getStoredInKg() + this.getLateRye().getStoredInKg() + this.getSpringBarley().getStoredInKg() + this.getWhiteBeet().getStoredInKg() + this.getWinterWheat().getStoredInKg();
    }

    public void checkNumberOfAnimals(List<Chicken> chickenList, List<Cow> cowList, List<Goat> goatList, List<Goose> gooseList, List<Pig> pigList, List<Sheep> sheepList, List<Turkey> turkeyList) {
        if (chickenList.isEmpty()) {
            totalNumberOfChicken = 0;
        } else totalNumberOfChicken = getChickenList().get(0).howManyChickenInList(chickenList);
        if (cowList.isEmpty()) {
            totalNumberOfCow = 0;
        } else totalNumberOfCow = getCowList().get(0).howManyCowInList(cowList);
        if (goatList.isEmpty()) {
            totalNumberOfGoat = 0;
        } else totalNumberOfGoat = goatList.get(0).howManyGoatInList(goatList);
        if (gooseList.isEmpty()) {
            totalNumberOfGoose = 0;
        } else totalNumberOfGoose = gooseList.get(0).howManyGooseInList(gooseList);
        if (pigList.isEmpty()) {
            totalNumberOfPig = 0;
        } else totalNumberOfPig = pigList.get(0).howManyPigInList(pigList);
        if (sheepList.isEmpty()) {
            totalNumberOfSheep = 0;
        } else totalNumberOfSheep = sheepList.get(0).howManySheepInList(sheepList);
        if (turkeyList.isEmpty()) {
            totalNumberOfTurkey = 0;
        } else totalNumberOfTurkey = turkeyList.get(0).howManyTurkeyInList(turkeyList);
        if (chickenList.isEmpty()) {
            totalNumberOfAdultChicken = 0;
        } else totalNumberOfAdultChicken = chickenList.get(0).howManyAdultChickenInList(chickenList);
        if (cowList.isEmpty()) {
            totalNumberOfAdultCow = 0;
        } else totalNumberOfAdultCow = cowList.get(0).howManyAdultCowInList(cowList);
        if (goatList.isEmpty()) {
            totalNumberOfAdultGoat = 0;
        } else totalNumberOfAdultGoat = goatList.get(0).howManyAdultGoatInList(goatList);
        if (gooseList.isEmpty()) {
            totalNumberOfAdultGoose = 0;
        } else totalNumberOfAdultGoose = gooseList.get(0).howManyAdultGooseInList(gooseList);
        if (pigList.isEmpty()) {
            totalNumberOfAdultPig = 0;
        } else totalNumberOfAdultPig = pigList.get(0).howManyAdultPigInList(pigList);
        if (sheepList.isEmpty()) {
            totalNumberOfAdultSheep = 0;
        } else totalNumberOfAdultSheep = sheepList.get(0).howManyAdultSheepInList(sheepList);
        if (turkeyList.isEmpty()) {
            totalNumberOfAdultTurkey = 0;
        } else totalNumberOfAdultTurkey = turkeyList.get(0).howManyAdultTurkeyInList(turkeyList);
    }

    public void moneyEarnOnAnimals() {
        boolean moneyFlag = false;
        System.out.print(this.owner + ", na sprzedaży produktów zwierzęcych zarobiłeś: ");
        if (totalNumberOfAdultChicken > 0) {
            System.out.println("Na kurzych jajach " + totalNumberOfAdultChicken * this.getChickenList().get(0).getAnimalProductPrice());
            this.setCash(this.getCash() + totalNumberOfAdultChicken * this.getChickenList().get(0).getAnimalProductPrice());
            moneyFlag = true;
        }
        if (totalNumberOfAdultCow > 0) {
            System.out.println("Na mleku krowim " + totalNumberOfAdultCow * this.getCowList().get(0).getAnimalProductPrice());
            this.setCash(this.getCash() + totalNumberOfAdultCow * this.getCowList().get(0).getAnimalProductPrice());
            moneyFlag = true;
        }
        if (totalNumberOfAdultGoat > 0) {
            System.out.println("Na mleku kozim " + totalNumberOfAdultGoat * this.getGoatList().get(0).getAnimalProductPrice());
            this.setCash(this.getCash() + totalNumberOfAdultGoat * this.getGoatList().get(0).getAnimalProductPrice());
            moneyFlag = true;

        }
        if (totalNumberOfAdultSheep > 0) {
            System.out.println("Na owczej wełnie " + totalNumberOfAdultSheep * this.getSheepList().get(0).getAnimalProductPrice());
            this.setCash(this.getCash() + totalNumberOfAdultSheep * this.getSheepList().get(0).getAnimalProductPrice());
            moneyFlag = true;
        }
        if (!moneyFlag)
            System.out.println("0 zł");
    }

    public void reproduction() {
        Random rand = new Random();
        Integer randInt, numberOfBorn = 0;
        boolean reproductionFlag = false;

        if (totalNumberOfAdultChicken > 1) {
            for (int i = 2; i <= totalNumberOfAdultChicken; i++) {
                randInt = rand.nextInt(this.getChickenList().get(0).getBreedingChance());
                if (randInt == 1) {
                    numberOfBorn++;
                }
            }
            if (numberOfBorn > 0) {
                System.out.println("Narodziło się: " + numberOfBorn + " młodych kur.");
                Chicken chicken = new Chicken();
                chicken.setNumberOfAnimal(numberOfBorn);
                this.chickenList.add(chicken);
                reproductionFlag = true;
            }
        }

        if (totalNumberOfAdultCow > 1) {
            for (int i = 2; i <= totalNumberOfAdultCow; i++) {
                randInt = rand.nextInt(this.getCowList().get(0).getBreedingChance());
                if (randInt == 1) {
                    numberOfBorn++;
                }
            }
            if (numberOfBorn > 0) {
                System.out.println("Narodziło się: " + numberOfBorn + " młodych krów.");
                Cow cow = new Cow();
                cow.setNumberOfAnimal(numberOfBorn);
                this.cowList.add(cow);
                reproductionFlag = true;
            }
        }
        if (totalNumberOfAdultGoat > 1) {
            for (int i = 2; i <= totalNumberOfAdultGoat; i++) {
                randInt = rand.nextInt(this.getGoatList().get(0).getBreedingChance());
                if (randInt == 1) {
                    numberOfBorn++;
                }
            }
            if (numberOfBorn > 0) {
                System.out.println("Narodziło się: " + numberOfBorn + " młodych kóz.");
                Goat goat = new Goat();
                goat.setNumberOfAnimal(numberOfBorn);
                this.goatList.add(goat);
                reproductionFlag = true;
            }
        }
        if (totalNumberOfAdultGoose > 1) {
            for (int i = 2; i <= totalNumberOfAdultGoose; i++) {
                randInt = rand.nextInt(this.getGooseList().get(0).getBreedingChance());
                if (randInt == 1) {
                    numberOfBorn++;
                }
            }
            if (numberOfBorn > 0) {
                System.out.println("Narodziło się: " + numberOfBorn + " młodych gęsi.");
                Goose goose = new Goose();
                goose.setNumberOfAnimal(numberOfBorn);
                this.gooseList.add(goose);
                reproductionFlag = true;
            }
        }
        if (totalNumberOfAdultPig > 1) {
            for (int i = 2; i <= totalNumberOfAdultPig; i++) {
                randInt = rand.nextInt(this.getPigList().get(0).getBreedingChance());
                if (randInt == 1) {
                    numberOfBorn++;
                }
            }
            if (numberOfBorn > 0) {
                System.out.println("Narodziło się: " + numberOfBorn + " młodych świń.");
                Pig pig = new Pig();
                pig.setNumberOfAnimal(numberOfBorn);
                this.pigList.add(pig);
                reproductionFlag = true;
            }
        }
        if (totalNumberOfAdultSheep > 1) {
            for (int i = 2; i <= totalNumberOfAdultSheep; i++) {
                randInt = rand.nextInt(this.getSheepList().get(0).getBreedingChance());
                if (randInt == 1) {
                    numberOfBorn++;
                }
            }
            if (numberOfBorn > 0) {
                System.out.println("Narodziło się: " + numberOfBorn + " młodych owiec.");
                Sheep sheep = new Sheep();
                sheep.setNumberOfAnimal(numberOfBorn);
                this.sheepList.add(sheep);
                reproductionFlag = true;
            }
        }
        if (totalNumberOfAdultTurkey > 1) {
            for (int i = 2; i <= totalNumberOfAdultTurkey; i++) {
                randInt = rand.nextInt(this.getTurkeyList().get(0).getBreedingChance());
                if (randInt == 1) {
                    numberOfBorn++;
                }
            }
            if (numberOfBorn > 0) {
                System.out.println("Narodziło się: " + numberOfBorn + " młodych kur.");
                Turkey turkey = new Turkey();
                turkey.setNumberOfAnimal(numberOfBorn);
                this.turkeyList.add(turkey);
                reproductionFlag = true;
            }
        }
        if (!reproductionFlag)
            System.out.println("Narodziło się 0 zwierząt.");
    }

    public void currentTime() {
        System.out.println("Jest " + calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH) + ", czyli " + getWeekOfYear() + " tydzień roku. " + turnCounter + " tura.");
    }

    public void startOfTheTurn() {
        currentTime();
        checkNumberOfAnimals(chickenList, cowList, goatList, gooseList, pigList, sheepList, turkeyList);
        Events.eventCheck(this);
        harvestSown();
        reproduction();
        moneyEarnOnAnimals();
    }

    public void nextTurn() {
        animal.eat(this, chickenList, cowList, goatList, gooseList, pigList, sheepList, turkeyList);
        this.calendar.add(Calendar.DAY_OF_WEEK, 7);
        this.winningConditions();
        this.turnCounter++;
    }

    public Integer getWeekOfYear() {
        return this.calendar.get(Calendar.WEEK_OF_YEAR);
    }

    public Date getTime() {

        return this.calendar.getTime();
    }

    public void addSown(Plant plant) {
        Sown sown = new Sown();
        sown = sown.addToSown(plant, this);
        if(sown != null)
        sownList.add(sown);

    }

    public void harvestSown() {
        Boolean harvested = false;
        for (int i = 0; i < this.sownList.size(); i++) {
            sownList.get(i).minusWeekToHarvest();
        }
        for (int i = 0; i < this.sownList.size(); i++) {
            harvested = sownList.get(i).harvestTime(this);
            if(harvested){
                sownList.remove(i);
                i--;
            }
            harvested = false;
        }
    }


    public void winningConditions() {
        //20ha ziemi, 5 różncyh gatunków zwierząt, 5 różnych gatunków roślin i jedzenie dla zwierząt na rok.
        final Integer landArea = 20;
        final Integer plantSpecies = 5;
        final Integer animalSpecies = 5;
        Integer plantSpeciesCounter = 0;
        Integer animalSpeciesCounter = 0;
        Double springBarleyCounter = this.getSpringBarley().getStoredInKg();
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
            System.out.println("     *************************************************************************************************************************************");
            System.out.println("***********************************************************************************************************************************************");
            System.out.println("Gratulacje!!! Udało ci się osiągnąć cel gry, jakim jest zebranie jednocześnie przynajmniej: ");
            System.out.println("- 20 ha ziemi;");
            System.out.println("- Pięciu gatunków roślin;");
            System.out.println("- Pięciu gatunków zwierząt;");
            System.out.println("- Karmy dla zwierząt na okres przynajmniej roku.");
            System.out.println();
            System.out.println("Stałeś się rolnikiem doskonałym. Cały świat chyli czoło przed twoimi wybitnymi osiągnięciami i otrzymujesz listy gratulacyjne z całego świata!");
            System.out.println("************************************************************************************************************************************************");
            System.out.println("     *************************************************************************************************************************************");
        }

    }
}
