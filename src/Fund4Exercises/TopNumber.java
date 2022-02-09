package Fund4Exercises;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= n; i++) {
            String num = String.valueOf(i);
            int sumOfDigits = 0;
            boolean hasOddDigit = false;

            for (int j = 0; j < num.length(); j++) {
                char symbol = num.charAt(j);
                int digit = Integer.parseInt(String.valueOf(symbol));
                sumOfDigits += digit;
                if (digit % 2 != 0) {
                    hasOddDigit = true;
                }
            }

            if (sumOfDigits % 8 == 0 && hasOddDigit) {
                System.out.println(i);
            }
        }
    }
}
