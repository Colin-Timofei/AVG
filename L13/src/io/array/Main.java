package io.array;

import static io.array.MakeArray.*;

public class Main {

    public static void main(String[] args) {

        int[] testarray = {3,4,5,6,7,8};
        for(int x : returnOnlyEvenNumbers(testarray)) {
            System.out.print(x + " ");
        }
        System.out.println();

        char[] chararray = {'t','h','i','s',' ','i','s',' ','a',' ','s','t','r','i','n','g'};
        System.out.println(returnCharsAsString(chararray));
    }
}
