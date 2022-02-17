package Fund5Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<String> commandLine = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
        String command = commandLine.get(0);

        while (!command.equals("end")) {

            switch (command) {
                case "Delete":
                    int element = Integer.parseInt(commandLine.get(1));

                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) == element) {
                            numbers.remove(i);
                            i--;
                        }
                    }

                    break;
                case "Insert":
                    element = Integer.parseInt(commandLine.get(1));
                    int index = Integer.parseInt(commandLine.get(2));
                    numbers.add(index, element);
            }

            commandLine = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
            command = commandLine.get(0);
        }

        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
