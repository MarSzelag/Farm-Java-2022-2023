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

        farm = menu.mainMenu(farm);

        while(menu.getMainMenuCounter() != 9){
            menu.farmMenu(farm);
        }


    }
}