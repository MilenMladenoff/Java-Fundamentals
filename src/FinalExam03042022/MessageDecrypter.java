package FinalExam03042022;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageDecrypter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String regex = "^([$%])(?<tag>[A-Z][a-z]{3,})\\1: (?<chars>(\\[\\d+\\]\\|){3})$";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 1; i <= n; i++) {
            String inputMessage = scan.nextLine();
            Matcher matcher = pattern.matcher(inputMessage);

            if (matcher.find()) {
                String tag = matcher.group("tag");
                Pattern charsPattern = Pattern.compile("\\d+");
                Matcher charsMatcher = charsPattern.matcher(matcher.group("chars"));
                StringBuilder decryptedMessage = new StringBuilder();

                while (charsMatcher.find()) {
                    int number = Integer.parseInt(charsMatcher.group());
                    decryptedMessage.append((char) number);
                }

                System.out.printf("%s: %s%n", tag, decryptedMessage);
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}
