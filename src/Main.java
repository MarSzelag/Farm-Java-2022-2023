import farm.Farm;
import plants.Corn;

import java.util.Calendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner scan = new Scanner(System.in);

            Farm farm = new Farm();
            farm.generateFarm();
            System.out.println(farm.getCorn().getStoredInKg()); // Test losowania ilości roślin
             System.out.println(Corn.class.getName());

            farm.shop.buyPlant(farm.getCorn(), farm);



        //Random rand = new Random();

/*
        while(menu.getMainMenuCounter() != 9){

        }*/


    }
}