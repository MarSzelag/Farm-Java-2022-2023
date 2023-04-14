package events;

import farm.Farm;

import java.util.Random;

public class Events {
    private String eventName;
    private static Integer chance;
    private static Double damage;


    public Events(String eventName, Integer chance, Double damage){
        this.eventName = eventName;
        this.chance = chance;
        this.damage = damage;
    }

    public static Integer getChance() {
        return chance;
    }

    public void setChance(Integer chance) {
        this.chance = chance;
    }

    public static Double getDamage() {
        return damage;
    }

    public static void setDamage(Double damage) {
        Events.damage = damage;
    }

        public static void eventCheck(Farm farm ){
        boolean droughtFlag = false;
        boolean droughtFlagGlobal = false;
        boolean floodFlagGlobal = false;
        boolean potatoBeetleFlatGlobal = false;

        Random rand = new Random();
      //  Integer temp;

        for(int i = 0; i < farm.getSown().size(); i++){
            droughtFlag = false;

            if(rand.nextInt(Drought.getChance()) == 1){
                farm.getSown().get(i).setEventsDamages(farm.getSown().get(i).getEventsDamages() - Drought.getDamage());
               droughtFlag = true;
               droughtFlagGlobal = true;
            }
            if(rand.nextInt(Flood.getChance()) == 1 && !droughtFlag){
                farm.getSown().get(i).setEventsDamages(farm.getSown().get(i).getEventsDamages() - Flood.getDamage());
                floodFlagGlobal = true;
            }
            if(rand.nextInt(PotatoBeetle.getChance()) == 1){
                farm.getSown().get(i).setEventsDamages(farm.getSown().get(i).getEventsDamages() - PotatoBeetle.getDamage());
                potatoBeetleFlatGlobal = true;
            }
        }
        if(droughtFlagGlobal == true){
            System.out.println("Twoją farmę nawiedziła susza. Część twoich roślin wyschła.");
        }
        if(floodFlagGlobal == true){
            System.out.println("Twoją farmę nawiedziła powódź. Część twoich roślin została zalana.");
        }
        if(potatoBeetleFlatGlobal == true){
            System.out.println("Twoją farmę nawiedziła stonka ziemniaczana. Część twoich roślin została pożarta.");
        }
    }
}

