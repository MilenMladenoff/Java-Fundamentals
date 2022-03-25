package Fund8Exercises;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] input = scan.nextLine().toCharArray();
        StringBuilder cipher = new StringBuilder();

        for (char symbol : input) {
            char c = (char) (symbol + 3);
            cipher.append(c);
        }

        System.out.println(cipher);

    }
}
