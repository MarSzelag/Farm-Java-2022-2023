import animals.Animal;
import farm.Farm;
import plants.Corn;


import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner scan = new Scanner(System.in);

            Farm farm = new Farm();
            farm.generateFarm();

        //Random rand = new Random();


        while(menu.getMainMenuCounter() != 9){
            menu.mainMenu();
        }


    }
}