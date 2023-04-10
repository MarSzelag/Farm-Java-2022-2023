package plants;

import farm.Farm;

import java.util.Scanner;

public class Sown {

        private Plant plant;
        private String name;
        Integer haSown = 0;
        private Integer weeksToHarvest;

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

        public Sown addToSown(Plant plant, Farm farm) {
            Sown sown = null;
            Integer haToSow = 0;
            this.plant = plant;

            Scanner scan = new Scanner(System.in);
            System.out.println("Masz " + farm.getLand().getFreeLand() + " nieobsianej ziemi i " + plant.getStoredInKg() + " kg " + plant.getPlantName() + " Obsianie 1 ha ziemi wymaga " + plant.getNeededToSowOneHaInKg());
            System.out.println("Koszt przygotowania ziemi i obsiewu wynosi " + plant.getLandPreparationCostPerHa() + "zł, a koszt ochrony roślin " + plant.getProtectionAgainstPests() + "zł za każdy ha obsianej ziemi.");
            System.out.println("Wprowadź 0, aby wyjść.");
            System.out.println("Ile ha " + plant.getPlantName() + "chcesz obsiać?");
            try {
                haToSow = Integer.parseInt(scan.nextLine());
                if (haToSow < 0) {
                    System.out.println("Nie można wprowadzać wartości ujemnych. Spróbuj jeszcze raz.");
                } else if (haToSow == 0) {
                } else if(farm.getCash() < ((plant.getLandPreparationCostPerHa() + plant.getProtectionAgainstPests()) * haToSow)){
                    System.out.println("Nie masz wystarczającej ilości pieniędzy, żeby przygotować ziemię do obsiewu i zapewnić jakiejkolwiek ochrony przed szkodnikami.");
                }else if (farm.getLand().getFreeLand() >= haToSow && plant.getStoredInKg() >= (haToSow * plant.getNeededToSowOneHaInKg())) {
                    if (farm.getWeekOfYear() >= plant.getSowingTimeFromWeek() && farm.getWeekOfYear() <= plant.getSowingTimeToWeek()) {
                        farm.setCash(farm.getCash() - ((plant.getLandPreparationCostPerHa() + plant.getProtectionAgainstPests()) * haToSow));
                        this.haSown = haToSow;
                        this.weeksToHarvest = plant.getHarvestTimeAfterNoWeeks();
                        System.out.println("Obsiałeś " + haToSow + " ziemi.");
                    } else
                        System.out.println("Teraz nie da rady tego zasiać. Okres zasiewów jest od " + plant.getSowingTimeFromWeek() + " tygodnia do " + plant.getSowingTimeToWeek() + " tygodnia roku.");
                } else
                    System.out.println("Sprawdź dokładnie ile ziemi możesz obsiać i czy masz wystarczającą ilość roślin do obsiewu.");
            } catch (
                    Exception e) {
                System.out.println("Błąd"); //TODO Mismatch exception?
            }
            return sown;
        }

