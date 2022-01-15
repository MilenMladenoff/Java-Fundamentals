package Fund1MoreExercises;

import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double num1 = Double.parseDouble(scan.nextLine());
        double num2 = Double.parseDouble(scan.nextLine());
        double num3 = Double.parseDouble(scan.nextLine());
        double maxNum = 0;
        double midNum = 0;
        double minNum = 0;
        if (num2 < num1 && num1 > num3) {
            maxNum = num1;
        } else if (num1 < num2 && num2 > num3) {
            maxNum = num2;
        } else {
            maxNum = num3;
        }
        if (num2 > num1 && num1 < num3) {
            minNum = num1;
        } else if (num1 > num2 && num2 < num3) {
            minNum = num2;
        } else {
            minNum = num3;
        }
        if (num1 != maxNum && num1 != minNum) {
            midNum = num1;
        } else if (num2 != maxNum && num2 != minNum) {
            midNum = num2;
        } else {
            midNum = num3;
        }
        System.out.printf("%.0f%n", maxNum);
        System.out.printf("%.0f%n", midNum);
        System.out.printf("%.0f%n", minNum);
    }
}
