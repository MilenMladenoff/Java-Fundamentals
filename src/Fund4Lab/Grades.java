package Fund4Lab;

import java.util.Scanner;

public class Grades {
    public static void printGrades(double grade) {
        if (grade >= 2 && 3 > grade) {
            System.out.println("Fail");
        } else if (grade >= 3 && 3.5 > grade) {
            System.out.println("Poor");
        } else if (grade >= 3.5 && 4.5 > grade) {
            System.out.println("Good");
        } else if (grade >= 4.5 && 5.5 > grade) {
            System.out.println("Very good");
        } else {
            System.out.println("Excellent");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        printGrades(Double.parseDouble(scan.nextLine()));
    }
}
