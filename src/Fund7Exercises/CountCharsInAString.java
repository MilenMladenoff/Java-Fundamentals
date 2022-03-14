package Fund7Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        Map<Character, Integer> charsCount = new LinkedHashMap<>();

        for (String text : input) {

            for (int i = 0; i < text.length(); i++) {
                char symbol = text.charAt(i);

                if (!charsCount.containsKey(symbol)) {
                    charsCount.put(symbol, 1);
                } else {
                    charsCount.put(symbol, charsCount.get(symbol) + 1);
                }
            }
        }

        charsCount.forEach((key, value) -> System.out.printf("%c -> %d%n", key, value));
    }
}
