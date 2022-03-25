package Fund8Exercises;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        double sum = 0;

        for (String s : input) {
            char letterBefore = s.charAt(0);
            char letterAfter = s.charAt(s.length() - 1);
            String digits = s.substring(1, s.length() - 1);
            double num = Integer.parseInt(digits);

            if (Character.isUpperCase(letterBefore)) {
                sum += num / getAlphabeticPos(letterBefore);
            } else {
                sum += num * getAlphabeticPos(letterBefore);
            }

            if (Character.isUpperCase(letterAfter)) {
                sum -= getAlphabeticPos(letterAfter);
            } else {
                sum += getAlphabeticPos(letterAfter);
            }
        }

        System.out.printf("%.2f", sum);
    }

    static int getAlphabeticPos(char c) {
        return Character.toLowerCase(c) - 96;
    }
}
