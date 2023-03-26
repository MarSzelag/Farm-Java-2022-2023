package shop;

import animals.Animal;
import farm.Farm;
import plants.Plant;
import buildings.Building;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Shop {
    Scanner scan = new Scanner(System.in);

    public Shop(Farm farm) {
    }

    //TODO*****************************Plants
    public void plantPossession(Plant plant, Farm farm) {
        System.out.println("Posiadasz: " + plant.getStoredInKg() + " kg " + plant.getPlantName() + " oraz " + farm.getCash() + "zł w gotówce.");
    }

    public void landPossession(Farm farm) {
        System.out.println("Posiadasz: " + farm.getLand().getLandSizeInHa() + " ha ziemi oraz " + farm.getCash() + "zł w gotówce.");
    }

    public void buildingPossesion(Building building, Farm farm){
        System.out.println("Posiadasz " + building.getQuantityOfThisBuildingType() + " " + building.getName());
    }

    public void animalPossesion(List<Animal> animalList, Farm farm){
        System.out.println("Posiadasz " + animalList.size() + " " + animalList.get(0).getRace());
    }

    public void buyPlant(Plant plant, Farm farm) {
        Integer quantity;
        boolean flag = false;
        while (!flag) {
            plantPossession(plant, farm);
            System.out.println("Cena kupna kukurydzy wynosi " + plant.getBuyPricePerKg() + "zł za kilogram.");
            System.out.printf("Masz gotówkę na zakup maksymalnie %.0f kg %s%n kg", (farm.getCash() / plant.getBuyPricePerKg()), plant.getPlantName());
            System.out.println("Ile kg chcesz kupić? Jeśli nie chcesz dokonać zakupu, wciśnij 0.");

            try {
                quantity = scan.nextInt();
                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
                } else if (quantity < 0) {
                    System.out.println("Nie można kupić ujemnej ilości " + plant.getPlantName());
                } else if (farm.getCash() < (quantity * plant.getBuyPricePerKg())) {
                    System.out.println("Nie masz wystarczającej ilości pieniędzy, żeby kupić " + plant.getPlantName() + " w ilości " + quantity + "kg.");
                } else {
                    plant.setStoredInKg(plant.getStoredInKg() + quantity);
                    farm.setCash(farm.getCash() - (quantity * plant.getBuyPricePerKg()));
                    System.out.println("Dokonałeś zakupu " + quantity + "kg " + plant.getPlantName() + " za kwotę " + (quantity * plant.getBuyPricePerKg()) + "zł.");
                    plantPossession(plant, farm);
                    flag = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Ilość podajemy w pełnych kilogramach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }
            scan.nextLine();
        }
    }

    public void sellPlant(plants.Plant plant, Farm farm) {
        Integer quantity;
        boolean flag = false;
        while (!flag) {
            plantPossession(plant, farm);
            System.out.println("Cena sprzedaży kukurydzy wynosi " + plant.getSellPricePerKg() + "zł za kilogram.");
            System.out.println("Posiadasz obecnie " + plant.getStoredInKg() + "kg kukurydzy.");
            System.out.println("Ile kg chcesz sprzedać? Jeśli nie chcesz dokonać sprzedaży, wciśnij 0.");

            try {
                quantity = scan.nextInt();
                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
                } else if (quantity > plant.getStoredInKg()) {
                    System.out.println("Nie możesz sprzedać więcej niż posiadasz. Wprowadź odpowiednią ilość.");

                } else if (quantity < 0) {
                    System.out.println("Wprowadziłeś ilość mniejszą niż zero. Wprowadź odpowiednią ilość.");
                } else {
                    plant.setStoredInKg(plant.getStoredInKg() - quantity);
                    farm.setCash(farm.getCash() + (quantity * plant.getBuyPricePerKg()));
                    System.out.println("Sprzedałeś " + quantity + "kg " + plant.getPlantName() + " za kwotę " + (quantity * plant.getBuyPricePerKg()) + "zł.");
                    plantPossession(plant, farm);
                    flag = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Ilość podajemy w pełnych kilogramach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }
            scan.nextLine();
        }
    }

    public void buyLand(Farm farm) {
        Integer quantity;
        boolean flag = false;
        while (!flag) {
            landPossession(farm);
            System.out.println("Cena kupna ziemi wynosi " + farm.getLand().getBuyPriceOfLandPerHa() + "zł za hektar.");
            System.out.println("Masz gotówkę na zakup maksymanie " + (Math.floor(farm.getCash() / farm.getLand().getBuyPriceOfLandPerHa())));
            System.out.println("Ile ha chcesz kupić? Jeśli nie chcesz dokonać zakupu, wciśnij 0.");

            try {
                quantity = scan.nextInt();
                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
                } else if (quantity < 0) {
                    System.out.println("Nie można kupić ujemnej ilości ziemi.");
                } else if (farm.getCash() < (quantity * farm.getLand().getBuyPriceOfLandPerHa())) {
                    System.out.println("Nie masz wystarczającej ilości pieniędzy, żeby kupić ziemię w ilości " + quantity + "ha.");
                } else {
                    farm.getLand().setLandSizeInHa(farm.getLand().getLandSizeInHa() + quantity);
                    farm.setCash(farm.getCash() - (quantity * farm.getLand().getBuyPriceOfLandPerHa()));
                    System.out.println("Dokonałeś zakupu " + quantity + "ha ziemi za kwotę " + (quantity * farm.getLand().getBuyPriceOfLandPerHa() + "zł."));
                    landPossession(farm);
                    flag = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Ilość podajemy w pełnych hektarach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }
            scan.nextLine();
        }
    }

    public void sellLand(Farm farm) {
        Integer quantity;
        boolean flag = false;
        while (!flag) {
            landPossession(farm);
            System.out.println("Cena sprzedaży ziemi wynosi " + farm.getLand().getSellPriceOfLandPerHa() + "zł za hektar.");
            System.out.println("Możesz sprzedać tylko nieobsianą ziemię, czyli " + farm.getLand().getFreeLand());
            System.out.println("Ile ha chcesz sprzedać? Jeśli nie chcesz dokonać zakupu, wciśnij 0.");

            try {
                quantity = scan.nextInt();
                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
                } else if (quantity < 0) {
                    System.out.println("Nie można sprzedać ujemnej ilości ziemi.");
                } else if (quantity > farm.getLand().getFreeLand()) {
                    System.out.println("Nie możesz sprzedać więcej ziemi niż masz obecnie ziemi nieobsianej.");
                } else {
                    farm.getLand().setLandSizeInHa(farm.getLand().getLandSizeInHa() - quantity);
                    farm.setCash(farm.getCash() + (quantity * farm.getLand().getBuyPriceOfLandPerHa()));
                    System.out.println("Dokonałeś sprzedaży " + quantity + "ha ziemi za kwotę " + (quantity * farm.getLand().getBuyPriceOfLandPerHa() + "zł."));
                    landPossession(farm);
                    flag = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Ilość podajemy w pełnych hektarach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }
            scan.nextLine();
        }
    }
    //TODO****************************Buildings
    public void buyBuilding(Building building, Farm farm){

        String buildingName = "get" + building.getName();
        Integer quantity;
        boolean flag = false;
        while (!flag) {
            buildingPossesion(building, farm);
            System.out.println("Cena kupna 1 " + building.getName() + " wynosi " + building.getPrice() + " zł");
            System.out.println("Masz gotówkę na zakup maksymanie " + (Math.floor(farm.getCash() / building.getPrice())));
            System.out.println("Ile budynków chcesz kupić? Jeśli nie chcesz dokonać zakupu, wciśnij 0.");

            try {
                quantity = scan.nextInt();
                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
                } else if (quantity < 0) {
                    System.out.println("Nie można kupić ujemnej ilości budynków.");
                } else if (farm.getCash() < (quantity * building.getPrice())) {
                    System.out.println("Nie masz wystarczającej ilości pieniędzy, żeby kupić " + building.getName() + " w ilości " + quantity + "szt.");
                } else if(quantity > ((building.getQuantityOfThisBuildingType() * building.getCapacityOfOneBuilding()) - farm.allPlantsKg()) / building.getCapacityOfOneBuilding()){
                    System.out.println("Nie możesz sprzedać tylu budynk"); //TODO to jest do sprzedaży, a nie zakupów <-- przenieść
                } else {
                    building.setQuantityOfThisBuildingType(building.getQuantityOfThisBuildingType() + quantity);
                    farm.setCash(farm.getCash() - (quantity * building.getPrice()));
                    System.out.println("Dokonałeś zakupu " + quantity + " " + building.getName() + " za kwotę " + (quantity * building.getPrice()) + "zł.");
                    buildingPossesion(building, farm);
                    flag = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Ilość podajemy w sztukach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }
            scan.nextLine();
        }
    }

    public void sellBuilding(Farm farm){

    }
    //TODO****************************Animals
    public void buyAnimal(Farm farm){

    }
    public void sellAnimal(Farm farm){

    }





}
