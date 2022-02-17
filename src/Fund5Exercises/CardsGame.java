package Fund5Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> player1 = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> player2 = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        while (!player1.isEmpty() && !player2.isEmpty()) {

            if (player1.get(0) > player2.get(0)) {
                player1.add(player1.get(0));
                player1.add(player2.get(0));
            } else if (player1.get(0) < player2.get(0)) {
                player2.add(player2.get(0));
                player2.add(player1.get(0));
            }

            player1.remove(0);
            player2.remove(0);
        }

        int sum = 0;
        if (player1.isEmpty()) {

            for (int i : player2) {
                sum += i;
            }

            System.out.printf("Second player wins! Sum: %d%n", sum);
        } else {

            for (int i : player1) {
                sum += i;
            }

            System.out.printf("First player wins! Sum: %d%n", sum);
        }
    }
}
