package plants;

import farm.Farm;

import java.util.Scanner;

public class Sown {

    private Plant plant;
    private String name;
    private Integer haSown = 0;
    private Integer weeksToHarvest;

    private Double eventsDamages = 1.000;

    public Sown() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeeksToHarvest() {
        return weeksToHarvest;
    }

    public void setWeeksToHarvest(Integer weeksToHarvest) {
        this.weeksToHarvest = weeksToHarvest;
    }

    public Double getEventsDamages() {
        return eventsDamages;
    }

    public void setEventsDamages(Double eventsDamages) {
        this.eventsDamages = eventsDamages;
    }

    public Integer getHaSown() {
        return haSown;
    }

    public void setHaSown(Integer haSown) {
        this.haSown = haSown;
    }

    public Sown addToSown(Plant plant, Farm farm) {
        Sown sown = new Sown();
        Integer haToSow = 0;
        sown.plant = plant;

        sown.weeksToHarvest = plant.getHarvestTimeAfterNoWeeks();
        sown.setName(plant.getPlantName());

        Scanner scan = new Scanner(System.in);
        System.out.println("Masz " + farm.getLand().getFreeLand() + "ha nieobsianej ziemi i " + plant.getStoredInKg() + " kg " + plant.getPlantName() + ". Obsianie 1 ha ziemi wymaga " + plant.getNeededToSowOneHaInKg() + "kg " + plant.getPlantName());
        System.out.println("Na twoim koncie znajduje się " + farm.getCash() + "zł.");
        System.out.println("Koszt przygotowania ziemi i obsiewu wynosi " + plant.getLandPreparationCostPerHa() + "zł, a koszt ochrony roślin " + plant.getProtectionAgainstPests() + "zł za każdy ha obsianej ziemi.");
        System.out.println("Wprowadź 0, aby wyjść.");
        System.out.println("Ile ha " + plant.getPlantName() + " chcesz obsiać?");
        try {
            haToSow = Integer.parseInt(scan.nextLine());
            if (haToSow < 0) {
                System.out.println("Nie można wprowadzać wartości ujemnych. Spróbuj jeszcze raz.");
            } else if (haToSow == 0) {
                sown = null;
            } else if (farm.getCash() < ((plant.getLandPreparationCostPerHa() + plant.getProtectionAgainstPests()) * haToSow)) {
                System.out.println("Nie masz wystarczającej ilości pieniędzy, żeby przygotować ziemię do obsiewu i zapewnić jakiejkolwiek ochrony przed szkodnikami.");
            } else if (farm.getLand().getFreeLand() >= haToSow && farm.getBarn().getCapacityOfOneBuilding() * farm.getBarn().getQuantityOfThisBuildingType() >= (haToSow * plant.getNeededToSowOneHaInKg())) {
                if (farm.getWeekOfYear() >= plant.getSowingTimeFromWeek() && farm.getWeekOfYear() <= plant.getSowingTimeToWeek()) {
                    farm.setCash(farm.getCash() - ((plant.getLandPreparationCostPerHa() + plant.getProtectionAgainstPests()) * haToSow));
                    farm.getLand().setFreeLand(farm.getLand().getFreeLand() - haToSow);
                    farm.getLand().setSownLandInHa(farm.getLand().getSownLandInHa() + haToSow);

                    if (plant instanceof Corn) {
                        farm.getCorn().setStoredInKg(farm.getCorn().getStoredInKg() - haToSow * farm.getCorn().getNeededToSowOneHaInKg());
                    } else if (plant instanceof LatePotato) {
                        farm.getLatePotato().setStoredInKg(farm.getLatePotato().getStoredInKg() - haToSow * farm.getLatePotato().getNeededToSowOneHaInKg());
                    } else if (plant instanceof LateRape) {
                        farm.getLateRape().setStoredInKg(farm.getLateRape().getStoredInKg() - haToSow * farm.getLateRape().getNeededToSowOneHaInKg());
                    } else if (plant instanceof LateRye) {
                        farm.getLateRye().setStoredInKg(farm.getLateRye().getStoredInKg() - haToSow * farm.getLateRye().getNeededToSowOneHaInKg());
                    } else if (plant instanceof SpringBarley) {
                        farm.getSpringBarley().setStoredInKg(farm.getSpringBarley().getStoredInKg() - haToSow * farm.getSpringBarley().getNeededToSowOneHaInKg());
                    } else if (plant instanceof WhiteBeet) {
                        farm.getWhiteBeet().setStoredInKg(farm.getWhiteBeet().getStoredInKg() - haToSow * farm.getWhiteBeet().getNeededToSowOneHaInKg());
                    } else if (plant instanceof WinterWheat) {
                        farm.getWinterWheat().setStoredInKg(farm.getWinterWheat().getStoredInKg() - haToSow * farm.getWinterWheat().getNeededToSowOneHaInKg());
                    } else {
                        System.out.println("Nie wiadomo, jaka to jest roślina.");
                    }
                    sown.haSown = haToSow;
                    System.out.println("Obsiałeś " + haToSow + "ha ziemi.");
                } else {
                    sown = null;
                    System.out.println("Teraz nie da rady tego zasiać. Okres zasiewów jest od " + plant.getSowingTimeFromWeek() + " tygodnia do " + plant.getSowingTimeToWeek() + " tygodnia roku, a obecnie mamy " + farm.getWeekOfYear() + " tydzień.");
                }
            } else
                System.out.println("Sprawdź dokładnie ile ziemi możesz obsiać i czy masz wystarczającą ilość roślin do obsiewu.");
        } catch (NumberFormatException e) {
            System.out.println("Wprowadzono nieprawidłowwe dane.");
        }
        return sown;
    }

