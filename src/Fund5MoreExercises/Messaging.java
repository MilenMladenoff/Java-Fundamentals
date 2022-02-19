package Fund5MoreExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> numbers = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
        String stringLine = scan.nextLine();
        List<String> text = new ArrayList<>();

        for (int i = 0; i < stringLine.length(); i++) {
            text.add(Character.toString(stringLine.charAt(i)));
        }

        String result = "";

        for (int i = 0; i < numbers.size(); i++) {
            String numbersElement = numbers.get(i);
            int digitsSum = 0;

            for (int j = 0; j < numbersElement.length(); j++) {
                char symbol = numbersElement.charAt(j);
                int digit = Character.getNumericValue(symbol);
                digitsSum += digit;
            }

            int letterIndex = 0;

            if (digitsSum <= text.size()) {
                letterIndex = digitsSum;
            } else {
                letterIndex = (digitsSum - text.size() * (digitsSum / text.size()));
            }

            char resultLetter = (text.get(letterIndex).charAt(0));
            text.remove(letterIndex);
            result = result + resultLetter;
        }

        System.out.println(result);
    }
}
