package io.heroeslore.equipment;

public abstract class DH extends IH {

    protected final int defense;

    public DH(String n, int d, int g) {
        super(n,g);
        defense = d > 1 ? d : 1;
    }

    public int getDefense() {
        return defense;
    }
}
