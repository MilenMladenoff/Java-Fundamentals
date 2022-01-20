package Fund2Lab;

import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        boolean isSpecial = false;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int number = i;
            while (number > 0) {
                sum += number % 10;
                number = number / 10;
            }
            isSpecial = (sum == 5) || (sum == 7) || (sum == 11);
            String trueOrFalse = "";
            if (isSpecial) {
                trueOrFalse = "True";
            } else {
                trueOrFalse = "False";
            }
            System.out.printf("%d -> %s%n", i, trueOrFalse);
            sum = 0;
        }
    }
}
