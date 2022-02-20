package FundExams05Mid;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> inventory = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());
        List<String> commandLine = Arrays.stream(scan.nextLine().split(" - |:")).collect(Collectors.toList());
        String command = commandLine.get(0);

        while (!command.equals("Craft!")) {
            String item = commandLine.get(1);

            switch (command) {
                case "Collect":

                    if (!inventory.contains(item)) {
                        inventory.add(item);
                    }

                    break;
                case "Drop":
                    inventory.remove(item);
                    break;
                case "Combine Items":

                    if (inventory.contains(item)) {
                        String newItem = commandLine.get(2);
                        inventory.add(inventory.indexOf(item) + 1, newItem);
                    }

                    break;
                case "Renew":

                    if (inventory.contains(item)) {
                        inventory.remove(item);
                        inventory.add(item);
                    }

                    break;
            }

            commandLine = Arrays.stream(scan.nextLine().split(" - |:")).collect(Collectors.toList());
            command = commandLine.get(0);
        }

        System.out.println(inventory.toString().replaceAll("[\\[\\]]", ""));
    }
}
