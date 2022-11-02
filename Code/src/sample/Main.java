package sample;


import java.util.Arrays;

public class Main {

    //Exercise 1
    public static int oddSum(int i) {
        if (i <= 0) return 0;     //Base case, if integer is negative, return 0.
        if (i % 2 == 0) return oddSum(i - 1); //If integer is even, return odd integer
        return (int) (oddSum(i - 2) + Math.pow(i, 2));
    }

    //Exercise 3
    public static boolean additive(String s) {
        if (s.length() < 3) { //Checks if the algorithm can run through the string
            return false;
        }
        int indexOne = Integer.parseInt(s.substring(0, 1));
        int indexTwo = Integer.parseInt(s.substring(1, 2));
        int indexThree = Integer.parseInt(s.substring(2, 3));
        if (indexOne + indexTwo == indexThree) {
            System.out.println(indexOne + " plus " + indexTwo + " is equal to " + indexThree);
            return true;
        }
        return additive(s.substring(1)); //Define a new start index
    }

    //Exercise 4
    public static int[] threePow(int[] array) {
        int[] temp = new int[4]; //Array that will return the three values + power of two
        int lowestOffset = Integer.MAX_VALUE; //Highest possible offset for an exponent (pow of two)
        for (int firstIndex = 0; firstIndex < array.length; firstIndex++) { //Loop through the all the indexes
            for (int secondIndex = 0; secondIndex < array.length; secondIndex++) {
                for (int threeIndex = 0; threeIndex < array.length; threeIndex++) {
                    //The same number can only be used once
                    if (firstIndex == secondIndex || secondIndex == threeIndex || firstIndex == threeIndex) {
                        continue;
                    }
                    // Check all relevant exponents  (three numbers + pow of two)
                    // sqrt ensures always positive integers
                    for (int i = 1; i < Math.sqrt(Integer.MAX_VALUE); i++) {
                        int offSet = (int) (Math.pow(2, i) - (array[firstIndex] + array[secondIndex] + array[threeIndex])); //Variable int indicates the off from the sum of three numbers compared to the pow of two
                        if (Math.sqrt(Math.pow(offSet, 2)) < lowestOffset) {
                            lowestOffset = (int) Math.sqrt(Math.pow(offSet, 2));
                            temp[0] = array[firstIndex];
                            temp[1] = array[secondIndex];
                            temp[2] = array[threeIndex];
                            temp[3] = (int) Math.pow(2, i);
                        }
                    }
                }
            }
            //This algorithm can be optimized, however, the optimization doesn't change the bigOh time complexity.
            //N * N * N * sqrt(1) = N^3 | sqrt(1) == constant
        }
        return temp;
    }

    //Exercise 6
    public static int sumDivisibleBy3(int N) {
        if (N - 3 < 0) { //Base case
            return 0;
        }
        if (N % 3 == 0) { //If divisible by 3
            return N + sumDivisibleBy3(N - 3);
        }
        //If not divisible by 3
        return sumDivisibleBy3(N - (N % 3));
    }

    //Exercise 7
    public static int[] solutionPair(int z) {
        int[] output = new int[]{0, 0};

        if (z > 100000) {
            return output;
        }

        // sqrt used for the theoretical lowest natural exponent
        for (int x = 3; x < Math.log(z)/Math.log(3); x++) {
            for (int y = 3; y < Math.sqrt(z); y++) {
                //Checks if x^y is equal to z, and that x is the largest value
                if (Math.pow(x, y) == z && x > output[0]) {
                    output[0] = x;
                    output[1] = y;
                }
            }
        }
        return output;
    }

    //Exercise 10
    public static int logTo(int N) {
        if (N <= 1) {
            return 0;
        }
        return logTo(N / 2) + 1;
    }

    //Exercise 11
    public static int election(int[] array, int participants) {
        int[] temp = new int[participants];
        Arrays.fill(temp, 0);
        for (int j : array) {
            temp[j - 1]++;

        }
        for (int i = 0; i < temp.length; i++) {
            //System.out.println(temp[i] +">"+array);
            if (temp[i] >= array.length / 2) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //System.out.println("------------------------- Exercise 1 -------------------------\n");
        //System.out.println("The sum of odd squares, from 1 to 8: " + oddSum(8));
        //System.out.println("\n------------------------- Exercise 3 -------------------------\n");
        //System.out.println("The additive is " + additive("82842605"));
        //System.out.println("\n------------------------- Exercise 4 -------------------------\n");
        //System.out.println("The three numbers, and closest power result: " + Arrays.toString(threePow(new int[]{23, 56, 22, 11, 65, 89, 3, 44, 87, 910, 45, 35, 98})));
        //System.out.println("\n------------------------- Exercise 6 -------------------------\n");
        //System.out.println("Test 1: \t The divisible sum of 12 is " + sumDivisibleBy3(12));
        //System.out.println("Test 2: \t The divisible sum of 14 is " + sumDivisibleBy3(14));
        //System.out.println("\n------------------------- Exercise 7 -------------------------\n");
        //System.out.println("Test 1: \t The solution pair of 6561 is: " + Arrays.toString(solutionPair(6561)));
        //System.out.println("Test 2: \t The solution pair of 3125 is: " + Arrays.toString(solutionPair(3125)));
        //System.out.println("\n------------------------- Exercise 10 ------------------------\n");
        //System.out.println("Test 1: \t The base 2 log of 32 is: " + logTo(32)); //returns 5
        //System.out.println("Test 2: \t The base 2 log of 4096 is: " +logTo(4096)); //returns 12
        //System.out.println("\n------------------------- Exercise 11 ------------------------\n");
        //System.out.println("Test 1: \t Which candidate has the majority? (-1 for none of them) " + election(new int[]{7, 4, 3, 5, 3, 1, 6, 4, 5, 1, 7, 5}, 7));
        //System.out.println("Test 2: \t Which candidate has the majority? (-1 for none of them) " +election(new int[]{7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 5}, 7));

    }
}
