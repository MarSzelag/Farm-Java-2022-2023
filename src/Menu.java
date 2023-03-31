import farm.Farm;
import plants.*;
import buildings.*;

import java.util.Scanner;

public class Menu {
    Scanner scan = new Scanner(System.in);
    private Integer mainMenuCounter = 0;
    String name;


    public Integer getMainMenuCounter() {
        return mainMenuCounter;
    }

    public void setMainMenuCounter(Integer mainMenuCounter) {
        this.mainMenuCounter = mainMenuCounter;
    }



    public void mainMenuShow() {
        System.out.println("Witamy na farmie. Posługując się poniższym menu wybierz, co chcesz zrobić.");
        System.out.println("1. Utwórz nową grę dla jednego gracza.");
        System.out.println("2. Utwórz nową grę dla wielu graczy.");
        System.out.println("9. Zakończ i opuść grę.");
    }

    public Farm mainMenu(Farm farm) { //TODO If there is wrong input in scan then repeat
        Farm menuFarm = farm;
        mainMenuShow();
        System.out.println();
        mainMenuCounter = Integer.parseInt(scan.nextLine());

        switch (mainMenuCounter) {
            case 1:
                System.out.println("Wybrałeś '1' Utworzenie gry dla jednego gracza.");
                menuFarm = createFarmMenu(farm);
                setOwnerName(menuFarm);
                return menuFarm;
            case 2:
                System.out.println("Do zrobienia:                                         Wybrałeś '2' Utworzenie gry dla wielu graczy.");
                break;
            case 9:
                System.out.println("Wybrałeś '9' Opuszczenie gry. Zapraszamy serdecznie, gdy tylko znowu zapragniesz zaznać uroków farmerskiego życia.");
                break;
            default:
                System.out.println("Wprowadzono niewłaściwą wartość. Spróbuj jeszcze raz.");
        }
        return menuFarm;
    }

    public Farm createFarmMenu(Farm farm){
        //Scanner scan = new Scanner(System.in);
        System.out.println("Rozpoczynasz nową farmerską przygodę.");
        System.out.println("Wybierz farmę, którą chcesz zarządzać");
        return farm.generateManyFarms();
    }

    public void setOwnerName(Farm farm){
        System.out.println("Napisz nam, jak mamy się do ciebie zwracać: ");
        farm.setOwner(scan.nextLine());
        System.out.println("Witamy cię, " + farm.getOwner());
    }

    public void farmMenu(Farm farm) {
        Integer farmMenuCounter = 0;

         // Do sprawdzenia --> System.out.println("Data: " + farm.getTime() + ", " + farm.getWeekOfYear() + " tydzień roku, " + " tura nr " + "farm.getTurnCounter()");
        System.out.println();

        System.out.println("Wybierz opcję: ");
        System.out.println("1. Stan posiadania.");
        System.out.println("2. Sklep.");
        System.out.println("3. Obsiewanie i zbiory.");
        System.out.println("4. Zarządzanie zwierzętami.");
        System.out.println("5. Koniec tury.");
        System.out.println("9. Wyjdź z gry.");

        farmMenuCounter = Integer.parseInt(scan.nextLine());

        switch (farmMenuCounter) {
            case 1:
                System.out.println("Stan posiadania.");
                farm.possesions();
                break;
            case 2:
                System.out.println("Sklep.");
                shopMenu(farm);
                break;
            case 3:
                System.out.println("Obsiewanie i zbiory.");
                break;
            case 4:
                System.out.println("Zarządzanie zwierzętami.");
                break;
            case 5:
                System.out.println("Koniec tury.");
                break;
            case 9:
                System.out.println("Wyjdź z gry."); // Wyjście z gry powinno mieć potwierdzenie, czy na pewno.
                break;
            default:
                System.out.println("Wprowadzonow niewłaściwą wartość. Spróbuj jeszcze raz.");
        }
    }

    public void possesionsMenu(Farm farm) {
        Integer possesionMenuCounter = 0;
        farm.possesions();

        System.out.println("7. Powrót do menu głównego farmy.");

        switch (possesionMenuCounter) {
            case 5:
                break;
            default:
                System.out.println("Wprowadzonow niewłaściwą wartość. Spróbuj jeszcze raz.");
        }

    }

