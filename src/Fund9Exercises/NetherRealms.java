package Fund9Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Pattern pattern = Pattern.compile("[^,\\s+]+");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String demonName = matcher.group();
            int demonHealth = getDemonHealth(demonName);
            double demonDamage = getDemonDamage(demonName);
            System.out.printf("%s - %d health, %.2f damage%n", demonName, demonHealth, demonDamage);
        }

    }

    private static double getDemonDamage(String demonName) {
        Pattern damagePattern = Pattern.compile("[-|+]?(\\d+\\.?\\d+|\\d+)");
        Matcher damageMatcher = damagePattern.matcher(demonName);
        double damage = 0;

        while (damageMatcher.find()) {
            damage += Double.parseDouble(damageMatcher.group());
        }

        Pattern pattern = Pattern.compile("[*/]");
        damageMatcher = pattern.matcher(demonName);

        while (damageMatcher.find()) {
            String symbol = damageMatcher.group();

            if (symbol.equals("*")) {
                damage *= 2;
            } else if (symbol.equals("/")) {
                damage /= 2;
            }
        }

        return damage;
    }

    private static int getDemonHealth(String demonName) {
        Pattern healthPattern = Pattern.compile("[^-+0-9*/.]");
        Matcher healthMatcher = healthPattern.matcher(demonName);
        int charsSum = 0;

        while (healthMatcher.find()) {
            int symbol = healthMatcher.group().charAt(0);
            charsSum += symbol;
        }

        return charsSum;
    }
}
