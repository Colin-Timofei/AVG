package io.heroeslore.equipment;

public class Helmet extends DH {

    public Helmet(String n, int d, int g) {
        super(n,d,g);
    }

    public Helmet(Helmet x) {super(x.name, x.defense, x.price);}

}
