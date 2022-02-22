package FundExams04Mid;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> groceries = Arrays.stream(scan.nextLine().split("!")).collect(Collectors.toList());
        List<String> command = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
        String action = command.get(0);

        while (!action.equals("Go")) {
            String item = command.get(1);

            switch (action) {
                case "Urgent":

                    if (!groceries.contains(item)) {
                        groceries.add(0, item);
                    }

                    break;
                case "Unnecessary":
                    groceries.remove(item);
                    break;
                case "Correct":
                    String newItem = command.get(2);

                    if (groceries.contains(item)) {
                        groceries.set(groceries.indexOf(item), newItem);
                    }

                    break;
                case "Rearrange":

                    if (groceries.contains(item)) {
                        groceries.remove(item);
                        groceries.add(item);
                    }

                    break;
            }

            command = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
            action = command.get(0);
        }

        System.out.println(groceries.toString().replaceAll("[\\[\\]]", ""));
    }
}
