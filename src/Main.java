
import farm.Farm;

public class Main {
    public static void main(String[] args) {
        Farm farm = new Farm();
        Menu menu = new Menu();
        Integer farmMenuCounter = 0;

        farm = menu.mainMenu(farm);

        while (farmMenuCounter != 9) {
            farmMenuCounter = 0;
            farm.startOfTheTurn();
            while(farmMenuCounter != 9 && farmMenuCounter != 4) {
                farmMenuCounter = menu.farmMenu(farm);
            }
            farm.nextTurn();
        }

        System.out.println("Gra została pomyślnie zakończona.");
    }
}