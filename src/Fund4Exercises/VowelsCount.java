package Fund4Exercises;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        printVowelsQuantity(text);
    }

    private static void printVowelsQuantity(String text) {
        int vowelsCounter = 0;

        for (int i = 0; i < text.length(); i++) {
            char letter = text.toLowerCase().charAt(i);

            if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u' || letter == 'y') {
                vowelsCounter++;
            }
        }

        System.out.println(vowelsCounter);
    }
}
