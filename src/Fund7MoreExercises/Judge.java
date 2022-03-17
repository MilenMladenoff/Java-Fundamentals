package Fund7MoreExercises;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Judge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputLine = scan.nextLine().split(" -> ");
        Map<String, Integer> users = new TreeMap<>();
        Map<String, TreeMap<String, Integer>> contests = new LinkedHashMap<>();

        while (!inputLine[0].equals("no more time")) {
            String user = inputLine[0];
            String contest = inputLine[1];
            int points = Integer.parseInt(inputLine[2]);
            contests.putIfAbsent(contest, new TreeMap<>());
            contests.get(contest).putIfAbsent(user, 0);

            if (contests.get(contest).get(user) < points) {
                contests.get(contest).put(user, points);
            }

            inputLine = scan.nextLine().split(" -> ");
        }

        for (Map.Entry<String, TreeMap<String, Integer>> contest : contests.entrySet()) {
            AtomicInteger index = new AtomicInteger(1);
            System.out.printf("%s: %d participants%n", contest.getKey(), contest.getValue().size());
            contest.getValue().entrySet().stream()
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue())).forEach(k -> {
                        users.putIfAbsent(k.getKey(), 0);
                        users.put(k.getKey(), users.get(k.getKey()) + k.getValue());
                        System.out.printf("%d. %s <::> %d%n", index.getAndIncrement(), k.getKey(), k.getValue());
                    });
        }

        System.out.println("Individual standings:");
        AtomicInteger index = new AtomicInteger(1);
        users.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(k -> System.out.printf("%d. %s -> %d%n", index.getAndIncrement(), k.getKey(), k.getValue()));


    }
}