        public boolean minusWeeksToHarvest(Farm farm) {//TODO return minusWeeksToHarvest i usunąć jeśli jest 0? this.haSown jest chyba błędne, bo podaje całość haSown, a nie tylko dla tego przypadku.
            boolean harvested = false;
            if (this.weeksToHarvest > 0) {
                this.weeksToHarvest--;
            } else if (this.weeksToHarvest < -4) {
                farm.getLand().setSownLandInHa(farm.getLand().getSownLandInHa() - this.haSown);
                farm.getLand().setFreeLand(farm.getLand().getFreeLand() + this.haSown);
                harvested = true;
                System.out.println("");
            } else if (this.weeksToHarvest <= 0) {
                if (this.plant.equals(farm.getCorn().getClass())) {
                    if (farm.getBarn().getCapacityOfOneBuilding() * farm.getBarn().getQuantityOfThisBuildingType() - farm.getBarn().kgOfPlantsStoredInBarn(farm) >= this.haSown * this.plant.getHarvestsFromHaKg()) {
                        farm.setCorn(farm.getCorn().getStoredInKg() + this.haSown * this.plant.getHarvestsFromHaKg());
                        System.out.println("W zbiorach zebrano " + this.haSown * this.plant.getHarvestsFromHaKg() + "kg kukurydzy.");
                        System.out.println("Obecnie posiadasz " + farm.getCorn().getStoredInKg() + "kg kukurydzy.");
                        farm.getLand().setSownLandInHa(farm.getLand().getSownLandInHa() - this.haSown);
                        farm.getLand().setFreeLand(farm.getLand().getFreeLand() + this.haSown);
                        harvested = true;
                    } else {
                        System.out.println("W stodole nie ma miejsca. Nie można zebrać kukurydzy. Dokup dodatkową lub sprzedaj rośliny. Pozostały " + (4 - this.weeksToHarvest) + " tygodnie do zbiorów.");
                        System.out.println("Później to, co jest do zebrania przedpadnie.");
                    }
                }
                if (this.plant.equals(farm.getLatePotato().getClass())) {
                    if (farm.getBarn().getCapacityOfOneBuilding() * farm.getBarn().getQuantityOfThisBuildingType() - farm.getBarn().kgOfPlantsStoredInBarn(farm) >= this.haSown * this.plant.getHarvestsFromHaKg()) {
                        farm.setLatePotato(farm.getLatePotato().getStoredInKg() + this.haSown * this.plant.getHarvestsFromHaKg());
                        System.out.println("W zbiorach zebrano " + this.haSown * this.plant.getHarvestsFromHaKg() + "kg kukurydzy.");
                        System.out.println("Obecnie posiadasz " + farm.getLatePotato().getStoredInKg() + "kg kukurydzy.");
                        farm.getLand().setSownLandInHa(farm.getLand().getSownLandInHa() - this.haSown);
                        farm.getLand().setFreeLand(farm.getLand().getFreeLand() + this.haSown);
                        harvested = true;
                    } else {
                        System.out.println("W stodole nie ma miejsca. Nie można zebrać ziemniaka późnego. Dokup dodatkową lub sprzedaj rośliny. Pozostały " + (4 - this.weeksToHarvest) + " tygodnie do zbiorów.");
                        System.out.println("Później to, co jest do zebrania przedpadnie.");
                    }
                }
                if (this.plant.equals(farm.getLateRape().getClass())) {
                    if (farm.getBarn().getCapacityOfOneBuilding() * farm.getBarn().getQuantityOfThisBuildingType() - farm.getBarn().kgOfPlantsStoredInBarn(farm) >= this.haSown * this.plant.getHarvestsFromHaKg()) {
                        farm.setLateRape(farm.getLateRape().getStoredInKg() + this.haSown * this.plant.getHarvestsFromHaKg());
                        System.out.println("W zbiorach zebrano " + this.haSown * this.plant.getHarvestsFromHaKg() + "kg kukurydzy.");
                        System.out.println("Obecnie posiadasz " + farm.getLateRape().getStoredInKg() + "kg kukurydzy.");
                        farm.getLand().setSownLandInHa(farm.getLand().getSownLandInHa() - this.haSown);
                        farm.getLand().setFreeLand(farm.getLand().getFreeLand() + this.haSown);
                        harvested = true;
                    } else {
                        System.out.println("W stodole nie ma miejsca. Nie można zebrać Rzepaka ozimego. Dokup dodatkową lub sprzedaj rośliny. Pozostały " + (4 - this.weeksToHarvest) + " tygodnie do zbiorów.");
                        System.out.println("Później to, co jest do zebrania przedpadnie.");
                    }
                }
                if (this.plant.equals(farm.getLateRye().getClass())) {
                    if (farm.getBarn().getCapacityOfOneBuilding() * farm.getBarn().getQuantityOfThisBuildingType() - farm.getBarn().kgOfPlantsStoredInBarn(farm) >= this.haSown * this.plant.getHarvestsFromHaKg()) {
                        farm.setLateRye(farm.getLateRye().getStoredInKg() + this.haSown * this.plant.getHarvestsFromHaKg());
                        System.out.println("W zbiorach zebrano " + this.haSown * this.plant.getHarvestsFromHaKg() + "kg kukurydzy.");
                        System.out.println("Obecnie posiadasz " + farm.getLateRye().getStoredInKg() + "kg kukurydzy.");
                        farm.getLand().setSownLandInHa(farm.getLand().getSownLandInHa() - this.haSown);
                        farm.getLand().setFreeLand(farm.getLand().getFreeLand() + this.haSown);
                        harvested = true;
                    } else {
                        System.out.println("W stodole nie ma miejsca. Nie można zebrać żyta ozimego. Dokup dodatkową lub sprzedaj rośliny. Pozostały " + (4 - this.weeksToHarvest) + " tygodnie do zbiorów.");
                        System.out.println("Później to, co jest do zebrania przedpadnie.");
                    }
                }
                if (this.plant.equals(farm.getSpringBarley().getClass())) {
                    if (farm.getBarn().getCapacityOfOneBuilding() * farm.getBarn().getQuantityOfThisBuildingType() - farm.getBarn().kgOfPlantsStoredInBarn(farm) >= this.haSown * this.plant.getHarvestsFromHaKg()) {
                        farm.setSpringBarley(farm.getSpringBarley().getStoredInKg() + this.haSown * this.plant.getHarvestsFromHaKg());
                        System.out.println("W zbiorach zebrano " + this.haSown * this.plant.getHarvestsFromHaKg() + "kg kukurydzy.");
                        System.out.println("Obecnie posiadasz " + farm.getSpringBarley().getStoredInKg() + "kg kukurydzy.");
                        farm.getLand().setSownLandInHa(farm.getLand().getSownLandInHa() - this.haSown);
                        farm.getLand().setFreeLand(farm.getLand().getFreeLand() + this.haSown);
                        harvested = true;
                    } else {
                        System.out.println("W stodole nie ma miejsca. Nie można zebrać jęczmienia jarego. Dokup dodatkową lub sprzedaj rośliny. Pozostały " + (4 - this.weeksToHarvest) + " tygodnie do zbiorów.");
                        System.out.println("Później to, co jest do zebrania przedpadnie.");
                    }
                }
                if (this.plant.equals(farm.getWhiteBeet().getClass())) {
                    if (farm.getBarn().getCapacityOfOneBuilding() * farm.getBarn().getQuantityOfThisBuildingType() - farm.getBarn().kgOfPlantsStoredInBarn(farm) >= this.haSown * this.plant.getHarvestsFromHaKg()) {
                        farm.setWhiteBeet(farm.getWhiteBeet().getStoredInKg() + this.haSown * this.plant.getHarvestsFromHaKg());
                        System.out.println("W zbiorach zebrano " + this.haSown * this.plant.getHarvestsFromHaKg() + "kg kukurydzy.");
                        System.out.println("Obecnie posiadasz " + farm.getWhiteBeet().getStoredInKg() + "kg kukurydzy.");
                        farm.getLand().setSownLandInHa(farm.getLand().getSownLandInHa() - this.haSown);
                        farm.getLand().setFreeLand(farm.getLand().getFreeLand() + this.haSown);
                        harvested = true;
                    } else {
                        System.out.println("W stodole nie ma miejsca. Nie można zebrać buraka cukrowego. Dokup dodatkową lub sprzedaj rośliny. Pozostały " + (4 - this.weeksToHarvest) + " tygodnie do zbiorów.");
                        System.out.println("Później to, co jest do zebrania przedpadnie.");
                    }
                }
                if (this.plant.equals(farm.getWinterWheat().getClass())) {
                    if (farm.getBarn().getCapacityOfOneBuilding() * farm.getBarn().getQuantityOfThisBuildingType() - farm.getBarn().kgOfPlantsStoredInBarn(farm) >= this.haSown * this.plant.getHarvestsFromHaKg()) {
                        farm.setWinterWheat(farm.getWinterWheat().getStoredInKg() + this.haSown * this.plant.getHarvestsFromHaKg());
                        System.out.println("W zbiorach zebrano " + this.haSown * this.plant.getHarvestsFromHaKg() + "kg kukurydzy.");
                        System.out.println("Obecnie posiadasz " + farm.getWinterWheat().getStoredInKg() + "kg kukurydzy.");
                        farm.getLand().setSownLandInHa(farm.getLand().getSownLandInHa() - this.haSown);
                        farm.getLand().setFreeLand(farm.getLand().getFreeLand() + this.haSown);
                        harvested = true;
                    } else {
                        System.out.println("W stodole nie ma miejsca. Nie można zebrać pszenicy ozimej. Dokup dodatkową lub sprzedaj rośliny. Pozostały " + (4 - this.weeksToHarvest) + " tygodnie do zbiorów.");
                        System.out.println("Później to, co jest do zebrania przedpadnie.");
                    }
                }
//TODO zwiększyć ilość roślin w magazynie farmy i sprawdzić czy jest miejsce w magazynie, jeśli nie roślina przepada

            } else
                System.out.println("Coś poszło nie tak.");
            return harvested;
        }
}
