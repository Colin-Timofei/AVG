package io.heroeslore.equipment;

public class Armor extends DH {

    public Armor(String n, int d, int g) {
        super(n,d,g);
    }

    public Armor(Armor x) {super(x.name, x.defense, x.price);}

}
