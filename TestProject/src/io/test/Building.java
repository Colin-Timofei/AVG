package io.test;

public class Building {
    protected String color;

    public Building(String color) {
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public int calculateArea() {
        return 10000;
    }
}
