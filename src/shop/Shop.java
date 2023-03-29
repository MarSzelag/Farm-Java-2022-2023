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

    //TODO*****************************Plants
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
        System.out.println("Posiadasz " + farm.getChickenList().size() + " kur.");
    }

    public void animalPossesionCow(Farm farm) {
        System.out.println("Posiadasz " + farm.getCowList().size() + " krów.");
    }

    public void animalPossesionGoat(Farm farm) {
        System.out.println("Posiadasz " + farm.getGoatList().size() + " kóz.");
    }

    public void animalPossesionGoose(Farm farm) {
        System.out.println("Posiadasz " + farm.getGooseList().size() + " gęsi.");
    }

    public void animalPossesionPig(Farm farm) {
        System.out.println("Posiadasz " + farm.getPigList().size() + " świń.");
    }

    public void animalPossesionSheep(Farm farm) {
        System.out.println("Posiadasz " + farm.getSheepList().size() + " owiec.");
    }

    public void animalPossesionTurkey(Farm farm) {
        System.out.println("Posiadasz " + farm.getTurkeyList().size() + " indyków.");
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
        Integer maxNumberOfBuildingsToSell = (building.getQuantityOfThisBuildingType() * building.getCapacityOfOneBuilding()) - farm.allPlantsKg() / building.getCapacityOfOneBuilding();
        boolean flag = false;
        while (!flag) {
            landPossession(farm);
            System.out.println("Cena sprzedaży 1 budynku wynosi " + farm.getLand().getSellPriceOfLandPerHa() + "zł za hektar.");
            System.out.println("Możesz sprzedać tylko nieobsianą ziemię, czyli " + farm.getLand().getFreeLand());
            System.out.println("Ile budynków chcesz sprzedać? Jeśli nie chcesz dokonać sprzedaży, wciśnij 0.");

            try {
                quantity = scan.nextInt();
                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
                } else if (quantity < 0) {
                    System.out.println("Nie można sprzedać ujemnej ilości budynków.");
                } else if (quantity > farm.getLand().getFreeLand()) {
                    System.out.println("Nie możesz sprzedać więcej ziemi niż masz obecnie ziemi nieobsianej.");
                } else if (quantity > maxNumberOfBuildingsToSell) {
                    System.out.println("Możesz sprzedać tylko budynki, które stoją puste. Możesz sprzedać maksymalnie " + maxNumberOfBuildingsToSell + " budynki.");
                } else {
                    building.setQuantityOfThisBuildingType(building.getQuantityOfThisBuildingType() + quantity);
                    farm.setCash(farm.getCash() + (quantity * building.getBuyingPrice()));

                    System.out.println("Dokonałeś sprzedaży " + quantity + " " + building.getName() + " za kwotę " + (quantity * building.getBuyingPrice()) + "zł.");
                    landPossession(farm);
                    flag = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Ilość podajemy w dodatnich liczbach całkowitych. Spróbuj jeszcze raz.");
            }
            scan.nextLine();
        }

    }

    //TODO****************************Animals

    public void buyChicken(Farm farm) {
        Integer quantity;
        boolean flag = false;
        Chicken chicken = new Chicken();

        while (!flag) {
            animalPossesionChicken(farm);
            System.out.println("Cena kupna kury wynosi " + chicken.getBuyingPrice() + " za sztukę.");
            System.out.println("Masz gotówkę na zakup maksymalnie " + (farm.getCash() / chicken.getBuyingPrice()));
            System.out.println("Ile sztuk chcesz kupić? Jeśli nie chcesz dokonać zakupu, wciśnij 0.");

            try {
                quantity = scan.nextInt();

                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
                } else if (quantity < 0) {
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
            } catch (InputMismatchException e) {
                System.out.println("Ilość podajemy w sztukach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }
            scan.nextLine();

        }

    }

    public void sellChicken(Farm farm) {
        Integer quantity;
        boolean flag = false;
        Chicken chicken = new Chicken();

        while (!flag) {
            animalPossesionChicken(farm);
            System.out.println("Cena sprzedaży kur wynosi " + chicken.getSellingPrice() + "zł za sztukę.");
            System.out.println("Posiadasz obecnie " + farm.getChickenList().size() + "sztuk kur.");
            System.out.println("Ile kur chcesz sprzedać? Jeśli nie chcesz dokonać sprzedaży, wciśnij 0.");

            try {
                quantity = scan.nextInt();
                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
                } else if (quantity > farm.getChickenList().size()) {
                    System.out.println("Nie możesz sprzedać więcej niż posiadasz. Wprowadź odpowiednią ilość.");

                } else if (quantity < 0) {
                    System.out.println("Wprowadziłeś ilość mniejszą niż zero. Wprowadź odpowiednią ilość.");
                } else {
                    farm.removeChicken(farm.getChickenList(), quantity);
                    farm.setCash(farm.getCash() + (quantity * chicken.getSellingPrice()));
                    System.out.println("Sprzedałeś " + quantity + " sztuk " + chicken.getRace() + " za kwotę " + (quantity * chicken.getSellingPrice()) + "zł.");
                    animalPossesionChicken(farm);
                    flag = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Ilość podajemy w sztukach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }
            scan.nextLine();
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
                quantity = scan.nextInt();

                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
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
            } catch (InputMismatchException e) {
                System.out.println("Ilość podajemy w sztukach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }
            scan.nextLine();

        }
    }

    public void sellCow(Farm farm) {

        Integer quantity;
        boolean flag = false;
        Cow cow = new Cow();

        while (!flag) {
            animalPossesionCow(farm);
            System.out.println("Cena sprzedaży krów wynosi " + cow.getSellingPrice() + "zł za sztukę.");
            System.out.println("Posiadasz obecnie " + farm.getCowList().size() + "sztuk krów.");
            System.out.println("Ile krów chcesz sprzedać? Jeśli nie chcesz dokonać sprzedaży, wciśnij 0.");

            try {
                quantity = scan.nextInt();
                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
                } else if (quantity > farm.getCowList().size()) {
                    System.out.println("Nie możesz sprzedać więcej niż posiadasz. Wprowadź odpowiednią ilość.");

                } else if (quantity < 0) {
                    System.out.println("Wprowadziłeś ilość mniejszą niż zero. Wprowadź odpowiednią ilość.");
                } else {
                    farm.removeCow(farm.getCowList(), quantity);
                    farm.setCash(farm.getCash() + (quantity * cow.getSellingPrice()));
                    System.out.println("Sprzedałeś " + quantity + " sztuk " + cow.getRace() + " za kwotę " + (quantity * cow.getSellingPrice()) + "zł.");
                    animalPossesionCow(farm);
                    flag = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Ilość podajemy w sztukach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }
            scan.nextLine();
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
                quantity = scan.nextInt();

                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
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
            } catch (InputMismatchException e) {
                System.out.println("Ilość podajemy w sztukach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }
            scan.nextLine();

        }
    }

    public void sellGoat(Farm farm) {

        Integer quantity;
        boolean flag = false;
        Goat goat = new Goat();

        while (!flag) {
            animalPossesionGoat(farm);
            System.out.println("Cena sprzedaży kóz wynosi " + goat.getSellingPrice() + "zł za sztukę.");
            System.out.println("Posiadasz obecnie " + farm.getGoatList().size() + "sztuk kóz.");
            System.out.println("Ile kóz chcesz sprzedać? Jeśli nie chcesz dokonać sprzedaży, wciśnij 0.");

            try {
                quantity = scan.nextInt();
                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
                } else if (quantity > farm.getGoatList().size()) {
                    System.out.println("Nie możesz sprzedać więcej niż posiadasz. Wprowadź odpowiednią ilość.");

                } else if (quantity < 0) {
                    System.out.println("Wprowadziłeś ilość mniejszą niż zero. Wprowadź odpowiednią ilość.");
                } else {
                    farm.removeGoat(farm.getGoatList(), quantity);
                    farm.setCash(farm.getCash() + (quantity * goat.getSellingPrice()));
                    System.out.println("Sprzedałeś " + quantity + " sztuk " + goat.getRace() + " za kwotę " + (quantity * goat.getSellingPrice()) + "zł.");
                    animalPossesionGoat(farm);
                    flag = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Ilość podajemy w sztukach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }
            scan.nextLine();
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
                quantity = scan.nextInt();

                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
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
            } catch (InputMismatchException e) {
                System.out.println("Ilość podajemy w sztukach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }
            scan.nextLine();

        }
    }

    public void sellGoose(Farm farm) {

        Integer quantity;
        boolean flag = false;
        Goose goose = new Goose();

        while (!flag) {
            animalPossesionGoose(farm);
            System.out.println("Cena sprzedaży gęsi wynosi " + goose.getSellingPrice() + "zł za sztukę.");
            System.out.println("Posiadasz obecnie " + farm.getGooseList().size() + "sztuk gęsi.");
            System.out.println("Ile gęsi chcesz sprzedać? Jeśli nie chcesz dokonać sprzedaży, wciśnij 0.");

            try {
                quantity = scan.nextInt();
                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
                } else if (quantity > farm.getGooseList().size()) {
                    System.out.println("Nie możesz sprzedać więcej niż posiadasz. Wprowadź odpowiednią ilość.");

                } else if (quantity < 0) {
                    System.out.println("Wprowadziłeś ilość mniejszą niż zero. Wprowadź odpowiednią ilość.");
                } else {
                    farm.removeGoose(farm.getGooseList(), quantity);
                    farm.setCash(farm.getCash() + (quantity * goose.getSellingPrice()));
                    System.out.println("Sprzedałeś " + quantity + " sztuk " + goose.getRace() + " za kwotę " + (quantity * goose.getSellingPrice()) + "zł.");
                    animalPossesionGoose(farm);
                    flag = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Ilość podajemy w sztukach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }
            scan.nextLine();
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
                quantity = scan.nextInt();

                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
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
            } catch (InputMismatchException e) {
                System.out.println("Ilość podajemy w sztukach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }
            scan.nextLine();

        }
    }

    public void sellPig(Farm farm) {

        Integer quantity;
        boolean flag = false;
        Pig pig = new Pig();

        while (!flag) {
            animalPossesionPig(farm);
            System.out.println("Cena sprzedaży świń wynosi " + pig.getSellingPrice() + "zł za sztukę.");
            System.out.println("Posiadasz obecnie " + farm.getPigList().size() + "sztuk świń.");
            System.out.println("Ile świń chcesz sprzedać? Jeśli nie chcesz dokonać sprzedaży, wciśnij 0.");

            try {
                quantity = scan.nextInt();
                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
                } else if (quantity > farm.getPigList().size()) {
                    System.out.println("Nie możesz sprzedać więcej niż posiadasz. Wprowadź odpowiednią ilość.");

                } else if (quantity < 0) {
                    System.out.println("Wprowadziłeś ilość mniejszą niż zero. Wprowadź odpowiednią ilość.");
                } else {
                    farm.removePig(farm.getPigList(), quantity);
                    farm.setCash(farm.getCash() + (quantity * pig.getSellingPrice()));
                    System.out.println("Sprzedałeś " + quantity + " sztuk " + pig.getRace() + " za kwotę " + (quantity * pig.getSellingPrice()) + "zł.");
                    animalPossesionPig(farm);
                    flag = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Ilość podajemy w sztukach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }
            scan.nextLine();
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
                quantity = scan.nextInt();

                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
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
            } catch (InputMismatchException e) {
                System.out.println("Ilość podajemy w sztukach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }
            scan.nextLine();

        }
    }

    public void sellSheep(Farm farm) {

        Integer quantity;
        boolean flag = false;
        Sheep sheep = new Sheep();

        while (!flag) {
            animalPossesionSheep(farm);
            System.out.println("Cena sprzedaży owiec wynosi " + sheep.getSellingPrice() + "zł za sztukę.");
            System.out.println("Posiadasz obecnie " + farm.getSheepList().size() + "sztuk owiec.");
            System.out.println("Ile owiec chcesz sprzedać? Jeśli nie chcesz dokonać sprzedaży, wciśnij 0.");

            try {
                quantity = scan.nextInt();
                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
                } else if (quantity > farm.getSheepList().size()) {
                    System.out.println("Nie możesz sprzedać więcej niż posiadasz. Wprowadź odpowiednią ilość.");

                } else if (quantity < 0) {
                    System.out.println("Wprowadziłeś ilość mniejszą niż zero. Wprowadź odpowiednią ilość.");
                } else {
                    farm.removeSheep(farm.getSheepList(), quantity);
                    farm.setCash(farm.getCash() + (quantity * sheep.getSellingPrice()));
                    System.out.println("Sprzedałeś " + quantity + " sztuk " + sheep.getRace() + " za kwotę " + (quantity * sheep.getSellingPrice()) + "zł.");
                    animalPossesionSheep(farm);
                    flag = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Ilość podajemy w sztukach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }
            scan.nextLine();
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
                quantity = scan.nextInt();

                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
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
            } catch (InputMismatchException e) {
                System.out.println("Ilość podajemy w sztukach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }
            scan.nextLine();

        }
    }

    public void sellTurkey(Farm farm) {

        Integer quantity;
        boolean flag = false;
        Turkey turkey = new Turkey();

        while (!flag) {
            animalPossesionTurkey(farm);
            System.out.println("Cena sprzedaży indyków wynosi " + turkey.getSellingPrice() + "zł za sztukę.");
            System.out.println("Posiadasz obecnie " + farm.getTurkeyList().size() + "sztuk indyków.");
            System.out.println("Ile indyków chcesz sprzedać? Jeśli nie chcesz dokonać sprzedaży, wciśnij 0.");

            try {
                quantity = scan.nextInt();
                if (quantity == 0) {
                    System.out.println("Dziękujemy za wizytę w naszym sklepie. Zapraszamy ponownie.");
                    flag = true;
                } else if (quantity > farm.getTurkeyList().size()) {
                    System.out.println("Nie możesz sprzedać więcej niż posiadasz. Wprowadź odpowiednią ilość.");

                } else if (quantity < 0) {
                    System.out.println("Wprowadziłeś ilość mniejszą niż zero. Wprowadź odpowiednią ilość.");
                } else {
                    farm.removeTurkey(farm.getTurkeyList(), quantity);
                    farm.setCash(farm.getCash() + (quantity * turkey.getSellingPrice()));
                    System.out.println("Sprzedałeś " + quantity + " sztuk " + turkey.getRace() + " za kwotę " + (quantity * turkey.getSellingPrice()) + "zł.");
                    animalPossesionTurkey(farm);
                    flag = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Ilość podajemy w sztukach. Bez wartości ułamkowych. Używamy tylko cyfr. Spróbuj jeszcze raz.");
            }
            scan.nextLine();
        }
    }


}
