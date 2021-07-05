package io.heroeslore.main;

import java.util.ArrayList;
import java.util.Random;

import io.heroeslore.equipment.*;

public class Generator {

    static void itemGenerator() {
        String[] weapons = {"Claymore", "Falchion", "Flamberge", "Glaive",
                "Rapier", "Gladius", "Pine Sword"};
        generateItems(weapons, "Weapons", 100);

        String[] shields = {"Buckler", "Aspis", "Kite Shield", "Hero Shield"};
        generateItems(shields, "Shields", 25);

        String[] armors = {"Leather Armor", "Brigandine", "Scale Mail", "Full Plate"};
        generateItems(armors, "Armors", 50);

        String[] helmets = {"Circlet", "Headgear", "Battle Hat", "War Helmet"};
        generateItems(armors, "Helmets", 15);

        String[] boots = {"Leather Shoes", "Plate Boots", "Long Grip"};
        generateItems(boots, "Boots", 10);
    }

    private static void generateItems(String[] items, String cls, int max) {

        int size = items.length;

        for(int i = 0; i < size; i++) {
            int temp1 = new Random().nextInt(max/2) + (max - max/2);
            int temp2 = (temp1 * temp1) + new Random().nextInt(temp1*25);
            switch(cls) {
                case "Weapons" : Main.weapons.add(new Weapon(items[i],temp1,temp2)); break;
                case "Shields" : Main.shields.add(new Shield(items[i],temp1,temp2)); break;
                case "Armors" : Main.armors.add(new Armor(items[i],temp1,temp2)); break;
                case "Helmets" : Main.helmets.add(new Helmet(items[i],temp1,temp2)); break;
                case "Boots" : Main.boots.add(new Boots(items[i],temp1,temp2)); break;
            }
        }
    }
}
