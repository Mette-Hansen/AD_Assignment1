package sample;


public class Main {

    //Exercise 1
    public static int oddSum(int i) {
        if (i <= 0) return 0;                 //Hvis i er mindre eller lig med nul, så stop
        if (i % 2 == 0) return oddSum(i - 1);   //Hvis i er et lige tal, så minus det med et og start forfra
        return (int) (oddSum(i - 2) + Math.pow(i, 2));  //Hvis i er ulige, så find summen af de mindre ulige tal, og tilføj det nuværende tal i anden til det.
    }

    public static void main(String[] args) {
        System.out.println(oddSum(8));
    }
}
