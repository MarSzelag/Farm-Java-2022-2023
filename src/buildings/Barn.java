package buildings;

import farm.Farm;

public class Barn extends Building{

    public Barn() {
        super("Stodoła", "Rośliny", 20000, 500.00, 400.00);
    }

    public Integer kgOfPlantsStoredInBarn(Farm farm){
        Integer allPlantsInKg = farm.getCorn().getStoredInKg() + farm.getLatePotato().getStoredInKg() + farm.getLateRape().getStoredInKg() + farm.getLateRye().getStoredInKg() + farm.getSpringBarley().getStoredInKg() + farm.getWhiteBeet().getStoredInKg() + farm.getWinterWheat().getStoredInKg();
        return allPlantsInKg;
    }

}
