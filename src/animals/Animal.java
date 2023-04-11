package animals;

import farm.Farm;

import java.util.LinkedList;
import java.util.List;

public class Animal {
    private String race;
    private Integer ageWeeks;
    private Integer ageOfAdulthoodWeeks;
    private Double weightInKg;
    private Double weightGainPerWeekKg;
    private String acceptedFood;
    private String buildingNeeded;
    private Double foodEatenPerWeek;
    private Integer breedingChance;
    private Double buyingPrice;
    private Double sellingPrice;

    private Integer numberOfAnimal;
    private boolean isAdult = false;
    private Double animalProductPrice;

    public Animal() {
    }

    public Animal(String race, Integer ageWeeks, Integer ageOfAdulthood, Double weightInKg, Double foodEatenPerWeek, Double weightGainPerWeek, Integer breedingChance, Double buyingPrice, Double sellingPrice, String buildingNeeded, String acceptedFood) {
        this.race = race;
        this.ageWeeks = ageWeeks;
        this.ageOfAdulthoodWeeks = ageOfAdulthood;
        this.weightInKg = weightInKg;
        this.foodEatenPerWeek = foodEatenPerWeek;
        this.weightGainPerWeekKg = weightGainPerWeek;
        this.breedingChance = breedingChance;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.buildingNeeded = buildingNeeded;
        this.acceptedFood = acceptedFood;
    }

    //TODO Types of food accepted by animal
    //TODO Chances for breeding if there is more than one adult animal
    //TODO In Farm class list of animal type, and then each animal have its own cell in list
// Liczba zwierząt - razem, wiek - osobno dla każdego zwierzęcia - lista zwierząt i ostatni element listy jest ilością zwierząt

    // kura, gęś, indyk - coop
    // krowa - barn
    // świnia - pigsty
    // owca - sheepfold
    // koza - goat barn

    public void canAnimalEatIt() {

    }

    public void breed() {

    }

