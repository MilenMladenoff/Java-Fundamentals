package Fund8MoreExercises;

import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char firstChar = scan.nextLine().charAt(0);
        char lastChar = scan.nextLine().charAt(0);
        String text = scan.nextLine();
        int symbolsSum = 0;

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);

            if (firstChar < symbol && symbol < lastChar) {
                symbolsSum += symbol;
            }
        }

        System.out.println(symbolsSum);
    }
}
