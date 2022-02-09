package Fund4Exercises;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long num1 = Long.parseLong(scan.nextLine());
        long num2 = Long.parseLong(scan.nextLine());
        double factorialNum1 = findFactorial(num1);
        double factorialNum2 = findFactorial(num2);
        System.out.printf("%.2f", factorialNum1 / factorialNum2);
    }

    private static double findFactorial(double n) {
        long factorial = 1;
        for (int i = 1; i <= n; i++){
            factorial *= i;
        }
        return factorial;
    }
}