    public void numberOfAdultAnimals() {

    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Integer getAgeWeeks() {
        return ageWeeks;
    }

    public void setAgeWeeks(Integer ageWeeks) {
        this.ageWeeks = ageWeeks;
    }

    public Integer getAgeOfAdulthood() {
        return ageOfAdulthoodWeeks;
    }

    public void setAgeOfAdulthood(Integer ageOfAdulthood) {
        this.ageOfAdulthoodWeeks = ageOfAdulthood;
    }

    public Double getWeightGainPerWeekKg() {
        return weightGainPerWeekKg;
    }

    public void setWeightGainPerWeekKg(Double weightGainPerWeekKg) {
        this.weightGainPerWeekKg = weightGainPerWeekKg;
    }

    public String getAcceptedFood() {
        return acceptedFood;
    }

    public void setAcceptedFood(String acceptedFood) {
        this.acceptedFood = acceptedFood;
    }

    public Integer getAgeOfAdulthoodWeeks() {
        return ageOfAdulthoodWeeks;
    }

    public void setAgeOfAdulthoodWeeks(Integer ageOfAdulthoodWeeks) {
        this.ageOfAdulthoodWeeks = ageOfAdulthoodWeeks;
    }

    public Double getWeightInKg() {
        return weightInKg;
    }

    public void setWeightInKg(Double weightInKg) {
        this.weightInKg = weightInKg;
    }

    public Double getFoodEatenPerWeek() {
        return foodEatenPerWeek;
    }

    public void setFoodEatenPerWeek(Double foodEatenPerWeek) {
        this.foodEatenPerWeek = foodEatenPerWeek;
    }

    public Integer getBreedingChance() {
        return breedingChance;
    }

    public void setBreedingChance(Integer breedingChance) {
        this.breedingChance = breedingChance;
    }

    public String getBuildingNeeded() {
        return buildingNeeded;
    }

    public void setBuildingNeeded(String buildingNeeded) {
        this.buildingNeeded = buildingNeeded;
    }

    public Double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(Double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Integer getNumberOfAnimal() {
        return numberOfAnimal;
    }

    public void setNumberOfAnimal(Integer numberOfAnimal) {
        this.numberOfAnimal = numberOfAnimal;
    }

    public Double getAnimalProductPrice() {
        return animalProductPrice;
    }

    public void setAnimalProductPrice(Double animalProductPrice) {
        this.animalProductPrice = animalProductPrice;
    }

    public void ageChange() {
        this.ageWeeks = this.ageWeeks + 1;
        if (this.ageWeeks < this.ageOfAdulthoodWeeks)
            this.weightInKg = this.weightInKg + this.weightGainPerWeekKg;
        if (this.ageWeeks == this.ageOfAdulthoodWeeks)
            this.isAdult = true;
    }

    public void reproduce() {//TODO
        if (this.ageWeeks >= this.ageOfAdulthoodWeeks) {

        }
    }

    public void eat(Farm farm, List<Chicken> chickenList, List<Cow> cowList, List<Goat> goatList, List<Goose> gooseList, List<Pig> pigList, List<Sheep> sheepList, List<Turkey> turkeyList) {
        Double chickenFoodNeed = 0.0, cowFoodNeed = 0.0, goatFoodNeed = 0.0, gooseFoodNeed = 0.0, sheepFoodNeed = 0.0, turkeyFoodNeed = 0.0, pigFoodNeed = 0.0;
        if (!chickenList.isEmpty()) {
            chickenFoodNeed = chickenList.get(0).getFoodEatenPerWeek() * howManyChickenInList(chickenList);
        }
        if (!chickenList.isEmpty()) {
            cowFoodNeed = cowList.get(0).getFoodEatenPerWeek() * howManyCowInList(cowList);
        }
        if (!chickenList.isEmpty()) {
            goatFoodNeed = goatList.get(0).getFoodEatenPerWeek() * howManyGoatInList(goatList);
        }
        if (!chickenList.isEmpty()) {
            gooseFoodNeed = gooseList.get(0).getFoodEatenPerWeek() * howManyGooseInList(gooseList);
        }
        if (!chickenList.isEmpty()) {
            sheepFoodNeed = sheepList.get(0).getFoodEatenPerWeek() * howManySheepInList(sheepList);
        }
        if (!chickenList.isEmpty()) {
            turkeyFoodNeed = turkeyList.get(0).getFoodEatenPerWeek() * howManyTurkeyInList(turkeyList);
        }
        if (!chickenList.isEmpty()) {
            pigFoodNeed = pigList.get(0).getFoodEatenPerWeek() * howManyPigInList(pigList);
        }

        if (farm.getCorn().getStoredInKg() >= chickenFoodNeed && chickenFoodNeed > 0) {
            System.out.println("Kury zjadły " + chickenFoodNeed + "kg kukurydzy.");
            farm.setCorn(-chickenFoodNeed);
        } else {
            for (int i = 0; i < chickenList.size(); i++) {
                if (chickenList.get(i).getWeightInKg() > 0.5) {
                    chickenList.get(i).setWeightInKg(chickenList.get(i).getWeightInKg() - 0.01);
                    System.out.println("Kup kukurydzę. Kwoje kurczaki nie mają wystarczającej ilości i zaczęły chudnąć.");
                }
            }
        }
        if (farm.getWinterWheat().getStoredInKg() >= cowFoodNeed && cowFoodNeed > 0) {
            System.out.println("Krowy zjadły " + cowFoodNeed + "kg pszenicy ozimej.");
            farm.setWinterWheat(-cowFoodNeed);
        } else {
            for (int i = 0; i < cowList.size(); i++) {
                if (cowList.get(i).getWeightInKg() > 45.0) {
                    cowList.get(i).setWeightInKg(cowList.get(i).getWeightInKg() - 0.05);
                    System.out.println("Kup pszenicę ozimą. Kwoje krowy nie mają wystarczającej ilości i zaczęły chudnąć.");
                }
            }
        }
        if (farm.getSpringBarley().getStoredInKg() >= goatFoodNeed + gooseFoodNeed + sheepFoodNeed + turkeyFoodNeed && goatFoodNeed + gooseFoodNeed + sheepFoodNeed + turkeyFoodNeed > 0) {
            System.out.println("Kozy, gęsi, owce i indyki zjadły razem " + goatFoodNeed + gooseFoodNeed + sheepFoodNeed + turkeyFoodNeed + "kg jęczmienia jarego.");
            farm.setSpringBarley(-(goatFoodNeed + gooseFoodNeed + sheepFoodNeed + turkeyFoodNeed));
        } else {
            for (int i = 0; i < goatList.size(); i++) {
                if (goatList.get(i).getWeightInKg() > 34.0) {
                    goatList.get(i).setWeightInKg(goatList.get(i).getWeightInKg() - 0.03);
                    System.out.println("Kup jęczmień jary. Kwoje kozy nie mają wystarczającej ilości i zaczęły chudnąć.");
                }
            }
            for (int i = 0; i < gooseList.size(); i++) {
                if (gooseList.get(i).getWeightInKg() > 1.0) {
                    gooseList.get(i).setWeightInKg(gooseList.get(i).getWeightInKg() - 0.007);
                    System.out.println("Kup jęczmień jary. Kwoje gęsi nie mają wystarczającej ilości i zaczęły chudnąć.");
                }
            }
            for (int i = 0; i < sheepList.size(); i++) {
                if (sheepList.get(i).getWeightInKg() > 14.0) {
                    sheepList.get(i).setWeightInKg(sheepList.get(i).getWeightInKg() - 0.02);
                    System.out.println("Kup jęczmień jary. Kwoje owce nie mają wystarczającej ilości i zaczęły chudnąć.");
                }
            }
            for (int i = 0; i < turkeyList.size(); i++) {
                if (turkeyList.get(i).getWeightInKg() > 0.8) {
                    turkeyList.get(i).setWeightInKg(turkeyList.get(i).getWeightInKg() - 0.006);
                    System.out.println("Kup jęczmień jary. Kwoje indyki nie mają wystarczającej ilości i zaczęły chudnąć.");
                }
            }
        }
        if (farm.getLatePotato().getStoredInKg() >= pigFoodNeed && pigFoodNeed > 0) {
            System.out.println("Świnie zjadły " + pigFoodNeed + "kg późnych ziemniaków.");
            farm.setLatePotato(-pigFoodNeed);
        } else {
            for (int i = 0; i < chickenList.size(); i++) {
                if (chickenList.get(i).getWeightInKg() > 16.0) {
                    chickenList.get(i).setWeightInKg(chickenList.get(i).getWeightInKg() - 0.02);
                    System.out.println("Kup późne ziemniaki. Kwoje świnie nie mają wystarczającej ilości i zaczęły chudnąć.");
                }
            }
        }
    }

    public  Integer howManyChickenInList(List<Chicken> list) {
        Integer numberOfAnimals = 0;
        for (int i = 0; i < list.size(); i++) {
            numberOfAnimals = numberOfAnimals + list.get(i).getNumberOfAnimal();
        }
        return numberOfAnimals;
    }

    public Integer howManyAdultChickenInList(List<Chicken> list) {
        Integer numberOfAdultAnimals = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAgeOfAdulthoodWeeks() <= list.get(i).getAgeWeeks()) {
                numberOfAdultAnimals = numberOfAdultAnimals + this.getNumberOfAnimal();
            }
        }
        return numberOfAdultAnimals;
    }

