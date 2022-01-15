package Fund1Exercises;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int number = Integer.parseInt(input);
        int numberDigits = number;
        int factorialSum = 0;
        for (int i = 0; i < input.length(); i++){
            int digit = numberDigits % 10;
            numberDigits /= 10;
            int factorial = 1;
            for (int j = 1; j <= digit; j++){
                factorial *= j;
            }
            factorialSum += factorial;
        }
        if (number == factorialSum){
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
