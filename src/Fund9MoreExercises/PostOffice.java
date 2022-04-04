package Fund9MoreExercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\|");
        Pattern capitalsPattern = Pattern.compile("([#%$*&])(?<capitalLetters>[A-Z]+)\\1");
        Matcher capitalsMatcher = capitalsPattern.matcher(input[0]);

        if (capitalsMatcher.find()) {
            String capitalLetters = capitalsMatcher.group("capitalLetters");
            Pattern wordsLengthPattern = Pattern.compile("(?<capitalLetter>[\\d]{2}):(?<wordLength>[\\d]{2})");
            Matcher wordsLengthMatcher = wordsLengthPattern.matcher(input[1]);
            String[] words = input[2].split("\\s+");
            Map<Character, Integer> wordsLength = new HashMap<>();

            while (wordsLengthMatcher.find()) {
                char capitalLetter = (char) Integer.parseInt(wordsLengthMatcher.group("capitalLetter"));
                int wordLength = Integer.parseInt(wordsLengthMatcher.group("wordLength")) + 1;

                if (capitalLetters.indexOf(capitalLetter) != -1) {
                    wordsLength.putIfAbsent(capitalLetter, wordLength);
                }
            }

            for (int i = 0; i < words.length; i++) {
                String currentWord = words[i];

                if (wordsLength.containsKey(currentWord.charAt(0)) && wordsLength.get(currentWord.charAt(0)) == currentWord.length()) {
                    System.out.println(currentWord);
                }
            }
        }
    }
}
