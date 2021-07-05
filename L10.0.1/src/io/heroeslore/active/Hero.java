package io.heroeslore.active;

import io.heroeslore.equipment.*;

public class Hero {
    private final String name;
    private int level;
    private Basics stats;
    private Weapon weapon;
    private Armor armor;
    private Shield shield;
    private Helmet helmet;
    private Boots boots;

    public Hero(String n, Basics sb, Weapon w, Armor a, Shield s, Helmet h, Boots b) {
        name = n;
        level = 1;
        stats = sb;
        weapon = w;
        armor = a;
        shield = s;
        helmet = h;
        boots = b;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public Basics getStats() {
        return stats;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public Shield getShield() {
        return shield;
    }

    public Boots getBoots() {
        return boots;
    }

    public Helmet getHelmet() {
        return helmet;
    }

    private int getFullAttack() {
        return (stats.getPower() + weapon.getPower()) * 16;
    }

    private int getFullDefense() {
        return (stats.getDefense() + armor.getDefense() + shield.getDefense() + helmet.getDefense() + boots.getDefense()) * 12;
    }

    public int attack() {
        return getFullAttack();
    }

    public int getAttacked(int a) {
        int dmg = a - getFullDefense();
        if(dmg > 0) stats.bleed(dmg);
        return stats.getHp();
    }

    public void levelup(int h, int s, int p, int d) {
        stats.levelUp(h,s,p,d);
        level++;
    }
}