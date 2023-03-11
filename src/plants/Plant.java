package plants;

public class Plant {

    private String plantName;
    private Integer neededToSowOneHaInKg;
    private Integer harvestsFromHaKg; // Wydajność upraw w kg z ha.

    private Integer sowingTimeFromWeek; // Czas obsiewu od. 4 pory roku, 12 miesięcy, czy 52 tygodnie?
    private Integer sowingTimeToWeek; // Czas obsiewu do.
    private Integer harvestTimeFromWeek;
    private Integer harvestTimeToWeek;

    private Double SellPricePerKg; // Cena sprzedaży kilograma
    private Double BuyPricePerKg;

    private Integer storedInKg = 0;

   // private Integer growTime; // Czas, jaki potrzebuje roślina do osiągnięcia dojrzałej formy.
    // private Integer age; // Obecny wiek zasadzonej rośliny.

    public Plant(){

    }
    public Plant(String plantName, Integer neededToSowOneHaInKg, Integer harvestsFromHa, Integer sowingTimeFromWeek, Integer sowingTimeToWeek, Integer harvestTimeFromWeek, Integer harvestTimeToWeek, Double sellPricePerKg, Double buyPricePerKg) {
        this.plantName = plantName;
        this.neededToSowOneHaInKg = neededToSowOneHaInKg;
        this.harvestsFromHaKg = harvestsFromHa;
        this.sowingTimeFromWeek = sowingTimeFromWeek;
        this.sowingTimeToWeek = sowingTimeToWeek;
        this.harvestTimeFromWeek = harvestTimeFromWeek;
        this.harvestTimeToWeek = harvestTimeToWeek;
        this.SellPricePerKg = sellPricePerKg;
        this.BuyPricePerKg = buyPricePerKg;
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

    public Integer getHarvestTimeFromWeek() {
        return harvestTimeFromWeek;
    }

    public void setHarvestTimeFromWeek(Integer harvestTimeFromWeek) {
        this.harvestTimeFromWeek = harvestTimeFromWeek;
    }

    public Integer getHarvestTimeToWeek() {
        return harvestTimeToWeek;
    }

    public void setHarvestTimeToWeek(Integer harvestTimeToWeek) {
        this.harvestTimeToWeek = harvestTimeToWeek;
    }

    public Double getSellPricePerKg() {
        return SellPricePerKg;
    }

    public void setSellPricePerKg(Double sellPricePerKg) {
        SellPricePerKg = sellPricePerKg;
    }

    public Double getBuyPricePerKg() {
        return BuyPricePerKg;
    }

    public void setBuyPricePerKg(Double buyPricePerKg) {
        BuyPricePerKg = buyPricePerKg;
    }

    public Integer getStoredInKg() {
        return storedInKg;
    }

    public void setStoredInKg(Integer storedInKg) {
        this.storedInKg = storedInKg;
    }
}
