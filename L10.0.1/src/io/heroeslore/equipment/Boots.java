package io.heroeslore.equipment;

public class Boots extends DH {

    public Boots(String n, int d, int g) {
        super(n,d,g);
    }

    public Boots(Boots x) {super(x.name, x.defense, x.price);}

}
