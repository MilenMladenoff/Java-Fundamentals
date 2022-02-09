package Fund4Exercises;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        while (!input.equals("END")) {
            System.out.println(isPalindrome(input));
            input = scan.nextLine();
        }
    }

    private static boolean isPalindrome(String input) {
        boolean isPalindrome = true;

        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                isPalindrome = false;
            }
        }

        return isPalindrome;
    }
}
