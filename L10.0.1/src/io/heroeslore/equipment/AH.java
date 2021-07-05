package io.heroeslore.equipment;

public abstract class AH extends IH {

    protected final int power;

    public AH(String n, int p, int g) {
        super(n,g);
        power = p > 1 ? p : 1;
    }

    public int getPower() {
        return power;
    }
}
