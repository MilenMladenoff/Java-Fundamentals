package Fund7MoreExercises;

import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputContests = scan.nextLine().split(":");
        Map<String, String> contests = new HashMap<>();
        TreeMap<String, LinkedHashMap<String, Integer>> submits = new TreeMap<>();

        while (!inputContests[0].equals("end of contests")) {
            contests.put(inputContests[0], inputContests[1]);
            inputContests = scan.nextLine().split(":");
        }

        String[] submission = scan.nextLine().split("=>");

        while (!submission[0].equals("end of submissions")) {
            String contest = submission[0];
            String pass = submission[1];
            String user = submission[2];
            int points = Integer.parseInt(submission[3]);

            if (contests.containsKey(contest)) {

                if (contests.get(contest).equals(pass)) {
                    LinkedHashMap<String, Integer> userResults = new LinkedHashMap<>();
                    userResults.put(contest, points);

                    if (!submits.containsKey(user)) {
                        submits.put(user, userResults);
                    } else {

                        if (!submits.get(user).containsKey(contest)) {
                            submits.get(user).put(contest, points);
                        } else {
                            submits.get(user).put(contest, Math.max(points, submits.get(user).get(contest)));
                        }
                    }
                }
            }

            submission = scan.nextLine().split("=>");
        }

        int pointsSum = 0;

        for (Map.Entry<String, LinkedHashMap<String, Integer>> submit : submits.entrySet()) {
            int sum = submit.getValue().values().stream().mapToInt(i -> i).sum();

            if (sum > pointsSum) {
                pointsSum = sum;
            }
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> submit : submits.entrySet()) {

            if (submit.getValue().values().stream().mapToInt(i -> i).sum() == pointsSum) {
                System.out.printf("Best candidate is %s with total %d points.%n", submit.getKey(), pointsSum);
            }
        }

        System.out.println("Ranking:");
        submits.forEach((k, v) -> {
            System.out.printf("%s%n", k);
            v.entrySet().stream()
                    .sorted((a, b) -> b.getValue() - a.getValue())
                    .forEach(i -> System.out.printf("#  %s -> %d%n", i.getKey(), i.getValue()));
        });
    }
}