    public Integer howManyCowInList(List<Cow> list) {
        Integer numberOfAnimals = 0;
        for (int i = 0; i < list.size(); i++) {
            numberOfAnimals = numberOfAnimals + list.get(i).getNumberOfAnimal();
        }
        return numberOfAnimals;
    }

    public Integer howManyAdultCowInList(List<Cow> list) {
        Integer numberOfAdultAnimals = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAgeOfAdulthoodWeeks() <= list.get(i).getAgeWeeks()) {
                numberOfAdultAnimals = numberOfAdultAnimals + this.getNumberOfAnimal();
            }
        }
        return numberOfAdultAnimals;
    }

    public Integer howManyGoatInList(List<Goat> list) {
        Integer numberOfAnimals = 0;
        for (int i = 0; i < list.size(); i++) {
            numberOfAnimals = numberOfAnimals + list.get(i).getNumberOfAnimal();
        }
        return numberOfAnimals;
    }

    public Integer howManyAdultGoatInList(List<Goat> list) {
        Integer numberOfAdultAnimals = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAgeOfAdulthoodWeeks() <= list.get(i).getAgeWeeks()) {
                numberOfAdultAnimals = numberOfAdultAnimals + this.getNumberOfAnimal();
            }
        }
        return numberOfAdultAnimals;
    }

    public Integer howManyGooseInList(List<Goose> list) {
        Integer numberOfAnimals = 0;
        for (int i = 0; i < list.size(); i++) {
            numberOfAnimals = numberOfAnimals + list.get(i).getNumberOfAnimal();
        }
        return numberOfAnimals;
    }

    public Integer howManyAdultGooseInList(List<Goose> list) {
        Integer numberOfAdultAnimals = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAgeOfAdulthoodWeeks() <= list.get(i).getAgeWeeks()) {
                numberOfAdultAnimals = numberOfAdultAnimals + this.getNumberOfAnimal();
            }
        }
        return numberOfAdultAnimals;
    }


    public Integer howManyPigInList(List<Pig> list) { //TODO sprawdza po sprzedaży i zakupie
        Integer numberOfAnimals = 0;
        for (int i = 0; i < list.size(); i++) {
            numberOfAnimals = numberOfAnimals + list.get(i).getNumberOfAnimal();
        }
        return numberOfAnimals;
    }

    public Integer howManyAdultPigInList(List<Pig> list) {//TODO sprawdza po sprzedaży i zakupie
        Integer numberOfAdultAnimals = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAgeOfAdulthoodWeeks() <= list.get(i).getAgeWeeks()) {
                numberOfAdultAnimals = numberOfAdultAnimals + this.numberOfAnimal;
            }
        }
        return numberOfAdultAnimals;
    }

    public Integer howManySheepInList(List<Sheep> list) {
        Integer numberOfAnimals = 0;
        for (int i = 0; i < list.size(); i++) {
            numberOfAnimals = numberOfAnimals + list.get(i).getNumberOfAnimal();
        }
        return numberOfAnimals;
    }

    public Integer howManyAdultSheepInList(List<Sheep> list) {
        Integer numberOfAdultAnimals = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAgeOfAdulthoodWeeks() <= list.get(i).getAgeWeeks()) {
                numberOfAdultAnimals = numberOfAdultAnimals + this.getNumberOfAnimal();
            }
        }
        return numberOfAdultAnimals;
    }

    public Integer howManyTurkeyInList(List<Turkey> list) {
        Integer numberOfAnimals = 0;
        for (int i = 0; i < list.size(); i++) {
            numberOfAnimals = numberOfAnimals + list.get(i).getNumberOfAnimal();
        }
        return numberOfAnimals;
    }

    public Integer howManyAdultTurkeyInList(List<Turkey> list) {
        Integer numberOfAdultAnimals = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAgeOfAdulthoodWeeks() <= list.get(i).getAgeWeeks()) {
                numberOfAdultAnimals = numberOfAdultAnimals + this.getNumberOfAnimal();
            }
        }
        return numberOfAdultAnimals;
    }


}

