package Fund9MoreExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String regex = "(?<string>[\\D]+)(?<number>\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        StringBuilder rageMessage = new StringBuilder();

        while (matcher.find()) {
            int repetitions = Integer.parseInt(matcher.group("number"));
            String stringGroup = matcher.group("string").toUpperCase();

            for (int i = 1; i <= repetitions; i++) {
                rageMessage.append(stringGroup);
            }
        }

        System.out.printf("Unique symbols used: %d%n", rageMessage.chars().distinct().count());
        System.out.println(rageMessage);
    }
}
