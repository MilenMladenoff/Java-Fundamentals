package Fund5Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<String> commandLine = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
        String command = commandLine.get(0);

        while (!command.equals("end")) {

            switch (command) {
                case "Contains":
                    int num = Integer.parseInt(commandLine.get(1));
                    boolean containsNum = false;

                    for (int number : numbers) {
                        if (number == num) {
                            containsNum = true;
                            break;
                        }
                    }

                    if (containsNum) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }

                    break;
                case "Print":
                    String evenOrOdd = commandLine.get(1);

                    if (evenOrOdd.equals("even")) {
                        for (int number : numbers) {
                            if (number % 2 == 0) {
                                System.out.print(number + " ");
                            }
                        }
                    } else {
                        for (int number : numbers) {
                            if (number % 2 != 0) {
                                System.out.print(number + " ");
                            }
                        }
                    }
                    System.out.println();

                    break;
                case "Get":
                    int sum = 0;

                    for (int number : numbers) {
                        sum += number;
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    String condition = commandLine.get(1);
                    num = Integer.parseInt(commandLine.get(2));

                    switch (condition) {
                        case "<":

                            for (int number : numbers) {

                                if (number < num) {
                                    System.out.print(number + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case ">":

                            for (int number : numbers) {

                                if (number > num) {
                                    System.out.print(number + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case ">=":

                            for (int number : numbers) {

                                if (number >= num) {
                                    System.out.print(number + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case "<=":

                            for (int number : numbers) {

                                if (number <= num) {
                                    System.out.print(number + " ");
                                }
                            }
                            System.out.println();
                            break;
                    }

            }

            commandLine = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
            command = commandLine.get(0);
        }
    }
}
