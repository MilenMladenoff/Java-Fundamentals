package Fund1MoreExercises;

import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int messageLength = Integer.parseInt(scan.nextLine());
        for (int i = 1; i <= messageLength; i++) {
            String currentPush = scan.nextLine();
            int pushLength = currentPush.length();
            char mainDigit = currentPush.charAt(0);
            int digit = Character.getNumericValue(mainDigit);
            int offset = (digit - 2) * 3;
            if (digit == 8 || digit == 9) {
                offset = offset + 1;
            }
            int letterIndex = offset + pushLength - 1;
            int asciiValue = letterIndex + 97;
            char letter = (char) asciiValue;
            if (digit == 0) {
                letter = (char) (digit + 32);
            }
            System.out.print(letter);
        }
    }
}
