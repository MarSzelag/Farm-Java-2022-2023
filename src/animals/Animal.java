package animals;

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

    public void canAnimalEatIt(){

    }

    public void breed(){

    }

    public void numberOfAdultAnimals(){

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

    public void ageChange(){
        this.ageWeeks = this.ageWeeks + 1;
        if(this.ageWeeks < this.ageOfAdulthoodWeeks)
            this.weightInKg = this.weightInKg + this.weightGainPerWeekKg;
        if(this.ageWeeks == this.ageOfAdulthoodWeeks)
            this.isAdult = true;
    }

    public void reproduce(){//TODO
        if(this.ageWeeks >= this.ageOfAdulthoodWeeks){

        }
    }

    public Integer howManyChickenInList(List<Chicken> list){
        Integer numberOfAnimals = 0;
        for(int i = 0; i < list.size(); i++){
            numberOfAnimals = numberOfAnimals + list.get(i).getNumberOfAnimal();
        }
        return numberOfAnimals;
    }

    public Integer howManyAdultChickenInList(List<Chicken> list){
        Integer numberOfAdultAnimals = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getAgeOfAdulthoodWeeks() <= list.get(i).getAgeWeeks()) {
                numberOfAdultAnimals = numberOfAdultAnimals + this.getNumberOfAnimal();
            }
        }
        return numberOfAdultAnimals;
    }
    public Integer howManyCowInList(List<Cow> list){
        Integer numberOfAnimals = 0;
        for(int i = 0; i < list.size(); i++){
            numberOfAnimals = numberOfAnimals + list.get(i).getNumberOfAnimal();
        }
        return numberOfAnimals;
    }

    public Integer howManyAdultCowInList(List<Cow> list){
        Integer numberOfAdultAnimals = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getAgeOfAdulthoodWeeks() <= list.get(i).getAgeWeeks()) {
                numberOfAdultAnimals = numberOfAdultAnimals + this.getNumberOfAnimal();
            }
        }
        return numberOfAdultAnimals;
    }
    public Integer howManyGoatInList(List<Goat> list){
        Integer numberOfAnimals = 0;
        for(int i = 0; i < list.size(); i++){
            numberOfAnimals = numberOfAnimals + list.get(i).getNumberOfAnimal();
        }
        return numberOfAnimals;
    }

    public Integer howManyAdultGoatInList(List<Goat> list){
        Integer numberOfAdultAnimals = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getAgeOfAdulthoodWeeks() <= list.get(i).getAgeWeeks()) {
                numberOfAdultAnimals = numberOfAdultAnimals + this.getNumberOfAnimal();
            }
        }
        return numberOfAdultAnimals;
    }
    public Integer howManyGooseInList(List<Goose> list){
        Integer numberOfAnimals = 0;
        for(int i = 0; i < list.size(); i++){
            numberOfAnimals = numberOfAnimals + list.get(i).getNumberOfAnimal();
        }
        return numberOfAnimals;
    }

    public Integer howManyAdultGooseInList(List<Goose> list){
        Integer numberOfAdultAnimals = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getAgeOfAdulthoodWeeks() <= list.get(i).getAgeWeeks()) {
                numberOfAdultAnimals = numberOfAdultAnimals + this.getNumberOfAnimal();
            }
        }
        return numberOfAdultAnimals;
    }


    public Integer howManyPigInList(List<Pig> list){ //TODO sprawdza po sprzedaży i zakupie
        Integer numberOfAnimals = 0;
        for(int i = 0; i < list.size(); i++){
            numberOfAnimals = numberOfAnimals + list.get(i).getNumberOfAnimal();
        }
        return numberOfAnimals;
    }

    public Integer howManyAdultPigInList(List<Pig> list){//TODO sprawdza po sprzedaży i zakupie
        Integer numberOfAdultAnimals = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getAgeOfAdulthoodWeeks() <= list.get(i).getAgeWeeks()) {
                numberOfAdultAnimals = numberOfAdultAnimals + this.numberOfAnimal;
            }
        }
        return numberOfAdultAnimals;
    }

    public Integer howManySheepInList(List<Sheep> list){
        Integer numberOfAnimals = 0;
        for(int i = 0; i < list.size(); i++){
            numberOfAnimals = numberOfAnimals + list.get(i).getNumberOfAnimal();
        }
        return numberOfAnimals;
    }

    public Integer howManyAdultSheepInList(List<Sheep> list){
        Integer numberOfAdultAnimals = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getAgeOfAdulthoodWeeks() <= list.get(i).getAgeWeeks()) {
                numberOfAdultAnimals = numberOfAdultAnimals + this.getNumberOfAnimal();
            }
        }
        return numberOfAdultAnimals;
    }
    public Integer howManyTurkeyInList(List<Turkey> list){
        Integer numberOfAnimals = 0;
        for(int i = 0; i < list.size(); i++){
            numberOfAnimals = numberOfAnimals + list.get(i).getNumberOfAnimal();
        }
        return numberOfAnimals;
    }

    public Integer howManyAdultTurkeyInList(List<Turkey> list){
        Integer numberOfAdultAnimals = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getAgeOfAdulthoodWeeks() <= list.get(i).getAgeWeeks()) {
                numberOfAdultAnimals = numberOfAdultAnimals + this.getNumberOfAnimal();
            }
        }
        return numberOfAdultAnimals;
    }


}

