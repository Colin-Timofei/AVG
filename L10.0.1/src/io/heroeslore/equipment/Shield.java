package io.heroeslore.equipment;

public class Shield extends DH {

    public Shield(String n, int d, int g) {
        super(n,d,g);
    }

    public Shield(Shield x) {super(x.name, x.defense, x.price);}
}