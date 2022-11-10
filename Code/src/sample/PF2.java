package sample;

public class PF2 {
    //Exercise 1
    //Heavily inspired by:
    // https://stackoverflow.com/questions/53337839/find-the-most-repeated-word-in-a-string
    // https://www.geeksforgeeks.org/frequent-word-array-strings/

    public static String exercise1(String input) {
        //Splits string by blank spaces, regex for blank space character = \s
        String[] splitWordArray = input.split("\s");

        //Counters for freq occur word
        int tempCount, finalCount = 0;

        //Variable to store the most freq occur word
        String mostFreqOccurWord = "";

        //Compares the string array indexes which are filled with the inputString
        for (int i = 0; i < splitWordArray.length; i++) {
            tempCount = 0;
            for (int j = 0; j < splitWordArray.length; j++) {
                if (splitWordArray[i].equalsIgnoreCase(splitWordArray[j])) {
                    tempCount++;
                }
            }

            //Checks the word with the biggest counter and stores the most freq word
            if (tempCount > finalCount) {
                finalCount = tempCount;
                mostFreqOccurWord = splitWordArray[i];
            }
        }
        System.out.println("Most frequent occurring word: " + mostFreqOccurWord);
        return mostFreqOccurWord;
    } // Big oh = N * N = N^2

    public static void main(String[] args) {
        exercise1("The cattle were running back and forth, but there was no wolf to be seen, heard, or smelled, " +
                "so the shepherd decided to take a little nap in a bed of grass and early summer flowers. " +
                "Soon he was awakened by a sound he had never heard before.");
    }
}
