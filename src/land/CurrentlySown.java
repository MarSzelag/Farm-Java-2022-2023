package land;

public class CurrentlySown {
    private String name;
    private Integer numberOfHaSown;
    private Integer timeToHarvest;
    private Double eventsModificator;

    public CurrentlySown(String name, Integer numberOfHaSown, Integer timeToHarvest, Double eventsModificator) {
        this.name = name;
        this.numberOfHaSown = numberOfHaSown;
        this.timeToHarvest = timeToHarvest;
        this.eventsModificator = eventsModificator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfHaSown() {
        return numberOfHaSown;
    }

    public void setNumberOfHaSown(Integer numberOfHaSown) {
        this.numberOfHaSown = numberOfHaSown;
    }

    public Integer getTimeToHarvest() {
        return timeToHarvest;
    }

    public void setTimeToHarvest(Integer timeToHarvest) {
        this.timeToHarvest = timeToHarvest;
    }

    public Double getEventsModificator() {
        return eventsModificator;
    }

    public void setEventsModificator(Double eventsModificator) {
        this.eventsModificator = eventsModificator;
    }
}
