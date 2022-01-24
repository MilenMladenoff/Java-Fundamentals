package Fund2MoreExercises;

import java.util.Scanner;

public class FloatingEquality {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double eps = 0.000001;
        double numberA = Double.parseDouble(scan.nextLine());
        double numberB = Double.parseDouble(scan.nextLine());
        boolean isEqual = Math.abs(numberA - numberB) < eps;
        if (isEqual) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
