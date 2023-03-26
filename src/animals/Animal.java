package animals;

import java.util.List;

public class Animal {
    private String race;
    private Integer age;
    private Integer ageOfAdulthood;
    private Double weightGainPerWeek;
    private List<String> acceptedFood; //TODO Maybe list of objects and then check if it is this type of food?
    private Double breedingChance;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAgeOfAdulthood() {
        return ageOfAdulthood;
    }

    public void setAgeOfAdulthood(Integer ageOfAdulthood) {
        this.ageOfAdulthood = ageOfAdulthood;
    }

    public Double getWeightGainPerWeek() {
        return weightGainPerWeek;
    }

    public void setWeightGainPerWeek(Double weightGainPerWeek) {
        this.weightGainPerWeek = weightGainPerWeek;
    }

    public List<String> getAcceptedFood() {
        return acceptedFood;
    }

    public void setAcceptedFood(List<String> acceptedFood) {
        this.acceptedFood = acceptedFood;
    }

    public Double getBreedingChance() {
        return breedingChance;
    }

    public void setBreedingChance(Double breedingChance) {
        this.breedingChance = breedingChance;
    }
}

