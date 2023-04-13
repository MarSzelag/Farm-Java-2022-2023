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

    public Farm createFarmMenu(Farm farm) {
        //Scanner scan = new Scanner(System.in);
        System.out.println("Rozpoczynasz nową farmerską przygodę.");
        System.out.println("Wybierz farmę, którą chcesz zarządzać");
        return farm.generateManyFarms();
    }

    public void setOwnerName(Farm farm) {
        System.out.println("Napisz nam, jak mamy się do ciebie zwracać: ");
        farm.setOwner(scan.nextLine());
        System.out.println("Witamy cię, " + farm.getOwner());
    }

    public Integer farmMenu(Farm farm) {
        Integer farmMenuCounter = 0;

        // Do sprawdzenia --> System.out.println("Data: " + farm.getTime() + ", " + farm.getWeekOfYear() + " tydzień roku, " + " tura nr " + "farm.getTurnCounter()");
        System.out.println();

        System.out.println("Wybierz opcję: ");
        System.out.println("1. Stan posiadania.");
        System.out.println("2. Sklep.");
        System.out.println("3. Obsiewanie.");
        System.out.println("4. Koniec tury.");
        System.out.println("9. Wyjdź z gry.");

        farmMenuCounter = Integer.parseInt(scan.nextLine());
        Integer farmCounter = 0;

        switch (farmMenuCounter) {
            case 1:
                System.out.println("Stan posiadania.");
                farm.possesions();
                break;
            case 2:
                System.out.println("Sklep.");
                while (farmCounter != 9) {
                    farmCounter = shopMenu(farm);
                }
                break;
            case 3:
                System.out.println("Obsiewanie");
                while (farmCounter != 9) {
                    farmCounter = sowMenu(farm);
                }
                break;
            case 4:
                System.out.println("Koniec tury.");
                break;
            case 9:
                System.out.println("Wyjdź z gry.");
                break;
            default:
                System.out.println("Wprowadzono niewłaściwą wartość. Spróbuj jeszcze raz.");
        }
        return farmMenuCounter;
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

    public Integer shopMenu(Farm farm) {
        System.out.println("Wybierz dział: ");
        System.out.println("1. Rośliny.");
        System.out.println("2. Zwierzęta.");
        System.out.println("3. Budynki.");
        System.out.println("4. Ziemia.");
        System.out.println("9. Powrót do menu głównego farmy.");

        Integer shopMenuCounter = 0;
        shopMenuCounter = Integer.parseInt(scan.nextLine());
        Integer shopCounter = 0;

        switch (shopMenuCounter) {
            case 1:
                while (shopCounter != 9) {
                    shopCounter = shopMenuPlants(farm);
                }
                break;
            case 2:
                while (shopCounter != 9) {
                    shopCounter = shopMenuAnimals(farm);
                }
                break;
            case 3:
                while (shopCounter != 9) {
                    shopCounter = shopMenuBuildings(farm);
                }
                break;
            case 4:
                while (shopCounter != 9) {
                    shopCounter = shopMenuLand(farm);
                }
                break;
            case 9:
                System.out.println("Powrót do menu głównego farmy.");
                break;
            default:
                System.out.println("Wprowadzonow niewłaściwą wartość. Spróbuj jeszcze raz.");
        }
        return shopMenuCounter;
    }

    public Integer shopMenuPlants(Farm farm) {
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
        Integer plantsCounter = 0;
        shopMenuPlantsCounter = Integer.parseInt(scan.nextLine());

        switch (shopMenuPlantsCounter) {
            case 1:
                while (plantsCounter != 9) {
                    plantsCounter = shopMenuCorn(farm);
                }
                break;
            case 2:
                while (plantsCounter != 9) {
                    plantsCounter = shopMenuLatePotato(farm);
                }
                break;
            case 3:
                while (plantsCounter != 9) {
                    plantsCounter = shopMenuLateRape(farm);
                }
                break;
            case 4:
                while (plantsCounter != 9) {
                    plantsCounter = shopMenuLateRye(farm);
                }
                break;
            case 5:
                while (plantsCounter != 9) {
                    plantsCounter = shopMenuSpringBarley(farm);
                }
                break;
            case 6:
                while (plantsCounter != 9) {
                    plantsCounter = shopMenuWhiteBeet(farm);
                }
                break;
            case 7:
                while (plantsCounter != 9) {
                    plantsCounter = shopMenuWinterWheat(farm);
                }
                break;
            case 9:
                System.out.println("Powrót do menu głównego sklepu.");
                break;
        }
        return shopMenuPlantsCounter;
    }

    public Integer shopMenuAnimals(Farm farm) {
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
        Integer animalCounter = 0;
        shopMenuAnimalsCounter = Integer.parseInt(scan.nextLine());

        switch (shopMenuAnimalsCounter) {
            case 1:
                while (animalCounter != 9) {
                    animalCounter = shopMenuChicken(farm);
                }
                break;
            case 2:
                while (animalCounter != 9) {
                    animalCounter = shopMenuCow(farm);
                }
                break;
            case 3:
                while (animalCounter != 9) {
                    animalCounter = shopMenuGoat(farm);
                }
                break;
            case 4:
                while (animalCounter != 9) {
                    animalCounter = shopMenuGoose(farm);
                }
                break;
            case 5:
                while (animalCounter != 9) {
                    animalCounter = shopMenuPig(farm);
                }
                break;
            case 6:
                while (animalCounter != 9) {
                    animalCounter = shopMenuSheep(farm);
                }
                break;
            case 7:
                while (animalCounter != 9) {
                    animalCounter = shopMenuTurkey(farm);
                }
                break;
            case 9:
                System.out.println("Powrót do menu głównego sklepu.");
                break;
        }
        return shopMenuAnimalsCounter;

    }

    public Integer shopMenuBuildings(Farm farm) {
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
        Integer buildingCounter = 0;
        shopMenuBuildingsCounter = Integer.parseInt(scan.nextLine());

        switch (shopMenuBuildingsCounter) {
            case 1:
                while (buildingCounter != 9) {
                    buildingCounter = shopMenuChickenCoop(farm);
                }
                break;
            case 2:
                while (buildingCounter != 9) {
                    buildingCounter = shopMenuCowShed(farm);
                }
                break;
            case 3:
                while (buildingCounter != 9) {
                    buildingCounter = shopMenuGoatBarn(farm);
                }
                break;
            case 4:
                while (buildingCounter != 9) {
                    buildingCounter = shopMenuGooseCoop(farm);
                }
                break;
            case 5:
                while (buildingCounter != 9) {
                    buildingCounter = shopMenuPigsty(farm);
                }
                break;
            case 6:
                while (buildingCounter != 9) {
                    buildingCounter = shopMenuSheepfold(farm);
                }
                break;
            case 7:
                while (buildingCounter != 9) {
                    buildingCounter = shopMenuTurkeyCoop(farm);
                }
                break;
            case 8:
                while (buildingCounter != 9) {
                    buildingCounter = shopMenuBarn(farm);
                }
                break;
            case 9:
                System.out.println("Powrót do menu głównego sklepu.");
                break;
        }
        return shopMenuBuildingsCounter;
    }

    public Integer shopMenuLand(Farm farm) {
        System.out.println("Sklep. Dział handlu ziemią.");
        System.out.println("Wybierz, czy chcesz kupić, czy sprzedać ziemię: ");
        System.out.println("1. Kupno ziemi.");
        System.out.println("2. Sprzedaż ziemi.");
        System.out.println("9. Wyjście do menu głównego.");

        Integer shopMenuLandCounter = 0;
        Integer landCounter;
        shopMenuLandCounter = Integer.parseInt(scan.nextLine());

        switch (shopMenuLandCounter) {
            case 1:
                //    while(landCounter != 0) {
                farm.shop.buyLand(farm);
                //  }
                break;
            case 2:
                //while(landCounter != 0) {
                farm.shop.sellLand(farm);
                //}
                break;
            case 9:
                System.out.println("Powrót do menu głównego sklepu.");
                break;
        }
        return shopMenuLandCounter;
    }
/*

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
    }*/

    //TODO plants menus
    public Integer shopMenuCorn(Farm farm) {
        System.out.println("Chcesz sprzedać, czy kupić kukurydzę?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Powrót do menu roślin w sklepie.");

        Integer shopMenuCornCounter = 0;
        Corn corn = new Corn();

        shopMenuCornCounter = Integer.parseInt(scan.nextLine());

        switch (shopMenuCornCounter) {
            case 1:
                farm.shop.buyPlant(farm.getCorn(), farm);
                break;
            case 2:
                farm.shop.sellPlant(farm.getCorn(), farm);
                break;
            case 9:
                break;
        }
        return shopMenuCornCounter;
    }

    public Integer shopMenuLatePotato(Farm farm) {
        System.out.println("Chcesz sprzedać, czy kupić późne ziemniaki?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Powrót do menu roślin w sklepie.");

        Integer shopMenuLatePotatoCounter = 0;
        LatePotato latePotato = new LatePotato();

        shopMenuLatePotatoCounter = Integer.parseInt(scan.nextLine());

        switch (shopMenuLatePotatoCounter) {
            case 1:
                farm.shop.buyPlant(farm.getLatePotato(), farm);
                break;
            case 2:
                farm.shop.sellPlant(farm.getLatePotato(), farm);
                break;
            case 9:
                break;
        }
        return shopMenuLatePotatoCounter;
    }

    public Integer shopMenuLateRape(Farm farm) {
        System.out.println("Chcesz sprzedać, czy kupić rzepak ozimy?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Powrót do menu roślin w sklepie.");

        Integer shopMenuLateRapeCounter = 0;
        LateRape lateRape = new LateRape();

        shopMenuLateRapeCounter = Integer.parseInt(scan.nextLine());

        switch (shopMenuLateRapeCounter) {
            case 1:
                farm.shop.buyPlant(farm.getLateRape(), farm);
                break;
            case 2:
                farm.shop.sellPlant(farm.getLateRape(), farm);
                break;
            case 9:
                break;
        }
        return shopMenuLateRapeCounter;
    }

    public Integer shopMenuLateRye(Farm farm) {
        System.out.println("Chcesz sprzedać, czy kupić żyto ozime?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Powrót do menu roślin w sklepie.");

        Integer shopMenuLateRyeCounter = 0;
        LateRye lateRye = new LateRye();

        shopMenuLateRyeCounter = Integer.parseInt(scan.nextLine());

        switch (shopMenuLateRyeCounter) {
            case 1:
                farm.shop.buyPlant(farm.getLateRye(), farm);
                break;
            case 2:
                farm.shop.sellPlant(farm.getLateRye(), farm);
                break;
            case 9:
                break;
        }
        return shopMenuLateRyeCounter;
    }

    public Integer shopMenuSpringBarley(Farm farm) {
        System.out.println("Chcesz sprzedać, czy kupić jęczmień jary?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Powrót do menu roślin w sklepie.");

        Integer shopMenuSpringBarleyCounter = 0;
        SpringBarley springBarley = new SpringBarley();

        shopMenuSpringBarleyCounter = Integer.parseInt(scan.nextLine());

        switch (shopMenuSpringBarleyCounter) {
            case 1:
                farm.shop.buyPlant(farm.getSpringBarley(), farm);
                break;
            case 2:
                farm.shop.sellPlant(farm.getSpringBarley(), farm);
                break;
            case 9:
                break;
        }
        return shopMenuSpringBarleyCounter;
    }

    public Integer shopMenuWhiteBeet(Farm farm) {
        System.out.println("Chcesz sprzedać, czy kupić buraki cukrowe?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Powrót do menu roślin w sklepie.");

        Integer shopMenuWhiteBeetCounter = 0;
        WhiteBeet whiteBeet = new WhiteBeet();

        shopMenuWhiteBeetCounter = Integer.parseInt(scan.nextLine());

        switch (shopMenuWhiteBeetCounter) {
            case 1:
                farm.shop.buyPlant(farm.getWhiteBeet(), farm);
                break;
            case 2:
                farm.shop.sellPlant(farm.getWhiteBeet(), farm);
                break;
            case 9:
                break;
        }
        return shopMenuWhiteBeetCounter;
    }

    public Integer shopMenuWinterWheat(Farm farm) {
        System.out.println("Chcesz sprzedać, czy kupić pszenicę ozimą?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Powrót do menu roślin w sklepie.");

        Integer shopMenuWinterWheatCounter = 0;
        WinterWheat winterWheat = new WinterWheat();

        shopMenuWinterWheatCounter = Integer.parseInt(scan.nextLine());

        switch (shopMenuWinterWheatCounter) {
            case 1:
                farm.shop.buyPlant(farm.getWinterWheat(), farm);
                break;
            case 2:
                farm.shop.sellPlant(farm.getWinterWheat(), farm);
                break;
            case 9:
                break;
        }
        return shopMenuWinterWheatCounter;
    }

    public Integer shopMenuChicken(Farm farm) {
        System.out.println("Chcesz sprzedać, czy kupić kury?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Powrót do menu zwierząt w sklepie.");

        Integer shopMenuChickenCounter = 0;

        shopMenuChickenCounter = Integer.parseInt(scan.nextLine());

        switch (shopMenuChickenCounter) {
            case 1:
                farm.shop.buyChicken(farm);
                break;
            case 2:
                farm.shop.sellChicken(farm);
                break;
            case 9:
                break;
        }
        return shopMenuChickenCounter;
    }

    public Integer shopMenuCow(Farm farm) {
        System.out.println("Chcesz sprzedać, czy kupić krowy?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Powrót do menu zwierząt w sklepie.");

        Integer shopMenuCowCounter = 0;

        shopMenuCowCounter = Integer.parseInt(scan.nextLine());

        switch (shopMenuCowCounter) {
            case 1:
                farm.shop.buyCow(farm);
                break;
            case 2:
                farm.shop.sellCow(farm);
                break;
            case 9:
                break;
        }
        return shopMenuCowCounter;
    }

    public Integer shopMenuGoat(Farm farm) {
        System.out.println("Chcesz sprzedać, czy kupić ");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Powrót do menu zwierząt w sklepie.");

        Integer shopMenuGoatCounter = 0;

        shopMenuGoatCounter = Integer.parseInt(scan.nextLine());

        switch (shopMenuGoatCounter) {
            case 1:
                farm.shop.buyGoat(farm);
                break;
            case 2:
                farm.shop.sellGoat(farm);
                break;
            case 9:
                break;
        }
        return shopMenuGoatCounter;
    }

    public Integer shopMenuGoose(Farm farm) {
        System.out.println("Chcesz sprzedać, czy kupić kozy?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Powrót do menu zwierząt w sklepie.");

        Integer shopMenuGooseCounter = 0;

        shopMenuGooseCounter = Integer.parseInt(scan.nextLine());

        switch (shopMenuGooseCounter) {
            case 1:
                farm.shop.buyGoose(farm);
                break;
            case 2:
                farm.shop.sellGoose(farm);
                break;
            case 9:
                break;
        }
        return shopMenuGooseCounter;
    }

    public Integer shopMenuPig(Farm farm) {
        System.out.println("Chcesz sprzedać, czy kupić świnie?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Powrót do menu zwierząt w sklepie.");

        Integer shopMenuPigCounter = 0;

        shopMenuPigCounter = Integer.parseInt(scan.nextLine());

        switch (shopMenuPigCounter) {
            case 1:
                farm.shop.buyPig(farm);
                break;
            case 2:
                farm.shop.sellPig(farm);
                break;
            case 9:
                break;
        }
        return shopMenuPigCounter;
    }

    public Integer shopMenuSheep(Farm farm) {
        System.out.println("Chcesz sprzedać, czy kupić owce?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Powrót do menu zwierząt w sklepie.");

        Integer shopMenuSheepCounter = 0;

        shopMenuSheepCounter = Integer.parseInt(scan.nextLine());

        switch (shopMenuSheepCounter) {
            case 1:
                farm.shop.buySheep(farm);
                break;
            case 2:
                farm.shop.sellSheep(farm);
                break;
            case 9:
                break;
        }
        return shopMenuSheepCounter;
    }

    public Integer shopMenuTurkey(Farm farm) {
        System.out.println("Chcesz sprzedać, czy kupić indyki?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Powrót do menu zwierząt w sklepie.");

        Integer shopMenuTurkeyCounter = 0;

        shopMenuTurkeyCounter = Integer.parseInt(scan.nextLine());

        switch (shopMenuTurkeyCounter) {
            case 1:
                farm.shop.buyTurkey(farm);
                break;
            case 2:
                farm.shop.sellTurkey(farm);
                break;
            case 9:
                break;
        }
        return shopMenuTurkeyCounter;
    }

    //TODO buildings menus
    public Integer shopMenuBarn(Farm farm) {
        System.out.println("Chcesz sprzedać, czy kupić stodoły?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Powrót do menu budynków w sklepie.");

        Integer shopMenuBarnCounter = 0;
        Barn barn = new Barn();

        shopMenuBarnCounter = Integer.parseInt(scan.nextLine());

        switch (shopMenuBarnCounter) {
            case 1:
                farm.shop.buyBuilding(barn, farm);
                break;
            case 2:
                farm.shop.sellBuilding(barn, farm);
                break;
            case 9:
                break;
        }
        return shopMenuBarnCounter;
    }

    public Integer shopMenuChickenCoop(Farm farm) {
        System.out.println("Chcesz sprzedać, czy kupić kurniki?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Powrót do menu budynków w sklepie.");

        Integer shopMenuChickenCoopCounter = 0;
        ChickenCoop chickenCoop = new ChickenCoop();

        shopMenuChickenCoopCounter = Integer.parseInt(scan.nextLine());

        switch (shopMenuChickenCoopCounter) {
            case 1:
                farm.shop.buyBuilding(chickenCoop, farm);
                break;
            case 2:
                farm.shop.sellBuilding(chickenCoop, farm);
                break;
            case 9:
                break;
        }
        return shopMenuChickenCoopCounter;
    }

    public Integer shopMenuCowShed(Farm farm) {
        System.out.println("Chcesz sprzedać, czy kupić obory?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Powrót do menu budynków w sklepie.");

        Integer shopMenuCowShedCounter = 0;
        CowShed cowShed = new CowShed();

        shopMenuCowShedCounter = Integer.parseInt(scan.nextLine());

        switch (shopMenuCowShedCounter) {
            case 1:
                farm.shop.buyBuilding(cowShed, farm);
                break;
            case 2:
                farm.shop.sellBuilding(cowShed, farm);
                break;
            case 9:
                break;
        }
        return shopMenuCowShedCounter;
    }

    public Integer shopMenuGoatBarn(Farm farm) {
        System.out.println("Chcesz sprzedać, czy kupić stodoły dla kóz?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Powrót do menu budynków w sklepie.");

        Integer shopMenuGoatBarnCounter = 0;
        Barn barn = new Barn();

        shopMenuGoatBarnCounter = Integer.parseInt(scan.nextLine());

        switch (shopMenuGoatBarnCounter) {
            case 1:
                farm.shop.buyBuilding(barn, farm);
                break;
            case 2:
                farm.shop.sellBuilding(barn, farm);
                break;
            case 9:
                break;
        }
        return shopMenuGoatBarnCounter;
    }

    public Integer shopMenuGooseCoop(Farm farm) {
        System.out.println("Chcesz sprzedać, czy kupić kurniki dla gęsi?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Powrót do menu budynków w sklepie.");

        Integer shopMenuGooseCoopCounter = 0;
        GooseCoop gooseCoop = new GooseCoop();

        shopMenuGooseCoopCounter = Integer.parseInt(scan.nextLine());

        switch (shopMenuGooseCoopCounter) {
            case 1:
                farm.shop.buyBuilding(gooseCoop, farm);
                break;
            case 2:
                farm.shop.sellBuilding(gooseCoop, farm);
                break;
            case 9:
                break;
        }
        return shopMenuGooseCoopCounter;
    }

    public Integer shopMenuPigsty(Farm farm) {
        System.out.println("Chcesz sprzedać, czy kupić chlewy?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Powrót do menu budynków w sklepie.");

        Integer shopMenuPigstyCounter = 0;
        Pigsty pigsty = new Pigsty();

        shopMenuPigstyCounter = Integer.parseInt(scan.nextLine());

        switch (shopMenuPigstyCounter) {
            case 1:
                farm.shop.buyBuilding(pigsty, farm);
                break;
            case 2:
                farm.shop.sellBuilding(pigsty, farm);
                break;
            case 9:
                break;
        }
        return shopMenuPigstyCounter;
    }

    public Integer shopMenuSheepfold(Farm farm) {
        System.out.println("Chcesz sprzedać, czy kupić owczarnie?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Powrót do menu budynków w sklepie.");

        Integer shopMenuSheepfoldCounter = 0;
        Sheepfold sheepfold = new Sheepfold();

        shopMenuSheepfoldCounter = Integer.parseInt(scan.nextLine());

        switch (shopMenuSheepfoldCounter) {
            case 1:
                farm.shop.buyBuilding(sheepfold, farm);
                break;
            case 2:
                farm.shop.sellBuilding(sheepfold, farm);
                break;
            case 9:
                break;
        }
        return shopMenuSheepfoldCounter;
    }

    public Integer shopMenuTurkeyCoop(Farm farm) {
        System.out.println("Chcesz sprzedać, czy kupić kurniki dla indyków?");
        System.out.println("1. Kupić.");
        System.out.println("2. Sprzedać.");
        System.out.println("9. Powrót do menu budynków w sklepie.");

        Integer shopMenuTurkeyCoopCounter = 0;
        TurkeyCoop turkeyCoop = new TurkeyCoop();

        shopMenuTurkeyCoopCounter = Integer.parseInt(scan.nextLine());

        switch (shopMenuTurkeyCoopCounter) {
            case 1:
                farm.shop.buyBuilding(turkeyCoop, farm);
                break;
            case 2:
                farm.shop.sellBuilding(turkeyCoop, farm);
                break;
            case 9:
                break;
        }
        return shopMenuTurkeyCoopCounter;
    }

    //TODO sow i harvest
    public Integer sowMenu(Farm farm) {
        Integer sowMenuCounter = 0;
        // Integer sowCounter = 0;
        System.out.println("Co chcesz obsiać?");
        System.out.println("1. Kukurydza.");
        System.out.println("2. Ziemniak późny.");
        System.out.println("3. Rzepak ozimy.");
        System.out.println("4. Żyto ozime.");
        System.out.println("5. Jęczmień jary.");
        System.out.println("6. Burak cukrowy.");
        System.out.println("7. Pszenica ozima.");
        System.out.println("9. Powrót do menu głównego farmy.");


        sowMenuCounter = Integer.parseInt(scan.nextLine());

        switch (sowMenuCounter) {
            case 1:
                farm.addSown(farm.getCorn());
                break;
            case 2:
                farm.addSown(farm.getLatePotato());
                break;
            case 3:
                farm.addSown(farm.getLateRape());
                break;
            case 4:
                farm.addSown(farm.getLateRye());
                break;
            case 5:
                farm.addSown(farm.getSpringBarley());
                break;
            case 6:
                farm.addSown(farm.getWhiteBeet());
                break;
            case 7:
                farm.addSown(farm.getWinterWheat());
                break;
            case 9:
                System.out.println("Powrót do menu głównego farmy.");
                break;
        }
        return sowMenuCounter;
    }

}
