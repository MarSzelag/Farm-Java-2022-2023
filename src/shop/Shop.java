package shop;

import animals.*;
import farm.Farm;
import plants.*;
import buildings.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Shop {
    Scanner scan = new Scanner(System.in);

    public Shop(Farm farm) {
    }


    public void plantPossession(Plant plant, Farm farm) {
        System.out.println("Posiadasz: " + plant.getStoredInKg() + " kg " + plant.getPlantName() + " oraz " + farm.getCash() + "zł w gotówce.");
    }

    public void landPossession(Farm farm) {
        System.out.println("Posiadasz: " + farm.getLand().getLandSizeInHa() + " ha ziemi oraz " + farm.getCash() + "zł w gotówce.");
    }

    public void buildingPossesion(Building building, Farm farm) {
        System.out.println("Posiadasz " + building.getQuantityOfThisBuildingType() + " " + building.getName());
    }


    public void animalPossesionChicken(Farm farm) {
        if (!farm.getChickenList().isEmpty()) {
            System.out.println("Posiadasz " + farm.getChickenList().get(0).howManyChickenInList(farm.getChickenList()) + " kur.");
        } else System.out.println("Posiadasz 0 kur.");
    }

    public void animalPossesionCow(Farm farm) {
        if (!farm.getCowList().isEmpty()) {
            System.out.println("Posiadasz " + farm.getCowList().get(0).howManyCowInList(farm.getCowList()) + " krów.");
        } else System.out.println("Posiadasz 0 krów.");
    }

    public void animalPossesionGoat(Farm farm) {
        if (!farm.getGoatList().isEmpty()) {
            System.out.println("Posiadasz " + farm.getGoatList().get(0).howManyGoatInList(farm.getGoatList()) + " kóz.");
        } else System.out.println("Posiadasz 0 kóz.");
    }

    public void animalPossesionGoose(Farm farm) {
        if (!farm.getGooseList().isEmpty()) {
            System.out.println("Posiadasz " + farm.getGooseList().get(0).howManyGooseInList(farm.getGooseList()) + " gęsi.");
        } else System.out.println("Posiadasz 0 gęsi.");
    }

    public void animalPossesionPig(Farm farm) {
        if (!farm.getPigList().isEmpty()) {
            System.out.println("Posiadasz " + farm.getPigList().get(0).howManyPigInList(farm.getPigList()) + " świń.");
        } else System.out.println("Posiadasz 0 świń.");
    }

    public void animalPossesionSheep(Farm farm) {
        if (!farm.getSheepList().isEmpty()) {
            System.out.println("Posiadasz " + farm.getSheepList().get(0).howManySheepInList(farm.getSheepList()) + " owiec.");
        } else System.out.println("Posiadasz 0 owiec.");
    }

    public void animalPossesionTurkey(Farm farm) {
        if (!farm.getTurkeyList().isEmpty()) {
            System.out.println("Posiadasz " + farm.getTurkeyList().get(0).howManyTurkeyInList(farm.getTurkeyList()) + " indyków.");
        } else System.out.println("Posiadasz 0 indyków.");
    }

    public void buyPlant(Plant plant, Farm farm) {
        Integer quantity;
        boolean flag = false;
        while (!flag) {
            plantPossession(plant, farm);
            System.out.println("Cena kupna kukurydzy wynosi " + plant.getBuyPricePerKg() + "zł za kilogram.");
            System.out.printf("Masz gotówkę na zakup maksymalnie %.0f kg %s.%n", (farm.getCash() / plant.getBuyPricePerKg()), plant.getPlantName());
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
                    farm.getLand().setFreeLand(farm.getLand().getFreeLand() + quantity);
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
            System.out.println("Możesz sprzedać tylko nieobsianą ziemię, czyli " + farm.getLand().getFreeLand() + "ha.");
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
                    farm.getLand().setFreeLand(farm.getLand().getFreeLand() - quantity);
                    farm.setCash(farm.getCash() + (quantity * farm.getLand().getBuyPriceOfLandPerHa()));
                    System.out.println("Dokonałeś sprzedaży " + quantity + "ha ziemi za kwotę " + (quantity * farm.getLand().getBuyPriceOfLandPerHa()) + "zł.");
                    landPossession(farm);
                    flag = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Ilość podajemy w pełnych hektarach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }
            scan.nextLine();
        }
    }

    public void buyBuilding(Building building, Farm farm) {

        Integer quantity;
        boolean flag = false;
        while (!flag) {
            buildingPossesion(building, farm);
            System.out.println("Cena kupna 1 " + building.getName() + " wynosi " + building.getBuyingPrice() + " zł");
            System.out.println("Masz gotówkę na zakup maksymanie " + (Math.floor(farm.getCash() / building.getBuyingPrice())));
            System.out.println("Ile budynków chcesz kupić? Jeśli nie chcesz dokonać zakupu, wciśnij 0.");

            try {
                quantity = scan.nextInt();
                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
                } else if (quantity < 0) {
                    System.out.println("Nie można kupić ujemnej ilości budynków.");
                } else if (farm.getCash() < (quantity * building.getBuyingPrice())) {
                    System.out.println("Nie masz wystarczającej ilości pieniędzy, żeby kupić " + building.getName() + " w ilości " + quantity + "szt.");
                } else {
                    building.setQuantityOfThisBuildingType(building.getQuantityOfThisBuildingType() + quantity);
                    farm.setCash(farm.getCash() - (quantity * building.getBuyingPrice()));
                    System.out.println("Dokonałeś zakupu " + quantity + " " + building.getName() + " za kwotę " + (quantity * building.getBuyingPrice()) + "zł.");
                    buildingPossesion(building, farm);
                    flag = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Ilość podajemy w sztukach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }
            scan.nextLine();
        }
    }

    public void sellBuilding(Building building, Farm farm) {

        Integer quantity;
        double maxNumberOfBuildingsToSell = (building.getQuantityOfThisBuildingType() * building.getCapacityOfOneBuilding()) - farm.allPlantsKg() / building.getCapacityOfOneBuilding();
        boolean flag = false;
        while (!flag) {
            buildingPossesion(building, farm);
            System.out.println("Cena sprzedaży 1 budynku wynosi " + building.getSellingPrice() + "zł za 1 budynek.");
            System.out.println("Ile budynków chcesz sprzedać? Jeśli nie chcesz dokonać sprzedaży, wciśnij 0.");
            Integer enoughCapacityPlants = 0, enoughCapacityBuildings = 0;

            try {
                quantity = Integer.parseInt(scan.nextLine());
                Barn barn;
                if(building instanceof Barn) {
                    barn = (Barn) building;
                    Double kgOfPlantsDouble = barn.kgOfPlantsStoredInBarn(farm);
                    Integer kgOfPlantsInteger = kgOfPlantsDouble.intValue();
                    enoughCapacityPlants = ((farm.getBarn().getCapacityOfOneBuilding() * farm.getBarn().getQuantityOfThisBuildingType()) - (farm.getBarn().getCapacityOfOneBuilding() * quantity)) - kgOfPlantsInteger;
                }else
                    enoughCapacityBuildings = ((building.getCapacityOfOneBuilding() * building.getQuantityOfThisBuildingType()) - (building.getCapacityOfOneBuilding() * quantity));


                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
                }else if(building.getName().equals("Stodoła") && enoughCapacityPlants < 0){
                    System.out.println("Nie możesz sprzedać tylu budynków, ponieważ pozostanie za mało, żeby pomieścić rośliny.");
                }else if(building.getName().equals("Kurnik") && enoughCapacityBuildings < 0){
                    System.out.println("Nie możesz sprzedać tylu kurników, ponieważ nie będzie wystarczającej ilości, żeby pomieścić kury.");
                }else if(building.getName().equals("Obora") && enoughCapacityBuildings < 0){
                    System.out.println("Nie możesz sprzedać tylu kurników, ponieważ nie będzie wystarczającej ilości, żeby pomieścić krowy.");
                }else if(building.getName().equals("Stodoła dla kóz") && enoughCapacityBuildings < 0){
                    System.out.println("Nie możesz sprzedać tylu kurników, ponieważ nie będzie wystarczającej ilości, żeby pomieścić kozy.");
                }else if(building.getName().equals("Gęsi kurnik") && enoughCapacityBuildings < 0){
                    System.out.println("Nie możesz sprzedać tylu kurników, ponieważ nie będzie wystarczającej ilości, żeby pomieścić gęsi.");
                }else if(building.getName().equals("Chlew") && enoughCapacityBuildings < 0){
                    System.out.println("Nie możesz sprzedać tylu kurników, ponieważ nie będzie wystarczającej ilości, żeby pomieścić świnie.");
                }else if(building.getName().equals("Owczarnia") && enoughCapacityBuildings < 0){
                    System.out.println("Nie możesz sprzedać tylu kurników, ponieważ nie będzie wystarczającej ilości, żeby pomieścić owce.");
                }else if(building.getName().equals("Kurnik dla indyków") && enoughCapacityBuildings < 0){
                    System.out.println("Nie możesz sprzedać tylu kurników, ponieważ nie będzie wystarczającej ilości, żeby pomieścić indyki.");
                } else if (quantity < 0) {
                    System.out.println("Nie można sprzedać ujemnej ilości budynków.");
                } else if (quantity > farm.getLand().getFreeLand()) {
                    System.out.println("Nie możesz sprzedać więcej ziemi niż masz obecnie ziemi nieobsianej.");
                } else if (quantity > maxNumberOfBuildingsToSell) {
                    System.out.println("Możesz sprzedać tylko budynki, które stoją puste. Możesz sprzedać maksymalnie " + maxNumberOfBuildingsToSell + " budynki.");
                } else {
                    building.setQuantityOfThisBuildingType(building.getQuantityOfThisBuildingType() - quantity);
                    farm.setCash(farm.getCash() + (quantity * building.getBuyingPrice()));

                    System.out.println("Dokonałeś sprzedaży " + quantity + " " + building.getName() + " za kwotę " + (quantity * building.getBuyingPrice()) + "zł.");
                    buildingPossesion(building, farm);
                    flag = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ilość podajemy w dodatnich liczbach całkowitych. Spróbuj jeszcze raz.");
            }
        }
    }
    /*
 if(building.getClass().equals(Barn.class.getClass())) {
        Double kgOfPlantsDouble = barn.kgOfPlantsStoredInBarn(farm);
        Integer kgOfPlantsInteger = kgOfPlantsDouble.intValue();
        enoughCapacityPlants = ((barn.getCapacityOfOneBuilding() * barn.getQuantityOfThisBuildingType()) - (barn.getCapacityOfOneBuilding() * quantity)) - kgOfPlantsInteger;
    }
    enoughCapacityBuildings = ((building.getCapacityOfOneBuilding() * building.getQuantityOfThisBuildingType()) - (building.getCapacityOfOneBuilding() * quantity));

                if (quantity == 0) {
        System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
        flag = true;
    }else if(building.getName().equals("Stodoła") && enoughCapacityPlants <= 0){
        System.out.println("Nie możesz sprzedać tylu budynków, ponieważ pozostanie za mało, żeby pomieścić rośliny.");

        else if(building.getName().equals("Kurnik") && ((enoughCapacityBuildings) - farm.getChickenList().get(0).howManyChickenInList(farm.getChickenList())) <= 0 ){
                    System.out.println("Nie możesz sprzedać tylu kurników, ponieważ nie będzie wystarczającej ilości, żeby pomieścić kury.");
                }*/
    public void buyChicken(Farm farm) {//todo
        Integer quantity;
        boolean flag = false;
        Chicken chicken = new Chicken();

        while (!flag) {
            animalPossesionChicken(farm);
            System.out.println("Cena kupna kury wynosi " + chicken.getBuyingPrice() + " za sztukę.");
            System.out.println("Masz gotówkę na zakup maksymalnie " + (farm.getCash() / chicken.getBuyingPrice()));
            System.out.println("Ile sztuk chcesz kupić? Jeśli nie chcesz dokonać zakupu, wciśnij 0.");

            try {
                quantity = Integer.parseInt(scan.nextLine());
                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
                } else if((farm.getChickenCoop().getCapacityOfOneBuilding() * farm.getChickenCoop().getQuantityOfThisBuildingType()) < farm.getTotalNumberOfChicken() + quantity){
                    System.out.println("Nie możesz kupić kur. Nie masz wystarczającej ilości kurników.");
                }else if (quantity < 0) {
                    System.out.println("Nie można kupić ujemnej ilości " + chicken.getRace());
                } else if (farm.getCash() < (quantity * chicken.getBuyingPrice())) {
                    System.out.println("Nie masz wystarczającej ilości pieniędzy, żeby kupić " + chicken.getRace() + " w ilości " + quantity + " szt.");
                } else {
                    farm.addChicken(farm.getChickenList(), quantity);
                    farm.setCash(farm.getCash() - (quantity * chicken.getBuyingPrice()));
                    System.out.println("Dokonałeś zakupu " + quantity + " szt." + chicken.getRace() + " za kwotę " + (quantity * chicken.getBuyingPrice()) + "zł.");
                    animalPossesionChicken(farm);
                    flag = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ilość podajemy w sztukach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }

        }

    }

    public void sellChicken(Farm farm) {
        Integer quantity;
        boolean flag = false;
        Chicken chicken = new Chicken();

        while (!flag) {
            animalPossesionChicken(farm);
            System.out.println("Cena sprzedaży kur wynosi " + chicken.getSellingPrice() + "zł za sztukę.");
            System.out.println("Ile kur chcesz sprzedać? Jeśli nie chcesz dokonać sprzedaży, wciśnij 0.");

            try {
                quantity = Integer.parseInt(scan.nextLine());
                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
                } else if (farm.getChickenList().isEmpty()) {
                    System.out.println("Nie masz kur na sprzedaż. ");
                } else if (quantity > farm.getChickenList().get(0).howManyChickenInList(farm.getChickenList())) {
                    System.out.println("Nie możesz sprzedać więcej niż posiadasz. Wprowadź odpowiednią ilość.");

                } else if (quantity < 0) {
                    System.out.println("Wprowadziłeś ilość mniejszą niż zero. Wprowadź odpowiednią ilość.");
                } else {
                    Integer quantityTemp = quantity;
                    for (int i = 0; i < farm.getChickenList().size() && quantityTemp > 0; i++) {

                        if (quantityTemp > 0) {
                            if (quantityTemp < farm.getChickenList().get(0).getNumberOfAnimal()) {
                                farm.getChickenList().get(i).setNumberOfAnimal(farm.getChickenList().get(0).getNumberOfAnimal() - quantityTemp);
                                quantityTemp = 0;
                            } else if (quantityTemp == farm.getChickenList().get(0).getNumberOfAnimal()) {
                                quantityTemp = 0;
                                farm.getChickenList().remove(0);
                            } else {
                                quantityTemp = quantityTemp - farm.getChickenList().get(0).getNumberOfAnimal();
                                farm.getChickenList().remove(0);
                            }
                        }
                    }
                    farm.setCash(farm.getCash() + (quantity * chicken.getSellingPrice()));
                    System.out.println("Sprzedałeś " + quantity + " sztuk " + chicken.getRace() + " za kwotę " + (quantity * chicken.getSellingPrice()) + "zł.");
                    if (!farm.getChickenList().isEmpty()) {
                        farm.setTotalNumberOfChicken(farm.getChickenList().get(0).howManyChickenInList(farm.getChickenList()));
                        farm.setTotalNumberOfAdultChicken(farm.getChickenList().get(0).howManyAdultChickenInList(farm.getChickenList()));
                    } else {
                        farm.setTotalNumberOfChicken(0);
                        farm.setTotalNumberOfAdultChicken(0);
                    }
                    animalPossesionChicken(farm);
                    flag = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("Ilość podajemy w sztukach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }
        }
    }

    public void buyCow(Farm farm) {
        Integer quantity;
        boolean flag = false;
        Cow cow = new Cow();

        while (!flag) {
            animalPossesionCow(farm);
            System.out.println("Cena kupna krowy wynosi " + cow.getBuyingPrice() + " za sztukę.");
            System.out.println("Masz gotówkę na zakup maksymalnie " + (farm.getCash() / cow.getBuyingPrice()));
            System.out.println("Ile sztuk chcesz kupić? Jeśli nie chcesz dokonać zakupu, wciśnij 0.");

            try {
                quantity = Integer.parseInt(scan.nextLine());

                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
                } else if((farm.getCowShed().getCapacityOfOneBuilding() * farm.getCowShed().getQuantityOfThisBuildingType()) < farm.getTotalNumberOfCow() + quantity){
                    System.out.println("Nie możesz kupić krów. Nie masz wystarczającej ilości obór.");
                } else if (quantity < 0) {
                    System.out.println("Nie można kupić ujemnej ilości " + cow.getRace());
                } else if (farm.getCash() < (quantity * cow.getBuyingPrice())) {
                    System.out.println("Nie masz wystarczającej ilości pieniędzy, żeby kupić " + cow.getRace() + " w ilości " + quantity + " szt.");
                } else {
                    farm.addCow(farm.getCowList(), quantity);
                    farm.setCash(farm.getCash() - (quantity * cow.getBuyingPrice()));
                    System.out.println("Dokonałeś zakupu " + quantity + " szt." + cow.getRace() + " za kwotę " + (quantity * cow.getBuyingPrice()) + "zł.");
                    animalPossesionCow(farm);
                    flag = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ilość podajemy w sztukach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }
        }
    }

    public void sellCow(Farm farm) {

        Integer quantity;
        boolean flag = false;
        Cow cow = new Cow();

        while (!flag) {
            animalPossesionCow(farm);
            System.out.println("Cena sprzedaży krów wynosi " + cow.getSellingPrice() + "zł za sztukę.");
            System.out.println("Ile krów chcesz sprzedać? Jeśli nie chcesz dokonać sprzedaży, wciśnij 0.");

            try {
                quantity = Integer.parseInt(scan.nextLine());
                if (farm.getCowList() == null) {
                    System.out.println("Nie masz kur na sprzedaż. ");
                } else if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
                } else if (quantity > farm.getCowList().get(0).howManyCowInList(farm.getCowList())) {
                    System.out.println("Nie możesz sprzedać więcej niż posiadasz. Wprowadź odpowiednią ilość.");
                } else if (quantity < 0) {
                    System.out.println("Wprowadziłeś ilość mniejszą niż zero. Wprowadź odpowiednią ilość.");
                } else {
                    Integer quantityTemp = quantity;
                    for (int i = 0; i < farm.getCowList().size() && quantityTemp > 0; i++) {
                        if (quantityTemp > 0) {
                            if (quantityTemp < farm.getCowList().get(0).getNumberOfAnimal()) {
                                farm.getCowList().get(0).setNumberOfAnimal(farm.getCowList().get(0).getNumberOfAnimal() - quantityTemp);
                                quantityTemp = 0;
                            } else if (quantityTemp == farm.getCowList().get(0).getNumberOfAnimal()) {
                                quantityTemp = 0;
                                farm.getCowList().remove(0);
                            } else {
                                quantityTemp = quantityTemp - farm.getCowList().get(0).getNumberOfAnimal();
                                farm.getCowList().remove(0);
                            }
                        }
                    }
                    farm.setCash(farm.getCash() + (quantity * cow.getSellingPrice()));
                    System.out.println("Sprzedałeś " + quantity + " sztuk " + cow.getRace() + " za kwotę " + (quantity * cow.getSellingPrice()) + "zł.");
                    if (!farm.getCowList().isEmpty()) {
                        farm.setTotalNumberOfCow(farm.getCowList().get(0).howManyCowInList(farm.getCowList()));
                        farm.setTotalNumberOfAdultCow(farm.getCowList().get(0).howManyAdultCowInList(farm.getCowList()));
                    } else {
                        farm.setTotalNumberOfCow(0);
                        farm.setTotalNumberOfAdultCow(0);
                    }
                    animalPossesionCow(farm);
                    flag = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ilość podajemy w sztukach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }
        }
    }

    public void buyGoat(Farm farm) {
        Integer quantity;
        boolean flag = false;
        Goat goat = new Goat();

        while (!flag) {
            animalPossesionGoat(farm);
            System.out.println("Cena kupna kozy wynosi " + goat.getBuyingPrice() + " za sztukę.");
            System.out.println("Masz gotówkę na zakup maksymalnie " + (farm.getCash() / goat.getBuyingPrice()));
            System.out.println("Ile sztuk chcesz kupić? Jeśli nie chcesz dokonać zakupu, wciśnij 0.");

            try {
                quantity = Integer.parseInt(scan.nextLine());

                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
                } else if((farm.getGoatBarn().getCapacityOfOneBuilding() * farm.getGoatBarn().getQuantityOfThisBuildingType()) < farm.getTotalNumberOfGoat() + quantity){
                    System.out.println("Nie możesz kupić kóz. Nie masz wystarczającej ilości stodół dla kóz.");
                } else if (quantity < 0) {
                    System.out.println("Nie można kupić ujemnej ilości " + goat.getRace());
                } else if (farm.getCash() < (quantity * goat.getBuyingPrice())) {
                    System.out.println("Nie masz wystarczającej ilości pieniędzy, żeby kupić " + goat.getRace() + " w ilości " + quantity + " szt.");
                } else {
                    farm.addGoat(farm.getGoatList(), quantity);
                    farm.setCash(farm.getCash() - (quantity * goat.getBuyingPrice()));
                    System.out.println("Dokonałeś zakupu " + quantity + " szt." + goat.getRace() + " za kwotę " + (quantity * goat.getBuyingPrice()) + "zł.");
                    animalPossesionGoat(farm);
                    flag = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ilość podajemy w sztukach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }
        }
    }

    public void sellGoat(Farm farm) {

        Integer quantity;
        boolean flag = false;
        Goat goat = new Goat();

        while (!flag) {
            animalPossesionGoat(farm);
            System.out.println("Cena sprzedaży kóz wynosi " + goat.getSellingPrice() + "zł za sztukę.");
            System.out.println("Ile kóz chcesz sprzedać? Jeśli nie chcesz dokonać sprzedaży, wciśnij 0.");

            try {
                quantity = Integer.parseInt(scan.nextLine());
                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
                } else if (farm.getGoatList() == null) {
                    System.out.println("Nie masz kur na sprzedaż. ");
                } else if (quantity > farm.getGoatList().get(0).howManyGoatInList(farm.getGoatList())) {
                    System.out.println("Nie możesz sprzedać więcej niż posiadasz. Wprowadź odpowiednią ilość.");
                } else if (quantity < 0) {
                    System.out.println("Wprowadziłeś ilość mniejszą niż zero. Wprowadź odpowiednią ilość.");
                } else {
                    Integer quantityTemp = quantity;
                    for (int i = 0; i < farm.getGoatList().size() && quantityTemp > 0; i++) {
                        if (quantityTemp > 0) {
                            if (quantityTemp < farm.getGoatList().get(0).getNumberOfAnimal()) {
                                farm.getGoatList().get(0).setNumberOfAnimal(farm.getGoatList().get(0).getNumberOfAnimal() - quantityTemp);
                                quantityTemp = 0;
                            } else if (quantityTemp == farm.getGoatList().get(0).getNumberOfAnimal()) {
                                quantityTemp = 0;
                                farm.getGoatList().remove(0);
                            } else {
                                quantityTemp = quantityTemp - farm.getGoatList().get(0).getNumberOfAnimal();
                                farm.getGoatList().remove(0);
                            }
                        }
                    }
                    farm.setCash(farm.getCash() + (quantity * goat.getSellingPrice()));
                    System.out.println("Sprzedałeś " + quantity + " sztuk " + goat.getRace() + " za kwotę " + (quantity * goat.getSellingPrice()) + "zł.");
                    if (!farm.getGoatList().isEmpty()) {
                        farm.setTotalNumberOfGoat(farm.getGoatList().get(0).howManyGoatInList(farm.getGoatList()));
                        farm.setTotalNumberOfAdultGoat(farm.getGoatList().get(0).howManyAdultGoatInList(farm.getGoatList()));
                    } else {
                        farm.setTotalNumberOfGoat(0);
                        farm.setTotalNumberOfAdultGoat(0);
                    }
                    animalPossesionGoat(farm);
                    flag = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("Ilość podajemy w sztukach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }
        }
    }

    public void buyGoose(Farm farm) {
        Integer quantity;
        boolean flag = false;
        Goose goose = new Goose();

        while (!flag) {
            animalPossesionGoose(farm);
            System.out.println("Cena kupna gęsi wynosi " + goose.getBuyingPrice() + " za sztukę.");
            System.out.println("Masz gotówkę na zakup maksymalnie " + (farm.getCash() / goose.getBuyingPrice()));
            System.out.println("Ile sztuk chcesz kupić? Jeśli nie chcesz dokonać zakupu, wciśnij 0.");

            try {
                quantity = Integer.parseInt(scan.nextLine());

                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
                } else if((farm.getGooseCoop().getCapacityOfOneBuilding() * farm.getGooseCoop().getQuantityOfThisBuildingType()) < farm.getTotalNumberOfGoose() + quantity){
                    System.out.println("Nie możesz kupić gęsi. Nie masz wystarczającej ilości kurników dla gęsi.");
                } else if (quantity < 0) {
                    System.out.println("Nie można kupić ujemnej ilości " + goose.getRace());
                } else if (farm.getCash() < (quantity * goose.getBuyingPrice())) {
                    System.out.println("Nie masz wystarczającej ilości pieniędzy, żeby kupić " + goose.getRace() + " w ilości " + quantity + " szt.");
                } else {
                    farm.addGoose(farm.getGooseList(), quantity);
                    farm.setCash(farm.getCash() - (quantity * goose.getBuyingPrice()));
                    System.out.println("Dokonałeś zakupu " + quantity + " szt." + goose.getRace() + " za kwotę " + (quantity * goose.getBuyingPrice()) + "zł.");
                    animalPossesionGoose(farm);
                    flag = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ilość podajemy w sztukach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }

        }
    }

    public void sellGoose(Farm farm) {

        Integer quantity;
        boolean flag = false;
        Goose goose = new Goose();

        while (!flag) {
            animalPossesionGoose(farm);
            System.out.println("Cena sprzedaży gęsi wynosi " + goose.getSellingPrice() + "zł za sztukę.");
            System.out.println("Ile gęsi chcesz sprzedać? Jeśli nie chcesz dokonać sprzedaży, wciśnij 0.");

            try {
                quantity = Integer.parseInt(scan.nextLine());
                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
                } else if (farm.getGooseList() == null) {
                    System.out.println("Nie masz kur na sprzedaż. ");
                } else if (quantity > farm.getGooseList().get(0).howManyGooseInList(farm.getGooseList())) {
                    System.out.println("Nie możesz sprzedać więcej niż posiadasz. Wprowadź odpowiednią ilość.");
                } else if (quantity < 0) {
                    System.out.println("Wprowadziłeś ilość mniejszą niż zero. Wprowadź odpowiednią ilość.");
                } else {
                    Integer quantityTemp = quantity;
                    for (int i = 0; i < farm.getGooseList().size() && quantityTemp > 0; i++) {
                        if (quantityTemp > 0) {
                            if (quantityTemp < farm.getGooseList().get(0).getNumberOfAnimal()) {
                                farm.getGooseList().get(0).setNumberOfAnimal(farm.getGooseList().get(0).getNumberOfAnimal() - quantityTemp);
                                quantityTemp = 0;
                            } else if (quantityTemp == farm.getGooseList().get(0).getNumberOfAnimal()) {
                                quantityTemp = 0;
                                farm.getGooseList().remove(0);
                            } else {
                                quantityTemp = quantityTemp - farm.getGooseList().get(0).getNumberOfAnimal();
                                farm.getGooseList().remove(0);
                            }
                        }
                    }
                    farm.setCash(farm.getCash() + (quantity * goose.getSellingPrice()));
                    System.out.println("Sprzedałeś " + quantity + " sztuk " + goose.getRace() + " za kwotę " + (quantity * goose.getSellingPrice()) + "zł.");
                    if (!farm.getGooseList().isEmpty()) {
                        farm.setTotalNumberOfGoose(farm.getGooseList().get(0).howManyGooseInList(farm.getGooseList()));
                        farm.setTotalNumberOfAdultGoose(farm.getGooseList().get(0).howManyAdultGooseInList(farm.getGooseList()));
                    } else {
                        farm.setTotalNumberOfGoose(0);
                        farm.setTotalNumberOfAdultGoose(0);
                    }
                    animalPossesionGoose(farm);
                    flag = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ilość podajemy w sztukach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }
        }
    }

    public void buyPig(Farm farm) {
        Integer quantity;
        boolean flag = false;
        Pig pig = new Pig();

        while (!flag) {
            animalPossesionPig(farm);
            System.out.println("Cena kupna świni wynosi " + pig.getBuyingPrice() + " za sztukę.");
            System.out.println("Masz gotówkę na zakup maksymalnie " + (farm.getCash() / pig.getBuyingPrice()));
            System.out.println("Ile sztuk chcesz kupić? Jeśli nie chcesz dokonać zakupu, wciśnij 0.");

            try {
                quantity = Integer.parseInt(scan.nextLine());

                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
                } else if((farm.getPigsty().getCapacityOfOneBuilding() * farm.getPigsty().getQuantityOfThisBuildingType()) < farm.getTotalNumberOfPig() + quantity){
                    System.out.println("Nie możesz kupić świń. Nie masz wystarczającej ilości chlewów.");
                } else if (quantity < 0) {
                    System.out.println("Nie można kupić ujemnej ilości " + pig.getRace());
                } else if (farm.getCash() < (quantity * pig.getBuyingPrice())) {
                    System.out.println("Nie masz wystarczającej ilości pieniędzy, żeby kupić " + pig.getRace() + " w ilości " + quantity + " szt.");
                } else {
                    farm.addPig(farm.getPigList(), quantity);
                    farm.setCash(farm.getCash() - (quantity * pig.getBuyingPrice()));
                    System.out.println("Dokonałeś zakupu " + quantity + " szt." + pig.getRace() + " za kwotę " + (quantity * pig.getBuyingPrice()) + "zł.");
                    animalPossesionPig(farm);
                    flag = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ilość podajemy w sztukach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }
        }
    }

    public void sellPig(Farm farm) {

        Integer quantity;
        boolean flag = false;
        Pig pig = new Pig();

        while (!flag) {
            animalPossesionPig(farm);
            System.out.println("Cena sprzedaży świń wynosi " + pig.getSellingPrice() + "zł za sztukę.");
            System.out.println("Ile świń chcesz sprzedać? Jeśli nie chcesz dokonać sprzedaży, wciśnij 0.");

            try {
                quantity = Integer.parseInt(scan.nextLine());
                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
                } else if (farm.getPigList() == null) {
                    System.out.println("Nie masz kur na sprzedaż. ");
                } else if (quantity > farm.getPigList().get(0).howManyAdultPigInList(farm.getPigList())) {
                    System.out.println("Nie możesz sprzedać więcej niż posiadasz. Wprowadź odpowiednią ilość.");
                } else if (quantity < 0) {
                    System.out.println("Wprowadziłeś ilość mniejszą niż zero. Wprowadź odpowiednią ilość.");
                } else {
                    Integer quantityTemp = quantity;
                    for (int i = 0; i < farm.getPigList().size() && quantityTemp > 0; i++) {
                        if (quantityTemp > 0) {
                            if (quantityTemp < farm.getPigList().get(0).getNumberOfAnimal()) {
                                farm.getPigList().get(0).setNumberOfAnimal(farm.getPigList().get(0).getNumberOfAnimal() - quantityTemp);
                                quantityTemp = 0;
                            } else if (quantityTemp == farm.getPigList().get(0).getNumberOfAnimal()) {
                                quantityTemp = 0;
                                farm.getPigList().remove(0);
                            } else {
                                quantityTemp = quantityTemp - farm.getPigList().get(i).getNumberOfAnimal();
                                farm.getPigList().remove(0);
                            }
                        }
                    }
                    farm.setCash(farm.getCash() + (quantity * pig.getSellingPrice()));
                    System.out.println("Sprzedałeś " + quantity + " sztuk " + pig.getRace() + " za kwotę " + (quantity * pig.getSellingPrice()) + "zł.");
                    if (!farm.getPigList().isEmpty()) {
                        farm.setTotalNumberOfPig(farm.getPigList().get(0).howManyPigInList(farm.getPigList()));
                        farm.setTotalNumberOfAdultPig(farm.getPigList().get(0).howManyAdultPigInList(farm.getPigList()));
                    } else {
                        farm.setTotalNumberOfPig(0);
                        farm.setTotalNumberOfAdultPig(0);
                    }
                    animalPossesionPig(farm);
                    flag = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("Ilość podajemy w sztukach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }
        }
    }

    public void buySheep(Farm farm) {
        Integer quantity;
        boolean flag = false;
        Sheep sheep = new Sheep();

        while (!flag) {
            animalPossesionSheep(farm);
            System.out.println("Cena kupna owcy wynosi " + sheep.getBuyingPrice() + " za sztukę.");
            System.out.println("Masz gotówkę na zakup maksymalnie " + (farm.getCash() / sheep.getBuyingPrice()));
            System.out.println("Ile sztuk chcesz kupić? Jeśli nie chcesz dokonać zakupu, wciśnij 0.");

            try {
                quantity = Integer.parseInt(scan.nextLine());

                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
                } else if((farm.getSheepfold().getCapacityOfOneBuilding() * farm.getSheepfold().getQuantityOfThisBuildingType()) < farm.getTotalNumberOfSheep() + quantity){
                    System.out.println("Nie możesz kupić owiec. Nie masz wystarczającej ilości owczarni.");
                } else if (quantity < 0) {
                    System.out.println("Nie można kupić ujemnej ilości " + sheep.getRace());
                } else if (farm.getCash() < (quantity * sheep.getBuyingPrice())) {
                    System.out.println("Nie masz wystarczającej ilości pieniędzy, żeby kupić " + sheep.getRace() + " w ilości " + quantity + " szt.");
                } else {
                    farm.addSheep(farm.getSheepList(), quantity);
                    farm.setCash(farm.getCash() - (quantity * sheep.getBuyingPrice()));
                    System.out.println("Dokonałeś zakupu " + quantity + " szt." + sheep.getRace() + " za kwotę " + (quantity * sheep.getBuyingPrice()) + "zł.");
                    animalPossesionSheep(farm);
                    flag = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ilość podajemy w sztukach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }
        }
    }

    public void sellSheep(Farm farm) {

        Integer quantity;
        boolean flag = false;
        Sheep sheep = new Sheep();

        while (!flag) {
            animalPossesionSheep(farm);
            System.out.println("Cena sprzedaży owiec wynosi " + sheep.getSellingPrice() + "zł za sztukę.");
            System.out.println("Ile owiec chcesz sprzedać? Jeśli nie chcesz dokonać sprzedaży, wciśnij 0.");

            try {
                quantity = Integer.parseInt(scan.nextLine());
                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
                } else if (farm.getSheepList() == null) {
                    System.out.println("Nie masz kur na sprzedaż. ");
                } else if (quantity > farm.getSheepList().get(0).howManySheepInList(farm.getSheepList())) {
                    System.out.println("Nie możesz sprzedać więcej niż posiadasz. Wprowadź odpowiednią ilość.");
                } else if (quantity < 0) {
                    System.out.println("Wprowadziłeś ilość mniejszą niż zero. Wprowadź odpowiednią ilość.");
                } else {
                    Integer quantityTemp = quantity;
                    for (int i = 0; i < farm.getSheepList().size() && quantityTemp > 0; i++) {
                        if (quantityTemp > 0) {
                            if (quantityTemp < farm.getSheepList().get(0).getNumberOfAnimal()) {
                                farm.getSheepList().get(0).setNumberOfAnimal(farm.getSheepList().get(0).getNumberOfAnimal() - quantityTemp);
                                quantityTemp = 0;
                            } else if (quantityTemp == farm.getSheepList().get(0).getNumberOfAnimal()) {
                                quantityTemp = 0;
                                farm.getSheepList().remove(0);
                            } else {
                                quantityTemp = quantityTemp - farm.getSheepList().get(0).getNumberOfAnimal();
                                farm.getSheepList().remove(0);
                            }
                        }
                    }
                    farm.setCash(farm.getCash() + (quantity * sheep.getSellingPrice()));
                    System.out.println("Sprzedałeś " + quantity + " sztuk " + sheep.getRace() + " za kwotę " + (quantity * sheep.getSellingPrice()) + "zł.");
                    if (!farm.getSheepList().isEmpty()) {
                        farm.setTotalNumberOfSheep(farm.getSheepList().get(0).howManySheepInList(farm.getSheepList()));
                        farm.setTotalNumberOfAdultSheep(farm.getSheepList().get(0).howManyAdultSheepInList(farm.getSheepList()));
                    } else {
                        farm.setTotalNumberOfSheep(0);
                        farm.setTotalNumberOfAdultSheep(0);
                    }
                    animalPossesionSheep(farm);
                    flag = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("Ilość podajemy w sztukach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }
        }
    }

    public void buyTurkey(Farm farm) {
        Integer quantity;
        boolean flag = false;
        Turkey turkey = new Turkey();

        while (!flag) {
            animalPossesionTurkey(farm);
            System.out.println("Cena kupna indyka wynosi " + turkey.getBuyingPrice() + " za sztukę.");
            System.out.println("Masz gotówkę na zakup maksymalnie " + (farm.getCash() / turkey.getBuyingPrice()));
            System.out.println("Ile sztuk chcesz kupić? Jeśli nie chcesz dokonać zakupu, wciśnij 0.");

            try {
                quantity = Integer.parseInt(scan.nextLine());

                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
                } else if((farm.getTurkeyCoop().getCapacityOfOneBuilding() * farm.getTurkeyCoop().getQuantityOfThisBuildingType()) < farm.getTotalNumberOfTurkey() + quantity){
                    System.out.println("Nie możesz kupić indyków. Nie masz wystarczającej ilości kurników dla indyków.");
                } else if (quantity < 0) {
                    System.out.println("Nie można kupić ujemnej ilości " + turkey.getRace());
                } else if (farm.getCash() < (quantity * turkey.getBuyingPrice())) {
                    System.out.println("Nie masz wystarczającej ilości pieniędzy, żeby kupić " + turkey.getRace() + " w ilości " + quantity + " szt.");
                } else {
                    farm.addTurkey(farm.getTurkeyList(), quantity);
                    farm.setCash(farm.getCash() - (quantity * turkey.getBuyingPrice()));
                    System.out.println("Dokonałeś zakupu " + quantity + " szt." + turkey.getRace() + " za kwotę " + (quantity * turkey.getBuyingPrice()) + "zł.");
                    animalPossesionTurkey(farm);
                    flag = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ilość podajemy w sztukach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }

        }
    }

    public void sellTurkey(Farm farm) {

        Integer quantity;
        boolean flag = false;
        Turkey turkey = new Turkey();

        while (!flag) {
            animalPossesionTurkey(farm);
            System.out.println("Cena sprzedaży indyków wynosi " + turkey.getSellingPrice() + "zł za sztukę.");
            System.out.println("Ile indyków chcesz sprzedać? Jeśli nie chcesz dokonać sprzedaży, wciśnij 0.");

            try {
                quantity = Integer.parseInt(scan.nextLine());
                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
                } else if (farm.getTurkeyList() == null) {
                    System.out.println("Nie masz kur na sprzedaż. ");
                } else if (quantity > farm.getTurkeyList().get(0).howManyTurkeyInList(farm.getTurkeyList())) {
                    System.out.println("Nie możesz sprzedać więcej niż posiadasz. Wprowadź odpowiednią ilość.");
                } else if (quantity < 0) {
                    System.out.println("Wprowadziłeś ilość mniejszą niż zero. Wprowadź odpowiednią ilość.");
                } else {
                    Integer quantityTemp = quantity;
                    for (int i = 0; i < farm.getTurkeyList().size() && quantityTemp > 0; i++) {
                        if (quantityTemp > 0) {
                            if (quantityTemp < farm.getTurkeyList().get(0).getNumberOfAnimal()) {
                                farm.getTurkeyList().get(0).setNumberOfAnimal(farm.getTurkeyList().get(0).getNumberOfAnimal() - quantityTemp);
                                quantityTemp = 0;
                            } else if (quantityTemp == farm.getTurkeyList().get(0).getNumberOfAnimal()) {
                                quantityTemp = 0;
                                farm.getTurkeyList().remove(0);
                            } else {
                                quantityTemp = quantityTemp - farm.getTurkeyList().get(0).getNumberOfAnimal();
                                farm.getTurkeyList().remove(0);
                            }
                        }
                    }
                    farm.setCash(farm.getCash() + (quantity * turkey.getSellingPrice()));
                    System.out.println("Sprzedałeś " + quantity + " sztuk " + turkey.getRace() + " za kwotę " + (quantity * turkey.getSellingPrice()) + "zł.");
                    if (!farm.getTurkeyList().isEmpty()) {
                        farm.setTotalNumberOfTurkey(farm.getTurkeyList().get(0).howManyTurkeyInList(farm.getTurkeyList()));
                        farm.setTotalNumberOfAdultTurkey(farm.getTurkeyList().get(0).howManyAdultTurkeyInList(farm.getTurkeyList()));
                    } else {
                        farm.setTotalNumberOfTurkey(0);
                        farm.setTotalNumberOfAdultTurkey(0);
                    }
                    animalPossesionTurkey(farm);
                    flag = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("Ilość podajemy w sztukach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }
        }
    }
}
