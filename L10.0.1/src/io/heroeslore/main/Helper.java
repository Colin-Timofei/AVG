package io.heroeslore.main;

import io.heroeslore.active.Basics;
import io.heroeslore.active.Equipment;
import io.heroeslore.equipment.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Helper {

    static private void welcomeMessage() {

        System.out.println();
        System.out.println("Welcome Hero !");
        System.out.println("Today you'll test your powers in our tournament");
    }

    static private int getPointsChoice(int maxchoice, String choicemessage, boolean x) {

        int choice = -1;

        System.out.println();
        System.out.println("Points available : " + maxchoice);

        if(x) {
            if(maxchoice != 0) {
                System.out.println("Please set the number of points to go into " + choicemessage);
                do {
                    try {
                        choice = new Scanner(System.in).nextInt();
                        if(choice > maxchoice || choice < 0) {
                            choice = -1;
                            throw new Exception();
                        }
                    } catch (Exception e) {
                        System.out.println();
                        System.out.println("Sorry, you can't put that amount of points in " + choicemessage);
                        System.out.println("Please try again");
                    }
                }while (choice == -1);

            } else {
                choice = 0;
                System.out.println("No points available. Zero points were assigned to " + choicemessage);
            }
        } else {
            choice = maxchoice;
            System.out.println("Last option. " + maxchoice + " point/s were added to " + choicemessage);
        }

        return choice;
    }

    static private Basics chooseBasics() {

        int choice;
        int points = 20;

        System.out.println();
        System.out.println("You have " + points + " to add into hp, sp, power and defense");
        System.out.println("Choose wisely since you won't be able to reassign later");

        int hp = getPointsChoice(points, "hp", true);
        points -= hp;

        int sp = getPointsChoice(points, "sp", true);
        points -= sp;

        int power = getPointsChoice(points, "power", true);
        points -= power;

        int defense = getPointsChoice(points, "defense", false);
        points -= defense;

        return new Basics(hp ,sp ,power, defense);
    }

    static private int getItemChoice(ArrayList<? extends IH> x, int availablegold, String choicemessage) {

        System.out.println();

        int choice = 0;
        int arraysize = x.size();

        int minprice = x.get(0).getPrice();
        int minchoice = 0;

        for (int i = 1; i < arraysize; i++) {
            if(x.get(i).getPrice() < minprice) {
                minprice = x.get(i).getPrice();
                minchoice = i;
            }
        }

        if (availablegold < minprice) {
            System.out.println("It seems you do not have enough funds");
            System.out.println("You'll be given the least expensive " + choicemessage);
            System.out.println();
            return minchoice;
        }
        else {
            do {
                try {
                    choice = new Scanner(System.in).nextInt();
                    if(choice > arraysize || x.get(choice-1).getPrice() > availablegold) {
                        choice = 0;
                        throw new Exception();
                    }
                } catch (Exception e) {
                    System.out.println();
                    System.out.println("Sorry, you can't buy that " + choicemessage);
                    System.out.println("Please pick again");
                }

            } while(choice == 0);

            return (choice - 1);
        }
    }

    static Equipment chooseEquipment(int yourgold) {

        int gold = yourgold;
        int tmpprice = 0;

        Equipment e = new Equipment();

        String[] items = {"weapon", "shield", "armor", "helmet", "boots"};
        int size = items.length;

        for(int i = 0; i < size; i++) {

            System.out.println();
            System.out.println("Choose your " + items[i] + " : ");

            switch (items[i]) {
                case "weapon" : Displayer.displayAHItem(Main.weapons);
                    e.weapon = new Weapon(Main.weapons.get(getItemChoice(Main.weapons, gold, "weapon")));
                    tmpprice = e.weapon.getPrice();
                    break;
                case "shield" : Displayer.displayDHItem(Main.shields);
                    e.shield = new Shield(Main.shields.get(getItemChoice(Main.shields, gold, "shield")));
                    tmpprice = e.shield.getPrice();
                    break;
                case "armor" : Displayer.displayDHItem(Main.armors);
                    e.armor = new Armor(Main.armors.get(getItemChoice(Main.armors, gold, "armor")));
                    tmpprice = e.armor.getPrice();
                    break;
                case "helmet" : Displayer.displayDHItem(Main.helmets);
                    e.helmet = new Helmet(Main.helmets.get(getItemChoice(Main.helmets, gold, "helmet")));
                    tmpprice = e.helmet.getPrice();
                    break;
                case "boots" : Displayer.displayDHItem(Main.boots);
                    e.boots = new Boots(Main.boots.get(getItemChoice(Main.boots, gold, "boots")));
                    tmpprice = e.boots.getPrice();
                    break;
            }

            gold = tmpprice < gold ? gold - tmpprice : gold;

            System.out.println();
            System.out.println("Remaining gold : " + gold);
            System.out.println();
        }
        return e;
    }

    static void myHero() {

        welcomeMessage();
        chooseBasics();
        chooseEquipment(10000);
    }
}
