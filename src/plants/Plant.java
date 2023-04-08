package plants;

import farm.Farm;

import java.util.Date;
import java.util.Scanner;

public class Plant {

    private String plantName;
    private Integer neededToSowOneHaInKg;
    private Integer harvestsFromHaKg; // Wydajność upraw w kg z ha.

    private Integer sowingTimeFromWeek; // Czas obsiewu od. 4 pory roku, 12 miesięcy, czy 52 tygodnie?
    private Integer sowingTimeToWeek; // Czas obsiewu do.
    private Integer harvestTimeAfterNoWeeks;
    private Integer noOfWeeksLeftToHavest;

    private Double sellPricePerKg; // Cena sprzedaży kilograma
    private Double buyPricePerKg;

    private Double landPreparationCostPerHa;
    private Double protectionAgainstPests;

    //private boolean isSownAlready;

    private Integer storedInKg = 0;

    // private Integer growTime; // Czas, jaki potrzebuje roślina do osiągnięcia dojrzałej formy.
    // private Integer age; // Obecny wiek zasadzonej rośliny.

    public Plant() {

    }

    public Plant(String plantName, Integer neededToSowOneHaInKg, Integer harvestsFromHa, Integer sowingTimeFromWeek, Integer sowingTimeToWeek, Integer harvestTimeAfterNoWeeks, Double sellPricePerKg, Double buyPricePerKg, Double landPreparationCostPerHa, Double protectionAgainstPests) {
        this.plantName = plantName;
        this.neededToSowOneHaInKg = neededToSowOneHaInKg;
        this.harvestsFromHaKg = harvestsFromHa;
        this.sowingTimeFromWeek = sowingTimeFromWeek;
        this.sowingTimeToWeek = sowingTimeToWeek;
        this.harvestTimeAfterNoWeeks = harvestTimeAfterNoWeeks;
        this.sellPricePerKg = sellPricePerKg;
        this.buyPricePerKg = buyPricePerKg;
        this.landPreparationCostPerHa = landPreparationCostPerHa;
        this.protectionAgainstPests = protectionAgainstPests;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public Integer getNeededToSowOneHaInKg() {
        return neededToSowOneHaInKg;
    }

    public void setNeededToSowOneHaInKg(Integer neededToSowOneHaInKg) {
        this.neededToSowOneHaInKg = neededToSowOneHaInKg;
    }

    public Integer getHarvestsFromHaKg() {
        return harvestsFromHaKg;
    }

    public void setHarvestsFromHaKg(Integer harvestsFromHaKg) {
        this.harvestsFromHaKg = harvestsFromHaKg;
    }

    public Integer getSowingTimeFromWeek() {
        return sowingTimeFromWeek;
    }

    public void setSowingTimeFromWeek(Integer sowingTimeFromWeek) {
        this.sowingTimeFromWeek = sowingTimeFromWeek;
    }

    public Integer getSowingTimeToWeek() {
        return sowingTimeToWeek;
    }

    public void setSowingTimeToWeek(Integer sowingTimeToWeek) {
        this.sowingTimeToWeek = sowingTimeToWeek;
    }

    public Integer getHarvestTimeAfterNoWeeks() {
        return harvestTimeAfterNoWeeks;
    }

    public void setHarvestTimeAfterNoWeeks(Integer harvestTimeAfterNoWeeks) {
        this.harvestTimeAfterNoWeeks = harvestTimeAfterNoWeeks;
    }

    public Integer getNoOfWeeksLeftToHavest() {
        return noOfWeeksLeftToHavest;
    }

    public void setNoOfWeeksLeftToHavest(Integer noOfWeeksLeftToHavest) {
        this.noOfWeeksLeftToHavest = noOfWeeksLeftToHavest;
    }

    public Double getSellPricePerKg() {
        return sellPricePerKg;
    }

    public void setSellPricePerKg(Double sellPricePerKg) {
        sellPricePerKg = sellPricePerKg;
    }

    public Double getBuyPricePerKg() {
        return buyPricePerKg;
    }

    public void setBuyPricePerKg(Double buyPricePerKg) {
        buyPricePerKg = buyPricePerKg;
    }

    public Integer getStoredInKg() {
        return storedInKg;
    }

    public void setStoredInKg(Integer storedInKg) {
        this.storedInKg = storedInKg;
    }

    public Double getLandPreparationCostPerHa() {
        return landPreparationCostPerHa;
    }

    public void setLandPreparationCostPerHa(Double landPreparationCostPerHa) {
        this.landPreparationCostPerHa = landPreparationCostPerHa;
    }

    public Double getProtectionAgainstPests() {
        return protectionAgainstPests;
    }
/*
    public boolean isSownAlready() {
        return isSownAlready;
    }

    public void setSownAlready(boolean sownAlready) {
        isSownAlready = sownAlready;
    }*/

    public void setProtectionAgainstPests(Double protectionAgainstPests) {
        this.protectionAgainstPests = protectionAgainstPests;
    }



}
