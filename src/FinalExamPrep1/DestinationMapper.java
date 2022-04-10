package FinalExamPrep1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Pattern pattern = Pattern.compile("([=/])(?<destination>[A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(input);
        List<String> destinations = new ArrayList<>();
        int pointsSum = 0;

        while (matcher.find()) {
            String destination = matcher.group("destination");
            destinations.add(destination);
            pointsSum += destination.length();
        }

        System.out.printf("Destinations: %s%n", String.join(", ", destinations));
        System.out.printf("Travel Points: %d", pointsSum);
    }
}
