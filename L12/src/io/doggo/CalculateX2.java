package io.doggo;

public class CalculateX2 {

    public int addnumbers(int[] numbers) {

        int size = numbers.length;

        if(size == 0) {
            return 0;
        }
        else if (size == 1) {
            return numbers[0];
        }
        else {
            int sum = 0;
            for(int x : numbers) {
                sum += x;
            }
            return sum;
        }
    }

    public int addnumbers(float[] numbers) {

        int size = numbers.length;

        if(size == 0) {
            return -1;
        }
        else if(size == 1) {
            return 0;
        }
        else {
            float sum = 0;
            for(float x : numbers) {
                sum += x;
            }
            return Math.round(sum);
        }
    }

    public int addnumbers(String numbers) {

        int sum = 0;
        int size = numbers.length();

        for(int i = 0; i < size; i++) {
            sum += numbers.charAt(i);
        }

        return sum;
    }
}
