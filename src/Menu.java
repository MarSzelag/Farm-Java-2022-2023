import farm.Farm;

import java.util.Scanner;

public class Menu {
    Scanner scan = new Scanner(System.in);
    private Integer mainMenuCounter = 0;

    public void mainMenuShow() {
        System.out.println("Witamy na farmie. Posługując się poniższym menu wybierz, co chcesz zrobić.");
        System.out.println("1. Utwórz nową grę dla jednego gracza.");
        System.out.println("9. Zakończ i opuść grę.");
    }

    public Farm mainMenu(Farm farm) {
        Farm menuFarm = farm;

        while (mainMenuCounter != 1 && mainMenuCounter != 9) {
            try {
                mainMenuShow();
                System.out.println();
                mainMenuCounter = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wprowadzono złą wartość. Spróbuj jeszcze raz");
                mainMenuCounter = 0;
            }
        }

        switch (mainMenuCounter) {
            case 1:
                System.out.println("Wybrałeś '1' Utworzenie gry dla jednego gracza.");
                menuFarm = createFarmMenu(farm);
                setOwnerName(menuFarm);
                return menuFarm;
            case 9:
                System.out.println("Wybrałeś '9' Opuszczenie gry. Zapraszamy serdecznie, gdy tylko znowu zapragniesz zaznać uroków farmerskiego życia.");
                break;
            default:
                System.out.println("Wprowadzono niewłaściwą wartość. Spróbuj jeszcze raz.");
        }
        return menuFarm;
    }

