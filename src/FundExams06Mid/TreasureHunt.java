package FundExams06Mid;

import java.util.*;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> treasure = Arrays.stream(scan.nextLine().split("\\|")).collect(Collectors.toList());
        List<String> command = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
        String action = command.get(0);

        while (!action.equals("Yohoho!")) {

            switch (action) {
                case "Loot":

                    for (int i = 1; i < command.size(); i++) {
                        String item = command.get(i);

                        if (!treasure.contains(item)) {
                            treasure.add(0, item);
                        }
                    }

                    break;
                case "Drop":
                    int index = Integer.parseInt(command.get(1));

                    if (index >= 0 && treasure.size() > index) {
                        treasure.add(treasure.get(index));
                        treasure.remove(index);
                    }

                    break;
                case "Steal":
                    int count = Integer.parseInt(command.get(1));
                    List<String> stolen = new ArrayList<>();

                    for (int i = count; i > 0; i--) {

                        if (treasure.isEmpty()) {
                            break;
                        }

                        stolen.add(treasure.get(treasure.size() - 1));
                        treasure.remove(treasure.size() - 1);
                    }

                    Collections.reverse(stolen);
                    System.out.println(stolen.toString().replaceAll("[\\[\\]]", ""));
                    break;
            }

            command = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
            action = command.get(0);
        }

        double averageGain = 0;

        for (int i = 0; i < treasure.size(); i++) {
            averageGain += (treasure.get(i)).length();
        }

        averageGain /= treasure.size();

        if (treasure.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageGain);
        }
    }
}
