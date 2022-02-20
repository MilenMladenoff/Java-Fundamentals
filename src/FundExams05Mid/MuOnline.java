package FundExams05Mid;

import java.util.*;
import java.util.stream.Collectors;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> dungeon = Arrays.stream(scan.nextLine().split("\\|")).collect(Collectors.toList());
        int roomCounter = 0;
        int health = 100;
        int bitcoins = 0;

        for (int i = 0; i < dungeon.size(); i++) {
            List<String> room = Arrays.stream(dungeon.get(i).split(" ")).collect(Collectors.toList());
            roomCounter++;

            switch (room.get(0)) {
                case "potion":
                    int potion = Integer.parseInt(room.get(1));

                    if (potion >= 100 - health) {
                        System.out.printf("You healed for %d hp.%n", 100 - health);
                        health = 100;
                    } else {
                        System.out.printf("You healed for %d hp.%n", potion);
                        health += potion;
                    }

                    System.out.printf("Current health: %d hp.%n", health);
                    break;
                case "chest":
                    int currentCoins = Integer.parseInt(room.get(1));
                    System.out.printf("You found %d bitcoins.%n", currentCoins);
                    bitcoins += currentCoins;
                    break;
                default:
                    String monster = room.get(0);
                    int attack = Integer.parseInt(room.get(1));
                    health -= attack;

                    if (health > 0) {
                        System.out.printf("You slayed %s.%n", monster);
                    } else {
                        System.out.printf("You died! Killed by %s.%n", monster);
                        System.out.printf("Best room: %d%n", roomCounter);
                    }

                    break;
            }

            if (health <= 0) {
                break;
            }
        }

        if (health > 0) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", bitcoins);
            System.out.printf("Health: %d%n", health);
        }
    }
}
