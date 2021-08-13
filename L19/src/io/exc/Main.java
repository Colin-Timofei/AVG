package io.exc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-uuuu kk:mm");

        System.out.println(LocalDateTime.now().format(formatter));
    }

}
