package FinalExam03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Pattern pattern = Pattern.compile("([@#])(?<wordOne>[A-Za-z]{3,})\\1\\1(?<wordTwo>[A-Za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(input);
        int pairsCounter = 0;
        List<String> pairs = new ArrayList<>();

        while (matcher.find()) {
            pairsCounter++;
            String wordOne = matcher.group("wordOne");
            String wordTwo = matcher.group("wordTwo");
            StringBuilder wordToReverse = new StringBuilder(wordTwo);

            if (wordOne.equals(wordToReverse.reverse().toString())) {
                String currentPair = wordOne + " <=> " + wordTwo;
                pairs.add(currentPair);
            }
        }

        if (pairsCounter == 0) {
            System.out.println("No word pairs found!");
            System.out.println("No mirror words!");
        } else {
            System.out.printf("%d word pairs found!%n", pairsCounter);

            if (pairs.isEmpty()) {
                System.out.println("No mirror words!");
            } else {
                System.out.println("The mirror words are:");
                System.out.println(String.join(", ", pairs));
            }
        }
    }
}
