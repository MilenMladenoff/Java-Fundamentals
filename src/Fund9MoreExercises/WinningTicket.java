package Fund9MoreExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s*,\\s*");
        String regex = "[@]{6,}|[#]{6,}|[\\$]{6,}|[\\^]{6,}";
        Pattern pattern = Pattern.compile(regex);

        for (String ticket : input) {
            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
            } else {
                String firstHalf = ticket.substring(0, 10);
                String secondHalf = ticket.substring(10);
                Matcher matcherFirst = pattern.matcher(firstHalf);
                Matcher matcherSecond = pattern.matcher(secondHalf);
                String firstHalfWin = "";
                String secondHalfWin = "";

                if (matcherFirst.find()) {
                    firstHalfWin = matcherFirst.group();
                }

                if (matcherSecond.find()) {
                    secondHalfWin = matcherSecond.group();
                }

                int minLength = Math.min(firstHalfWin.length(), secondHalfWin.length());
                String firstRecord = firstHalfWin.substring(0, minLength);
                String secondRecord = secondHalfWin.substring(0, minLength);

                if (firstHalfWin.length() < 6 || secondHalfWin.length() < 6 || !firstRecord.equals(secondRecord)) {
                    System.out.printf("ticket \"%s\" - no match%n", ticket);
                } else if (firstRecord.length() == 10) {
                    System.out.printf("ticket \"%s\" - 10%s Jackpot!%n", ticket, firstRecord.charAt(0));
                } else {
                    System.out.printf("ticket \"%s\" - %d%s%n", ticket, minLength, firstRecord.charAt(0));
                }
            }
        }
    }
}
