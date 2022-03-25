package Fund8Exercises;

import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder result = new StringBuilder(scan.nextLine());

        for (int i = 0; i < result.length() - 1; i++) {
            char currentDigit = result.charAt(i);
            char nextDigit = result.charAt(i + 1);

            if (currentDigit == nextDigit) {
                result.deleteCharAt(i);
                i--;
            }
        }

        System.out.println(result);
    }
}
