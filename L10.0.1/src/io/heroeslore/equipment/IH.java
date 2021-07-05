package io.heroeslore.equipment;

public abstract class IH {
    protected final String name;
    protected final int price;

    public IH(String n, int g) {
        name = n;
        price = g > 100 ? g : 100;
    }

    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
}
