package FundExams03Mid;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> targets = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<String> commandLine = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
        String command = commandLine.get(0);

        while (!command.equals("End")) {
            int index = Integer.parseInt(commandLine.get(1));

            switch (command) {
                case "Shoot":
                    int power = Integer.parseInt(commandLine.get(2));

                    if (0 <= index && index < targets.size()) {

                        if (power < targets.get(index)) {
                            targets.set(index, targets.get(index) - power);
                        } else {
                            targets.remove(index);
                        }
                    }

                    break;
                case "Add":
                    int value = Integer.parseInt(commandLine.get(2));

                    if (0 <= index && index < targets.size()) {
                        targets.add(index, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }

                    break;
                case "Strike":
                    int radius = Integer.parseInt(commandLine.get(2));

                    if (0 <= index - radius && index + radius < targets.size()) {

                        for (int i = 1; i <= radius * 2 + 1; i++) {
                            targets.remove(index - radius);
                        }
                    } else {
                        System.out.println("Strike missed!");
                    }

                    break;
            }

            commandLine = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
            command = commandLine.get(0);
        }

        for (int i = 0; i < targets.size(); i++) {

            if (i == targets.size() - 1) {
                System.out.print(targets.get(i));
            } else {
                System.out.printf("%d|", targets.get(i));
            }
        }


    }
}
