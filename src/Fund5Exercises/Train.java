package Fund5Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> wagons = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int wagonCapacity = Integer.parseInt(scan.nextLine());
        List<String> commandLine = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
        String commandLineInput1 = commandLine.get(0);

        while (!commandLineInput1.equals("end")) {

            if (commandLineInput1.equals("Add")) {
                int passengers = Integer.parseInt(commandLine.get(1));
                wagons.add(passengers);
            } else {
                int passengers = Integer.parseInt(commandLineInput1);

                for (int i = 0; i < wagons.size(); i++) {

                    if (wagonCapacity - wagons.get(i) >= passengers) {
                        wagons.set(i, wagons.get(i) + passengers);
                        break;
                    }

                }

            }

            commandLine = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
            commandLineInput1 = commandLine.get(0);
        }

        System.out.println(wagons.toString().replaceAll("[\\[\\],]", ""));
    }
}