    public void shopMenu(Farm farm) {
        System.out.println("Wybierz dział: ");
        System.out.println("1. Rośliny.");
        System.out.println("2. Zwierzęta.");
        System.out.println("3. Budynki.");
        System.out.println("4. Ziemia.");
        System.out.println("9. Powrót do menu głównego farmy.");

        Integer shopMenuCounter = 0;
        shopMenuCounter = Integer.parseInt(scan.nextLine());

        switch (shopMenuCounter) {
            case 1:
                shopMenuPlants(farm);
                break;
            case 2:
                shopMenuAnimals(farm);
                break;
            case 3:
                shopMenuBuildings(farm);
                break;
            case 4:
                shopMenuLand(farm);
                break;
            case 9:
                System.out.println("Powrót do menu głównego farmy.");
                break;
            default:
                System.out.println("Wprowadzonow niewłaściwą wartość. Spróbuj jeszcze raz.");
        }

    }

    public void shopMenuPlants(Farm farm){
        System.out.println("Sklep. Dział handlu roślinami.");
        System.out.println("Wybierz, czym chcesz handlować: ");
        System.out.println("1. Kukurydza.");
        System.out.println("2. Ziemniak późny.");
        System.out.println("3. Rzepak ozimy.");
        System.out.println("4. Żyto ozime.");
        System.out.println("5. Jęczmień jary.");
        System.out.println("6. Burak cukrowy.");
        System.out.println("7. Pszenica ozima.");
        System.out.println("9. Powrót do menu głównego sklepu.");

        Integer shopMenuPlantsCounter = 0;
        shopMenuPlantsCounter = Integer.parseInt(scan.nextLine());

        switch(shopMenuPlantsCounter){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 9:
                break;
        }

    }
    public void shopMenuAnimals(Farm farm){
        System.out.println("Sklep. Dział handlu zwierzętami.");
        System.out.println("Wybierz, czym chcesz handlować: ");
        System.out.println("1. Kury.");
        System.out.println("2. Krowy.");
        System.out.println("3. Kozy.");
        System.out.println("4. Gęsi.");
        System.out.println("5. Świnie.");
        System.out.println("6. Owce.");
        System.out.println("7. Indyki.");
        System.out.println("9. Powrót do menu głównego sklepu.");

        Integer shopMenuAnimalsCounter = 0;
        shopMenuAnimalsCounter = Integer.parseInt(scan.nextLine());

        switch(shopMenuAnimalsCounter){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 9:
                break;
        }

    }
    public void shopMenuBuildings(Farm farm){
        System.out.println("Sklep. Dział handlu budynkami.");
        System.out.println("Wybierz, czym chcesz handlować: ");
        System.out.println("1. Kurniki.");
        System.out.println("2. Obory.");
        System.out.println("3. Stodoły dla kóz.");
        System.out.println("4. Kurniki dla gęsi.");
        System.out.println("5. Chlewy.");
        System.out.println("6. Owczarnie.");
        System.out.println("7. Kurniki dla indyków.");
        System.out.println("8. Stodoły.");
        System.out.println("9. Powrót do menu głównego sklepu.");

        Integer shopMenuBuildingsCounter = 0;
        shopMenuBuildingsCounter = Integer.parseInt(scan.nextLine());

        switch(shopMenuBuildingsCounter){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
        }

    }
    public void shopMenuLand(Farm farm){
        System.out.println("Sklep. Dział handlu ziemią.");
        System.out.println("Wybierz, czym chcesz handlować: ");

        Integer shopMenuLandCounter = 0;
        shopMenuLandCounter = Integer.parseInt(scan.nextLine());

        switch(shopMenuLandCounter) {
            case 1:
                farm.shop.buyLand(farm); //TODO Can I remove farm from method if I have farm.shop?
                break;
            case 2:
                farm.shop.buyLand(farm);
                break;
            case 9:
                break;
        }
    }


    public void sowAndHarvestMenu(Farm farm) {
        Integer sowAndHarvestMenuCounter = 0;

        System.out.println("Wybierz opcję:");
        System.out.println("1. Zasiew.");
        System.out.println("2. Zbiory.");
        System.out.println("7. Powrót do menu głównego farmy.");

        switch (sowAndHarvestMenuCounter) {
            case 1:
                System.out.println("Zasiew.");
                break;
            case 2:
                System.out.println("Zbiory.");
                break;
            case 7:
                System.out.println("Powrót do menu głównego farmy.");
                break;
            default:
                System.out.println("Wprowadzonow niewłaściwą wartość. Spróbuj jeszcze raz.");
        }
    }

