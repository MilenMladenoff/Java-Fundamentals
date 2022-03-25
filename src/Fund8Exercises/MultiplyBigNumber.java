package Fund8Exercises;

import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String num = scan.nextLine();
        int multiplier = Integer.parseInt(scan.nextLine());
        StringBuilder result = new StringBuilder();
        int reminder = 0;

        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = Integer.parseInt(String.valueOf(num.charAt(i)));
            int product = digit * multiplier + reminder;

            if (i == 0) {
                result.insert(0, product);
            } else {
                int digitToAdd = product % 10;
                reminder = product / 10;
                result.insert(0, digitToAdd);
            }
        }

        while (result.charAt(0) == '0' && result.length() > 1) {
            result.deleteCharAt(0);
        }

        System.out.println(result);
    }
}
