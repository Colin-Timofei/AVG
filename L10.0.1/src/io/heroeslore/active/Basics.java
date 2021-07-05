package io.heroeslore.active;

public class Basics {

    private int hp;
    private int maxhp;
    private int sp;
    private int maxsp;
    private int power;
    private int defense;

    public Basics(int h, int s, int p, int d) {
        maxhp = h > 16 ? h : 16;
        hp = maxhp;
        maxsp = s > 16 ? s : 16;
        sp = maxsp;
        power = p > 4 ? p : 4;
        defense = d > 4 ? d : 4;
    }

    public int getMaxhp() {
        return maxhp;
    }

    public int getHp() {
        return hp;
    }

    public int bleed(int a) {
        hp -= a > 0 ? a : 0;
        return hp;
    }

    public void resetHp() {
        hp = maxhp;
    }

    public int getMaxsp() {
        return maxsp;
    }

    public int getSp() {
        return sp;
    }

    public int useforce(int fn)
    {
        sp -= fn > 0 ? fn : 0;
        return sp;
    }

    public void resetSp() {
        sp = maxsp;
    }

    public int getPower() {
        return power;
    }

    public int getDefense() {
        return defense;
    }

    public void levelUp(int ah, int as, int ap, int ad) {
        maxhp += ah > 0 ? ah : 0;
        maxsp += as > 0 ? as : 0;
        power += ap > 0 ? ap : 0;
        defense += ad > 0 ? ad : 0;
        resetHp();
        resetSp();
    }
}
