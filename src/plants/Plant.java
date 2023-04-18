package plants;

public class Plant {

    private String plantName;
    private Integer neededToSowOneHaInKg;
    private Integer harvestsFromHaKg;

    private Integer sowingTimeFromWeek;
    private Integer sowingTimeToWeek;
    private Integer harvestTimeAfterNoWeeks;
    private Integer noOfWeeksLeftToHavest;

    private Double sellPricePerKg;
    private Double buyPricePerKg;

    private Double landPreparationCostPerHa;
    private Double protectionAgainstPestsPerHa;

    private Double storedInKg = 0.00;

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
        this.protectionAgainstPestsPerHa = protectionAgainstPests;
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

    public Double getStoredInKg() {
        return storedInKg;
    }

    public void setStoredInKg(Double storedInKg) {
        this.storedInKg = storedInKg;
    }

    public Double getLandPreparationCostPerHa() {
        return landPreparationCostPerHa;
    }

    public void setLandPreparationCostPerHa(Double landPreparationCostPerHa) {
        this.landPreparationCostPerHa = landPreparationCostPerHa;
    }

    public Double getProtectionAgainstPests() {
        return protectionAgainstPestsPerHa;
    }

    public void setProtectionAgainstPests(Double protectionAgainstPests) {
        this.protectionAgainstPestsPerHa = protectionAgainstPests;
    }



}
