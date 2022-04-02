package Fund9Exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String nameRegex = "[A-Za-z]+";
        String distanceRegex = "[\\d]";
        List<String> participants = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());
        Map<String, Integer> racers = new LinkedHashMap<>();

        for (String name : participants) {
            racers.putIfAbsent(name, 0);
        }
        Pattern namePattern = Pattern.compile(nameRegex);
        Pattern distancePattern = Pattern.compile(distanceRegex);
        String inputLine = scan.nextLine();

        while (!inputLine.equals("end of race")) {
            Matcher nameMatcher = namePattern.matcher(inputLine);
            StringBuilder letters = new StringBuilder();

            while (nameMatcher.find()) {
                letters.append(nameMatcher.group());
            }

            if (racers.containsKey(letters.toString())) {
                Matcher distanceMatcher = distancePattern.matcher(inputLine);

                while (distanceMatcher.find()) {
                    int digit = Integer.parseInt(distanceMatcher.group());
                    racers.put(letters.toString(), racers.get(letters.toString()) + digit);
                }
            }

            inputLine = scan.nextLine();
        }

        List<String> racersSorted = racers.entrySet().stream()
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue())).map(Map.Entry::getKey)
                .collect(Collectors.toList());
        String pos = "";
        for (int i = 0; i < racersSorted.size(); i++) {

            if (i == 3) {
                break;
            }

            pos = i == 0 ? "1st" : i == 1 ? "2nd" : i == 2 ? "3rd" : "";
            System.out.printf("%s place: %s%n", pos, racersSorted.get(i));
        }
    }
}
