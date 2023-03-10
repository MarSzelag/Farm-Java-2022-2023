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

    private Integer storedInKg;

   // private Integer growTime; // Czas, jaki potrzebuje roślina do osiągnięcia dojrzałej formy.
    // private Integer age; // Obecny wiek zasadzonej rośliny.


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
}
