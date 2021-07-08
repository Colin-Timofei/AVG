package io.doggo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        AudiA1 mycar = new AudiA1(2020, 25500);
        System.out.println();

        CalculateX2 helpme = new CalculateX2();
        System.out.println(helpme.addnumbers(new int[]{3,4,5}));
        System.out.println(helpme.addnumbers(new float[]{3.3f,4.8f,12.9f}));
        System.out.println(helpme.addnumbers("Kira"));
        System.out.println();

        E3 next = new E3(2022);
        System.out.println(next);
        System.out.println();

        GTA4 test = new GTA4(true, 124);
        System.out.println(test.stars);
        System.out.println();

        System.out.println(new Inteli5());
        System.out.println();

    }
}
