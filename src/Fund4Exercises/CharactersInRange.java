package Fund4Exercises;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char start = scan.nextLine().charAt(0);
        char end = scan.nextLine().charAt(0);
        printCharacterBetween(start, end);
    }

    private static void printCharacterBetween(char start, char end) {

        if (start < end) {
            for (int i = start + 1; i < end; i++) {
                System.out.printf("%c ", i);
            }
        } else {
            for (int i = end + 1; i < start; i++) {
                System.out.printf("%c ", i);
            }
        }
    }
}
