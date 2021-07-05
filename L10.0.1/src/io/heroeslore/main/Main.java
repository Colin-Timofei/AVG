package io.heroeslore.main;

import io.heroeslore.equipment.*;

import java.util.ArrayList;

public class Main {

    static final ArrayList<Weapon> weapons = new ArrayList<Weapon>();
    static final ArrayList<Shield> shields = new ArrayList<Shield>();
    static final ArrayList<Armor> armors = new ArrayList<Armor>();
    static final ArrayList<Helmet> helmets = new ArrayList<Helmet>();
    static final ArrayList<Boots> boots = new ArrayList<Boots>();

    public static void main(String[] args) {

        Generator.itemGenerator();

        Helper.myHero();

    }
}