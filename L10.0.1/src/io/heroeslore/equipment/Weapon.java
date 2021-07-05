package io.heroeslore.equipment;

public class Weapon extends AH {

    public Weapon(String n, int p, int g) {
        super(n,p,g);
    }

    public Weapon(Weapon x) {
        super(x.name, x.power, x.price);
    }
}
