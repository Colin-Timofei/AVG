package io.heroeslore.main;

import java.util.ArrayList;
import io.heroeslore.equipment.*;

public class Displayer {

    static void displayAHItem(ArrayList<? extends AH> x) {

        int size = x.size();

        System.out.printf("%10s","name : ");
        for (int i = 0; i < size; i++)
            System.out.printf("|" + "%18s",(i+1) + " " + x.get(i).getName());

        System.out.println();

        System.out.printf("%10s","power :");
        for (int i = 0; i < size; i++)
            System.out.printf("|" + "%18s",x.get(i).getPower());

        System.out.println();
        System.out.printf("%10s","price :");
        for (int i = 0; i < size; i++)
            System.out.printf("|" + "%18s",x.get(i).getPrice());
    }

    static void displayDHItem(ArrayList<? extends DH> x) {

        int size = x.size();

        System.out.printf("%10s","name : ");
        for (int i = 0; i < size; i++)
            System.out.printf("|" + "%18s",(i+1) + " " + x.get(i).getName());

        System.out.println();

        System.out.printf("%10s","defense :");
        for (int i = 0; i < size; i++)
            System.out.printf("|" + "%18s",x.get(i).getDefense());

        System.out.println();
        System.out.printf("%10s","price :");
        for (int i = 0; i < size; i++)
            System.out.printf("|" + "%18s",x.get(i).getPrice());
    }
}
