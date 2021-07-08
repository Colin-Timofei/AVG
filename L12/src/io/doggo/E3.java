package io.doggo;

import java.time.LocalDate;

public class E3 {
    int year;
    LocalDate date;

    E3() {
        this.date = LocalDate.now().plusMonths(3);
        this.year = this.date.getYear();
    }

    E3(LocalDate date) {
        this.date = date;
        this.year = this.date.getYear();
    }

    E3(int year) {
        if(year <= LocalDate.now().getYear()) {
            this.date = LocalDate.now().plusYears(1);
            this.year = date.getYear();
        }
        else {
            this.year = year;
            this.date = LocalDate.parse(this.year+"-06-06");
        }
    }
}
