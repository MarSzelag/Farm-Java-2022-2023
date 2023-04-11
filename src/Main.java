import animals.Animal;
import farm.Farm;
import plants.Corn;


import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Farm farm = new Farm();
        Menu menu = new Menu();
        Scanner scan = new Scanner(System.in);
        Integer farmMenuCounter = 0;

        farm = menu.mainMenu(farm);

        while (farmMenuCounter != 9) {
            farm.startOfTheTurn();
            farmMenuCounter = menu.farmMenu(farm);
            farm.nextTurn();
        }


    }
}