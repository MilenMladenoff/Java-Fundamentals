package Fund5MoreExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        double racer1Time = 0;
        double racer2Time = 0;

        for (int i = 0; i < numbers.size() / 2; i++) {
            double currentTime = numbers.get(i);

            if (currentTime != 0) {
                racer1Time += currentTime;
            } else {
                racer1Time *= 0.8;
            }
        }

        for (int i = numbers.size() - 1; i > numbers.size() / 2; i--) {
            double currentTime = numbers.get(i);

            if (currentTime != 0) {
                racer2Time += currentTime;
            } else {
                racer2Time *= 0.8;
            }
        }

        if (racer1Time < racer2Time) {
            System.out.printf("The winner is left with total time: %.1f", racer1Time);
        } else {
            System.out.printf("The winner is right with total time: %.1f", racer2Time);
        }
    }
}
