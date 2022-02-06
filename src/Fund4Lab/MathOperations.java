package Fund4Lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double firstNum = Double.parseDouble(scan.nextLine());
        char operator = scan.nextLine().charAt(0);
        double secondNum = Double.parseDouble(scan.nextLine());
        System.out.println(new DecimalFormat("0.##").format(calculate(firstNum, operator, secondNum)));
    }

    private static double calculate(double firstNum, char operator, double secondNum) {
        double result = 0;

        switch (operator) {
            case '/':
                result = firstNum / secondNum;
                break;
            case '*':
                result = firstNum * secondNum;
                break;
            case '+':
                result = firstNum + secondNum;
                break;
            case '-':
                result = firstNum - secondNum;
                break;
        }

        return result;
    }
}
