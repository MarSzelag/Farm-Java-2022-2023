package animals;

import farm.Farm;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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
        if (this.ageWeeks >= this.ageOfAdulthoodWeeks)
            this.isAdult = true;
    }

    public void reproduce(Farm farm, List<Chicken> chickenList, List<Cow> cowList, List<Goat> goatList, List<Goose> gooseList, List<Pig> pigList, List<Sheep> sheepList, List<Turkey> turkeyList) {
        Random rand = new Random();
        Integer number = 0;
        Integer newbornTemp = 0;
        if (!chickenList.isEmpty() && farm.getTotalNumberOfAdultChicken() > 1) {
            for (int i = 1; i <= farm.getTotalNumberOfAdultChicken(); i++) {
                number = rand.nextInt(chickenList.get(0).getBreedingChance());
                if (number == 1) {
                    newbornTemp++;
                }
            }
            if (newbornTemp > 0) {
                Chicken chicken = new Chicken();
                chicken.setNumberOfAnimal(newbornTemp);
                chickenList.add(chicken);
                System.out.println("Narodziło się " + newbornTemp + " nowych kur.");
                newbornTemp = 0;
            }
        }
        if (!cowList.isEmpty() && farm.getTotalNumberOfAdultCow() > 1) {
            for (int i = 1; i <= farm.getTotalNumberOfAdultCow(); i++) {
                number = rand.nextInt(cowList.get(0).getBreedingChance());
                if (number == 1) {
                    newbornTemp++;
                }
            }
            if (newbornTemp > 0) {
                Cow cow = new Cow();
                cow.setNumberOfAnimal(newbornTemp);
                cowList.add(cow);
                System.out.println("Narodziło się " + newbornTemp + " nowych krów.");
                newbornTemp = 0;
            }
        }
        if (!goatList.isEmpty() && farm.getTotalNumberOfAdultGoat() > 1) {
            for (int i = 1; i <= farm.getTotalNumberOfAdultGoat(); i++) {
                number = rand.nextInt(goatList.get(0).getBreedingChance());
                if (number == 1) {
                    newbornTemp++;
                }
            }
            if (newbornTemp > 0) {
                Goat goat = new Goat();
                goat.setNumberOfAnimal(newbornTemp);
                goatList.add(goat);
                System.out.println("Narodziło się " + newbornTemp + " nowych kóz.");
                newbornTemp = 0;
            }
        }
        if (!gooseList.isEmpty() && farm.getTotalNumberOfAdultGoose() > 1) {
            for (int i = 1; i <= farm.getTotalNumberOfAdultGoose(); i++) {
                number = rand.nextInt(gooseList.get(0).getBreedingChance());
                if (number == 1) {
                    newbornTemp++;
                }
            }
            if (newbornTemp > 0) {
                Goose goose = new Goose();
                goose.setNumberOfAnimal(newbornTemp);
                gooseList.add(goose);
                System.out.println("Narodziło się " + newbornTemp + " nowych gęsi.");
                newbornTemp = 0;
            }
        }
        if (!pigList.isEmpty() && farm.getTotalNumberOfAdultPig() > 1) {
            for (int i = 1; i <= farm.getTotalNumberOfAdultPig(); i++) {
                number = rand.nextInt(pigList.get(0).getBreedingChance());
                if (number == 1) {
                    newbornTemp++;
                }
            }
            if (newbornTemp > 0) {
                Pig pig = new Pig();
                pig.setNumberOfAnimal(newbornTemp);
                pigList.add(pig);
                System.out.println("Narodziło się " + newbornTemp + " nowych świń.");
                newbornTemp = 0;
            }
        }
        if (!sheepList.isEmpty() && farm.getTotalNumberOfAdultSheep() > 1) {
            for (int i = 1; i <= farm.getTotalNumberOfAdultSheep(); i++) {
                number = rand.nextInt(sheepList.get(0).getBreedingChance());
                if (number == 1) {
                    newbornTemp++;
                }
            }
            if (newbornTemp > 0) {
                Sheep sheep = new Sheep();
                sheep.setNumberOfAnimal(newbornTemp);
                sheepList.add(sheep);
                System.out.println("Narodziło się " + newbornTemp + " nowych owiec.");
                newbornTemp = 0;
            }
        }
        if (!turkeyList.isEmpty() && farm.getTotalNumberOfAdultTurkey() > 1) {
            for (int i = 1; i <= farm.getTotalNumberOfAdultTurkey(); i++) {
                number = rand.nextInt(turkeyList.get(0).getBreedingChance());
                if (number == 1) {
                    newbornTemp++;
                }
            }
            if (newbornTemp > 0) {
                Turkey turkey = new Turkey();
                turkey.setNumberOfAnimal(newbornTemp);
                turkeyList.add(turkey);
                System.out.println("Narodziło się " + newbornTemp + " nowych indyków.");
                newbornTemp = 0;
            }
        }

    }

    public void eat(Farm farm, List<Chicken> chickenList, List<Cow> cowList, List<Goat> goatList, List<Goose> gooseList, List<Pig> pigList, List<Sheep> sheepList, List<Turkey> turkeyList) {
        Double chickenFoodNeed = 0.0, cowFoodNeed = 0.0, goatFoodNeed = 0.0, gooseFoodNeed = 0.0, sheepFoodNeed = 0.0, turkeyFoodNeed = 0.0, pigFoodNeed = 0.0;
        if (!chickenList.isEmpty()) {
            chickenFoodNeed = chickenList.get(0).getFoodEatenPerWeek() * farm.getTotalNumberOfChicken();
        }
        if (!cowList.isEmpty()) {
            cowFoodNeed = cowList.get(0).getFoodEatenPerWeek() * farm.getTotalNumberOfCow();
        }
        if (!goatList.isEmpty()) {
            goatFoodNeed = goatList.get(0).getFoodEatenPerWeek() * farm.getTotalNumberOfGoat();
        }
        if (!gooseList.isEmpty()) {
            gooseFoodNeed = gooseList.get(0).getFoodEatenPerWeek() * farm.getTotalNumberOfGoose();
        }
        if (!pigList.isEmpty()) {
            pigFoodNeed = pigList.get(0).getFoodEatenPerWeek() * farm.getTotalNumberOfPig();
        }
        if (!sheepList.isEmpty()) {
            sheepFoodNeed = sheepList.get(0).getFoodEatenPerWeek() * farm.getTotalNumberOfSheep();
        }
        if (!turkeyList.isEmpty()) {
            turkeyFoodNeed = turkeyList.get(0).getFoodEatenPerWeek() * farm.getTotalNumberOfTurkey();
        }

        if (farm.getCorn().getStoredInKg() >= chickenFoodNeed && farm.getTotalNumberOfChicken() > 0) {
            System.out.println("Kury zjadły " + chickenFoodNeed + "kg kukurydzy.");
            farm.setCorn(farm.getCorn().getStoredInKg() - chickenFoodNeed);
        } else if (farm.getCorn().getStoredInKg() < chickenFoodNeed) {//TODO ************** skopiować do innych zwierząt.
            for (int i = 0; i < chickenList.size(); i++) {
                if (chickenList.get(i).getWeightInKg() > 0.5) {
                    chickenList.get(i).setWeightInKg(chickenList.get(i).getWeightInKg() - 0.01);
                }
            }
            System.out.println("Kup kukurydzę. Twoje kurczaki nie mają wystarczającej ilości i zaczęły chudnąć.");
            farm.setCorn(0);
        }

        if (farm.getWinterWheat().getStoredInKg() >= cowFoodNeed && farm.getTotalNumberOfCow() > 0) {
            System.out.println("Krowy zjadły " + cowFoodNeed + "kg pszenicy ozimej.");
            farm.setWinterWheat(farm.getWinterWheat().getStoredInKg() - cowFoodNeed);
        } else if(farm.getWinterWheat().getStoredInKg() < cowFoodNeed){
            for (int i = 0; i < cowList.size(); i++) {
                if (cowList.get(i).getWeightInKg() > 45.0) {
                    cowList.get(i).setWeightInKg(cowList.get(i).getWeightInKg() - 0.05);
                }
            }
            System.out.println("Kup pszenicę ozimą. Twoje krowy nie mają wystarczającej ilości i zaczęły chudnąć.");
            farm.setWinterWheat(0);
        }

        Double sumFoodNeed = goatFoodNeed + gooseFoodNeed + sheepFoodNeed + turkeyFoodNeed;
        if (farm.getSpringBarley().getStoredInKg() >= goatFoodNeed + gooseFoodNeed + sheepFoodNeed + turkeyFoodNeed && farm.getTotalNumberOfGoat() + farm.getTotalNumberOfGoose() + farm.getTotalNumberOfSheep() + farm.getTotalNumberOfTurkey() > 0) {
            System.out.println("Kozy, gęsi, owce i indyki zjadły razem " + sumFoodNeed + "kg jęczmienia jarego.");
            farm.setSpringBarley(farm.getSpringBarley().getStoredInKg() - (sumFoodNeed));
        } else if(farm.getSpringBarley().getStoredInKg() < sumFoodNeed){
            for (int i = 0; i < goatList.size(); i++) {
                if (goatList.get(i).getWeightInKg() > 34.0) {
                    goatList.get(i).setWeightInKg(goatList.get(i).getWeightInKg() - 0.03);
                }
            }
            System.out.println("Kup jęczmień jary. Twoje kozy nie mają wystarczającej ilości i zaczęły chudnąć.");

            for (int i = 0; i < gooseList.size(); i++) {
                if (gooseList.get(i).getWeightInKg() > 1.0) {
                    gooseList.get(i).setWeightInKg(gooseList.get(i).getWeightInKg() - 0.007);
                }
            }
            System.out.println("Kup jęczmień jary. Twoje gęsi nie mają wystarczającej ilości i zaczęły chudnąć.");

            for (int i = 0; i < sheepList.size(); i++) {
                if (sheepList.get(i).getWeightInKg() > 14.0) {
                    sheepList.get(i).setWeightInKg(sheepList.get(i).getWeightInKg() - 0.02);
                }
            }
            System.out.println("Kup jęczmień jary. Twoje owce nie mają wystarczającej ilości i zaczęły chudnąć.");

            for (int i = 0; i < turkeyList.size(); i++) {
                if (turkeyList.get(i).getWeightInKg() > 0.8) {
                    turkeyList.get(i).setWeightInKg(turkeyList.get(i).getWeightInKg() - 0.006);
                }
            }
            System.out.println("Kup jęczmień jary. Twoje indyki nie mają wystarczającej ilości i zaczęły chudnąć.");
            farm.setSpringBarley(0);
        }

        if (farm.getLatePotato().getStoredInKg() >= pigFoodNeed && farm.getTotalNumberOfPig() > 0) {
            System.out.println("Świnie zjadły " + pigFoodNeed + "kg późnych ziemniaków.");
            farm.setLatePotato(farm.getLatePotato().getStoredInKg() - pigFoodNeed);
        } else if(farm.getLatePotato().getStoredInKg() < pigFoodNeed){
            for (int i = 0; i < chickenList.size(); i++) {
                if (chickenList.get(i).getWeightInKg() > 16.0) {
                    chickenList.get(i).setWeightInKg(chickenList.get(i).getWeightInKg() - 0.02);
                }
            }
            System.out.println("Kup późne ziemniaki. Twoje świnie nie mają wystarczającej ilości i zaczęły chudnąć.");
            farm.setLatePotato(0);
        }
    }

    public Integer howManyChickenInList(List<Chicken> list) {
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


    public Integer howManyPigInList(List<Pig> list) {
        Integer numberOfAnimals = 0;
        for (int i = 0; i < list.size(); i++) {
            numberOfAnimals = numberOfAnimals + list.get(i).getNumberOfAnimal();
        }
        return numberOfAnimals;
    }

    public Integer howManyAdultPigInList(List<Pig> list) {
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

