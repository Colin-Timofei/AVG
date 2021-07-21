package io.test;

public class HouseService implements IHouse{

    public void addHouse(House house) {
        System.out.println(house.getHouseNumber() + " will receive mail today");
    }

    public void addHouse(int id) {

    }

    public void deleteHouse(int id) {

    }

    public int[] getEvenNumbers(int[] fullArray) {

        int size = fullArray.length;
        int[] evenNumbersArray = new int[size];

        for(int i = 0, j = 0; i < size; i++) {
            if(fullArray[i] % 2 == 0) {
                evenNumbersArray[j] = fullArray[i];
                j++;
            }
        }

//        int newSize = 0;
//        int temp = 0;
//
//        for(int i = 0; i < size; i++) {
//            if(fullArray[i] % 2 == 0) {
//                newSize++;
//            }
//        }
//
//
//
//
//        for(int i = 0; i < size ; i++) {
//            if(fullArray[i] % 2 == 0) {
//                evenNumbersArray[temp] = fullArray[i];
//                temp++;
//            }
//        }

        return evenNumbersArray;
    }
}
