package Fund7Exercises;

import java.util.*;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputLine = scan.nextLine().split("-");
        Map<String, Integer> users = new LinkedHashMap<>();
        Map<String, Integer> submissions = new LinkedHashMap<>();

        while (!inputLine[0].equals("exam finished")) {
            String name = inputLine[0];

            if (inputLine.length == 3) {
                String language = inputLine[1];
                int points = Integer.parseInt(inputLine[2]);

                if (!users.containsKey(name) || users.get(name) < points) {
                    users.put(name, points);
                }

                if (!submissions.containsKey(language)) {
                    submissions.put(language, 1);
                } else {
                    submissions.put(language, submissions.get(language) + 1);
                }

            } else {
                users.remove(name);
            }

            inputLine = scan.nextLine().split("-");
        }

        System.out.println("Results:");
        users.forEach((key, value) -> System.out.printf("%s | %d%n", key, value));
        System.out.println("Submissions:");
        submissions.forEach((key, value) -> System.out.printf("%s - %d%n", key, value));
    }
}