    //TODO plants menus
    public void shopMenuCorn(Farm farm){
        System.out.println("Chcesz sprzedać, czy kupić kukurydzę?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Wyjście z tego menu.");

        Integer shopMenuCornCounter = 0;
        Corn corn = new Corn();

        shopMenuCornCounter = Integer.parseInt(scan.nextLine());

        switch(shopMenuCornCounter) {
            case 1:
                farm.shop.buyPlant(corn, farm);
                break;
            case 2:
                farm.shop.sellPlant(corn, farm );
                break;
            case 9:
                break;
        }

    }
    public void shopMenuLatePotato(Farm farm){
        System.out.println("Chcesz sprzedać, czy kupić późne ziemniaki?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Wyjście z tego menu.");

        Integer shopMenuLatePotatoCounter = 0;
        LatePotato latePotato = new LatePotato();

        shopMenuLatePotatoCounter = Integer.parseInt(scan.nextLine());

        switch(shopMenuLatePotatoCounter) {
            case 1:
                farm.shop.buyPlant(latePotato, farm);
                break;
            case 2:
                farm.shop.sellPlant(latePotato, farm );
                break;
            case 9:
                break;
        }

    }
    public void shopMenuLateRape(Farm farm){
        System.out.println("Chcesz sprzedać, czy kupić rzepak ozimy?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Wyjście z tego menu.");

        Integer shopMenuLateRapeCounter = 0;
        LateRape lateRape = new LateRape();

        shopMenuLateRapeCounter = Integer.parseInt(scan.nextLine());

        switch(shopMenuLateRapeCounter) {
            case 1:
                farm.shop.buyPlant(lateRape, farm);
                break;
            case 2:
                farm.shop.sellPlant(lateRape, farm);
                break;
            case 9:
                break;
        }

    }
    public void shopMenuLateRye(Farm farm){
        System.out.println("Chcesz sprzedać, czy kupić żyto ozime?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Wyjście z tego menu.");

        Integer shopMenuLateRyeCounter = 0;
        LateRye lateRye = new LateRye();

        shopMenuLateRyeCounter = Integer.parseInt(scan.nextLine());

        switch(shopMenuLateRyeCounter) {
            case 1:
                farm.shop.buyPlant(lateRye, farm);
                break;
            case 2:
                farm.shop.sellPlant(lateRye, farm);
                break;
            case 9:
                break;
        }

    }
    public void shopMenuSpringBarley(Farm farm){
        System.out.println("Chcesz sprzedać, czy kupić jęczmień jary?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Wyjście z tego menu.");

        Integer shopMenuSpringBarleyCounter = 0;
        SpringBarley springBarley = new SpringBarley();

        shopMenuSpringBarleyCounter = Integer.parseInt(scan.nextLine());

        switch(shopMenuSpringBarleyCounter) {
            case 1:
                farm.shop.buyPlant(springBarley, farm);
                break;
            case 2:
                farm.shop.sellPlant(springBarley, farm);
                break;
            case 9:
                break;
        }

    }
    public void shopMenuWhiteBeet(Farm farm){
        System.out.println("Chcesz sprzedać, czy kupić buraki cukrowe?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Wyjście z tego menu.");

        Integer shopMenuWhiteBeetCounter = 0;
        WhiteBeet whiteBeet = new WhiteBeet();

        shopMenuWhiteBeetCounter = Integer.parseInt(scan.nextLine());

        switch(shopMenuWhiteBeetCounter) {
            case 1:
                farm.shop.buyPlant(whiteBeet, farm);
                break;
            case 2:
                farm.shop.sellPlant(whiteBeet, farm);
                break;
            case 9:
                break;
        }

    }
    public void shopMenuWinterWheat(Farm farm){
        System.out.println("Chcesz sprzedać, czy kupić pszenicę ozimą?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Wyjście z tego menu.");

        Integer shopMenuWinterWheatCounter = 0;
        WinterWheat winterWheat = new WinterWheat();

        shopMenuWinterWheatCounter = Integer.parseInt(scan.nextLine());

        switch(shopMenuWinterWheatCounter) {
            case 1:
                farm.shop.buyPlant(winterWheat, farm);
                break;
            case 2:
                farm.shop.sellPlant(winterWheat, farm);
                break;
            case 9:
                break;
        }

    }
    //TODO animals menus
    public void shopMenuChicken(Farm farm){
        System.out.println("Chcesz sprzedać, czy kupić kury?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Wyjście z tego menu.");

        Integer shopMenuChickenCounter = 0;

        shopMenuChickenCounter = Integer.parseInt(scan.nextLine());

        switch(shopMenuChickenCounter) {
            case 1:
                farm.shop.buyChicken(farm);
                break;
            case 2:
                farm.shop.sellChicken(farm);
                break;
            case 9:
                break;
        }

    }
    public void shopMenuCow(Farm farm){
        System.out.println("Chcesz sprzedać, czy kupić krowy?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Wyjście z tego menu.");

        Integer shopMenuCowCounter = 0;

        shopMenuCowCounter = Integer.parseInt(scan.nextLine());

        switch(shopMenuCowCounter) {
            case 1:
                farm.shop.buyCow(farm);
                break;
            case 2:
                farm.shop.sellCow(farm);
                break;
            case 9:
                break;
        }

    }
    public void shopMenuGoat(Farm farm){
        System.out.println("Chcesz sprzedać, czy kupić ");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Wyjście z tego menu.");

        Integer shopMenuGoatCounter = 0;

        shopMenuGoatCounter = Integer.parseInt(scan.nextLine());

        switch(shopMenuGoatCounter) {
            case 1:
                farm.shop.buyGoat(farm);
                break;
            case 2:
                farm.shop.sellGoat(farm);
                break;
            case 9:
                break;
        }

    }
    public void shopMenuGoose(Farm farm){
        System.out.println("Chcesz sprzedać, czy kupić kozy?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Wyjście z tego menu.");

        Integer shopMenuGooseCounter = 0;

        shopMenuGooseCounter = Integer.parseInt(scan.nextLine());

        switch(shopMenuGooseCounter) {
            case 1:
                farm.shop.buyGoose(farm);
                break;
            case 2:
                farm.shop.sellGoose(farm);
                break;
            case 9:
                break;
        }

    }
    public void shopMenuPig(Farm farm){
        System.out.println("Chcesz sprzedać, czy kupić świnie?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Wyjście z tego menu.");

        Integer shopMenuPigCounter = 0;

        shopMenuPigCounter = Integer.parseInt(scan.nextLine());

        switch(shopMenuPigCounter) {
            case 1:
                farm.shop.buyPig(farm);
                break;
            case 2:
                farm.shop.sellPig(farm);
                break;
            case 9:
                break;
        }

    }
    public void shopMenuSheep(Farm farm){
        System.out.println("Chcesz sprzedać, czy kupić owce?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Wyjście z tego menu.");

        Integer shopMenuSheepCounter = 0;

        shopMenuSheepCounter = Integer.parseInt(scan.nextLine());

        switch(shopMenuSheepCounter) {
            case 1:
                farm.shop.buySheep(farm);
                break;
            case 2:
                farm.shop.sellSheep(farm);
                break;
            case 9:
                break;
        }

    }
    public void shopMenuTurkey(Farm farm){
        System.out.println("Chcesz sprzedać, czy kupić indyki?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Wyjście z tego menu.");

        Integer shopMenuTurkeyCounter = 0;

        shopMenuTurkeyCounter = Integer.parseInt(scan.nextLine());

        switch(shopMenuTurkeyCounter) {
            case 1:
                farm.shop.buyTurkey(farm);
                break;
            case 2:
                farm.shop.sellTurkey(farm);
                break;
            case 9:
                break;
        }

    }
    //TODO buildings menus
    public void shopMenuBarn(Farm farm){
        System.out.println("Chcesz sprzedać, czy kupić stodoły?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Wyjście z tego menu.");

        Integer shopMenuBarnCounter = 0;
        Barn barn = new Barn();

        shopMenuBarnCounter = Integer.parseInt(scan.nextLine());

        switch(shopMenuBarnCounter) {
            case 1:
                farm.shop.buyBuilding(barn, farm);
                break;
            case 2:
                farm.shop.sellBuilding(barn, farm);
                break;
            case 9:
                break;
        }

    }
    public void shopMenuChickenCoop(Farm farm){
        System.out.println("Chcesz sprzedać, czy kupić kurniki?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Wyjście z tego menu.");

        Integer shopMenuChickenCoopCounter = 0;
        ChickenCoop chickenCoop = new ChickenCoop();

        shopMenuChickenCoopCounter = Integer.parseInt(scan.nextLine());

        switch(shopMenuChickenCoopCounter) {
            case 1:
                farm.shop.buyBuilding(chickenCoop, farm);
                break;
            case 2:
                farm.shop.sellBuilding(chickenCoop, farm);
                break;
            case 9:
                break;
        }

    }
    public void shopMenuCowShed(Farm farm){
        System.out.println("Chcesz sprzedać, czy kupić obory?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Wyjście z tego menu.");

        Integer shopMenuCowShedCounter = 0;
        CowShed cowShed = new CowShed();

        shopMenuCowShedCounter = Integer.parseInt(scan.nextLine());

        switch(shopMenuCowShedCounter) {
            case 1:
                farm.shop.buyBuilding(cowShed, farm);
                break;
            case 2:
                farm.shop.sellBuilding(cowShed, farm);
                break;
            case 9:
                break;
        }

    }
    public void shopMenuGoatBarn(Farm farm){
        System.out.println("Chcesz sprzedać, czy kupić stodoły dla kóz?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Wyjście z tego menu.");

        Integer shopMenuGoatBarnCounter = 0;
        Barn barn = new Barn();

        shopMenuGoatBarnCounter = Integer.parseInt(scan.nextLine());

        switch(shopMenuGoatBarnCounter) {
            case 1:
                farm.shop.buyBuilding(barn, farm);
                break;
            case 2:
                farm.shop.sellBuilding(barn, farm);
                break;
            case 9:
                break;
        }

    }
    public void shopMenuGooseCoop(Farm farm){
        System.out.println("Chcesz sprzedać, czy kupić kurniki dla gęsi?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Wyjście z tego menu.");

        Integer shopMenuGooseCoopCounter = 0;
        GooseCoop gooseCoop = new GooseCoop();

        shopMenuGooseCoopCounter = Integer.parseInt(scan.nextLine());

        switch(shopMenuGooseCoopCounter) {
            case 1:
                farm.shop.buyBuilding(gooseCoop, farm);
                break;
            case 2:
                farm.shop.sellBuilding(gooseCoop, farm);
                break;
            case 9:
                break;
        }

    }
    public void shopMenuPigsty(Farm farm){
        System.out.println("Chcesz sprzedać, czy kupić chlewy?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Wyjście z tego menu.");

        Integer shopMenuPigstyCounter = 0;
        Pigsty pigsty = new Pigsty();

        shopMenuPigstyCounter = Integer.parseInt(scan.nextLine());

        switch(shopMenuPigstyCounter) {
            case 1:
                farm.shop.buyBuilding(pigsty, farm);
                break;
            case 2:
                farm.shop.sellBuilding(pigsty, farm);
                break;
            case 9:
                break;
        }

    }
    public void shopMenuSheepfold(Farm farm){
        System.out.println("Chcesz sprzedać, czy kupić owczarnie?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Wyjście z tego menu.");

        Integer shopMenuSheepfoldCounter = 0;
        Sheepfold sheepfold = new Sheepfold();

        shopMenuSheepfoldCounter = Integer.parseInt(scan.nextLine());

        switch(shopMenuSheepfoldCounter) {
            case 1:
                farm.shop.buyBuilding(sheepfold, farm);
                break;
            case 2:
                farm.shop.sellBuilding(sheepfold, farm);
                break;
            case 9:
                break;
        }

    }
    public void shopMenuTurkeyCoop(Farm farm){
        System.out.println("Chcesz sprzedać, czy kupić kurniki dla indyków?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Wyjście z tego menu.");

        Integer shopMenuTurkeyCoopCounter = 0;
        TurkeyCoop turkeyCoop = new TurkeyCoop();

        shopMenuTurkeyCoopCounter = Integer.parseInt(scan.nextLine());

        switch(shopMenuTurkeyCoopCounter) {
            case 1:
                farm.shop.buyBuilding(turkeyCoop, farm);
                break;
            case 2:
                farm.shop.sellBuilding(turkeyCoop, farm);
                break;
            case 9:
                break;
        }

    }

    //TODO rest
    public void sowMenu() {
        Integer sowMenuCounter = 0;

    }

    public void harvestMenu() {
        Integer harvestMenuCounter = 0;

    }
}
