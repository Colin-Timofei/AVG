package io.array;

import java.util.ArrayList;
import java.util.Iterator;

public class MakeArray {

    public static int[] returnOnlyEvenNumbers(int[] originalarray) {

        int count = 0;
        ArrayList<Integer> temparray = new ArrayList<Integer>();

        for(int x : originalarray) {
            if(x % 2 == 0) {
                temparray.add(x);
                count++;
            }
        }

        int[] newevenarray = new int[count];

        for(int i = 0; i < count; i++) {
            newevenarray[i] = temparray.get(i);
        }

        return newevenarray;
    }

    public static String returnCharsAsString(char[] originalarray) {

        String newstring = "";
        String temp = "";

        for(char x : originalarray) {
            temp = newstring + x;
            newstring = temp;
        }

        return newstring;
    }
}
