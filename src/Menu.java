import farm.Farm;

import java.util.Scanner;

public class Menu {

    private Integer mainMenuCounter = 0;

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
        System.out.println();
    }

    public void mainMenu() {
        System.out.println();

        switch (mainMenuCounter) {
            case 1:
                System.out.println("Wybrałeś '1' Utworzenie gry dla jednego gracza.");
                createFarmMenu();
                break;
            case 2:
                System.out.println("Wybrałeś '2' Utworzenie gry dla wielu graczy.");
                break;
            case 9:
                System.out.println("Wybrałeś '9' Opuszczenie gry. Zapraszamy serdecznie, gdy tylko znowu zapragniesz zaznać uroków farmerskiego życia.");
                break;
            default:
                System.out.println("Wprowadzono niewłaściwą wartość. Spróbuj jeszcze raz.");
        }
    }

    public void createFarmMenu(){
        //Scanner scan = new Scanner(System.in);
        System.out.println("Rozpoczynasz nową przygodę na swojej farmie.");
        System.out.println("Najpierw jednak musimy cię poznać.");
        System.out.println("W tym celu podaj nam informację, jak mamy się do ciebie zwracać: ");

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

        switch (farmMenuCounter) {
            case 1:
                System.out.println("Stan posiadania.");
                break;
            case 2:
                System.out.println("Sklep.");
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

    public void possesionsMenu(Farm farm) { //TODO Farm farm???
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

    public void shopMenu() {
        System.out.println("Wybierz dział: ");
        System.out.println("1. Rośliny.");
        System.out.println("2. Zwierzęta.");
        System.out.println("3. Budynki.");
        System.out.println("4. Ziemia.");
        System.out.println("9. Powrót do menu głównego farmy.");

        Integer shopMenuCounter = 0;

        switch (shopMenuCounter) {
            case 1:
                shopMenuPlants();
                break;
            case 2:
                shopMenuAnimals();
                break;
            case 3:
                shopMenuBuildings();
                break;
            case 4:
                shopMenuLand();
                break;
            case 9:
                System.out.println("Powrót do menu głównego farmy.");
                break;
            default:
                System.out.println("Wprowadzonow niewłaściwą wartość. Spróbuj jeszcze raz.");
        }

    }

    public void shopMenuPlants(){
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

    }
    public void shopMenuAnimals(){
        System.out.println("Sklep. Dział handlu zwierzętami.");
        System.out.println("Wybierz, czym chcesz handlować: ");

    }
    public void shopMenuBuildings(){
        System.out.println("Sklep. Dział handlu budynkami.");
        System.out.println("Wybierz, czym chcesz handlować: ");

    }
    public void shopMenuLand(){
        System.out.println("Sklep. Dział handlu ziemią.");
        System.out.println("Wybierz, czym chcesz handlować: ");

    }


    public void sowAndHarvestMenu() {
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

    public void sowMenu() {
        Integer sowMenuCounter = 0;

    }

    public void harvestMenu() {
        Integer harvestMenuCounter = 0;

    }
}
