package io.doggo;

public class GTA4 {
    int hp;
    int money;
    int stars;

    GTA4() {
        this.hp = 100;
        this.money = 1000;
    }

    GTA4(int money) {
        this();
        this.money = 0;
        System.out.println("No cheating ! Penalty $1000");
    }

    GTA4(boolean cheats_enabled, int money) {
        this(-1);
        if(cheats_enabled) {
            this.stars = 5;
        }
    }
}