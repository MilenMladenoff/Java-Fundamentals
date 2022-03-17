package Fund7MoreExercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MOBAChallenger {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputLine = scan.nextLine().split("\\s+");
        Map<String, TreeMap<String, Integer>> players = new TreeMap<>();

        while (!inputLine[0].equals("Season")) {

            if (inputLine[1].equals("->")) {
                String player = inputLine[0];
                String pos = inputLine[2];
                int skill = Integer.parseInt(inputLine[4]);
                players.putIfAbsent(player, new TreeMap<String, Integer>());
                players.get(player).putIfAbsent(pos, 0);

                if (players.get(player).get(pos) < skill) {
                    players.get(player).put(pos, skill);
                }

            } else {
                String player1 = inputLine[0];
                String player2 = inputLine[2];

                if (players.containsKey(player1) && players.containsKey(player2)) {
                    boolean hasCommon = false;
                    for (String pos1 : players.get(player1).keySet()) {
                        for (String pos2 : players.get(player2).keySet()) {

                            if (pos1.equals(pos2)) {
                                hasCommon = true;
                                break;
                            }
                        }
                    }

                    if (hasCommon) {

                        if (players.get(player1).values().stream().mapToInt(i -> i).sum() >
                                players.get(player2).values().stream().mapToInt(i -> i).sum()) {
                            players.remove(player2);
                        } else if (players.get(player1).values().stream().mapToInt(i -> i).sum() <
                                players.get(player2).values().stream().mapToInt(i -> i).sum()) {
                            players.remove(player1);
                        }
                    }
                }
            }

            inputLine = scan.nextLine().split("\\s+");
        }

        players.entrySet().stream().sorted((p1, p2) -> {
            int result = Integer.compare(p2.getValue().values().stream().mapToInt(i -> i).sum(),
                    p1.getValue().values().stream().mapToInt(i -> i).sum());

            if (result == 0) {
                result = p1.getKey().compareTo(p2.getKey());
            }

            return result;
        }).forEach(entry -> {
            System.out.printf("%s: %d skill%n", entry.getKey(), entry.getValue().values().stream().mapToInt(i -> i).sum());
            entry.getValue().entrySet().stream().sorted((e1, e2) -> {
                int res = Integer.compare(e2.getValue(), e1.getValue());

                if (res == 0) {
                    res = e1.getKey().compareTo(e2.getKey());
                }

                return res;
            }).forEach(e -> {
                System.out.printf("- %s <::> %d%n", e.getKey(), e.getValue());
            });
        });
    }
}
