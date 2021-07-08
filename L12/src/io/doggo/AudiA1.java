package io.doggo;

import java.util.concurrent.TimeUnit;

public class AudiA1 {
    private int year;
    private int price;
    private String transmission;
    private boolean is_sportback;

    public AudiA1(int year, int price) {
        this.year = year;
        this.price = price;
        transmission = "automatic";
        is_sportback = false;

        this.go();
        this.stop();
    }

    private void go() {
        System.out.println("Engine started");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {}
        System.out.println("We have reached 50 km/h");
        System.out.println();
    }

    private void stop() {
        System.out.println("We don't do that here !");
        System.out.println();
    }



}