    public boolean harvestTime(Farm farm) {
        boolean harvested = false;
        System.out.println("Blablabla");
        if (this.weeksToHarvest == null) {
        } else if (this.weeksToHarvest < -4) {
            farm.getLand().setSownLandInHa(farm.getLand().getSownLandInHa() - this.haSown);
            farm.getLand().setFreeLand(farm.getLand().getFreeLand() + this.haSown);
            harvested = true;
            System.out.println("Niestety, zbiory się zmarnowały.");
        } else if (this.weeksToHarvest <= 0) {
            if (this.plant instanceof Corn) {
                if (farm.getBarn().getCapacityOfOneBuilding() * farm.getBarn().getQuantityOfThisBuildingType() - farm.getBarn().kgOfPlantsStoredInBarn(farm) >= this.haSown * this.plant.getHarvestsFromHaKg()) {
                    farm.getCorn().setStoredInKg(farm.getCorn().getStoredInKg() + this.haSown * this.plant.getHarvestsFromHaKg() * this.eventsDamages);
                    System.out.println("W zbiorach zebrano " + this.haSown * this.plant.getHarvestsFromHaKg() + "kg kukurydzy.");
                    System.out.println("Obecnie posiadasz " + farm.getCorn().getStoredInKg() + "kg kukurydzy.");
                    farm.getLand().setSownLandInHa(farm.getLand().getSownLandInHa() - this.haSown);
                    farm.getLand().setFreeLand(farm.getLand().getFreeLand() + this.haSown);
                    harvested = true;
                } else {
                    this.weeksToHarvest--;
                    System.out.println("W stodole nie ma miejsca. Nie można zebrać kukurydzy. Dokup dodatkową lub sprzedaj rośliny. Pozostały " + (4 - this.weeksToHarvest) + " tygodnie do zbiorów.");
                    System.out.println("Później to, co jest do zebrania przedpadnie.");
                }
            }
            if (this.plant instanceof LatePotato) {
                if (farm.getBarn().getCapacityOfOneBuilding() * farm.getBarn().getQuantityOfThisBuildingType() - farm.getBarn().kgOfPlantsStoredInBarn(farm) >= this.haSown * this.plant.getHarvestsFromHaKg()) {
                    farm.getLatePotato().setStoredInKg(farm.getLatePotato().getStoredInKg() + this.haSown * this.plant.getHarvestsFromHaKg() * this.eventsDamages);
                    System.out.println("W zbiorach zebrano " + this.haSown * this.plant.getHarvestsFromHaKg() + "kg późnych ziemniaków.");
                    System.out.println("Obecnie posiadasz " + farm.getLatePotato().getStoredInKg() + "kg późnych ziemniaków.");
                    farm.getLand().setSownLandInHa(farm.getLand().getSownLandInHa() - this.haSown);
                    farm.getLand().setFreeLand(farm.getLand().getFreeLand() + this.haSown);
                    harvested = true;
                } else {
                    this.weeksToHarvest--;
                    System.out.println("W stodole nie ma miejsca. Nie można zebrać ziemniaka późnego. Dokup dodatkową lub sprzedaj rośliny. Pozostały " + (4 - this.weeksToHarvest) + " tygodnie do zbiorów.");
                    System.out.println("Później to, co jest do zebrania przedpadnie.");
                }
            }
            if (this.plant instanceof LateRape) {
                if (farm.getBarn().getCapacityOfOneBuilding() * farm.getBarn().getQuantityOfThisBuildingType() - farm.getBarn().kgOfPlantsStoredInBarn(farm) >= this.haSown * this.plant.getHarvestsFromHaKg()) {
                    farm.getLateRape().setStoredInKg(farm.getLateRape().getStoredInKg() + this.haSown * this.plant.getHarvestsFromHaKg() * this.eventsDamages);
                    System.out.println("W zbiorach zebrano " + this.haSown * this.plant.getHarvestsFromHaKg() + "kg rzepaka ozimego.");
                    System.out.println("Obecnie posiadasz " + farm.getLateRape().getStoredInKg() + "kg rzepaka ozimego.");
                    farm.getLand().setSownLandInHa(farm.getLand().getSownLandInHa() - this.haSown);
                    farm.getLand().setFreeLand(farm.getLand().getFreeLand() + this.haSown);
                    harvested = true;
                } else {
                    this.weeksToHarvest--;
                    System.out.println("W stodole nie ma miejsca. Nie można zebrać Rzepaka ozimego. Dokup dodatkową lub sprzedaj rośliny. Pozostały " + (4 - this.weeksToHarvest) + " tygodnie do zbiorów.");
                    System.out.println("Później to, co jest do zebrania przedpadnie.");
                }
            }
            if (this.plant instanceof LateRye) {
                if (farm.getBarn().getCapacityOfOneBuilding() * farm.getBarn().getQuantityOfThisBuildingType() - farm.getBarn().kgOfPlantsStoredInBarn(farm) >= this.haSown * this.plant.getHarvestsFromHaKg()) {
                    farm.getLateRye().setStoredInKg(farm.getLateRye().getStoredInKg() + this.haSown * this.plant.getHarvestsFromHaKg() * this.eventsDamages);
                    System.out.println("W zbiorach zebrano " + this.haSown * this.plant.getHarvestsFromHaKg() + "kg żyta ozimego.");
                    System.out.println("Obecnie posiadasz " + farm.getLateRye().getStoredInKg() + "kg żyta ozimego.");
                    farm.getLand().setSownLandInHa(farm.getLand().getSownLandInHa() - this.haSown);
                    farm.getLand().setFreeLand(farm.getLand().getFreeLand() + this.haSown);
                    harvested = true;
                } else {
                    this.weeksToHarvest--;
                    System.out.println("W stodole nie ma miejsca. Nie można zebrać żyta ozimego. Dokup dodatkową lub sprzedaj rośliny. Pozostały " + (4 - this.weeksToHarvest) + " tygodnie do zbiorów.");
                    System.out.println("Później to, co jest do zebrania przedpadnie.");
                }
            }
            if (this.plant instanceof SpringBarley) {
                if (farm.getBarn().getCapacityOfOneBuilding() * farm.getBarn().getQuantityOfThisBuildingType() - farm.getBarn().kgOfPlantsStoredInBarn(farm) >= this.haSown * this.plant.getHarvestsFromHaKg()) {
                    farm.getSpringBarley().setStoredInKg(farm.getSpringBarley().getStoredInKg() + this.haSown * this.plant.getHarvestsFromHaKg() * this.eventsDamages);
                    System.out.println("W zbiorach zebrano " + this.haSown * this.plant.getHarvestsFromHaKg() + "kg jęczmienia jarego.");
                    System.out.println("Obecnie posiadasz " + farm.getSpringBarley().getStoredInKg() + "kg jęczmienia jarego.");
                    farm.getLand().setSownLandInHa(farm.getLand().getSownLandInHa() - this.haSown);
                    farm.getLand().setFreeLand(farm.getLand().getFreeLand() + this.haSown);
                    harvested = true;
                } else {
                    this.weeksToHarvest--;
                    System.out.println("W stodole nie ma miejsca. Nie można zebrać jęczmienia jarego. Dokup dodatkową lub sprzedaj rośliny. Pozostały " + (4 - this.weeksToHarvest) + " tygodnie do zbiorów.");
                    System.out.println("Później to, co jest do zebrania przedpadnie.");
                }
            }
            if (this.plant instanceof WhiteBeet) {
                if (farm.getBarn().getCapacityOfOneBuilding() * farm.getBarn().getQuantityOfThisBuildingType() - farm.getBarn().kgOfPlantsStoredInBarn(farm) >= this.haSown * this.plant.getHarvestsFromHaKg()) {
                    farm.getWhiteBeet().setStoredInKg(farm.getWhiteBeet().getStoredInKg() + this.haSown * this.plant.getHarvestsFromHaKg() * this.eventsDamages);
                    System.out.println("W zbiorach zebrano " + this.haSown * this.plant.getHarvestsFromHaKg() + "kg buraków cukrowych.");
                    System.out.println("Obecnie posiadasz " + farm.getWhiteBeet().getStoredInKg() + "kg buraków cukrowych.");
                    farm.getLand().setSownLandInHa(farm.getLand().getSownLandInHa() - this.haSown);
                    farm.getLand().setFreeLand(farm.getLand().getFreeLand() + this.haSown);
                    harvested = true;
                } else {
                    this.weeksToHarvest--;
                    System.out.println("W stodole nie ma miejsca. Nie można zebrać buraków cukrowych. Dokup dodatkową lub sprzedaj rośliny. Pozostały " + (4 - this.weeksToHarvest) + " tygodnie do zbiorów.");
                    System.out.println("Później to, co jest do zebrania przedpadnie.");
                }
            }
            if (this.plant instanceof WinterWheat) {
                if (farm.getBarn().getCapacityOfOneBuilding() * farm.getBarn().getQuantityOfThisBuildingType() - farm.getBarn().kgOfPlantsStoredInBarn(farm) >= this.haSown * this.plant.getHarvestsFromHaKg()) {
                    farm.getWinterWheat().setStoredInKg(farm.getWinterWheat().getStoredInKg() + this.haSown * this.plant.getHarvestsFromHaKg() * this.eventsDamages);
                    System.out.println("W zbiorach zebrano " + this.haSown * this.plant.getHarvestsFromHaKg() + "kg kukurydzy.");
                    System.out.println("Obecnie posiadasz " + farm.getWinterWheat().getStoredInKg() + "kg kukurydzy.");
                    farm.getLand().setSownLandInHa(farm.getLand().getSownLandInHa() - this.haSown);
                    farm.getLand().setFreeLand(farm.getLand().getFreeLand() + this.haSown);
                    harvested = true;
                } else {
                    this.weeksToHarvest--;
                    System.out.println("W stodole nie ma miejsca. Nie można zebrać pszenicy ozimej. Dokup dodatkową lub sprzedaj rośliny. Pozostały " + (4 - this.weeksToHarvest) + " tygodnie do zbiorów.");
                    System.out.println("Później to, co jest do zebrania przedpadnie.");
                }
            }
        }

        return harvested;
    }

    public void minusWeekToHarvest(){
        if(this.weeksToHarvest > 0){
            this.weeksToHarvest--;
        }
    }
}
