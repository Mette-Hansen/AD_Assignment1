package sample;


import java.util.Arrays;

public class Main {

    //Exercise 1
    public static int oddSum(int i) {
        if (i <= 0) return 0;     //Basecase, if integer is negative, return 0.
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
            System.out.println(indexOne + " " + indexTwo + " " + indexThree);
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
                        int offSet = (int) (Math.pow(i,2) - (array[firstIndex] + array[secondIndex] + array[threeIndex])); //Variable int indicates the off from the sum of three numbers compared to the pow of two
                        if (Math.sqrt(Math.pow(offSet,2)) < lowestOffset){
                            lowestOffset = (int) Math.sqrt(Math.pow(offSet,2));
                            temp[0] = array[firstIndex];
                            temp[1] = array[secondIndex];
                            temp[2] = array[threeIndex];
                            temp[3] = (int) Math.pow(i,2);
                        }
                    }
                }
            }
            //This algorithm can be optimized, however, the optimization doesn't change the bigOh time complexity.
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(oddSum(8));
        System.out.println(additive("82842605"));
        System.out.println(Arrays.toString(threePow(new int[]{23, 56, 22, 11, 65, 89, 3, 44, 87, 910, 45, 35, 98})));
    }
}
