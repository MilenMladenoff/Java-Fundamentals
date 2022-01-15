package Fund1Exercises;

import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        int division = 0;
        boolean isDivisible = true;
        if (number % 10 == 0){
            division = 10;
        } else if (number % 7 == 0){
            division = 7;
        } else if (number % 6 == 0){
            division = 6;
        } else if (number % 3 == 0){
            division = 3;
        } else if (number % 2 == 0){
            division = 2;
        } else {
            isDivisible = false;
        }
        if (isDivisible){
            System.out.printf("The number is divisible by %d%n", division);
        } else {
            System.out.println("Not divisible");
        }
    }
}
