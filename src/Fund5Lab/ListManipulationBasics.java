package Fund5Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<String> commandLine = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
        String command = commandLine.get(0);

        while (!command.equals("end")) {

            switch (command) {
                case "Add":
                    int num = Integer.parseInt(commandLine.get(1));
                    numbers.add(num);
                    break;
                case "Remove":
                    numbers.remove(Integer.valueOf(commandLine.get(1)));
                    break;
                case "RemoveAt":
                    num = Integer.parseInt(commandLine.get(1));
                    numbers.remove(num);
                    break;
                case "Insert":
                    num = Integer.parseInt(commandLine.get(1));
                    int index = Integer.parseInt(commandLine.get(2));
                    numbers.add(index, num);
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