    public Farm createFarmMenu(Farm farm) {
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

        while (farmMenuCounter != 1 && farmMenuCounter != 2 && farmMenuCounter != 3 && farmMenuCounter != 4 && farmMenuCounter != 9) {
            System.out.println();
            System.out.println("Wybierz opcję: ");
            System.out.println("1. Stan posiadania.");
            System.out.println("2. Sklep.");
            System.out.println("3. Obsiewanie.");
            System.out.println("4. Koniec tury.");
            System.out.println("9. Wyjdź z gry.");

            try {
                farmMenuCounter = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wprowadź prawidłową wartość");
            }
        }
        Integer farmCounter = 0;

        switch (farmMenuCounter) {
            case 1:
                System.out.println("Stan posiadania.");
                farm.possessions();
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


    public Integer shopMenu(Farm farm) {
        Integer shopMenuCounter = 0;
        while (shopMenuCounter != 1 && shopMenuCounter != 2 && shopMenuCounter != 3 && shopMenuCounter != 4 && shopMenuCounter != 9) {
            System.out.println("Wybierz dział: ");
            System.out.println("1. Rośliny.");
            System.out.println("2. Zwierzęta.");
            System.out.println("3. Budynki.");
            System.out.println("4. Ziemia.");
            System.out.println("9. Powrót do menu głównego farmy.");
            try {
                shopMenuCounter = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wprowadź właściwą wartość.");
                shopMenuCounter = 0;
            }
        }
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
        Integer shopMenuPlantsCounter = 0;
        Integer plantsCounter = 0;
        while (shopMenuPlantsCounter != 1 && shopMenuPlantsCounter != 2 && shopMenuPlantsCounter != 3 && shopMenuPlantsCounter != 4 && shopMenuPlantsCounter != 5 && shopMenuPlantsCounter != 6 && shopMenuPlantsCounter != 7 && shopMenuPlantsCounter != 9) {
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

            try {
                shopMenuPlantsCounter = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wprowadź prawidłową wartość.");
                shopMenuPlantsCounter = 0;
            }
        }

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
        Integer shopMenuAnimalsCounter = 0;
        Integer animalCounter = 0;
        while (shopMenuAnimalsCounter != 1 && shopMenuAnimalsCounter != 2 && shopMenuAnimalsCounter != 3 && shopMenuAnimalsCounter != 4 && shopMenuAnimalsCounter != 5 && shopMenuAnimalsCounter != 6 && shopMenuAnimalsCounter != 7 && shopMenuAnimalsCounter != 9) {
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

            try {
                shopMenuAnimalsCounter = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wprowadź prawidłową wartość.");
                shopMenuAnimalsCounter = 0;
            }
        }

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
        Integer shopMenuBuildingsCounter = 0;
        Integer buildingCounter = 0;
        while (shopMenuBuildingsCounter != 1 && shopMenuBuildingsCounter != 2 && shopMenuBuildingsCounter != 3 && shopMenuBuildingsCounter != 4 && shopMenuBuildingsCounter != 5 && shopMenuBuildingsCounter != 6 && shopMenuBuildingsCounter != 7 && shopMenuBuildingsCounter != 8 && shopMenuBuildingsCounter != 9) {
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

            try {
                shopMenuBuildingsCounter = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wprowadź prawidłową wartość.");
                shopMenuBuildingsCounter = 0;
            }
        }

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
        Integer shopMenuLandCounter = 0;
        while (shopMenuLandCounter != 1 && shopMenuLandCounter != 2 && shopMenuLandCounter !=9) {
            System.out.println("Sklep. Dział handlu ziemią.");
            System.out.println("Wybierz, czy chcesz kupić, czy sprzedać ziemię: ");
            System.out.println("1. Kupno ziemi.");
            System.out.println("2. Sprzedaż ziemi.");
            System.out.println("9. Wyjście do menu głównego.");

            try {
                shopMenuLandCounter = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wprowadź prawidłową wartość.");
                shopMenuLandCounter = 0;
            }
        }

        switch (shopMenuLandCounter) {
            case 1:
                farm.shop.buyLand(farm);
                break;
            case 2:
                farm.shop.sellLand(farm);
                break;
            case 9:
                System.out.println("Powrót do menu głównego sklepu.");
                break;
        }
        return shopMenuLandCounter;
    }

    public Integer shopMenuCorn(Farm farm) {
        Integer shopMenuCornCounter = 0;
        while (shopMenuCornCounter != 1 && shopMenuCornCounter != 2 && shopMenuCornCounter != 9) {
            System.out.println("Chcesz sprzedać, czy kupić kukurydzę?");
            System.out.println("1. Kupić.");
            System.out.println("2. Sprzedać.");
            System.out.println("9. Powrót do menu roślin w sklepie.");

            try {
                shopMenuCornCounter = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wprowadź prawidłową wartość.");
                shopMenuCornCounter = 0;
            }
        }

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
        Integer shopMenuLatePotatoCounter = 0;
        while (shopMenuLatePotatoCounter != 1 && shopMenuLatePotatoCounter != 2 && shopMenuLatePotatoCounter != 9) {
            System.out.println("Chcesz sprzedać, czy kupić późne ziemniaki?");
            System.out.println("1. Kupić.");
            System.out.println("2. Sprzedać.");
            System.out.println("9. Powrót do menu roślin w sklepie.");

            try {
                shopMenuLatePotatoCounter = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wprowadź prawidłową wartość.");
                shopMenuLatePotatoCounter = 0;
            }
        }

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
        Integer shopMenuLateRapeCounter = 0;
        while (shopMenuLateRapeCounter != 1 && shopMenuLateRapeCounter != 2 && shopMenuLateRapeCounter != 9) {
            System.out.println("Chcesz sprzedać, czy kupić rzepak ozimy?");
            System.out.println("1. Kupić.");
            System.out.println("2. Sprzedać.");
            System.out.println("9. Powrót do menu roślin w sklepie.");

            try {
                shopMenuLateRapeCounter = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wprowadź prawidłową wartość.");
                shopMenuLateRapeCounter = 0;
            }
        }

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
        Integer shopMenuLateRyeCounter = 0;
        while (shopMenuLateRyeCounter != 1 && shopMenuLateRyeCounter != 2 && shopMenuLateRyeCounter != 9) {
            System.out.println("Chcesz sprzedać, czy kupić żyto ozime?");
            System.out.println("1. Kupić.");
            System.out.println("2. Sprzedać.");
            System.out.println("9. Powrót do menu roślin w sklepie.");

            try {
                shopMenuLateRyeCounter = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wprowadź prawidłową wartość.");
                shopMenuLateRyeCounter = 0;
            }
        }

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
        Integer shopMenuSpringBarleyCounter = 0;
        while (shopMenuSpringBarleyCounter != 1 && shopMenuSpringBarleyCounter != 2 && shopMenuSpringBarleyCounter != 9) {
            System.out.println("Chcesz sprzedać, czy kupić jęczmień jary?");
            System.out.println("1. Kupić.");
            System.out.println("2. Sprzedać.");
            System.out.println("9. Powrót do menu roślin w sklepie.");


            try {
                shopMenuSpringBarleyCounter = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wprowadź prawidłową wartość.");
                shopMenuSpringBarleyCounter = 0;
            }
        }

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
        Integer shopMenuWhiteBeetCounter = 0;
        while (shopMenuWhiteBeetCounter != 1 && shopMenuWhiteBeetCounter != 2 && shopMenuWhiteBeetCounter != 9) {
            System.out.println("Chcesz sprzedać, czy kupić buraki cukrowe?");
            System.out.println("1. Kupić.");
            System.out.println("2. Sprzedać.");
            System.out.println("9. Powrót do menu roślin w sklepie.");

            try {
                shopMenuWhiteBeetCounter = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wprowadź prawidłową wartość.");
                shopMenuWhiteBeetCounter = 0;
            }
        }

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
        Integer shopMenuWinterWheatCounter = 0;
        while (shopMenuWinterWheatCounter != 1 && shopMenuWinterWheatCounter != 2 && shopMenuWinterWheatCounter != 9) {
            System.out.println("Chcesz sprzedać, czy kupić pszenicę ozimą?");
            System.out.println("1. Kupić.");
            System.out.println("2. Sprzedać.");
            System.out.println("9. Powrót do menu roślin w sklepie.");

            try {
                shopMenuWinterWheatCounter = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wprowadź prawidłową wartość.");
                shopMenuWinterWheatCounter = 0;
            }
        }

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
        Integer shopMenuChickenCounter = 0;
        while (shopMenuChickenCounter != 1 && shopMenuChickenCounter != 2 && shopMenuChickenCounter != 9) {
            System.out.println("Chcesz sprzedać, czy kupić kury?");
            System.out.println("1. Kupić.");
            System.out.println("2. Sprzedać.");
            System.out.println("9. Powrót do menu zwierząt w sklepie.");

            try {
                shopMenuChickenCounter = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wprowadź prawidłową wartość.");
                shopMenuChickenCounter = 0;
            }
        }

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
        Integer shopMenuCowCounter = 0;
        while (shopMenuCowCounter != 1 && shopMenuCowCounter != 2 && shopMenuCowCounter != 9) {
            System.out.println("Chcesz sprzedać, czy kupić krowy?");
            System.out.println("1. Kupić.");
            System.out.println("2. Sprzedać.");
            System.out.println("9. Powrót do menu zwierząt w sklepie.");

            try {
                shopMenuCowCounter = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wprowadź prawidłową wartość.");
                shopMenuCowCounter = 0;
            }
        }

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
        Integer shopMenuGoatCounter = 0;
        while (shopMenuGoatCounter != 1 && shopMenuGoatCounter != 2 && shopMenuGoatCounter != 9) {
            System.out.println("Chcesz sprzedać, czy kupić ");
            System.out.println("1. Kupić.");
            System.out.println("2. Sprzedać.");
            System.out.println("9. Powrót do menu zwierząt w sklepie.");

            try {
                shopMenuGoatCounter = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wprowadź prawidłową wartość.");
                shopMenuGoatCounter = 0;
            }
        }

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
        Integer shopMenuGooseCounter = 0;
        while (shopMenuGooseCounter != 1 && shopMenuGooseCounter != 2 && shopMenuGooseCounter != 9) {
            System.out.println("Chcesz sprzedać, czy kupić kozy?");
            System.out.println("1. Kupić.");
            System.out.println("2. Sprzedać.");
            System.out.println("9. Powrót do menu zwierząt w sklepie.");

            try {
                shopMenuGooseCounter = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wprowadź prawidłową wartość.");
                shopMenuGooseCounter = 0;
            }
        }

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
        Integer shopMenuPigCounter = 0;
        while (shopMenuPigCounter != 1 && shopMenuPigCounter != 2 && shopMenuPigCounter != 9) {
            System.out.println("Chcesz sprzedać, czy kupić świnie?");
            System.out.println("1. Kupić.");
            System.out.println("2. Sprzedać.");
            System.out.println("9. Powrót do menu zwierząt w sklepie.");

            try {
                shopMenuPigCounter = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wprowadź prawidłową wartość.");
                shopMenuPigCounter = 0;
            }
        }

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
        Integer shopMenuSheepCounter = 0;
        while (shopMenuSheepCounter != 1 && shopMenuSheepCounter != 2 && shopMenuSheepCounter != 9) {
            System.out.println("Chcesz sprzedać, czy kupić owce?");
            System.out.println("1. Kupić.");
            System.out.println("2. Sprzedać.");
            System.out.println("9. Powrót do menu zwierząt w sklepie.");

            try {
                shopMenuSheepCounter = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wprowadź prawidłową wartość.");
                shopMenuSheepCounter = 0;
            }
        }

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
        Integer shopMenuTurkeyCounter = 0;
        while (shopMenuTurkeyCounter != 1 && shopMenuTurkeyCounter != 2 && shopMenuTurkeyCounter != 9) {
            System.out.println("Chcesz sprzedać, czy kupić indyki?");
            System.out.println("1. Kupić.");
            System.out.println("2. Sprzedać.");
            System.out.println("9. Powrót do menu zwierząt w sklepie.");

            try {
                shopMenuTurkeyCounter = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wprowadź prawidłową wartość.");
                shopMenuTurkeyCounter = 0;
            }
        }

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

    public Integer shopMenuBarn(Farm farm) {
        Integer shopMenuBarnCounter = 0;
        while (shopMenuBarnCounter != 1 && shopMenuBarnCounter != 2 && shopMenuBarnCounter != 9) {
            System.out.println("Chcesz sprzedać, czy kupić stodoły?");
            System.out.println("1. Kupić.");
            System.out.println("2. Sprzedać.");
            System.out.println("9. Powrót do menu budynków w sklepie.");


            try {
                shopMenuBarnCounter = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wprowadź prawidłową wartość.");
                shopMenuBarnCounter = 0;
            }
        }

        switch (shopMenuBarnCounter) {
            case 1:
                farm.shop.buyBuilding(farm.getBarn(), farm);
                break;
            case 2:
                farm.shop.sellBuilding(farm.getBarn(), farm);
                break;
            case 9:
                break;
        }
        return shopMenuBarnCounter;
    }

    public Integer shopMenuChickenCoop(Farm farm) {
        Integer shopMenuChickenCoopCounter = 0;
        while (shopMenuChickenCoopCounter != 1 && shopMenuChickenCoopCounter != 2 && shopMenuChickenCoopCounter != 9) {
            System.out.println("Chcesz sprzedać, czy kupić kurniki?");
            System.out.println("1. Kupić.");
            System.out.println("2. Sprzedać.");
            System.out.println("9. Powrót do menu budynków w sklepie.");

            try {
                shopMenuChickenCoopCounter = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wprowadź prawidłową wartość.");
                shopMenuChickenCoopCounter = 0;
            }
        }

        switch (shopMenuChickenCoopCounter) {
            case 1:
                farm.shop.buyBuilding(farm.getChickenCoop(), farm);
                break;
            case 2:
                farm.shop.sellBuilding(farm.getChickenCoop(), farm);
                break;
            case 9:
                break;
        }
        return shopMenuChickenCoopCounter;
    }

    public Integer shopMenuCowShed(Farm farm) {
        Integer shopMenuCowShedCounter = 0;
        while (shopMenuCowShedCounter != 1 && shopMenuCowShedCounter != 2 && shopMenuCowShedCounter != 9) {
            System.out.println("Chcesz sprzedać, czy kupić obory?");
            System.out.println("1. Kupić.");
            System.out.println("2. Sprzedać.");
            System.out.println("9. Powrót do menu budynków w sklepie.");

            try {
                shopMenuCowShedCounter = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wprowadź prawidłową wartość.");
                shopMenuCowShedCounter = 0;
            }
        }

        switch (shopMenuCowShedCounter) {
            case 1:
                farm.shop.buyBuilding(farm.getCowShed(), farm);
                break;
            case 2:
                farm.shop.sellBuilding(farm.getCowShed(), farm);
                break;
            case 9:
                break;
        }
        return shopMenuCowShedCounter;
    }

    public Integer shopMenuGoatBarn(Farm farm) {
        Integer shopMenuGoatBarnCounter = 0;
        while (shopMenuGoatBarnCounter != 1 && shopMenuGoatBarnCounter != 2 && shopMenuGoatBarnCounter != 9) {
            System.out.println("Chcesz sprzedać, czy kupić stodoły dla kóz?");
            System.out.println("1. Kupić.");
            System.out.println("2. Sprzedać.");
            System.out.println("9. Powrót do menu budynków w sklepie.");

            try {
                shopMenuGoatBarnCounter = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wprowadź prawidłową wartość.");
                shopMenuGoatBarnCounter = 0;
            }
        }

        switch (shopMenuGoatBarnCounter) {
            case 1:
                farm.shop.buyBuilding(farm.getGoatBarn(), farm);
                break;
            case 2:
                farm.shop.sellBuilding(farm.getGoatBarn(), farm);
                break;
            case 9:
                break;
        }
        return shopMenuGoatBarnCounter;
    }

    public Integer shopMenuGooseCoop(Farm farm) {
        Integer shopMenuGooseCoopCounter = 0;
        while (shopMenuGooseCoopCounter != 1 && shopMenuGooseCoopCounter != 2 && shopMenuGooseCoopCounter != 9) {
            System.out.println("Chcesz sprzedać, czy kupić kurniki dla gęsi?");
            System.out.println("1. Kupić.");
            System.out.println("2. Sprzedać.");
            System.out.println("9. Powrót do menu budynków w sklepie.");

            try {
                shopMenuGooseCoopCounter = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wprowadź prawidłową wartość.");
                shopMenuGooseCoopCounter = 0;
            }
        }

        switch (shopMenuGooseCoopCounter) {
            case 1:
                farm.shop.buyBuilding(farm.getGooseCoop(), farm);
                break;
            case 2:
                farm.shop.sellBuilding(farm.getGooseCoop(), farm);
                break;
            case 9:
                break;
        }
        return shopMenuGooseCoopCounter;
    }

    public Integer shopMenuPigsty(Farm farm) {
        Integer shopMenuPigstyCounter = 0;
        while (shopMenuPigstyCounter != 1 && shopMenuPigstyCounter != 2 && shopMenuPigstyCounter != 9) {
            System.out.println("Chcesz sprzedać, czy kupić chlewy?");
            System.out.println("1. Kupić.");
            System.out.println("2. Sprzedać.");
            System.out.println("9. Powrót do menu budynków w sklepie.");

            try {
                shopMenuPigstyCounter = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wprowadź prawidłową wartość.");
                shopMenuPigstyCounter = 0;
            }
        }

        switch (shopMenuPigstyCounter) {
            case 1:
                farm.shop.buyBuilding(farm.getPigsty(), farm);
                break;
            case 2:
                farm.shop.sellBuilding(farm.getPigsty(), farm);
                break;
            case 9:
                break;
        }
        return shopMenuPigstyCounter;
    }

    public Integer shopMenuSheepfold(Farm farm) {
        Integer shopMenuSheepfoldCounter = 0;
        while (shopMenuSheepfoldCounter != 1 && shopMenuSheepfoldCounter != 2 && shopMenuSheepfoldCounter != 9) {
            System.out.println("Chcesz sprzedać, czy kupić owczarnie?");
            System.out.println("1. Kupić.");
            System.out.println("2. Sprzedać.");
            System.out.println("9. Powrót do menu budynków w sklepie.");

            try {
                shopMenuSheepfoldCounter = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wprowadź prawidłową wartość.");
                shopMenuSheepfoldCounter = 0;
            }
        }

        switch (shopMenuSheepfoldCounter) {
            case 1:
                farm.shop.buyBuilding(farm.getSheepfold(), farm);
                break;
            case 2:
                farm.shop.sellBuilding(farm.getSheepfold(), farm);
                break;
            case 9:
                break;
        }
        return shopMenuSheepfoldCounter;
    }

    public Integer shopMenuTurkeyCoop(Farm farm) {
        Integer shopMenuTurkeyCoopCounter = 0;
        while (shopMenuTurkeyCoopCounter != 1 && shopMenuTurkeyCoopCounter != 2 && shopMenuTurkeyCoopCounter != 9) {
            System.out.println("Chcesz sprzedać, czy kupić kurniki dla indyków?");
            System.out.println("1. Kupić.");
            System.out.println("2. Sprzedać.");
            System.out.println("9. Powrót do menu budynków w sklepie.");

            try {
                shopMenuTurkeyCoopCounter = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wprowadź prawidłową wartość.");
                shopMenuTurkeyCoopCounter = 0;
            }
        }

        switch (shopMenuTurkeyCoopCounter) {
            case 1:
                farm.shop.buyBuilding(farm.getTurkeyCoop(), farm);
                break;
            case 2:
                farm.shop.sellBuilding(farm.getTurkeyCoop(), farm);
                break;
            case 9:
                break;
        }
        return shopMenuTurkeyCoopCounter;
    }

    public Integer sowMenu(Farm farm) {
        Integer sowMenuCounter = 0;
        while (sowMenuCounter != 1 && sowMenuCounter != 2 && sowMenuCounter != 3 && sowMenuCounter != 4 && sowMenuCounter != 5 && sowMenuCounter != 6 && sowMenuCounter != 7 && sowMenuCounter != 9) {
            System.out.println("Co chcesz obsiać?");
            System.out.println("1. Kukurydza.");
            System.out.println("2. Ziemniak późny.");
            System.out.println("3. Rzepak ozimy.");
            System.out.println("4. Żyto ozime.");
            System.out.println("5. Jęczmień jary.");
            System.out.println("6. Burak cukrowy.");
            System.out.println("7. Pszenica ozima.");
            System.out.println("9. Powrót do menu głównego farmy.");

            try {
                sowMenuCounter = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wprowadź prawidłową wartość.");
                sowMenuCounter = 0;
            }
        }

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
                System.out.println("XXXXXXXXXXX");
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
