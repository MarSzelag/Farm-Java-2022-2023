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
        Byte farmMenuCounter = 0;

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

    public void possesionsMenu() {
        Byte possesionMenuCounter = 0;

        System.out.println("Stan posiadania w farmie: ");
        System.out.println("7. Powrót do menu głównego farmy.");

        switch (possesionMenuCounter) {
            case 5:
                break;
            default:
                System.out.println("Wprowadzonow niewłaściwą wartość. Spróbuj jeszcze raz.");
        }

    }

    public void shopMenu() {
        Byte shopMenuCounter = 0;

        System.out.println("Wybierz dział: ");
        System.out.println("1. Ziemia.");
        System.out.println("2. Budynki.");
        System.out.println("3. Rośliny.");
        System.out.println("4. Zwierzęta.");
        System.out.println("7. Powrót do menu głównego farmy.");

        switch (shopMenuCounter) {
            case 1:
                System.out.println("Ziemia.");
                break;
            case 2:
                System.out.println("Budynki.");
                break;
            case 3:
                System.out.println("Rośliny.");
                break;
            case 4:
                System.out.println("Zwierzęta.");
                break;
            case 7:
                System.out.println("Powrót do menu głównego farmy.");
                break;
            default:
                System.out.println("Wprowadzonow niewłaściwą wartość. Spróbuj jeszcze raz.");
        }

    }

    public void sowAndHarvestMenu() {
        Byte sowAndHarvestMenuCounter = 0;

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
        Byte sowMenuCounter = 0;

    }

    public void harvestMenu() {
        Byte harvestMenuCounter = 0;

    }
}
