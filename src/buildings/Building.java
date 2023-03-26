package buildings;

public class Building {
    private String name;
    private String storedGoods;
    private Integer quantityOfThisBuildingType = 0;
    private Integer capacityOfOneBuilding;

    private Double price;

    public Building(String name, String storedGoods, Integer capacityOfOneBuilding, Double price) {
        this.name = name;
        this.storedGoods = storedGoods;
        this.capacityOfOneBuilding = capacityOfOneBuilding;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStoredGoods() {
        return storedGoods;
    }

    public void setStoredGoods(String storedGoods) {
        this.storedGoods = storedGoods;
    }

    public Integer getQuantityOfThisBuildingType() {
        return quantityOfThisBuildingType;
    }

    public void setQuantityOfThisBuildingType(Integer quantityOfThisBuildingType) {
        this.quantityOfThisBuildingType = quantityOfThisBuildingType;
    }

    public Integer getCapacityOfOneBuilding() {
        return capacityOfOneBuilding;
    }

    public void setCapacityOfOneBuilding(Integer capacityOfOneBuilding) {
        this.capacityOfOneBuilding = capacityOfOneBuilding;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer totalCapacity(){
        return this.quantityOfThisBuildingType * this.capacityOfOneBuilding;
    }

}


/*
barn - zboża
chickenCoop - kury
cowShed - krowy
pigsty - świnie
 */
// magazyn, silos, stodoła, obora, kurnik, garaź
