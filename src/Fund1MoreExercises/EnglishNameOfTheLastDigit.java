package Fund1MoreExercises;

import java.util.Scanner;

public class EnglishNameOfTheLastDigit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        if (number % 10 == 0) {
            System.out.println("zero");
        } else if (number % 10 == 1) {
            System.out.println("one");
        } else if (number % 10 == 2) {
            System.out.println("two");
        } else if (number % 10 == 3) {
            System.out.println("three");
        } else if (number % 10 == 4) {
            System.out.println("four");
        } else if (number % 10 == 5) {
            System.out.println("five");
        } else if (number % 10 == 6) {
            System.out.println("six");
        } else if (number % 10 == 7) {
            System.out.println("seven");
        } else if (number % 10 == 8) {
            System.out.println("eight");
        } else {
            System.out.println("nine");
        }
    }
}
