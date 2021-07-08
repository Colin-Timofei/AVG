package io.doggo;

import java.time.LocalDate;

public class Inteli5 {
    String modelnumber;
    LocalDate date;

    Inteli5() {
        modelnumber = "not original !";
        date = LocalDate.now();
    }

    Inteli5(String modelnumber) {
        this.modelnumber = modelnumber;
        date = LocalDate.now();
    }

    void display(Inteli5 x) {
        System.out.println(x);
    }

    void displaythis() {
        display(this);
    }

    public String toString() {
        return "AMD send their regards !";
    }
}
