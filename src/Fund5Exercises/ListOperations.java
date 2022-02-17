package Fund5Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<String> commandLine = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
        String command = commandLine.get(0);

        while (!command.equals("End")) {

            switch (command) {
                case "Add":
                    int num = Integer.parseInt(commandLine.get(1));
                    numbers.add(num);
                    break;
                case "Insert":
                    num = Integer.parseInt(commandLine.get(1));
                    int index = Integer.parseInt(commandLine.get(2));

                    if (index < 0 || numbers.size() <= index) {
                        System.out.println("Invalid index");
                    } else {
                        numbers.add(index, num);
                    }

                    break;
                case "Remove":
                    index = Integer.parseInt(commandLine.get(1));

                    if (index < 0 || numbers.size() <= index) {
                        System.out.println("Invalid index");
                    } else {
                        numbers.remove(index);
                    }

                    break;
                case "Shift":
                    String direction = commandLine.get(1);
                    int count = Integer.parseInt(commandLine.get(2));

                    if (direction.equals("left")) {

                        for (int i = 1; i <= count; i++) {
                            numbers.add(numbers.get(0));
                            numbers.remove(0);
                        }

                    } else {

                        for (int i = 1; i <= count; i++) {
                            numbers.add(0, numbers.get(numbers.size() - 1));
                            numbers.remove(numbers.size() - 1);
                        }
                    }
                    break;
            }

            commandLine = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
            command = commandLine.get(0);
        }

        for (int item : numbers) {
            System.out.print(item + " ");
        }
    }
}
