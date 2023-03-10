package plants;

public class Corn extends Plant{

    public Corn(String plantName, Integer neededToSowOneHaInKg, Integer harvestsFromHaKg, Integer sowingTimeFromWeek, Integer sowingTimeToWeek, Integer harvestTimeFromWeek, Integer harvestTimeToWeek, Double sellPricePerKg, Double buyPricePerKg) {
        super(plantName, neededToSowOneHaInKg, harvestsFromHaKg, sowingTimeFromWeek, sowingTimeToWeek, harvestTimeFromWeek, harvestTimeToWeek, sellPricePerKg, buyPricePerKg);
    }
}
