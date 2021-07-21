package io.test;

public class House extends Building {
    private String street;
    private int houseNumber;
    private boolean hasTwoDoors;

    public House(int houseNumber, String color) {
        super(color);
        this.houseNumber = houseNumber;
    }

    public House(String street, int houseNumber, String color) {
        this(houseNumber, color);
        this.street = street;
    }

    public House(String street, int houseNumber, boolean hasTwoDoors, String color) {
        this(street, houseNumber, color);
        this.hasTwoDoors = hasTwoDoors;
    }

    public House getInstance() {
        return this;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHasTwoDoors(boolean hasTwoDoors) {
        this.hasTwoDoors = hasTwoDoors;
    }

    public boolean getHasTwoDoors() {
        return hasTwoDoors;
    }

    @Override
    public int calculateArea() {
        return 100;
    }
}
