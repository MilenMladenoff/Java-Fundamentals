package FinalExam05;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        BigInteger coolThreshold = new BigInteger(String.valueOf(1));
        Pattern digitsPattern = Pattern.compile("[\\d]");
        Matcher digitsMatcher = digitsPattern.matcher(input);

        while (digitsMatcher.find()) {
            int currentDigit = Integer.parseInt(digitsMatcher.group());
            coolThreshold = coolThreshold.multiply(BigInteger.valueOf(currentDigit));
        }

        Pattern emojisPattern = Pattern.compile("((:)\\2|(\\*)\\3)(?<emoji>[A-Z][a-z]{2,})\\1");
        Matcher emojisMatcher = emojisPattern.matcher(input);
        int emojisCounter = 0;
        List<String> coolEmojis = new ArrayList<>();

        while (emojisMatcher.find()) {
            String currentEmoji = emojisMatcher.group("emoji");
            emojisCounter++;
            int digitsSum = 0;

            for (int i = 0; i < currentEmoji.length(); i++) {
                int currentDigit = currentEmoji.charAt(i);
                digitsSum += currentDigit;
            }

            if (BigInteger.valueOf(digitsSum).compareTo(coolThreshold) > 0) {
                coolEmojis.add(emojisMatcher.group());
            }
        }

        System.out.printf("Cool threshold: %s%n", coolThreshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", emojisCounter);

        if (!coolEmojis.isEmpty()) {

            for (String coolEmoji : coolEmojis) {
                System.out.println(coolEmoji);
            }
        }
    }
}
