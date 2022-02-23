package FundExams06Mid;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> pirateShip = Arrays.stream(scan.nextLine().split(">")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> warship = Arrays.stream(scan.nextLine().split(">")).map(Integer::parseInt).collect(Collectors.toList());
        int healthCapacity = Integer.parseInt(scan.nextLine());
        List<String> command = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
        String action = command.get(0);
        boolean isSunken = false;

        while (!action.equals("Retire")) {

            switch (action) {
                case "Fire":
                    int index = Integer.parseInt(command.get(1));
                    int damage = Integer.parseInt(command.get(2));

                    if (0 <= index && index < warship.size()) {
                        warship.set(index, warship.get(index) - damage);

                        if (warship.get(index) <= 0) {
                            System.out.println("You won! The enemy ship has sunken.");
                            isSunken = true;
                            break;
                        }
                    }

                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(command.get(1));
                    int endIndex = Integer.parseInt(command.get(2));
                    damage = Integer.parseInt(command.get(3));

                    if ((0 <= startIndex && startIndex < pirateShip.size()) && (0 <= endIndex && endIndex < pirateShip.size())) {

                        for (int i = startIndex; i <= endIndex; i++) {
                            pirateShip.set(i, pirateShip.get(i) - damage);

                            if (pirateShip.get(i) <= 0) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                isSunken = true;
                                break;
                            }
                        }
                    }

                    break;
                case "Repair":
                    index = Integer.parseInt(command.get(1));
                    int health = Integer.parseInt(command.get(2));

                    if (0 <= index && index < pirateShip.size()) {

                        if (health >= healthCapacity - pirateShip.get(index)) {
                            pirateShip.set(index, healthCapacity);
                        } else {
                            pirateShip.set(index, pirateShip.get(index) + health);
                        }
                    }

                    break;
                case "Status":
                    int needRepairCounter = 0;

                    for (int i = 0; i < pirateShip.size(); i++) {

                        if (pirateShip.get(i) < healthCapacity / 5) {
                            needRepairCounter++;
                        }
                    }

                    System.out.printf("%d sections need repair.%n", needRepairCounter);
                    break;
            }

            if (isSunken) {
                break;
            }

            command = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
            action = command.get(0);
        }

        if (!isSunken) {
            int pirateShipSum = 0;

            for (int i = 0; i < pirateShip.size(); i++) {
                pirateShipSum += pirateShip.get(i);
            }

            System.out.printf("Pirate ship status: %d%n", pirateShipSum);
            int warshipSum = 0;

            for (int i = 0; i < warship.size(); i++) {
                warshipSum += warship.get(i);
            }

            System.out.printf("Warship status: %d%n", warshipSum);
        }
    }
}
