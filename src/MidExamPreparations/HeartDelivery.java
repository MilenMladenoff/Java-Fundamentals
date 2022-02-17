package MidExamPreparations;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> neighborhood = Arrays.stream(scan.nextLine().split("@")).map(Integer::parseInt).collect(Collectors.toList());
        List<String> commandLine = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
        String command = commandLine.get(0);
        int cupidPosition = 0;

        while (!command.equals("Love!")) {
            int jumpLength = Integer.parseInt(commandLine.get(1));
            cupidPosition = cupidPosition + jumpLength;

            if (cupidPosition >= neighborhood.size()) {
                cupidPosition = 0;
            }

            if (neighborhood.get(cupidPosition) > 0) {
                neighborhood.set(cupidPosition, neighborhood.get(cupidPosition) - 2);

                if (neighborhood.get(cupidPosition) == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", cupidPosition);
                }

            } else if (neighborhood.get(cupidPosition) == 0) {
                System.out.printf("Place %d already had Valentine's day.%n", cupidPosition);
            }

            commandLine = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
            command = commandLine.get(0);
        }

        System.out.printf("Cupid's last position was %d.%n", cupidPosition);
        int valentinesDayHousesCounter = neighborhood.size();

        for (int i = 0; i < neighborhood.size(); i++) {

            if (neighborhood.get(i) == 0) {
                valentinesDayHousesCounter--;
            }
        }

        if (valentinesDayHousesCounter == 0) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.", valentinesDayHousesCounter);
        }

    }
}
